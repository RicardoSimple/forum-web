<template>
    <div>
        <el-header >
            <div class="title">
                <h3>
                标题
                </h3>
            </div>
        </el-header>
        <el-main>
            <div class="author" style="text-align: left;font-size: 120%;">
                张三
            </div>
            <div class="artical_body">
                <p style ="text-align: left;font-size: 120%;">
                我是文章
                </p>
            </div>
        </el-main>
    </div>
</template>
<script>
import router from '@/router'
export default{
    name:"artical"

}
</script>
<style>
.title{
    font-size:35px;
}

.articcal_body{
    font-size: 35px;
    text-align: left;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)

}
</style>