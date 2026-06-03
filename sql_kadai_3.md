1.
select fl.title from film as fl 
inner join inventory as iv 
on fl.film_id = iv.film_id
inner join rental as rt
on iv.inventory_id = rt.inventory_id
where rental_date = (select max(rental_date) from rental);

2.
begin;

insert into rental (rental_date, inventory_id, customer_id, staff_id)
values (now(), 23, 56, 2);

insert into payment (customer_id, staff_id, rental_id, amount, payment_date)
values (56, 2, 16051, 4.99, now());

commit;