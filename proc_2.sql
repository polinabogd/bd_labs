/*2.Створити пакет, який вставляє 10 стрічок в таблицю Книги у фор-
маті < Noname+No> , наприклад: Noname5, Noname6, Noname7 і т.д.*/
drop procedure if exists insertion_into_book;
DELIMITER //
CREATE PROCEDURE insertion_into_book ()
begin
	declare str VARCHAR(80);
	declare counter int;
	set counter=0, str='NoName';
while counter<10 do
	set counter = counter+1;
		insert into book(name, catalog_tree_id ) values (concat(str,counter), counter);
end while;
END //
DELIMITER ;
