/*1. Для таблиці Користувачі написати функцію як буде шукати
MAX стовпця Рейтинг. Потім зробити вибірку даних (SELECT),
використовуючи дану функцію.*/
DROP FUNCTION IF EXISTS get_max_rating;
DELIMITER //
CREATE FUNCTION get_max_rating()
RETURNS int
DETERMINISTIC
BEGIN
	return(SELECT MAX(rating) FROM user);
END;
select * from user where rating = get_max_rating()//
DELIMITER ;