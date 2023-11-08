<template>
  <div>
    <div class="jobContainer">
      <div
        v-for="job,index in jobs"
        :key="index"
      >
        <JobForm :job="job"></JobForm>
      </div>
    </div>
  </div>
</template>

<script>
import JobForm from './jobForm.vue';
import { getAllTeamJob } from '../api/teamJobService'
export default {
  components: { JobForm },
  async created () {
    var res = (await getAllTeamJob()).data
    console.log(res.data)
    this.jobs = res.data
  },
  data () {
    return {
      jobs: {}
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