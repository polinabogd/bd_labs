/*3. для Книги→УДК забезпечити формат: 2 довільні букви + '.' + 3 цифри.*/
drop trigger if exists befor_book;
DELIMITER //
create trigger befor_book
before insert
on book for each row
begin
	if (new.UDC not like '[a-z][a-z].[0-9][0-9][0-9]') 
    then signal sqlstate '45000'
    set message_text = "Check UDC value let/let.num/num/num";
    end if;
end //
DELIMITER ;