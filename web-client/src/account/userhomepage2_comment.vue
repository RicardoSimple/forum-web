
<template>
    <div>
        1
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

        console.log(id)
        console.log(userType)
    },
    data(){
        return{
            comments:[],
        }
    }
}
</script>