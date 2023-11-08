<template>
  <div>
    <div
      v-for="job,index in jobs"
      :key="index"
    >
      <JobForm :job="job"></JobForm>
    </div>
  </div>
</template>

<script>
import JobForm from './jobForm.vue';
import { getAllTeamJob } from '../api/teamJobService'
export default {
  components: {JobForm},
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