<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="产品编号" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="产品编号"></el-input>
    </el-form-item>
    <el-form-item label="产品名称" prop="productName">
      <el-input v-model="dataForm.productName" placeholder="产品名称"></el-input>
    </el-form-item>
    <el-form-item label="库存数量" prop="inventoryNumber">
      <el-input v-model="dataForm.inventoryNumber" placeholder="库存数量"></el-input>
    </el-form-item>
    <el-form-item label="盘点数量" prop="physicalNumber">
      <el-input v-model="dataForm.physicalNumber" placeholder="盘点数量"></el-input>
    </el-form-item>
    <el-form-item label="产品盘存状态：盘盈、盘亏" prop="inventoryStatus">
      <el-input v-model="dataForm.inventoryStatus" placeholder="产品盘存状态：盘盈、盘亏"></el-input>
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
          productId: '',
          productName: '',
          inventoryNumber: '',
          physicalNumber: '',
          inventoryStatus: ''
        },
        dataRule: {
          productId: [
            { required: true, message: '产品编号不能为空', trigger: 'blur' }
          ],
          productName: [
            { required: true, message: '产品名称不能为空', trigger: 'blur' }
          ],
          inventoryNumber: [
            { required: true, message: '库存数量不能为空', trigger: 'blur' }
          ],
          physicalNumber: [
            { required: true, message: '盘点数量不能为空', trigger: 'blur' }
          ],
          inventoryStatus: [
            { required: true, message: '产品盘存状态：盘盈、盘亏不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/renren/productinventory/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productId = data.productInventory.productId
                this.dataForm.productName = data.productInventory.productName
                this.dataForm.inventoryNumber = data.productInventory.inventoryNumber
                this.dataForm.physicalNumber = data.productInventory.physicalNumber
                this.dataForm.inventoryStatus = data.productInventory.inventoryStatus
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
              url: this.$http.adornUrl(`/renren/productinventory/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productId': this.dataForm.productId,
                'productName': this.dataForm.productName,
                'inventoryNumber': this.dataForm.inventoryNumber,
                'physicalNumber': this.dataForm.physicalNumber,
                'inventoryStatus': this.dataForm.inventoryStatus
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
