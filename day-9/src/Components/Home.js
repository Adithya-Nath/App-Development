import React from 'react';
import '../Assets/css/Home.css';
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faPhone, faMapMarker } from '@fortawesome/free-solid-svg-icons';
import { faFacebook, faTwitter, faInstagram } from '@fortawesome/free-brands-svg-icons';

import backgroundImage from '../Assets/images/image1.jpeg'; // Import your background image

function Home() {
  return (
    <div className="home-container">
      <header className="header">
        <div className="logo">
          <h1>Blood Donation App</h1>
        </div>
        <nav className="nav">
          <ul>
            <li><Link to="/dashboard">Dashboard</Link></li>
            <li><Link to="/profileDetails">Profile</Link></li>
          </ul>
        </nav>
      </header>

      <div className="poster-container">
         {/* Rest of your component */}
      </div>

      <main className="main-content">
        <h1> </h1>
     <h1 className='title_hm'>"Don't be scared; it's in your blood to save lives."</h1>
      </main>

      <footer className="footer">
        <ul>
        <li><Link  to="/Terms">Terms and Conditions</Link></li>
          <li><Link to="/PrivacyPolicy">Privacy Policy</Link></li>
          <li><Link to="/faq">FAQ</Link></li>
          <li><Link to="/ContactUs">Contact Us</Link></li>
          <div className="social-icons">
          <a href="https://www.facebook.com" target="_blank" rel="noopener noreferrer">
            <FontAwesomeIcon icon={faFacebook} className="social-icon" />
          </a>
          <a href="https://www.twitter.com" target="_blank" rel="noopener noreferrer">
            <FontAwesomeIcon icon={faTwitter} className="social-icon" />
          </a>
          <a href="https://www.instagram.com" target="_blank" rel="noopener noreferrer">
            <FontAwesomeIcon icon={faInstagram} className="social-icon" />
          </a>
        </div>
          
        </ul>
      </footer>
    </div>
  );
}

export default Home;