<template>
  <div>
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
import { getTeamJobByTeamId } from '../api/teamJobService';
import JobForm from '@/components/jobForm.vue';
export default {
  components: {
    JobForm,
  },
  async created () {
    var ras = JSON.parse(sessionStorage.getItem("userData"))
    var res = (await getTeamJobByTeamId(ras.teamId)).data
    this.jobs = res.data;
  },
  data () {
    return {
      jobs: [],
    }
  }
}
</script>

<style>
.jobContainer {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  align-items: center;
  padding: 10px;
  width: 1100px;
  height: auto;
}
</style>