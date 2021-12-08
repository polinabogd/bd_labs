/*1. Забезпечити цілісність значень для структури БД.*/
USE bogdanovska_7_2;

-- catalog_tree

DROP TRIGGER IF EXISTS catalog_tree_delete;

DELIMITER //
CREATE TRIGGER catalog_tree_delete
BEFORE DELETE
ON catalog_tree FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT catalog_tree_id FROM book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete catalog_tree, its defined in book";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS catalog_tree_update;

DELIMITER //
CREATE TRIGGER catalog_tree_update
BEFORE UPDATE
ON catalog_tree FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT catalog_tree_id from book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update catalog_tree, its defined in book";
    END IF;
END //
DELIMITER ;


-- password

DROP TRIGGER IF EXISTS password_update;

DELIMITER //
CREATE TRIGGER password_update
BEFORE UPDATE
ON password FOR EACH ROW
BEGIN
	IF (old.user_login IN (SELECT login FROM user))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update rassword, its defined in user";
    END IF;
END //
DELIMITER ;


DROP TRIGGER IF EXISTS password_insert;

DELIMITER //
CREATE TRIGGER password_insert
BEFORE INSERT
ON password FOR EACH ROW
BEGIN
	IF (new.user_login NOT IN (SELECT login from user))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Check password for insert, no such user";
    END IF;
END //
DELIMITER ;

-- book_links

DROP TRIGGER IF EXISTS book_links_delete;

DELIMITER //
CREATE TRIGGER book_links_delete
BEFORE DELETE
ON book_links FOR EACH ROW
BEGIN
	IF (old.book_id IN (SELECT id FROM book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete book_links, its defined in book";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS book_links_update;

DELIMITER //
CREATE TRIGGER book_links_update
BEFORE UPDATE
ON book_links FOR EACH ROW
BEGIN
	IF (old.book_id IN (SELECT id FROM book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update book_links, its defined in book";
    END IF;
END //
DELIMITER ;


DROP TRIGGER IF EXISTS book_links_insert;

DELIMITER //
CREATE TRIGGER book_links_insert
BEFORE INSERT
ON book_links FOR EACH ROW
BEGIN
	IF (new.book_id NOT IN (SELECT id from book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Check book_links for insert, no such book";
    END IF;
END //
DELIMITER ;

-- book

DROP TRIGGER IF EXISTS book_delete;

DELIMITER //
CREATE TRIGGER book_delete
BEFORE DELETE
ON book FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT book_id FROM user_has_book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete book, its defined in user_has_book";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS book_update;

DELIMITER //
CREATE TRIGGER book_update
BEFORE UPDATE
ON book FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT book_id FROM user_has_book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update book, its defined in user_has_book";
    END IF;
END //
DELIMITER ;


DROP TRIGGER IF EXISTS book_insert;

DELIMITER //
CREATE TRIGGER book_insert
BEFORE INSERT
ON book FOR EACH ROW
BEGIN
	IF (new.catalog_tree_id NOT IN (SELECT id from catalog_tree))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Check book for insert, no such catalog_tree";
    END IF;
END //
DELIMITER ;

-- user

DROP TRIGGER IF EXISTS user_delete;

DELIMITER //
CREATE TRIGGER user_delete
BEFORE DELETE
ON user FOR EACH ROW
BEGIN
	IF (old.login IN (SELECT user_login FROM user_has_book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete user, its defined in user_has_book";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS user_update;

DELIMITER //
CREATE TRIGGER user_update
BEFORE UPDATE
ON user FOR EACH ROW
BEGIN
	IF (old.login IN (SELECT user_login FROM user_has_book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update user, its defined in user_has_book";
    END IF;
END //
DELIMITER ;

-- user_has_book

DROP TRIGGER IF EXISTS user_has_book_delete;

DELIMITER //
CREATE TRIGGER user_has_book_delete
BEFORE DELETE
ON user_has_book FOR EACH ROW
BEGIN
	IF (old.user_login IN (SELECT login FROM user) and old.book_id IN (SELECT id FROM book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete user_has_book, its defined in user and book";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS user_has_book_update;

DELIMITER //
CREATE TRIGGER user_has_book_update
BEFORE UPDATE
ON user_has_book FOR EACH ROW
BEGIN
	IF (old.user_login IN (SELECT login FROM user) and old.book_id IN (SELECT id FROM book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update user_has_book, its defined in user and book";
    END IF;
END //
DELIMITER ;


DROP TRIGGER IF EXISTS user_has_book_insert;

DELIMITER //
CREATE TRIGGER user_has_book_insert
BEFORE INSERT
ON user_has_book FOR EACH ROW
BEGIN
	IF (new.user_login NOT IN (SELECT login FROM user) or new.book_id NOT IN (SELECT id FROM book))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Check user_has_book for insert, no such user or book";
    END IF;
END //
DELIMITER ;