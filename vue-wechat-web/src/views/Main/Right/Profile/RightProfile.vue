<template>
    <div class="right-profile-wrap">
      <div class="profile-account-information">
        <div class="acount-information-left">
          <img class="avatar" :src="myself.avatar" />
        </div>
        <div class="acount-information-right">
          <h4 class="avatar-label"> 头 像 修 改 </h4>
          <input v-model="avater" class="avatar-input" type="text" placeholder="头像链接" />
          <h4 class="nickname-label"> 昵 称 修 改 </h4>
          <input v-model="nickname" class="nickname-input" type="text" placeholder="昵称" />
          <h4 class="password-label"> 密 码 修 改 </h4>
          <input v-model="password" class="password-input" type="text" placeholder="密码" />
        </div>
      </div>

      <div class="profile-personal-information">
        <div class="personal-information-left">
          <h4 class="name-label"> 姓 名 修 改 </h4>
          <h4 class="sex-label"> 性 别 修 改 </h4>
          <!-- <h4 class="birthday-label"> 生 日 修 改 </h4> -->
          <h4 class="email-label"> 邮 箱 修 改 </h4>
          <h4 class="schoolname-label"> 学 校 修 改 </h4>
          <h4 class="city-label"> 城 市 修 改 </h4>
          <h4 class="bloodtype-label"> 血 型 修 改 </h4>
        </div>
        <div class="personal-information-right">
          <input v-model="name" class="name-input" type="text" placeholder="姓名" />
          <input v-model="sex" class="sex-input" type="text" placeholder="性别" />
          <!-- <input v-model="birthday" class="birthday-input" type="date" placeholder="生日" /> -->
          <input v-model="email" class="email-input" type="text" placeholder="邮箱" />
          <input v-model="schoolname" class="schoolname-input" type="text" placeholder="学校" />
          <input v-model="city" class="city-input" type="text" placeholder="城市" />
          <input v-model="bloodtype" class="bloodtype-input" type="text" placeholder="血型" />
        </div>
      </div>
      <button class="modifyprofile-btn" @click="commitModify">确认修改</button>
    </div>
    
</template>

<script>
import axios from 'axios'
import Qs from 'qs'

export default {
    name :'modifyprofile',
    data() {
        return {
            avater:'',
            nickname:'',
            password:'',
            name:'',
            sex:'',
            // birthday: new Date(),
            email:'',
            schoolname:'',
            city:'',
            bloodtype:''
        }
    },
    computed:{
        myself() {
        return this.$store.state.myself;
        },
    },

    methods:{
      commitModify(){
        var that = this;
        var mydata={
          uid: that.$store.state.myself.id,
          password: that.password,
          gravatar: that.avatar,
          nickName: that.nickname,
          name: that.name,
          sex: that.sex,
          // birthday: that.birthday,
          email: that.email,
          schoolName: that.schoolname,
          city: that.city,
          bloodType: that.bloodtype,
          state: 0,
        }
      //在这里进行跨域请求
      that.axios({
        method: "put",
        url: 'http://127.0.0.1:8077/WeChat/user/update',
        data: mydata
      })
      .then(function(res) {
        console.log(res);
        if (res.data.msg=="修改成功!") {
          alert(res.data.msg);
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

<style>
.right-profile-wrap{
text-align: center;
margin: 0;
padding: 0;
}

.profile-account-information{
width: 600px;
height:50%;
}

.acount-information-left{
float: left;
height: 100%;
width:300px;
}
.avatar{
height: 50%;
width:300px;
}
.acount-information-right{

margin-left: 350px;
height:100%;
}
.avatar-label{
text-align: center;
line-height: 10px;
font-size: 18px;
}
.avatar-input{
padding: 15px 35px;
line-height: 20px;
height: 15px;
border: 1px solid #efefef;
font-size: 18px;
outline: none;
transition: 0.4s;
}
.nickname-label{
text-align: center;
line-height: 10px;
font-size: 18px;
}
.nickname-input{
padding: 15px 35px;
line-height: 20px;
height: 15px;
border: 1px solid #efefef;
font-size: 18px;
outline: none;
transition: 0.4s;
}
.password-label{
text-align: center;
line-height: 10px;
font-size: 18px;
}
.password-input{
padding: 15px 35px;
line-height: 20px;
height: 15px;
border: 1px solid #efefef;
font-size: 18px;
outline: none;
transition: 0.4s;    
}
.profile-account-information::after{
content: '';
display: block;
visibility: hidden;
clear: both
}

.profile-personal-information{
width: 600px;
height: 50%;
}
.personal-information-left{
text-align: center;
float: left;
height: 100%;
width:300px;
}
.personal-information-right{
margin-left: 350px;
height:100%;
}

.name-label{
text-align: center;
line-height: 10px;
font-size: 18px;
}
.name-input{
padding: 15px 35px;
line-height: 20px;
height: 15px;
border: 2px solid #efefef;
font-size: 18px;
outline: none;
transition: 0.4s;     
}
.sex-label{
text-align: center;
font-size: 18px;
}
.sex-input{
padding: 15px 35px;
line-height: 20px;
height: 15px;
border: 2px solid #efefef;
font-size: 18px;
outline: none;
transition: 0.4s;    
}
.birthday-label{
text-align: center;
font-size: 18px;
}
.birthday-input{
padding: 15px 35px;
line-height: 20px;
height: 15px;
border: 2px solid #efefef;
font-size: 18px;
outline: none;
transition: 0.4s;    
}
.email-label{
text-align: center;
font-size: 18px;
}
.email-input{
padding: 15px 35px;
line-height: 20px;
height: 15px;
border: 2px solid #efefef;
font-size: 18px;
outline: none;
transition: 0.4s;    
}
.schoolname-label{
text-align: center;
font-size: 18px;
}
.schoolname-input{
padding: 15px 35px;
line-height: 20px;
height: 15px;
border: 2px solid #efefef;
font-size: 18px;
outline: none;
transition: 0.4s;    
}
.city-label{
text-align: center;
font-size: 18px;
}
.city-input{
padding: 15px 35px;
line-height: 20px;
height: 15px;
border: 2px solid #efefef;
font-size: 18px;
outline: none;
transition: 0.4s;    
}
.bloodtype-label{
text-align: center;
font-size: 18px;
}
.bloodtype-input{
padding: 15px 35px;
line-height: 20px;
height: 15px;
border: 2px solid #efefef;
font-size: 18px;
outline: none;
transition: 0.4s;    
}
.modifyprofile-btn{
border: none;
outline: none;
background-color: #2dcc70;
color: #fff;
font-size: 15px;
height: 30px;
cursor: pointer;
}
.profile-personal-information::after{
content: '';
display: block;
visibility: hidden;
clear: both
}
</style>
