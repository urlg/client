
/**
 * 通讯
 */

//项目请求根路径
let requestPath = 'http://localhost:9090/Table/';
export default {

    /**
     * post请求
     */
    send(VueAPP,serviceCode,submitData){
        let requestbody = new Object();
        requestbody.date = new Date().getFullYear()
        requestbody.time = new Date().getTime()
        requestbody.serviceCode = serviceCode
        /**
         * 对当前submitData进行拼接成最后上送格式
         */
        let keys = new Array();
            keys = Object.keys(submitData);
            let i;
            for (i=0;i<keys.length;i++){
                requestbody[keys[i]] = submitData[keys[i]]
            }
        let responseBody;
       let promise = new Promise((resolve) =>{
            VueAPP.$HttpUtil.post(requestPath+serviceCode,requestbody).then((response)=>{
                responseBody = response.data
                resolve(responseBody)
            })
        })
        return promise
    }
}