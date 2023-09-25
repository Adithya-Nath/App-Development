import { configureStore } from '@reduxjs/toolkit';
import authReducer from './authSlice';
import applicationReducer from './applicationSlice';
import bloodReducer from './BloodSlice'; // Updated import

const store = configureStore({
  reducer: {
    auth: authReducer, 
    applications: applicationReducer,
    blood: bloodReducer, // Updated reducer name
  },
});

export default store;
