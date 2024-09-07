import React from 'react';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import AdminPanel from './components/AdminPanel'; 
import BookingPage from './components/BookingPage';
import Home from './components/Home';
import Navbar from './components/Navbar';
import SignInPage from './components/SignInPage';
import SignUpPage from './components/SignUpPage';

const NotFound = () => <h2>404 - Page Not Found</h2>;

const App = () => {
  return (
    <Router>
      <Navbar />
      <div className="container mt-5">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/signin" element={<SignInPage />} />
          <Route path="/signup" element={<SignUpPage />} />
          <Route path="/book" element={<BookingPage />} />
          <Route path="/admin" element={<AdminPanel />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
