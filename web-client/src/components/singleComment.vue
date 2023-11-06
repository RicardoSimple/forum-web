<template>
  <div class="comment">
    <div class="head">
      <el-avatar
        :size="50"
        :src="url"
      ></el-avatar>
      <div class="info">
        <div class="name">{{ comment.name }}</div>
      </div>
    </div>
    <div class="content">
      <div class="title">{{ comment.title }}</div>
      <div class="main">{{ comment.content }}</div>
    </div>
    <div class="foot">
      <div class="time">{{ comment.gmtCreated }}</div>
      <!-- 可以添加底部内容，如操作按钮等 -->
    </div>
  </div>
</template>

<script>
export default {
  name: 'SingleComment',
  props: {
    comment: {
      type: Object,
      required: true,
    },
  },
  computed: {
    url (){
      // 计算头像 URL 的逻辑，可以从 comment 中获取
      return this.comment.avatarUrl;
    },
  },
};
</script>

<style scoped>
.comment {
  display: flex;
  border: 1px solid #e0e0e0;
  border-radius: 4px;
  padding: 16px;
  margin-bottom: 16px;
}

.head {
  display: flex;
}

.el-avatar {
  margin-right: 16px;
}

.info {
  display: flex;
  flex-direction: column;
}

.name {
  font-weight: bold;
}

.time {
  color: #999;
}

.content {
  flex: 1;
}

.title {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 8px;
}

.main {
  font-size: 14px;
}

.foot {
  margin-top: 16px;
  text-align: right;
}
</style>
