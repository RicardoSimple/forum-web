

<template>
    <div>
        <div style="text-align: right;">
            <router-link to="/creat/artical">
                发帖
            </router-link>
        </div>
        <div
        v-for="comment,index in comments"
        :key="index">
        <SingleComment :comment="comment"></SingleComment>
        </div>
    </div>
</template>
<script>
import SingleComment from '@/components/singleComment.vue';
import { GetCommentByIdAndType } from '@/api/commentService';
import router from '@/router';
export default{
    components:{
    SingleComment,
},
    async created(){
        var ras =JSON.parse(sessionStorage.getItem("userData"))
        var res = (await GetCommentByIdAndType(ras.userType,ras.id)).data
        this.comments=res.data;
        console.log("comment")
        console.log(res)
    },
    data(){
        return{
            comments:[],
        }
    }
}
</script>