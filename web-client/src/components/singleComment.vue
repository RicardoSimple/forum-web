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
          <el-avatar
            :size="80"
            :src="avatarUrl"
          ></el-avatar>
          <div class="info">
            <div class="name">{{ comment.name }}</div>
            <div class="time">{{ comment.gmtCreated }}</div>
          </div>
        </div>
        <el-button
          style="float: right; padding: 3px 0"
          type="text"
          class="detailBtn"
        >查看更多</el-button>
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
            type="primary"
            icon="el-icon-edit"
            circle
          ></el-button>
          <el-button
            type="success"
            icon="el-icon-check"
            circle
          ></el-button>
          <el-button
            type="info"
            icon="el-icon-message"
            circle
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
    }
  },
  props: {
    comment: {
      type: Object,
      required: true,
    },
  },
  watch:{
    comment:{
      handler:async function(newName,oldName){
        console.log(this.comment)
        var res = (await getUserWithIdAndType(this.userType,this.userID)).data;
        console.log(res)
        if(res.code==200){
          this.avatarUrl = res.data.avatar;
          console.log("yes")
          console.log(this.avatarUrl)
        }
      },
      immediate:true
    }
  },
  computed: {
  },
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
