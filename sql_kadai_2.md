1.
SELECT * FROM film; and I choose 'African Egg'
SELECT film.title, staff.store_id, address.address FROM
	film JOIN inventory ON film.film_id = inventory.film_id
	JOIN staff ON inventory.store_id = staff.store_id
	JOIN  address ON staff.address_id = address.address_id
	WHERE title = 'African Egg'
2.
SELECT 
    c.customer_id,
    COALESCE(p.total_pay, 0) AS total_pay,
    COALESCE(r.total_rent, 0) AS total_rent
FROM customer c
LEFT JOIN (
    SELECT customer_id, SUM(amount) AS total_pay
    FROM payment
    GROUP BY customer_id)
	p ON c.customer_id = p.customer_id
LEFT JOIN (
    SELECT customer_id, COUNT(rental_id) AS total_rent
    FROM rental
    GROUP BY customer_id)
	r ON c.customer_id = r.customer_id
ORDER BY total_pay DESC, total_rent DESC
LIMIT 5;
