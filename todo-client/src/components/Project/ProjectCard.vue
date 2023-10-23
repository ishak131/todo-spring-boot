<template>
  <div
    @click="
      () => {
        router.push('/project-tasks/' + props.project.id)
      }
    "
    v-if="!isDeleted"
    class="card"
  >
    <div class="title-and-delete">
      <h2 class="title">{{ props.project.title }}</h2>
      <DeleteButton @on-click="deleteProject" />
    </div>
    <p class="description">{{ props.project.description }}</p>
  </div>
</template>

<script setup lang="ts">
import { authorizedApis } from '@/api/axiosSetup'
import DeleteButton from '../Button/DeleteButton.vue'
import { ref } from 'vue'
import router from '@/router'

const isDeleted = ref(false)
const props = defineProps(['project'])

const deleteProject = (event:Event) => {
  event.stopPropagation()
  authorizedApis
    .delete(`/projects/${props.project.id}`)
    .then((res) => {
      isDeleted.value = true
    })
    .catch((err) => {
      console.log({ err })
    })
}
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
  padding-right: 15px;
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
