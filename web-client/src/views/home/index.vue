<template>
  <div>
    <H3>
      欢迎来到 企业论坛系统
    </H3>
    <el-container>
      <el-container>
        <el-header>
          <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            router
            mode="horizontal"
            @select="handleSelect"
          >
            <el-menu-item
              route="comment"
              index="1"
            >帖子</el-menu-item>
            <el-menu-item
              route="job"
              index="2"
            >岗位</el-menu-item>
          </el-menu>
        </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
      <el-aside width="300px">
        <el-card
          v-if="userData!=null"
          style="  height: 400px;"
          class="aside-card"
        >
          <div
            slot="header"
            class="clearfix"
          >
            <span>DashCard</span>
            <!-- <el-button
              style="float: right; padding: 3px 0"
              type="text"
            >操作按钮</el-button> -->
          </div>
          <div style="display: flex; flex-direction: column;flex: none;align-items: center;
          justify-content: center;">
            <el-button
              type=""
              icon="el-icon-user"
              class="btn"
              @click="jumpToComment"
              round
            >我的帖子</el-button>
            <el-button
              type=""
              icon="el-icon-plus"
              class="btn"
              @click="jumpToNewComment"
              round
            >发布帖子</el-button>
            <el-button
              type=""
              class="btn"
              icon="el-icon-setting"
              @click="jumpToJob"
              v-if="userData!=null&&userData.userType=='team_user'"
              round
            >管理岗位</el-button>
            <el-button
              type=""
              class="btn"
              icon="el-icon-plus"
              @click="jumpToNewJob"
              v-if="userData!=null&&userData.userType=='team_user'"
              round
            >发布岗位</el-button>
          </div>
          <div>

          </div>
        </el-card>
        <el-card
          class="aside-card"
          style="margin-top: 10px;"
        >
          <div
            slot="header"
            class="clearfix"
          >
            <span>企业</span>
            <el-button
              style="float: right; padding: 3px 0"
              type="text"
              @click="addEvent"
            >去添加</el-button>
          </div>
          <div>
            <div
              v-for="team,index in teams"
              :key="index"
            >
              <TeamCard :team="team"></TeamCard>
            </div>
          </div>
        </el-card>
      </el-aside>
    </el-container>

  </div>
</template>

<script>
import { getAllTeam } from '@/api/teamService'
import TeamCard from '@/components/teamCard.vue'

export default {
  // name: "home"
  components: { TeamCard },
  data () {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      userData: null,
      teams: []
    }
  },
  async created () {
    console.log("判断用户信息是否存在,控制展示用户信息还是展示头像")
    this.userData = JSON.parse(sessionStorage.getItem("userData"))
    console.log("当前用户信息:", this.userData)
    var res = (await getAllTeam()).data
    this.teams = res.data;
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath);
    },
    jumpToComment () {
      window.location.href = "/#/currentUser/myartical"
    },
    jumpToJob () {
      window.location.href = "/#/currentUser/myCreatedjob"
    },
    jumpToNewComment () {
      window.location.href = "/#/creat/artical"
    },
    jumpToNewJob () {
      window.location.href = "/#/creat/job"
    },
    addEvent () {
      window.location.href = "/#/addTeam"
    }
  }
}

</script>





<style scoped>
.el-header,
.el-footer {
  color: #333;
  text-align: center;
  line-height: 60px;
}

.aside-card {
  position: sticky;
}
.btn {
  width: 180px;
  margin-bottom: 10px;
}
</style>