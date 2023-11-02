<template>
    <div>

        <el-card class="box-card" style="margin-left: 25%;background-color: #fffdf5;overflow:auto; width: 50%;margin-top: 1.5%">
            <span> 注册账号</span>
            <avue-form style="margin-top: 5%" ref="form" v-model="obj" :option="option"
                       @reset-change="emptytChange"
                       @submit="submit">

                <template slot-scope="{}" slot="email">
                    <div>
                        <el-input style="float:left;width: 70%" v-model="obj.email" placeholder="请输入邮箱"></el-input>
                        <el-button style="float:left;margin-left: 2%" @click="sendEmailCode">发送验证码</el-button>
                    </div>

                </template>
            </avue-form>

            <!-- 注意： 自定义的提交按钮 参数验证无效 -->
            <el-button @click="submit">注册</el-button>
            <span src="" style="margin-left: 3%;text-align: center ; font-size: 12px">
                <router-link to="/login">登录</router-link>
             </span>
        </el-card>
    </div>
</template>
<script>
    import router from '@/router'
    export default {
        name: "register",
        data() {
            return {
                obj: {},
                defaultData: {
                    username: null,
                    password: null,
                },
                uri: {
                    sendEmailAuthCode: "/api/client/tool/toolUser/sendEmailAuthCode",
                    register: "/api/client/tool/toolUser/register",
                },
            }
        },
        props: {
            closeDialog: [],
        },
        computed: {
            option() {
                return {
                    submitBtn: false,
                    emptyBtn: false,
                    submitText: '登陆',
                    column: [
                        {
                            label: '昵称',
                            prop: 'nickname',
                            maxlength: 16,
                            showWordLimit: true,
                            span: 20,
                            rules: [{
                                required: true,
                                message: "请输入 昵称",
                                trigger: "blur"
                            }]
                        },
                        {
                            label: '邮箱',
                            prop: 'email',
                            maxlength: 32,
                            showWordLimit: true,
                            span: 20,
                            rules: [{
                                required: true,
                                message: "请输入 邮箱",
                                trigger: "blur"
                            }]
                        },
                        {
                            label: '邮箱验证',
                            prop: 'emailCode',
                            maxlength: 6,
                            showWordLimit: true,
                            span: 20,
                            rules: [{
                                required: true,
                                message: "请输入 邮箱验证码",
                                trigger: "blur"
                            }]
                        },
                        {
                            label: '账号',
                            prop: 'username',
                            tip: '输入邮箱后自动获取@符号前的对应的账号或手机号填入',
                            disabled: true,
                            maxlength: 32,
                            showWordLimit: true,
                            span: 20,
                            rules: [{
                                required: true,
                                message: "账号",
                                trigger: "blur"
                            }]
                        },
                        {
                            label: '密码',
                            prop: 'password',
                            type: "password",
                            maxlength: 18,
                            showWordLimit: true,
                            span: 20,
                            rules: [{
                                required: true,
                                message: "请输入 密码",
                                trigger: "blur"
                            }]
                        },
                        {
                            label: '确认密码',
                            prop: 'passwordTwo',
                            type: "password",
                            maxlength: 18,
                            showWordLimit: true,
                            span: 20,
                            rules: [{
                                required: true,
                                message: "请输入 确认密码",
                                trigger: "blur"
                            }]
                        },
                    ]
                }
            }
        },
        created() {
            this.obj = this.defaultData
        },
        methods: {
            emptytChange() {
                this.closeDialog(false);
            },
            sendEmailCode() {
                this.crud.post(this.uri.sendEmailAuthCode, null, {email: this.obj.email}).then((res) => {
                    // 处理发送按钮，60秒倒计时，先不管
                })
            },
            submit(form) {
                if (this.obj.password !== this.obj.passwordTwo) {
                    this.$message.error("两次输入的密码不一致")
                    throw new Error("两次输入的密码不一致")
                }

                this.crud.post(this.uri.register, this.obj).then((res) => {
                    // 注册成功跳登录界面
                    router.push({path: "/login"});
                })
            },
        },
        watch: {
            // newNum = 新值，旧值
            "obj.email": function (newNum, oldNum) {
                console.log(newNum)
                if (newNum != null && newNum.indexOf("@") != -1) {
                    let index = newNum.indexOf("@");
                    this.obj.username = newNum.substring(0, index);
                } else {
                    this.obj.username = null;
                }
            }
        }
    }
</script>

<style scoped>

</style>