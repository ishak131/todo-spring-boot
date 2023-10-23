<template>
  <div class="todo-list">
    <TodoTask v-for="(task, index) in tasks" :task="task" :key="index" />
    <form class="add-task">
      <TodoInput
        :value="taskTitle"
        type="text"
        placeholder="Task Title"
        @on-change="onTaskTitleChange"
      />
      <TodoButton @on-click="addNewTask" text="Add" />
    </form>
  </div>
</template>

<script setup lang="ts">
import { authorizedApis } from '@/api/axiosSetup'
import TodoButton from '../components/Button/TodoButton.vue'
import TodoInput from '../components/Input/TodoInput.vue'
import TodoTask from '../components/Task/TodoTask.vue'
import { onMounted, reactive, ref } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const tasks = reactive<any[]>([])
const taskTitle = ref('')
const { projectId } = route.params

onMounted(() => {
  getTasks()
})

const onTaskTitleChange = (event: any) => {
  taskTitle.value = event.target.value
}

const getTasks = () => {
  authorizedApis
    .get(`/projects/${projectId}/tasks`)
    .then((res) => {
      tasks.splice(0, tasks.length)
      tasks.push(...res.data)
    })
    .catch((err) => {
      console.log({ err })
    })
}

const addNewTask = () => {
  authorizedApis
    .post(`/projects/${projectId}/tasks`, {
      title: taskTitle.value
    })
    .then(() => {
      getTasks()
      taskTitle.value = ''
    })
    .catch((err) => {
      console.log({ err })
    })
}
</script>
<style scoped>
.todo-list {
  max-width: 500px;
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
  height: calc(100vh - (60px + 160px));
  overflow: auto;
  padding-top: 40px;
  padding-bottom: 40px;
  padding-right: 10px;
  padding-left: 10px;
  align-items: center;
  justify-content: center;
  margin-left: auto;
  margin-right: auto;
}

.add-task {
  width: 500px;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px;
  margin-top: auto;
  position: fixed;
  bottom: 0;
  padding: 20px 0;
  background-color: #fff;
}
</style>
