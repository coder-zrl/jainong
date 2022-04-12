<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="顾客名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="顾客名称"></el-input>
    </el-form-item>
    <el-form-item label="顾客住址" prop="address">
      <el-input v-model="dataForm.address" placeholder="顾客住址"></el-input>
    </el-form-item>
    <el-form-item label="顾客电话" prop="phoneNumber">
      <el-input v-model="dataForm.phoneNumber" placeholder="顾客电话"></el-input>
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
          address: '',
          phoneNumber: ''
        },
        dataRule: {
          name: [
            { required: true, message: '顾客名称不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '顾客住址不能为空', trigger: 'blur' }
          ],
          phoneNumber: [
            { required: true, message: '顾客电话不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/renren/customer/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.customer.name
                this.dataForm.address = data.customer.address
                this.dataForm.phoneNumber = data.customer.phoneNumber
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
              url: this.$http.adornUrl(`/renren/customer/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
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
