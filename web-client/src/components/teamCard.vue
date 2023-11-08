<template>
  <div style="margin-bottom: 10px;">
    <el-card shadow="hover" style="display: flex;align-items: center;justify-content: center;flex-direction: row;"><el-avatar
        shape="square"
        :size="50"
        :src="team.logo"
      ></el-avatar>
      <div>{{ team.name }}</div>
    </el-card>
  </div>
</template>

<script>
export default {
  name:'TeamCard',
  data () {
    return {
    }
  },
  props: {
    team: {
      type: Object
    }
  }
}
</script>

<style>
</style>