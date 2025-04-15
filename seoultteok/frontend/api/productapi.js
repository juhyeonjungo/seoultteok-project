import axios from 'axios'

const API_BASE_URL = 'http://localhost:8081/api/products' // 실제 Spring Boot 백엔드 주소

export const fetchProducts = () => {
  console.log("정주현");
  return axios.get(API_BASE_URL)
}