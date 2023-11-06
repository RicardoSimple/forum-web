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
                    <h4>职位描述</h4>
                </div>
                <div >
                    <el-tag
                    v-for="tag in job.tags"
                    :key="tag.name"
                    class="tags">
                    {{tag.name}}
                    </el-tag>
                </div>
                <div class="desc" >
                    <p >
                    &nbsp;
                    &nbsp;
                    {{ job.desc }}
                    </p>
                </div>
                <div class="content" >
                    <p >
                    &nbsp;
                    &nbsp;
                    {{ job.content }}
                    </p>
                </div>
                <div class="count">
                    <p>
                    &nbsp;
                    &nbsp;
                    预计招聘：{{ job.count }}人
                    </p>
                </div>
            </div>
            <div class="button">
                <el-button ><!--投递简历功能，未实现，需要获取当前用户id-->
                    投递简历
                </el-button>
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
        },
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
div.body{
    margin-top:10px;
    font-size: 100%;
    text-align: left;
    margin-right: 10%;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    
}
.tags{
    margin-right: 1%;
    font-size: 100%;
    margin-bottom: 10px;
}
.button{
    text-align: center;
    font-size: 200%;
}
</style>