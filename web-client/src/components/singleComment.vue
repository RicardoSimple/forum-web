<template>
  <div
    class="comment"
    style="margin-bottom: 10px;"
  >
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
          <el-avatar
            :size="80"
            :src="avatarUrl"
          ></el-avatar>
          <div class="info">
            <div class="name">{{ comment.name }}</div>
            <div class="time">{{ comment.gmtCreated }}</div>
          </div>
        </div>
        <el-link
          style="float: right; padding: 3px 0 ;color:gray;"
          type="text"
          class="detailBtn"
          :href="pathToArtical"
        >查看<i class="el-icon-view el-icon--right"></i> </el-link>
      </div>
      <div class="content">
        <div class="title">{{ comment.title }}</div>
        <div class="main">{{ comment.content }}</div>
      </div>
      <el-divider></el-divider>
      <div class="footer">
        <div
          class="footer-right"
          style="float: right;padding-bottom: 10px;"
        >
          <el-button
            v-if="this.userData.id==this.comment.userID"
            type="primary"
            icon="el-icon-edit"
            circle
            @click="toEditComment"
          ></el-button>
          <el-button
            type="success"
            icon="el-icon-view"
            circle
            @click="toDetail"
          ></el-button>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import { getUserWithIdAndType } from '@/api/loginService';
export default {
  name: 'SingleComment',
  data () {
    return {
      avatarUrl: "",
      userData: null,
    }
  },
  props: {
    comment: {
      type: Object,
      required: true,
    },
  },
  computed: {
    pathToArtical () {
      return "/#/artical/" + this.comment.id
    }
  },
  created () {
    this.userData = JSON.parse(sessionStorage.getItem("userData"))
  },
  watch: {
    comment: {
      handler: async function (newName, oldName) {
        console.log(this.comment)
        var res = (await getUserWithIdAndType(this.comment.userID, this.comment.userType)).data;
        console.log(res)
        if (res.code == 200) {
          this.avatarUrl = res.data.avatar;
          console.log("yes")
          console.log(this.avatarUrl)
        }
      },
      immediate: true
    }
  },
  methods: {
    toDetail () {
      window.location.href = this.pathToArtical;
    },
    toEditComment () {
      window.location.href = '/#/editComment/' + this.comment.id;
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
