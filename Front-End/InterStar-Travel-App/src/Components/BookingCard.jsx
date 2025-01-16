import React, { useState, useEffect } from 'react';
import './BookingCard.css';

// The card component that maps the booking data to a display card
function BookingCard({ booking }) {
  const [user, setUser] = useState(null);
  const [flight, setFlight] = useState(null);

  // Fetch User Data based on userId
  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const response = await fetch(`http://localhost:8080/api/user/${booking.userId}`);
        const data = await response.json();
        setUser(data); 
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };

    const fetchFlightData = async () => {
      try {
        const response = await fetch(`http://localhost:8080/api/flight/${booking.flightId}`);
        const data = await response.json();
        setFlight(data); // Set the flight data from API
      } catch (error) {
        console.error('Error fetching flight data:', error);
      }
    };

    fetchUserData();
    fetchFlightData();
  }, [booking.userId, booking.flightId]);

  if (!user || !flight) {
    return <p>Loading booking details...</p>; // Optional loading state
  }

  return (
    <div className="booking-card">
      <div className="booking-card-body">
        <h3 className="booking-card-title">Booking Details</h3>

        <div className="booking-details">
          <div className="booking-detail">
            <h5><strong>Booking ID:</strong></h5>
            <p>{booking.bookingId}</p>
          </div>

          <div className="booking-detail">
            <h5><strong>Booking Date:</strong></h5>
            <p>{booking.bookingDate}</p>
          </div>

          <div className="booking-detail">
            <h5><strong>Status:</strong></h5>
            <p>{booking.bookingStatus}</p>
          </div>

          <div className="booking-detail">
            <h5><strong>Ticket Number:</strong></h5>
            <p>{booking.ticketNumber}</p>
          </div>

          <div className="booking-detail">
            <h5><strong>Total:</strong></h5>
            <p>${booking.total.toFixed(2)}</p>
          </div>

          <div className="booking-detail">
            <h5><strong>Passenger Name:</strong></h5>
            <p>{user.firstName} {user.lastName}</p>
          </div>

          <div className="booking-detail">
            <h5><strong>Flight Name:</strong></h5>
            <p>{flight.flightName}</p>
          </div>
        </div>

        <button className="cancel-booking-button">Cancel</button>
      </div>
    </div>
  );
}

export default BookingCard;