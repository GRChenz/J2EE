<template>
  <div>
    <div style="padding: 10px 0">
      <el-input style="width: 200px" suffix-icon="el-icon-search" placeholder="请输入教室号" v-model="classnum" ></el-input>
      <el-button style="margin-left:5px " type="primary" @click="load">搜索</el-button>
      <el-button style="margin-left:5px " type="warning" @click="reset">重置</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-button type="primary" @click="handleAdd">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
      <el-popconfirm
          style="margin: 0 10px"
          confirm-button-text='确定'
          cancel-button-text='取消'
          icon="el-icon-info"
          icon-color="red"
          title="能源项确定删除吗？"
          @confirm="delBatch"
      >
        <el-button type="danger" slot="reference">批量删除 <i class="el-icon-remove-outline"></i></el-button>
      </el-popconfirm>
      <el-upload action="http://localhost:9090/dataprocessing/import" :show-file-list="false" accept="xlsx" :on-success="handleExcelImportSuccess" style="display: inline-block">
        <el-button type="primary" class="ml-5">导入 <i class="el-icon-bottom"></i></el-button>
      </el-upload>
      <el-button type="primary" @click="exp" style="margin-left: 10px">导出 <i class="el-icon-top"></i></el-button>
    </div>
    <el-table :data="tableData" border stripe :header-cell-class-name="headerBg" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"> <!--用来展示CheckBox-->
      </el-table-column>
      <el-table-column prop="rid" label="教室ID" width="120"></el-table-column>
      <el-table-column prop="classnum" label="教室号" width="120"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column prop="electricalconsume" label="电能消耗量KW/D"></el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>
          <el-popconfirm
              style="margin: 0 10px"
              confirm-button-text='确定'
              cancel-button-text='取消'
              icon="el-icon-info"
              icon-color="red"
              title="能源项确定删除吗？"
              @confirm="del(scope.row.rid)"
          >
            <el-button slot="reference" type="danger" >删除<i class="el-icon-remove-outline"></i></el-button>
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
    <el-dialog title="能源项信息添加" :visible.sync="dialogFormVisible" width="30%">
      <el-form label-width="100px" size="small">
        <el-form-item label="教室ID" >
          <el-input v-model="form.rid" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="教室号" >
          <el-input v-model="form.classnum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="地址" >
          <el-input v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="电能消耗量" >
          <el-input v-model="form.electricalconsume" autocomplete="off"></el-input>
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
  name: "User",
  data(){
    return{
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 5,
      rid: "",
      classnum: "",
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
      this.request.get("/dataprocessing/page",{
            params: {
              pageNum:this.pageNum,
              pageSize:this.pageSize,
              classnum:this.classnum,
            }
          }
      ).then(res => {
        this.tableData= res.records
        this.total=res.total
      })
    },
    save(){
      this.request.post("/dataprocessing", this.form).then(res => {
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
      this.rid= ""
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
    del(rid) {
      this.request.delete("/dataprocessing/" + rid).then(res => {
        if (res) {
          this.$message.success("删除成功")
          this.load()
        } else {
          this.$message.error("删除失败")
        }
      })
    },
    delBatch(){
      let ids=this.multipleSelection.map(v => v.rid) //[{1},{2},{3}] =>[1,2,3]
      this.request.post("/dataprocessing/del/batch",ids).then(res => {
        if(res){
          this.$message.success("批量删除成功")
          this.load()
        }else{
          this.$message.error("批量删除失败")
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
    handleExcelImportSuccess() {
      this.$message.success("导入成功")
      this.load()
    },
    exp() {
      window.open("http://localhost:9090/dataprocessing/export")
    }
  }
}
</script>

<style>
.headerBg{
  background:  #eee!important;
}
</style>