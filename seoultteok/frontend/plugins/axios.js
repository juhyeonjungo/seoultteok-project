import axios from 'axios'

export default defineNuxtPlugin(() => {
  const instance = axios.create({
    baseURL: 'http://localhost:8081/api',  // ⬅️ 백엔드 주소
    withCredentials: true
  })

  return {
    provide: {
      axios: instance
    }
  }
})