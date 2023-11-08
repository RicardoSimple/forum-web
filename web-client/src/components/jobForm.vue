<template>
  <div class="comment" style="margin: 10px;">
    <el-card
      class="box-card"
      shadow="hover"
      :body-style="{ height:'240px' }"
    >
      <div
        slot="header"
        class="clearfix"
      >
        <div class="head">
          <div class="info">
            <div class="name">{{ job.jobName }}</div>
            <el-button
              style="float: right; padding: 3px 0"
              type="text"
              class="detailBtn"
              @click="jumpToDetail"
            >详情</el-button>
          </div>
          <div class="salary"><span style="color: rgb(209, 42, 42);">{{ salary}}</span>K/月</div>
        </div>
      </div>
      <div class="content">
        <div class="title">{{ job.desc }}</div>
        <div style="margin-top:10px;margin-bottom: 10px;">
          <el-tag
            v-for="tag in job.tags.length>5?job.tags.slice(0,5):job.tags"
            :key="tag"
            style="margin: 1px 0 0 5px;"
            class="tags"
          >
            {{tag}}
          </el-tag>
        </div>
      </div>
      <el-divider></el-divider>
      <div class="footer" style="margin-bottom: 5px;">
        <div
          class="footer-left"
          style="float: left;display: flex;"
        >
          <el-avatar
            :size="40"
            fit="fill"
            :src="team.logo"  
            style="position: relative;top: -10px;"
          ></el-avatar>
          <div>{{ team.name }}</div>
        </div>
        <div
          class="footer-right"
          style="float: right;padding-bottom: 10px;"
        >
          <div style="color: rgb(165, 167, 167);">行业：<span style="color: rgb(9, 6, 6);">{{ team.industry }}</span></div>
        </div>
      </div>
    </el-card>
  </div>
</template>


<script>
import { getTeamById } from '../api/teamService'

export default {
  name: 'JobForm',
  data () {
    return {
      team: {},
    }
  },
  props: {
    job: {
      type: Object,
      required: true,
    },
  },
  computed: {
    salary () {
      return this.job.salaryRange[0]/1000 + "-" + this.job.salaryRange[1]/1000
    }
  },
  watch: {
    job: {
      handler: async function (oldName, newName) {
        var res = (await getTeamById(this.job.teamId)).data;
        console.log(res)
        this.team = res.data;
      },
      immediate: true
    }
  },
  methods:{
    jumpToDetail(){
      window.location.href='/#/jobdetail/'+this.job.id;
    }
  }
};
</script>

<style scoped>
.box-card {
  line-height: normal;
  width: 500px;
  height: 280px;
}
.head {
  display: flex;
  height: 50px;
  width: 90%;
  line-height: 50px;
  text-align: center;
  flex-wrap: nowrap;
  justify-content: space-between;
  align-items: baseline;
}
.info {
  height: 80px;
  display: flex;
  padding-top: 25px;
  justify-content: space-between;
}
.detailBtn {
  position: relative;
  top: -28px;
  left: 40px;
}
.el-avatar {
  margin-right: 16px;
}

.name {
  font-weight: bold;
  font-size: 20px;
  line-height: 20px;
  margin-bottom: 10px;
}

.salary {
  color:rgb(73, 59, 59);
  font-size: 40px;
  line-height: 40px;
  position: relative;
  top: 5px;
  text-align: center;
}
.content {
  text-align: left;
  margin: 10px;
}
.title {
  font-size: 18px;
  height: 40px;
  font-weight: bold;
}

.main {
  font-size: 14px;
  line-height: 20px;
  justify-content: center;
  min-height: 50px;
}
</style>
