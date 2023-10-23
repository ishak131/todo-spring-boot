<template>
  <div v-if="!isDeleted" class="task" :class="{ done: isDone }">
    <div class="task-and-checkbox">
      <span> {{ task.title }} </span>
      <input @change="doAndUndoTask" type="checkbox" :checked="isDone" />
    </div>
    <DeleteButton @on-click="deleteProject" />
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import DeleteButton from '../Button/DeleteButton.vue'
import { authorizedApis } from '@/api/axiosSetup'
const { task } = defineProps(['task'])
const isDeleted = ref<boolean>(false)
const isDone = ref<boolean>(task.done)

const deleteProject = () => {
  authorizedApis
    .delete(`/projects/${task.project.id}/tasks/${task.id}`)
    .then((res) => {
      isDeleted.value = true
    })
    .catch((err) => {
      console.log({ err })
    })
}

const doAndUndoTask = () => {
  authorizedApis
    .put(`/projects/${task.project.id}/tasks/${task.id}`, {
      ...task,
      done: !isDone.value
    })
    .then((res) => {
      isDone.value = !isDone.value
    })
    .catch((err) => {
      console.log({ err })
    })
}
</script>

<style scoped>
.task {
  width: 100%;
  border-radius: 10px;
  padding-right: 15px;
  border: 1px solid var(--primary);
  display: flex;
  gap: 15px;
}
.task-and-checkbox {
  padding: 10px 15px;
  border-right: 1px solid var(--primary);
  flex-grow: 1;
  display: flex;
  gap: 10px;
}
.task-and-checkbox > span {
  font-size: 15px;
  font-weight: 600;
  flex-grow: 1;
}

.done,
.done > .task-and-checkbox {
  border-color: #22bb33 !important;
}

.done span {
  text-decoration: line-through;
}
</style>
