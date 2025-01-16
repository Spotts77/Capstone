import React from 'react';
import './DestinationCard.css';

// The card component that maps each destination to a display card
function DestinationCard({ destination }) {
  return (
    <div className="card">
      {/* Assuming the backend sends 'imageUrl' as the field name */}
      <img src={destination.imageUrl} alt={destination.destinationName} className="card-img-top" />
      
      <div className="card-body">
        <h3 className="card-title">{destination.destinationName}</h3>
        <p className="card-text">{destination.destinationDescription}</p>
        <button className="view-details-button">View Details</button>
      </div>
    </div>
  );
}

export default DestinationCard;