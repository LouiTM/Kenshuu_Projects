1.
SELECT title, release_year FROM film;
2.
SELECT title FROM film WHERE rental_rate > 4;
3.
INSERT INTO customer (store_id, address_id, first_name, last_name, email, activebool) VALUES (2, 5, 'Jared', 'Ely', 'jared.ely@sakilacustomer.org', true);
4.
UPDATE customer SET email = 'updated@email.com' WHERE customer_id = 5;