import React, { useEffect, useState } from 'react';
import config from '../config';

const UserList = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        fetch(`${config.API_BASE_URL}/user-service/api/users`)
            .then(response => response.json())
            .then(data => setUsers(data))
            .catch(error => console.error('Error fetching users:', error));
    }, []);

    return (
        <div>
            <h2>User List</h2>
            <ul>
                {users.map(user => (
                    <li key={user.id}>{user.userName} - {user.email}</li>
                ))}
            </ul>
        </div>
    );
};

export default UserList;
