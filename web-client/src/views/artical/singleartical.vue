<template>
  <div
    class="artical"
    style="margin-left : 20%;"
  >
    <div
      class="title"
      style="    text-align: center;"
    >{{ artical.title }}</div>
    <div class="author">
      <el-link
        :href="this.pasTouser"
        style="text-decoration: none;color: black;"
      >
        <!--获取用户头像-->
        <el-avatar
          :size="50"
          :src="avaterUrl"
        ></el-avatar>
        <span style="font-size: medium;">{{ artical.name }}</span>
        <div style="font-size: 15px;margin-top: 10px;color: gray;">
          发布时间：{{ artical.gmtCreated }}</div>
      </el-link>
    </div>
    <div class="artical_body">
      <span style="line-height: 40px;"> {{ artical.content }}</span>
    </div>
    <div style="float: left; margin-top: 10px;">
      <el-button
        v-if="this.userData.id==this.artical.userID"
        type="primary"
        icon="el-icon-edit"
        circle
        @click="toEditComment"
      ></el-button>
      <el-button
        type="success"
        icon="el-icon-star-off"
        circle
      ></el-button>
      <el-button
        v-if="this.userData.id==this.artical.userID"
        type="danger"
        icon="el-icon-delete"
        circle
        @click="deleteMethod"
      ></el-button>
    </div>
  </div>
</template>
<script>
import { getUserWithIdAndType } from '@/api/loginService'
import { deleteCommentById } from '@/api/commentService';

export default {
  name: "artical",
  data () {
    return {
      userData: null,
      avaterUrl: "",
    }
  },
  props: {
    artical: {
      type: Object,
      required: true,
    }
  },
  created () {
    this.userData = JSON.parse(sessionStorage.getItem("userData"))
  },
  computed: {

    // img: function() {
    //     //根据用户id查找图像并返回图片链接
    //     return this.artical.userID
    // },
    // author_name: function(){
    //     //根据用户id返回用户名,未完成
    //     return this.artical.author_id;
    // }
    pasTouser () {
      return "/#/user/" + this.artical.userID + "?userType=" + this.artical.userType;
    }
  },
  watch: {
    artical: {
      handler: async function (newName, oldName) {
        console.log(this.artical)
        var res = (await getUserWithIdAndType(this.artical.userID, this.artical.userType)).data;
        console.log(res)
        this.pasTouser = "/#/user/" + this.artical.userID;
        if (res.code == 200) {
          this.avaterUrl = res.data.avatar;
          console.log("yes")
          console.log(this.avaterUrl)
        }

      }
    }
  },
  methods: {
    toEditComment () {
      window.location.href = '/#/editComment/' + this.artical.id;
    },
    deleteMethod () {
      this.$alert('删除不可恢复，请谨慎操作', '确认删除？', {
        confirmButtonText: '确定',
        callback: action => {
          deleteCommentById(this.artical.id).then(res => {
            console.log(res)
            this.$message({
              type: 'info',
              message: `删除成功`
            });
            location.reload();
          })
        }
      });
    }
  }


}
</script>
<style>
.router-link-active {
  color: blue;
}
.title {
  font-size: 300%;
  font-weight: bold;
  margin-right: 20%;
}
.author {
  margin-top: 10px;
  text-align: left;
  font-size: 200%;
}
.artical_body {
  margin-top: 20px;
  font-size: 150%;
  text-align: left;
  margin-right: 20%;
  min-height: 400px;
  padding: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
</style>