<template>
  <div>

    <el-card
      class="box-card"
      style="margin-left: 25%;background-color: #fffdf5;overflow:auto; width: 50%;margin-top: 1.5%"
    >
      <span> 登录 企业论坛系统</span>
      <avue-form
        style="margin-top: 5%"
        ref="form"
        v-model="obj"
        :option="option"
        @reset-change="emptytChange"
        @submit="submit"
      >
      </avue-form>

      <!-- 注意： 自定义的提交按钮 参数验证无效 -->
      <el-button @click="submit">登录</el-button>
      <span
        src=""
        style="margin-left: 3%;text-align: center ; font-size: 12px"
      >
        <router-link to="/register">没有账号</router-link>
      </span>
    </el-card>
  </div>
</template>
<script>
import router from '@/router'
import { login } from '@/api/loginService'

export default {
  name: "login",
  data () {
    return {
      obj: {},
      defaultData: {
        userType: "talent_user",
        phone: null,
        pwd: null,
      },
    }
  },
  props: {
    closeDialog: [],
  },
  computed: {
    option () {
      return {
        submitBtn: false,
        emptyBtn: false,
        submitText: '登陆',
        column: [
          {
            label: '手机号',
            prop: 'phone',
            maxlength: 12,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 手机号",
              trigger: "blur"
            }]
          },
          {
            label: '密码',
            prop: 'pwd',
            type: 'password',
            maxlength: 18,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 密码",
              trigger: "blur"
            }]
          },
        ]
      }
    }
  },
  created () {
    this.obj = this.defaultData
  },
  methods: {
    emptytChange () {
      this.closeDialog(false);
    },
    async submit () {
      if ((await login(this.defaultData)).data.code == 200) {
        console.log("成功")
      }
    },
    // 获取当前登录账号信息缓存到sessionStorage
    findLoginUser () {
      this.crud.get("/api/client/tool/toolUser/findLoginUser").then(res => {
        let userData = {
          username: res.data.data.username, //账号
          nickname: res.data.data.nickname, // 昵称
          fullName: res.data.data.fullName, // 姓名
          head: res.data.data.head, // 头像
        };
        sessionStorage.setItem("userData", JSON.stringify(userData))
        window.location.href = "/"
      })
    },


  }
}
</script>

<style scoped>
</style>