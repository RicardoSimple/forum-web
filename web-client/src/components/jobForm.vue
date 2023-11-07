<template>
  <div class="comment">
    <el-card
      class="box-card"
      shadow="hover"
      body-style="{ padding:'0px' }"
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
            >详情</el-button>
          </div>
        </div>
        <div class="time">{{ job.salary }}</div>
      </div>
      <div class="content">
        <div class="title">{{ job.desc }}</div>
        <div>
          <el-tag
            v-for="tag in job.tags"
            :key="tag"
            class="tags"
          >
            {{tag}}
          </el-tag>
        </div>
      </div>
      <el-divider></el-divider>
      <div class="footer">
        <div
          class="footer-left"
          style="float: left;"
        >
          <el-avatar
            :size="40"
            :src="url"
          ></el-avatar>
          <div>{{ job.team.name }}</div>
        </div>
        <div
          class="footer-right"
          style="float: right;padding-bottom: 10px;"
        >
          <div>{{ job.team.industry }}</div>
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
    url () {
      // 计算头像 URL 的逻辑，可以从 comment 中获取
      return this.job.avatarUrl;
    },
  },
  watch: {
    job: {
      handler: async function (oldName, newName) {
        var res = (await getTeamById(this.job.teamId)).data;
        console.log(res)
      },
      immediate: true
    }
  }
};
</script>

<style scoped>
.box-card {
  line-height: normal;
  max-height: 400px;
}
.head {
  display: flex;
  height: 80px;
  width: 90%;
  flex-wrap: nowrap;
  align-items: self-start;
}
.info {
  height: 80px;
  padding-top: 25px;
}
.detailBtn {
  position: relative;
  top: -30px;
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

.time {
  color: #999;
  font-size: 15px;
  line-height: 20px;
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
