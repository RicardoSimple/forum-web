<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="6"><div>
        <span style="font-size: 20px;"> <router-link
          to="/user/:id/artical"
        >  帖子</router-link> </span>
      </div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple">
        <span style="font-size: 20px;"> <router-link
          to="/home/userhomepage2"
        > 帖子 </router-link> </span>
      </div></el-col>
    </el-row>
    <el-row :gutter="20">
    <el-col :span="24"><div class="grid-content bg-purple"></div></el-col>
    </el-row>
  </div>
</template>
<script>

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