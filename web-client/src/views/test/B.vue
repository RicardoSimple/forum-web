<template>
    <div>
        <div>工具服务</div>
        <div> <span>v1版本地址: </span> <a href="http://v1.tool.xijia.plus/user" target="_blank">http://v1.tool.xijia.plus/user</a></div>
        <br/>
        <div>

            <el-row style=" width: 100%;">
                <el-col :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>json 格式化</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span>
                    </el-card>
                </el-col>
                <el-col :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>websocket 在线测试</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span>
                    </el-card>
                </el-col>
                <el-col :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>cron生成器</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span></el-card>
                </el-col>
                <el-col :xs="6" :sm="6" :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>base64编码/解码</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span></el-card>
                </el-col>
            </el-row>
            <el-row style="left: 0%; top: 2%; width: 100%;margin-top: 2%">
                <el-col :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>开发工具下载</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span></el-card>
                </el-col>
                <el-col :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>jwt 解析</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span></el-card>
                </el-col>
                <el-col :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>汉字转拼音</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span></el-card>
                </el-col>
                <el-col :xs="6" :sm="6" :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>时间转换工具</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span></el-card>
                </el-col>
            </el-row>
            <el-row style="left: 0%; top: 2%; width: 100%;margin-top: 2%">
                <el-col :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>java 在线代码运行器</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span></el-card>
                </el-col>
                <el-col :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>js 在线代码运行器</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span></el-card>
                </el-col>
                <el-col :span="6">
                    <el-card>
                        <div slot="header" class="clearfix">
                            <span>html 在线代码运行器</span>
                            <el-button style="float: right; padding: 3px 0" type="text">敬请期待</el-button>
                        </div>
                        <span v-html="cardData"></span></el-card>
                </el-col>

            </el-row>
        </div>
    </div>
</template>

<script>
    export default {
        name: "B",
        data() {
            return {
                cardData: "<span style='font-size: 12px'>待定功能， 敬请期待<br/>  <br/> 上线时间: 2022-06-19 <br/> <span> "
            }
        },

    }
</script>

<style scoped>
    .el-card {
        max-width: 96%;
        margin-left: 1%;
        text-align: left;
    }

</style>