CREATE DATABASE IF NOT EXISTS student_project;
USE student_project;

drop table if exists trip_item_review;
drop table if exists trip_advisor_user;
drop table if exists trip_item_rating;
drop table if exists trip_item;
drop table if exists item_adress;
drop table if exists security;

create table security(
 login VARCHAR(50),
 password VARCHAR(45) NOT NULL,
 PRIMARY KEY(login)
);

create table item_adress(
 id_adress BIGINT AUTO_INCREMENT,
 country VARCHAR(50) NOT NULL,
 region VARCHAR(50) NOT NULL,
 settlement VARCHAR(50) NOT NULL,
 street VARCHAR(50) NOT NULL,
 house int NOT NULL,
 PRIMARY KEY(id_adress)
);

create table trip_advisor_user(
 id BIGINT AUTO_INCREMENT,
 surname VARCHAR(50) NOT NULL,
 name VARCHAR(50) NOT NULL,
 email VARCHAR(45) NOT NULL,
 security_login VARCHAR(50) NOT NULL,
 PRIMARY KEY(id, security_login),
 CONSTRAINT FK_trip_advisor_user_security
 FOREIGN KEY (security_login)
 REFERENCES security (login)
);

create table trip_item(
 id_item BIGINT AUTO_INCREMENT,
 item_category enum('Hotel', 'Hostel', 'Restaurant', 'Avia company', 'Car rent') NOT NULL,
 name VARCHAR(50) NOT NULL,
 id_adress bigint,
 index idx_name (name ASC),
 PRIMARY KEY(id_item, id_adress),
 CONSTRAINT FK_trip_item_item_adress
 FOREIGN KEY (id_adress)
 REFERENCES item_adress (id_adress)
);

create table trip_item_rating(
 id_trip_item_rating BIGINT AUTO_INCREMENT,
 stars_for_placement INT(10),
 stars_for_prices INT(10),
 stars_in_general INT(10),
 id_item bigint,
 PRIMARY KEY(id_trip_item_rating, id_item),
 CONSTRAINT FK_trip_item_rating_trip_item
 FOREIGN KEY (id_item)
 REFERENCES trip_item (id_item)
);

create table trip_item_review(
 id_item_review BIGINT AUTO_INCREMENT,
 review_text VARCHAR(50),
 id_item bigint not null,
 user_id bigint not null,
 PRIMARY KEY(id_item_review, id_item),
 
 CONSTRAINT FK_trip_item_review_trip_item
 FOREIGN KEY (id_item)
 REFERENCES trip_item (id_item),
 
 CONSTRAINT FK_trip_item_review_trip_advisor_user
 FOREIGN KEY (user_id)
 REFERENCES trip_advisor_user (id)
);

INSERT INTO security (`login`, `password`) VALUES 
('taras', 'taras2003'), 
('polina', 'polina2003'),
('liza', 'yel2003'), 
('yura', 'yura2003'),
('sasha', 'nazar2003'),
('valera', 'valera2003'),
('katya', 'katya2003'),
('zenyk', 'veres1914'),
('anna', 'anna2003'),
('pavlo', 'pashka');

INSERT INTO item_adress (`country`, `region`, settlement, street, house) VALUES 
('Ukraine', 'Lvivska', 'lviv', 'lukasha', '5'), 
('Ukraine', 'Chernivetska', 'chernivtsi', 'sagaydachnogo', '93'),
('Italy ', 'West', 'Parma', 'Bronte', '3'), 
('Italy', 'East', 'Rome', 'Bandera', '77'),
('Greece', 'Center', 'Athenas', 'Carlo', '77'),
('Greece', 'East', 'Somewhere', 'Bandera', '11'),
('Bolgaria', 'Center', 'Rome', 'Carlo', '632'),
('Bolgaria', 'East', 'Rome', 'Bandera', '89'),
('USA', 'East', 'Center', 'Carlo', '333'),
('USA', 'East', 'Rome', 'Bandera', '76');

INSERT INTO trip_advisor_user (surname, name, email, security_login ) VALUES 
('Bek', 'Taras', 'bektaras@gmail.com', 'taras'),
('Bogd', 'Polina', 'polinabogd@gmail.com', 'polina'),
('Dmitrenko', 'Liza', 'poLiza@gmail.com', 'liza'),
('Vavrynchuk', 'Yura', 'Yura@gmail.com', 'yura'),
('Borylo', 'Sasha', 'polSashabogd@gmail.com', 'sasha'),
('Kozak', 'Valera', 'Katerynad@gmail.com', 'valera'),
('Afund', 'Kateryna', 'Valeralinabogd@gmail.com', 'katya'),
('Veres', 'Zenyk', 'polinaZenyk@gmail.com', 'zenyk'),
('Ptashka', 'Anna', 'Annaabogd@gmail.com', 'anna'),
('Chel', 'Pavlo', 'pPavlo@gmail.com', 'pavlo');

INSERT INTO trip_item (item_category, name, id_adress ) VALUES 
('Hotel', 'Plaza', '1'),
('Hotel', 'Beregomet', '2'),
('Restaurant', 'Kupalska nich', '3'),
('Restaurant', 'david', '4'),
('Hostel', 'Studik', '5'),
('Hostel', 'Bidnist', '6'),
('Avia company', 'LvivAir', '7'),
('Avia company', 'Airlines', '8'),
('Car rent', 'take and go', '9'),
('Car rent', 'justDrive', '10');

INSERT INTO trip_item_rating (stars_for_placement, stars_for_prices, stars_in_general, id_item) VALUES 
('1', '10','2','1'),
('3', '6','3','2'),
('4', '10','7','3'),
('7', '9','5','4'),
('2', '5','8','5'),
('1', '2','3','6'),
('5', '7','9','7'),
('9', '4','10','8'),
('10', '3','5','9'),
('6', '1','1','10');

INSERT INTO trip_item_review (review_text, id_item, user_id) VALUES 
('Good','1','1'),
('Bad','2','2'),
('Awful','2','3'),
('Great','3','4'),
('Never seen better','4','5'),
('Don`t go there','3','6'),
('','5','7'),
('','9','8'),
('Kind of normal','6','9'),
('Can be','1','3');