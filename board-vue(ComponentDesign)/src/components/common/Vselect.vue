<script setup>
import { ref } from "vue";

defineProps({
    selectOption: Array
});

const emit= defineEmits(["onKeySelect"]);

const key = ref("");

const onSelect = () => {
    emit("onKeySelect", key.value);
}
</script>

<template>
    <select v-model="key" @change="onSelect" class="form-select form-select-sm ms-5 me-1 w-50" aria-label="검색조건">
        <option v-for="option in selectOption" 
            :key="option.value" 
            :value="option.value"
            :disabled="option.value === '' ">
           {{ option.text }}
        </option>
    </select>
</template>

<style scoped>

</style>