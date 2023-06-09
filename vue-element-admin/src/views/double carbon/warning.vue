<template>
  <div>
    <table>
      <tr>
        <td><span>检测点名称：</span></td>
        <td><span>检测点地址：</span></td>
        <td><span>状态：</span></td>
      </tr>
      <tr>
        <td><el-input v-model="selection.pointname" placeholder="请输入检测点名称" /></td>
        <td><el-input v-model="selection.pointaddress" placeholder="请输入检测点地址" /></td>
        <td>
          <el-select v-model="selection.state" clearable placeholder="请选择">
            <el-option
              v-for="item in typeFrom"
              :key="item.id"
              :label="item.typename"
              :value="item.id"
            />
          </el-select>
        </td>
        <td>
          <el-button
            style="margin-left: 20px"
            type="primary"
            @click="selectWarningsList()"
          ><i class="el-icon-search" />查询</el-button>
          <el-button type="primary" @click="resetPagination()">重置</el-button>
          <template>
            <el-button type="primary" @click="openWarning()">新建</el-button>
          </template>
        </td>
      </tr>
    </table>
    <el-table :data="tableData" style="width: 100%;" :header-cell-style="{'text-align':'center'}">
      <el-table-column prop="id" label="编号" width="100" align="center" />
      <el-table-column prop="pointname" label="检测点名称" width="100" align="center" />
      <el-table-column prop="pointaddress" label="检测点地址" width="180" align="center" />
      <el-table-column prop="timepower" label="实时功率" width="100" align="center" />
      <el-table-column prop="timevoltage" label="实时电压" width="100" align="center" />
      <el-table-column label="状态" width="100" align="center">
        <template slot-scope="scope">
          <p v-if="scope.row.state == 1">检测中</p>
          <p v-if="scope.row.state == 0">未检测</p>
        </template>
      </el-table-column>
      <el-table-column prop="reportingtime" label="上报时间" width="230" align="center" />
      <el-table-column prop="notes" label="备注" width="100" align="center" />
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="editWarnings(scope.row)">修改</el-button>
          <el-button
            size="mini"
            type="primary"
            @click="deleteById(scope.row.id)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--    添加预警弹窗-->
    <el-dialog :visible.sync="addWarnings" title="添加能效检测点">
      <el-form
        ref="ruleForm"
        :model="ruleForm"
        status-icon
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="检测点名称(*必填项)" prop="pointname">
          <el-input
            v-model="ruleForm.pointname"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item label="检测点地点(*必填项)" prop="pointaddress">
          <el-input
            v-model="ruleForm.pointaddress"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item label="实时功率(*必填项)" prop="timepower">
          <el-input
            v-model="ruleForm.timepower"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item label="实时电压(*必填项)" prop="timevoltage">
          <el-input
            v-model="ruleForm.timevoltage"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <!--        <el-form-item label="类型" prop="type">-->
        <!--          <el-input type="text" v-model="ruleForm.type" autocomplete="off"></el-input>-->
        <!--        </el-form-item>-->
        <el-form-item label="状态" prop="state">
          <el-select v-model="ruleForm.state" clearable placeholder="请选择">
            <el-option
              v-for="item in typeFrom"
              :key="item.id"
              :label="item.typename"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="notes">
          <el-input
            v-model="ruleForm.notes"
            type="textarea"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="save">添加</el-button>

          <el-button @click="outcancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!--    修改预警弹窗-->
    <el-dialog :visible.sync="updateWarning" title="修改能效检测点">
      <el-form
        ref="updateForm"
        :model="updateForm"
        status-icon
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="编号" prop="id" hidden>
          <el-input
            v-model="updateForm.id"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item label="检测点名称" prop="pointname">
          <el-input
            v-model="updateForm.pointname"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item label="检测点地址" prop="pointaddress">
          <el-input
            v-model="updateForm.pointaddress"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item label="实时功率" prop="timepower">
          <el-input
            v-model="updateForm.timepower"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item label="实时电压" prop="timevoltage">
          <el-input
            v-model="updateForm.timevoltage"
            type="text"
            autocomplete="off"
          />
        </el-form-item>
        <!--        <el-form-item label="类型" prop="type">-->
        <!--          <el-input type="text" v-model="updateForm.type" autocomplete="off"></el-input>-->
        <!--        </el-form-item>-->
        <el-form-item label="状态" prop="state">
          <el-select v-model="updateForm.state" clearable placeholder="请选择">
            <el-option
              v-for="item in typeFrom"
              :key="item.id"
              :label="item.typename"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="notes">
          <el-input
            v-model="updateForm.notes"
            type="textarea"
            autocomplete="off"
          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="update">修改</el-button>
          <el-button @click="outcancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <template>
      <!--            <span class="demonstration">完整功能</span>-->
      <el-pagination
        :total="pagination.total"
        :current-page="pagination.pageNum"
        :page-sizes="[2, 5, 10, 20]"
        layout="total, sizes, prev, pager, next, jumper"
        :page-size="pagination.pageSize"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </template>
  </div>
