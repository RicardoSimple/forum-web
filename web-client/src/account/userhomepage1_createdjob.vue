<template>
    <div>
        <div style="text-align: right;">
        <router-link to="/creat/artical" style="text-decoration: none;">
                发布招聘信息
            </router-link>
        </div>
        <div class="jobContainer">
        <div 
        v-for="job,index in jobs"
        :key='index'
        >
        <JobForm :job="job"></JobForm>
        </div>
        </div>
    </div>
</template>
<script>
import {getTeamJobByTeamId} from '../api/teamJobService';
import JobForm from '@/components/jobForm.vue';
export default{
    components:{
    JobForm,
},
    async created(){
        var ras =JSON.parse(sessionStorage.getItem("userData"))
        var res =(await getTeamJobByTeamId(ras.teamId)).data
        this.jobs=res.data;
    },
    data(){
        return{
            jobs:[],
        }
    }
}
</script>