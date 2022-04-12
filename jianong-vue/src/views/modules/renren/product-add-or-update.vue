<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="产品名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="产品名称"></el-input>
    </el-form-item>
    <el-form-item label="产品计数单位" prop="unit">
      <el-input v-model="dataForm.unit" placeholder="产品计数单位"></el-input>
    </el-form-item>
    <el-form-item label="产品等级" prop="level">
      <el-input v-model="dataForm.level" placeholder="产品等级"></el-input>
    </el-form-item>
    <el-form-item label="产品产地" prop="origin">
      <el-input v-model="dataForm.origin" placeholder="产品产地"></el-input>
    </el-form-item>
    <el-form-item label="产品运费" prop="freight">
      <el-input v-model="dataForm.freight" placeholder="产品运费"></el-input>
    </el-form-item>
    <el-form-item label="产品进价" prop="purchasePrice">
      <el-input v-model="dataForm.purchasePrice" placeholder="产品进价"></el-input>
    </el-form-item>
    <el-form-item label="产品包装物" prop="wrapPage">
      <el-input v-model="dataForm.wrapPage" placeholder="产品包装物"></el-input>
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
          level: '',
          origin: '',
          freight: '',
          purchasePrice: '',
          wrapPage: ''
        },
        dataRule: {
          name: [
            { required: true, message: '产品名称不能为空', trigger: 'blur' }
          ],
          unit: [
            { required: true, message: '产品计数单位不能为空', trigger: 'blur' }
          ],
          level: [
            { required: true, message: '产品等级不能为空', trigger: 'blur' }
          ],
          origin: [
            { required: true, message: '产品产地不能为空', trigger: 'blur' }
          ],
          freight: [
            { required: true, message: '产品运费不能为空', trigger: 'blur' }
          ],
          purchasePrice: [
            { required: true, message: '产品进价不能为空', trigger: 'blur' }
          ],
          wrapPage: [
            { required: true, message: '产品包装物不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/renren/product/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.product.name
                this.dataForm.unit = data.product.unit
                this.dataForm.level = data.product.level
                this.dataForm.origin = data.product.origin
                this.dataForm.freight = data.product.freight
                this.dataForm.purchasePrice = data.product.purchasePrice
                this.dataForm.wrapPage = data.product.wrapPage
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
              url: this.$http.adornUrl(`/renren/product/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'unit': this.dataForm.unit,
                'level': this.dataForm.level,
                'origin': this.dataForm.origin,
                'freight': this.dataForm.freight,
                'purchasePrice': this.dataForm.purchasePrice,
                'wrapPage': this.dataForm.wrapPage
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
