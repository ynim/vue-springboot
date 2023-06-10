<template>
  <div>

    <el-button type="primary" style="margin-left: 20px;" @click="openProcess()">新建</el-button>

    <el-table :data="tableData" style="width:100%">
      <el-table-column prop="id" label="编号" width="150" align="center" />
      <el-table-column prop="time" label="时间" width="200" align="center" />
      <el-table-column prop="title" label="标题" width="500" align="center" />
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="editProcess(scope.row)">修改</el-button>
          <el-button size="mini" type="primary" @click="deleteById(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog :visible.sync="addManagement" title="添加预告">
      <el-form ref="ruleFrom" :model="ruleFrom" status-icon label-width="150px" class="deom-ruleFrom">
        <el-form-item label="时间">
          <el-date-picker
            v-model="ruleFrom.time"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期时间"
          />
        </el-form-item>
        <el-form-item label="标题">
          <el-input v-model="ruleFrom.title" type="textarea" style="width: 200px;" auto-complete="off" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="save()">确定</el-button>
          <el-button @click="oncancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog :visible.sync="updateManagement" title="修改预告">
      <el-form ref="updateFrom" v-model="updateFrom" status-icon label-width="150px" class="deom-ruleFrom">
        <el-form-item label="编号" prop="id" hidden>
          <el-input v-model="updateFrom.id" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="时间" prop="time">
          <el-date-picker
            v-model="updateFrom.time"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期时间"
          />
        </el-form-item>
        <el-form-item label="标题" prop="title">
          <el-input v-model="updateFrom.title" type="textarea" style="width: 200px;" auto-complete="off" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="update">修改</el-button>
          <el-button @click="oncancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <template>
      <el-pagination
        :total="Pagination.total"
        :current-page="Pagination.pageNum"
        :page-sizes="[2, 5, 10, 20]"
        layout="total, sizes, prev, pager, next, jumper"
        :page-size="Pagination.pageSize"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </template>

  </div>
</template>

<script>
import { deleteById, pageList, addyg, updateyg } from '@/api/management'
export default {
  name: 'Management',
  data() {
    return {
      tableData: [],
      addManagement: false,
      updateManagement: false,
      Pagination: {
        total: 0,
        pageNum: 1,
        pageSize: 10
      },
      ruleFrom: {
        time: '',
        title: ''
      },
      updateFrom: {
        id: '',
        time: '',
        title: ''
      }
    }
  },
  created() {
    this.getProcessList()
  },
  methods: {
    clear() {
      this.ruleFrom = {}
    },
    oncancel() {
      this.addManagement = false
      this.updateManagement = false
    },
    getProcessList() {
      pageList(this.Pagination).then((res) => {
        console.log(res)
        this.tableData = res.data.list
        this.Pagination.total = res.data.total
      })
    },
    deleteById(id) {
      this.$confirm('此操作将永久删除编号' + id + ', 是否继续', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteById(id).then((res) => {
          console.log(res)
          if (res.data === 1) {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            this.getProcessList()
          } else {
            this.$message.error('删除失败')
          }
        })
      })
    },
    editProcess(Management) {
      this.updateManagement = true
      this.updateFrom.id = Management.id
      this.updateFrom.time = Management.time
      this.updateFrom.title = Management.title
    },
    update() {
      updateyg(this.updateFrom).then((res) => {
        if (res.data >= 1) {
          this.$message({
            message: '修改成功',
            type: 'success'
          })
          this.oncancel()
          this.getProcessList()
        } else {
          this.$message.error('修改失败')
        }
      })
    },
    save() {
      addyg(this.ruleFrom).then((res) => {
        if (res.data === 1) {
          this.$message({
            message: '添加成功',
            type: 'success'
          })
          this.getProcessList()
          this.oncancel()
          this.clear()
        } else {
          this.$message.error('添加失败')
        }
      })
    },
    openProcess() {
      this.addManagement = true
    }
  }
}
</script>

<style scoped>
.el-input {
  width: 200px;
  margin-left: 15px;
}
span {
  font-size: 10px;
  color: darkgray;
  margin-left: 15px;
}
div {
  margin: 10px;
}
</style>
