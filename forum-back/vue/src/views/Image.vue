<template>


  <div style="padding:10px">
    <!--   功能区域 -->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <!--    搜索区域-->
    <div style="margin: 10px 0">
      <el-input v-model="search" placeholder="请输入用户ID" style="width: 20%" clearable/>
      <el-button type="primary" style="margin-left: 5px" @click="load">查询</el-button>
    </div>

    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column sortable prop="id" label="ID" width="180"/>
      <el-table-column prop="idUser" label="用户ID" width="180"/>
      <el-table-column prop="imgUrl" label="图片">
        <template #default="scope">
            <el-image
                  style="width: 100px; height: 100px"
                  :src="scope.row.imgUrl"
                  :preview-src-list="[scope.row.imgUrl]"
                  :initial-index="1"
              >
              </el-image>
        </template>
      </el-table-column>
      <el-table-column prop="right" label="操作">
        <template #default="scope">
          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm
              confirm-button-text="确定"
              cancel-button-text="取消"
              icon-color="red"
              title="确认删除吗?" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button size="mini" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <div style="margin: 10px 0">
      <el-pagination
          v-model:currentPage="currentPage"
          :page-sizes="[5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange">
      </el-pagination>

      <el-dialog v-model="dialogVisible" title="提示" width="30%">
        <el-form :model="form" label-width="120px">
          <el-form-item label="用户ID">
            <el-input v-model="form.idUser" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="图片">
            <el-upload ref="upload" action="api/image/upload" :on-success="filesUploadSuccess">
              <el-button type="primary">点击上传</el-button>
            </el-upload>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="save">确定</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src


import request from "../utils/request";

export default {
  name: 'Image',
  components: {},


  data() {
    return {
      form: {},
      dialogVisible: false,
      search: '',
      currentPage: 1,
      pageSize: 10,
      total: 0,
      tableData: [],
    }
  },
  created() {
    this.load();
  },
  methods: {
    filesUploadSuccess(res){
      console.log(res);
      this.form.imgUrl = res.data;
    },
    load() {
      request.get("/image", {
        params: {
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res => {
        console.log(res);
        this.tableData = res.data.records;
        this.total = res.data.total;
      })
    },
    add() {
      this.dialogVisible = true;
      this.form = {};
      this.$refs['upload'].clearFiles()  // 清除历史文件列表
    },
    save() {
      if (this.form.id) { //更新
        request.put("/image", this.form).then(res => {
          console.log(res);
          if (res.code == '0') {
            this.$message({
              type: "success",
              message: "更新成功"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      } else {//新增
        request.post("/image", this.form).then(res => {
          console.log(res);
          if (res.code == '0') {
            this.$message({
              type: "success",
              message: "更新成功"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      }
      this.load();  //刷新表格的数据
      this.dialogVisible = false; //关闭弹窗
    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row));
      this.dialogVisible = true;
      this.$nextTick(() => {
        this.$refs['upload'].clearFiles()  // 清除历史文件列表
      })
    },
    handleDelete(id) {
      console.log(id);
      request.delete("/image/" + id).then(res=>{
        if (res.code == '0') {
          this.$message({
            type: "success",
            message: "删除成功"
          })
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
        this.load(); //删除后刷新表格的数据
      });
    },
    handleSizeChange(pageSize) {  //改变当前每页个数触发
      this.pageSize = pageSize;
      this.load();
    },
    handleCurrentChange(pageNum) { //改变当前页码触发
      this.currentPage = pageNum;
      this.load();
    },
  }
}
</script>
