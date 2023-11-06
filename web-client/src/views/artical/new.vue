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
            <el-button>清空</el-button>
        </div>
    </el-card>
    </div>
</template>
<script>
export default{
    name :"new_artical",
    data(){
        return{
            obj:{},
            defaultData:{
                artical_id: 1234,   //帖子id
                author_id: null, //作者id
                title: null,
                body: null,
            },
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
                        prop: 'ititle',
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
                        prop:'body',
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
    }   
}

</script>