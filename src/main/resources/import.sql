INSERT INTO mistrzowieVaBank.roles(id, name) VALUES(1, 'ADMIN');
INSERT INTO mistrzowieVaBank.roles(id, name) VALUES(2, 'USER');

INSERT INTO mistrzowieVaBank.users (id, username, password) VALUES (1, 'admin', '{bcrypt}$2a$10$PZomtrVYYPi4dB0vm5HYDOHib.O/WLXHmY41f4iHKKPCVdEDLJUvW');
INSERT INTO mistrzowieVaBank.users (id, username, password) VALUES (2, 'user', '{bcrypt}$2a$10$ZKhlcv0ki4chQZhiUGupM.50BUfDavDXPfmHsn3np.IcA26IO8fSC');
INSERT INTO mistrzowieVaBank.users (id, username, password) VALUES (3, 'noRole', '{bcrypt}$2a$10$ZKhlcv0ki4chQZhiUGupM.50BUfDavDXPfmHsn3np.IcA26IO8fSC');
INSERT INTO mistrzowieVaBank.users (id, username, password) VALUES (4, 'user2', '{bcrypt}$2a$10$ZKhlcv0ki4chQZhiUGupM.50BUfDavDXPfmHsn3np.IcA26IO8fSC');

INSERT INTO mistrzowieVaBank.users_roles (user_id, role_id) VALUES(1, 1);
INSERT INTO mistrzowieVaBank.users_roles (user_id, role_id) VALUES(1, 2);
INSERT INTO mistrzowieVaBank.users_roles (user_id, role_id) VALUES(2, 2);
INSERT INTO mistrzowieVaBank.users_roles (user_id, role_id) VALUES(4, 2);

INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (1, "Château Rieussec Premiere Cru Classe Sauternes", "Słodkie", "Białe", 2014, "Francja", 560, 10)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (2, "Hétszőlő Tokaj Sweet Szamorodni Domaine Imperial", "Słodkie", "Białe", 2017, "Węgry", 100, 15)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (3, "Château Lafite Rothschild Premiere Cru Classe Pauillac", "Wytrawne", "Czerwone", 2010, "Francja", 8550, 6)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (4, "Chateau Mouton Rothschild 1-er Cru Classe", "Wytrawne", "Czerwone", 2011, "Francja", 4650, 20)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (5, "Catena Zapata Adrianna Vineyard „River Stones Malbec", "Czerwone", "Białe", 2018, "Argentyna", 699, 2)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (6, "Muscaris Kojder", "Półsłodkie", "Białe", 2020, "Polska", 89, 420)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (7, "Araldica Moscato d'Asti", "Musujące", "Białe", 2020, "Włochy", 55, 11)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (8, "Tamada Kindzmarauli", "Czerwone", "Białe", 2019, "Gruzja", 49, 5)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (9, "Dominio de Pingus Pingus Ribera Del Duero DO", "Wytrawne", "Czerwone", 2018, "Hiszpania", 5549, 64)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (10, "Bestheim Pinot Gris Classic Alsace", "Półwytrawne", "Białe", 2019, "Francja", 65, 24)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (11, "Carmenere Gran Reserva Vina Falernia", "Półwytrawne", "Czerwone", 2018, "Chile", 79, 13)
INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (12, "Soley Winnica Słońce i Wiatr", "Półwytrawne", "Białe", 2020, "Polska", 79, 44)
