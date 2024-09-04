// src/components/UserNavbar.js
import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css'; // Assurez-vous de créer un fichier CSS pour le style
import  Logo from '../image/logo-riva.png'
const UserNavbar = () => {
    return (
        <nav className="navbar">
            <ul>
                 <li><img src={Logo} alt='Logo'/></li>
                <li><Link to="/request">Formulaire de Demande</Link></li>
                <li><Link to={"/ListDemande"}>Liste Demandes</Link></li>
                <li><Link to="/" onClick={() => { /* log out functionality */ }}>Logout</Link></li>
            </ul>
        </nav>
    );
};

export default UserNavbar;
