import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import "./FlightFormStyle.css";

function FlightSearchForm() {
  const [departureLocation, setDepartureLocation] = useState('');
  const [destination, setDestination] = useState('');
  const [departureDate, setDepartureDate] = useState('');
  const [passengerCount, setPassengerCount] = useState(1);
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);

    try {
      const response = await fetch(
        `https://api.example.com/flights?departure=${departureLocation}&destination=${destination}&departureDate=${departureDate}`
      );
      const data = await response.json();

      // Redirect to results page and pass the flight data as state
      navigate('/flightList', { state: { flights: data } });
    } catch (error) {
      console.error('Error fetching flight data:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <>
    {/* Info Panel */}
    <div className="info-panel">
      <h2>
        Discover Your Future in Space
      </h2>
      <p className='info-panel-text'>
      Exoplanetary adventures just became a reality. From now on, you can use your cosmic credits to explore every exoplanet in the galaxy, offering you infinite possibilities and unparalleled flexibility in planning your interstellar journey. The only thing left to decide is which distant world you'll explore next.
      </p>
      <button className="info-panel-button">
        <img src="./src/assets/binocular.png" alt="view icon" className="view-icon"/>
        View Destinations
        </button>
    </div>

    <div className="flight-search-form-container">
      <div className='solid-cover'>
      <h2 id="form-title"> 
        <img src="./src/assets/rocket.png" alt="rocket icon" className="title-icon"/>
        Find Your Next Flight
        </h2>
      <form onSubmit={handleSubmit} className="flight-search-form">
      <div className="form-floating">
  <select
    id="floatingDeparture"
    className="form-select"
    value={departureLocation}
    onChange={(e) => setDepartureLocation(e.target.value)}
    required
  >
    <option selected>Flying From:</option>
    <option value="New York">New York</option>
    <option value="Los Angeles">Los Angeles</option>
    <option value="Chicago">Chicago</option>
    <option value="Miami">Miami</option>
    <option value="San Francisco">San Francisco</option>
    {/* Add more options as needed */}
  </select>
  <label htmlFor="floatingDeparture">Departure Location:</label>
</div>

<div className="form-floating">
  
  <select
    id="floatingDestination"
    className="form-select"
    value={destination}
    onChange={(e) => setDestination(e.target.value)}
    required
  >
    <option value="">Flying To:</option>
    <option value="London">London</option>
    <option value="Paris">Paris</option>
    <option value="Tokyo">Tokyo</option>
    <option value="Sydney">Sydney</option>
    <option value="Dubai">Dubai</option>
    {/* Add more options as needed */}
  </select>
  <label htmlFor="floatingDestination">Destination:</label>
</div>
        <div className="form-floating">
          <input
            type="date"
            id="floatingDate"
            className='form-control'
            placeholder='Departure Date'
            value={departureDate}
            onChange={(e) => setDepartureDate(e.target.value)}
            required
          />
          <label htmlFor="floatingDate">Departure Date:</label>
        </div>
        <div className="form-floating">
          <input
            type="number"
            id="floatingPassengerCount"
            className='form-control'
            placeholder='Number of Tickets'
            min="1"
            value={passengerCount}
            onChange={(e) => setPassengerCount(e.target.value)}
            required
          />
          <label htmlFor="floatingPassengerCount">Tickets:</label>
        </div>
        <button type="submit" disabled={loading}>
          <img src="./src/assets/search.png" alt="search icon" className="search-icon"/>
          {loading ? 'Loading...' : 'Search Flights'}
        </button>
      </form>
      </div>
    </div>
    </>
  );
}

export default FlightSearchForm;