</template>

<script>
// import Axios from 'axios'
import {
  findAll,
  pageList,
  deleteById,
  addWarnings,
  updateWarning
} from '../../api/warning'
export default {
  name: 'Warning',
  data() {
    return {
      tableData: [],
      addWarnings: false,
      updateWarning: false,
      typeFrom: [{ 'id': '0', 'typename': '未检测' }, { 'id': '1', 'typename': '检测中' }],
      ruleForm: {
        pointname: '',
        pointaddress: '',
        timepower: '',
        timevoltage: '',
        state: '',
        notes: ''
      },
      updateForm: {
        id: '',
        pointname: '',
        pointaddress: '',
        timepower: '',
        timevoltage: '',
        state: '',
        notes: ''
      },
      pagination: {
        pageNum: 1,
        pageSize: 10,
        total: 0
      },
      selection: {
        pageNum: 1,
        pageSize: 10,
        total: 0,
        pointname: '',
        pointaddress: '',
        state: ''
      }
    }
  },
  created() {
    // 初始化
    this.getWarningsList()
  },
  methods: {
    // 清空表单
    clear() {
      this.ruleForm = {}
      // this.ruleForm.id=''
      // this.ruleForm.name=''
      // this.ruleForm.price=''
      // this.ruleForm.count=''
      // this.ruleForm.type=''
    },
    selectWarningsList() {
      findAll(this.selection).then((res) => {
        console.log(res)
        this.tableData = res.data.list
        this.pagination.total = res.data.total
      })
    },
    resetPagination() {
      console.log(this.selection)
      this.selection.pointname = ''
      this.selection.pointaddress = ''
      this.selection.state = ''
    },
    getWarningsList() {
      // eslint-disable-next-line no-undef
      pageList(this.pagination).then((res) => {
        console.log(res)
        this.tableData = res.data.list
        this.pagination.total = res.data.total
        console.log(this.pagination)
      })
    },
    handleSizeChange(val) {
      console.log('jk', val)
      this.pagination.pageSize = val
      this.pagination.pageNum = 1
      this.getWarningsList()
    },
    handleCurrentChange(val) {
      console.log('lik', typeof (val))
      this.pagination.pageNum = val
      this.getWarningsList()
    },
    findAll() {
      findAll().then((res) => {
        console.log(res)
        this.tableData = res
      })
    },
    deleteById(id) {
      this.$confirm('此操作将永久删除编号为' + id + ', 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          // eslint-disable-next-line no-undef
          deleteById(id).then((res) => {
            console.log(res)
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功!'
              })
              this.getWarningsList()
            } else {
              this.$message.error('删除失败')
            }
          })
        })
        .catch(() => {}) // 添加错误捕获
    },
    openWarning() {
      this.addWarnings = true
    },
    outcancel() {
      this.addWarnings = false
      this.updateWarning = false
    },
    save() {
      // eslint-disable-next-line no-undef
      addWarnings(this.ruleForm)
        .then((res) => {
          if (res.data === 1) {
            this.$message({
              message: '添加成功',
              type: 'success'
            })
            this.getWarningsList()
            this.outcancel()
            this.clear()
            // this.$router.go()
          } else {
            this.$message.error('添加失败')
          }
          // location.reload();
        })
        .catch(() => {}) // 添加错误捕获
    },
    editWarnings(Warnings) {
      this.updateWarning = true
      this.updateForm.id = Warnings.id
      this.updateForm.pointname = Warnings.pointname
      this.updateForm.pointaddress = Warnings.pointaddress
      this.updateForm.timepower = Warnings.timepower
      this.updateForm.timevoltage = Warnings.timevoltage
      this.updateForm.state = Warnings.state
      this.updateForm.notes = Warnings.notes
    },
    update() {
      // Axios.post('http://127.0.0.1:8080/warning/update', this.updateForm).then(function(res) {
      //   console.log(res)
      // })
      updateWarning(this.updateForm)
        .then((res) => {
          if (res.data >= 1) {
            this.$message({
              message: '修改成功',
              type: 'success'
            })
            this.getWarningsList()
            this.outcancel()
          } else {
            this.$message.error('修改失败')
          }
        })
        .catch(() => {}) // 添加错误捕获
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
  font-size:10px;
  color: darkgrey;
  margin-left: 15px;
}
div {
  margin: 10px;
}
</style>

