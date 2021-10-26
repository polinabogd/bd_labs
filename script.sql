/* 1. БД «Комп. фірма». Знайти виробників ПК. Вивести: maker, type.
Вихідні дані впорядкувати за спаданням за стовпцем maker */
SELECT maker, type FROM labor_sql.product
ORDER BY maker desc;

/*2. БД «Аеропорт». З таблиці Pass_in_trip вивести дати, 
коли були зайняті місця 'c' у будь-якому ряді.*/
SELECT date FROM labor_sql.pass_in_trip
where place like "%c";

/* 3. БД «Аеропорт». Для пасажирів таблиці Passenger вивести дати, 
коли вони користувалися послугами авіаліній.*/
SELECT name, date FROM labor_sql.passenger, labor_sql.pass_in_trip
order by name;

/*4. БД «Кораблі». Вивести класи всіх кораблів України ('Ukraine'). 
Якщо в БД немає класів кораблів України, тоді вивести класи для всіх
наявних у БД країн. Вивести: country, class.*/
SELECT class, country FROM labor_sql.classes
having(case when 
exists(SELECT class, country FROM labor_sql.classes where country="Ukraine") 
then country="Ukraine"
else country!="Ukraine"
end);

/*5. БД «Комп. фірма». Виведіть тих виробників ноутбуків, які не 
випускають принтери.*/
SELECT distinct maker FROM labor_sql.product
where type="Laptop" and  maker!=all
(select distinct maker from labor_sql.product where type="Printer");

/*6. БД «Комп. фірма». Для таблиці Printer вивести всю інформацію з 
коментарями в кожній комірці, наприклад, 'модель: 1276', 'ціна: 
400,00' і т.д. connac??*/
SELECT concat('код: ', code) as 'Код', 
concat('модель: ', model) as 'Модель', 
concat('колір: ', color) as 'Колір',
concat('тип: ', type) as 'Тип',
concat('ціна: ', price) as 'Ціна'
FROM labor_sql.printer;

/*7. БД «Комп. фірма». Знайдіть кількість ПК та середню ціну для кож-
ної моделі при умові, що середня ціна є меншою 800 дол.
*/
SELECT model, AVG(price)
FROM labor_sql.pc
GROUP BY model
HAVING AVG(price) < 800;

/*8. БД «Комп. фірма». Для таблиці Product отримати підсумковий набір 
у вигляді таблиці зі стовпцями pc, laptop та printer, у якій необхідно 
вказати кількість продукції, що випускається, тобто наявну загальну 
кількість продукції в таблицях, відповідно, PC, Laptop та Printer. 
(Підказка: використовувати підзапити вякості обчислювальних стовпців)*/

SELECT distinct (SELECT COUNT(laptop.code) FROM labor_sql.laptop) as laptop, 
(SELECT COUNT(printer.code) FROM labor_sql.printer) as printer, 
(SELECT COUNT(pc.code) FROM labor_sql.pc) as pc
FROM labor_sql.product;

/*9. БД «Комп. фірма». Для таблиці Product отримати підсумковий набір 
у вигляді таблиці зі стовпцями maker, laptop, у якій для кожного
 виробника необхідно вказати, чи виробляє він ('yes'), чи ні ('no') 
відповідний тип продукції. (Підказка: використовувати оператор CASE)*/
SELECT maker, 
case 
	when maker=any(SELECT maker FROM labor_sql.product where type="Laptop") 
    then 'yes'
    else 'no'
end as laptop
FROM labor_sql.product 
group by maker
order by maker;

/*10. БД «Кораблі». Знайдіть класи, до яких входить лише один 
корабель з усієї БД (врахувати також кораблі в таблиці Outcomes, яких 
немає в таблиці Ships). Вивести: class. (Підказка: використовувати 
оператор UNION*/
SELECT c.class
FROM classes c
 LEFT JOIN (
 SELECT class, name
 FROM ships
 UNION
 SELECT ship, ship
 FROM outcomes
) AS s ON s.class = c.class
GROUP BY c.class
HAVING COUNT(s.name) = 1
