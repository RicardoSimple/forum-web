<template>
  <div>
    <JobForm :job="job"></JobForm>
  </div>
</template>

<script>
import JobForm from './jobForm.vue';
import {getAllTeamJob} from '../api/teamJobService' 
export default {
  components: [JobForm],
  async created () {
    var res =(await getAllTeamJob()).data
    console.log(res)
  },
  data () {
    return {
      job: {

      }
    }
  }
}
</script>