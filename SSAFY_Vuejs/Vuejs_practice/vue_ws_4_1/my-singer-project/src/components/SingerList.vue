<script setup>
import SingerDetail from "./singers/SingerDetail.vue";

const singers = [
    { name: "adele" },
    { name: "maroon 5" },
    { name: "Dua Lipa" }
];
</script>

<template>
    <div style="text-align:center">
        <h1> 가수 목록</h1>
        <singer-detail v-for="singer in singers" :key="singer.name"/>
    </div>  
</template>

<style scoped>
 .card{
    display: inline-block; width:40%; margin:100px;
 }
 h1{
    color:orangered;
 }
</style>