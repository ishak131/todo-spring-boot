<template>
  <input class="todo-input" />
</template>

<script lang="ts">
export default {}
</script>

<style scoped>
.todo-input {
  width: 100%;
  border-radius: 10px;
  padding: 10px 15px;
  border: 1px solid var(--primary);
  outline: none;
  box-sizing: border-box;
  font-size: 15px;
  font-weight: 500;
}

.todo-input:focus {
  outline: none;
}
</style>
