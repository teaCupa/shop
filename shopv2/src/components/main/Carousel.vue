<template>
      <div id="box">
        <ul class="list">
          <transition-group name="fade" tag="div">
          <li v-for="(v,i) in banners" :key="v" v-show="(i+1)===index">
              <router-link :to="'/product/'+v.id">
                  <img :src="v">
              </router-link>
          </li>
          </transition-group>
        </ul>
        <ul class="count">
          <li v-for="num in 4" :key="num" @mouseover='change(num)' :class='{current:num===index}'>
            {{num}}
          </li>
        </ul>
      </div>
</template>

<script>
export default {
  name: 'banner',
  data : function(){
    return {
      banners : [//广告图片数组
          require('@/assets/images/ad1.png'),
          require('@/assets/images/ad2.png'),
          require('@/assets/images/ad3.png'),
          require('@/assets/images/ad4.png')
      ],
      index : 1,// 图片的索引
      flag : true,
      timer : '',// 定时器ID
    }
  },
  methods : {
    next : function(){
      // 下一张图片，图片索引为4时返回第一张
      this.index = this.index % 4 + 1
    },
    change : function(num){
      // 鼠标移入按钮切换到对应图片
      if(this.flag){
        this.flag = false;
        // 过1秒钟后可以再次移入按钮切换图片
        setTimeout(()=>{
          this.flag = true;
        },1000);
        this.index = num;// 切换为选中的图片
        clearInterval(this.timer);// 取消定时器
        // 过3秒钟图片轮换
        this.timer = setInterval(this.next,3000);
      }
    }
  },
  mounted : function(){
    // 过3秒钟图片轮换
    this.timer = setInterval(this.next,3000);
  }

}
</script>
<style lang="scss" scoped>
  #box {
    position: relative;
    width: 80%;
    margin-left: 10%;
    margin-top: -10px;
    height: 455px;
    background: #ffffff;
    border-radius: 5px;
  }

  #box .list {
    position: relative;
    left: -9%;
  }
  @media only screen and (min-width: 1450px){
    #box .list li {
      width: 50%;
      height: 50%;
      margin-left: 17%;
      margin-top: 0px;
      position: absolute;
      top: 0; left: 0; bottom: 0; right: 0;
    }
    #box .count {
      position: absolute;
      left: 520px;
      bottom: 25px;
    }

  }

  @media  screen and (min-width: 800px) and (max-width: 1450px){
    #box .list li {
      width: 50%;
      height: 50%;
      margin: auto;
      position: absolute;
      top: 0; left: -100px; bottom: 0; right: 0;
    }
    #box .list li img{
      width: 120%;
    }
    #box .count {
      position: absolute;
      left: 700px;
      bottom: 5px;
    }
  }

  @media  screen and (max-width: 400px){
    #box{
      display: none;
    }

  }

  #box .list li.current {
    opacity: 1;
  }

  #box .count li {
    color: #fff;
    float: left;
    width: 20px;
    height: 20px;
    line-height: 20px;
    text-align: center;
    cursor: pointer;
    margin-right: 5px;
    overflow: hidden;
    background: #6D6B6A;
    opacity: 0.7;
    border-radius: 20px;
  }

  #box .count li.current {
    color: #fff;
    opacity: 0.7;
    font-weight: 700;
    background: #f60;
    transition:all .6s ease;
  }
  /* 设置过渡属性 */
  .fade-enter-active, .fade-leave-active{
    transition: all 1s;
  }
  .fade-enter, .fade-leave-to{
    opacity: 0;
  }
  li{
      list-style: none;
  }
</style>
