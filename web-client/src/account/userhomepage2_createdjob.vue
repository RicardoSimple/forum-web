<template>
  <div>
    <div style="display: flex; justify-content: space-around;">
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
import JobForm from '../components/jobForm.vue';
import { getTeamJobByTeamId } from '../api/teamJobService'
import { getUserWithIdAndType } from '@/api/loginService';
export default {
  components: { JobForm },
  async created () {
    var id = this.$route.params.id
    var userType = this.$route.query.userType
    var res = (await getUserWithIdAndType(id, userType)).data
    this.jobs = (await getTeamJobByTeamId(res.data.teamId)).data.data

  },
  data () {
    return {
      jobs: {}
    }
  }
}
</script>