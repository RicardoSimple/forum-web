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
                    "## 小组信息\n" +
                    "- 第九组\n" +
                    "- 组长:B21031616李亚杰\n" +
                    "- 分工:前端\n" +
                    "- 具体:个人主页\n" +
                    "- 组员:B21031615李正皓\n" +
                    "- 分工:后端\n" +
                    "- 组员:B21031618肖博\n" +
                    "- 分工:前端\n" +
                    "- 组员:B21050426胡清文\n" +
                    "- 分工:后端\n" 
                    
            }
        },

    }
</script>

<style scoped>

</style>