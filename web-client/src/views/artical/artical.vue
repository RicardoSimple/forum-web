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
                artical_id: 1234,   //帖子id
                author_id: "12345", //作者id
                title: "标题",
                body: "文章主体",
                gmtCreated: "2023/11/6 16:33",
            }
        }
    }
}
</script>