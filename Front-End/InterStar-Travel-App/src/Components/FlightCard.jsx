import React from 'react';
import { useNavigate } from 'react-router-dom'; // Use useNavigate instead of useHistory
import './FlightCard.css';

// Function to format time from string (e.g., "10:30:00" -> "10:30 AM")
const formatTime = (time) => {
  const [hours, minutes] = time.split(':');
  const period = hours >= 12 ? 'PM' : 'AM';
  const formattedHours = hours > 12 ? hours - 12 : hours;
  return `${formattedHours}:${minutes} ${period}`;
};

// Function to format date from string (e.g., "2025-02-10" -> "February 10, 2025")
const formatDate = (date) => {
  const options = { year: 'numeric', month: 'long', day: 'numeric' };
  return new Date(date).toLocaleDateString(undefined, options);
};

function FlightCard({ flight, ticketNumber }) {
  const navigate = useNavigate();  // Use useNavigate

  const handleSelectFlight = () => {
    // Navigate to the booking overview page with the selected flight
    navigate('/bookingOverview', { state: { flight, ticketNumber } }); // Pass the flight data to the next page
  };

  return (
    <div className="flight-card">
      <div className="flight-card-body">
        {/* Flight Title */}
        <h3 className="flight-card-title">{flight.flightName}</h3>

        {/* Flight Details Section */}
        <div className="flight-details">
          <div className="flight-detail">
            <p id="flight-detail-title"><strong>Departure Time:</strong></p>
            <p id="flight-detail-info" >{formatTime(flight.departureTime)}</p>
          </div>

          <div className="flight-detail">
            <p id="flight-detail-title"><strong>Arrival Time:</strong></p>
            <p id="flight-detail-info" >{formatTime(flight.arrivalTime)}</p>
          </div>

          <div className="flight-detail">
            <p id="flight-detail-title"><strong>Price Per Ticket:</strong></p>
            <p id="flight-detail-info" >${flight.pricePerTicket.toFixed(2)}</p>
          </div>

          <div className="flight-detail">
            <p id="flight-detail-title" ><strong>Departure Date:</strong></p>
            <p id="flight-detail-info" >{formatDate(flight.departureDate)}</p>
          </div>

          <div className="flight-detail">
            <p id="flight-detail-title"><strong>Departure Port:</strong></p>
            <p id="flight-detail-info" >{flight.departurePortId}</p>
          </div>

          <div className="flight-detail">
            <p id="flight-detail-title" ><strong>Arrival Port:</strong></p>
            <p id="flight-detail-info">{flight.arrivalPortId}</p>
          </div>
        </div>

        {/* Button to select the flight */}
        <button className="view-details-button" onClick={handleSelectFlight}>
          Select
        </button>
      </div>
    </div>
  );
}

export default FlightCard;