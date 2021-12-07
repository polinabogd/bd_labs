INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('mystery', '1');
INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('horror', '1');
INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('fancy', '1');
INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('england', '1');
INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('bestlviv', '2');
INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('cheapshit', '2');
INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('autobiography', '2');
INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('biography', '2');
INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('science', '3');
INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('sci-fi', '3');
INSERT INTO `bogdanovska_7_2`.`catalog_tree` (`category`, `catalog_tree_id`) VALUES ('something', '4');

INSERT INTO `bogdanovska_7_2`.`book` (`name`, `authors`, `UDC`, `rating`, `catalog_tree_id`, `user_has_book_id`) VALUES ('Desca', 'Arthur Konan Doyl', '222.33', '44', '2', '1');
INSERT INTO `bogdanovska_7_2`.`book` (`name`, `authors`, `UDC`, `rating`, `catalog_tree_id`, `user_has_book_id`) VALUES ('Sherloc', 'Arthur Konan Doyl', '556.93', '1', '2', '3');
INSERT INTO `bogdanovska_7_2`.`book` (`name`, `authors`, `UDC`, `rating`, `catalog_tree_id`, `user_has_book_id`) VALUES ('Hunger games', 'Polina', '345.8765', '2', '3', '4');
INSERT INTO `bogdanovska_7_2`.`book` (`name`, `authors`, `UDC`, `rating`, `catalog_tree_id`, `user_has_book_id`) VALUES ('Harry Potter', 'Liza', '54.54', '33', '4', '7');
INSERT INTO `bogdanovska_7_2`.`book` (`name`, `authors`, `UDC`, `rating`, `catalog_tree_id`, `user_has_book_id`) VALUES ('451 FArenheit', 'Nazariy', '890', '41', '5', '3');
INSERT INTO `bogdanovska_7_2`.`book` (`name`, `authors`, `UDC`, `rating`, `catalog_tree_id`, `user_has_book_id`) VALUES ('Encyclopedia', 'Aloha', '543', '56', '1', '9');
INSERT INTO `bogdanovska_7_2`.`book` (`name`, `authors`, `UDC`, `rating`, `catalog_tree_id`, `user_has_book_id`) VALUES ('OMG', 'Oliva Oleng', '2345.432', '7', '9', '7');
INSERT INTO `bogdanovska_7_2`.`book` (`name`, `authors`, `UDC`, `rating`, `catalog_tree_id`, `user_has_book_id`) VALUES ('Cooking for idiots', 'Astrit Lingren', '98', '9', '6', '1');
INSERT INTO `bogdanovska_7_2`.`book` (`name`, `authors`, `UDC`, `rating`, `catalog_tree_id`, `user_has_book_id`) VALUES ('Python for begginers', 'Taras Bek', '123', '17', '7', '7');
INSERT INTO `bogdanovska_7_2`.`book` (`name`, `authors`, `UDC`, `rating`, `catalog_tree_id`, `user_has_book_id`) VALUES ('Spanish in two weeks', 'Fernando', '123.543', '4', '3', '8');

INSERT INTO `bogdanovska_7_2`.`book_links` (`book_address`, `book_id`) VALUES ('tgbnm,', '1');
INSERT INTO `bogdanovska_7_2`.`book_links` (`book_address`, `book_id`) VALUES ('hgfdlksjh', '2');
INSERT INTO `bogdanovska_7_2`.`book_links` (`book_address`, `book_id`) VALUES ('somewhere', '3');
INSERT INTO `bogdanovska_7_2`.`book_links` (`book_address`, `book_id`) VALUES ('anywhere', '4');
INSERT INTO `bogdanovska_7_2`.`book_links` (`book_address`, `book_id`) VALUES ('place', '5');
INSERT INTO `bogdanovska_7_2`.`book_links` (`book_address`, `book_id`) VALUES ('what', '6');
INSERT INTO `bogdanovska_7_2`.`book_links` (`book_address`, `book_id`) VALUES ('adress', '7');
INSERT INTO `bogdanovska_7_2`.`book_links` (`book_address`, `book_id`) VALUES ('imagineitsanaddress', '8');
INSERT INTO `bogdanovska_7_2`.`book_links` (`book_address`, `book_id`) VALUES ('ernesto', '9');
INSERT INTO `bogdanovska_7_2`.`book_links` (`book_address`, `book_id`) VALUES ('inmyheart', '10');

