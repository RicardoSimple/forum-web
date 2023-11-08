import service from '../http/index.js'

/**
 * 按照id获取企业
 * @param {string} id 
 * @returns 
 */
export async function getTeamById (id) {
  return await service.get('/team/get?id=' + id)
}

/**
 * 获取所有企业
 * @returns 
 */
export async function getAllTeam () {
  return await service.get('/team/all')
}

/**
 * 
 * @param {name:string,alias:string,industry:string,logo:string,link:string,code:string} param 
 * @returns 
 */
export async function addTeam (param) {
  return await service.post('/team/add', param)
}