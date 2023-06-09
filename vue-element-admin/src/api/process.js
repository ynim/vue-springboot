import request from '@/utils/request'

export function pageList(params) {
  return request({
    url: '/cess/pageList',
    method: 'get',
    params
  })
}
