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
fleet_size varchar(25) not null
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
max_passengers varchar(25) not null,
max_payload varchar(25) not null,
stages varchar(25) not null,
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


-- data
INSERT INTO passenger (first_name, last_name, email, phone_number)
VALUES
('John', 'Doe', 'johndoe@example.com', '+1234567890'),
('Jane', 'Smith', 'janesmith@example.com', '+1987654321'),
('Emily', 'Johnson', 'emilyj@example.com', '+1122334455'),
('Michael', 'Brown', 'michaelbrown@example.com', '+1444332211'),
('Sarah', 'Davis', 'sarahdavis@example.com', '+1555667788'),
('David', 'Miller', 'davidmiller@example.com', '+1666778899'),
('Laura', 'Wilson', 'laurawilson@example.com', '+1777889900'),
('James', 'Moore', 'jamesmoore@example.com', '+1888990011'),
('Linda', 'Taylor', 'lindataylor@example.com', '+1999001122'),
('Robert', 'Anderson', 'roberta@example.com', '+1234509876'),
('Patricia', 'Thomas', 'patriciat@example.com', '+9876543210'),
('Charles', 'Jackson', 'charlesjackson@example.com', '+1122336677'),
('Maria', 'White', 'mariawhite@example.com', '+1222333444'),
('William', 'Harris', 'williamharris@example.com', '+1333444555'),
('Elizabeth', 'Martin', 'elizabethmartin@example.com', '+1444555666'),
('Joseph', 'Garcia', 'josephgarcia@example.com', '+1555666777'),
('Betty', 'Rodriguez', 'bettyrodriguez@example.com', '+1666777888'),
('Thomas', 'Martinez', 'thomasmartinez@example.com', '+1777888899'),
('Nancy', 'Hernandez', 'nancyhernandez@example.com', '+1888999000'),
('Steven', 'Lopez', 'stevenlopez@example.com', '+1999001123');

INSERT INTO destination (destination_name, destination_description, image_url)
VALUES
('Mars', 'The Red Planet, known for its reddish appearance due to iron oxide (rust) on its surface. It has the largest volcano and canyon in the solar system.', 'https://example.com/mars_image.jpg'),
('Venus', 'Often called Earth\'s twin, Venus is a rocky planet with a thick atmosphere of sulfuric acid clouds, making it one of the hottest planets in the solar system.', 'https://example.com/venus_image.jpg'),
('Jupiter', 'The largest planet in the solar system, Jupiter is a gas giant known for its Great Red Spot, a massive storm that has been raging for centuries.', 'https://example.com/jupiter_image.jpg'),
('Saturn', 'Famous for its stunning ring system, Saturn is a gas giant with dozens of moons, including Titan, the second-largest moon in the solar system.', 'https://example.com/saturn_image.jpg'),
('Uranus', 'A giant ice planet known for its blue color and tilted rotation. Uranus rotates on its side, making it unique among the planets in the solar system.', 'https://example.com/uranus_image.jpg'),
('Neptune', 'Neptune is known for its deep blue color and intense winds. It is the furthest planet from the Sun and has a moon called Triton with geysers of liquid nitrogen.', 'https://example.com/neptune_image.jpg'),
('Europa', 'A moon of Jupiter, Europa is a frozen world with a vast ocean beneath its icy surface. It is considered one of the best places to search for signs of extraterrestrial life.', 'https://example.com/europa_image.jpg'),
('Titan', 'Titan is Saturn\'s largest moon and has a thick atmosphere and lakes of liquid methane and ethane on its surface. It is one of the most Earth-like places in the solar system.', 'https://example.com/titan_image.jpg'),
('Io', 'Io is one of Jupiter\'s moons, famous for its active volcanoes and sulfuric surface, making it the most geologically active body in the solar system.', 'https://example.com/io_image.jpg'),
('Callisto', 'Another moon of Jupiter, Callisto is heavily cratered and is one of the largest moons in the solar system. Its surface is ancient and largely unchanged.', 'https://example.com/callisto_image.jpg'),
('Enceladus', 'A moon of Saturn, Enceladus has a surface covered with ice, with geysers of water vapor shooting into space from beneath its icy crust.', 'https://example.com/enceladus_image.jpg'),
('Ganymede', 'The largest moon in the solar system, Ganymede is a moon of Jupiter that has its own magnetic field and a potential subsurface ocean.', 'https://example.com/ganymede_image.jpg'),
('Mercury', 'The smallest planet in the solar system, Mercury has a surface covered with craters and extreme temperatures due to its proximity to the Sun.', 'https://example.com/mercury_image.jpg'),
('Ceres', 'Ceres is the largest object in the asteroid belt and is classified as a dwarf planet. It may contain water ice beneath its rocky surface.', 'https://example.com/ceres_image.jpg'),
('Pluto', 'Once considered the ninth planet, Pluto is now classified as a dwarf planet. It is located in the outermost reaches of the solar system and has a complex system of moons.', 'https://example.com/pluto_image.jpg');
