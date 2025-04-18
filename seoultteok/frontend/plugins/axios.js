import axios from 'axios'

export default defineNuxtPlugin(() => {
  const instance = axios.create({
    baseURL: 'http://localhost:8081/api',
    withCredentials: false // ❌ JWT는 쿠키 필요 없음
  })

  // ✅ 요청 인터셉터: 토큰 자동으로 붙이기
  instance.interceptors.request.use((config) => {
    const token = localStorage.getItem('token')
    if (token) {
      config.headers.Authorization = `Bearer ${token}`
    }
    return config
  }, (error) => {
    return Promise.reject(error)
  })

  return {
    provide: {
      axios: instance
    }
  }
})
