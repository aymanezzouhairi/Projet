import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './RequestForm.css';

const RequestForm = () => {
    const [titreDemande, setTitreDemande] = useState('');
    const [description, setDescription] = useState('');
    const [montant, setMontant] = useState('');
    const [types, setTypes] = useState([]);
    const [articles, setArticles] = useState([]);
    const [selectedType, setSelectedType] = useState('');
    const [filteredArticles, setFilteredArticles] = useState([]);
    const [selectedArticles, setSelectedArticles] = useState([]);

    // Fetch types of articles
    useEffect(() => {
        const fetchTypes = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/demandes/types');
                setTypes(response.data);
            } catch (err) {
                console.error('Erreur lors de la récupération des types d\'articles', err);
            }
        };

        fetchTypes();
    }, []);

    // Fetch all articles
    useEffect(() => {
        const fetchArticles = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/articles/all');
                setArticles(response.data);
            } catch (err) {
                console.error('Erreur lors de la récupération des articles', err);
            }
        };

        fetchArticles();
    }, []);

    // Filter articles based on selected type
    useEffect(() => {
        if (selectedType) {
            setFilteredArticles(articles.filter(article => article.typeArticle.id === parseInt(selectedType)));
        } else {
            setFilteredArticles(articles);
        }
    }, [selectedType, articles]);

    // Handle form submission
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/demandes/add', {
                titreDemande,
                description,
                montant,
                articleIds: selectedArticles,
                typeArticleId: selectedType
            });
            if (response.status === 201) {
                alert('Demande ajoutée avec succès');
                setTitreDemande('');
                setDescription('');
                setMontant('');
                setSelectedArticles([]);
                setSelectedType('');
            }
        } catch (err) {
            console.error('Erreur lors de l\'ajout de la demande', err.response?.data || err);
            alert('Erreur lors de l\'ajout de la demande');
        }
    };

    return (
        <div className="request-form">
            <h2>Ajouter une demande d'achat</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Titre de la demande:</label>
                    <input
                        type="text"
                        value={titreDemande}
                        onChange={(e) => setTitreDemande(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Description:</label>
                    <textarea
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Montant:</label>
                    <input
                        type="number"
                        value={montant}
                        onChange={(e) => setMontant(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Type d'article:</label>
                    <select
                        value={selectedType}
                        onChange={(e) => setSelectedType(e.target.value)}
                        required
                    >
                        <option value="">Sélectionnez un type</option>
                        {types.map((type) => (
                            <option key={type.id} value={type.id}>{type.nom}</option>
                        ))}
                    </select>
                </div>
                <div className="form-group">
                    <label>Articles:</label>
                    <select
                        multiple
                        value={selectedArticles}
                        onChange={(e) => setSelectedArticles([...e.target.selectedOptions].map(option => option.value))}
                        required
                    >
                        {filteredArticles.map((article) => (
                            <option key={article.id} value={article.id}>{article.nom}</option>
                        ))}
                    </select>
                </div>
                <button type="submit">Ajouter la demande</button>
            </form>
        </div>
    );
};

export default RequestForm;
