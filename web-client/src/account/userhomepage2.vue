<template>
  <div>
    <div>
      <Information
        :id="this.userId"
        :userType="this.userType"
      ></Information>
    </div>

    <el-row :gutter="20">
      <el-col :span="6">
        <div>
          <el-button @click="jumpToArtical">TA的帖子</el-button>
        </div>
      </el-col>
      <el-col :span="6">
        <div
          v-if="this.userType==='team_user'"
          class="grid-content bg-purple"
        >
          <el-button @click="jumpToJob">TA们的岗位</el-button>
        </div>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="24">
        <div class="grid-content bg-purple"></div>
      </el-col>
    </el-row>

    <el-row :gutter="20">
      <el-col :span="24">
        <div class="grid-content bg-purple">
          <router-view></router-view>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import { getUserWithIdAndType } from '../api/loginService'
import Information from './information.vue';
export default {
  components: { Information },
  async created () {
    console.log(this.$route)
    this.userId = this.$route.params.id
    this.userType = this.$route.query.userType
    console.log(this.userType)
    console.log(this.userId)
    this.userData = (await getUserWithIdAndType(this.userId, this.userType)).data
    this.currentUser = JSON.parse(sessionStorage.getItem("userData"))

    console.log(this.userData)

  },
  data () {
    return {
      userData: null,
      userId: null,
      userType: null,
      currentUser: null,
    }
  },
  methods: {
    jumpToArtical () {
      window.location.href = `/#/user/${this.userId}/artical?userType=${this.userType}`
    },
    jumpToJob () {
      window.location.href = `/#/user/${this.userId}/createdjob?userType=${this.userType}`
    }
  }
}
</script>
<style>
.el-row {
  margin-bottom: 20px;
}
.el-col {
  border-radius: 4px;
}
</style>