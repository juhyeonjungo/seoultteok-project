<template>
  <section class="category-page">
    <div class="container">
      <h1 class="title">건강 떡</h1>
      <p class="desc">영양 가득한 건강 떡으로 든든하게 챙기세요.</p>
      <ProductList filterCategory="건강떡" />
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
.product-grid {
  max-width: 400px;     /* ✅ 카드 영역 폭 제한 */
  margin: 0 auto;         /* ✅ 가운데 정렬 */
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
  gap: 24px;
  padding: 20px;
}
</style>






