<!-- GlobalLoginListener.vue -->
<template>
  <div>
    <!-- 监听用户登录状态 -->
    <div v-if="user">
      <!-- 用户已登录 -->
      <!-- 在这里添加您想要展示的用户信息 -->
    </div>
    <div v-else>
      <!-- 用户未登录 -->
      <!-- 在这里添加未登录状态的内容或登录按钮 -->
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  computed: {
    ...mapState(['user']), // 从 Vuex store 中获取用户信息
  },
  methods:{
    
  }
};
</script>
