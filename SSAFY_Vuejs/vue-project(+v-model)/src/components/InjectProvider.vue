<script setup>
import {inject} from 'vue'

const name = inject('name');
const age = inject('age');

</script>

<template>
    <div>
        <p>
            부모로 부터 받은 이름은 {{ name }} 이고 
            나이는 {{ age }} 입니다
        </p>
    </div>
</template>

<style scoped>

</style>