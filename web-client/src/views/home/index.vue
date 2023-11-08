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
      <el-aside width="400px">
        <el-card v-if="userData!=null" class="aside-card">
          <div
            slot="header"
            class="clearfix"
          >
            <span>操作卡片</span>
            <el-button
              style="float: right; padding: 3px 0"
              type="text"
            >操作按钮</el-button>
          </div>
        </el-card>
      </el-aside>
    </el-container>

  </div>
</template>

<script>
export default {
  // name: "home"
  data () {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      userData: null
    }
  },
  created () {
    console.log("判断用户信息是否存在,控制展示用户信息还是展示头像")
    this.userData = JSON.parse(sessionStorage.getItem("userData"))
    console.log("当前用户信息:", this.userData)
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath);
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
  height: 400px;
  position: sticky;
}
</style>