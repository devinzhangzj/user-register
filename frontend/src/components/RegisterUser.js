import React, { useState } from 'react';
import config from '../config';

const RegisterUser = () => {
    const [user, setUser] = useState({
        userName: '',
        email: '',
        password: ''
    });
    const [message, setMessage] = useState('');
    const [isSubmitting, setIsSubmitting] = useState(false); // Added state for submission status

    const handleChange = (e) => {
        const { name, value } = e.target;
        setUser({ ...user, [name]: value });
    };

    const handleSubmit = async (e) => { // Changed to async function
        e.preventDefault();
        setIsSubmitting(true); // Set submitting status
        try {
            const response = await fetch(`${config.API_BASE_URL}/user-service/api/users/register`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            });

            if (!response.ok) {
                const error = await response.json();
                throw new Error(error.message);
            }

            const data = await response.json();
            setMessage('User registered successfully!');
            setUser({ userName: '', email: '', password: '' });
        } catch (error) {
            setMessage(error.message);
        } finally {
            setIsSubmitting(false); // Reset submitting status
        }
    };

    return (
        <div>
            <h2>Register User</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>User Name:</label>
                    <input type="text" name="userName" value={user.userName} onChange={handleChange} required disabled={isSubmitting} /> {/* Disable input when submitting */}
                </div>
                <div>
                    <label>Email:</label>
                    <input type="email" name="email" value={user.email} onChange={handleChange} required disabled={isSubmitting} /> {/* Disable input when submitting */}
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" name="password" value={user.password} onChange={handleChange} required disabled={isSubmitting} /> {/* Disable input when submitting */}
                </div>
                <button type="submit" disabled={isSubmitting}> {/* Disable button when submitting */}
                    {isSubmitting ? 'Registering...' : 'Register'} {/* Show loading text when submitting */}
                </button>
            </form>
            {message && <p>{message}</p>}
        </div>
    );
};

export default RegisterUser;
