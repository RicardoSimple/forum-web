<template>
    <div class="user-bottom" style="height: 60px;">
        <div class="links">
            <span>
                <router-link to="/test/d" style="text-decoration: none;color:black;">关于我们</router-link>
                &nbsp;
                <router-link to="/test/d" style="text-decoration: none;color:black;">意见反馈 </router-link>
                &nbsp;
                <router-link to="/test/c" style="text-decoration: none;color:black;">免责声明</router-link>
                &nbsp;
                <router-link to="/test/c" style="text-decoration: none;color:black;">资源导航</router-link>
                </span>
        </div>
        
    </div>

</template>

<script>
    export default {
        name: "XjBottom.vue"
    }
</script>


<style scoped>
    /*.user-bottom{*/
    /*    position:fixed;*/
    /*    bottom: 0;*/
    /*    left: 40%;*/
    /*}*/
    a.links{
        text-align: center;
        color: black;
        text-decoration: none;
        list-style-type: none;
    }
    div.links{
        height: 10px;
    }
    li{list-style-type:none;
        text-decoration: none;
    }
</style>