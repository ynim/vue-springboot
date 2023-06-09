import request from '@/utils/request'
// import Axios from '@/utils/request'

export function findAll(params) {
  return request({
    url: '/warn/selectlike',
    method: 'get',
    params
  })
}
// export const findAll = () => Axios.get('warn/findall')
export function pageList(params) {
  return request({
    url: '/warn/pageList',
    method: 'get',
    params
  })
}
// export const pageList = (params) => Axios.get('/warn/pageList', params)

export function deleteById(id) {
  return request({
    url: '/warn/remove',
    method: 'delete',
    params: { id }
  })
}
// export const deleteById = (params) => Axios.delete('/warn/remove', params)

export function addWarnings(params) {
  return request({
    url: '/warn/addwarning',
    method: 'post',
    params
  })
}
// export const addWarnings = (params) => Axios.post('/warn/addwarning', params)

export function updateWarning(params) {
  return request({
    url: '/warn/update',
    method: 'post',
    params
  })
}
// export const updateWarning = (params) => Axios.put('/warn/updateWarnings', params)
