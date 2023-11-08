<template>
  <div>
    <p>ParentInput : {{ modelValue }}</p>
    <input 
      type="text"
      :value="modelValue"
      @input="updateInputValue"
    >
  </div>
</template>

<script setup>
defineProps({
  modelValue: String,
})

const emit = defineEmits(['update:modelValue'])

const updateInputValue = function (event) {
  emit('update:modelValue', event.currentTarget.value)
}

</script>

<style scoped>

</style>
