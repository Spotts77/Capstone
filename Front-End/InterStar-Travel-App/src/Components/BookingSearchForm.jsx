import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './BookingFormStyle.css';
import BookingCard from './BookingCard'; // Import the BookingCard component

function BookingSearchForm() {
  const [bookingId, setBookingId] = useState('');
  const [loading, setLoading] = useState(false);
  const [bookings, setBookings] = useState([]); // State to store fetched booking data
  const navigate = useNavigate();

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);

    try {
      const response = await fetch(`http://localhost:8080/api/booking/${bookingId}`);
      const data = await response.json();

      // If bookings are found, store them in the state
      if (data) {
        setBookings([data]); // Assuming the response is a single booking object
      } else {
        setBookings([]); // Clear bookings if not found
        alert('Booking not found!');
      }
    } catch (error) {
      console.error('Error fetching booking data:', error);
      alert('Error fetching booking data');
    } finally {
      setLoading(false);
    }
  };

  return (
    <>
    <div className='background'>
      {/* Info Panel */}
      <div className="info-panel">
        <h2>Embark on Your Galactic Adventure</h2>
        <p className="info-panel-text-booking">
          Intergalactic travel just took a giant leap forward. With the latest advancements in spacecraft technology, you now have the power to traverse the stars at unprecedented speeds. Thanks to your interstellar credits, the entire cosmos is within your reach. The only question now is: which spacecraft will you take on your next epic voyage? The galaxy is waiting for you.
        </p>
        <button className="info-panel-button-booking">
          <img src="./src/assets/binocular.png" alt="view icon" className="view-icon" />
          View Spacecraft
        </button>
      </div>

      <div className="booking-search-form-container">
        <div className="solid-cover">
          <h2 id="form-title">
            <img src="./src/assets/rocket.png" alt="rocket icon" className="title-icon" />
            Find Your Booking
          </h2>
          <form onSubmit={handleSubmit} className="booking-search-form">
            <div className="form-floating">
              <input
                type="number"
                id="bookingId"
                className="form-control"
                placeholder="Booking ID"
                value={bookingId}
                onChange={(e) => setBookingId(e.target.value)}
                required
              />
              <label htmlFor="bookingId" id="form-select-label-booking">Booking ID:</label>
            </div>

            <button type="submit" disabled={loading} id="search-button">
              <img src="./src/assets/search.png" alt="search icon" className="search-icon" />
              {loading ? 'Loading...' : 'Search Booking'}
            </button>
          </form>
        </div>
      </div>

      {/* Display Booking Cards below the search button */}
      <div className="booking-cards-container">
        {bookings.length > 0 ? (
          bookings.map((booking) => (
            <BookingCard key={booking.bookingId} booking={booking} />
          ))
        ) : (
          <p>No bookings found or search again!</p>
        )}
      </div>
      </div>
    </>
  );
}

export default BookingSearchForm;