// 登录接口
import service from '../http/index.js'
import store from '../util/store.js'; // 导入Vuex操作

/**
 * 注册接口
 * @param {userType:string, name:string,nickname:string,phone:string,avatar:string,email:string,pwd:string,status:string,education:string,teamId:string,role:string} param 
 * @returns 
 */
export async function register (param) {
  return await service.post('/auth/register', param)
}

/**
 * 登录接口
 * @param {userType:string,phone:string,pwd:string} param 
 * @returns 
 */

export async function login (param) {
  const response = await service.post('/auth/login', param);
  if (response.status === 200) {
    console.log(response.data)
    const user = response.data.data; // 假设用户数据在响应中返回
    store.dispatch('loginUser', user);
  }
  return response;
}


/**
 * 登出接口
 * @returns 
 */
export async function logout () {
  store.dispatch('logoutUser');
  return await service.get('/auth/logout')
}
/**
 * 获取当前用户
 */
export async function getCurrentUser () {
  return await service.get('/auth/user')
}
