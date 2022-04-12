<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="机构名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="机构名称"></el-input>
    </el-form-item>
    <el-form-item label="机构类型：生产基地、批发中心、收购点" prop="type">
      <el-input v-model="dataForm.type" placeholder="机构类型：生产基地、批发中心、收购点"></el-input>
    </el-form-item>
    <el-form-item label="机构地址" prop="address">
      <el-input v-model="dataForm.address" placeholder="机构地址"></el-input>
    </el-form-item>
    <el-form-item label="联系电话" prop="phoneNumber">
      <el-input v-model="dataForm.phoneNumber" placeholder="联系电话"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          name: '',
          type: '',
          address: '',
          phoneNumber: ''
        },
        dataRule: {
          name: [
            { required: true, message: '机构名称不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '机构类型：生产基地、批发中心、收购点不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '机构地址不能为空', trigger: 'blur' }
          ],
          phoneNumber: [
            { required: true, message: '联系电话不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/renren/institution/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.institution.name
                this.dataForm.type = data.institution.type
                this.dataForm.address = data.institution.address
                this.dataForm.phoneNumber = data.institution.phoneNumber
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/renren/institution/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'type': this.dataForm.type,
                'address': this.dataForm.address,
                'phoneNumber': this.dataForm.phoneNumber
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
