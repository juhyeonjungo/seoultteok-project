import { useNuxtApp } from '#app'

export async function signupAPI(data) {
  const { $axios } = useNuxtApp()
  console.log("axios");
  return await $axios.post('/members/signup', data)
}

export async function loginAPI(data) {
  const { $axios } = useNuxtApp()
  const res = await $axios.post('/members/login', data)

  const token = res.data.token

  // ✅ 디코딩해서 이메일 추출
  try {
    const base64Payload = token.split('.')[1]
    const payload = JSON.parse(atob(base64Payload))
    const email = payload.sub  // 여기서 null 또는 undefined면 문제 발생
    console.log("📦 디코딩된 email:", email)
    return { token, email }
  } catch (err) {
    console.error("❌ 토큰 디코딩 실패:", err)
    return { token, email: null }  // fallback 처리
  }
}