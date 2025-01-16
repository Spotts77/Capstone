import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import DestinationCard from './DestinationCard';
import './DestinationList.css';

const DestinationList = () => {
    const navigate = useNavigate();
    const [destinations, setDestinations] = useState([]);  

    useEffect(() => {
        fetch('http://localhost:8080/api/destination')
            .then(response => {
                if (response.ok) {
                    return response.json();  
                } else {
                    throw new Error('Failed to fetch destinations');
                }
            })
            .then(data => setDestinations(data))  
            .catch((error) => {
                console.error('Error fetching destinations:', error);
                navigate("/", { state: { error: error.message } });
            });
    }, []);  


    return (
        <div id="background">
        <div className='container'>
            <h1 className='destination-title'>Destinations</h1>
            {destinations.length === 0 ? (
                <div className="alert alert-warning py-4">
                    No Destinations found.<br />
                </div>
            ) : (
                <div className='row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4'  id="card-container">
                    {destinations.map(destination => (
                        <DestinationCard key={destination.destinationId} destination={destination} />
                    ))}
                </div>
            )}
        </div>
        </div>
    );
};

export default DestinationList;