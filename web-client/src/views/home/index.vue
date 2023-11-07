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
      <el-aside width="400px">Aside</el-aside>
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
      option: {
        span: 4,
        data: [
          {
            click: function (item) {
              //alert(JSON.stringify(item));
            },
            name: '后宫1',
            src: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/20586235-1(1).jpeg',
            text: '这个你爱了嘛',
            href: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/20586235-1(1).jpeg',
            target: '_blank'
          },
          {
            click: function (item) {
              alert(JSON.stringify(item));
            },
            name: '后宫2',
            src: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/34014438-1(2).jpeg',
            text: '这个你爱了嘛',
            href: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/34014438-1(2).jpeg',
            target: '_blank'
          },
          {
            click: function (item) {
              alert(JSON.stringify(item));
            },
            name: '后宫3',
            src: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/43521695-1(3).jpeg',
            text: '这个你爱了嘛',
            href: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/43521695-1(3).jpeg',
            target: '_blank'
          },
          {
            click: function (item) {
              alert(JSON.stringify(item));
            },
            name: '后宫4',
            src: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/52753830-1(4).jpeg',
            text: '这个你爱了嘛',
            href: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/52753830-1(4).jpeg',
            target: '_blank'
          },
          {
            click: function (item) {
              alert(JSON.stringify(item));
            },
            name: '后宫5',
            src: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/01131452-1(5).jpeg',
            text: '这个你爱了嘛',
            href: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/01131452-1(5).jpeg',
            target: '_blank'
          },
          {
            click: function (item) {
              alert(JSON.stringify(item));
            },
            name: '后宫6',
            src: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/08769453-1(6).jpeg',
            text: '这个你爱了嘛',
            href: 'http://xijia-sz.oss-cn-shenzhen.aliyuncs.com/oss/file/file/gc/08769453-1(6).jpeg',
            target: '_blank'
          },
        ]
      },
    }
  },
  created () {

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
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
</style>