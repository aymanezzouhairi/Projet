import React from 'react';
import { Link } from 'react-router-dom';
import './AdminNavbar.css';
import Logo from '../image/logo-riva.png'


const AdminNavbar = () => {

    return (
        <nav className="navbar">
            <ul>
                 <li > <img src={Logo}  alt='Logo'></img> </li>
                <li><Link to="/dashboard">Demandes</Link></li>
                <li><Link to="articles">Articles</Link></li>
                <li><Link to="/addUser">Ajouter User</Link></li>
                <li><Link to="/" onClick={() => { /* log out functionality */ }}>Logout</Link></li>
            </ul>
        </nav>
    );
};

export default AdminNavbar;
