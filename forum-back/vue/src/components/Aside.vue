<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        :default-active="path"
        router
        class="el-menu-vertical-demo">

      <el-menu-item index="/user">用户管理</el-menu-item>
      <el-menu-item index="/topic">帖子管理</el-menu-item>
      <el-menu-item index="/answer">回复管理</el-menu-item>
      <el-menu-item index="/image">图片管理</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import {defineComponent} from 'vue'
import {
  Location,
  Document,
  Menu as IconMenu,
  Setting,
} from '@element-plus/icons'

export default {
  name: "Aside",
  components: {
    Location,
    Document,
    Setting,
    IconMenu,
  },
  data(){
    return{
      path: this.$route.path,  //设置默认高亮的菜单
    }
  },
  setup() {
    const handleOpen = (key, keyPath) => {
      console.log(key, keyPath)
    }
    const handleClose = (key, keyPath) => {
      console.log(key, keyPath)
    }
    return {
      handleOpen,
      handleClose,
    }
  },
}
</script>

<style scoped>

</style>