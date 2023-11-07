<template>
    <div>
        <singlejob :job="job"></singlejob>
    </div>
</template>
<script>
import singlejob from './singlejob.vue';
import { getTeamJobById } from '@/api/teamJobService.js';
export default {
    components:{
        singlejob
    },
    async beforeCreate(){
        this.id=this.$route.params.id;
        console.log(this.id);
        var res=(await getTeamJobById(this.id)).data;
        console.log(res.data);
        this.job=res.data;
    },
    data(){
        return{
            id:"",
            job:"",
            //job: {
            //     id: 124,
            //     jobName: "全栈程序员",
            //     teamId: 135678,
            //     desc: "全栈端工程师 招程序员，不包吃不包住\n工作时间:一周七天，每天8：00到20：00\n",
            //     content :"1、会所有语言2、有算法和深度学习等方面的项目经历3、应届生，三年工作经历",
            //     type:"全职",
            //     tags: [
            //          '标签一',
            //         '标签二',
            //          '标签三',
            //         '标签四',
            //         '标签五',
            //     ],
            //     count:10,
            //     gmtCreated: "2023/11/6 16:55"
            // }
        }
    },
    
}
</script>