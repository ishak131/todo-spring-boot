<template>
  <div class="card"  >
    <div class="title-and-delete">
      <h2 class="title">title</h2>
      <DeleteButton :onClick="()=>{console.log('delete');
      }" />
    </div>
    <p class="description">this is the project description</p>
  </div>
</template>

<script setup lang="ts">
import DeleteButton from '../Button/DeleteButton.vue'
</script>

<style scoped>
.card {
  padding: 20px;
  border-radius: 20px;
  background-color: #fff;
  box-shadow: 8px 4px 101px -47px black;
  max-width: 400px;
  min-height: 100px;
  display: flex;
  justify-content: space-between;
  flex-direction: column;
}

.title {
  color: var(--primary);
  font-size: 24px;
  margin: 0;
}

.description {
  color: black;
  font-size: 14px;
  margin: 0;
}

.title-and-delete {
  display: flex;
  justify-content: space-between;
}
</style>
