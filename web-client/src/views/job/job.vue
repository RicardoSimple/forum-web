<template>
    <div>
        <singlejob :job="job"></singlejob>
    </div>
</template>
<script>
import singlejob from './singlejob.vue';

export default {
    components:{
        singlejob
    },
    data(){
        return{
            job: {
                id: 124,
                jobName: "全栈程序员",
                teamId: 135678,
                desc: "全栈端工程师 招程序员，不包吃不包住\n工作时间:一周七天，每天8：00到20：00\n",
                content :"1、会所有语言2、有算法和深度学习等方面的项目经历3、应届生，三年工作经历",
                type:"全职",
                tags: [
                    { name: '标签一'},
                    { name: '标签二'},
                    { name: '标签三'},
                    { name: '标签四'},
                    { name: '标签五'},
                ],
                count:10,
                gmtCreated: "2023/11/6 16:55"
            }
        }
    },
    
}
</script>