drop database if exists interstar_travel;
create database interstar_travel;
use interstar_travel;

create table destination (
destination_id int primary key auto_increment, 
destination_name varchar(50) not null, 
destination_description varchar(250) not null, 
image_url varchar(400) not null
);

create table passenger (
passenger_id int primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(25) not null, 
phone_number varchar(25) not null 
);

create table spaceline(
spaceline_id int primary key auto_increment, 
spaceline_name varchar(50) not null, 
contact_number varchar(50) not null, 
founded_year varchar(25) not null, 
fleet_size int not null
);

create table spaceport(
spaceport_id int primary key auto_increment, 
spaceport_name varchar(50) not null, 
contact_number varchar(50) not null,
facilities varchar(250) not null,
year_established varchar(25) not null,
destination_id int not null,
constraint fk_destination_id 
	foreign key (destination_id)
	references destination(destination_id)
);

create table spacecraft (
spacecraft_id int primary key auto_increment,
spaceCraft_name varchar(50) not null,
max_passengers int not null,
max_payload varchar(25) not null,
stages int not null,
spacecraft_status varchar (25) not null,
specific_impulse varchar(25) not null, 
spaceline_id int not null,
constraint fk_spaceline_id
	foreign key (spaceline_id)
	references spaceline(spaceline_id)
);

create table flight (
flight_id int primary key auto_increment, 
flight_name varchar(50) not null, 
departure_time time not null,
departure_date date not null, 
arrival_time time not null,
price_per_ticket decimal not null,
departure_port_id int not null,
arrival_port_id int not null,
spacecraft_id int not null,
constraint fk_departure_port_id
	foreign key (departure_port_id) 
	references spaceport(spaceport_id),
constraint fk_arrival_port_id
	foreign key (arrival_port_id) 
	references spaceport(spaceport_id), 
constraint fk_spacecraft_id
	foreign key (spacecraft_id) 
	references spacecraft(spacecraft_id)
);

create table booking (
booking_id int primary key auto_increment, 
booking_date date not null, 
booking_status varchar(50) not null, 
ticket_num int not null,
total decimal not null,
passenger_id int not null, 
flight_id int not null, 
constraint fk_passenger_id 
	foreign key (passenger_id) 
	references passenger(passenger_id), 
constraint fk_flight_id
	foreign key (flight_id) 
	references flight(flight_id)
);

insert into destination (destination_name, destination_description, image_url) values
('Low Earth Orbit', 'Low Earth Orbit (LEO) refers to an orbit around Earth that is located approximately 100 to 1,200 miles (160 to 2,000 kilometers) above the planets surface.', 'src/assets/destinationsImages/low-earth-orbit.jpg'),
('Lunar Gateway', 'A Space station in high Lunar orbit usually oberating as a transfer station between the lunar surface and mars.', 'src/assets/destinationsImages/lunar-gateway.jpg'),
('Artemis Base', 'A fully sustainable colony located on the Lunar surface. The Artemis Base Camp will be a permanent outpost at the lunar south pole in or around the Shackleton Crater.', 'src/assets/destinationsImages/artemis-base.png'),
('Mars Base One', 'A fully sustainable colony located on the Martian surface', 'src/assets/destinationsImages/mars-base.jpg'),
('Mars Station', 'Mars Station is a space station located in low martian orbit', 'src/assets/destinationsImages/mars-station.jpg');

insert into  spaceline (spaceline_name, contact_number, founded_year, fleet_size) values
('SpaceX', '1-800-test','2026', 200), 
('Boeing', '1-700-test','2016', 100),
('NASA', '1-900-test', '1960', 100),
('Sierra Space', '1-600-test','2021', 50);

insert into spacecraft (spacecraft_name, max_passengers, max_payload, stages, spacecraft_status, specific_impulse, spaceline_id) values
('Falcon-9 BL1', 6, '200kg', 2, 'Ready for Flight', '200kn', 1), 
('New Glenn NG1', 10, '500kg', 2, 'Preparing for Flight','300kn', 2),
('Falcon-9 BL2', 6, '200kg', 2, 'Ready for Flight', '200kn', 1), 
('Falcon-9 BL3', 6, '200kg', 2, 'Ready for Flight', '200kn', 1), 
('New Glenn NG3', 10, '500kg', 2, 'Preparing for Flight','300kn', 2),
('Artemis BL1', 4, '200kg', 3, 'Ready for Flight', '200kn', 3),
('Artemis BL2', 4, '200kg', 3, 'Ready for Flight', '200kn', 3),
('Artemis BL3', 4, '200kg', 3, 'Ready for Flight', '200kn', 3),
('Artemis BL4', 4, '200kg', 3, 'Ready for Flight', '200kn', 3),
('Dream Chaser BL1', 6, '200kg', 2, 'Ready for Flight', '100kn', 4),
('Dream Chaser BL2', 6, '200kg', 2, 'Ready for Flight', '100kn', 4),
('Dream Chaser BL3', 6, '200kg', 2, 'Ready for Flight', '100kn', 4),
('Dream Chaser BL4', 6, '200kg', 2, 'Ready for Flight', '100kn', 4),
('New Glenn NG2', 10, '500kg', 2, 'Preparing for Flight','300kn', 2);

insert into spaceport (spaceport_name, contact_number, facilities, year_established, destination_id) values
('Orbital Reef', '1-700-test', 'Re-Fueling, Docking, public Transit, Storage', '2025', 1),
('International Space Station', '1-600-test', 'Re-Fueling, Docking, public Transit, Storage', '2030', 1),
('Lunar Gateway', '1-900-test', 'Re-Fueling, Docking, public Transit, Storage', '2025', 2),
('Mars Station', '1-400-test', 'Re-Fueling, Docking, public Transit, Storage', '2016', 5),
('Mars Base One', '1-900-test', 'Re-Fueling, Docking, public Transit, Storage', '2021', 4),
('Artemis Base', '1-800-test', 'Re-Fueling, Docking, public Transit, Storage', '2023', 3);

insert into flight (flight_name, departure_time, departure_date, arrival_time, price_per_ticket, 
departure_port_id, arrival_port_id, spacecraft_id) values
('Orbital Reef to Lunar Gateway', '10:30:00', '2025-02-10', '22:10:00', 600.00, 1, 3, 1), 
('Orbital Reef to Lunar Gateway', '07:30:00', '2025-02-10', '18:10:00', 800.00, 1, 3, 6), 
('Orbital Reef to Lunar Gateway', '22:10:00', '2025-02-10', '10:30:00', 1000.00, 1, 3, 2),
('International Space Station to Mars Station', '07:30:00', '2025-02-18', '18:10:00', 2000.00, 3, 4, 7),
('Mars Station to Mars Base One', '07:30:00', '2025-02-17', '18:10:00', 800.00, 4, 5, 9),  
('Lunar Gateway to Artemis Base', '09:30:00', '2025-02-13', '19:10:00', 400.00, 3, 6, 3);

INSERT INTO passenger (first_name, last_name, email, phone_number) 
values
('John', 'Doe', 'john.doe@example.com', '123-456-7890'),
('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210');

