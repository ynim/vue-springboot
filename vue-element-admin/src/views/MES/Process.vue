<template>
  <div>
    <table>
      <tr>
        <td>
          <span>工艺名称：</span>
        </td>
      </tr>
      <tr>
        <td>
          <el-input v-model="Pagination.name" placeholder="请输入工艺名称" />
        </td>
        <td>
          <el-button type="primary" style="margin-left: 20px;">
            <i class="el-icon-search" />查询</el-button>
          <el-button type="primary" @click="resetProcess()">重置</el-button>
        </td>
      </tr>
    </table>

    <el-button type="primary" style="margin-left: 20px;" @click="openProcess()">新建</el-button>

    <el-table :data="tableData" style="width:100%">
      <el-table-column prop="id" label="编号" width="150" align="center" />
      <el-table-column prop="name" label="工艺名称" width="200" align="center" />
      <el-table-column prop="product" label="产品" width="200" align="center" />
      <el-table-column prop="model" label="型号" width="150" align="center" />
      <el-table-column prop="guige" label="规格" width="150" align="center" />
      <el-table-column prop="unit" label="单位" width="150" align="center" />
      <el-table-column prop="prow" label="单位耗电量" width="150" align="center" />
      <el-table-column prop="notes" label="备注" width="200" align="center" />
      <el-table-column label="操作">
        <el-button size="mini" type="primary">修改</el-button>
        <el-button size="mini" type="primary">删除</el-button>
      </el-table-column>
    </el-table>

    <el-dialog :visible.sync="addProcess" title="添加工艺建模">
      <el-form ref="ruleFrom" v-model="ruleFrom" status-icon label-width="100px" class="deom-ruleFrom">
        <el-form-item label="产品(*必填项)" hidden>
          <el-input v-model="ruleFrom.product" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="工艺名称(*必填项)" hidden>
          <el-input v-model="ruleFrom.name" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="单位耗电量(*必填项)" hidden>
          <el-input v-model="ruleFrom.prow" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="备注" hidden>
          <el-input v-model="ruleFrom.notes" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="工艺描述" hidden>
          <el-input v-model="ruleFrom.description" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="save()">确定</el-button>
          <el-button @click="oncancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog :visible.sync="updateProcess" title="修改工艺建模">
      <el-form ref="updateFrom" v-model="updateFrom" status-icon label-width="100px" class="deom-ruleFrom">
        <el-form-item label="编号" prop="id" hidden>
          <el-input v-model="updateFrom.id" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="产品(*必填项)" hidden>
          <el-input v-model="updateFrom.product" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="工艺昵称(*必填项)" hidden>
          <el-input v-model="updateFrom.name" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="单位耗电量(*必填项)" hidden>
          <el-input v-model="updateFrom.prow" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="备注" hidden>
          <el-input v-model="updateFrom.notes" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="工艺描述" hidden>
          <el-input v-model="updateFrom.description" type="text" auto-complete="off" />
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

export default {
  name: 'Process',
  data() {
    return {
      tableData: [],
      addProcess: false,
      updateProcess: false,
      Pagination: {
        total: 0,
        pageNum: 1,
        pageSize: 10,
        name: ''
      },
      ruleFrom: {
        product: '',
        name: '',
        prow: '',
        notes: '',
        description: ''
      },
      updateFrom: {
        id: '',
        name: '',
        product: '',
        description: '',
        prow: '',
        notes: ''
      }
    }
  },
  methods: {
    oncancel() {
      this.addProcess = false
      this.updateProcess = false
    },
    openProcess() {
      this.addProcess = true
    },
    resetProcess() {
      this.Pagination.name = ''
    }
  }
}
</script>

<style scoped>
.el-input {
    width: 200;
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
