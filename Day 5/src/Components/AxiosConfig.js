import axios from 'axios';

const axiosInstance = axios.create();

axiosInstance.defaults.baseURL = 'http://localhost:8080'; 

axiosInstance.interceptors.request.use(
  (config) => {
    const authToken = localStorage.getItem('authToken');
    if (authToken) {
      config.headers.Authorization = `Bearer ${authToken}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default axiosInstance;