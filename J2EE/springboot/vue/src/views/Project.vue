<template>
  <div>
    <div style="padding: 10px 0">
      <el-input style="width: 200px" suffix-icon="el-icon-search" placeholder="请输入任务名称" v-model="classnum" ></el-input>
      <el-button style="margin-left:5px " type="primary" @click="load">搜索</el-button>
      <el-button style="margin-left:5px " type="warning" @click="reset">重置</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-button type="primary" @click="handleAdd">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
      <el-popconfirm
          style="margin: 0 10px"
          confirm-button-text='确定'
          cancel-button-text='取消'
          icon="el-icon-finished"
          icon-color="red"
          title="任务项确定完成吗？"
          @confirm="delBatch"
      >
        <el-button type="success" slot="reference">批量完成 <i class="el-icon-check"></i></el-button>
      </el-popconfirm>
    </div>
    <el-table :data="tableData" border stripe :header-cell-class-name="headerBg" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"> <!--用来展示CheckBox-->
      </el-table-column>
      <el-table-column prop="pid" label="任务ID" width="120"></el-table-column>
      <el-table-column prop="project" label="任务名称" width="120"></el-table-column>
      <el-table-column prop="paddress" label="地址"></el-table-column>
      <el-table-column prop="description" label="任务描述"></el-table-column>
      <el-table-column prop="ptime" label="任务发布时间"></el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button type="warning" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>
          <el-popconfirm
              style="margin: 0 10px"
              confirm-button-text='确定'
              cancel-button-text='取消'
              icon="el-icon-finished"
              icon-color="red"
              title="任务项确定完成吗？"
              @confirm="del(scope.row.pid)"
          >
            <el-button slot="reference" type="success" >完成<i class="el-icon-check"></i></el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[5, 10, 15, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
    <!--"新增按钮弹窗"-->
    <el-dialog title="任务项信息添加" :visible.sync="dialogFormVisible" width="30%">
      <el-form label-width="100px" size="small">
        <el-form-item label="任务ID" >
          <el-input v-model="form.pid" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="任务名" >
          <el-input v-model="form.project" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="地址" >
          <el-input v-model="form.paddress" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="任务描述" >
          <el-input v-model="form.description" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save" >确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "project.vue",
  data(){
    return{
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 5,
      pid: "",
      project: "",
      multipleSelection:[],
      form:{},
      dialogFormVisible:false,
      headerBg:'headerBg'
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      this.request.get("/project/page",{
            params: {
              pageNum:this.pageNum,
              pageSize:this.pageSize,
              project:this.project,
            }
          }
      ).then(res => {
        this.tableData= res.records
        this.total=res.total
      })
    },
    save(){
      this.request.post("/project", this.form).then(res => {
        if(res){
          this.$message.success("保存成功")
          this.dialogFormVisible=false
          this.load()
        }else{
          this.$message.error("保存失败")
        }
      })
    },
    reset(){
      this.pid= ""
      this.load()
    },
    handleAdd(){
      this.dialogFormVisible=true
      this.form={}
    },
    handleEdit(row){
      this.form=row
      this.dialogFormVisible=true

    },
    del(pid) {
      this.request.delete("/project/" + pid).then(res => {
        if (res) {
          this.$message.success("确认完成成功")
          this.load()
        } else {
          this.$message.error("确认完成失败")
        }
      })
    },
    delBatch(){
      let ids=this.multipleSelection.map(v => v.rid) //[{1},{2},{3}] =>[1,2,3]
      this.request.post("/project/del/batch",ids).then(res => {
        if(res){
          this.$message.success("批量完成成功")
          this.load()
        }else{
          this.$message.error("批量完成失败")
        }
      })
    },
    handleSelectionChange(val){
      this.multipleSelection=val
    },
    handleSizeChange(pageSize){
      this.pageSize =pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      this.pageNum=pageNum
      this.load()
    },
  }
}
</script>

<style>
.headerBg{
  background:  #eee!important;
}
</style>

