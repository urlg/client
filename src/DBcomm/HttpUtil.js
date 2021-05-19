var axios = require('axios')

// 配置项目根如路径
var root = 'http://localhost:9090/Table'

// axios请求
function httpApi (method, url, params) {
    return new Promise((resolve, reject) => {
        axios({
            method: method,
            url: url,
            data: method === 'POST' || method === 'PUT' ? params : null,
            params: method === 'GET' || method === 'DELETE' ? params : null,
            baseURL: root,
            withCredentials: false
        }).then(
            (response) => {
                resolve(response)
            }
        ).catch(
            (error) => {
                reject(error)
            }
        )
    })
}

// 返回在vue模板中的调用接口
export default {
    get: function (url, params) {
        return httpApi('GET', url, params)
    },
    post: function (url, params) {
        return httpApi('POST', url, params)
    },
    put: function (url, params) {
        return httpApi('PUT', url, params)
    },
    delete: function (url, params) {
        return httpApi('DELETE', url, params)
    }
}