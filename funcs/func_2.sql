/*2. Написати функцію, яка витягує за ключем між таблицями
Дерево каталогу та Книги значення поля Рубрика . Потім
зробити вибірку усіх даних (SELECT) з таблиці Книги,
використовуючи дану функцію.*/
DROP FUNCTION IF EXISTS get_category;
DELIMITER //
CREATE FUNCTION get_category(
	key_id int
)
RETURNS VARCHAR(45)
DETERMINISTIC
BEGIN
	return(SELECT category from catalog_tree where id = (SELECT catalog_tree_id FROM book where id = key_id));
END//
DELIMITER ;
select name, authors, get_category(id) from book;