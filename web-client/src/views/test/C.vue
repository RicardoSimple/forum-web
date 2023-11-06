<template>
    <div>
        <H2> client </H2>
        <H5>这里提供该项目 demo 的基础用法</H5>
        <br>
        <el-card class="box-card" style="margin-left: 25%;background-color: #FFFFFF;overflow:auto; width: 50%;">

            <span style="text-align: left">
                <div>一、目前已完成功能:</div>
                <br/>
                 <li> 1、顶/中/底部分离 </li>
                 <li> 2、顶部菜单 自定义 </li>
                 <li> 3、首页 定义 </li>
                 <li> 3、项目名 定义 </li>
                 <li> 4、router 路由跳转 </li>
                 <li> 5、axios 请求封装 </li>
                 <li> 6、axios 请求响应拦截器 </li>
                 <li> 7、注册/登录</li>
            </span>
        </el-card>
        <br/>
        <el-card class="box-card" style="margin-left: 25%;background-color: #FFFFFF;overflow:auto; width: 50%;">
            <span style="text-align: left">
                <div>二、采用技术:</div>
                <br/>
                 <li> 1、vue2 </li>
                 <li> 2、element2.x </li>
                 <li> 3、avue2.9.4 </li>
            </span>
        </el-card>
        <br/>
        <el-card class="box-card" style="margin-left: 25%;background-color: #FFFFFF;overflow:auto; width: 50%;">
            <span style="text-align: left">
                <div>三、目录结构:</div>
                <br/>
                 <li> src/page  - 顶部底部 </li>
                 <li> ---------- bottom.vue  - 底部信息 </li>
                 <li> ---------- top.vue  - 顶部信息 </li>
                   <br/>
                 <li> src/router  - 路由 </li>
                 <li> ---------- axios.js  - 请求响应拦截器 </li>
                 <li> ----------- index.js  - 路由配置 </li>
                   <br/>
                 <li> src/util   - 请求工具 </li>
                 <li> ----------- crud.js  - 请求工具封装 </li>
                   <br/>
                 <li> src/views  - 功能页面 </li>
                 <li>----------- home    首页  </li>
                 <li>----------- login   登录/注册  </li>
                 <li>----------- test    测试页,顶部菜单点击的所有页面  </li>
                   <br/>
                   <li>src/App.vue    - 项目入口  </li>
                   <li>src/main.js    - 项目核心依赖配置  </li>
                   <li>vue.config.js  - 项目服务信息  </li>
            </span>

        </el-card>
        <br/>
        <el-card class="box-card" style="margin-left: 25%;background-color: #FFFFFF;overflow:auto; width: 50%;">
            <span style="text-align: left">
                <div>四、请求工具  util.crud.js , 任意vue文件中使用</div>
                  <br/>
                <div>uri = 接口地址</div>
                  <pre>

        // get 请求
        this.crud.get(uri,params参数).then((res) => {
              // 响应数据
        })

        // post 请求
        this.crud.post(uri, data参数, params参数).then((res) => {

        })

        // put 请求
        this.crud.put(uri, data参数, params参数).then((res) => {

        })

        // del 请求
        this.crud.del(uri, data参数,params参数).then((res) => {

        })

        // 文件上传 (建议上传接口定义配置文件固定,然后在 crud.js 中读取)
        this.crud.del(upload, path上传接口).then((res) => {

        })

        // 文件下载
        this.crud.del(uri, data参数).then((res) => {

        })
                  </pre>
            </span>
        </el-card>
        <br/>
        <el-card class="box-card" style="margin-left: 25%;background-color: #FFFFFF;overflow:auto; width: 50%;">
            <span style="text-align: left">
                <div>五、登录注册</div>
                  <br/>
                <div> 1、该功能接口目前登录接口模拟对接的 tool 项目</div>
                  <br/>
                  <div>2、当前登录成功后 获取用户信息到 sessionStorage 缓存中 </div>
                  <br/>
                  <div> 缓存数据如下 , 详见 views/login/login.vue 文件</div>
                  <pre>
        let userData = {
           username: res.data.data.username, //账号
           nickname: res.data.data.nickname, // 昵称
           // fullName: res.data.data.fullName, // 姓名
           head: res.data.data.head, // 头像
        };
                  </pre>
                <div> 重新进入项目会获取用户信息判断是否登录来展示右上角信息 (展示用户信息 还是 登录按钮) </div>


                <br/>
               <div>  3、token 处理是在 router.axios.js 中 </div>
                <br/>
               <div>  由于我的接口 token 是通过响应头返回的  </div>
               <div>  响应获取响应头中的 token 存入 sessionStorage  </div>
               <div>  请求获取sessionStorage 的 token 放入请求头  </div>

            </span>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "C",
        data() {
            return {
                userDetails: ""
            }
        },

    }
</script>

<style scoped>

</style>