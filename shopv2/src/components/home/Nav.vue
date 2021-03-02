<template xmlns:https="http://www.w3.org/1999/xhtml">
    <div style="display: flex;justify-content: space-between;align-items: center; height: 75px;">
        <ul style="color: grey!important;display: flex;justify-content: flex-start">
            <li v-for="cateData in cateList">
                <el-popover
                        trigger="hover" :close-delay=600 width="1484"
                        @show="isShow=true" @after-leave="isShow=false">
                    <a slot="reference" style="margin-right: 30px">{{cateData.name}}</a>
                    <drop-menu :data="cateData.c2Childrens" :isShow="isShow" :type=1></drop-menu>
                </el-popover>
            </li>
        </ul>
        <div style="position:absolute;right: 35px;display: flex;align-items: center;">
            <div style="border-radius: 20px;height:36px;display: flex;border: 1px solid rgba(0,0,0,.08);">
                <button class="search-btn"></button>
                <input class="search-text" id="searchInput" name="" @click="tick" maxlength="30"/>
                <div style="display: flex;margin-right: 12px;align-items: center" >
                    <a href="https://www.smartisan.com/item/100162801" class="recommand">手机</a>
                </div>
            </div>
        </div>
        <div class="search-content-box" v-show="searchContentShow">
            <div v-for="item in cateList">
                <router-link :to="'/search/'+item.id">
                    <p class="text-title" @mouseover="setInputVal(item.name)">{{item.name}}</p>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script>
    import DropMenu from "../common/DropMenu";

    export default {
        name: "Nav",
        components: {DropMenu},
        data: function () {
            return {
                searchContentShow: false,
                isShow: false,
                cateList: []
            }
        },
        methods: {
            tick() {
                this.searchContentShow = true
                // document.querySelector('.search-content-box').addEventListener('click',function (e) {
                //     e.stopPropagation();  //阻止事件冒泡,从dom内部传到外部
                // },false)

                //监听整个document的点击事件，如果能收到事件(说明点击源既不是“显示菜单”按钮，也不来自菜单内部)，就可以放心关闭菜单了
                var that = this, time = 0
                document.querySelector('.search-content-box').addEventListener('click', function (e) {
                    time++;
                    if (time >= 1) {
                        that.searchContentShow = false
                        document.getElementById('searchInput').value=''
                        time = 0
                    }
                }, false);
            },
            setInputVal(val) {
                document.getElementById('searchInput').value=val
            },
            //事件监听方法
            keyDown(e){
                let val=document.getElementById('searchInput').value
                //如果是回车则执行登录方法
                if(e.keyCode === 13 && val!==''){
                    this.doSearch(val);
                }
            },
            doSearch(val){
                //跳转到搜索页面
                this.$router.push('/elasticsearch?keywords='+val)
            },
            getCategoryList() {
                this.getRequest('/category/unit').then(res => {
                    if (res) {
                        this.cateList = res.data
                    }
                })
            }
        },
        mounted() {
            this.getCategoryList();
            //添加搜索回车登录事件监听器
            document.addEventListener('keydown',this.keyDown);
        }
    }
</script>

