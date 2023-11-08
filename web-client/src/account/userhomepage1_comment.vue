
import SingleComment from '@/components/singleComment.vue';

<template>
    <div>
        <div
        v-for="comment,index in b"
        :key="index">
        <singleComment :comment="comment"></singleComment>
        </div>
    </div>
</template>
<script>
import singleComment from '@/components/singleComment.vue';
import { getCommentByIdAndType } from '@/api/commentService';
export default{


    components:{
        singleComment
    },
    async created(){
        var ras =JSON.parse(sessionStorage.getItem("userData"))
        var res = (await getCommentByIdAndType(ras.userId,ras.userType)).funData
        this.comments=res.data;
    },
    data(){
        return{
            coments:[],
        }
    }
}
</script>