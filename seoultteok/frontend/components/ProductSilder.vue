<template>
  <section class="all-products-section">
    <div class="container">
      <h2 class="title"><span class="brand">서울떡집</span> <span class="highlight">모든 떡</span></h2>

      <!-- 슬라이드 전체 컨테이너 -->
      <div class="slider-wrapper">
        <!-- 왼쪽 버튼 -->
        <button class="arrow-btn left" @click="scrollLeft">←</button>

        <!-- 제품 카드 슬라이더 -->
        <div class="slider" ref="sliderRef">
          <div
            v-for="product in productStore.products"
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

        <!-- 오른쪽 버튼 -->
        <button class="arrow-btn right" @click="scrollRight">→</button>
      </div>
    </div>
  </section>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useProductStore } from '@/stores/products'

const productStore = useProductStore()
const sliderRef = ref(null)

onMounted(async () => {
  await productStore.loadProducts()
})

const scrollLeft = () => {
  sliderRef.value.scrollBy({ left: -320, behavior: 'smooth' })
}

const scrollRight = () => {
  sliderRef.value.scrollBy({ left: 320, behavior: 'smooth' })
}
</script>

<style scoped>
.all-products-section {
  background-color: #fff;
  padding: 60px 20px;
}

.container {
  max-width: 1200px;
  margin: auto;
}

.title {
  font-size: 24px;
  margin-bottom: 24px;
  text-align: center;
  color: #3b2f2f;
}
.title .brand {
  color: #b08968;
}
.title .highlight {
  color: #6f4e37;
  font-weight: 800;
}

.slider-wrapper {
  position: relative;
  overflow: hidden;
}

.slider {
  display: flex;
  overflow-x: auto;
  scroll-behavior: smooth;
  gap: 24px;
  padding-bottom: 10px;
  scrollbar-width: none;
}
.slider::-webkit-scrollbar {
  display: none;
}

.card {
  min-width: 280px;
  flex: 0 0 auto;
  background: #fffaf4;
  border-radius: 14px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.08);
  transition: transform 0.3s ease;
  text-align: center;
}
.card:hover {
  transform: translateY(-4px);
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
  font-size: 16px;
  font-weight: 700;
  margin-bottom: 6px;
}
.price {
  font-size: 15px;
  color: #555;
}

.arrow-btn {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background-color: #fff0e6;
  border: none;
  padding: 10px 14px;
  border-radius: 50%;
  font-size: 18px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
  cursor: pointer;
  z-index: 2;
}
.arrow-btn:hover {
  background-color: #ffe4c4;
}
.arrow-btn.left {
  left: -12px;
}
.arrow-btn.right {
  right: -12px;
}
</style>
