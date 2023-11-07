<template>
  <div>
    <div
      v-for="comment,index in comments"
      :key="index"
    >
      <singleComment :comment="comment"></singleComment>
    </div>
  </div>
</template>

<script>
import { getAllComments } from '@/api/commentService'
import singleComment from './singleComment.vue'
export default {
  components: {
    singleComment
  },
  async created () {
    var res = (await getAllComments()).data
    this.comments = res.data;
  },
  data () {
    return {
      comments: [],
    }
  }
}
</script>