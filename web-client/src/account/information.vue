<template>
  <div style="padding: 10px; margin-bottom: 10px;">
    <el-card
      class="box-card"
      shadow="hover"
      body-style="{ padding:'0px' }"
    >
      <el-form
        ref="form"
        :disabled="formDisable"
        label-width="80px"
      >
        <div>
          <el-avatar
            :size="100"
            :src="userData.avatar"
            shape="square"
            style="margin-bottom: 5px;"
          ></el-avatar>
        </div>
        <el-form-item label="头像链接"><el-input
            v-model="userData.avatar"></el-input></el-form-item>
        <el-form-item label="名字"><el-input
            v-model="userData.name"></el-input></el-form-item>
        <el-form-item label="手机号"><el-input
            v-model="userData.phone"></el-input></el-form-item>
        <el-form-item label="昵称"><el-input
            v-model="userData.nickName"></el-input></el-form-item>
        <el-form-item label="邮箱"><el-input
            v-model="userData.email"></el-input></el-form-item>
        <el-form-item
          v-if="userData.role!=null"
          label="职位"
        ><el-input v-model="userData.role"></el-input></el-form-item>
      </el-form>
      <div v-if="sameUser()">
        <el-button
          type="primary"
          icon="el-icon-edit"
          @click="editEvent"
        >编辑</el-button>
        <el-button
          type="primary"
          :disabled="formDisable"
          @click="onSubmit"
        >修改</el-button>
        <el-button @click="cancelEvent">取消</el-button>
        <el-button
          type="danger"
          @click="editPwdEvent"
        >修改密码</el-button>
        <el-button
          type="danger"
          @click="forgetPwdEvent"
        >忘记密码</el-button>
      </div>
    </el-card>
  </div>
</template>
<script>
import { getUserWithIdAndType, updateUserByUserType } from '@/api/loginService'
export default {
  name: 'Information',
  async created () {
    var res = (await getUserWithIdAndType(this.id, this.userType)).data
    console.log(res)
    this.userData = res.data
    this.initData = { ...res.data }
    this.currentUser = JSON.parse(sessionStorage.getItem("userData"))
  },
  data () {
    return {
      userData: null,
      formDisable: true,
      initData: {},
      currentUser: null
    }
  },
  props: { id: { type: String }, userType: { type: String } },
  methods: {
    async onSubmit () {
      console.log('submit!');
      console.log(this.userData)
      var res = (await updateUserByUserType(this.userData, this.userType)).data
      if (res.code == '200') {
        this.$notify({
          title: '提示',
          message: '用户信息修改成功！'
        })
        location.reload()

      }
    },
    editEvent () {
      this.formDisable = false;
    },
    cancelEvent () {
      this.userData = { ...this.initData }
      this.formDisable = true;
    },
    sameUser () {
      if (this.currentUser != null && this.currentUser.phone != null && this.currentUser.phone == this.initData.phone) {
        if (this.userType == "talent_user") {
          return this.currentUser.nickName == this.initData.nickName && this.currentUser.id == this.initData.id;
        } else {
          return this.currentUser.teamId != null && this.currentUser.teamId == this.initData.teamId;
        }
      }
      return false;
    },
    editPwdEvent () {
      this.$alert('请联系管理员!', '修改密码', {
        confirmButtonText: '确定',
      });
    },
    forgetPwdEvent () {
      this.$alert('请联系管理员!', '忘记密码', {
        confirmButtonText: '确定',
      });
    }
  },
  computed: {
    toSubmit () {
      return this.userData == this.initData
    }
  }
}
</script>