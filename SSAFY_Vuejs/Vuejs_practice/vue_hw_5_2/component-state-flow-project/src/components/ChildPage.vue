<script setup>
    defineProps({
        child: Object,
    })
</script>

<template>
    <div>
        <h3>자식 페이지입니다.</h3>
        <p>이름: {{ child.name }}</p>
        <p>나이: {{ child.age }}</p>
    </div>
</template>

<style scoped>
    div{
        border:1px solid;
        margin:5px;
        padding: 5px;
    }
</style>