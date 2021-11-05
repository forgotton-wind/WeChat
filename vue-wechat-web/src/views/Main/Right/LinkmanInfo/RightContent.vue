<template>
  <div class="right-content-wrap">
    <img v-if="linkOrTemp" class="avatar" :src="linkman.avatar" />
    <img v-else class="avatar" :src="tempLinkman.avatar" />
    <h4 v-if="linkOrTemp" class="nickname">
      {{ linkman.alias ? linkman.alias : linkman.nickname }}
    </h4>
    <h4 v-else class="nickname">
      {{ tempLinkman.alias ? tempLinkman.alias : tempLinkman.nickname }}
    </h4>

    <div class="group-window-wrap" v-if="isgroup">
      <button v-if="isingroup" class="sendmessage-group" @click="sendMessagegroup">发群消息</button>
      <button v-if="isingroup" class="delgroup" @click="delGroup">删除群聊</button>
      <button v-else class="addgroup" @click="addGroup">添加群聊</button>
    </div>

    <div class="friend-window-wrap" v-else>
      <button v-if="isfriend" class="sendmessage-friend" @click="sendMessagefriend">发消息</button>
      <button v-if="isfriend" class="delfriend" @click="delFriend">删除好友</button>
      <button v-else class="addfriend" @click="addFriend">添加好友</button>
    </div>
  </div>
</template>

<script>
import avatar from "@/assets/default.png";

export default {
  name: "RightContent",
  data(){
    return {
      isgroup: false,
      isingroup: false,
      isfriend: false,
    };
  },
  computed: {
    linkman() {
      const currentLinkman = this.$store.state.currentLinkman;
      return this.$store.state.linkmans[currentLinkman];
    },
    tempLinkman() {
      return this.$store.state.tempLinkman;
    },
    linkOrTemp() {
      return this.$store.state.linkOrTemp;
    }
  },
  methods: {
    sendMessagegroup() {
      this.$store.commit("addChat", this.$store.state.currentLinkman);
    },

    addGroup() {

    },

    delGroup() {
      
    },

    sendMessagefriend() {
      this.$store.commit("addChat", this.$store.state.currentLinkman);
    },

    addFriend() {

    },

    delFriend() {
      
    },
  }
};
</script>

<style scoped>
.right-content-wrap {
  height: 300px;
  padding: 80px 0;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.avatar {
  width: 100px;
  height: 100px;
  display: block;
  margin-bottom: 22px;
}

.nickname {
  font-size: 24px;
  line-height: 38.4px;
  height: 38.4px;
  font-weight: 400;
  margin: 0 0 40px;
}

.sendmessage-group {
  width: 200px;
  height: 40px;
  border: none;
  outline: none;
  background-color: #42ac3e;
  border-radius: 4px;
  color: #fff;
  font-size: 14px;
  cursor: pointer;
  margin-top: 5px;
}

.addgroup {
  width: 200px;
  height: 40px;
  border: none;
  outline: none;
  background-color: #42ac3e;
  border-radius: 4px;
  color: #fff;
  font-size: 14px;
  cursor: pointer;
  margin-top: 5px;
}

.delgroup {
  width: 200px;
  height: 40px;
  border: none;
  outline: none;
  background-color: #42ac3e;
  border-radius: 4px;
  color: #fff;
  font-size: 14px;
  cursor: pointer;
  margin-top: 5px;
}

.sendmessage-friend {
  width: 200px;
  height: 40px;
  border: none;
  outline: none;
  background-color: #42ac3e;
  border-radius: 4px;
  color: #fff;
  font-size: 14px;
  cursor: pointer;
  margin-top: 5px;
}

.addfriend {
  width: 200px;
  height: 40px;
  border: none;
  outline: none;
  background-color: #42ac3e;
  border-radius: 4px;
  color: #fff;
  font-size: 14px;
  cursor: pointer;
  margin-top: 5px;
}

.delfriend {
  width: 200px;
  height: 40px;
  border: none;
  outline: none;
  background-color: #42ac3e;
  border-radius: 4px;
  color: #fff;
  font-size: 14px;
  cursor: pointer;
  margin-top: 5px;
}
</style>
