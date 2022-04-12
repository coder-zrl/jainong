<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="物资名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="物资名称"></el-input>
    </el-form-item>
    <el-form-item label="物资计数单位" prop="unit">
      <el-input v-model="dataForm.unit" placeholder="物资计数单位"></el-input>
    </el-form-item>
    <el-form-item label="物资进价" prop="purchasePrice">
      <el-input v-model="dataForm.purchasePrice" placeholder="物资进价"></el-input>
    </el-form-item>
    <el-form-item label="物资售价" prop="sellPrice">
      <el-input v-model="dataForm.sellPrice" placeholder="物资售价"></el-input>
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
          unit: '',
          purchasePrice: '',
          sellPrice: ''
        },
        dataRule: {
          name: [
            { required: true, message: '物资名称不能为空', trigger: 'blur' }
          ],
          unit: [
            { required: true, message: '物资计数单位不能为空', trigger: 'blur' }
          ],
          purchasePrice: [
            { required: true, message: '物资进价不能为空', trigger: 'blur' }
          ],
          sellPrice: [
            { required: true, message: '物资售价不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/renren/supplies/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.supplies.name
                this.dataForm.unit = data.supplies.unit
                this.dataForm.purchasePrice = data.supplies.purchasePrice
                this.dataForm.sellPrice = data.supplies.sellPrice
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
              url: this.$http.adornUrl(`/renren/supplies/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'unit': this.dataForm.unit,
                'purchasePrice': this.dataForm.purchasePrice,
                'sellPrice': this.dataForm.sellPrice
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
