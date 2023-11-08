/**
 * 
 * @param {string} str 
 * @param {number} num 
 */

export function shortStr (str, num) {
  return str.length > num ? str.slice(0, num) + "..." : str;
}

/**
 * 
 * @param {list} list 
 * @param {number} num 
 * @returns 
 */
export function shortItem (list, num) {
  return list.length > num ? list.slice(0, num) : list
}