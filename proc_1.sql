DELIMITER //
CREATE PROCEDURE `insertion_into_users` (
IN login VARCHAR(50),
IN surname VARCHAR(50), 
IN name VARCHAR(50),
IN fathername VARCHAR(50),
IN birthdate DATE,
IN birthplace VARCHAR(60),
IN domicile VARCHAR(60),
IN comment VARCHAR(30),
IN rating INT,
IN user_has_book_id INT
)
BEGIN
INSERT INTO user(`login`,`surname` , `name`, `fathername` ,`birthdate` ,
 `birthplace`, `domicile`, `comment`, `rating`, `user_has_book_id`) VALUES
(login, surname , name, fathername , birthdate , birthplace, domicile,
 comment, rating, user_has_book_id);
END //
DELIMITER ;