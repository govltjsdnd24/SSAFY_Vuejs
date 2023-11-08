<script setup>
import BoardWrite from "./components/board/BoardWrite.vue";
import TheHeading from "./components/layout/TheHeading.vue";
import BoardView from "./views/BoardView.vue";
import BoardModify from "./components/board/BoardModify.vue";
import BoardDetail from "./components/board/BoardDetail.vue";
</script>

<template>
    <TheHeading/>
    <BoardWrite/>
    <BoardModify/>
    <BoardView/>
    <BoardDetail/>
</template>
  
<style scope></style>