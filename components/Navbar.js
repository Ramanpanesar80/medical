import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css'; // Assuming you have a separate CSS file for styling

const Navbar = () => {
  return (
    <nav className="navbar">
      <ul className="navbar-list">
        <li className="navbar-item">
          <Link to="/" className="navbar-link">Home</Link>
        </li>
        <li className="navbar-item">
          <Link to="/signin" className="navbar-link">Sign In</Link>
        </li>
        <li className="navbar-item">
          <Link to="/signup" className="navbar-link">Sign Up</Link>
        </li>
        <li className="navbar-item">
          <Link to="/book" className="navbar-link">Book Appointment</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
