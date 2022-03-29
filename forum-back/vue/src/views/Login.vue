<template>
  <div style="width:100%;height:100vh;background-color:darkslateblue; overflow: hidden">
    <div style="width: 400px; margin: 100px auto">
      <div style="color: #cccccc; font-size: 30px;text-align: center; padding: 30px 0">欢迎登录</div>
      <el-form ref="form" :model="form" size="normal" :rules="rules">
        <el-form-item prop="username">
          <el-input :prefix-icon="Avatar" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input :prefix-icon="Lock" v-model="form.password" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;" type="primary" @click="login">登 录</el-button>
        </el-form-item>
      </el-form>
    </div>


  </div>
</template>

<script>
import request from "../utils/request";
import {Avatar,Lock} from '@element-plus/icons'
export default {
  name: "Login",
  components:{
    Avatar,
    Lock,
  },
  data() {
    return {
      form: {},
      Avatar,
      Lock,
      rules: {
        username: [
          {
            required: true,
            message: '请输入用户名',
            trigger: 'blur',
          }],
        password: [
          {
            required: true,
            message: '请输入密码',
            trigger: 'blur',
          }],
      }
    }
  },

  methods: {
    login() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          request.post("/user/login", this.form).then(res => {
            if (res.code == '0') {
              this.$message({
                type: "success",
                message: "登录成功"
              })
              sessionStorage.setItem("user",JSON.stringify(res.data)); //缓存用户信息
              this.$router.push("/");   //登录成功之后进行页面的跳转
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    }
  }
}
</script>

<style scoped>

</style>