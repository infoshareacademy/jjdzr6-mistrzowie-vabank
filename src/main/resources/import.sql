CREATE TABLE accounts (
                          user_name VARCHAR(20) NOT NULL,
                          encrypted_password VARCHAR(128) NOT NULL,
                          active BIT(1) NOT NULL,
                          user_role VARCHAR(20) NOT NULL,
                          CONSTRAINT pk_accounts PRIMARY KEY (user_name)
);
CREATE TABLE order_details (
                               id BIGINT NOT NULL,
                               order_id BIGINT NOT NULL,
                               product_id BIGINT NOT NULL,
                               quantity INT NOT NULL,
                               price DECIMAL NOT NULL,
                               amount DECIMAL NOT NULL,
                               CONSTRAINT pk_order_details PRIMARY KEY (id)
);

CREATE TABLE orders (
                        id BIGINT NOT NULL,
                        order_date datetime NOT NULL,
                        order_num INT NOT NULL,
                        amount DECIMAL NOT NULL,
                        customer_name VARCHAR(255) NOT NULL,
                        customer_address VARCHAR(255) NOT NULL,
                        customer_email VARCHAR(128) NOT NULL,
                        customer_phone VARCHAR(128) NOT NULL,
                        realized BOOLEAN NOT NULL,
                        CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE wine (
                      id BIGINT AUTO_INCREMENT NOT NULL,
                      name VARCHAR(255) NULL,
                      flavour VARCHAR(255) NULL,
                      type VARCHAR(255) NULL,
                      year INT NOT NULL,
                      origin VARCHAR(255) NULL,
                      price DECIMAL NULL,
                      quantity INT NOT NULL,
                      spec VARCHAR(5000) NULL,
                      image BLOB NULL,
                      create_date date NOT NULL,
                      CONSTRAINT pk_wine PRIMARY KEY (id)
);

ALTER TABLE order_details ADD CONSTRAINT FK_ORDER_DETAILS_ON_ORDER FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE order_details ADD CONSTRAINT FK_ORDER_DETAILS_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES wine (id);


ALTER TABLE orders ADD CONSTRAINT uc_7a4d96dd783e6268bc9173d62 UNIQUE (order_num);

ALTER TABLE wine ADD CONSTRAINT uc_wine_name UNIQUE (name);


INSERT INTO mistrzowieVaBank.orders (id, order_date, order_num, amount, customer_name, customer_address, customer_email, customer_phone, realized) VALUES (1, '2022-10-10',1, 100, 'Jan', 'asdvvc', 'ann@example.com','728326048',false);


INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (1, 'Château Rieussec Premiere Cru Classe Sauternes', 'Słodkie', 'Białe', 2014, 'Francja', 560, 10,'testowy opis', NULL,'2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (2, 'Hétszőlő Tokaj Sweet Szamorodni Domaine Imperial', 'Słodkie', 'Białe', 2017, 'Węgry', 100, 15,'testowy opis', NULL, '2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (3, 'Château Lafite Rothschild Premiere Cru Classe Pauillac', 'Wytrawne', 'Czerwone', 2010, 'Francja',8550, 6,'testowy opis',  NULL,'2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (4, 'Chateau Mouton Rothschild 1-er Cru Classe', 'Wytrawne', 'Czerwone', 2011, 'Francja', 4650, 20,'testowy opis',  NULL,'2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (5, 'Catena Zapata Adrianna Vineyard „River Stones Malbec', 'Czerwone', 'Białe', 2018, 'Argentyna', 699, 2,'testowy opis', NULL, '2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (6, 'Muscaris Kojder', 'Półsłodkie', 'Białe', 2020, 'Polska', 89, 420,'testowy opis', NULL, '2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (7, 'Araldica Moscato d Asti', 'Musujące', 'Białe', 2020, 'Włochy', 55, 11,'testowy opis', NULL, '2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (8, 'Tamada Kindzmarauli', 'Czerwone', 'Białe', 2019, 'Gruzja', 49, 5,'testowy opis', NULL, '2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (9, 'Dominio de Pingus Pingus Ribera Del Duero DO', 'Wytrawne', 'Czerwone', 2018, 'Hiszpania', 5549, 64,'testowy opis',  NULL,'2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (10, 'Bestheim Pinot Gris Classic Alsace', 'Półwytrawne', 'Białe', 2019, 'Francja', 65, 24,'testowy opis', NULL, '2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (11, 'Carmenere Gran Reserva Vina Falernia', 'Półwytrawne', 'Czerwone', 2018, 'Chile', 79, 13,'testowy opis',  NULL, '2022-10-10');
INSERT INTO mistrzowieVaBank.wine (id, name, flavour, type, year, origin, price, quantity, spec, IMAGE, CREATE_DATE) VALUES (12, 'Soley Winnica Słońce i Wiatr', 'Półwytrawne', 'Białe', 2020, 'Polska', 79, 44,'testowy opis',  NULL,'2022-10-10');

