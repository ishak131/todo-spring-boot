<template>
  <div class="page projects">
    <ProjectCard v-for="(project, index) in projects" :project="project" :key="index" />
    <form class="add-project">
      <TodoInput
        :value="projectTitle"
        type="text"
        placeholder="Project Title"
        @on-change="onProjectTitleChange"
      />
      <TodoButton @on-click="addNewProject" text="Add" />
    </form>
  </div>
</template>

<script setup lang="ts">
import ProjectCard from '../components/Project/ProjectCard.vue'
import TodoButton from '../components/Button/TodoButton.vue'
import TodoInput from '../components/Input/TodoInput.vue'
import { authorizedApis } from '../api/axiosSetup'
import { onMounted, reactive, ref } from 'vue'

const projects = reactive<any[]>([])
const projectTitle = ref('')

onMounted(() => {
  getProjects()
})

const onProjectTitleChange = (event: any) => {
  projectTitle.value = event.target.value
}

const getProjects = () => {
  authorizedApis
    .get('/projects')
    .then((res) => {
      projects.splice(0, projects.length)
      projects.push(...res.data)
    })
    .catch((err) => {
      console.log({ err })
    })
}

const addNewProject = (event: any) => {
  event.preventDefault()
  authorizedApis
    .post('/projects', {
      title: projectTitle.value,
      description: 'description of: ' + projectTitle.value
    })
    .then((res) => {
      getProjects()
      projectTitle.value = ''
    })
    .catch((err) => {
      console.log({ err })
    })
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
  padding: 20px 20px;
}
</style>
