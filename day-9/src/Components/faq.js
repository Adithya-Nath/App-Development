import React from 'react';
import '../Assets/css/faq.css';


const FAQ = () => {
  const faqData = [
    {
      question: 'How can I donate blood?',
      answer:
        'You can donate blood by visiting our nearest blood donation center or by participating in one of our blood donation events. Check our events page for details.'
    },
    {
      question: 'Is there an age limit for blood donation?',
      answer:
        'Yes, typically, donors must be at least 17 years old to donate blood. Some locations may have different age requirements, so check with your local blood center.'
    },
    {
      question: 'How often can I donate blood?',
      answer:
        'In most cases, you can donate whole blood every 8 weeks. Platelet and plasma donations may have different time intervals. Please check with your local blood center for specific guidelines.'
    },
    // Add more FAQ items as needed
  ];

  return (
    <div className="faq">
      <h2>Frequently Asked Questions</h2>
      <ul>
        {faqData.map((item, index) => (
          <li key={index}>
            <h3>{item.question}</h3>
            <p>{item.answer}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default FAQ;