<template>
    <div class="ShowMessage" v-show="IsShow">
        <span>
            {{Message}}
        </span>
        <button @click="removeElement()">我知道了</button>
    </div>
</template>

<script>
    export default {
        name: "ShowMessage",
        props:{
            Message:{
                type:String,
                default:''
            },
            IsShow:{
                type: Boolean,
                default: false
            }
        },
        data(){
            return{
                message:'',
                hideFn:''
            }
        },
        mounted(){},
        update(){},
        methods:{
            /**
             * 点击后弹框消失
             */
            removeElement(){
                this.$destroy();
                document.querySelector('.ShowMessage').remove()
            }
        }
    }
</script>

<style lang="less" scoped>
    .ShowMessage{
        position:fixed;
        display: flex;
        flex-direction: column;
        background-color:white;
        left: 12%;
        top: 30%;
        width: 30%;
        height: 25%;
        margin-left:30%;
        border-style: solid;
        border-radius: 2px 2px 2px 2px;
        border-color: black;
        border-width: 2px;
        .button{

        }
    }
</style>