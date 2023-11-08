<template>
    <div>
    <el-card
      class="box-card"
      style="margin-left: 15%;background-color:white;overflow:auto; width: 75%;margin-top: 1.5%"
    >
        <avue-form
        style="margin-top: 5%"
        ref="form"
        v-model="obj"
        :option="option"
        @reset-change="emptytChange"
        @submit="submit"
        ></avue-form>
        <div>
            <el-button @click="submit">发布</el-button>
            <el-button @click ="clearanything">清空</el-button>
        </div>
    </el-card>
    </div>
</template>
<script>
import {addOrUpdateComment} from '@/api/commentService'
export default{
    name :"new_artical",
    data(){
        return{
            obj:{},
            defaultData:{
                name:null,
                userID:null,
                userType:null,
                title:null,
                content:null,
            },
            userData:null,
        }
    },
    props:{
        closeDialog: [],
    },
    computed:{
        option(){
            return{
                submitBtn:false,
                emptyBtn:false,
                submitText:'确认保存',
                
                column:[
                    {
                        label:'标题',
                        prop: 'title',
                        type: 'textarea',
                        span:23,
                        minRows: 2,
                        maxRows: 3,
                        maxlength: 20,
                        showWordLimit: true,
                        rules:[{
                            required:true,
                            message:'请输入标题',
                            
                        }]
                        
                    },
                    {
                        label:'正文',
                        prop:'content',
                        type:'textarea',
                        span:23,
                        minRows:20,
                        maxlength:1000,
                        showWordLimit:true,
                        rules:[{
                            required:true,
                            message:'请输入正文'
                        }
                        ]
                    },
                    
                ]

            }
        }
    },
    created () {
        this.userData=JSON.parse(sessionStorage.getItem("userData")),
        console.log(this.userData),
        this.defaultData.userType=this.userData.userType,
        this.defaultData.name=this.userData.nickName,
        this.defaultData.userID=this.userData.id;
        this.obj = this.defaultData
    },
    methods:{

        async submit(){
            
            console.log(this.obj);
            
            var res = ((await addOrUpdateComment(this.obj)).data);
            console.log(res);
            if(res.code== '200'){
                this.$message.success("帖子发布成功！")
            }
            else if(res.code=="312"){
                this.$message.error("未登录")
            }
            else {
                this.$message.error("帖子发布失败，请重新尝试")
            }

        },
        clearanything(){
            this.obj=null;
            this.defaultData=null;
            this.$ref.form.resetForm();
        }
    }
}

</script>