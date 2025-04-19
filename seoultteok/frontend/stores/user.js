import { defineStore } from 'pinia'
import { signupAPI, loginAPI } from '@/api/userapi'

export const useUserStore = defineStore('user', {
  state: () => ({
    userEmail: null,
    token: null
  }),
  actions: {
    // 회원가입은 토큰 저장 X
    async signup(formData) {
      await signupAPI(formData)
    },

    // 로그인은 토큰 저장 O
    async login(formData) {
      const res = await loginAPI(formData)
    
      // 🔐 저장 순서 조심 + 콘솔 꼭 확인
    
      this.token = res.token
      this.userEmail = res.email
    
      
      localStorage.setItem('token', res.token)
      localStorage.setItem('userEmail', res.email)
      
    },

    loadUser() {
      const token = localStorage.getItem('token')
      const email = localStorage.getItem('userEmail')
    
      if (token) {
        try {
          const payload = JSON.parse(atob(token.split('.')[1]))  // 가운데 부분 디코딩
          const now = Math.floor(Date.now() / 1000)              // 초 단위 현재시간
    
          if (payload.exp < now) {
            // 🔥 토큰 만료됨
            this.logout()
            return
          }
    
          // ✅ 유효한 경우에만 상태 복구
          this.token = token
          this.userEmail = email
        } catch (e) {
          console.error("세션 만료 했다이:", e)
          alert("🔒 세션이 만료되어 자동 로그아웃 되었습니다.")
          this.logout()
        }
      }
    },

    logout() {
      this.token = null
      this.userEmail = null
      localStorage.removeItem('token')
      localStorage.removeItem('userEmail')
    }

  }
})