import React, { useState } from 'react';

const AppointmentForm = () => {
  const [date, setDate] = useState('');
  const [time, setTime] = useState('');
  const [doctor, setDoctor] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Reset previous messages
    setError('');
    setSuccess('');

    // Check if the date and time are valid
    const selectedDateTime = new Date(`${date}T${time}`);
    if (selectedDateTime <= new Date()) {
      setError('Please select a future date and time.');
      return;
    }

    setLoading(true);

    // Simulate a network request with setTimeout
    setTimeout(() => {
      setLoading(false);
      setSuccess('Appointment booked successfully!');
      console.log('Appointment booked successfully:', { date, time, doctor });

      // Optionally, reset the form fields
      setDate('');
      setTime('');
      setDoctor('');
    }, 2000); // Simulate a 2-second delay
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Book an Appointment</h2>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      {success && <p style={{ color: 'green' }}>{success}</p>}
      <input
        type="date"
        value={date}
        onChange={(e) => setDate(e.target.value)}
        required
      />
      <input
        type="time"
        value={time}
        onChange={(e) => setTime(e.target.value)}
        required
      />
      <select
        value={doctor}
        onChange={(e) => setDoctor(e.target.value)}
        required
      >
        <option value="">Select Doctor</option>
        <option value="Dr. Smith">Dr. Smith</option>
        <option value="Dr. Jones">Dr. Jones</option>
      </select>
      <button type="submit" disabled={loading}>
        {loading ? 'Booking...' : 'Book Appointment'}
      </button>
    </form>
  );
};

export default AppointmentForm;