<style scoped>

    li {
        list-style: none;
        display: flex;
        justify-content: space-between;
        margin-bottom: 10px;
    }

    a {
        cursor: pointer;
        text-decoration: none;
        font-weight: 700;
        background-color: transparent;
    }

    .search-btn {
        margin: auto 10px;
        width: 21px;
        height: 21px;
        cursor: pointer;
        background-color: transparent;
        border: none;
        background-image: -webkit-image-set(url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAABS2lUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4KPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMxNDAgNzkuMTYwNDUxLCAyMDE3LzA1LzA2LTAxOjA4OjIxICAgICAgICAiPgogPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4KICA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIi8+CiA8L3JkZjpSREY+CjwveDp4bXBtZXRhPgo8P3hwYWNrZXQgZW5kPSJyIj8+LUNEtwAAAY9JREFUOI2t1F9rU0EQBfCfTUwrVhtrMKGKVBRfFRVf9Tv7ERSfFPVBEBRF/NdWtLGkmlaT+DBz6e1N0l7QA5dd7s6ePTM7Z/nPODHnfw+X0EYLY+xiE+/wuy5hE3ewjkVMSjGT/LbxDJ+OI2ziHtZS0fdUtIsFdFL5Ev7gMd5XCZul+S1cxD5e4yWGlfheZtDGXfxAvxzQyLGD2zl/gyepoooBNvLg5RT0oRywkOO6qFkfT2cQlbGDV6IsXZyZRdgWBf+cgcfho6jtKZyfRbgoLmhQgwx+ifqezL1ThIWqhnpo5N6JSkYFYaHskPwjcE5cylAlq4JwM09aw4UahNdFqjvYqkqXC0UrdDKo2oMFbuKq6NfnwjlThOOUflk4YS3X9jDKeQ83cE14eSza59DBVS9fEU5YKh2yn3HLmeZQNH0LP/FQyS3VW+2LerbyO42zot9Gmd4L4aauA39vFErnPV+wglUHz9dA1HaU623cz3Ebj/DtKMI6WEnSLr7gQd1Gnoc9UaJVvMXXf+Sbxl+J62A8Lj9GswAAAABJRU5ErkJggg==) 1x, url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAYAAACM/rhtAAAACXBIWXMAAC4jAAAuIwF4pT92AAAKp2lUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMxNDAgNzkuMTYwNDUxLCAyMDE3LzA1LzA2LTAxOjA4OjIxICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdEV2dD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlRXZlbnQjIiB4bWxuczpwaG90b3Nob3A9Imh0dHA6Ly9ucy5hZG9iZS5jb20vcGhvdG9zaG9wLzEuMC8iIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ0MgKE1hY2ludG9zaCkiIHhtcDpDcmVhdGVEYXRlPSIyMDE4LTA0LTI4VDE5OjAyOjI4KzA4OjAwIiB4bXA6TWV0YWRhdGFEYXRlPSIyMDE4LTA0LTI4VDE5OjAyOjI4KzA4OjAwIiB4bXA6TW9kaWZ5RGF0ZT0iMjAxOC0wNC0yOFQxOTowMjoyOCswODowMCIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo5NWVhMjA0Yy0zMmEzLTRhYjUtYWM1YS1jM2E5N2Q2ZWU4OGMiIHhtcE1NOkRvY3VtZW50SUQ9ImFkb2JlOmRvY2lkOnBob3Rvc2hvcDo4OWYyYzY4Yi0xN2I5LWM1NDQtODk5Ni1jYmFhNTg4ZDZhNDAiIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDo0YTQ5ODUxYS0wNWEwLTQwNmEtOTY1NC05YjViYjRhY2QwMjkiIHBob3Rvc2hvcDpDb2xvck1vZGU9IjMiIHBob3Rvc2hvcDpJQ0NQcm9maWxlPSJzUkdCIElFQzYxOTY2LTIuMSIgZGM6Zm9ybWF0PSJpbWFnZS9wbmciPiA8eG1wTU06SGlzdG9yeT4gPHJkZjpTZXE+IDxyZGY6bGkgc3RFdnQ6YWN0aW9uPSJjcmVhdGVkIiBzdEV2dDppbnN0YW5jZUlEPSJ4bXAuaWlkOjRhNDk4NTFhLTA1YTAtNDA2YS05NjU0LTliNWJiNGFjZDAyOSIgc3RFdnQ6d2hlbj0iMjAxOC0wNC0yOFQxOTowMjoyOCswODowMCIgc3RFdnQ6c29mdHdhcmVBZ2VudD0iQWRvYmUgUGhvdG9zaG9wIENDIChNYWNpbnRvc2gpIi8+IDxyZGY6bGkgc3RFdnQ6YWN0aW9uPSJzYXZlZCIgc3RFdnQ6aW5zdGFuY2VJRD0ieG1wLmlpZDo5NWVhMjA0Yy0zMmEzLTRhYjUtYWM1YS1jM2E5N2Q2ZWU4OGMiIHN0RXZ0OndoZW49IjIwMTgtMDQtMjhUMTk6MDI6MjgrMDg6MDAiIHN0RXZ0OnNvZnR3YXJlQWdlbnQ9IkFkb2JlIFBob3Rvc2hvcCBDQyAoTWFjaW50b3NoKSIgc3RFdnQ6Y2hhbmdlZD0iLyIvPiA8L3JkZjpTZXE+IDwveG1wTU06SGlzdG9yeT4gPHBob3Rvc2hvcDpEb2N1bWVudEFuY2VzdG9ycz4gPHJkZjpCYWc+IDxyZGY6bGk+YWRvYmU6ZG9jaWQ6cGhvdG9zaG9wOjAxMmM5ZjAzLWNlN2YtMTE3YS1hNTRlLWZjOTdhNGYxMjE2ZTwvcmRmOmxpPiA8cmRmOmxpPmFkb2JlOmRvY2lkOnBob3Rvc2hvcDo2ZjQ2NDI5Yi04NjcxLTgzNDQtODFkOC05NTY3NjBjMTgyYzY8L3JkZjpsaT4gPHJkZjpsaT5hZG9iZTpkb2NpZDpwaG90b3Nob3A6YWVkNGEzZWMtODA0NS0xMTdiLTk2MmMtOTMwYzIxNGE1YjQ4PC9yZGY6bGk+IDxyZGY6bGk+YWRvYmU6ZG9jaWQ6cGhvdG9zaG9wOmI4NTllMGQwLTMyMTMtYjg0Ni1iMDI0LTZlNzA5OWIxZTZiYjwvcmRmOmxpPiA8cmRmOmxpPnhtcC5kaWQ6MDBkYWMzMzUtYTVlZC0zNjQ5LTk4OTItZTQ4NWQwNzhhOTRjPC9yZGY6bGk+IDxyZGY6bGk+eG1wLmRpZDowODlkNzUwYi0yOWY2LTQ5NDItYjhhMC04Yzg0OGE1M2E0Mjc8L3JkZjpsaT4gPHJkZjpsaT54bXAuZGlkOjBGQTNDOEQxNjFDMkU3MTFBOTAzQTNBMjFEQUQzNkIxPC9yZGY6bGk+IDxyZGY6bGk+eG1wLmRpZDozOTA5MDkzQjBDNkRFNzExQTQ5REM5MzY2MEYxMjNCNzwvcmRmOmxpPiA8cmRmOmxpPnhtcC5kaWQ6NThCOTU4NDNCQUNFMTFFNzk1NTlCMUZCQkNGODVFOTg8L3JkZjpsaT4gPHJkZjpsaT54bXAuZGlkOjVCRjUwM0JERDM5NDExRTU4MEVGQjEzQThGN0VGMTZFPC9yZGY6bGk+IDxyZGY6bGk+eG1wLmRpZDo2MTgzQzMxNjE4MzQxMUU1QjZCM0EwQzQ3MURBNkFGNzwvcmRmOmxpPiA8cmRmOmxpPnhtcC5kaWQ6NjFGRTkxMTYxQzlFMTFFNTg5NUNGQzc4M0E5ODREMkY8L3JkZjpsaT4gPHJkZjpsaT54bXAuZGlkOjhEMkVGM0I5Mzg2RjExRTVBQjYxREI3MTBBNDg4QjMyPC9yZGY6bGk+IDxyZGY6bGk+eG1wLmRpZDpBNjlFRjY3RjE4MzQxMUU1QjZCM0EwQzQ3MURBNkFGNzwvcmRmOmxpPiA8cmRmOmxpPnhtcC5kaWQ6QTY5RUY2ODMxODM0MTFFNUI2QjNBMEM0NzFEQTZBRjc8L3JkZjpsaT4gPHJkZjpsaT54bXAuZGlkOkFDRkY3RDJENTBCMzExRTZBMzM5QzA0MjQyQjQ3OURBPC9yZGY6bGk+IDxyZGY6bGk+eG1wLmRpZDpDMTY1NDRDMUVCRjUxMUU0QUM4N0RGQTVGNzc3NzFCNzwvcmRmOmxpPiA8cmRmOmxpPnhtcC5kaWQ6REJBRDlGRkE5OUI4MTFFNkEyRjdEQTZBOTYzQzc3NzE8L3JkZjpsaT4gPC9yZGY6QmFnPiA8L3Bob3Rvc2hvcDpEb2N1bWVudEFuY2VzdG9ycz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz6Y1/xKAAAC2ElEQVRYhe2Yz29SQRDHP6W02gKl0khRYjTR3kg1jcaT/7wnjRo1/qgHjQd/FLS8ttIWRQQPszyXx7zH7ntUEuPn1DK7s19md3ZnWBgOh/wnAwsp5hSBGlAxfy8DS8BPoAd0gABoAcd/U2AN2ALWPeYEwDug6TFnDBeBRWAb2Ei7CNAGngMnvhOnCbwM3ATyKURF6QPPgD2fSYsJtqvArSljfMghX/g7cOQ6KS4ydWRb4zgCPiNb10USZAlYQZKnDpRj5m4jyeR0LrUtLgL30MWfAi+ALw6+q0ADKCi2PnAfhzOpbd+dGKdN4AFyjbhwAnwASsiXtsmZzz/6CqwBN5RxX4FHwMBR3IgBkhRrishV5KgkRjEX+X9LGXMKPAHSvolD4GmMEC0YY9gCS+iX8EskCbLQB14pn1fQj1OILXBTsX9DnqxZ0DL+omjrhtgCK4r9UxZFjv4SX6joFkdpZ5Lj5i+aPGPYAs8p9m4mOW7+tHVDbIHandjLJMfNX+JTagv8pdhnUSRM86etG2IL/KHYVzPJcfOnrRtiC9SesCw1oIbmL7HqtgUGir2eSY6bP23dEFugdiGXkapkFlTRS7DEsiu6xYfKmAZS62Vh0fiJEuBZLLxVxhSAHdJ1gJh5O+hvrrbeGNE76Bi4iFTGNgWkkGjhV3LlgdtIGRdlH3jjKxDgALjCZHQLSE/Rxa3frRlxF2Lsj5lyxcQJ7BkRlxTbMpKJm0h0BshFOzD/F429AVw34+MoIcVs4o4knatrZqG0Z8+FAHiI1IsqSe/gIbKVVSa3e1asIJd3k5hITut5O2ZymcnE8aGNnLmS4mfUqqoiXZryHtKddZC39LyHsABpGXaRhNhDIqaJ3EA5k/P4dSsP3EWv4A+QMxn2QGeZAEk4i5zV7y6+jPrluO1ew/QvZ5WdLvSRSGnVTBjZeUVwRFwkX2MKl3kLhD8iS0jC7QLv56ron+I3lCOWLAF0MIUAAAAASUVORK5CYII=) 2x);
    }

    .search-text {
        flex: 1;
        height: 100%;
        outline: none;
        border: none;
        font-size: 14px;
        padding: 0;
        margin-right: 20px;
        color: rgba(0, 0, 0, .7);
        font-weight: 700;
    }

    .recommand {
        color: #3965cc;
        border: 1px solid rgba(138, 173, 55, .6);
        border-radius: 10px;
        background: #e5efff;
        padding: 0 10px;
    }

    .search-content-box {
        z-index: 10;
        position: absolute;
        top: 130px;
        right: 30px;
        border-radius: 12px;
        width: 260px;
        height: 300px;
        padding: 0 24px 16px;
        background: #fff;
    }

    .text-title {
        cursor: pointer;
        font-size: 22px;
        color: #222226;
        font-weight: 400;
        margin-bottom: 7px;
        margin-top: 4px
    }

    .text-title:hover {
        background-color: #a6a6a6;
    }

</style>
