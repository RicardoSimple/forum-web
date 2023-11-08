<template>
    <div style="margin-left: 10%;margin-right: 10%;">
      <div class="currentUser" style="">
        <span> <img
              :src='userData.head'
              style='cursor:pointer;border-radius: 50%;height: 50px;width: 50px'
            ></span> 
          <span style="margin-right: 12%;margin-left: 3%">
            {{userData.nickName}}
          </span>
      </div>
      <el-row :gutter="20">
        <el-col :span="6"><div class="grid-content bg-purple">
          <span style="font-size: 20px;"> <router-link
            to="/currentUser/myartical"
            style="text-decoration: none;"
          > 帖子 </router-link> </span>
        </div></el-col>
        <el-col :span="6" v-if="this.userData.userType==='talent_user'"><div>
          <span style="font-size: 20px;"> <router-link
            to="/currentUser/myjob"
            style="text-decoration: none;"
          > 已投岗位 </router-link> </span>
        </div></el-col>
        <el-col :span="6" v-if="this.userData.userType==='team_user'"><div>
          <span style="font-size: 20px;"> <router-link
            to="/currentUser/myCreatedjob"
            style="text-decoration: none;"
          > 在招岗位 </router-link> </span>
        </div></el-col>
      </el-row>
      <el-row :gutter="20">
      <el-col :span="24"><div class="grid-content bg-purple">
        <router-view></router-view>
      </div></el-col>
      </el-row>
    </div>
</template>
<script>
export default{
  name:'userpage',
  data(){
    return{
      userData:null,
    }

  },
  created(){
    this.userData=JSON.parse(sessionStorage.getItem("userData"))
  }
}
</script>
<style>
.currentUser{
  text-align: left;
  height: 100px;

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