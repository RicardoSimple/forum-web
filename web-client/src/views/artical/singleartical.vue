<template>
    <div class="artical" 
    style="margin-left : 20%;"
    >
      <div class="title">{{ artical.title }}</div>
      <div class="author">
        <el-link :href="this.pasTouser" style="text-decoration: none;color: black;">
            <!--获取用户头像-->
            <el-avatar
                :size="50"
                :src= "avaterUrl"
            ></el-avatar>
            <span >{{ artical.name }}</span>
            <div style="font-size: 15px;margin-top: 10px;">发布时间：{{ artical.gmtCreated }}</div>
        </el-link>
      </div>
      <div class="artical_body">
        <span>  {{ artical.content }}</span>
      </div>
    </div>
</template>
<script>
import { getUserWithIdAndType } from '@/api/loginService'


export default{
    name:"artical",
    data(){
        return {
            avaterUrl:"",
            pasTouser:"",
        }
    },
    props: {
        artical:{
            type:Object,
            required:true,
        }
    },
    computed:{
        
        // img: function() {
        //     //根据用户id查找图像并返回图片链接
        //     return this.artical.userID
        // },
        // author_name: function(){
        //     //根据用户id返回用户名,未完成
        //     return this.artical.author_id;
        // }
    },
    watch:{
        artical:{
            handler: async function(newName,oldName){
                console.log(this.artical)
                var res= (await getUserWithIdAndType(this.artical.userID,this.artical.userType)).data;
                console.log(res)
                this.pasTouser="/#/user/"+this.artical.userID;
                if(res.code==200){
                    this.avaterUrl=res.data.avatar;
                    console.log("yes")
                    console.log(this.avaterUrl)
                }

            }
        }
    }


}
</script>
<style>
.router-link-active{
    color: blue;
}
.title{
    font-size:300%;
    font-weight: bold;
    text-align: left;
    margin-right: 20%;
}
.author{
    margin-top: 10px;
    text-align: left;
    font-size: 200%; 
    
}
.artical_body{
    margin-top: 20px;
    font-size: 150%;
    text-align: left;
    margin-right: 20%;
    
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    
}
</style>