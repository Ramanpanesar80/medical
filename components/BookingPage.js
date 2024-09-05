import React, { useEffect } from 'react';
import Navbar from './Navbar';
import AppointmentForm from './AppointmentForm';

const BookingPage = () => {
  useEffect(() => {
    document.title = 'Book an Appointment';
  }, []);

  return (
    <div>
      <Navbar />
      <div className="container mt-4">
        <h1>Book Your Appointment</h1>
        <AppointmentForm />
      </div>
    </div>
  );
};

export default BookingPage;
