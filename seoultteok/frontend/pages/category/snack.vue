<template>
  <section class="category-page">
    <div class="container">
      <h1 class="title">간식/모찌</h1>
      <p class="desc">출출할 때, 간단한 간식과 모찌로 달래보세요.</p>
      <ProductList filterCategory="간식/모찌" />
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




