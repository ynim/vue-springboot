import request from '@/utils/request'

export function pageList(params) {
  return request({
    url: '/ptdt/findygall',
    method: 'get',
    params
  })
}

export function updateyg(params) {
  return request({
    url: '/ptdt/update',
    method: 'post',
    params
  })
}

export function addyg(params) {
  return request({
    url: '/ptdt/insert',
    method: 'post',
    params
  })
}

export function deleteById(id) {
  return request({
    url: '/ptdt/delete',
    method: 'delete',
    params: { id }
  })
}
