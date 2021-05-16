import Vue from 'vue';
import Message from './ShowMessage.vue';

let MessageConstructor = Vue.extend(Message)

let ShowMessage = function (object) {
    let MessageDom =new MessageConstructor({
        el:document.createElement('div')
    })

    for (let key in object){
        MessageDom[key] =object[key]
    }
        document.body.appendChild(MessageDom.$el)
}

    export default ShowMessage;