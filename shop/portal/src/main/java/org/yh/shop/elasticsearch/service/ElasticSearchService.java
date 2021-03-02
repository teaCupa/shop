package org.yh.shop.elasticsearch.service;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yh.shop.model.Product;
import org.yh.shop.service.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yh
 * @Date: 2021/3/1
 * @Description:
 */

@Service
public class ElasticSearchService {
    @Autowired
    ProductService productService;
    @Autowired
    RestHighLevelClient client;

    private static final Logger log = LoggerFactory.getLogger(ElasticSearchService.class);


    public void save() {
        List<Product>products= productService.getAllProduct();
        //批量插入
        BulkRequest bulkRequest = new BulkRequest("product");
        bulkRequest.timeout("5s");

        for(int i=0;i<products.size();i++){
            bulkRequest.add(new IndexRequest("product").id(""+i)
                    .source(JSON.toJSONString(products.get(i)), XContentType.JSON));
        }
        try {
            BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println("插入成功? "+!bulkResponse.hasFailures());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String,Object>> find(String keywords, Integer pageNum, Integer pageSize) {
        if(pageNum ==null){
            pageNum=0;
        }
        if(pageSize==null){
            pageSize=12;
        }
        SearchRequest request = new SearchRequest("product");
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        //分页
        sourceBuilder.from(pageNum).size(pageSize);
        //模糊匹配
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name",keywords);
        sourceBuilder.query(matchQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.field("name",30);
        highlightBuilder.requireFieldMatch(false);  //允许多个字段高亮
        highlightBuilder.postTags("</span>");
        sourceBuilder.highlighter(highlightBuilder);

        //执行搜索
        request.source(sourceBuilder);
        try {
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            log.info("hits:{}",response.getHits().getHits());
            ArrayList<Map<String,Object>> list = new ArrayList<>();
            for (SearchHit hits : response.getHits().getHits()) {
                Map<String, HighlightField> highlightFields = hits.getHighlightFields();
                log.info("map: {}",highlightFields);
                Map<String, Object> sourceAsMap = hits.getSourceAsMap();
                HighlightField field = highlightFields.get("name");
                if(field !=null){
                    Text[] texts = field.fragments();
                    String temp="";
                    for (Text text : texts) {
                        temp +=text;
                    }
                    //替换为高亮文本
                    sourceAsMap.put("name",temp);
                }
                list.add(sourceAsMap);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
