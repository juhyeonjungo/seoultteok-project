<template>
  <header class="header">
    <div class="container">
      <!-- 로고 및 사이트명 -->
      <NuxtLink to="/" class="logo-box">
        <img src="/images/logo.png" alt="서울떡집 로고" class="logo-img" />
        <span class="site-name">서울떡집</span>
      </NuxtLink>

      <!-- 검색창 + 메뉴 -->
      <div class="menu-box">
        <input type="text" placeholder="떡 검색하기..." class="search-input" />
        <nav class="top-menu">
          <NuxtLink to="/login">로그인</NuxtLink>
          <NuxtLink to="/signup">회원가입</NuxtLink>
          <NuxtLink to="/cart">장바구니</NuxtLink>
          <NuxtLink to="/support">고객센터</NuxtLink>
        </nav>
      </div>
    </div>
  </header>
</template>

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
</style>
