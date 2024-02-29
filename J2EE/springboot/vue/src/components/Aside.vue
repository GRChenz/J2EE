<template>
  <el-menu  style="min-height: 100%; overflow-x: hidden"
            background-color="rgb(48, 65, 86)"
            text-color="#fff"
            active-text-color="#ffd04b"
            :collapse-transition="false"
            :collapse="isCollapse"
            router
  >
    <div style="height: 60px; line-height: 60px; text-align: center">
      <img src="../assets/logo.png" alt="" style="width: 20px; position: relative; top: 5px;  ">
      <b style="color: white ;padding-left: 5px"  v-show="logoTextShow" >能源管理系统</b>
    </div>
    <el-menu-item index="/">
        <i class="el-icon-s-home"></i>
        <span slot="title">主页</span>
    </el-menu-item>
    <el-submenu index="2">
      <template slot="title">
        <i class="el-icon-help"></i>
        <span slot="title">能源项处理</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="/dataprocessing">数据处理</el-menu-item>
        <el-menu-item index="/file">数据信息记录</el-menu-item>
        <el-menu-item index="2-3">设备管理</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
    <el-submenu index="3">
      <template slot="title">
        <i class="el-icon-menu"></i>
        <span slot="title">信息管理</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="/project">任务管理</el-menu-item>
        <el-menu-item index="2-2">投诉反馈</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
    <el-submenu index="4">
      <template slot="title">
        <i class="el-icon-setting"></i>
        <span slot="title">系统设置</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="/register">用户管理</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: "Aside.vue",
  props: {
    isCollapse:Boolean,
    logoTextShow:Boolean
  }
}
</script>

<style scoped>

</style>