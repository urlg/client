<template>
    <div :style="content" v-show="isShow">
        <span>下一个窗口</span>
        <span>上一个窗口</span>
    </div>
</template>

<script>
    export default {
        props:{
            isShow:{
                type:Boolean,
                default:false
            },
            x_positon:{
                type:String,
                default: ''
            },
            y_positon:{
                type:String,
                default: ''
            }
        },
        data() {
            return{
                content:{
                    color:'red',
                    width:'50%',
                    position:'fixed',
                    display: 'flex',
                    flexDirection: 'column',
                    backgroundColor: 'grey',
                    borderColor: 'black',
                    borderStyle: 'solid',
                    borderWidth: '0.5px',
                    top:'',//Y轴位置
                    left:'',//X轴位置
                }
            }
        },
        created(){},
        mutation:{},
        computed:{
        },
    /**
     * 监听属性
     */
    watch:{
        x_positon:function (newVal) {
            this.content.left = newVal+'px';
        },
        y_positon:function (newVal) {
            this.content.top = newVal+'px'
        }
    },
    methods:{

        }
    }
</script>

<style lang="less" scoped>
</style>