<script setup>

import { computed } from "vue";

const props=defineProps({
    action: String,
    article: Object,
})

const action = computed(() => {
    if (props.action == "write") return "등록";
    else if (props.action == "modify") return "수정";
})

</script>

<template>
    <form>
          <div class="mb-3">
            <label for="userid" class="form-label">작성자 ID : </label>
            <input type="text" class="form-control" v-model="article.userId" readonly />
          </div>
          <div class="mb-3">
            <label for="subject" class="form-label">제목 : </label>
            <input type="text" class="form-control" v-model="article.subject" />
          </div>
          <div class="mb-3">
            <label for="content" class="form-label">내용 : </label>
            <textarea class="form-control" v-model="article.content" rows="7"></textarea>
          </div>
          <div class="col-auto text-center">
            <button type="button" class="btn btn-outline-success mb-3">{{action}}</button>
            <button type="button" class="btn btn-outline-danger mb-3 ms-1">목록으로이동...</button>
          </div>
    </form>
</template>

<style scoped>

</style>