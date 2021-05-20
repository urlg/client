<template>
    <div class="container">
        <!--最上面-->
        <div class="container-top">
            <div class="container-top-navigation">
                <span :class="{Active:Active==1}" @click="changNavigationStyle(1,$event)" @mousemove="mouseLeave">文件(F)</span>
                <span :class="{Active:Active==2}" @click="changNavigationStyle(2,$event)">视图(E)</span>
                <span :class="{Active:Active==3}" @click="changNavigationStyle(3,$event)">导航(N)</span>
                <span :class="{Active:Active==4}" @click="changNavigationStyle(4,$event)">代码(C)</span>
                <span :class="{Active:Active==5}" @click="changNavigationStyle(5,$event)">重构(R)</span>
                <span :class="{Active:Active==6}" @click="changNavigationStyle(6,$event)">运行(U)</span>
                <span :class="{Active:Active==7}" @click="changNavigationStyle(7,$event)">工具(T)</span>
                <span :class="{Active:Active==8}" @click="changNavigationStyle(8,$event)">VCS(S)</span>
                <span :class="{Active:Active==9}" @click="changNavigationStyle(9,$event)">窗口(W)</span>
                <span :class="{Active:Active==10}" @click="changNavigationStyle(10,$event)">帮助(H)</span>
            </div>
        </div>
        <!--中间栏位:暂时分为: 左 中-->
        <div class="container-main">
            <div class="container-main-left">
                <span @click="selectOperation('CREATED')">创建表</span>
                <span @click="selectOperation('SELECT')">查询表</span>
                <span @click="selectOperation('UPDATE')">修改表字段</span>
                <span @click="selectOperation('DELETE')">删除表</span>
            </div>
            <!--中间栏位-->
            <div class="container-main-middle">
                    <!--创建表-->
                <div class="container-main-createdTable">

                </div>
                <!--查询表-->
                <div class="container-main-queryTable" v-show="operation=='SELECT'">
                    <div class="queryTable-top">
                        <span>表名</span>
                        <input type="text" v-model="searchContent" placeholder="请输入需要查询的表名,不区分大小写" />
                        <button @click="queryTableData(searchContent)">查询</button>
                    </div>
                    <!--查询到的表数据-->
                    <div class="queryTable-data">
                        <NormalTable    :isShow.sync="TableInfo.isShow"
                                        :tHead="TableInfo.tHead"
                                        :TableData="TableInfo.TableData.Result"
                                        :title="TableInfo.title">

                        </NormalTable>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-right">

        </div>
        <div class="container-bottom">
            <span :class="{Active:Active==1}" @click="changNavigationStyle(1,$event)" @mousemove="mouseLeave">文件(F)</span>
            <span :class="{Active:Active==2}" @click="changNavigationStyle(2,$event)">视图(E)</span>
            <span :class="{Active:Active==3}" @click="changNavigationStyle(3,$event)">导航(N)</span>
            <span :class="{Active:Active==4}" @click="changNavigationStyle(4,$event)">代码(C)</span>
            <span :class="{Active:Active==5}" @click="changNavigationStyle(5,$event)">重构(R)</span>
            <span :class="{Active:Active==6}" @click="changNavigationStyle(6,$event)">运行(U)</span>
            <span :class="{Active:Active==7}" @click="changNavigationStyle(7,$event)">工具(T)</span>
            <span :class="{Active:Active==8}" @click="changNavigationStyle(8,$event)">VCS(S)</span>
            <span :class="{Active:Active==9}" @click="changNavigationStyle(9,$event)">窗口(W)</span>
            <span :class="{Active:Active==10}" @click="changNavigationStyle(10,$event)">帮助(H)</span>
        </div>
        <Navigetion :isShow.sync="isShow" :x_positon="x_positon" :y_positon="y_positon">

        </Navigetion>
        <NormalDailog :IsShow.sync="normalDailog.isShow"
                      :Title="normalDailog.title"
                      :Message="normalDailog.Message">

        </NormalDailog>
    </div>
</template>

