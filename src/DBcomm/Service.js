
/**
 * 通讯
 */

//项目请求根路径
let requestPath = 'http://localhost:9090/Table/';
export default {

    /**
     * post请求
     */
    send(VueAPP,url,submitData){
        let responseBody;
       let promise = new Promise((resolve) =>{
            VueAPP.$HttpUtil.post(requestPath+url,submitData).then((response)=>{
                responseBody = response.data
                resolve(responseBody)
            })
        })
        return promise
    }
}