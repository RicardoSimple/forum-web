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
        <router-link to="/register"><el-button>没有账号</el-button></router-link>
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
            label: '用户类型',
            prop: 'userType',
            tip: '输入企业用户或者个人用户',
            maxlength: 4,
            showWordLimit: true,
            span: 20,
            type: 'select', // 添加这一行
            dicData: [      // 添加下拉选项
              {
                label: '企业用户',
                value: 'team_user',
              },
              {
                label: '个人用户',
                value: 'talent_user',
              },
            ],
            rules: [
              {
                required: true,
                message: '请选择用户类型',
                trigger: 'blur',
              },
            ],
          },
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
      var res = ((await login(this.obj)).data)
      if (res.code == 200) {
        console.log("成功")
        this.$message.success("登录成功")
        this.findLoginUser(res.data)
      } else {
        this.$message.error("手机号或密码错误")
      }
    },
    // 获取当前登录账号信息缓存到sessionStorage
    findLoginUser (userData) {
      console.log(userData)
      sessionStorage.setItem("userData", JSON.stringify(userData))
      window.location.href = "/"
    },
  }
}
</script>

<style scoped>
</style>