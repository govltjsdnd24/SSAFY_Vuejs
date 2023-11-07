<script setup>
import BoardList from '../components/board/BoardList.vue'
import { useRoute, useRouter } from 'vue-router'

const router = useRouter()

const goHome = function () {
    router.push({ name: 'write' })
    console.log("here");
}
</script>

<template>
    <BoardList/>
</template>
  
<style scope></style>