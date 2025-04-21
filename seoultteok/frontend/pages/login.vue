<template>
  <v-container class="d-flex justify-center align-center" style="height: 100vh;">
    <v-card
      class="pa-8"
      max-width="500"
      min-width="400"
      elevation="10"
    >
      <v-card-title class="text-h5 font-weight-bold mb-6 justify-center">
        🔐 로그인
      </v-card-title>

      <v-form @submit.prevent="submit">
        <v-text-field
          v-model="email"
          label="이메일"
          type="email"
          placeholder="이메일을 입력하세요"
          prepend-inner-icon="mdi-email"
          density="comfortable"
          class="mb-4"
          hide-details
        />

        <v-text-field
          v-model="password"
          label="비밀번호"
          type="password"
          placeholder="비밀번호를 입력하세요"
          prepend-inner-icon="mdi-lock"
          density="comfortable"
          hide-details
        />

        <v-btn
          type="submit"
          color="brown-darken-2"
          variant="elevated"
          size="large"
          block
          class="mt-6"
        >
          로그인
        </v-btn>
      </v-form>
    </v-card>
  </v-container>
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
    if (!cartStore.cartId) {
      await cartStore.initCart(userStore.userEmail)
    }

    toast.success('✅ 로그인 성공!')
    router.push('/')
  } catch (e) {
    toast.error('❌ 로그인 실패: 이메일 또는 비밀번호 확인')
  }
}
</script>
