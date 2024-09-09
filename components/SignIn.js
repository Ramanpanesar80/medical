import React, { useState } from 'react';
import { auth } from './firebase'; // Import Firebase Auth
import { signInWithEmailAndPassword } from 'firebase/auth'; // Import necessary Firebase Auth function

const SignIn = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const handleSignIn = async (e) => {
    e.preventDefault();
    setError('');
    setSuccess('');

    try {
      const userCredential = await signInWithEmailAndPassword(auth, email, password);
      setSuccess('Signed in successfully!');
      console.log('Signed in user:', userCredential.user);
      // Optionally, redirect to a dashboard or reset form fields
      setEmail('');
      setPassword('');
    } catch (error) {
      setError(`Sign-in failed: ${error.message}`);
    }
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <h2 className="text-center mb-4">Sign In</h2>

          {/* Display error and success messages */}
          {error && <div className="alert alert-danger">{error}</div>}
          {success && <div className="alert alert-success">{success}</div>}

          <form onSubmit={handleSignIn}>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">Email</label>
              <input
                type="email"
                className="form-control"
                id="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                placeholder="Enter your email"
                required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="password" className="form-label">Password</label>
              <input
                type="password"
                className="form-control"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Enter your password"
                required
              />
            </div>
            <button type="submit" className="btn btn-primary w-100">Sign In</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default SignIn;
