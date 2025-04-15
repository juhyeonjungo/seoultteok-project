// stores/products.js
import { defineStore } from 'pinia'

export const useProductStore = defineStore('product', {
  state: () => ({
    products: [
      {
        id: 1,
        name: '꿀떡',
        enName: 'Honey Rice Cake',
        price: 6000,
        image: '/images/gguldduck.png',
      },
      {
        id: 2,
        name: '흑설탕 백설기',
        enName: 'Black Sugar Baekseolgi',
        price: 7000,
        image: '/images/blacksugarbaekseolgi.jpg',
      },
      {
        id: 3,
        name: '팥시루떡',
        enName: 'Red Bean Sirutteok',
        price: 8000,
        image: '/images/redbeansirutteok.png',
      },
      {
        id: 4,
        name: '콩시루떡',
        enName: 'Soybean Sirutteok',
        price: 8000,
        image: '/images/soybeansirutteok.jpg',
      },
      {
        id: 5,
        name: '백일떡 흑설탕백설기',
        enName: '100th Day Black Sugar Baekseolgi',
        price: 10000,
        image: '/images/baekseolgi100.jpg',
      },
      {
        id: 6,
        name: '약식',
        enName: 'Yakshik',
        price: 9000,
        image: '/images/yakshik.jpg',
      },
      {
        id: 7,
        name: '반달떡',
        enName: 'Half Moon Rice Cake',
        price: 8500,
        image: '/images/half-moon-rice-cake.jpg',
      },
      {
        id: 8,
        name: '첫돌 백설기',
        enName: 'First Birthday Baekseolgi',
        price: 10000,
        image: '/images/first-birthday-baekseolgi.jpg',
      },
      {
        id: 9,
        name: '콩호박백설기',
        enName: 'Pumpkin Baekseolgi',
        price: 9500,
        image: '/images/pumpkinbaekseolgi.jpg',
      },
      {
        id: 10,
        name: '영양모듬떡',
        enName: 'Healthy Mixed Tteok',
        price: 9500,
        image: '/images/modeum.jpg',
      },
      {
        id: 11,
        name: '쑥땅콩모찌',
        enName: 'Healthy Mixed Tteok',
        price: 9500,
        image: '/images/mochi.jpg',
      },
    ]
  })
})
