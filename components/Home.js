import React from 'react';
import { useNavigate } from 'react-router-dom';
import Navbar from './Navbar';

const Home = () => {
  const navigate = useNavigate();

  const handleBookAppointment = () => {
    navigate('/book'); // This redirects to the "Book Appointment" page
  };

  return (
    <div>
      <Navbar />
      <div className="container text-center mt-5">
        <h1>Welcome to the Medical Appointment Booking System</h1>
        <p className="lead mt-3">
          Easily book your medical appointments online with our user-friendly system.
        </p>
        <button className="btn btn-primary mt-4" onClick={handleBookAppointment}>
          Book an Appointment
        </button>
      </div>
    </div>
  );
};

export default Home;
