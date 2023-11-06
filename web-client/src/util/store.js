// store.js
import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    user: null, // 这将存储用户信息
  },
  mutations: {
    setUser (state, user) {
      state.user = user;
    },
    clearUser (state) {
      state.user = null;
    },
  },
  actions: {
    loginUser ({ commit }, user) {
      commit('setUser', user);
    },
    logoutUser ({ commit }) {
      commit('clearUser');
    },
  },
});

export default store;