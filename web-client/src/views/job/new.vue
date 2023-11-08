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
      <div
        class="tags"
        style="position:relative;margin-left:45px   "
      >
        <label style="margin-right: 10px;">标签:</label>
        <el-tag
          v-for="tag in defaultData.tags"
          closable
          :disable-transitions="false"
          @close="handleClose(tag)"
          :key="tag.name"
        >{{ tag}}</el-tag>
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
        <el-button
          v-else
          class="button-new-tag"
          size="small"
          @click="showInput"
        >+ New Tag</el-button>
      </div>
      <div>
        <el-button @click="submit">发布</el-button>
        <el-button @click="clearany">清空</el-button>
      </div>
    </el-card>
  </div>
</template>
<script>
import { addOrUpdateTeamJob } from '@/api/teamJobService'

export default {
  name: "new_job",
  data () {
    return {
      obj: {},
      defaultData: {
        jobName: null,
        teamId: null,
        desc: null,
        content: null,
        type: null,
        tags: [],
        count: 10,
        salaryRange: [],
        minSalary: null,
        maxSalary: null,

      },
      inputVisible: false,
      inputValue: '',
      userData: null
    }
  },
  props: {
    closeDialob: [],
  },
  created () {
    this.userData = JSON.parse(sessionStorage.getItem("userData"))
    this.defaultData.teamId = this.userData.teamId;
    this.obj = this.defaultData;
  },
  computed: {
    option () {
      return {
        submitBtn: false,
        emptyBtn: false,
        column: [
          {
            label: '职位名称',
            prop: 'jobName',
            span: 10,
            minRows: 1,
            maxlength: 10,
            showWordLimit: true,
            rules: [{
              required: true,
              message: "请输入 职位名称"
            }]
          },
          {
            label: '简介',
            prop: 'desc',
            type: 'textarea',
            span: 23,
            placeholder: "示例\n职位描述：\n负责四门两盖的调整，熟悉车辆异常情况，有一定的汽车维修经验。",
            maxlength: 100,
            showWordLimit: true,
            rules: [{
              required: true,
              message: "请输入 岗位简介"
            }]

          },
          {
            label: '具体要求',
            prop: 'content',
            type: 'textarea',
            span: 23,
            placeholder: '示例:\n职位要求：\n1.熟悉至少一种编程语言，包括python、java等。\n2.熟悉Spring，Mybatis等常用开发框架。\n3.有实际前后端编程项目经验者优先。\n4.了解网络爬虫、ES、Spark等大数据组件者优先。\n5.实习期至少保证6个月。',
            rules: [{
              required: true,
              message: '请输入 具体要求'
            }]
          },
          {
            label: '职位类型',
            prop: 'type',
            type: 'select',
            rules: [{
              required: true,
              message: '请选择 职位类型'
            }],
            dicData: [
              {
                label: '不限',
                value: '不限',
              },
              {
                label: '全职',
                value: '全职'
              },
              {
                label: '兼职',
                value: '兼职',
              },
              {
                label: '实习',
                value: '实习',
              },

            ]
          },
          {
            label: '职位人数',
            controlsPosition: '',
            prop: 'count',
            min: 1,
            type: 'number',
            rules: [{
              required: true,
              message: '请选择职位数量 大于零'
            }]
          },
          {
            label: '最低薪资',
            controlsPosition: '',
            prop: 'minSalary',
            type: 'number',
            rules: [{
              required: true,
            }]
          },
          {
            label: '最高薪资',
            controlsPosition: '',
            prop: 'maxSalary',
            type: 'number',
            rules: [{
              required: true,
            }]
          },

        ]
      }
    }
  },
  methods: {
    handleClose (tag) {
      this.defaultData.tags.splice(this.defaultData.tags.indexOf(tag), 1);
    },
    showInput () {
      this.inputVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },
    handleInputConfirm () {
      let inputValue = this.inputValue;
      if (inputValue) {
        this.defaultData.tags.push(inputValue);
      }
      this.inputVisible = false;
      this.inputValue = '';
    },
    async submit () {
      this.obj.salaryRange[0] = this.obj.minSalary
      this.obj.salaryRange[1] = this.obj.maxSalary
      this.obj.tags = this.defaultData.tags
      this.defaultData.salaryRange[0] = this.obj.minSalary
      this.defaultData.salaryRange[1] = this.obj.maxSalary

      var res = ((await addOrUpdateTeamJob(this.obj)).data);
      console.log(res);
      if (res.code == '200') {
        this.$message.success("岗位发布成功！")
      }
      else if (res.code == "312") {
        this.$message.error("未登录")
      }
      else {
        this.$message.error("帖子发布失败，请重新尝试")
      }
    },
    clearany () {
      this.$refs.form.resetForm();
    }

  },

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
.tags {
  text-align: left;
}
</style>