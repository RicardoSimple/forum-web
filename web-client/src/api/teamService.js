import service from '../http/index.js'

/**
 * 按照id获取企业
 * @param {string} id 
 * @returns 
 */
export async function getTeamById (id) {
  return await service.get('/team/get?id=' + id)
}