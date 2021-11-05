import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import avatar from "../assets/default.png";
import group from "../assets/default_group.png";
import user from "../assets/user.jpeg";

const store = new Vuex.Store({
  state: {
    token: "",
    isShowExpression: false,
    isShowMembers: false,
    isShowMemberInfo: false,
    isShowMyInfo: false,
    isShowChatterInfo: false,
    isShowSearch: false,
    chatCount: 1,
    currentTabIndex: 0,
    currentRight: 0,
    currentLinkman: 0,
    lIndex: 0,
    linkOrTemp: 1,
    isgroup: false,
    isingroup: false,
    isfriend: false,
    myself: {
      id: 1,
      account: "",
      //TODO 考虑还要不要password  可能不需要  没办法逆着解码
      password: "",
      nickname: "",
      name: "",
      sex: "",
      birthday: "",
      email: "",
      schooolname: "",
      city: "",
      bloodtype: "",
      avatar: ""
    },
    chats: [
      {
        chatId: 0,
        linkmanIndex: 1,
        isMute: false,
        isOnTop: false,
        messages: [
          {
            avatar,
            ctn: "你好",
            nickname: "用户一",
            sender: 1,
            time: new Date("2011-01-11 11:11:11"),
            type: "chat"
          }
        ]
      }
    ],
    tempLinkman: {
      id: 1,
      type: "",
      account: "",
      password: "",
      nickname: "",
      name: "",
      sex: "",
      birthday: "",
      email: "",
      schooolname: "",
      city: "",
      bloodtype: "",
      avatar: ""
    },
    linkmans: [
      {
        id: 2,
        type: "group",
        members: ["p1", "p2"],
        nickname: "这是群组",
        gender: "",
        region: "这是地区",
        avatar: group
      },
    ],
    currentChatId: -1
  },
  mutations: {
    setExpression(state, isShowExpression) {
      if (isShowExpression) {
        state.isShowMembers = false;
        state.isShowMemberInfo = false;
        state.isShowMyInfo = false;
        state.isShowChatterInfo = false;
      }
      state.isShowExpression = isShowExpression;
    },
    setMembers(state, isShowMembers) {
      if (isShowMembers) {
        state.isShowExpression = false;
        state.isShowMyInfo = false;
        state.isShowChatterInfo = false;
      }
      state.isShowMembers = isShowMembers;
    },
    setMemberInfo(state, isShowMemberInfo) {
      state.isShowMemberInfo = isShowMemberInfo;
    },
    setChatterInfo(state, isShowChatterInfo) {
      if (isShowChatterInfo) {
        state.isShowMembers = false;
        state.isShowMemberInfo = false;
        state.isShowExpression = false;
        state.isShowMyInfo = false;
      }
      state.isShowChatterInfo = isShowChatterInfo;
    },
    setMyInfo(state, isShowMyInfo) {
      if (isShowMyInfo) {
        state.isShowMembers = false;
        state.isShowMemberInfo = false;
        state.isShowExpression = false;
        state.isShowChatterInfo = false;
      }
      state.isShowMyInfo = isShowMyInfo;
    },
    setCurrentTab(state, tabIndex) {
      state.currentTabIndex = tabIndex;
    },
    setCurrentRight(state, rightIndex) {
      state.currentRight = rightIndex;
    },
    setCurrentLinkman(state, index) {
      state.currentLinkman = index;
    },
    hideAll(state) {
      state.isShowMembers = false;
      state.isShowMemberInfo = false;
      state.isShowExpression = false;
      state.isShowChatterInfo = false;
      state.isShowMyInfo = false;
      state.isShowSearch = false;
    },
    setChatId(state, id) {
      state.currentChatId = id;
      state.currentRight = 0;
    },
    setSearch(state, isShowSearch) {
      state.isShowSearch = isShowSearch;
    },
    sendMessage(state, msg) {
      for (let chat of state.chats) {
        if (chat.chatId === state.currentChatId) {
          chat.messages.push(msg);
          break;
        }
      }
    },
    getIndex(state, kind) {
      state.lIndex = 0;
      for (let i=0; i<state.linkmans.length; ++i) {
        if (state.linkmans[i].type === kind) {
          state.lIndex++;
        }
      }
    },
    addLinkman(state) {
      state.linkmans.push(tempLinkman);
    },
    addChat(state, linkmanIndex) {
      state.currentTabIndex = 0;
      state.currentRight = 0;
      for (let i = 0; i < state.chats.length; i++) {
        let chat = state.chats[i];
        if (chat.linkmanIndex === linkmanIndex) {
          state.chats.splice(i, 1);
          state.chats = [chat].concat(state.chats);
          state.currentChatId = chat.chatId;
          return;
        }
      }
      state.chats = [
        {
          linkmanIndex,
          chatId: state.chatCount,
          isMute: false,
          isOnTop: false,
          messages: []
        }
      ].concat(state.chats);
      state.currentChatId = state.chatCount;

      state.chatCount += 1;
    }
  }
});

export default store;
