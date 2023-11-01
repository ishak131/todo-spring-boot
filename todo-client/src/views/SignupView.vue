<template enter-class="flex item-center">
    <div class="flex item-center content-center page">
      <div class="flex flex-col item-center justify-center w-96 mx-auto">
        <h1 class="text-center text-4xl mb-5">Sign Up</h1>
        <form class="gap-2.5 flex flex-col">
          <TodoInput placeholder="Full Name" />
          <TodoInput placeholder="Password" />
          <TodoInput placeholder="Password Confirmation" />
          <TodoButton text="Log In" />
        </form>
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import TodoButton from '../components/Button/TodoButton.vue'
  import TodoInput from '../components/Input/TodoInput.vue'
  
  
  
  </script>
  
  <style scoped></style>
  