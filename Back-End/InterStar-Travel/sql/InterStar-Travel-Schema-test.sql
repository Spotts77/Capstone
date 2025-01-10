drop database if exists interstar_travel_test;
create database interstar_travel_test;
use interstar_travel_test;

create table destination (
destination_id int primary key auto_increment, 
destination_name varchar(50) not null, 
destination_description varchar(250) not null, 
image_url varchar(50) not null
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
departure_time varchar(25) not null,
departure_date date not null, 
arrival_time varchar(25) not null,
price_per_ticket int not null,
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
passenger_id int not null, 
flight_id int not null, 
constraint fk_passenger_id 
	foreign key (passenger_id) 
	references passenger(passenger_id), 
constraint fk_flight_id
	foreign key (flight_id) 
	references flight(flight_id)
);

INSERT INTO passenger (first_name, last_name, email, phone_number) 
values
('John', 'Doe', 'john.doe@example.com', '123-456-7890'),
('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210');

insert into destination (destination_name, destination_description, image_url) values
('Low Earth Orbit', 'Low Earth Orbit (LEO) refers to an orbit around Earth that is located approximately 100 to 1,200 miles (160 to 2,000 kilometers) above the planets surface.', 'https://www.google.com/test'),
('Earths Moon', 'The Moon is Earths only natural satellite, located about 238,855 miles (384,400 kilometers) away. It is roughly one-quarter the size of Earth and has a significant impact on our planet, influencing tides and stabilizing Earths axial tilt.','https://www.google.com/test');

insert into  spaceline (spaceline_name, contact_number, founded_year, fleet_size) values
('SpaceX', '1-800-test','2026', 200), 
('Boeing', '1-700-test','2016', 100);

insert into spaceport (spaceport_name, contact_number, facilities, year_established, destination_id) values
('VST', '1-700-test', 'Re-Fueling, Docking, public Transit, Storage', '1996', 1),
('MBA', '1-800-test', 'Re-Fueling, Docking, public Transit, Storage', '2030', 2);

insert into spacecraft (spacecraft_name, max_passengers, max_payload, stages, spacecraft_status, specific_impulse, spaceline_id) values
('Falcon 9', 6, '200kg', 2, 'Ready for Flight', '200kn', 1), 
('New Glenn', 10, '500kg', 2, 'Preparing for Flight','300kn', 2);

insert into flight (flight_name, departure_time, departure_date, arrival_time, price_per_ticket, 
departure_port_id, arrival_port_id, spacecraft_id) values
('VST To MBA', '10:30:00', 2025-02-10, '22:10:00', 600, 1, 2, 1), 
('MBA To VST', '22:10:00', 2025-02-15, '10:30:00', 1000, 2, 1, 2);


