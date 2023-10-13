import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import 'react-toastify/dist/ReactToastify.css';
import '../Assets/css/signup.css';
import { toast, ToastContainer } from 'react-toastify';
import axios from 'axios';
import { userRegister } from './api';

function Signup() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleFormSubmit = async (e) => {
    e.preventDefault();
  
    // Check if all fields are filled
    const hasEmptyField = Object.values(formData).some((field) => field === '');
  
    // Check if the email is in a valid format using a regular expression
    const isValidEmail = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(
      formData.email
    );
  
    // Check if the password contains at least one symbol and one number
    const isValidPassword = /^(?=.*[!@#$%^&*])(?=.*\d).+$/.test(formData.password);
  
    if (hasEmptyField) {
      // Display a creative alert message using Toastify
      toast.error(
        <div>
          <p>Please fill in all the fields to continue.</p>
          <div className="loader">
            {/* ... Loader HTML */}
          </div>
        </div>,
        {
          position: 'top-center',
          autoClose: 5000,
          hideProgressBar: true,
          closeButton: false,
          closeOnClick: false,
          pauseOnHover: true,
          draggable: false,
        }
      );
    } else if (!isValidEmail) {
      // Display an error message for an invalid email
      toast.error('Please enter a valid email address.');
    } else if (!isValidPassword) {
      // Display an error message for an invalid password
      toast.error(
        'Password must contain at least one symbol (!@#$%^&*) and at least one number.'
      );
    } else {
      try {
        // Make an HTTP POST request to your baxxckend API
        const response = await userRegister(formData);
        console.log(response.data);
  
        // Check the response status
        if (response.status === 200) {
          // Signup was successful, you can navigate to a success page or handle it as needed
          navigate('/');
        } else {
          // Handle any error from the backend
          toast.error('Signup failed. Please try again later.');
        }
      } catch (error) {
        // Handle network errors or other exceptions
        toast.error('Signup failed. Please try again later.');
      }
    }
  };
  

  return (
    <>
    <div className='signupbody'>
      <div className="form-box">
        <form className="form" onSubmit={handleFormSubmit}>
          <span className="title">Welcome</span>
          <span className="subtitle">Create a free account </span>
          <div className="form-container">
            <input
              type="text"
              className="input"
              placeholder="Name"
              name="name"
              value={formData.fullName}
              onChange={handleInputChange}
            />
            <input
              type="email"
              className="input"
              placeholder="Email"
              name="email"
              value={formData.email}
              onChange={handleInputChange}
            />
            {/* <input
              type="text"
              className="input"
              placeholder="Username"
              name="username"
              value={formData.username}
              onChange={handleInputChange}
            />
            <input
              type="text"
              className="input"
              placeholder="Mobile Number"
              name="mobileNumber"
              value={formData.mobileNumber}
              onChange={handleInputChange}
            /> */}
            <input
              type="password"
              className="input"
              placeholder="Password"
              name="password"
              value={formData.password}
              onChange={handleInputChange}
            />
          </div>
          <button type="submit">Sign up</button>
        </form>
        <div className="form-section">
          <p>
            Have an account? <Link to="/">Log in</Link>{' '}
          </p>
        </div>
      </div>
      <ToastContainer />
    </div>
    </>
  );
}

export default Signup;
