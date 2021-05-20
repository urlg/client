/**
 * 对象Object
 */
export  default {

    //返回对象的所有Key
    getObjectKey(object){
        let objectkeys =[]
        //判断传入的object是否为Object
        if(!(object instanceof  Object)){
            return ''
        }
        if(Object.keys(object[0]).length==1) {
            console.error('&&&&&&&',Object.keys(object[0]))
            objectkeys = Object.keys(object[0])

            return  objectkeys
        }
    }

}