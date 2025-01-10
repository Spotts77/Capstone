use interstar_travel_test;

-- findUserByEmail script -- 
select 
first_name, 
last_name, 
email, 
phone_number
from passenger
where email = "john.doe@example.com";

-- findAllDestinations script--
select 
destination_name, 
destination_description, 
image_url
from destination;

-- findFlightByKey script--
SELECT 
f.flight_id, 
f.flight_name, 
f.departure_time, 
f.arrival_time, 
f.price_per_ticket, 
dp.spaceport_name, 
ap.spaceport_name
FROM flight f
JOIN spaceport dp ON f.departure_port_id = dp.spaceport_id
JOIN spaceport ap ON f.arrival_port_id = ap.spaceport_id
WHERE dp.spaceport_name = "VST"
AND ap.spaceport_name = "MBA"
AND f.departure_date = "2025-02-10";