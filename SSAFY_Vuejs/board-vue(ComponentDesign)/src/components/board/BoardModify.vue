<script setup>
import { ref } from "vue";
import DetailForm from "../common/DetailForm.vue";

const article = ref({
  articleNo: 100,
  subject: "안녕하세요 뷰테스트 중입니다.",
  content:
    "뷰테스트 중입니다. 컴포넌트 연습하고 있으며, 앞으로 props와 custom event를 처리 할 예정입니다.",
  userId: "ssafy",
  userName: "김싸피",
  hit: 123,
  registerDate: "25.01.01",
});
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">글수정</mark>
        </h2>
      </div>
      <div class="col-lg-10">
        <DetailForm
          action="modify" 
          :article="article"
        />
      </div>
    </div>
  </div>
</template>

<style scoped></style>
