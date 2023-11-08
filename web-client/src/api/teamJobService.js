import service from '../http/index.js'

/**
 * 新增或修改岗位
 * @param {id:string,jobName:string,teamId:string,desc:string,content:string,type:string,tags:string[],count:int} param 
 * @returns 
 */
export async function addOrUpdateTeamJob (param) {
  return await service.post('/teamjob/add', param)
}

/**
 * 根据teamid获取岗位
 * @param {teamId:String} teamId 
 * @returns 
 */
export async function getTeamJobByTeamId (teamId) {
  return await service.get('/teamjob/getbyteamid?teamId=' + teamId);
}
/**
 * 根据id获岗位
 * @param {id:string} id 
 * @returns 
 */
export async function getTeamJobById (id) {
  return await service.get('/teamjob/get?id=' + id)
}

/**
 * 获取所有岗位
 * @returns 
 */
export async function getAllTeamJob () {
  return await service.get('/teamjob/all')
}