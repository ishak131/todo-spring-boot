<template>
  <div class="home-page">
    <h1 class="welcome">
      Welcome to <br />
      Todo List by Asset Technology Group
    </h1>
    <p class="todo-description">
      The Asset Technology Group's Todo List App is a powerful task management application designed
      to help you stay organized and productive. With its user-friendly interface and robust
      features, managing your tasks has never been easier.
    </p>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
.home-page {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  height: calc(100vh - 60px) ;
}
.welcome {
  text-align: center;
  font-size: 40px;
  color: var(--primary);
  line-height: 70px;
}

.todo-description{
    color: black;
    font-weight: 400;
    text-align: center;
    max-width: 80vw;
    font-size: 25px;
}
</style>
