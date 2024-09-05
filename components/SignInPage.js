import React from 'react';
import Navbar from './Navbar';
import SignIn from './SignIn';

const SignInPage = () => {
  return (
    <div>
      <Navbar />
      <div className="container mt-5">
        <SignIn />
      </div>
    </div>
  );
};

export default SignInPage;
