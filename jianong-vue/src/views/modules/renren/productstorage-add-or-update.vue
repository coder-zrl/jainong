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
    <el-form-item label="产品进价" prop="purchasePrice">
      <el-input v-model="dataForm.purchasePrice" placeholder="产品进价"></el-input>
    </el-form-item>
    <el-form-item label="入库总斤数" prop="totalJinNumber">
      <el-input v-model="dataForm.totalJinNumber" placeholder="入库总斤数"></el-input>
    </el-form-item>
    <el-form-item label="金额" prop="amount">
      <el-input v-model="dataForm.amount" placeholder="金额"></el-input>
    </el-form-item>
    <el-form-item label="校验人" prop="checkOne">
      <el-input v-model="dataForm.checkOne" placeholder="校验人"></el-input>
    </el-form-item>
    <el-form-item label="经手人" prop="handler">
      <el-input v-model="dataForm.handler" placeholder="经手人"></el-input>
    </el-form-item>
    <el-form-item label="入库时间" prop="storageTime">
      <el-input v-model="dataForm.storageTime" placeholder="入库时间"></el-input>
    </el-form-item>
    <el-form-item label="片名" prop="geographicalName">
      <el-input v-model="dataForm.geographicalName" placeholder="片名"></el-input>
    </el-form-item>
    <el-form-item label="农户" prop="farmerId">
      <el-input v-model="dataForm.farmerId" placeholder="农户"></el-input>
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
          purchasePrice: '',
          totalJinNumber: '',
          amount: '',
          checkOne: '',
          handler: '',
          storageTime: '',
          geographicalName: '',
          farmerId: ''
        },
        dataRule: {
          productId: [
            { required: true, message: '产品编号不能为空', trigger: 'blur' }
          ],
          productName: [
            { required: true, message: '产品名称不能为空', trigger: 'blur' }
          ],
          purchasePrice: [
            { required: true, message: '产品进价不能为空', trigger: 'blur' }
          ],
          totalJinNumber: [
            { required: true, message: '入库总斤数不能为空', trigger: 'blur' }
          ],
          amount: [
            { required: true, message: '金额不能为空', trigger: 'blur' }
          ],
          checkOne: [
            { required: true, message: '校验人不能为空', trigger: 'blur' }
          ],
          handler: [
            { required: true, message: '经手人不能为空', trigger: 'blur' }
          ],
          storageTime: [
            { required: true, message: '入库时间不能为空', trigger: 'blur' }
          ],
          geographicalName: [
            { required: true, message: '片名不能为空', trigger: 'blur' }
          ],
          farmerId: [
            { required: true, message: '农户不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/renren/productstorage/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productId = data.productStorage.productId
                this.dataForm.productName = data.productStorage.productName
                this.dataForm.purchasePrice = data.productStorage.purchasePrice
                this.dataForm.totalJinNumber = data.productStorage.totalJinNumber
                this.dataForm.amount = data.productStorage.amount
                this.dataForm.checkOne = data.productStorage.checkOne
                this.dataForm.handler = data.productStorage.handler
                this.dataForm.storageTime = data.productStorage.storageTime
                this.dataForm.geographicalName = data.productStorage.geographicalName
                this.dataForm.farmerId = data.productStorage.farmerId
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
              url: this.$http.adornUrl(`/renren/productstorage/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productId': this.dataForm.productId,
                'productName': this.dataForm.productName,
                'purchasePrice': this.dataForm.purchasePrice,
                'totalJinNumber': this.dataForm.totalJinNumber,
                'amount': this.dataForm.amount,
                'checkOne': this.dataForm.checkOne,
                'handler': this.dataForm.handler,
                'storageTime': this.dataForm.storageTime,
                'geographicalName': this.dataForm.geographicalName,
                'farmerId': this.dataForm.farmerId
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
