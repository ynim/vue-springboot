import request from '@/utils/request'

export function pageList(params) {
  return request({
    url: '/cess/pageList',
    method: 'get',
    params
  })
}

export function addProcess(params) {
  return request({
    url: '/cess/insert',
    method: 'post',
    params
  })
}

export function updateProcess(params) {
  return request({
    url: '/cess/update',
    method: 'post',
    params
  })
}

export function deleteById(id) {
  return request({
    url: '/cess/c',
    method: 'delete',
    params: { id }
  })
}
