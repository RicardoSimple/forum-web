<template>
    <div class="new_job">
        <el-card
        class="box-card"
        style="margin-left: 15%;background-color:white;overflow:auto; width: 75%;margin-top: 1.5%"
        >
            <avue-form 
            style="margin-top: 5%;"
            ref="form"
            v-model="obj"
            :option="option"
            ></avue-form>
            <div class="tags" style="position:relative;margin-left:45px   ">
                <label style="margin-right: 10px;">标签:</label>
                <el-tag 
                v-for="tag in defaultData.tags"
                closable
                :disable-transitions="false" 
                @close="handleClose(tag)"
                :key="tag.name">{{ tag}}</el-tag>
                <el-input
                class="input-new-tag"
                v-if="inputVisible"
                v-model="inputValue"
                ref="saveTagInput"
                size="small"
                @keyup.enter.native="handleInputConfirm"
                @blur="handleInputConfirm"
                >

                </el-input>
                <el-button  v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>    
            </div>
            <div>
                <el-button @click="submit">发布</el-button>
                <el-button>清空</el-button>
            </div>
    </el-card>
    </div>
</template>
<script>
export default{
    name:"new_job",
    data(){
        return{
            obj:{},
            defaultData:{
                id: 124,
                jobName: null,
                teamId: null,
                desc: null,
                content :null,
                type:null,
                tags: [
                    
                ],
                count:10,
                salaryRange:[],
                
            },
            inputVisible: false,
            inputValue: ''
        }
    },
    props:{
        closeDialob:[],
    },
    computed:{
        option(){
            return {
                submitBtn:false,
                emptyBtn:false,
                column:[
                    {
                        label:'职位名称',
                        prop:'jobName',
                        span:10,
                        minRows:1,
                        maxlength:10,
                        showWordLimit:true,
                        rules:[{
                            required:true,
                        }]
                    },
                    {
                        label:'简介',
                        prop:'desc',
                        type:'textarea',
                        span:23,
                        placeholder:"示例\n职位描述：\n1.主要参与小米内容平台的研发维护工作，处理海量亿级内容，维护互联网内容供给服务的稳定性。\n2.参与小米互联网算法服务相关工具开发。",
                        maxlength:100,
                        showWordLimit:true,
                        rules:[{
                            required:true,
                        }]
                    
                    },  
                    {
                        label:'具体要求',
                        prot:'content',
                        type:'textarea',
                        span:23,
                        placeholder:'示例:\n职位要求：\n1.熟悉至少一种编程语言，包括python、java等。\n2.熟悉Spring，Mybatis等常用开发框架。\n3.有实际前后端编程项目经验者优先。\n4.了解网络爬虫、ES、Spark等大数据组件者优先。\n5.实习期至少保证6个月。',
                        rules:[{
                            required:true,
                        }]
                    },
                    {
                        label:'职位类型',
                        prop:'type',
                        type:'select',
                        rules:[{
                            required:true,
                        }],
                        dicData:[
                            {
                                label:'不限',
                                value:'不限',
                            },
                            {
                                label:'全职',
                                value:'全职'
                            },
                            {
                                label:'兼职',
                                value:'兼职',
                            },
                            {
                                label:'实习',
                                value:'实习',
                            },

                        ]
                    },
                    {
                        label:'职位人数',
                        controlsPosition: '',
                        prop: 'count',
                        min: 1,
                        max: 100,
                        readonly:true,
                        type:'number', 
                        rules:[{
                            required:true,
                        }]
                    },
                    {
                        label:'最低薪资',
                        controlsPosition: '',
                        prop: 'salaryRange[0]',
                        min: 0,
                        readonly:true,
                        type:'number', 
                        rules:[{
                            required:true,
                        }]
                    },
                    {
                        label:'最高薪资',
                        controlsPosition: '',
                        prop: 'salaryRange[1]',
                        min: 0,
                        readonly:true,
                        type:'number', 
                        rules:[{
                            required:true,
                        }]
                    },
                    
                ]
            }
        }
    },
    methods:{
        handleClose(tag) {
            this.defaultData.tags.splice(this.defaultData.tags.indexOf(tag), 1);
        },
        showInput() {
            this.inputVisible = true;
            this.$nextTick(_ => {
            this.$refs.saveTagInput.$refs.input.focus();
        });
        },
        handleInputConfirm() {
            let inputValue = this.inputValue;
            if (inputValue) {
                this.defaultData.tags.push(inputValue);
        }
        this.inputVisible = false;
        this.inputValue = '';
      }

    },
    //需要根据当前用户id获取teamid
    
}
</script>
<style>
.el-tag + .el-tag {
    margin-left: 10px;
    text-align: left;
  }
  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }
  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }
  .tags{
    text-align: left;
  }
  </style>