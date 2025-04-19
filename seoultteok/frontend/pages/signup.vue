<template>
    <div class="signup-wrapper">
      <h2>회원가입</h2>
  
      <!-- 약관 -->
      <section class="agreement-section">
        <label class="all-check">
          <input type="checkbox" v-model="agreeAll" @change="toggleAll" />
          전체 약관에 동의합니다.
        </label>
  
        <div v-for="(item, index) in agreements" :key="index" class="agreement-box">
          <label>
            <input type="checkbox" v-model="item.checked" />
            {{ item.label }}
          </label>
          <textarea readonly>{{ item.content }}</textarea>
        </div>
      </section>
  
      <!-- 기본 정보 -->
      <section class="info-section">
        <h3>기본 정보</h3>
        <div class="form-group">
          <label>아이디 (이메일)</label>
          <input v-model="form.email" type="email" />
        </div>
        <div class="form-group">
          <label>비밀번호</label>
          <input v-model="form.password" type="password" />
        </div>
        <div class="form-group">
          <label>비밀번호 확인</label>
          <input v-model="confirmPassword" type="password" />
        </div>
        <div class="form-group">
          <label>이름</label>
          <input v-model="form.name" type="text" />
        </div>
        <div class="form-group">
          <label>휴대폰번호</label>
          <input v-model="form.phone" type="tel" />
        </div>
       
      </section>
  
      <!-- 부가 정보 -->
      <section class="info-section">
        <h3>부가 정보</h3>
        <div class="form-group">
          <label>생년월일</label>
          <input v-model="form.birth" type="date" />
        </div>
        <div class="form-group">
          <label>주소</label>
          <input v-model="form.address" type="text" />
        </div>
      </section>
  
      <!-- 버튼 -->
      <div class="action">
        <button @click="submit">회원가입</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { useRouter } from 'vue-router'
  import { useUserStore } from '@/stores/user'
  
  const router = useRouter()
  const userStore = useUserStore()
  
  const form = ref({
    email: '',
    password: '',
    name: '',
    phone: '',
    birth: '',
    address: '',
    role:'User',
  })
  const confirmPassword = ref('')
  
  const agreements = ref([
    { label: '(필수) 이용약관 동의', checked: false, content: '서비스 이용과 관련하여 회사가 정한 모든 정책 및 운영규칙을 준수할 것을 동의합니다.' },
    { label: '(필수) 개인정보 수집 및 이용 동의', checked: false, content: '회원가입, 주문처리 및 고객응대를 위해 이름, 이메일, 연락처 등의 개인정보를 수집하며, 수집된 정보는 회원 탈퇴 시까지 보관됩니다.' },
    { label: '(선택) 마케팅 활용 동의', checked: false, content: '이벤트, 할인 쿠폰, 신상품 소식을 이메일 및 문자로 받아보는 것에 동의합니다. 언제든지 수신을 거부할 수 있습니다.' }
  ])
  const agreeAll = ref(false)
  
  function toggleAll() {
    agreements.value.forEach(a => (a.checked = agreeAll.value))
  }
  
  async function submit() {
    const required = agreements.value.slice(0, 2)
    if (!required.every(a => a.checked)) return alert('필수 약관을 동의해주세요.')
    if (form.value.password !== confirmPassword.value) return alert('비밀번호가 일치하지 않습니다.')
  
    try {
      console.log("회원가입 시작")
      await userStore.signup(form.value)
      alert('가입 완료')
      router.push('/login')
    } catch (e) {
      console.error(e)
      alert('가입 실패')
    }
  }
  </script>
  
  <style scoped>
  .signup-wrapper {
    max-width: 600px;
    margin: auto;
    padding: 30px;
    background: #fff;
  }
  .agreement-section,
  .info-section {
    margin-bottom: 24px;
  }
  .form-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 14px;
  }
  .form-group input {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 6px;
  }
  textarea {
    width: 100%;
    height: 120px;
    margin-top: 8px;
    padding: 8px;
    border: 1px solid #ccc;
  }
  button {
    background: #623b2a;
    color: white;
    border: none;
    padding: 12px 24px;
    cursor: pointer;
    font-weight: bold;
    border-radius: 6px;
  }
  </style>
  