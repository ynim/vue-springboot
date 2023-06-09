import Axios from "axios";
const API = Axios.create({
    baseURL:'/',
    timeout:3000
})
export default API