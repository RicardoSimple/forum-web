<template>
  <div>
    <singleComment :comment="comment"></singleComment>
  </div>
</template>

<script>
import singleComment from './singleComment.vue'
export default {
  components: {
    singleComment
  },
  data () {
    return {
      comment: {
        name: "xiao",
        title: "评论标题",
        content: "1?5!",
        gmtCreated: "2023-11-3 15:30",
        userID:"1",
        userType:"talent_user"
      }
    }
  }
}
</script>