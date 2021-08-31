<template>
  <div>
    <div class="head">
      <el-button type="primary" @click="handleAdd()">add</el-button>
      <el-input
        placeholder="请输入name"
        prefix-icon="el-icon-search"
        v-model="search">
      </el-input>
      <el-button type="primary" @click="updateForm(search)">search</el-button>
    </div>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="name"
        label="书名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="author"
        label="作者"
        width="180">
      </el-table-column>
      <el-table-column
        prop="iSBN"
        label="ISBN">
      </el-table-column>
      <el-table-column
        label="操作">
        <template #default="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">edit
          </el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row.name)">delete
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="书籍" :visible.syncs="dialogTableVisible">
      <div class="block">
        <el-input label="书名" v-model="dialogInit.name" class="dia_input"  center></el-input>
        <el-input label="作者" v-model="dialogInit.author" class="dia_input"  center></el-input>
        <el-input label="ISBN" v-model="dialogInit.iSBN" class="dia_input"  center></el-input>
        <div slot="footer" class="dialog-footer"  center>
          <el-button @click="dialogTableVisible = false">取 消</el-button>
          <el-button type="primary" @click="updateData()">确 定</el-button>
        </div>
      </div>
    </el-dialog>

  </div>
</template>
<script>
import {request} from "../utils/request";

export default {
  data() {
    return {
      dialogTableVisible: false,
      search: "",
      tableData: [],
      dialogInit: {
        name: "",
        author: "",
        iSBN: ""
      },
      addOrEdit: ""
    }
  },
  mounted() {
    this.updateForm();
  },
  methods: {
    updateForm(str) {
      if (str == null) {
        request.findAll().then(res => {
          this.tableData = res.data;
          console.log(this.tableData);
        });
      } else {
        request.findByName(str).then(res => {
          this.tableData = res.data;
          console.log(this.tableData);
        });
      }
    },
    handleEdit(scope, row) {
      this.dialogTableVisible = true;
      this.addOrEdit = "edit";
      this.dialogInit.author = row.author;
      this.dialogInit.name = row.name;
      this.dialogInit.iSBN = row.iSBN;
    },
    handleAdd(){
      this.dialogTableVisible = true;
      this.addOrEdit = "add";
      this.dialogInit= {
        name:"",
        author: "",
        iSBN: ""
      }
    },
    handleDelete(name) {
      request.deleteBook(name).then(res => {
        console.log(res.data);
        this.updateForm();
      })
      this.dialogTableVisible = false;
    },
    updateData() {
      if(this.addOrEdit === "edit"){
        request.updateBook(this.dialogInit).then(res => {
          console.log(res.data);
          this.updateForm();
        })
        this.dialogTableVisible = false;
      }else if(this.addOrEdit === "add"){
        request.insertBook(this.dialogInit).then(res => {
          console.log(res.data);
          this.updateForm();
        })
        this.dialogTableVisible = false;
      }

    }
  }
}

</script>
<style>
.head .el-button {
  position: relative;
  left: -30%;
}

.el-input {
  width: 10%;
  position: relative;
  left: -30%;
}
.dia_input{
  width: 200px;
}
.el-dialog{
  display: flex;
}
.dialog-footer{
  display: inline;
}
.block{
  position: relative;
  top: 30px;
}
</style>
