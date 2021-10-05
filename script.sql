INSERT INTO `bogdanovska`.`security` (`login`, `password`) VALUES ('taras', 'taras2003');
INSERT INTO `bogdanovska`.`security` (`login`, `password`) VALUES ('polina', 'polina2003');
INSERT INTO `bogdanovska`.`security` (`login`, `password`) VALUES ('liza', 'yel2003');
INSERT INTO `bogdanovska`.`security` (`login`, `password`) VALUES ('nazar', 'nazar2003');

INSERT INTO `bogdanovska`.`adress` (`Country`, `Region`, `Settlement`, `Street`, `House`) VALUES ('Ukraine', 'Lvivska', 'lviv', 'lukasha', '5');
INSERT INTO `bogdanovska`.`adress` (`Country`, `Region`, `Settlement`, `Street`, `House`) VALUES ('Ukraine', 'Chernivetska', 'chernivtsi', 'sagaydachnogo', '93');
INSERT INTO `bogdanovska`.`adress` (`Country`, `Region`, `Settlement`, `Street`, `House`) VALUES ('Italy ', 'West', 'Parma', 'Bronte', '3');
INSERT INTO `bogdanovska`.`adress` (`Country`, `Region`, `Settlement`, `Street`, `House`) VALUES ('Italy', 'East', 'Rome', 'Carlo', '77');

INSERT INTO `bogdanovska`.`tripsrating` (`RatingName`) VALUES ('Best by reviews');

INSERT INTO `bogdanovska`.`tripadvisoruser` (`NameSurname`, `BirthDate`, `Adress_idAdress`, `Security_login`) VALUES ('Taras Bek', '11.11.2003', '1', 'taras');
INSERT INTO `bogdanovska`.`tripadvisoruser` (`NameSurname`, `BirthDate`, `Adress_idAdress`, `Security_login`) VALUES ('Polina Bogd', '10.10.2003', '2', 'polina');

INSERT INTO `bogdanovska`.`accommodationowner` (`NameSurname`, `Security_login`) VALUES ('Liza Dmitrenko', 'liza');
INSERT INTO `bogdanovska`.`accommodationowner` (`NameSurname`, `Security_login`) VALUES ('Nazar Bakalic', 'nazar');

INSERT INTO `bogdanovska`.`tripaccommodation` (`PriceForPerson`, `PriceForOneOfFamily`, `BreakfastIncluded`, `FullRefundDueDate`, `AccommodationOwner_idOwner`, `Adress_idAdress`, `TripsRating_idTripsRating1`) VALUES ('25', '20', '1', '12.12.2021', '1', '3', '1');
INSERT INTO `bogdanovska`.`tripaccommodation` (`PriceForPerson`, `PriceForOneOfFamily`, `BreakfastIncluded`, `FullRefundDueDate`, `AccommodationOwner_idOwner`, `Adress_idAdress`, `TripsRating_idTripsRating1`) VALUES ('30', '23', '-1', '10.10.2003', '2', '4', '1');

INSERT INTO `bogdanovska`.`tripreview` (`CommentText`, `AmountOfStarsOutOfFive`, `TripAccommodation_idTripAccommodation`, `TripAdvisorUser_idTripAdvisorUser`) VALUES ('Very bad. Don`t go!!', '0', '1', '1');
INSERT INTO `bogdanovska`.`tripreview` (`CommentText`, `AmountOfStarsOutOfFive`, `TripAccommodation_idTripAccommodation`, `TripAdvisorUser_idTripAdvisorUser`) VALUES ('Best of the best', '4', '2', '1');