<script>
    import Navigetion from '@/page/box/pullDownBox-Navigetion.vue'
    import  NormalDailog from '@/page/dailog/NormalDailog'
    import  NormalTable from '@/page/box/normalTable.vue'
    import ObjectKeys from '@/js/getObjectInfo.js'
    export default {
        components:{ Navigetion ,NormalDailog, NormalTable},
        data(){
            return{
                operation:'CREATED',//操作类型
                searchContent:'',//查询操作时查询表名
                //表格信息
                TableInfo:{
                    isShow:false,
                    title:'查询返回结果',
                    tHead:[],//动态获取表格头
                    TableData: {
                        Result: []
                    },//查询到的表数据
                },
                isShow :false,
                Active :'',//用来改变导航页style
                x_positon:'',//被点击的元素X轴
                y_positon:'',//被点击的元素Y轴

                //dailog
                normalDailog:{
                    isShow :false,
                    options :['确定','取消'],
                    title :'title',
                    Message: 'Messadddddddddddddge'
                }
            }
        },
        created(){},
        methods:{
            /**
             * 改变导航页style
             */
            changNavigationStyle(num,$event){
                //$showMessage
                this.$showMessage({
                    Message: '客户信息查找失败，请重新测试',
                    IsShow:true
                })
                //this.isShow =true;
                this.Active = num;
                //this.normalDailog.isShow =true;
                this.x_positon = $event.currentTarget.getBoundingClientRect().left.toFixed(2);
                this.y_positon = $event.currentTarget.getBoundingClientRect().top.toFixed(2);
            },
            /**
             * 鼠标离开事件
             */
            mouseLeave(){this.isShow = false},
            /**
             * 操作类型选择
             */

            selectOperation(operation){
                this.operation =operation;
            },
            /**
             * 查找输入的表名数据
             */
          async  queryTableData(param){
                this.TableInfo.isShow = true;
                let submitData = {
                    "param":param,
                    "offset":0,
                    "limit":9
                }
                //实现异步处理查询操作
               let result = await this.$Service.send(this,'SD00001',submitData)
                //循环result对象所有Key
                this.TableInfo.tHead = []
                this.TableInfo.tHead = ObjectKeys.getObjectKey(result)
                let m;
                for (m=0;m<result.length;m++){
                    let n
                    for(n=0;n<this.TableInfo.tHead.length;n++){
                        console.error('----',result[m].this.TableInfo.tHead[n])
                        this.TableData.Result.push(result[m].this.TableInfo.tHead[n])
                    }
                }
                console.error('*******',this.TableInfo.tHead)
            }
        },
    }
</script>

<style lang="less" scoped>
.container{
    background-color: grey;
    height: 100%;
    width: 100%;
    position: fixed;
    top: 0px;
    left: 0px;
    .container-top{
        display: flex;
        flex-direction: column;
        .container-top-navigation{
            border-bottom-style: solid;
            border-bottom-width: 1px;
            border-bottom-color: black;
            span{
                padding: 0px 10px 10px 10px;
                font-size: 10px;
                //color: white;
            }
            .Active{
                background-color: lightsteelblue;
            }
        }
    }
    /**
    中间栏位
    **/
    .container-main{
        display: flex;
        flex-direction: row;
        height: 94%;
        .container-main-left{
            display: flex;
            background-color: darkslategrey;
            flex-direction: column;
            border-style: solid;
            border-width: 1px;
            width: 20%;
            word-break: break-all;
            span{
                border-width: 1px;
                border-bottom-color: red;
                height: 10%;
                text-align: center;
                line-height: 70px;
                border-style: solid;
            }
        }
        //中间区域
        .container-main-middle{
                .container-main-queryTable{
                    .queryTable-data{
                        display: flex;
                        flex-direction: row;
                            th{
                                display: flex;
                                flex-direction: row;
                            }

                    }
                }
        }

    }
    /**
    最下边的栏位
     */
    .container-bottom{
        display: flex;
        flex-direction: row;
        border-style: solid;
        border-color: cadetblue;
        border-width: 1px;
        //top: 19px;
    }
}
</style>