<script setup>
    import SingerAlbum from "./SingerAlbum.vue";
</script>

<template class="card">
    <div class="indiv" >
        <h1> 가수1 </h1>
        <img src="../../assets/singer.jpg" width="200"/>
        <p> 가수 소개글 </p>
        <singer-album/>
    </div>
</template>

<style scoped>
 .indiv{
    border: solid 1px; display:inline-block; width: 40%; margin:20px;
 }
</style>