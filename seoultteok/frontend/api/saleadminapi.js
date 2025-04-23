import { useNuxtApp } from '#app'

export const useSalesApi = () => {
  const { $axios } = useNuxtApp()

  const fetchSalesData = async (period = 'daily') => {
    const response = await $axios.get(`/admin/sales?period=${period}`)
    console.log("✅ 백엔드 응답:", response.data)
    return response.data
  }

  return { fetchSalesData }
}