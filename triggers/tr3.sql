/*4. Заборонити видалення стрічок з таблиці Паролі.*/
drop trigger if exists not_delete_password;
DELIMITER //
create trigger not_delete_password
before delete
on password for each row
begin
    signal sqlstate '45000'
    set message_text = "Do not delete!!!";
end //
DELIMITER ;