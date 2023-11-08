<template>
  <div style="text-align: left;">
    <el-card style="width: 60%;margin-left: 20%;">
      <div style="">添加您的企业</div>
      <el-form
        label-position="top"
        label-width="80px"
        :model="teamForm"
      >
        <el-form-item label="企业名称">
          <el-input
            v-model="teamForm.name"
            placeholder="请填写企业名称"
          ></el-input>
        </el-form-item>
        <el-form-item label="logo链接">
          <el-input
            v-model="teamForm.logo"
            placeholder="请填写企业logo链接"
          ></el-input>
        </el-form-item>
        <el-form-item label="别名/简称">
          <el-input
            v-model="teamForm.alias"
            placeholder="请填写企业别名"
          ></el-input>
        </el-form-item>
        <el-form-item label="行业">
          <el-input
            v-model="teamForm.industry"
            placeholder="请填写您企业的行业"
          ></el-input>
        </el-form-item>
        <el-form-item label="企业官网">
          <el-input
            v-model="teamForm.link"
            placeholder="请填写企业官网链接"
          ></el-input>
        </el-form-item>
        <el-form-item label="邀请码">
          <el-tooltip
            class="item"
            effect="dark"
            content="默认邀请码为888888"
            placement="top"
          >
            <el-input
              v-model="teamForm.code"
              placeholder="若无邀请码请联系我们"
            ></el-input>
          </el-tooltip>
        </el-form-item>
        <el-form-item size="large">
          <el-button
            type="primary"
            @click="onSubmit"
          >立即创建</el-button>
          <el-button @click="emptyEvent">清空表单</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { addTeam } from '@/api/teamService'
export default {
  data () {
    return {
      teamForm: {

      }
    }
  },
  methods: {
    async onSubmit () {
      console.log(this.teamForm)
      var res = (await addTeam(this.teamForm)).data;
      if (res.code == '200') {
        this.$notify({
          title: '提示',
          message: '企业添加成功！'
        })
        window.location.href = '/'
      } else {
        this.$notify({
          title: '错误',
          message: '邀请码不正确'
        })
      }
    },
    emptyEvent () {
      this.teamForm = {};
    }
  }
}
</script>

<style>
</style>