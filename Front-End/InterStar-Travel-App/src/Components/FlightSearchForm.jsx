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

  const handleClick = () => {
    navigate('/DestinationList');
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);

    try {
      const response = await fetch(
        `http://localhost:8080/api/flight/search/${departureLocation}/${destination}/${departureDate}`
      );
      const data = await response.json();

      if (data && data.length > 0) {
      
        const ticketNumber = passengerCount;
        
        // Pass both flights data and the ticketNumber to the next page
        navigate('/flightList', { state: { flights: data, ticketNumber: ticketNumber } });
      } else {
        console.error('No flights found');
      }
    } catch (error) {
      console.error('Error fetching flight data:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <>
      <div className='background'>
        {/* Info Panel */}
        <div className="info-panel">
          <h2>Discover Your Future in Space</h2>
          <p className='info-panel-text'>
            Exoplanetary adventures just became a reality. From now on, you can use your cosmic credits to explore every exoplanet in the galaxy, offering you infinite possibilities and unparalleled flexibility in planning your interstellar journey. The only thing left to decide is which distant world you'll explore next.
          </p>
          <button className="info-panel-button" onClick={handleClick}>
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
                  <option value="Orbital Reef">Orbital Reef</option>
                  <option value="International Space Station">ISS</option>
                  <option value="Lunar Gateway">Lunar Gateway</option>
                  <option value="Mars Station">Mars Station</option>
                  <option value="Mars Base One">Mars Base One</option>
                  <option value="Artemis Base">Artemis Base</option>
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
                  <option value="Orbital Reef">Orbital Reef</option>
                  <option value="International Space Station">ISS</option>
                  <option value="Lunar Gateway">Lunar Gateway</option>
                  <option value="Mars Station">Mars Station</option>
                  <option value="Mars Base One">Mars Base One</option>
                  <option value="Artemis Base">Artemis Base</option>
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
                <label htmlFor="floatingDate" id="form-select-label">Departure Date:</label>
              </div>

              <div className="form-floating">
                <input
                  type="number"
                  id="floatingPassengerCount"
                  className='form-control'
                  min="1"
                  value={passengerCount}
                  onChange={(e) => setPassengerCount(e.target.value)}
                  required
                />
                <label htmlFor="floatingPassengerCount" id="form-select-label">Tickets:</label>
              </div>

              <button type="submit" disabled={loading} id="search-button">
                <img src="./src/assets/search.png" alt="search icon" className="search-icon"/>
                {loading ? 'Loading...' : 'Search Flights'}
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}

export default FlightSearchForm;