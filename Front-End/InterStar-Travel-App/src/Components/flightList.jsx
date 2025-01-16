import React from 'react';
import { useLocation } from 'react-router-dom';
import FlightCard from './FlightCard';
import './FlightList.css';

const FlightList = () => {
  const location = useLocation();
  const { flights, ticketNumber } = location.state || { flights: [] }; // Get flights data passed via state

  return (
  <div id="background">
    <div className='container'>
      <h1 id="flight-list-title">Available Flights</h1>
      <div className="flight-list">
        {flights.length === 0 ? (
          <p>No flights available</p>
        ) : (
          flights.map((flight) => (
            <FlightCard key={flight.flightId} flight={flight} ticketNumber={ticketNumber}/>
          ))
        )}
      </div>
    </div>
  </div>
  );
};

export default FlightList;