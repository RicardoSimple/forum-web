<template>
  <div>
    <singleartical :artical="artical"></singleartical>
    111
  </div>
</template>
<script>
import { getCommentById } from '@/api/commentService';
import singleartical from './singleartical.vue'
export default {
  components: {
    singleartical
  },
  async beforeCreate () {
    this.id = this.$route.params.id
    console.log(this.id);
    var res = (await getCommentById(this.id)).data;
    console.log(res.data);
    this.artical = res.data
  },
  data () {
    return {
      id: "",
      artical: "",
    }
  },
}
</script>