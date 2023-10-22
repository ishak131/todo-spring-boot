<template>
  <div class="page projects">
    <ProjectCard v-for="(project, index) in projects" :title="project" :key="index" />
    <form class="add-project">
      <TodoInput type="text" />
      <TodoButton @on-click="addNewProject" text="Add" />
    </form>
  </div>
</template>

<script lang="ts">
import ProjectCard from '../components/Project/ProjectCard.vue'
import TodoButton from '../components/Button/TodoButton.vue'
import TodoInput from '../components/Input/TodoInput.vue'
import { ref } from 'vue'
export default {
  components: {
    ProjectCard,
    TodoButton,
    TodoInput
  },
  // `setup` is a special hook dedicated for the Composition API.
  setup() {
    const projects = ref([1, 2, 3, 4, 5, 6, 7, 8])

    const addNewProject = (event: any) => {
      console.log(event)

      event.preventDefault()
      projects.value.push(2)
      console.log('project is added')
    }
    // expose the ref to the template
    return {
      projects,
      addNewProject
    }
  }
}
</script>

<style scoped>
.projects {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  gap: 30px;
  height: calc(100vh - (60px + 160px));
  overflow: auto;
  padding-top: 40px;
  padding-bottom: 40px;
  align-items: center;
}

.add-project {
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
