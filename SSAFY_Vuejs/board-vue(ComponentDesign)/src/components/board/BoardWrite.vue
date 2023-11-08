<script setup>
import { ref} from "vue";
import DetailForm from "../common/DetailForm.vue";

const article = ref({
  articleNo: 0,
  subject: "",
  content: "",
  userId: "",
  userName: "",
  hit: 0,
  registerDate: "",
});
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">글쓰기</mark>
        </h2>
      </div>
      <div class="col-lg-10">
        <DetailForm
          action="write" 
          :article="article"
        />
      </div>
    </div>
  </div>
</template>

<style scoped></style>
