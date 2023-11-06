<template>
    <div class="artical" 
    style="margin-left : 10%;"
    >
      <div class="title">{{ artical.title }}</div>
      <div class="author">
        <router-link to="/home/userhomepage1" style="text-decoration: none;color: black;">
            <!--获取用户头像-->
            <el-avatar
                :size="50"
                :src= "img"
            ></el-avatar>
            <span> {{ artical.author_name }}</span>
            <span style="font-size: 15px;">发布时间：{{ artical.gmtCreated }}</span>
        </router-link>
      </div>
      <div class="artical_body">
        <span>  {{ artical.body }}</span>
      </div>
    </div>
</template>
<script>
export default{
    name:"artical",
    props: {
        artical:{
            type:Object,
            required:true,
        }
    },
    computed:{
        
        img: function() {
            //根据用户id查找图像并返回图片链接
            return this.artical.author_id;
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
    margin-right: 10%;
}
.author{
    margin-top: 10px;
    text-align: left;
    font-size: 200%; 
    
}
.artical_body{
    margin-top: 10px;
    font-size: 150%;
    text-align: left;
    margin-right: 10%;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)

}
</style>