<template>
    <div>
        <singlejob :job="job"></singlejob>
    </div>
</template>
<script>
import singlejob from './singlejob.vue'
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
                desc: "月薪1000，12薪",
                content :"招程序员，不包吃不包住\n工作时间:一周七天，每天8：00到20：00\n",
                type:"程序员",
                tags: ["前端","算法","深度学习","后端"],
                count:10,
                gmtCreated: "2023/11/6 16:55"
            }
        }
    }
}
</script>