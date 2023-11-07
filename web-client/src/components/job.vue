<template>
  <div>
    <JobForm :job="job"></JobForm>
  </div>
</template>

<script>
import JobForm from './jobForm.vue';
export default {
  components: [JobForm],
  data () {
    return {
      job: {

      }
    }
  }
}
</script>