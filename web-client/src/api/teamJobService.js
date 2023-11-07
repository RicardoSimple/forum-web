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
  return await service.get('/teamJob/getbyteamid?teamId=' + teamId);
}