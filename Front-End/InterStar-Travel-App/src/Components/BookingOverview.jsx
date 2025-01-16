import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom'; // Use useNavigate instead of useHistory
import './BookingOverview.css';

function BookingOverview() {
  const location = useLocation();
  const navigate = useNavigate(); // Initialize useNavigate

  // Get the flight data passed from the previous page
  const [flight, setFlight] = useState(location.state ? location.state.flight : null);
  const [ticketNumber, setTicketNumber] = useState(location.state ? location.state.ticketNumber : null);

  // User form state
  const [user, setUser] = useState({
    firstName: '',
    lastName: '',
    email: '',
    phoneNumber: '',
  });

  const [error, setError] = useState('');
  const [booking, setBooking] = useState(null);


  useEffect(() => {
    if (!flight) {
      alert('No flight selected. Redirecting...');
      navigate('/flights'); 
    }
  }, [flight, navigate]);


  const handleChange = (e) => {
    const { name, value } = e.target;
    setUser({ ...user, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();


    if (!user.firstName || !user.lastName || !user.email || !user.phoneNumber) {
      setError('Please fill out all fields.');
      console.log('Error: Please fill out all fields.');
      return;
    }

    try {
 
      console.log('Sending user data to backend...');
      const userResponse = await fetch('http://localhost:8080/api/user/make/users', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(user),
      });

      const userData = await userResponse.json();
      console.log('User response:', userData);

      if (!userResponse.ok) {
   
        setError(userData.message || 'Failed to create user.');
        console.error('Failed to create user:', userData);
        return;
      }

      const createdUser = userData.payload ? userData.payload : userData; 
      console.log('Created user:', createdUser);

    
      const newBooking = {
        bookingDate: new Date().toISOString().split('T')[0], 
        bookingStatus: 'Booked', 
        ticketNumber: ticketNumber, 
        total: flight.pricePerTicket,
        userId: createdUser.userId, 
        flightId: flight.flightId, 
      };

      console.log('Sending booking data to backend:', newBooking);
      // Send the booking data to the backend
      const bookingResponse = await fetch('http://localhost:8080/api/booking/make/booking', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(newBooking),
      });

      const bookingData = await bookingResponse.json();
      console.log('Booking response:', bookingData);

      if (!bookingResponse.ok) {
        const errorText = await bookingResponse.text(); // Get the raw response text
        console.error('Error response text:', errorText);
        throw new Error(`Failed to create booking: ${errorText}`);
      }

      // Set the booking confirmation
      setBooking(bookingData); // Use the booking data received from the backend
      setError('');
      console.log('Booking created:', bookingData);
    } catch (err) {
      setError('Failed to create booking. Please try again.');
      console.error('Error in booking creation:', err);
    }
  };

  return (
    <div className='background'>
    <div className="booking-overview">
      <h1>Booking Overview</h1>
      
      {/* Display flight details if available */}
      {flight ? (
        <div className="flight-details">
          <h3 id="flight-overview-title">Flight: {flight.flightName}</h3>
          <p id="flight-overview-subtitle"><strong>Departure Time:</strong> {flight.departureTime}</p>
          <p id="flight-overview-subtitle"><strong>Arrival Time:</strong> {flight.arrivalTime}</p>
          <p id="flight-overview-subtitle"><strong>Price Per Ticket:</strong> ${flight.pricePerTicket.toFixed(2)}</p>
          <p id="flight-overview-subtitle"><strong>Departure Date:</strong> {flight.departureDate}</p>
          <p id="flight-overview-subtitle"><strong>Departure Port:</strong> {flight.departurePortId}</p>
          <p id="flight-overview-subtitle"><strong>Arrival Port:</strong> {flight.arrivalPortId}</p>
        </div>
      ) : (
        <p>No flight selected</p>
      )}

      {/* User details form */}
      <h2 id="user-form-title">User Details</h2>
      <form onSubmit={handleSubmit}>
        {error && <p className="error">{error}</p>}

        <div className="form-group">
          <label id="user-form-label" htmlFor="firstName">First Name</label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            value={user.firstName}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label id="user-form-label" htmlFor="lastName">Last Name</label>
          <input
            type="text"
            id="lastName"
            name="lastName"
            value={user.lastName}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label id="user-form-label" htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            value={user.email}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label id="user-form-label" htmlFor="phoneNumber">Phone Number</label>
          <input
            type="text"
            id="phoneNumber"
            name="phoneNumber"
            value={user.phoneNumber}
            onChange={handleChange}
            required
          />
        </div>

        <button type="submit">Confirm Booking</button>
      </form>

      {/* Display booking confirmation */}
      {booking && (
        <div className="booking-confirmation">
          <h3>Booking Confirmed!</h3>
          <p><strong>Booking ID:</strong> {booking.bookingId}</p>
          <p><strong>Booking Date:</strong> {booking.bookingDate}</p>
          <p><strong>Ticket Number:</strong> {booking.ticketNumber}</p>
          <p><strong>Total:</strong> ${booking.total.toFixed(2)}</p>
        </div>
      )}
    </div>
    </div>
  );
}

export default BookingOverview;