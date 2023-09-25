// ContactUs.js

import React from 'react';
import '../Assets/css/ContactUs.css';

const ContactUs = () => {
  return (
    <div className="contact-us">
      <h2>Contact Us</h2>
      <div className="contact-info">
        <p>
          For inquiries or assistance, please contact us using the information below:
        </p>
        <ul>
          <li>Email: contact@yourblooddonationwebsite.com</li>
          <li>Phone: +91 9447538680</li>
          <li>Address: Arivozhi Nagar,Kovaipudur,Coimbatore,Tamil Nadu</li>
        </ul>
      </div>
      <div className="contact-form">
        {/* Add your contact form component here */}
      </div>
    </div>
  );
};

export default ContactUs;