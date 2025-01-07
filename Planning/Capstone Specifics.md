# Plan Specifics
## Models
1. User Model
    ### Fields
    - user_id
    - first_name
    - last_name
    - email
    - phone_number
    ### Methods (data Layer)
    - create user
    - update user
    - delete user
    ### Domain Layer
    ### Web Layer
2. Booking Model
    ### Fields
    - booking_id
    - booking_date
    - status
    - payment_status
    - ticket_num 
    - user_id FK
    - flight_id FK
    ### Methods (data Layer)
    . create booking
    . update booking 
    . delete booking 
    . findBookingByKey
    . findAllBookingByUserId
    ### Domain Layer
    ### Web Layer
3. SpaceFlight Model
    ### Fields
    - flight_id
    - flight_name
    - departure_time
    - arrival_time
    - departure_port_id FK
    - arrival_port_id FK
    - spacecraft_id FK
    - price
    ### Methods (data Layer)
    - findFlightsByKey
    ### Domain Layer
    ### Web Layer
4. SpacePort Model
    ### Fields
    - spaceport_id 
    - port_name
    - contact_number
    - facilities
    - location
    - year_established
    - destination_id FK
    ### Methods (data Layer)
    . findPortById
    . findPortByDestination
    ### Domain Layer
    ### Web Layer
5. Destination Model
    ### Fields
    - destination_id 
    - destination_name
    - description
    - category
    - image_url
    ### Methods (data Layer)
    - FindDestinationByName
    ### Domain Layer
    ### Web Layer
6. SpaceLine Model
    ### Fields
    - spaceline_id
    - spaceline_name
    - contact_number
    - founded_year
    - fleet_size
    ### Methods (data Layer)
    - findSpaceLineByName
    ### Domain Layer
    ### Web Layer
7. SpaceCraft model
    ### Fields
    - spacecraft_id
    - spacecraft_name
    - max_passengers
    - max_payload
    - stages
    - engines
    - spaceline_id FK
    - status
    - specific_impulses
    ### Methods (data Layer)
    - findSpaceCraftByName
    ### Domain Layer
    ### Web Layer