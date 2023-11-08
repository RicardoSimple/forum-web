<template>
    <div>
        <el-card
        class="box-card"    
        shadow="hover"
        body-style="{ padding:'0px' }"  
        >
        <el-form ref="form" :model="form" label-width="80px">
            <div>
            <el-avatar
            :size="50"
            :src="userData.avatar"
            ></el-avatar>
            </div>
            <el-form-item label="头像链接"><el-input v-model="userData.avatar"></el-input></el-form-item>
            <el-form-item label="名字"><el-input v-model="userData.name"></el-input></el-form-item>
            <el-form-item label="手机号"><el-input v-model="userData.phone"></el-input></el-form-item>
            <el-form-item label="昵称"><el-imput v-model="userData.nickNamme"></el-imput></el-form-item>
            <el-form-item label="邮箱"><el-input v-model="userData.email"></el-input></el-form-item>
        </el-form>
        <el-button type="primary" @click="onSubmit">修改</el-button>
        <el-button>取消</el-button>
        </el-card>
    </div>
</template>
<script>
import { getUserWithIdAndType } from '@/api/loginService'
export default{
    name:'Information',
    async created(){
        var id=this.$route.params.id
        var userType=this.$route.query.userType
        var res=(await getUserWithIdAndType(id,userType)).data
        console.log(res)
        this.userData=res.data
    },
    data(){
        return{
            userData:null,
        }
    },
    methods: {
      onSubmit() {
        console.log('submit!');

      }
    }
}
</script>