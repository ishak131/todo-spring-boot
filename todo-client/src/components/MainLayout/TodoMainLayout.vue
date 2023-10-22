<script setup lang="ts">
import { RouterView } from 'vue-router'
import TodoHeader from './TodoHeader.vue'
</script>

<template>
  <TodoHeader></TodoHeader>
  <main>
    <RouterView />
  </main>
</template>

<style scoped></style>
