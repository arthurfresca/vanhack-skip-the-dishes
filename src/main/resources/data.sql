/**
 * CREATE Script for init of DB
 */

-- Create 1 INITIAL CUSTOMER
insert into customers(id, date_created, email, name, address, password, is_active) values (1, now(), 'arthur.m.fresca@gmail.com', 'Arthur Fresca', 'Street Y', 'Pass123', true);

-- Create 1 INITIAL STORES
insert into stores (id, date_created, name, address, cousine_id, is_active) values (1, now(), 'Store 1', 'Street X', 1, true);

-- Create 3 INITIAL PRODUCTS
insert into products (id, date_created, store_id, description, price, name, is_active) values (1, now(), 1, 'Green or black olives, onions, tomato, and feta cheese', 20.00, 'Pizza', true);

insert into products (id, date_created, store_id, description, price, name, is_active) values (2, now(), 1, 'Chocolate, Strawberry', 2.50, 'Ice cream', true);

insert into products (id, date_created, store_id, description, price, name, is_active) values (3, now(), 1, 'Hotroll', 31.00, 'Sushi', true);