<template>
  <section class="chaltteok-page">
    <div class="container">
      <h1 class="title">전통 찰떡</h1>
      <p class="desc">쫀득한 전통 찰떡을 소개합니다.</p>

      <div class="grid">
        <div
          v-for="product in chaltteokProducts"
          :key="product.productId"
          class="card"
        >
          <img :src="product.imageUrl" :alt="product.name" class="card-img" />
          <div class="card-body">
            <h3 class="name">{{ product.name }}</h3>
            <p class="price">{{ product.retailPrice.toLocaleString() }}원</p>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import { onMounted, computed } from 'vue'
import { useProductStore } from '~/stores/products'

const productStore = useProductStore()

onMounted(async () => {
  await productStore.loadProducts()
})

// category === '전통 찰떡'인 상품만 필터링
const chaltteokProducts = computed(() =>
  productStore.products.filter(product => product.category === '전통 찰떡')
)
</script>

<style scoped>
.chaltteok-page {
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
.grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
  gap: 24px;
}
.card {
  background: white;
  border-radius: 14px;
  box-shadow: 0 4px 14px rgba(0, 0, 0, 0.08);
  overflow: hidden;
}
.card-img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}
.card-body {
  padding: 16px;
}
.name {
  font-weight: 700;
  margin-bottom: 6px;
}
.price {
  color: #333;
}
</style>
