import request from '@/utils/request'

export function pageList(params) {
  return request({
    url: '/duct/pageList',
    method: 'get',
    params
  })
}

export function addPlant(params) {
  return request({
    url: '/duct/insert',
    method: 'post',
    params
  })
}

export function updatePlant(params) {
  return request({
    url: '/duct/update',
    method: 'post',
    params
  })
}

export function deleteById(id) {
  return request({
    url: '/duct/delete',
    method: 'delete',
    params: { id }
  })
}
