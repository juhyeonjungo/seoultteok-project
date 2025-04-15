<template>
    <section class="healthy-page">
      <div class="container">
        <h1 class="title">건강 떡</h1>
        <p class="desc">영양 가득한 건강 떡으로 든든하게 챙기세요.</p>
  
        <div class="grid">
          <div
            v-for="product in healthyProducts"
            :key="product.id"
            class="card"
          >
            <img :src="product.image" :alt="product.name" class="card-img" />
            <div class="card-body">
              <h3 class="name">{{ product.name }}</h3>
              <p class="price">{{ product.price.toLocaleString() }}원</p>
            </div>
          </div>
        </div>
      </div>
    </section>
  </template>
  
  <script setup>
  import { useProductStore } from '~/stores/products'
  
  const productStore = useProductStore()
  
  const healthyProducts = productStore.products.filter(product =>
    ['영양모듬떡', '약식'].includes(product.name)
  )
  </script>
  
  <style scoped>
  .healthy-page {
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
  .grid {
  max-width: 600px; /* ✅ 최대 너비 설정 */
  margin: 0 auto;   /* ✅ 가운데 정렬 */
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
  gap: 24px;
}

  </style>
  