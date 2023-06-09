import request from '@/utils/request'

export function pageList(params) {
  return request({
    url: '/ject/pageList',
    method: 'get',
    params
  })
}

export function addproject(params) {
  return request({
    url: '/ject/insert',
    method: 'post',
    params
  })
}

export function updateproject(params) {
  return request({
    url: '/ject/update',
    method: 'post',
    params
  })
}

export function deleteById(id) {
  return request({
    url: '/ject/remove',
    method: 'delete',
    params: { id }
  })
}
