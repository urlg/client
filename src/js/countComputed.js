export default {
    /**
     * 加法
     *      value1:传入的第一个值
     *      value2:传入的第二个值
     *      bit:保留的位数
     */
    addCount(value1,value2,Bit){
        let result =(Number(value1)+Number(value2)).toFixed(Number(Bit))
        return result;
    },
    /**
     * 减法
     *      value1:传入的第一个值
     *      value2:传入的第二个值
     *      bit:保留的位数
     */
    subtractCont(value1,value2,Bit){
        let result =(Number(value1)-Number(value2)).toFixed(Number(Bit))
        return result;
    },
    /**
     * 乘法
     *      value1:传入的第一个值
     *      value2:传入的第二个值
     *      bit:保留的位数
     */
    multiplicationCont(value1,value2,Bit){
        let result =(Number(value1)*Number(value2)).toFixed(Number(Bit))
        return result;
    },
    /**
     * 除法
     *      value1:传入的第一个值
     *      value2:传入的第二个值
     *      bit:保留的位数
     */
    divisionCont(value1,value2,Bit){
        let result =(Number(value1)/Number(value2)).toFixed(Number(Bit))
        return result;
    },

}