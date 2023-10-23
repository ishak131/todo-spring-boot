import axios from 'axios'

const apisConfig = {
  baseURL: 'http://localhost:8080/',
  timeout: 10000,
  headers: {
    'Access-Control-Allow-Origin': '*',
    'Content-Type': 'application/json'
  }
}

const authenticationAPIs = axios.create(apisConfig)
const authorizedApis = axios.create(apisConfig)

export { authenticationAPIs, authorizedApis }
