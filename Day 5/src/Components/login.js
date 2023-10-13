import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import 'react-toastify/dist/ReactToastify.css';
import '../Assets/css/login.css';
import { toast, ToastContainer } from 'react-toastify';
import { useDispatch } from 'react-redux';
import { login } from '../Redux/authSlice';
import axios from 'axios';
import image from '../Assets/images/image2.jpg'
import { userLogin } from './api';

function Login() {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });
  

  const navigate = useNavigate();
  const dispatch = useDispatch(); // Get the dispatch function from Redux

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };
  const handleFormSubmit = async (e) => {
    e.preventDefault();
    
    // Check if all fields are filled
    const hasEmptyField = Object.values(formData).some((field) => field === '');
    
    if (hasEmptyField) {
      // Display a Toastify error message
      toast.error('Please fill in all the fields to continue.', {
        position: 'top-center',
        autoClose: 5000,
        hideProgressBar: true,
        closeButton: false,
        closeOnClick: false,
        pauseOnHover: true,
        draggable: false,
      });
    } else {
      try {
        // Make an asynchronous HTTP POST request to your backend API
        const response = await userLogin(formData);
        localStorage.setItem('Token',response.data.token);
        console.log(response.data.token);
        console.log(formData);
        
        // Check the response status
        if (response.status === 200) {
          const token = response.data.token;
          // Dispatch the login action with the form data
          localStorage.setItem('authToken', token)
          dispatch(login(formData.email));
  
          // If login is successful, navigate to the dashboard
          navigate('/Home');
        } else {
          // Handle unsuccessful login
          toast.error('Login failed. Please check your credentials.');
        }
      } catch (error) {
        // Handle network errors or other exceptions
        console.error('An error occurred:', error);
  
        // Display an error message to the user
        toast.error('Login failed. Please try again later.');
      }
    }
  };
  
  return (
    <>
    <div className='mainloginbody' >
      
      
      <div className="loginpage">
        <div className="form-box">
          <form className="form" onSubmit={handleFormSubmit}>
            <span className="title">Blood Donation</span>
            <span className="subtitle">Welcome back</span>
            <div className="form-container">
              <input
                type="text"
                className="input"
                placeholder="email"
                name="email"
                value={formData.email}
                onChange={handleInputChange}
              />
              <input
                type="password"
                className="input"
                placeholder="Password"
                name="password"
                value={formData.password}
                onChange={handleInputChange}
              />
            </div>
            <button type="submit">Sign in</button>
          </form>
          <div className="form-section">
            <p>
              Don't have an account? <Link to="/signup">Signup</Link>{' '}
            </p>
          </div>
        </div>
      </div>
      <ToastContainer />
    </div>
    </>
  );
}

export default Login;
