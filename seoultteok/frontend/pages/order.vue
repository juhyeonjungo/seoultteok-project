<template>
    <div class="order-page">
      <h1>🧾 주문서 작성</h1>
  
      <div class="form-group">
        <label>수령자 이름</label>
        <input v-model="receiverName" type="text" />
      </div>
  
      <div class="form-group">
        <label>배송지 주소</label>
        <input v-model="receiverAddress" type="text" />
      </div>
  
      <div class="form-group">
        <label>연락처 (전화번호)</label>
        <input v-model="receiverPhone" type="tel" />
      </div>
  
      <div class="form-group">
        <label>요청사항 (선택)</label>
        <textarea v-model="memo" rows="3" placeholder="예: 문 앞에 놓아주세요" />
      </div>
  
      <div class="order-summary">
        <p>총 상품 수: {{ totalCount }}개</p>
        <p>총 금액: {{ totalPrice.toLocaleString() }}원</p>
        <button @click="submitOrder">결제하기</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { useCartStore } from '~/stores/cart'
  import { useUserStore } from '~/stores/user'
  import { useToast } from 'vue-toastification'
  import { useRouter } from 'vue-router'
  import { createOrder } from '@/api/orderapi'
  
  const cartStore = useCartStore()
  const userStore = useUserStore()
  const toast = useToast()
  const router = useRouter()
  
  const receiverName = ref('')
  const receiverAddress = ref('')
  const receiverPhone = ref('')
  const memo = ref('')
  
  const totalPrice = computed(() => cartStore.totalPrice)
  const totalCount = computed(() => cartStore.totalCount)
  
  async function submitOrder() {
    if (!receiverName.value || !receiverAddress.value || !receiverPhone.value) {
      return toast.error('❗ 이름, 주소, 연락처는 필수입니다')
    }
  
    const orderData = {
      receiverName: receiverName.value,
      receiverAddress: receiverAddress.value,
      receiverPhone: receiverPhone.value,
      memo: memo.value,
      totalPrice: totalPrice.value,
      items: cartStore.items.map(item => ({
        productId: item.productId,
        quantity: item.quantity,
        price: item.price
      }))
    }
  
    try {
        console.log("주문페이지"+userStore.userEmail);
      await createOrder(userStore.userEmail, orderData)
      toast.success('✅ 주문 완료!')
      cartStore.items = []
      router.push('/')
    } catch (err) {
      console.error(err)
      toast.error('❌ 주문 실패')
    }
  }
  </script>
  
  <style scoped>
  .order-page {
    max-width: 600px;
    margin: auto;
    padding: 20px;
  }
  .form-group {
    margin-bottom: 16px;
    display: flex;
    flex-direction: column;
  }
  input,
  textarea {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 8px;
  }
  textarea {
    resize: none;
  }
  button {
    background: #623b2a;
    color: #fff;
    padding: 10px 20px;
    border-radius: 8px;
    font-weight: bold;
  }
  </style>
  