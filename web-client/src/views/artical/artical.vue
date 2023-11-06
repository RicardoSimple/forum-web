<template>
    <div>
        <singleartical  :artical ="artical"></singleartical>
    </div>
</template>
<script>
import singleartical from './singleartical.vue'
export default{
    components:{
    singleartical
},
    data(){
        return{
            artical:{
                id: 1234,   //帖子id
                author_id: "12345", //作者id
                author_name: "张三",//用户昵称
                title: "标题",
                body: "文章主体",
                gmtCreated: "2023/11/6 16:33",
            }
        }
    }
}
</script>