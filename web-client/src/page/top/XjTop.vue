<template>

  <el-row>

    <!-- 项目名 -->
    <el-col :span="4">
      <div
        class="grid-content bg-purple"
        style="margin-top: 5%;margin-left: 10%;text-align: left;"
      >
        <span style="font-size: 20px;"> <router-link
            style="color: #ff0517"
            to="/"
          > {{projectName}} </router-link> </span>
      </div>
    </el-col>

    <!-- 功能集 -->
    <el-col :span="17">
      <div class="grid-content bg-purple-light">

        <el-menu
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          v-for="(item, i) in funData"
          :index="''+i"
          :key="i"
        >
          <el-menu-item v-if="item.path != null">
            <router-link :to="item.path">{{item.name}}</router-link>
          </el-menu-item>

          <el-submenu v-if="item.children != null">
            <template slot="title">{{item.name}}</template>
            <el-menu-item
              v-for="(itemTwo, j) in item.children"
              :index="i+ '-' + j"
              :key="i+ '-' + j"
            >
              <router-link
                class="funTwo"
                :to="itemTwo.path"
              >{{itemTwo.name}}</router-link>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </div>
    </el-col>
 

    <!-- 登录/登出/用户信息 -->
    <el-col :span="3">
      <div
        class="grid-content bg-purple-light"
        style="height: 60px;line-height:60px; text-align:right;margin-right: 12%"
      >
        <router-link
          style="color: #ff0517"
          v-if="userData==null"
          to="/login"
        > 登录/注册</router-link>

        <span v-if="userData!=null">
          <span> <img
              :src='userData.head'
              style='cursor:pointer;border-radius: 20px;height: 25px;width: 25px'
            ></span>
          <span style="margin-right: 12%;margin-left: 3%">
            {{userData.nickname.length > 3?userData.nickname.substring(0,3)+"..." : userData.nickname}}
          </span>
          <!-- 退出,鼠标移到到该位置变小手 -->
          <span
            style="cursor:pointer;font-size: 12px; color: #ff0517;"
            @click="exitLogin"
          > 退出 </span>
        </span>
      </div>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "XjTop",
  data () {
    return {
      // 选中菜单
      activeIndex: 'second',
      // 项目名
      projectName: "企业论坛系统",
      // 当前登录用户信息
      userData: null,
      // 功能集 (注意这里方向是从右到左)
      funData: [
        // {
          // path: null,
          // name: "相关文档",
          // children: [
            {
              path: "/test/c",
              name: "本项目文档",
              children: null
            },
            {
              path: "/test/d",
              name: "作者信息",
              children: null
            },
          // ]
        // },
        // {
        //   path: "/test/b",
        //   name: "工具服务",
        //   children: null
        // },
        // {
        //   path: "/test/a",
        //   name: "接口测试",
        //   children: null
        // },
      ]
    }
  },
  methods: {
    handleSelect () {

    },
    exitLogin () {
      sessionStorage.removeItem("TOKEN");
      sessionStorage.removeItem("userData");
      this.$message.success("退出成功");
      window.location.href = "/"
    }
  },
  created () {
    console.log("判断用户信息是否存在,控制展示用户信息还是展示头像")
    this.userData = JSON.parse(sessionStorage.getItem("userData"))
    console.log("当前用户信息:", this.userData)
  },
}
</script>

<style scoped>
/* 功能靠右  */
.el-menu {
  float: right;
  margin-right: 0%;
}

a {
  text-decoration: none !important; /* 去掉下划线 */
}

/* 二级菜单a连接导致颜色错误修正 */
.funTwo {
  color: #85888e;
}

.funTwo:hover {
  color: #303133;
}

/*a:link {*/
/*    color: #909399 !important; !*未访问的链接颜色*!*/
/*}*/

/*a:visited {*/
/*    color: #0F180F !important; !*已访问的链接颜色*!*/
/*}*/

/*a:hover {*/
/*    color: #0f180f !important; !*鼠标移动到链接的颜色*!*/
/*    text-decoration: underline;*/
/*}*/

/*a:active {*/
/*    color: #ff6827 !important; !*鼠标点击时的颜色*!*/
/*}*/
</style>

