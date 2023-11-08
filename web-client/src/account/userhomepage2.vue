<template>
  <div>
    <div class="information">
      <div>
        
      </div>

    </div>
    <el-row :gutter="20">
      <el-col :span="6"><div>
        <span style="font-size: 20px;"> <router-link
          to=""
        >  帖子</router-link> </span>
      </div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple">
        <span style="font-size: 20px;"> <router-link
          to="pasTojob"
          v-if="this.userType==='team_user'"
        > 招聘岗位 </router-link> </span>
      </div></el-col>
    </el-row>
    <el-row :gutter="20">
    <el-col :span="24"><div class="grid-content bg-purple"></div></el-col>
    </el-row>
  </div>
</template>
<script>
import {getUserWithIdAndType} from '../api/loginService'
export default{
  compute:{
    pasTojob(){
      return "/#/user/"+this.userData.id+"/createdjob"+this.userData.id+"?userType="+this.userData.userType;
    },
    pasToartical(){
      return this.$route;
    }
  },
  async created(){
    console.log(this.$route)
    this.userId=this.$route.params.id
    this.userType=this.$route.query.userType
    console.log(this.userType)
    console.log(this.userId)
    this.userData=(await getUserWithIdAndType(this.userId,this.userType)).data
    console.log(this.userData)
   
  },
  data(){
    return{
      userData:null,
      userId:null,
      userType:null,
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
/* .bg-purple-dark {
  background: #99a9bf;
} */
.bg-purple {
  background: #d3dce6;
}
/* .bg-purple-light {
  background: #e5e9f2;
} */
/* .grid-content {
  border-radius: 4px;
  min-height: 36px;
} */
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>