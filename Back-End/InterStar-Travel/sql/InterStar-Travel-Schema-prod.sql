drop database if exists interstar_travel;
create database interstar_travel;
use interstar_travel;

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
location varchar(25) not null,
year_established varchar(25) not null,
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
constraint fk_departure_port_id
foreign key (spaceport_id) 
references spaceport(spaceport_id),
constraint fk_arrival_port_id
foreign key (spaceport_id) 
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
constraint fk_passenger_id 
foreign key (passenger_id) 
references passenger(passenger_id), 
constraint fk_flight_id
foreign key (flight_id) 
references flight(flight_id)
);