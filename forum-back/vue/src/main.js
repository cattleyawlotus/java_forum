import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// import 'element-plus/lib/theme-chalk/index.css'

import '@/assets/css/global.css'

// 统一导入el-icon图标
import * as ElIconModules from '@element-plus/icons'
import { transElIconName } from './utils/utils.js'
const app = createApp(App);

// 统一注册el-icon图标
for(let iconName in ElIconModules){
    app.component(transElIconName(iconName),ElIconModules[iconName])
}
app.use(store).use(router).use(ElementPlus,{size:'small'}).mount('#app')
