<template>
  <div>
    <table>
      <tr>
        <td><span>项目名称：</span></td>
        <td><span>开始日期：</span></td>
        <td><span>结束日期：</span></td>
        <td><span>状态：</span></td>
      </tr>
      <tr>
        <td>
          <el-input v-model="pagination.name" placeholder="请输入项目名称" />
        </td>
        <td>
          <el-date-picker
            v-model="pagination.start"
            value-format="yyyy-MM-dd"
            placeholder="选择开始日期"
          />
        </td>
        <td>
          <el-date-picker v-model="pagination.end" value-format="yyyy-MM-dd" placeholder="选择结束日期" />
        </td>
        <td>
          <el-select v-model="pagination.status" clearable placeholder="请选择">
            <el-option
              v-for="item in typeForm"
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
            @click="getProjectsList()"
          ><i class="el-icon-search" />查询
          </el-button>
          <el-button type="primary" @click="resetPagination()">重置</el-button>
        </td>
      </tr>
      <template>
        <el-button style="margin-left: 15px;" type="primary" @click="openProject()">新建</el-button>
      </template>
    </table>
    <el-table :data="tableData" style="width: 100%" :header-cell-style="{'text-align':'center'}">
      <el-table-column prop="id" label="编号" width="130" align="center" />
      <el-table-column prop="name" label="项目名称" width="150" align="center" />
      <el-table-column prop="header" label="负责人" width="120" align="center" />
      <el-table-column prop="start" label="开始时间" width="230" align="center" />
      <el-table-column prop="end" label="结束时间" width="230" align="center" />
      <el-table-column label="项目状态" width="100" align="center">
        <template slot-scope="scope">
          <p v-if="scope.row.status == 1">正常</p>
          <p v-if="scope.row.status == 0">挂起</p>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="primary"
            @click="editProjects(scope.row)"
          >修改</el-button>
          <el-button
            size="mini"
            type="primary"
            @click="deleteById(scope.row.id)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog :visible.sync="addProjects" title="添加项目管理">
      <el-form
        ref="ruleFrom"
        :model="ruleFrom"
        status-icon
        label-width="100"
        class="demo-ruleFrom"
      >
        <el-form-item label="项目名(*必填项)" prop="name">
          <el-input v-model="ruleFrom.name" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="负责人(*必填项)" prop="header">
          <el-input v-model="ruleFrom.header" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="开始日期(*必填项)" prop="start">
          <el-date-picker v-model="ruleFrom.start" value-format="yyyy-MM-dd" placeholder="选择开始日期" />
        </el-form-item>
        <el-form-item label="结束日期(*必填项)" prop="start">
          <el-date-picker v-model="ruleFrom.end" value-format="yyyy-MM-dd" placeholder="选择开始日期" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="ruleFrom.status" clearable placeholder="请选择">
            <el-option
              v-for="item in typeForm"
              :key="item.id"
              :label="item.typename"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="图片上传">
          <template>
            <single-image />
          </template>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="save()">添加</el-button>
          <el-button @click="outcancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog :visible.sync="updateProject" title="修改项目">
      <el-form
        ref="updateFrom"
        :model="updateFrom"
        status-icon
        label-width="100px"
        class="demo-ruleFrom"
      >
        <el-form-item label="编号" prop="id" hidden>
          <el-input v-model="updateFrom.id" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="项目名称" prop="name">
          <el-input v-model="updateFrom.name" type="text" auto-complete="off" />
        </el-form-item>
        <el-form-item label="开始日期" prop="start">
          <el-date-picker v-model="updateFrom.start" value-format="yyyy-MM-dd" placeholder="选择开始日期" />
        </el-form-item>
        <el-form-item label="结束日期" prop="end">
          <el-date-picker v-model="updateFrom.end" value-format="yyyy-MM-dd" placeholder="选择结束日期" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="updateFrom.status" clearable placeholder="请选择">
            <el-option
              v-for="item in typeForm"
              :key="item.id"
              :label="item.typename"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="图片上传" prop="duction">
          <el-upload
            class="avatar-updoader"
            action=""
            http-request="uploader"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
          >
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="update">修改</el-button>
          <el-button @click="oncancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <template>
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
import { addproject, pageList, updateproject, deleteById } from '@/api/project'
import SingleImage from '@/components/Upload/SingleImage.vue'
export default {
  name: 'Project',
  components: { SingleImage },
  data() {
    return {
      tableData: [],
      addProjects: false,
      updateProject: false,
      uploadUrl: '/ject/insert',
      imageList: [],
      fileList: [],
      previewDialogVisible: false,
      imgUrl: '',
      typeForm: [
        { id: '0', typename: '挂起' },
        { id: '1', typename: '正常' }
      ],
      ruleFrom: {
        name: '',
        header: '',
        start: '',
        end: '',
        duction: '',
        status: ''
      },
      updateFrom: {
        id: '',
        name: '',
        header: '',
        start: '',
        end: '',
        duction: '',
        status: ''
      },
      pagination: {
        pageNum: 1,
        pageSize: 10,
        total: 0,
        name: '',
        start: '',
        end: '',
        status: ''
      }
    }
  },
  created() {
    this.getProjectsList()
  },
  methods: {
    clear() {
      this.ruleFrom = {}
    },
    resetPagination() {
      console.log(this.pagination)
      this.pagination.name = ''
      this.pagination.start = ''
      this.pagination.end = ''
      this.pagination.status = ''
    },
    openProject() {
      this.addProjects = true
    },
    outcancel() {
      this.addProjects = false
      this.updateProject = false
    },
    getProjectsList() {
      if (this.pagination.start > this.pagination.end) {
        this.$message.error('开始时间应在结束时间之前')
      } else {
        pageList(this.pagination).then((res) => {
          console.log(res)
          this.tableData = res.data.list
          this.pagination.total = res.data.total
          console.log(this.pagination)
        })
      }
    },
    save() {
      addproject(this.ruleFrom).then((res) => {
        if (res.data === 1) {
          this.$message({
            message: '添加成功',
            type: 'success'
          })
          this.getProjectsList()
          this.outcancel()
          this.clear()
        } else {
          this.$message.error('添加失败')
        }
      })
    },
    editProjects(Project) {
      this.updateProject = true
      this.updateFrom.id = Project.id
      this.updateFrom.name = Project.name
      this.updateFrom.header = Project.header
      this.updateFrom.start = Project.start
      this.updateFrom.end = Project.end
      this.updateFrom.status = Project.status
      this.updateFrom.duction = Project.duction
    },
    update() {
      updateproject(this.updateFrom).then((res) => {
        if (res.data >= 1) {
          this.$message({
            message: '修改成功',
            type: 'success'
          })
          this.getProjectsList()
          this.outcancel()
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
            this.getProjectsList()
          } else {
            this.$message.error('删除失败')
          }
        })
      }).catch(() => {})
    },
    handleSizeChange(val) {
      console.log('jk', val)
      this.pagination.pageSize = val
      this.pagination.pageNum = 1
    },
    handleCurrentChange(val) {
      console.log('lik', val)
      this.pagination.pageNum = val
    },
    handleRemove(file, fileList) {
      this.imageList = fileList
    },
    beforeUpload(file) {
      this.fileList.push(file)
      return false // 阻止自动上传，以便显示预览
    },

    handleSuccess(response, file) {
      file.url = response // 将后端返回的 URL 分配给 file.url
    },

    handleError(err, file, duction) {
      this.$message.error(`${file.name} 上传失败：${err.message}`)
    },

    handlePreview(file) {
      this.previewDialogVisible = true
      this.imgUrl = file.url || file.thumbUrl || file.response
      this.addProjects.duction = file.url || file.thumbUrl || file.response
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
