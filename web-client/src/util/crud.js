import request from '@/router/axios';
import {proxyPath, uploadPath} from '@/config/env';

export default {
    /**
     * get 请求, 查询专用
     * @param uri
     * @param params query 参数
     * @returns {Promise<*>}
     */
    async get(uri, params) {
        console.debug("get => uri:", uri, "  params:", params)
        return await request({
            url: proxyPath + uri,
            method: 'get',
            meta: {
                isSerialize: false
            },
            params: params
        })
    },

    /**
     * post 请求, 添加专业，部分复杂查询可用
     * @param uri
     * @param data body 参数
     * @param params query 参数
     * @returns {Promise<*>}
     */
    async post(uri, data, params) {
        console.debug("post => uri:", uri, "  data:", data, "  params:", params)
        return await request({
            url: proxyPath + uri,
            method: 'post',
            meta: {
                isSerialize: false
            },
            data: data,
            params: params
        })
    },

    /**
     * put 请求, 编辑专用
     * @param uri
     * @param data body 参数
     * @param params query 参数
     * @returns {Promise<*>}
     */
    async put(uri, data, params) {
        console.debug("put => uri:", uri, "  data:", data, "  params:", params)
        return await request({
            url: proxyPath + uri,
            method: 'put',
            meta: {
                isSerialize: false
            },
            data: data,
            params: params
        })
    },

    /**
     * del 请求, 删除专用
     * @param uri
     * @param data body 参数
     * @param params query 参数
     * @returns {Promise<AxiosResponse<any>>}
     */
    async del(uri, data, params) {
        console.debug("del => uri:", uri, "  params:", params)
        return await request.delete(proxyPath + uri, {
            method: 'delete',
            meta: {
                isSerialize: false
            },
            data: data,
            params: params
        })
    },

    /**
     * 文件上传
     * @param  file 文件
     * @param  path 上传文件存放二级地址
     *
     * @author wangsong
     * @mail  1720696548@qq.com
     * @date  2021/10/16 0016 12:58
     * @version 1.0.0
     */
    upload(file, path) {
        console.debug("upload");
        // var newFile = new File([file], file.name, {type: file.type});
        // 开始上传
        var formData = new FormData();
        formData.append("file", file);
        return request({
            url: uploadPath + path,
            method: 'post',
            headers: {"Content-Type": "multipart/form-data;charset=UTF-8"},
            meta: {
                isSerialize: false
            },
            data: formData
        })
    },


    /**
     * 通用下载
     * @param uri 下载接口地址
     * @param data 请求测试
     * @returns {*}
     */
    download(uri, data) {
        console.debug("download => uri:", uri, "  data:", data)
        return request({
            url: proxyPath + uri,
            method: 'post',
            data: data,
            // 下载zip文件需要使用的响应格式,这是区别于普通post请求的地方,重点!!!
            responseType: "blob"
        }).then(res => {
            // 下载格式为zip { type: "application/zip" }
            let blob = new Blob([res.data], {type: "application/zip"});
            // 创建一个<a>标签
            let elink = document.createElement("a");
            // 隐藏标签
            elink.style.display = "none";
            // 配置href
            elink.href = window.URL.createObjectURL(blob);
            // 获取名称
            let filename = res.headers["content-disposition"];
            let newFilename = filename.split(';')[1].split('=')[1];
            newFilename = decodeURIComponent(newFilename);
            elink.download = newFilename;
            elink.click();
            // 释放URL 对象
            URL.revokeObjectURL(elink.href);
            // 移除<a>标签
            // document.body.removeChild(elink);
        })
    },


    /**
     * 通用 删除行
     * @author wangsong
     * @param thih 调用者（调用者需提供 onLoad 查询方法,删除后调用此方法重新从后台查询数据）
     * @param uri  删除接口地址
     * @param id   删除id
     * @param index  删除索引
     * @date 2021/10/16 0016 9:50
     * @return
     * @version 1.0.0
     */
    delRow(thih, uri, id, index) {
        console.debug("delRow => uri:", uri, "  id:", id)
        thih.$confirm(`此操作将永久删除序号【${index + 1}】的数据, 是否继续?`, '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
        }).then(() => {
            return this.del(uri + "/" + id).then(() => {
                // 删除后刷新列表数据
                thih.onLoad();
            })
        })
    },

    /**
     * 通用 分页查询/列表查询
     * @author wangsong
     * @param thih
     * @param isPage 是否分页
     * @param isCallback 是否触发回调函数（在调用页面定义 onLoadCallback 方法）
     * @mail  1720696548@qq.com
     * @date  2021/10/16 0016 10:00
     * @version 1.0.0
     */
    list(thih, isPage, isCallback) {
        // 开启 loading 等待
        thih.loading = true;
        // 默认分页
        isPage = isPage == null ? true : isPage
        isCallback = isCallback == null ? false : isCallback
        // 查询参数
        let params = {};
        // 处理参数，如果存在数组查询参数，转为逗号分割的参数进行查询
        if (thih.search != null) {
            for (let k in thih.search) {
                let v = thih.search[k];
                if (v instanceof Array) {
                    params[k] = v.join(",");
                } else {
                    params[k] = v;
                }
            }
        }
        // 分页参数
        params.current = thih.page != null ? thih.page.currentPage : 0;
        params.size = thih.page != null ? thih.page.pageSize : 0;
        console.debug("列表查询list => " +
            "  uri:", thih.uri.infoList,
            "  isPage:", isPage,
            "  isCallback -> onLoadCallback(res):", isCallback,
            "  params:", params)
        // 发起请求
        return this.get(thih.uri.infoList, params).then(res => {
            if (isPage) {
                // 分页
                thih.data = res.data.data.records;
                thih.page.total = res.data.data.total;
            } else {
                // 不分页
                thih.data = res.data.data;
            }
            console.debug("列表查询list返回 => " + thih.data)
            if (isCallback) {
                // 回调
                thih.onLoadCallback(res);
            }
            // 关闭 loading 等待
            thih.loading = false;
        })
    },
    /**
     * 此方法为表格数据重置后，重置表格样式，防止表格 操作栏和列表 位置对不上
     * @author wangsong
     * <P>
     *      // // 解决表格错位(需表格ref=crud)
     *      //  thih.$nextTick(() => {
     *      //      if (thih.$refs.crud != null) {
     *      //          thih.$refs.crud.doLayout();
     *      //      }
     *      //  });
     * </P>
     * @thih
     * @ref  表格 ref值 如：this.$refs.crud
     * @mail  1720696548@qq.com
     * @date  2021/11/14 0014 9:55
     */
    doLayout(thih, refP) {
        console.debug(thih)
        console.debug(refP)
        thih.$nextTick(() => {
            if (refP != null) {
                try {
                    refP.doLayout();
                } catch (e) {
                    //
                }
            }
        });
    },
}


