<template>
    <div>
        <div>作者信息</div>
        <br>

        <el-card class="box-card" style="margin-left: 25%;background-color: #FFFFFF;overflow:auto; width: 50%;">
            <span style="text-align: left">
                <pre>
                    {{userDetails}}
                </pre>
            </span>
        </el-card>

    </div>
</template>

<script>
    export default {
        name: "C",
        data() {
            return {
                userDetails: "\n" +
                    "## 基础信息\n" +
                    "- 姓名：保密\n" +
                    "- 艺名：兮家小二（叫我小二就好了）\n" +
                    "- 作者qq:  1720696548 \n" +
                    "- 作者微信: 1720696548 \n" +
                    "- 出生地：四川宜宾叙州区 (具体地址保密)\n" +
                    "- 现居：四川成都\n" +
                    "- 当前工作公司：保密\n" +
                    "- 当前职业：java 开发工程师\n" +
                    "- 职业年限：2018年-至今\n" +
                    "- 作者 csdn 地址：https://blog.csdn.net/qq_41463655\n" +
                    "- 作者 码云地址：https://gitee.com/wslxm \n" +
                    "- 作者 bilbil 用户名：兮家小二\n" +
                    "\n" +
                    "## 性格爱好\n" +
                    "- 喜欢动漫，不太喜欢看电视剧，喜欢周星驰的电影，喜欢希腊,北欧等神话,灾难篇等电影\n" +
                    "- 喜欢专研技术，不喜欢勾心斗角，不喜欢管理 (管不好自己,emmm....)\n" +
                    "- 喜欢单机游戏( 没时间玩，也没设备，emmm....)， 偶尔玩玩王者荣耀等游戏\n" +
                    "- 喜欢下雨天\n" +
                    "- 喜欢风景好的地方，以及可爱的人\n"
            }
        },

    }
</script>

<style scoped>

</style>