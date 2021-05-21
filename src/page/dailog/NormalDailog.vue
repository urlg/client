<!--
普通弹框，具有确定和取消按钮或者可以增加其他按钮
-->
<template>
    <div class="containerDailog" v-show="IsShow">
        <div class="containerDailog-title">
            <img src="/src/assets/logo.png">
            {{Title}}
        </div>
        <div class="containerDailog-content">
            {{Message}}
        </div>
    </div>
</template>

<script>
    export default {
        name: "NormalDailog",
        props:{
            IsShow:{
                type:Boolean,
                default : false
            },
            Title :{
                type :String,
                default :''
            },
            Image:{
                type:String,
                default:''
            },
            Message:{
                type:String,
                default:''
            }
        },
        data(){
            return{

            }
        }
    }
</script>

<style lang="less" scoped>
    .containerDailog{
        display: flex;
        flex-direction: column;
        background-color:white;
        height:500px;
        width: 500px;
        margin-left:30%;
        border-style: solid;
        border-radius: 2px 2px 2px 2px;
        border-color: black;
        border-width: 2px;
        .containerDailog-title{
            span{
                text-align: center;
            }
        }
        .containerDailog-content{
            width: 20%;
        }
    }
</style>