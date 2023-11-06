<template>
    <div class="job">
        <div class="head">
            <div class="title">{{ job.jobName }}</div>
            <div class="user">
                <router-link to="/home/userhomepage1" style="text-decoration: none;color: black;" >
                    <el-avatar
                    :size="50"
                    :src= "img"
                    ></el-avatar>
                    <span class="teamname">{{teamName}}</span>
                </router-link>
            </div>
            <div class="body">
                <div>
                    <h3>职位描述</h3>
                </div>
                <div>
                    <el-tags>
                        
                    </el-tags>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import router from '@/router';

export default{
    name: "singlejob",
    props: {
        job: {
            type: Object,
            retquired: true,
        },
    },
    computed: {
        teamName: function() {
            //根据teamid返回企业用户的昵称
            return this.job.teamId;
        },
        img: function () {
            // 计算头像 URL 的逻辑，可以从 comment 中获取
            return this.job.id;
        }
    },
};
</script>
<style>
.head{
    text-align: left;
    margin-left: 10%;   
}
.title{
    font-size:300%;
}
.user{
    margin-top: 10px;
    font-size: 200%;
}
.body{
    font-size: 150%;
    text-align: left;
    margin-right: 10%;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)


}
</style>