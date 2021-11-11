<template>
  <div class="wrap" @click="handleHide">
    <div class="main">
      <div class="main-left">
        <left-header></left-header>
        <left-search></left-search>
        <left-chat-list></left-chat-list>
      </div>
      <div class="main-right">
        <keep-alive>
          <component :is="currentRight"></component>
        </keep-alive>
      </div>
    </div>
  </div>
</template>

<script>
import LeftHeader from "./Left/LeftHeader";
import LeftSearch from "./Left/LeftSearch";
import LeftChatList from "./Left/LeftChatList/LeftChatList";

import Chat from "./Right/Chat/Chat";
import LinkmanInfo from "./Right/LinkmanInfo/LinkmanInfo";
import Profile from "./Right/Profile/RightProfile";

import axios from 'axios'
import Qs from 'qs'

export default {
  name: "Main",
  components: {
    LeftHeader,
    LeftSearch,
    LeftChatList,
    Chat,
    LinkmanInfo,
    Profile,
  },
  mounted(){
    // 轮循
    this.timer = window.setInterval(() => {
      setTimeout(() => {
          //轮询有无新消息
          var that = this;
          var mydata={
            u_id:that.$store.state.myself.id,
          }

          that.axios({
            method: "get",
            url: 'http://127.0.0.1:8077/WeChat/message/inquire?id='+mydata.u_id,
            data:Qs.stringify(mydata)
          })
          .then(function(res) {
            console.log(res);
            if (res.data.msg=="有新消息") {
              for (let i=0; i<res.data.data.length; ++i) {
                var mydata  = {
                  ctn: res.data.data[i].content,
                  time: res.data.data[i].time,
                  type: res.data.data[i].typeId,
                  fromId: res.data.data[i].fromId,
                  toId: res.data.data[i].toId
                }
                that.$store.commit("receiveChat", mydata)
              }
            }
          })
          .catch(function(err) {
            console.log(err);
          });
          console.log("每秒轮询一次")
      }, 1)
    }, 1000);

    // 群聊轮循
    this.timer = window.setInterval(() => {
      setTimeout(() => {
          //轮询有无新消息
          var that = this;
          var mydata={
            u_id:that.$store.state.myself.id,
          }

          that.axios({
            method: "get",
            url: 'http://127.0.0.1:8077/WeChat/group/receive?u_id='+mydata.u_id,
            data:Qs.stringify(mydata)
          })
          .then(function(res) {
            console.log(res);
            if (res.data.msg=="有消息") {
              for (let i=0; i<res.data.data.length; ++i) {
                for (let j=0; j<res.data.data[i].length; ++j) {
                  var mydata  = {
                    ctn: res.data.data[i][j].content,
                    time: res.data.data[i][j].time,
                    type: res.data.data[i][j].type,
                    uId: res.data.data[i][j].uid,
                    gId: res.data.data[i][j].gid,
                    id: res.data.data[i][j].id,
                  }
                  that.$store.commit("receiveGroupChat", mydata)
                } 
              }
            }
          })
          .catch(function(err) {
            console.log(err);
          });
          console.log("每秒轮询一次2")
      }, 1)
    }, 1000);
  },
  destroyed(){
    clearInterval(this.timer)
  },
  data() {
    return {
      tabs: [Chat, LinkmanInfo, Profile]
    };
  },
  computed: {
    currentRight() {
      return this.tabs[this.$store.state.currentRight];
    }
  },
  methods: {
    handleHide() {
      this.$store.commit("hideAll");
    }
  }
};
</script>

<style scoped>
.wrap {
  height: 100vh;
  overflow: hidden;
}

.main {
  max-width: 1000px;
  min-width: 800px;
  height: 100%;
  border-radius: 3px;
  margin: 0 auto;
  display: flex;
}

.main-left {
  width: 280px;
  height: 100%;
  background-color: #2e3238;
}

.main-right {
  background-color: #eee;
  flex-grow: 1;
}
</style>
