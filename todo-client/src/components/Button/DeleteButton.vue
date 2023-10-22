<template>
  <button @click="$emit('on-click', $event)" class="delete-button" role="button">
    <img class="delete-image" src="../../assets/delete.png" />
  </button>
</template>

<script lang="ts">
export default {
  setup() {},
  emits: ['on-click'],
  props: {
    text: String
  }
}
</script>

<style scoped>
.delete-button {
  background: #fff;
  padding: 0;
  border-radius: 50%;
  border: none;
}
.delete-button:hover > .delete-image {
  transform: scale(1.5);
}

.delete-image {
  height: 15px;
  transition: transform 0.2s; /* Animation */
}
</style>
