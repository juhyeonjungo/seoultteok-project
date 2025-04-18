<template>
    <div class="login-wrapper">
      <h2>로그인</h2>
  
      <div class="form-group">
        <label>이메일</label>
        <input v-model="email" type="email" placeholder="이메일 입력" />
      </div>
  
      <div class="form-group">
        <label>비밀번호</label>
        <input v-model="password" type="password" placeholder="비밀번호 입력" />
      </div>
  
      <button @click="submit">로그인</button>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { useRouter } from 'vue-router'
  import { useUserStore } from '@/stores/user'
  import { useToast } from 'vue-toastification'
  import { useCartStore } from '@/stores/cart'
  
  const email = ref('')
  const password = ref('')
  const router = useRouter()
  const userStore = useUserStore()
  const toast = useToast()
  const cartStore = useCartStore()

  async function submit() {
  try {
    await userStore.login({ email: email.value, password: password.value })

    await cartStore.fetchCart(userStore.userEmail)
     console.log("장바구니 있는지 확인했니?");
   
     
    // 🛒 장바구니가 없을 경우 생성
    if (!cartStore.cartId) {
      await cartStore.initCart(userStore.userEmail)
      console.log("장바구니 만들러갈게영");
    }

    toast.success('✅ 로그인 성공했습니다!')
    router.push('/')
  } catch (e) {
    toast.error('❌ 로그인 실패: 이메일 또는 비밀번호를 확인하세요')
    console.error(e)
  }
}

  </script>
  
  <style scoped>
  .login-wrapper {
    max-width: 400px;
    margin: auto;
    padding: 30px;
    background: #fff;
  }
  .form-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 14px;
  }
  input {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 6px;
  }
  button {
    background: #623b2a;
    color: white;
    border: none;
    padding: 12px;
    border-radius: 6px;
    cursor: pointer;
    font-weight: bold;
  }
  </style>
  