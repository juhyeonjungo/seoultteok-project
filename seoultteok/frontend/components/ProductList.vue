<template>
  <div class="product-grid">
    <div v-for="product in filteredProducts" :key="product.productId" class="card">
      <img :src="product.imageUrl" class="card-img" />
      <div class="card-body">
        <h3>{{ product.name }}</h3>
        <p>{{ product.retailPrice.toLocaleString() }}원</p>
        <button @click="addToCart(product)">담기</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useProductStore } from '~/stores/products'
import { useCartStore } from '~/stores/cart'
import { computed, onMounted } from 'vue'
import { useToast } from 'vue-toastification'
import { useUserStore } from '~/stores/user'

const props = defineProps({
  filterCategory: [String, Array]
})
const toast = useToast()
const productStore = useProductStore()
const cartStore = useCartStore()
const userStore = useUserStore()

onMounted(async () => {
  if (productStore.products.length === 0) {
    await productStore.loadProducts()
  }
})

const filteredProducts = computed(() => {
  if (!props.filterCategory) return productStore.products

  if (Array.isArray(props.filterCategory)) {
    return productStore.products.filter(p =>
      props.filterCategory.includes(p.category)
    )
  }

  return productStore.products.filter(p => p.category === props.filterCategory)
})

function addToCart(product) {
  const userStore = useUserStore()

  cartStore.addToCart(product)

  if (userStore.token) {
    toast.success(`🛒 ${product.name} 이(가) 장바구니에 추가되었습니다!`, {
      timeout: 2000,
      position: 'top-center',
      hideProgressBar: false,
      closeButton: false
    })
  }
}
</script>

<style scoped>
.product-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
  gap: 24px;
  padding: 20px;
}
.card {
  background: white;
  border-radius: 14px;
  box-shadow: 0 4px 14px rgba(0, 0, 0, 0.08);
  overflow: hidden;
  transition: all 0.3s ease; /* ✅ 부드러운 전환 */
}
.card:hover {
  transform: translateY(-5px) scale(1.02); /* ✅ 살짝 떠오름 + 확대 */
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15); /* ✅ 그림자 강조 */
}
.card-img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}
.card-body {
  padding: 16px;
}
button {
  background-color: #d9905c;
  color: white;
  padding: 10px 16px;
  border: none;
  border-radius: 8px;
  font-weight: 600;
  font-size: 14px;
  cursor: pointer;
  transition: background-color 0.2s ease;
  margin-top: 8px;
}

button:hover {
  background-color: #c87f4f;
}
</style>
