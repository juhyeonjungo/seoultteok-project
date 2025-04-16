<template>
  <section class="category-page">
    <div class="container">
      <h1 class="title">답례떡 / 행사떡</h1>
      <p class="desc">정성 가득한 답례떡, 행사떡을 소개합니다.</p>
      <ProductList filterCategory="답례떡/행사떡" />
    </div>
  </section>
</template>

<script setup>
import ProductList from '~/components/ProductList.vue'
</script>

<style scoped>
.category-page {
  padding: 60px 20px;
  background-color: #fffaf4;
}
.container {
  max-width: 1200px;
  margin: auto;
  text-align: center;
}
.title {
  font-size: 28px;
  font-weight: bold;
  margin-bottom: 16px;
}
.desc {
  color: #555;
  margin-bottom: 32px;
}
</style>
