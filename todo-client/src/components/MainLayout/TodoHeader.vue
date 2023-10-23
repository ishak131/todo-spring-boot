<template>
  <div class="header">
    <nav class="navigation-links">
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/projects">Projects</RouterLink>
    </nav>
    <div class="actions">
      <TodoButton
        @on-click="
          () => {
            console.log('clicked')
          }
        "
        text="Login"
      />
      <TodoButton
        @on-click="
          () => {
            console.log('clicked')
          }
        "
        text="Signup"
      />
    </div>
  </div>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router'
import TodoButton from '../Button/TodoButton.vue'
</script>

<style scoped>
.header {
  display: flex;
  height: 60px;
  background-color: #fff;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  justify-content: space-between;
  padding: 0 20px;
  box-shadow: 0px 4px 15px 0px rgba(61, 61, 61, 0.1);
}
.navigation-links {
  display: flex;
  align-items: center;
  gap: 20px;
}
.navigation-links > a {
  font-size: 20px;
  font-weight: 400;
  color: black;
  text-decoration: none;
}

.actions {
  display: flex;
  gap: 20px;
  width: fit-content;
  align-items: center;
}
</style>
