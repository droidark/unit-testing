DROP TABLE item IF EXISTS;
CREATE TABLE item (
                      id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
                      name VARCHAR(250),
                      price INTEGER,
                      quantity INTEGER
);
INSERT INTO item(id, name, price, quantity) values (1001, 'Item-1001', 101, 201);
INSERT INTO item(id, name, price, quantity) values (1002, 'Item-1002', 51, 101);
INSERT INTO item(id, name, price, quantity) values (1003, 'Item-1003', 151, 21);