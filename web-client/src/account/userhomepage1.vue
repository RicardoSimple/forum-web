<template>
  <div style="margin-left: 10%;margin-right: 10%;">
    <div
      class="currentUser"
      style=""
    >
    </div>
    <Information
      :id="this.userData.id"
      :userType="this.userData.userType"
    ></Information>
    <el-row :gutter="20">
      <el-col :span="6">
        <div class="grid-content bg-purple">
          <span
            style="font-size: 20px; border: 1px gray solid;padding: 5px 11px;border-radius: 8px;"
          > <router-link
              to="/currentUser/myartical"
              style="text-decoration: none; color: gray;"
            > 帖子 </router-link> </span>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="grid-content bg-purple">
          <span
            style="font-size: 20px; border: 1px gray solid;padding: 5px 11px;border-radius: 8px;"
          > <router-link
              to="/creat/artical"
              style="text-decoration: none; color: gray;"
            > 去发帖 </router-link> </span>
        </div>
      </el-col>

      <el-col
        :span="6"
        v-if="this.userData.userType==='talent_user'"
      >
        <div>
          <span
            style="font-size: 20px;border: 1px gray solid;padding: 5px 11px;border-radius: 8px;"
          > <router-link
              to="/currentUser/myjob"
              style="text-decoration: none;color: gray;"
            > 已投岗位 </router-link> </span>
        </div>
      </el-col>
      <el-col
        :span="6"
        v-if="this.userData.userType==='team_user'"
      >
        <div>
          <span
            style="font-size: 20px;border: 1px gray solid;padding: 5px 11px;border-radius: 8px;"
          > <router-link
              to="/currentUser/myCreatedjob"
              style="text-decoration: none;color: gray;"
            > 在招岗位 </router-link> </span>
        </div>
      </el-col>
      <el-col
        :span="6"
        v-if="this.userData.userType==='team_user'"
      >
        <div>
          <span
            style="font-size: 20px;border: 1px gray solid;padding: 5px 11px;border-radius: 8px;"
          > <router-link
              to="/creat/job"
              style="text-decoration: none;color: gray;"
            > 发布岗位 </router-link> </span>
        </div>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="24">
        <div class="grid-content bg-purple" style="padding: 20px;">
          <router-view></router-view>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import Information from './information.vue';
export default {
  name: 'userpage',
  components: { Information },
  data () {
    return {
      userData: null,
    }

  },
  created () {
    this.userData = JSON.parse(sessionStorage.getItem("userData"))
  }
}
</script>
<style>
.currentUser {
  text-align: left;
}
.el-row {
  margin-bottom: 20px;
}
.el-col {
  border-radius: 4px;
}
.row-bg {
  padding: 10px 0;
}
</style>