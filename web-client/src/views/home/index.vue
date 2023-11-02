<template>
  <div>
    <H3>
      欢迎来到 企业论坛系统
    </H3>
    <H5>
      这里提供了
      | 工具服务
      | 通用快速开发平台 spring-boot-plus2
      | 开源项目
      | 个人作品展示
      | 其他更多
    </H5>
    <H5>
      spring-boot-plus2 码云地址：<a
        href="https://gitee.com/wslxm/spring-boot-plus2">https://gitee.com/wslxm/spring-boot-plus2</a>
    </H5>
    <H5>
      xj-client 码云地址：<a
        href="https://gitee.com/wslxm/xj-client">https://gitee.com/wslxm/xj-client</a>
    </H5>
    <H5>
      QQ 交流群：1037211892
    </H5>

    <avue-data-card :option="option"></avue-data-card>
  </div>
</template>

<script>
export default {
  // name: "home"
  data () {
    return {
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
}

</script>





<style scoped>
</style>