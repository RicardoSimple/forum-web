<template>
  <div>

    <el-card
      class="box-card"
      style="margin-left: 25%;background-color: #fffdf5;overflow:auto; width: 50%;margin-top: 1.5%"
    >
      <span> 注册账号</span>
      <el-radio
        v-model="userType"
        label="talent_user"
      >个人用户</el-radio>
      <el-radio
        v-model="userType"
        label="team_user"
      >企业用户</el-radio>
      <div v-if="userType=='talent_user'">
        <avue-form
          style="margin-top: 5%"
          ref="form"
          v-model="obj"
          :option="talent_option"
          @reset-change="emptytChange"
          @submit="submit"
        >
        </avue-form>
      </div>
      <div v-else>
        <avue-form
          style="margin-top: 5%"
          ref="form"
          v-model="obj"
          :option="team_option"
          @reset-change="emptytChange"
          @submit="submit"
        >
        </avue-form>
      </div>

      <!-- 注意： 自定义的提交按钮 参数验证无效 -->
      <el-button @click="submit">注册</el-button>
      <span
        src=""
        style="margin-left: 3%;text-align: center ; font-size: 12px"
      >
        <router-link to="/login"><el-button>登录</el-button></router-link>
      </span>
    </el-card>
  </div>
</template>
<script>
import { register } from '@/api/loginService'
import { getAllTeam } from '@/api/teamService'
export default {
  name: "register",
  data () {
    return {
      obj: {},
      userType: 'talent_user',
      teamDicData: [
      ],
      defaultData: {
        userType: "talent_user",
        nickName: null,
        pwd: null,
        avatar: 'https://img1.baidu.com/it/u=589477597,210681775&fm=253&fmt=auto&app=138&f=JPEG?w=607&h=500'
      },
    }
  },
  props: {
    closeDialog: [],
  },
  computed: {
    talent_option () {
      return {
        submitBtn: false,
        emptyBtn: false,
        submitText: '登陆',
        column: [
          {
            label: '昵称',
            prop: 'nickName',
            maxlength: 16,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 昵称",
              trigger: "blur"
            }]
          },
          {
            label: '姓名',
            prop: 'name',
            maxlength: 16,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 姓名",
              trigger: "blur"
            }]
          },
          {
            label: '头像链接',
            prop: 'avatar',
            maxlength: 100,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 头像链接",
              trigger: "blur"
            }]
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
            label: '教育程度',
            prop: 'education',
            maxlength: 18,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 目前最高学历",
              trigger: "blur"
            }]
          },
          {
            label: '工作状态',
            prop: 'status',
            maxlength: 4,
            showWordLimit: true,
            span: 20,
            type: 'select', // 添加这一行
            dicData: [      // 添加下拉选项
              {
                label: '在职',
                value: '在职',
              },
              {
                label: '待业',
                value: '待业',
              },
              {
                label: '在校',
                value: '在校'
              },
              {
                label: '在职但寻找新机会',
                value: '在职但寻找新机会'
              }
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
            label: '密码',
            prop: 'pwd',
            type: "password",
            maxlength: 18,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 密码",
              trigger: "blur"
            }]
          },
          {
            label: '确认密码',
            prop: 'pwd2',
            type: "password",
            maxlength: 18,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 确认密码",
              trigger: "blur"
            }]
          },
        ]
      }
    },
    team_option () {
      return {
        submitBtn: false,
        emptyBtn: false,
        submitText: '登陆',
        column: [
          {
            label: '昵称',
            prop: 'nickName',
            maxlength: 16,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 昵称",
              trigger: "blur"
            }]
          },
          {
            label: '姓名',
            prop: 'name',
            maxlength: 16,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 姓名",
              trigger: "blur"
            }]
          },
          {
            label: '头像链接',
            prop: 'avatar',
            maxlength: 100,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 头像链接",
              trigger: "blur"
            }]
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
            label: '企业职位',
            prop: 'role',
            maxlength: 16,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 职位",
              trigger: "blur"
            }]
          },
          {
            label: '绑定企业',
            prop: 'teamId',
            tip: '输入企业用户或者个人用户',
            maxlength: 4,
            showWordLimit: true,
            span: 20,
            type: 'select', // 添加这一行
            dicData: this.teamDicData,
            rules: [
              {
                required: true,
                message: '请选择用户类型',
                trigger: 'blur',
              },
            ],
          },
          {
            label: '密码',
            prop: 'pwd',
            type: "password",
            maxlength: 18,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 密码",
              trigger: "blur"
            }]
          },
          {
            label: '确认密码',
            prop: 'pwd2',
            type: "password",
            maxlength: 18,
            showWordLimit: true,
            span: 20,
            rules: [{
              required: true,
              message: "请输入 确认密码",
              trigger: "blur"
            }]
          },
        ]
      }
    },
  },
  async created () {
    var res = (await getAllTeam()).data
    console.log(res);
    this.obj = this.defaultData
    var teamList = res.data;
    for (var i = 0; i < res.data.length; i++) {
      this.teamDicData.push({label:teamList[i].name,value:teamList[i].id}) 
    }
  },
  methods: {
    emptytChange () {
      this.closeDialog(false);
    },
    async submit (form) {
      if (this.obj.pwd !== this.obj.pwd2) {
        this.$message.error("两次输入的密码不一致")
        throw new Error("两次输入的密码不一致")
      }
      this.obj.userType = this.userType;
      console.log(this.obj);
      var res = (await register(this.obj)).data;
      console.log(res);
      if (res.code == '200') {
        this.$message.success("注册成功！请重新登录")
        window.location.href = "/#/login"
      } else {
        this.$message.error("注册失败")
      }
    },
  },
  watch: {
  }
}
</script>

<style scoped>
</style>