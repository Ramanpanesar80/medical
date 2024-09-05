import React, { useState } from 'react';

const SignUp = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    setLoading(true);
    setError('');

    // Basic validation
    if (!/\S+@\S+\.\S+/.test(email)) {
      setError('Please enter a valid email address.');
      setLoading(false);
      return;
    }

    if (password.length < 8) {
      setError('Password must be at least 8 characters long.');
      setLoading(false);
      return;
    }

    // Simulate sign-up logic (replace with actual API call)
    setTimeout(() => {
      setLoading(false);
      console.log('Registered with:', email, password);
      // Redirect to sign-in page or another page
    }, 1000);
  };

  return (
    <form onSubmit={handleSubmit} className="signup-form">
      <h2>Sign Up</h2>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      <input
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder="Email"
        required
      />
      <input
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        placeholder="Password"
        required
      />
      <button type="submit" disabled={loading}>
        {loading ? 'Signing Up...' : 'Sign Up'}
      </button>
    </form>
  );
};

export default SignUp;
