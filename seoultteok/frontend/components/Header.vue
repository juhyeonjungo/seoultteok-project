<template>
  <header class="header">
    <div class="container">
      <NuxtLink to="/" class="logo-box">
        <img src="/images/logo.png" class="logo-img" />
        <span class="site-name">서울떡집</span>
      </NuxtLink>

      <div class="menu-box">
        <input type="text" placeholder="떡 검색하기..." class="search-input" />
        <nav class="top-menu">
          <template v-if="userStore.token">
            <span>{{ userStore.userEmail }}님</span>
            <button @click="logout" class="logout-btn">로그아웃</button>
            <!-- 로그아웃 버튼도 추가 가능 -->
          </template>
          <template v-else>
            <NuxtLink to="/login">로그인</NuxtLink>
            <NuxtLink to="/signup">회원가입</NuxtLink>
          </template>
          <NuxtLink to="/cart">장바구니</NuxtLink>
          <NuxtLink to="/support">고객센터</NuxtLink>
        </nav>
      </div>
    </div>
  </header>
</template>

<script setup>
import { onMounted } from 'vue'
import { useUserStore } from '~/stores/user'
import { useRouter } from 'vue-router'

const userStore = useUserStore()
const router = useRouter()
onMounted(() => {
  userStore.loadUser() // 🔐 클라이언트 환경에서만 실행됨
  console.log("헤더에서 store token:", userStore.token)
  console.log("헤더에서 이메일:", userStore.userEmail)
  console.log("로컬스토리지 직접 확인:", localStorage.getItem('userEmail'))
})


// 로그아웃 핸들러
const logout = () => {
  userStore.logout()
  router.push('/')  // 홈으로 이동 (선택사항)
}
</script>

<style scoped>
.header {
  width: 100%;
  background-color: #fffaf4;
  border-bottom: 1px solid #e4d8c8;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.03);
}

.container {
  max-width: 1200px;
  margin: auto;
  padding: 14px 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

/* 로고 박스 전체를 링크로 */
.logo-box {
  display: flex;
  align-items: center;
  gap: 10px;
  text-decoration: none;
}

.logo-img {
  width: 44px;
  height: 44px;
  border-radius: 50%;
  border: 2px solid #d4a373;
}

.site-name {
  font-size: 24px;
  font-weight: 900;
  color: #5e3023;
  letter-spacing: -0.5px;
  transition: color 0.2s;
}

.logo-box:hover .site-name {
  color: #bb7d49;
}

/* 검색창 + 상단 메뉴 */
.menu-box {
  display: flex;
  align-items: center;
  gap: 24px;
}

.search-input {
  padding: 6px 12px;
  border: 1px solid #d0b49f;
  border-radius: 8px;
  font-size: 14px;
  outline: none;
}

.top-menu {
  display: flex;
  gap: 18px;
}

.top-menu a {
  color: #7b5e57;
  text-decoration: none;
  font-weight: 500;
  transition: color 0.2s;
}

.top-menu a:hover {
  color: #d4a373;
}

.logout-btn {
  margin-left: 8px;
  background: none;
  border: none;
  color: #7b5e57;
  font-weight: bold;
  cursor: pointer;
}

.logout-btn:hover {
  color: #d4a373;
}
</style>
