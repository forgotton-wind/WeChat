<template>
  <div class="wrap">
   <div class="login-box">
     <div class="login-title-wrap">
        <div
          class="login-title"
          :class="{ 'login-title-selected': isLogin }"
          @click="isLogin = true"
        >
          登录
        </div>
        <div
          class="login-title"
          :class="{ 'login-title-selected': !isLogin }"
          @click="isLogin = false"
        >
          注册
        </div>
      </div>

      <div class="login-main-wrap" v-if="isLogin">
        <div class="login-main-title">欢迎登录</div>
        <div class="login-main-input">
          <input v-model="account" class="login-input" type="text" placeholder="账号" />
          <input v-model="password" class="login-input" type="password" placeholder="密码" />
          <button class="login-btn login-btn-login" v-on:click="handleLogin">
            登 录
          </button>
        </div>
      </div>
      <div class="login-main-wrap" v-else>
        <div class="login-main-title">欢迎注册</div>
        <div class="login-main-input">
          <input v-model="account" class="login-input" type="text" placeholder="账号" />
          <input v-model="password" class="login-input" type="password" placeholder="密码" />
          <input v-model="password2" class="login-input" type="password" placeholder="确认密码" />
          <button class="login-btn login-btn-register" v-on:click="handleRegister">注 册</button>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import axios from 'axios'
import Qs from 'qs'

export default {
  name: "Login",
  data() {
    return {
      isLogin: true,
      account:'',
      password:'',
      password2:''
    };

  },
  methods: {
    handleLogin() {
      var that = this;
      var mydata={
        u_account:that.account,
        u_password:that.password
      }
      //在这里进行跨域请求
      that.axios({
        method: "post",
        url: 'http://127.0.0.1:8077/WeChat/user/login?user_account='+mydata.u_account+'&user_password='+mydata.u_password,
        data:Qs.stringify(mydata)
      })
      .then(function(res) {
        console.log(res);
        if (res.data.msg=="登录成功!") {
          //登陆成功后更新myself信息
          that.$store.state.myself.id = res.data.data.userPo.uid
          that.$store.state.myself.account = res.data.data.userPo.userAccount
          that.$store.state.myself.nickname = res.data.data.userPo.nickName
          that.$store.state.myself.name = res.data.data.userPo.name
          that.$store.state.myself.sex = res.data.data.userPo.sex
          that.$store.state.myself.birthday = res.data.data.userPo.birthday
          that.$store.state.myself.email = res.data.data.userPo.email
          that.$store.state.myself.schoolname = res.data.data.userPo.schoolName
          that.$store.state.myself.city = res.data.data.userPo.city
          that.$store.state.myself.bloodtype = res.data.data.userPo.bloodType
          that.$store.state.myself.avatar = res.data.data.userPo.gravatar
          //登陆成功后更新linkman信息
          for (let i=0; i<res.data.data.linkManList.length; ++i) {
            let linkman = res.data.data.linkManList[i]
            that.$store.state.tempLinkman.id = linkman.uid
            that.$store.state.tempLinkman.account = linkman.userAccount
            that.$store.state.tempLinkman.nickname = linkman.nickName
            that.$store.state.tempLinkman.name = linkman.name
            that.$store.state.tempLinkman.sex = linkman.sex
            that.$store.state.tempLinkman.birthday = linkman.birthday
            that.$store.state.tempLinkman.email = linkman.email
            that.$store.state.tempLinkman.schoolname = linkman.schoolName
            that.$store.state.tempLinkman.city = linkman.city
            that.$store.state.tempLinkman.bloodtype = linkman.bloodType
            that.$store.state.tempLinkman.avatar = linkman.gravatar
            that.$store.state.linkmans.push(that.$store.state.tempLinkman);
          }
          //切换到主页面
          that.$router.push("main");
        } else {
          alert(res.data.msg);
        }
      })
      .catch(function(err) {
        console.log(err);
      });
    },
	
    handleRegister() {
        var that = this;
        var mydata={
          u_account:that.account,
          u_password:that.password,
          u_password2:that.password2
        }

        that.axios({
          method: "post",
          url: 'http://127.0.0.1:8077/WeChat/user/register?user_account='+mydata.u_account+'&user_password='+mydata.u_password+'&confirm_password='+mydata.u_password2,
          data:Qs.stringify(mydata)
        })
        .then(function(res) {
          console.log(res);
          if (res.data.msg=="注册成功!") {
            alert(res.data.msg);
            that.isLogin = true;
          } else {
            alert(res.data.msg);
          }
        })
        .catch(function(err) {
          console.log(err);
        });
    }
  }
};
</script>

<style scoped>
.wrap {
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.login-box {
  min-width: 500px;
  width: 500px;
  min-height: 500px;
  height: 500px;
  display: flex;
  flex-direction: column;
  background-color: #fff;
  box-shadow: 0 2px 10px #999;
}

.login-title-wrap {
  width: 100%;
  height: 100px;
  display: flex;
}

.login-title {
  font-size: 32px;
  flex-grow: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #28af62;
  color: #fff;
  cursor: pointer;
}

.login-title-selected {
  background-color: #2dcc70;
}

.login-main-wrap {
  flex-grow: 1;
}

.login-main-title {
  text-align: center;
  line-height: 80px;
  font-size: 24px;
}

input::-webkit-input-placeholder,
textarea::-webkit-input-placeholder {
  color: #d4d4d4;
}

.login-main-input {
  display: flex;
  flex-direction: column;
  padding: 0 20px 10px;
  color: #d4d4d4;
}

.login-input {
  margin-top: 10px;
  padding: 18px 10px;
  line-height: 24px;
  height: 24px;
  border: 1px solid #efefef;
  font-size: 18px;
  outline: none;
  transition: 0.4s;
}

.login-input:focus {
  border-color: #2dcc70;
  transition: 0.4s;
}

.login-btn {
  border: none;
  outline: none;
  background-color: #2dcc70;
  color: #fff;
  font-size: 28px;
  line-height: 56px;
  height: 56px;
  cursor: pointer;
}

.login-btn-login {
  margin-top: 92px;
}

.login-btn-register {
  margin-top: 20px;
}

.login-btn:active {
  background-color: #28af62;
}
</style>
