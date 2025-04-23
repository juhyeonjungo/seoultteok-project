<template>
    <v-container>
      <h2 class="text-h5 font-weight-bold mb-4">🛒 상품 목록 관리</h2>
      <v-btn color="success" class="mb-4" @click="openAddDialog">➕ 상품 추가</v-btn>
      <v-data-table :items="products" :headers="headers" class="elevation-1">
        <template #item.actions="{ item }">
          <v-btn size="small" color="primary" @click="editProduct(item)">수정</v-btn>
          <v-btn size="small" color="error" @click="deleteProduct(item.productId)">삭제</v-btn>
        </template>
      </v-data-table>
      <!--수정 모달창 -->
<v-dialog v-model="editDialog" max-width="600px">
  <v-card>
    <v-card-title class="text-h6">✏️ 상품 정보 수정</v-card-title>
    <v-card-text>
      <v-text-field label="이름" v-model="editedProduct.name" />
      <v-text-field label="소매가" v-model="editedProduct.retailPrice" type="number" />
      <v-text-field label="카테고리" v-model="editedProduct.category" />
      <v-text-field label="재고" v-model="editedProduct.stock" type="number" />
    </v-card-text>
    <v-card-actions>
      <v-spacer />
      <v-btn color="primary" @click="updateProduct">확인</v-btn>
      <v-btn color="grey" @click="editDialog = false">취소</v-btn>
    </v-card-actions>
  </v-card>
</v-dialog>

<!-- 상품 추가 모달 -->
<v-dialog v-model="addDialog" max-width="600px">
  <v-card>
    <v-card-title class="text-h6">🧩 새 상품 등록</v-card-title>
    <v-card-text>
      <v-text-field label="이름" v-model="newProduct.name" />
      <v-text-field label="설명" v-model="newProduct.description" />
      <v-text-field label="재고" v-model="newProduct.stock" type="number" />
      <v-text-field label="이미지 경로" v-model="newProduct.imageUrl" />
      <v-text-field label="카테고리" v-model="newProduct.category" />
      <v-text-field label="소매가" v-model="newProduct.retailPrice" type="number" />
      <v-text-field label="도매가" v-model="newProduct.bulkPrice" type="number" />
    </v-card-text>
    <v-card-actions>
      <v-spacer />
      <v-btn color="primary" @click="addProduct">등록</v-btn>
      <v-btn color="grey" @click="addDialog = false">취소</v-btn>
    </v-card-actions>
  </v-card>
</v-dialog>
    </v-container>

    
  </template>
  
  <script setup>
  import { onMounted, ref } from 'vue'
  import { useProductAdminStore } from '@/stores/productadmin'
  import { useToast } from 'vue-toastification'
  
  const store = useProductAdminStore()
  const products = ref([])
  const editDialog = ref(false)
  const editedProduct = ref({})
  const toast = useToast()
  const addDialog = ref(false)

  const newProduct = ref({
  name: '',
  description: '',
  stock: 0,
  imageUrl: '',
  category: '',
  retailPrice: 0,
  bulkPrice: 0
})

  const headers = [
    { title: 'ID', key: 'productId' },
    { title: '이름', key: 'name' },
    { title: '소매가', key: 'retailPrice' },
    { title: '카테고리', key: 'category' },
    { title: '재고', key: 'stock' },
    { title: '관리', key: 'actions' },
  ]
  
  onMounted(async () => {
    products.value = await store.fetchAllProducts()
  })
  
  function editProduct(product) {
    editedProduct.value = { ...product } // 깊은 복사
    editDialog.value = true
  }

  function openAddDialog() {
  newProduct.value = {
    name: '',
    description: '',
    stock: 0,
    imageUrl: '',
    category: '',
    retailPrice: 0,
    bulkPrice: 0
  }
  addDialog.value = true
}

  // 백엔드에 상품 수정 요청
  async function updateProduct() {
  try {
    await store.updateProduct(editedProduct.value)
    products.value = await store.fetchAllProducts()
    editDialog.value = false

    toast.success('✅ 상품 수정 완료!')
  } catch (err) {
    toast.error('❌ 상품 수정 실패')
    console.error(err)
  }
}
// 백엔드 상품 추가 요청청
async function addProduct() {
  try {
    await store.addProduct(newProduct.value)
    products.value = await store.fetchAllProducts()
    toast.success('✅ 상품이 성공적으로 등록되었습니다')
    addDialog.value = false
  } catch (e) {
    toast.error('❌ 등록 실패')
  }
}
  
  async function deleteProduct(productId) {
    if (confirm('정말 삭제하시겠습니까?')) {
      await store.deleteProduct(productId)
      products.value = await store.fetchAllProducts()
    }
  }
  </script>
  