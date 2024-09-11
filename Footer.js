import React, { useState } from 'react';
import './Footer.css';

const Footer = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    message: '',
  });
  const [formSubmitted, setFormSubmitted] = useState(false);

  const handleModalToggle = () => {
    setIsModalOpen(!isModalOpen);
    setFormSubmitted(false);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setFormSubmitted(true);
    // You can integrate form submission with a backend service or email service
    console.log('Form data:', formData);
    // Reset form after submission
    setFormData({ name: '', email: '', message: '' });
  };

  return (
    <footer className="footer">
      <div className="footer-content">
        <ul className="footer-links">
          <li><a href="/about">About Us</a></li>
          <li><a href="/privacy-policy">Privacy Policy</a></li>
          <li><button className="contact-btn" onClick={handleModalToggle}>Contact Us</button></li>
        </ul>
        <p>&copy; {new Date().getFullYear()} Medical Appointment System. All Rights Reserved.</p>
      </div>

      {/* Contact Us Modal */}
      {isModalOpen && (
        <div className="modal-overlay">
          <div className="modal">
            <button className="close-modal" onClick={handleModalToggle}>&times;</button>
            <h2>Contact Us</h2>
            {!formSubmitted ? (
              <form onSubmit={handleSubmit}>
                <div className="form-group">
                  <label htmlFor="name">Name</label>
                  <input
                    type="text"
                    id="name"
                    name="name"
                    value={formData.name}
                    onChange={handleInputChange}
                    required
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="email">Email</label>
                  <input
                    type="email"
                    id="email"
                    name="email"
                    value={formData.email}
                    onChange={handleInputChange}
                    required
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="message">Message</label>
                  <textarea
                    id="message"
                    name="message"
                    rows="4"
                    value={formData.message}
                    onChange={handleInputChange}
                    required
                  ></textarea>
                </div>
                <button type="submit" className="submit-btn">Send Message</button>
              </form>
            ) : (
              <p className="success-message">Thank you for reaching out! We will get back to you soon.</p>
            )}
          </div>
        </div>
      )}
    </footer>
  );
};

export default Footer;
