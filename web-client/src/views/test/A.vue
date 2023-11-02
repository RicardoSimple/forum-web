<template>
    <div>
        <div>接口请求测试</div>
        <div>下方是请求接口返回的数据，接口信息详见代码 或 F12控制台查看</div>
         <br/>
        <el-card class="box-card" style="margin-left: 20%;background-color: #FFFFFF;overflow:auto; width: 60%;">
            <span style="text-align: left">  <pre>  {{ data}}</pre> </span>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "A",
        data() {
            return {
                data: null
            }
        },
        created() {
            // http://manage.xijia.plus/api/api/client/sys/banner/list/1
            console.log("加载A页面, 获取接口数据测试")
            this.crud.get("/api/client/sys/banner/list/1").then(res => {
                this.data = res.data.data;
            })
        },
        methods: {},
    }
</script>

<style scoped>

</style>