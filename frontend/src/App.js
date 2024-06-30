import React, { useState, useEffect } from 'react';
import RegisterUser from './components/RegisterUser';
import UserList from './components/UserList';

const App = () => {
    const [users, setUsers] = useState([]);
    const [message, setMessage] = useState('');

    // Function to fetch users from the API
    const fetchUsers = () => {
        fetch('/user-service/api/users')
            .then(response => response.json())
            .then(data => setUsers(data))
            .catch(error => console.error('Error fetching users:', error));
    };

    useEffect(() => {
        fetchUsers();
    }, []);

    // Function to add a new user to the state and refresh the user list
    const addUser = (user) => {
        setUsers([...users, user]);
        fetchUsers(); // Re-fetch users to refresh the list
    };

    // Function to display a message for a set duration
    const displayMessage = (msg) => {
        setMessage(msg);
        setTimeout(() => setMessage(''), 3000);
    };

    return (
        <div>
            <h1>User Service Frontend</h1>
            {message && <p>{message}</p>}
            <RegisterUser addUser={addUser} displayMessage={displayMessage} />
            <UserList users={users} />
        </div>
    );
};

export default App;
