import React, { useState, useEffect } from 'react';
import { db } from './firebase'; // Import Firestore instance
import { collection, getDocs } from 'firebase/firestore'; // For fetching data from Firestore

const AdminPanel = () => {
  const [appointments, setAppointments] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  // Function to fetch appointments from Firestore
  const fetchAppointments = async () => {
    try {
      const querySnapshot = await getDocs(collection(db, 'appointments'));
      const appointmentsList = querySnapshot.docs.map((doc) => ({
        id: doc.id,
        ...doc.data(),
      }));
      setAppointments(appointmentsList);
      setLoading(false);
    } catch (err) {
      setError('Failed to fetch appointments');
      setLoading(false);
    }
  };

  // Fetch appointments on component mount
  useEffect(() => {
    fetchAppointments();
  }, []);

  return (
    <div className="container mt-5">
      <h2>Doctor's Admin Panel</h2>
      {loading ? (
        <p>Loading appointments...</p>
      ) : error ? (
        <p style={{ color: 'red' }}>{error}</p>
      ) : (
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>Date</th>
              <th>Time</th>
              <th>Doctor</th>
              <th>Booked At</th>
            </tr>
          </thead>
          <tbody>
            {appointments.map((appointment) => (
              <tr key={appointment.id}>
                <td>{appointment.date}</td>
                <td>{appointment.time}</td>
                <td>{appointment.doctor}</td>
                <td>{new Date(appointment.createdAt.seconds * 1000).toLocaleString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default AdminPanel;
