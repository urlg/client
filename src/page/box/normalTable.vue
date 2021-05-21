<template>
    <div class="normal-Table" v-show="isShow">
        <span>{{title}}</span>
        <table border="1">
            <thead>
                <tr>
                    <th v-for="(item1,index1) in tHead " :key="index1">{{item1}}</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(item2,index2) in TableData" :key="index2">
                    <td v-for="(item3,index3) in item2" :key="index3">{{item3}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        props:{
            isShow:{
                type:Boolean,
                default:true
            },
            title:{
                type:String,
                default:''
            },
            tHead:{
                type: Array,
                default: ()=>([])
            },
            TableData:{
                type:Array,
                default:()=>([])
            }
        },
        data(){
            return{
                name: "normalTable",
            }
        },
        created(){
        }
    }
</script>

<style lang="less" scoped>
    .normal-Table{
        background-color: #d9cebd;
        span{
            padding-left: 140px;
            font-size: 20px;
        }
    }
</style>