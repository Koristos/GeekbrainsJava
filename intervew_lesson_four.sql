CREATE DATABASE FILMBASEchartchartchartchart_idchart_id;
USE FILMBASE;

CREATE TABLE FILMS (
film_id INTEGER PRIMARY KEY auto_increment,
film_name VARCHAR (50) NOT NULL,
film_duration INTEGER NOT NULL);

CREATE TABLE TICKETS (
ticket_id INTEGER PRIMARY KEY auto_increment,
ticket_place VARCHAR(4) NOT NULL,
chart_id INTEGER NOT NULL);

CREATE TABLE PRICES(
price_id INTEGER PRIMARY KEY auto_increment,
price_cost DECIMAL (10,2) NOT NULL);

CREATE TABLE CHART (
chart_id INTEGER PRIMARY KEY auto_increment,
chart_date DATETIME NOT NULL,
price_id INTEGER NOT NULL,
film_id INTEGER NOT NULL);

ALTER TABLE TICKETS ADD (CONSTRAINT FK_TICKETS_CHART FOREIGN KEY (chart_id) REFERENCES CHART (chart_id) ON DELETE CASCADE);
ALTER TABLE CHART ADD (CONSTRAINT FK_CHART_FILMS FOREIGN KEY (film_id) REFERENCES FILMS (film_id) ON DELETE CASCADE);
ALTER TABLE CHART ADD (CONSTRAINT FK_CHART_PRICES FOREIGN KEY (price_id) REFERENCES PRICES (price_id));

INSERT INTO FILMS (film_name, film_duration) VALUES 
('Pirates of the Caribien', 90),
('Lord of the Rings', 120),
('Snow White', 60);

INSERT INTO PRICES (price_cost) VALUES 
(100.00),
(120.00),
(150.00),
(200.00),
(500.00);


INSERT INTO CHART (chart_date, price_id, film_id) VALUES 
('2021-01-01 12:00:00', 1, 1),
('2021-01-01 13:00:00', 2, 2),
('2021-01-01 16:00:00', 3, 3),
('2021-01-01 17:10:00', 4, 2);

INSERT INTO TICKETS (ticket_place, chart_id) VALUES 
('12F', 1),
('13F', 1),
('14F', 1),
('15F', 1),
('12F', 2),
('13F', 2),
('14F', 2),
('12F', 3),
('13F', 3),
('14F', 4),
('15F', 4),
('12G', 3),
('13G', 3),
('14G', 3),
('15G', 4);

COMMIT;

SELECT films_one.film_name, chart_one.chart_date,  films_two.film_name, chart_two.chart_date, films_two.film_duration FROM 
(CHART AS chart_one LEFT JOIN FILMS AS films_one ON (chart_one.film_id=films_one.film_id))
INNER JOIN
(CHART AS chart_two LEFT JOIN FILMS AS films_two ON (chart_two.film_id=films_two.film_id))
ON 
(chart_one.chart_date < date_add(chart_two.chart_date, INTERVAL films_two.film_duration MINUTE)
AND
chart_one.chart_date > chart_two.chart_date);

SELECT chart_id, first_film_name, first_film_start, first_film_duration, second_film_start, second_film_name, break FROM CHART
INNER JOIN
(SELECT chart_one.chart_id AS id,  films_one.film_name AS first_film_name, chart_one.chart_date AS first_film_start, films_one.film_duration AS first_film_duration, 
chart_two.chart_date AS second_film_start, films_two.film_name AS second_film_name,
MIN(TIME_TO_SEC(TIMEDIFF(chart_two.chart_date, date_add(chart_one.chart_date, INTERVAL films_one.film_duration MINUTE)))/60) AS break 
FROM 
(CHART AS chart_one LEFT JOIN FILMS AS films_one ON (chart_one.film_id=films_one.film_id))
INNER JOIN
(CHART AS chart_two LEFT JOIN FILMS AS films_two ON (chart_two.film_id=films_two.film_id))
ON TIME_TO_SEC(TIMEDIFF(chart_two.chart_date, date_add(chart_one.chart_date, INTERVAL films_one.film_duration MINUTE))>0)
GROUP BY id) AS result
ON (chart_id = result.id)
WHERE (break>30);

SELECT COALESCE(FILMS.film_name, 'ИТОГО') as film_name, sum(result.tickets_count) AS total_visitors,
avg(result.tickets_count) AS avarage_visitors, sum(tickets_count*price_cost) AS total_cash
FROM FILMS
LEFT JOIN
(SELECT CHART.chart_id, PRICES.price_cost, count(TICKETS.ticket_id) AS tickets_count, CHART.film_id FROM CHART
LEFT JOIN PRICES ON (CHART.price_id = PRICES.price_id)
LEFT JOIN TICKETS ON (CHART.chart_id = TICKETS.chart_id)
GROUP BY CHART.chart_id) as result
ON (FILMS.film_id = result.film_id)
GROUP BY film_name WITH ROLLUP;