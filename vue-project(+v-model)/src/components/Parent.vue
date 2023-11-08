<!-- Parent.vue -->

<template>
  <div>
    <p>Parent : {{ searchText }}</p>
    <ParentInput v-model="searchText" />
    <ParentChild 
      @some-event="someCallback" 
      @emit-args="getNumbers"
      @update-name="updateName"
      my-msg="message" 
      :dynamic-props="name" 
    />
    <hr>
    <InjectProvider/>
    <hr>
    <SlotChild>부모가 슬롯으로 데이타바인딩</SlotChild>
    <hr>
    <SlotChildName v-slot:nm>부모가 nm으로 데이타바인딩</SlotChildName>
    <hr>
    <SlotChildName v-slot:age>부모가 age로 데이타바인딩</SlotChildName>
    
  </div>
</template>

<script setup>
import { ref, provide } from 'vue'
import ParentChild from '@/components/ParentChild.vue'
import ParentInput from '@/components/ParentInput.vue'
// ---------------------------------------------------
import InjectProvider from '@/components/InjectProvider.vue'
import SlotChild from '@/components/SlotChild.vue'
import SlotChildName from '@/components/SlotChildName.vue'


// 

const name = ref('Alice')
const searchText = ref(null)

const age = ref(30);
provide(/*키*/'name',/* 값*/ name );
provide(/*키*/'age', /* 값*/ age );

const someCallback = function () {
  console.log('ParentChild가 발신한 이벤트를 수신했어요.')
}

const getNumbers = function (...args) {
  console.log(args)
  console.log(`ParentChild가 전달한 추가인자 ${args}를 수신했어요.`)
}

const updateName = function () {
  name.value = 'Bella'
}
</script>

<style scoped>

</style>
