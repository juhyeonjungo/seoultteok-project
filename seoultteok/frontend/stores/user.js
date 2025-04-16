import { defineStore } from 'pinia'
import { signupAPI } from '@/api/userapi'

export const useUserStore = defineStore('user', {
  state: () => ({
    user: null
  }),
  actions: {
    async signup(formData) {
        console.log("정주현");
      const res = await signupAPI(formData)
      return res
    }
  }
})