INSERT INTO `bogdanovska_7_2`.`user` (`login`, `surname`, `name`, `fathername`, `birthdate`, `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES ('polina', 'Bogdanovska', 'Polian', 'Stanislavivna', '23.06.2003', 'Chernivtsi', 'Lviv', 'No', '1', '1');
INSERT INTO `bogdanovska_7_2`.`user` (`login`, `surname`, `name`, `fathername`, `birthdate`, `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES ('liza2003', 'Dmitrenko', 'Liza', 'Viktorivna', '07.06.2003', 'Lviv', 'Lviv', 'No', '2', '2');
INSERT INTO `bogdanovska_7_2`.`user` (`login`, `surname`, `name`, `fathername`, `birthdate`, `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES ('katya2003', 'Mintenko', 'Katya', 'Olehivna', '26.06.2003', 'Chernivtsi', 'Lviv', 'Stupid', '3', '3');
INSERT INTO `bogdanovska_7_2`.`user` (`login`, `surname`, `name`, `fathername`, `birthdate`, `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES ('anna2003', 'Illich', 'Anna', 'Geogiivna', '10.12.2002', 'Lviv', 'Lviv', 'Nothing', '4', '4');
INSERT INTO `bogdanovska_7_2`.`user` (`login`, `surname`, `name`, `fathername`, `birthdate`, `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES ('vasyl2003', 'Vasiliev', 'Olga', 'Nazarivna', '09.04.2002', 'Chernivtsi', 'Lviv', 'Good', '5', '5');
INSERT INTO `bogdanovska_7_2`.`user` (`login`, `surname`, `name`, `fathername`, `birthdate`, `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES ('nastya2003', 'Shevchenko', 'Nastya', 'Hrihorivna', '12.03.2003', 'Lviv', 'Chernivtsi', 'No', '6', '6');
INSERT INTO `bogdanovska_7_2`.`user` (`login`, `surname`, `name`, `fathername`, `birthdate`, `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES ('taras2003', 'Kostenko', 'Taras', 'Viktorovich', '12.06.2003', 'Chernivtsi', 'Chernivtsi', 'Bad reader', '7', '7');
INSERT INTO `bogdanovska_7_2`.`user` (`login`, `surname`, `name`, `fathername`, `birthdate`, `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES ('vitya2003', 'Ninovskiy', 'Viktor', 'Olehovich', '23.06.2000', 'Lviv', 'Chernivtsi', 'Do not return books', '8', '8');
INSERT INTO `bogdanovska_7_2`.`user` (`login`, `surname`, `name`, `fathername`, `birthdate`, `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES ('nazar2003', 'Koval', 'Nazar', 'Georgiyovich', '07.11.2003', 'Chernivtsi', 'Chernivtsi', 'Not paid', '9', '9');
INSERT INTO `bogdanovska_7_2`.`user` (`login`, `surname`, `name`, `fathername`, `birthdate`, `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES ('oleg2003', 'Balyo', 'Oleg', 'Nazariyovich', '11.11.2000', 'Lviv', 'Chernivtsi', 'No', '10', '10');

INSERT INTO `bogdanovska_7_2`.`password` (`password`, `user_login`) VALUES ('qwer123', 'anna2003');
INSERT INTO `bogdanovska_7_2`.`password` (`password`, `user_login`) VALUES ('hgf75', 'katya2003');
INSERT INTO `bogdanovska_7_2`.`password` (`password`, `user_login`) VALUES ('234h', 'liza2003');
INSERT INTO `bogdanovska_7_2`.`password` (`password`, `user_login`) VALUES ('oiuh5', 'nastya2003');
INSERT INTO `bogdanovska_7_2`.`password` (`password`, `user_login`) VALUES ('987hf', 'nazar2003');
INSERT INTO `bogdanovska_7_2`.`password` (`password`, `user_login`) VALUES ('f5', 'oleg2003');
INSERT INTO `bogdanovska_7_2`.`password` (`password`, `user_login`) VALUES ('iruth44', 'polina');
INSERT INTO `bogdanovska_7_2`.`password` (`password`, `user_login`) VALUES ('0jct', 'taras2003');
INSERT INTO `bogdanovska_7_2`.`password` (`password`, `user_login`) VALUES ('9s2d', 'vasyl2003');
INSERT INTO `bogdanovska_7_2`.`password` (`password`, `user_login`) VALUES ('347c', 'vitya2003');

INSERT INTO `bogdanovska_7_2`.`user_has_book` (`user_login`, `book_id`) VALUES ('anna2003', '1');
INSERT INTO `bogdanovska_7_2`.`user_has_book` (`user_login`, `book_id`) VALUES ('katya2003', '2');
INSERT INTO `bogdanovska_7_2`.`user_has_book` (`user_login`, `book_id`) VALUES ('liza2003', '3');
INSERT INTO `bogdanovska_7_2`.`user_has_book` (`user_login`, `book_id`) VALUES ('nastya2003', '4');
INSERT INTO `bogdanovska_7_2`.`user_has_book` (`user_login`, `book_id`) VALUES ('nazar2003', '5');
INSERT INTO `bogdanovska_7_2`.`user_has_book` (`user_login`, `book_id`) VALUES ('oleg2003', '6');
INSERT INTO `bogdanovska_7_2`.`user_has_book` (`user_login`, `book_id`) VALUES ('polina', '7');
INSERT INTO `bogdanovska_7_2`.`user_has_book` (`user_login`, `book_id`) VALUES ('taras2003', '8');
INSERT INTO `bogdanovska_7_2`.`user_has_book` (`user_login`, `book_id`) VALUES ('vasyl2003', '9');
INSERT INTO `bogdanovska_7_2`.`user_has_book` (`user_login`, `book_id`) VALUES ('vitya2003', '10');


