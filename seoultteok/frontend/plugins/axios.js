import axios from 'axios'
import { useToast } from 'vue-toastification'

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

  // ✅ 응답 인터셉터: 토큰 만료 및 권한 없음 처리
  instance.interceptors.response.use(
    res => res,
    err => {
      const code = err.response?.status
      const toast = useToast()

      if (code === 401) {
        toast.error("🔐 로그인 필요 또는 토큰 만료됨")

        // 👉 토큰 초기화
        const userStore = useUserStore()
        userStore.logout()

        window.location.href = "/login"
      }

      if (code === 403) {
        toast.error("⛔ 로그인을 해주세요 (접근 불가)")
      }

      return Promise.reject(err)
    }
  )

  return {
    provide: {
      axios: instance
    }
  }
})
