
<template>
    <div>
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
        var id = this.$route.params.id
        var userType = this.$route.query.userType
        var res= (await GetCommentByIdAndType(userType,id)).data
        console.log(res)
        console.log(id)
        console.log(userType)
        this.comments=res.data
    },
    data(){
        return{
            comments:[],
        }
    }
}
</script>