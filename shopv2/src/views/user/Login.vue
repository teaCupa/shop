<template>
   <div>
      <el-form
              :rules="rules"
              ref="loginForm"
              v-loading="loading"
              element-loading-text="正在登录..."
              element-loading-spinner="el-icon-loading"
              element-loading-background="rgba(0, 0, 0, 0.8)"
              :model="loginForm"
              class="loginContainer">
         <h3 class="loginTitle">用户登录</h3>
         <el-form-item prop="username">
            <div style="display: flex">
               <i style="color: #4e7483;font-size: 35px;margin-top: 4px" class="el-icon-user"></i>
               <div style="margin-left: 10px;width: 300px"><el-input size="normal" type="text" v-model="loginForm.username" auto-complete="off"
                                                                     placeholder="请输入用户名"></el-input></div>
            </div>
         </el-form-item>
         <el-form-item prop="password">
            <div style="display: flex">
               <i style="color: #4e7483;font-size: 35px;margin-top: 4px" class="el-icon-user-solid"></i>
               <div style="margin-left: 10px;width: 300px"><el-input size="normal" type="password" v-model="loginForm.password" auto-complete="off"
                                                                     placeholder="请输入密码" @keydown.enter.native="submitLogin"></el-input>
               </div>
            </div>
         </el-form-item>
         <!--<el-checkbox size="normal" class="loginRemember" v-model="checked">remember me</el-checkbox>-->
         <!--<el-form-item prop="password">-->
            <!--<div  style="display: flex">-->
               <!--<el-input size="normal" type="text" v-model="loginForm.code" auto-complete="off"-->
                         <!--placeholder="点击图片更换验证码" @keydown.enter.native="submitLogin" style="margin-left: 18px;width: 180px"/>-->
               <!--<img :src=vcUrl style="width: 164px;height: 40px;margin-left: 6px" @click="updateVerifyCode" alt=""/>-->
            <!--</div>-->
         <!--</el-form-item>-->
         <!--<router-link :to="'/findPass/'+user.id">-->
         <router-link :to="'/findPass/'+1">
            <div style="margin-left:82%;font-size: 13px;color:#000000">忘记密码</div></router-link>
         <div style="display: flex;justify-content: space-around;margin-top: 8px">
            <el-button size="normal" type="primary" style="width: 42%;" @click="submitLogin">登录</el-button>
            <el-button size="normal" type="info" style="width: 42%;" @click="register">注册</el-button>
         </div>
      </el-form>
   </div>
</template>
<script>

   export default {
      name: "Login",
      data() {
         return {
            loading: false,
            vcUrl: '/captcha.jpg?time=' + new Date(),
            loginForm: {
               username: 'zs',
               password: '123',
               // code:''
            },
            checked: true,
            rules: {
               username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
               password: [{required: true, message: '请输入密码', trigger: 'blur'}],
               // code: [{required: true, message: '请输入验证码', trigger: 'blur'}]
            }
         }
      },
      computed:{
         user(){return this.$store.state.user.user}
      },
      methods: {
         updateVerifyCode(){
            this.vcUrl = '/captcha.jpg?time=' + new Date()
         },
         submitLogin() {
            this.$refs.loginForm.validate((valid) => {
               if (valid) {
                  this.loading = true;
                  this.postKeyValueRequest('/login',this.loginForm).then(resp => {
                     this.loading = false;
                     if(resp){
                        this.$store.commit('login', resp.data); //存储对象
                        this.$bus.emit('loadCart','aa')
                        // localStorage.setItem('token','Bearer '+resp.data.token)
                        let query = this.$route.query.id
                        if(query===undefined ){
                            this.$router.push('/');
                        }else if(query.startsWith('/product/'))
                            this.$router.push(query);
                     }
                  })
               } else {
                  this.$message.error('请输入所有字段');
                  return false;
               }
            });
         },
         register(){
            let routerJump = this.$router.resolve({
               path: '/register',
               query: {
                  id: 1,
               }
            });
            window.open(routerJump.href, '_blank');  //新开一个窗口
         }
      }
   }
</script>
<style>
   .loginContainer {
      border-radius: 15px;
      background-clip: padding-box;
      margin: 180px auto;
      width: 350px;
      padding: 15px 35px 15px 35px;
      background: #fff;
      border: 1px solid #eaeaea;
      box-shadow: 0 0 25px #cac6c6;
   }

   .loginTitle {
      margin: 15px auto 20px auto;
      text-align: center;
      color: #505458;
   }

   .loginRemember {
      text-align: left;
      margin: 0px 0px 15px 0px;
   }
</style>

