// 登录接口
import service from '../http/index.js'

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
  return await service.post('/auth/login', param)
}

/**
 * 登出接口
 * @returns 
 */
export async function logout () {
  return await service.get('/auth/logout')
}
/**
 * 获取当前用户
 */
export async function getCurrentUser () {
  return await service.get('/auth/user')
}
