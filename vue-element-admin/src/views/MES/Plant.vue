<template>
  <div>
    <table>
      <tr>
        <td>
          <span>生产线名称：</span>
        </td>
      </tr>
      <tr>
        <td>
          <el-input v-model="Pagination.scxname" placeholder="请输入生产线名称" />
        </td>
        <td>
          <el-button
            style="margin-left: 20px;"
            type="primary"
            @click="getPlantList()"
          ><i class="el-icon-search" />查询</el-button>
          <el-button type="primary" @click="resetPlant()">重置</el-button>
        </td>
      </tr>
    </table>
    <el-button type="primary" style="margin-left: 20px;" @click="openPlant()">新建</el-button>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="编号" width="150" align="center" />
      <el-table-column prop="scxname" label="生产线名称" width="230" align="center" />
      <el-table-column prop="product" label="产品" width="230" align="center" />
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="primary"
            @click="editPlant(scope.row)"
          >修改</el-button>
          <el-button
            size="mini"
            type="primary"
            @click="deleteById(scope.row.id)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog :visible.sync="addPlant" title="新建工厂建模">
      <el-form ref="ruleFrom" :model="ruleFrom" status-icon label-width="100px" class="demo-ruleFrom">
        <el-form-item label="生产线名称" prop="scxname">
          <el-input v-model="ruleFrom.scxname" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="产品" prop="product">
          <el-input v-model="ruleFrom.product" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="save()">添加</el-button>
          <el-button @click="oncancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog :visible.sync="updatePlant" title="修改工厂建模">
      <el-form ref="updateFrom" :model="updateForm" status-icon label-width="100px" class="demo-ruleFrom">
        <el-form-item label="编号" prop="id" hidden>
          <el-input v-model="updateForm.id" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="生产线名称" prop="scxname">
          <el-input v-model="updateForm.scxname" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="产品" prop="product">
          <el-input v-model="updateForm.product" type="text" auto-complete="off" />
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
import { updatePlant, addPlant, deleteById, pageList } from '@/api/plant'

export default {
  name: 'Product',
  data() {
    return {
      tableData: [],
      updatePlant: false,
      addPlant: false,
      updateForm: {
        id: '',
        scxname: '',
        product: ''
      },
      ruleFrom: {
        scxname: '',
        product: ''
      },
      Pagination: {
        pageNum: 1,
        pageSize: 10,
        total: 0,
        scxname: ''
      }
    }
  },
  created() {
    this.getPlantList()
  },
  methods: {
    oncancel() {
      this.addPlant = false
      this.updatePlant = false
    },
    openPlant() {
      this.addPlant = true
    },
    editPlant(plant) {
      this.updatePlant = true
      this.updateForm.id = plant.id
      this.updateForm.scxname = plant.scxname
      this.updateForm.product = plant.product
    },
    resetPlant() {
      this.Pagination.scxname = ''
    },
    update() {
      updatePlant(this.updateForm).then((res) => {
        if (res.data >= 1) {
          this.$message({
            message: '修改成功',
            type: 'success'
          })
          this.getPlantList()
          this.oncancel()
        } else {
          this.$message.error('修改失败')
        }
      }).catch(() => {})
    },
    deleteById(id) {
      this.$confirm('此操作将永久删除编号为' + id + ', 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteById(id).then((res) => {
          console.log(res)
          if (res.data === 1) {
            this.$message({
              type: 'success',
              message: '删除成功！'
            })
            this.getPlantList()
          } else {
            this.$message.error('删除失败')
          }
        })
      })
    },
    clear() {
      this.ruleFrom = {}
    },
    save() {
      addPlant(this.ruleFrom).then((res) => {
        if (res.data === 1) {
          this.$message({
            message: '添加成功',
            type: 'success'
          })
          this.oncancel()
          this.getPlantList()
          this.clear()
        } else {
          this.$message.error('添加失败')
        }
      })
    },
    getPlantList() {
      pageList(this.Pagination).then((res) => {
        console.log(res)
        this.tableData = res.data.list
        this.Pagination.total = res.data.total
      })
    },
    handleSizeChange(val) {
      this.Pagination.pageSize = val
      this.Pagination.pageNum = 1
    },
    handleCurrentChange(val) {
      this.Pagination.pageNum = val
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
    margin-left: 15px;
    color: darkgray;
}
div {
    margin: 10px;
}
</style>
