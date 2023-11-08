import service from '../http/index.js'

/**
 * 新增或修改帖子
 * @param {id:string,name:string,userID:string,userType:string,title:string,content:string} param 
 * @returns 
 */
export async function addOrUpdateComment (param) {
  return await service.post('/comment/add', param)
}

/**
 * 获取全部帖子
 * @returns 
 */
export async function getAllComments () {
  return await service.get('/comment/all')
}

/**
 * 根据id获取帖子
 * @param {id:string} id 
 * @returns 
 */
export async function getCommentById (id) {
  return await service.get('/comment/getbyid?id=' + id)
}

/**
 * 根据用户类型和用户id获取帖子
 * @param {string} type 
 * @param {string} userId 
 * @returns 
 */
export async function GetCommentByIdAndType (type, userId) {
  return await service.get(`/comment/userIdAndType?type=${type}&userId=${userId}`)
}

/**
 * 删除帖子
 * @param {string} id 
 * @returns 
 */
export async function deleteCommentById (id) {
  return await service.delete("/comment/delete?id=" + id);
}