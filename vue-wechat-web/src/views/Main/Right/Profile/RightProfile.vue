<template>
    <div class="right-profile-wrap">
        <img class="avatar" :src="myself.avatar" />
        <input v-model="avater" class="avater-input" type="text" placeholder="头像链接" />

        <div class="profile-basic-information">
            <h4 class="nickname"> {{ myself.nickname ? myself.nickname : myself.id }}</h4>
            <input v-model="avater" class="avater-input" type="text" placeholder="头像链接" />
            <h4 class="password"> {{ myself.password }}</h4>
            <input v-model="password" class="password-input" type="text" placeholder="密码修改" />
            <h4 class="name"> {{ myself.name }}</h4>
            <input v-model="name" class="name-input" type="text" placeholder="姓名修改" />
            <h4 class="sex"> {{ myself.sex }}</h4>
            <input v-model="sex" class="sex-input" type="text" placeholder="性别修改" />
            <h4 class="birthday"> {{ myself.birthday }}</h4>
            <input v-model="birthday" class="birthday-input" type="text" placeholder="生日修改" />
            <h4 class="email"> {{ myself.email }}</h4>
            <input v-model="email" class="email-input" type="text" placeholder="邮箱修改" />
            <h4 class="schoolname"> {{ myself.schoolname }}</h4>
            <input v-model="schoolname" class="schoolname-input" type="text" placeholder="学校修改" />
            <h4 class="city"> {{ myself.city }}</h4>
            <input v-model="city" class="city-input" type="text" placeholder="城市修改" />
            <h4 class="bloodtype"> {{ myself.bloodtype }}</h4>
            <input v-model="bloodtype" class="bloodtype-input" type="text" placeholder="血型修改" />
        </div>
        <button class="modifyprofile-btn" @click="commitModify">确认修改</button>
    </div>
    
</template>

<script>
export default {
    name :'modifyprofile',
    data() {
        return {
            avater:'',
            nickname:'',
            password:'',
            name:'',
            sex:'',
            birthday:'',
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
          that.$router.push("main");
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
.avatar{
width:200px;
height:200px
}
.avatar-input{

}
.profile-basic-information{

}
.nickname{

}
.nickname-input{
    
}
.password{

}
.password-input{
    
}
.name{

}
.name-input{
    
}
.sex{

}
.sex-input{
    
}
.birthday{

}
.birthday-input{
    
}
.email{

}
.email-input{
    
}
.schoolname{

}
.schoolname-input{
    
}
.city{

}
.city-input{
    
}
.bloodtype{

}
.bloodtype-input{
    
}
.modifyprofile-btn{

}
</style>
