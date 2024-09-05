import React from 'react';
import Navbar from './Navbar';
import SignUp from './SignUp';

const SignUpPage = () => {
  return (
    <div>
      <Navbar />
      <div className="container mt-5">
        <SignUp />
      </div>
    </div>
  );
};

export default SignUpPage;
