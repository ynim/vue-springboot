import request from '@/utils/request'

export function pageList(params) {
  return request({
    url: '/duct/pageList',
    method: 'get',
    params
  })
}
