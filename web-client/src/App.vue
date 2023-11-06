<template>
    <div id="app">
        <div style="height: 1000px;">
            <!-- 顶部 -->
            <XjTop :key="new Date().getTime()"></XjTop>

            <!-- 路由页面 -->
            <el-card class="box-card" style="margin-left: 1%;background-color: #FFFFFF;overflow:auto; width: 98%;">
                <router-view/>
            </el-card>

            <!-- 底部 -->
            <el-card class="box-card" style="margin-left: 1%;background-color: #FFFFFF;width: 98%;height: 300px; margin-top: 1%;">
                <XjBottom></XjBottom>
            </el-card>
            <GlobalLoginListener />
        </div>
    </div>
</template>


<script>

    //引入组件
    import XjTop from './page/top/XjTop';
    import XjBottom from './page/bottom/XjBottom';
    import GlobalLoginListener from './components/GlobalLoginListener.vue'; // 导入全局组件

    export default {
        name: "app",
        //定义组件
        components: {
            XjTop: XjTop,
            XjBottom: XjBottom,
            GlobalLoginListener
        }
    }


</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }

    nav {
        padding: 30px;
    }

    nav a {
        font-weight: bold;
        color: #2c3e50;
    }

    nav a.router-link-exact-active {
        color: #42b983;
    }
</style>
