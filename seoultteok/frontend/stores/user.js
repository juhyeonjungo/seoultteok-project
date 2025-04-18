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
      this.token = localStorage.getItem('token')
      this.userEmail = localStorage.getItem('userEmail')
      if (!this.userEmail) {
        this.token = null  
        localStorage.removeItem('token')
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