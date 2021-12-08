/*3. Використовуючи курсор, забезпечити динамічне створення БД
з іменами Користувачів, з випадковою кількістю таблиць для
кожної БД (від 1 до 9). Структура таблиць довільна. Імена
таблиць відповідають імені Користувача з порядковим номером
від 1 до 9.*/
drop procedure if exists create_new_db_of_users;
DELIMITER //
CREATE PROCEDURE create_new_db_of_users ()
BEGIN
	DECLARE nameU varchar(90);
	DECLARE done int DEFAULT false;
    DECLARE random int;
	
    DECLARE cursor1 CURSOR FOR SELECT name from user;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
	OPEN cursor1;
    loop1: LOOP 
		set random = (FLOOR( RAND() * (9-1) + 1));
		FETCH cursor1 INTO nameU;
        IF done=true THEN LEAVE loop1;
        END IF;

		SET @tmp_query0 = CONCAT('drop database if exists ',nameU,';');
        PREPARE myquery FROM @tmp_query0;
        EXECUTE myquery;
        DEALLOCATE PREPARE myquery;
        
        SET @tmp_query = CONCAT('CREATE DATABASE IF NOT EXISTS ',nameU,';');
        PREPARE myquery FROM @tmp_query;
        EXECUTE myquery;
        DEALLOCATE PREPARE myquery;

        
       WHILE random > 0 do
            set random = random - 1;
            
			SET @tmp_query2 = CONCAT('use ',nameU,';');
			PREPARE statement0 FROM @tmp_query2;
			EXECUTE statement0;
			DEALLOCATE PREPARE statement0;
            
            
            SET @tmp_query3 = CONCAT('drop table if exists ',nameU,';');
			PREPARE statement1 FROM @tmp_query3;
			EXECUTE statement1;
			DEALLOCATE PREPARE statement1;
            
            
			SET @tmp_query4 = CONCAT(
            'CREATE TABLE IF NOT EXISTS `',CONCAT(nameU,random), '` 
			(
			`id` INT,
			`name` VARCHAR(45), 
			PRIMARY KEY (`id`)
			);'
			);
			PREPARE statement FROM @tmp_query4;
			EXECUTE statement;
			DEALLOCATE PREPARE statement;
            
        end while;
    END LOOP;
    CLOSE cursor1;

END //
DELIMITER ;