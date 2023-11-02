

export const saveUserInfo = (userInfo) => {
  window.localStorage.setItem("userInfo", JSON.stringify(userInfo))
}

export const getSavedUserInfo = () => {
  return JSON.parse(window.localStorage.getItem("userInfo"))
}