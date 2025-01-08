# Planning Doc
## Day 1 01/06/25
### Checklist
1. planning
    1. plan out the database schema and relationship mapping 
        - what tables are to be added (1hr) (done)
        - what relationshipos do they have to each other (30min) (done)
    2. Back-end methods needed 
        - what models need to be created (20 min) (done)
        - what fields need to be created for each model (1hr) (Done)
        - what methods do each model need to map to database (1.5hr) (in progress)
## Day 2 01/07/25
### Checklist
1. planning
    1. Back-end methods needed 
        - what methods do each model need to map to database (1.5hr) (if needed)
    2. Database implementation 
        - creation of tables and databases (production and test) (2hr)
    3. Data Layer implementation. Breakdown of tasks/ Stories to be found on Capstone Specific file.
2. Front-end implementation
    - creation of landing page (done)
    - creation of navigation bar (mostly done with tweaks)
    - creation of error page (needs styling)
    - creation of app router (done, updated as more pages come online)
## Day 3 01/08/25
### Checklist
1. Front-end implementation
    - finalization of landing page (done)(2hr)
    - finalization of nav bar (in progress)(1hr)
    - creation of user sign up form (1.5hr)
        - needs fetch commands to link to back end
        - will serve as a design template until back-end work
    - creation of available flight search page (2hr)
        - needs fetch commands to link to back end
        - will serve as a design template until back-end work
    - creation of list of available flight's page
        - this will be initial look/ design without functionality
    - Flight booking form page(2hr)
        - intial design
        - will require fetch/ mapping to back-end to work
## Day 4 01/09/25
### Checklist
1. finalization of initial front-end work
2. beginning of back-end implementation
    1. database and model creation
        - creation of Space line table in database (30min)
        - creation of Space craft table in database (30min)
        - creation of Destination table in database (30min)
        - creation of Space Port table in database (30min)
        - creation of Flight table in database (30min)
        - creation of User table in database (30min)
        - creation of Booking table in database (30min)

        - creation of Spaceline model (30min)
            #### Fields
            - spaceline_id
            - spaceline_name
            - contact_number
            - founded_year
            - fleet_size
        - creation of Spacecraft model (30min)
            #### Fields
            - spacecraft_id
            - spacecraft_name
            - max_passengers
            - max_payload
            - stages
            - engines
            - spaceline_id FK
            - status
            - specific_impulses
        - creation of Destination model(30min)
            #### Fields
            - destination_id 
            - destination_name
            - description
            - category
            - image_url
        - creation of Space Port model(30min)
            #### Fields
            - spaceport_id 
            - port_name
            - contact_number
            - facilities
            - location
            - year_established
            - destination_id FK
        - creation of Flight model (30min)
            #### Fields
            - flight_id
            - flight_name
            - departure_time
            - arrival_time
            - departure_port_id FK
            - arrival_port_id FK
            - spacecraft_id FK
            - price
        - creation of User model (30min)
            #### Fields
            - user_id
            - first_name
            - last_name
            - email
            - phone_number
        - creation of Booking model (30min)
            #### Fields
            - booking_id
            - booking_date
            - status
            - ticket_num 
            - user_id FK
            - flight_id FK
## Day 5 01/10/25
### Checklist
1. finalization of database and models
2. Data layer implementation 
    1. implement 
## Day 6 01/13/25
### Checklist
## Day 7 01/14/25
### Checklist
## Day 8 01/15/25
### Checklist
## Day 9 01/16/25
### Checklist