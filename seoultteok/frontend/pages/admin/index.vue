<!-- /pages/admin/index.vue -->
<template>
    <div class="admin-page">
      <h1> 서울떡집 관리자 공간입니다.</h1>
      <!-- 예시: 관리자용 기능 나열 -->
      <ul>
        <li><NuxtLink to="/admin/products">상품 목록 관리</NuxtLink></li>
        <li><NuxtLink to="/admin/orders">주문 전체 관리</NuxtLink></li>
        <li><NuxtLink to="/admin/sales">매출 관리</NuxtLink></li>
      </ul>
    </div>
  </template>
  
  <script setup>
  import { useUserStore } from '@/stores/user'
  import { useRouter } from 'vue-router'
  
  const userStore = useUserStore()
  const router = useRouter()
  
  // ✅ 관리자만 접근 허용
  if (userStore.token) {
    const payload = JSON.parse(atob(userStore.token.split('.')[1]))
    if (payload.role !== 'ADMIN') {
      alert('관리자만 접근 가능한 페이지입니다.')
      router.push('/')
    }
  } else {
    alert('로그인이 필요합니다.')
    router.push('/login')
  }
  </script>
  
  <style scoped>
  .admin-page {
    max-width: 800px;
    margin: auto;
    padding: 40px;
  }
  </style>
  