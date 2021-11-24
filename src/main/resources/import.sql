DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), quantity int, cost float, PRIMARY KEY (id));
INSERT INTO products (title, quantity, cost) VALUES ('Invisible Hat', 2, 6.66), ('Magic Carpet', 0, 2.22), ('Sword Kladenets', 0, 3.14);
