/*2. Значення Користувачі→Рейтинг повинне бути у межах [0; 5],
при цьому тип даних допускає лише два розряди після коми;*/
drop trigger if exists rating_trigger;
DELIMITER //
create trigger before_rating
before insert
on user for each row
begin
	if (new.rating>5 or new.rating<0) 
    then signal sqlstate '45000'
    set message_text = "Check rating value (<5;>0)";
    end if;
end //
DELIMITER ;