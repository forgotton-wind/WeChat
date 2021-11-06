<template>
  <div class="left-chat-list-tab-wrap">
    <div v-for="(kind, index) in kinds" :key="'kind' + index">
      <div class="kind-title">{{ kind.title }}</div>
      <div
        v-for="(linkman, lIndex) in kind.linkmans"
        :key="'linkman' + lIndex"
        class="wrap"
        :class="{
          'wrap-selected': currentLinkman === 'k' + index + 'l' + lIndex
        }"
        @click="handleShowDetail(index, lIndex)"
        @dblclick="handleNewChat(index, lIndex)"
      >
        <div class="avatar-wrap">
          <img class="avatar" :src="linkman.avatar" />
        </div>
        <div class="nickname">
          {{ linkman.account ? linkman.account : linkman.nickname }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import avatar from "@/assets/default.png";

export default {
  name: "TabChat",
  data() {
    return {
      currentLinkman: ""
    };
  },
  computed: {
    kinds() {
      let linkmans = this.$store.state.linkmans;
      let kinds = [];
      let kindCount = -1;
      let currentType = "";
      for (let linkman of linkmans) {
        if (linkman.type !== currentType) {
          kinds.push({
            title: linkman.type === "group" ? "群组" : linkman.type,
            linkmans: []
          });

          currentType = linkman.type;
          kindCount += 1;
        }
        kinds[kindCount].linkmans.push({ ...linkman });
      }
      return kinds;
    }
  },
  methods: {
    handleShowDetail(kindIndex, lIndex) {
      var that = this
      this.$store.state.linkOrTemp = 1;
      this.currentLinkman = "k" + kindIndex + "l" + lIndex;
      const id = this.kinds[kindIndex].linkmans[lIndex].id;

      const linkmans = this.$store.state.linkmans;
      this.$store.commit("setCurrentRight", 1);
      for (let i = 0; i < linkmans.length; i++) {
        if (id === linkmans[i].id && linkmans[i].type === this.kinds[kindIndex].linkmans[lIndex].type) {
          this.$store.state.isfriend = true
          let linkman = linkmans[i]
          that.$store.state.tempLinkman.id = linkman.id
          that.$store.state.tempLinkman.account = linkman.account
          that.$store.state.tempLinkman.nickname = linkman.nickname
          that.$store.state.tempLinkman.name = linkman.name
          that.$store.state.tempLinkman.sex = linkman.sex
          that.$store.state.tempLinkman.birthday = linkman.birthday
          that.$store.state.tempLinkman.email = linkman.email
          that.$store.state.tempLinkman.schoolname = linkman.schoolname
          that.$store.state.tempLinkman.city = linkman.city
          that.$store.state.tempLinkman.bloodtype = linkman.bloodtype
          that.$store.state.tempLinkman.avatar = linkman.avatar
          this.$store.commit("setCurrentLinkman", i);
          break;
        }
      }
    },

    handleNewChat(kindIndex, lIndex) {
      for (let i = 0; i < this.$store.state.linkmans.length; i++) {
        const linkman = this.$store.state.linkmans[i];
        if (linkman.id === this.kinds[kindIndex].linkmans[lIndex].id
        && linkman.type == this.kinds[kindIndex].linkmans[lIndex].type) {
          this.$store.commit("addChat", i);
          return;
        }
      }
    }
  }
};
</script>

<style scoped>
.kind-title {
  color: #787b87;
  background-color: #292d32;
  padding: 2px 18px;
  font-size: 14px;
  height: 24px;
  display: flex;
  align-items: center;
}

.wrap {
  display: flex;
  height: 30px;
  padding: 10px 18px 9px;
  border-bottom: 1px solid rgb(41, 44, 51);
  cursor: pointer;
}

.wrap-selected {
  background-color: rgb(59, 64, 71);
}

.avatar-wrap {
  margin-right: 10px;
}

.avatar {
  width: 30px;
  height: 30px;
  border-radius: 2px;
}

.nickname {
  color: #fff;
  display: flex;
  align-items: center;
  font-size: 13px;
}
</style>
