<template>
  <nav class="gnb">
    <ul class="gnb-list">
      <li><NuxtLink to="/category/ceremony">답례떡·행사떡</NuxtLink></li>
      <li><NuxtLink to="/category/chaltteok">전통 찰떡</NuxtLink></li>
      <li><NuxtLink to="/category/snack">간식/모찌</NuxtLink></li>
      <li><NuxtLink to="/category/healthy">건강 떡</NuxtLink></li>
      <li><NuxtLink to="/category/comingroot">오시는 길</NuxtLink></li>
    </ul>
  </nav>
</template>

<style scoped>
.gnb {
  background-color: #fff0e0;
  border-top: 1px solid #e0cfc0;
  border-bottom: 1px solid #e0cfc0;
  box-shadow: inset 0 -1px 0 rgba(0, 0, 0, 0.03);
}

.gnb-list {
  max-width: 1200px;
  margin: auto;
  display: flex;
  justify-content: center;
  gap: 32px;
  padding: 14px 20px;
  list-style: none;
}

.gnb-list li a {
  color: #5c4033;
  font-weight: 600;
  font-size: 15px;
  text-decoration: none;
  transition: color 0.2s, border-bottom 0.2s;
  padding-bottom: 3px;
  border-bottom: 2px solid transparent;
}

.gnb-list li a:hover {
  color: #d38852;
  border-bottom: 2px solid #d38852;
}
</style>
