import request from '@/utils/request'

export function getToken() {
  return request({
    url: '/user/login', // 假地址 自行替换
    method: 'get'
  })
}
