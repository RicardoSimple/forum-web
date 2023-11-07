<template>
    <div class="job">
        <div class="head">
            <div class="title">
                {{ job.jobName }}
                <span style="font-size: 80%;color: red;">{{ job.salaryRange[0]/1000 }}K-{{ job.salaryRange[1]/1000 }}K</span>
            </div>
            <div class="user">
                <el-link :href="teampage" style="text-align: left;">
                    <div class="teamname">{{teamname}}</div>
                    <div class="teamindustry">行业：{{ teamindustry }}</div>
                    <div class="teamlink">官网:{{ teamlink }}</div>
                    
                </el-link>
            </div>
        </div>
        <div class="body">
                <div>
                    <h4>职位描述</h4>
                </div>
                <div >
                    <el-tag
                    v-for="tag in job.tags"
                    :key="tag"
                    class="tags">
                    {{tag}}
                    </el-tag>
                </div>
                <div>
                    <p>职位类型：{{ job.type }}</p>
                </div>
                <div class="desc" >
                    <p >
                    {{ job.desc }}
                    </p>
                </div>
                <div class="content" >
                    <p >
                    {{ job.content }}
                    </p>
                </div>
                <div class="count">
                    <p>
                    &nbsp;
                    &nbsp;
                    预计招聘：
                    {{ job.count }}人
                    </p>
                </div>
            </div>
            <div class="button">
                <el-button ><!--投递简历功能，未实现，需要获取当前用户id-->
                    投递简历
                </el-button>
        </div>
    </div>
</template>
<script>
import router from '@/router';
import {getTeamById} from '@/api/teamService'
export default{
    name: "singlejob",
    props: {
        job: {
            type: Object,
            retquired: true,
        },
    },
    data(){
        return {
            teamname:"",
            teamlink:"",
            teamindustry:"",
        }
    },
    computed: {
       teampage() {
        return "/user/:"+this.job.teamId;
       }

    },
    watch:{
        job:{
            handler: async function(newName,oldName){
                console.log(this.job)
                var res =(await getTeamById(this.job.teamId) ).data;
                console.log(res);
                this.teamname=res.data.name;
                this.teamlink=res.data.link;
                this.teamindustry=res.data.industry;
            }
        }
    }  

};
</script>
<style>
.head{
    text-align: left;
    margin-left: 15%;   
    margin-right: 15%;
}
.body{
    text-align: left;
    margin-left: 15%;
    margin-right: 15%;
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