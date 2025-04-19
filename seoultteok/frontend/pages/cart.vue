<template>
  <div class="container">
    <h1>🛒 장바구니</h1>

    <div v-if="cartItems.length === 0">
      <p>장바구니가 비어있습니다.</p>
    </div>

    <div v-else class="cart-list">
      <div v-for="item in cartItems" :key="item.cartItemId" class="cart-item">
        <img :src="item.image" class="thumb" />
        <div class="info">
          <h3>{{ item.name }}</h3>
          <p>{{ item.price.toLocaleString() }}원</p>
          <input
            type="number"
            v-model.number="item.quantity"
            min="1"
            @change="changeQuantity(item.cartItemId, item.quantity)"
          />
          <button @click="remove(item.cartItemId)">삭제</button>
        </div>
      </div>

      <hr />
      <div class="summary">
        <p>총 상품 수: {{ totalCount }}개</p>
        <p>총 금액: {{ totalPrice.toLocaleString() }}원</p>
        <button @click="checkout">주문하기</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useCartStore } from '~/stores/cart'
import { computed } from 'vue'
import { onMounted } from 'vue'
import { useUserStore } from '~/stores/user'

const userStore = useUserStore()
const cartStore = useCartStore()

const cartItems = computed(() => cartStore.items)
const totalPrice = computed(() => cartStore.totalPrice)
const totalCount = computed(() => cartStore.totalCount)


onMounted(async () => {
  console.log("✅ 현재 로그인 이메일:", userStore.userEmail)
  if (userStore.userEmail) {
    await cartStore.fetchCart(userStore.userEmail)
  }
})

function changeQuantity(cartItemId, quantity) {
  cartStore.updateQuantity(cartItemId, quantity)
}

function remove(cartItemId) {
  cartStore.removeFromCart(cartItemId)
}

function checkout() {
  alert('🚨 결제기능은 아직 미구현입니다!')
}
</script>

  
  <style scoped>
 .container {
  max-width: 700px;
  margin: auto;
  padding: 20px;
}

.cart-item {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 20px;
  margin-bottom: 24px;
  padding: 16px;
  border-radius: 16px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
  background-color: #fff;
}

.thumb {
  width: 100px;
  height: 100px;
  object-fit: cover;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.info {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.info h3 {
  font-size: 18px;
  margin: 0;
}

.info p {
  color: #444;
  margin: 0;
}

input[type="number"] {
  width: 80px;
  padding: 6px 10px;
  border: 1px solid #ccc;
  border-radius: 8px;
  font-size: 14px;
}

button {
  /* ✅ 너비를 고정 또는 auto로 지정 */
  width: auto;
  padding: 6px 14px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #fff;
  cursor: pointer;
  transition: all 0.2s ease;
}

button:hover {
  background-color: #f8f8f8;
  border-color: #999;
}

.summary {
  text-align: right;
  margin-top: 30px;
  font-size: 16px;
}

.summary button {
  background-color: #222;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 10px;
  margin-top: 12px;
}

.summary button:hover {
  background-color: #444;
}

  </style>
  