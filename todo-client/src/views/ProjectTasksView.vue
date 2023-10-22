<template>
  <div class="todo-list">
    <TodoTask />
    <form class="add-task">
      <TodoInput type="text" />
      <TodoButton @on-click="addNewTask" text="Add" />
    </form>
  </div>
</template>

<script lang="ts">
import TodoButton from '../components/Button/TodoButton.vue'
import TodoInput from '../components/Input/TodoInput.vue'
import TodoTask from '../components/Task/TodoTask.vue'
import { ref } from 'vue'
export default {
  components: {
    TodoButton,
    TodoInput,
    TodoTask
  },
  setup() {
    const tasks = ref([1, 2, 3, 4, 5, 6, 7, 8])

    const addNewTask = (event: any) => {
      console.log(event)

      event.preventDefault()
      tasks.value.push(2)
      console.log('project is added')
    }
    return {
      tasks,
      addNewTask
    }
  }
}
</script>
<style scoped>
.todo-list {
  max-width: 800px;
}

.add-task {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px;
  margin-top: auto;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 40px 20px;
}
</style>
