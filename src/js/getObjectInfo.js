/**
 * 对象Object
 */
export  default {

    /**
     *  @description  返回对象的所有Key
     *  *  @ param
     *      对象格式为：
     *      objec：[
     *      {‘username’:‘张三’,‘age’:17,'gender':'男'},
     *      {‘username’:‘张三’,‘age’:17,'gender':'男'},
     *      {‘username’:‘张三’,‘age’:17,'gender':'男'},
     *      ]
     * @param object
     * @returns {string|string[]}
     */
    getObjectKeys(object){
        let keys =[]
        //判断传入的object是否为Object
        if(!(object instanceof  Object)){
            return ''
        }
            keys = Object.keys(object[0])
            return  keys
    },

    /**
     * @description 返回对象的所有value
     *  *  @ param
     *      对象格式为：
     *      objec：[
     *      {‘username’:‘张三’,‘age’:17,'gender':'男'},
     *      {‘username’:‘张三’,‘age’:17,'gender':'男'},
     *      {‘username’:‘张三’,‘age’:17,'gender':'男'},
     *      ]
     *      @returns {string|string[]}
     */
        getObjectValues(objectKeys,object){
            let values =[]
            //判断传入的object是否为Object
            if(!(objectKeys instanceof  Object)){
                return ''
            }

            //循环object
            let i;
            for(i=0;i<object.length;i++){
                let k;
                let array = [];
                for (k=0;k<objectKeys.length;k++){
                    /**
                     * 单行Key的value
                     */
                    array.push(object[i][objectKeys[k]])
                }
                values.push(array)
            }
            return values
    }
}