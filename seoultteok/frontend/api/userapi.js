import { useNuxtApp } from '#app'

export async function signupAPI(data) {
  const { $axios } = useNuxtApp()
  console.log("axios");
  return await $axios.post('/members/signup', data)
}
