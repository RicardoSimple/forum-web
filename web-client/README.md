# xijia-client

- xijia-client 是 spring-boot-plus2 项目的一个衍生产品,但又可完全独立运行，对接任意后端项目,
- xijia-client 主要目的是提供用户端的基础骨架
- xijia-client 等同与是一个纯前端的用户端产品 (门户网站)

在线体验： http://client.xijia.plus/

## 相关命令
```
# 拉取相关依赖
npm install

# 启动服务
npm run serve

# 打包
npm run build

```

## 接口请求工具

详见：util.crud.js

```js
  // 任意vue文件中使用
  this.crud.get(uri,params参数).then((res) => {
        // 响应数据
  })

  this.crud.post(uri, data参数, params参数).then((res) => {
        
  })

  // 更多详见 util.crud.js
```

## 请求响应拦截

详见： axios.js