<template>
    <div class="ShowMessage" v-show="IsShow">
        <span>
            {{Message}}
        </span>
        <div class="Buttom">
            <button class="ShowMessage-Buttom" v-for="(item,key) in Options" :key="item" @click="Confirm(key)">{{item}}</button>
        </div>
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
            },
            Options:{
                type:Array,
                default:()=>([])
            }
        },
        data(){
            return{
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
            },
            /**
             * 当点击的时候
             */
            Confirm(key){
                if(this.hideFn && typeof this.hideFn =='function'){
                    this.hideFn(key)
                }
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
        .ShowMessage-Buttom{
            button{
                display: flex;
                flex-direction: row;
            }
        }
    }
</style>