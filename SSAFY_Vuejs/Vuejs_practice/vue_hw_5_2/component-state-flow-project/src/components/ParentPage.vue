<script setup>
import ChildPage from "./ChildPage.vue";

const children = [
    { name: '김하나', age: 30 },
    { name: '김두리', age: 20 },
    { name: '김서이', age: 10 },
];

</script>

<template>
    <div>
        <h1>부모 페이지입니다.</h1>
        <ChildPage v-for="child in children" :key="child.name" 
            :child="child"
        />
    </div>
</template>

<style scoped>
    div {
        border:1px solid;
        margin:5px;
        padding: 5px;
    }
</style>