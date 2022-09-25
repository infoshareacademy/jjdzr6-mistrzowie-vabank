CREATE TABLE `accounts` (
                            `USER_NAME` varchar(20) COLLATE latin1_general_ci NOT NULL,
                            `ACTIVE` bit(1) NOT NULL,
                            `ENCRYTED_PASSWORD` varchar(128) COLLATE latin1_general_ci NOT NULL,
                            `USER_ROLE` varchar(20) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;


CREATE TABLE `orders` (
                          `ID` long COLLATE latin1_general_ci NOT NULL,
                          `AMOUNT` double NOT NULL,
                          `CUSTOMER_ADDRESS` varchar(255) COLLATE latin1_general_ci NOT NULL,
                          `CUSTOMER_EMAIL` varchar(128) COLLATE latin1_general_ci NOT NULL,
                          `CUSTOMER_NAME` varchar(255) COLLATE latin1_general_ci NOT NULL,
                          `CUSTOMER_PHONE` varchar(128) COLLATE latin1_general_ci NOT NULL,
                          `ORDER_DATE` datetime NOT NULL,
                          `ORDER_NUM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `order_details` (
                                 `ID` long COLLATE latin1_general_ci NOT NULL,
                                 `AMOUNT` double NOT NULL,
                                 `PRICE` double NOT NULL,
                                 `QUANITY` int(11) NOT NULL,
                                 `ORDER_ID` varchar(50) COLLATE latin1_general_ci NOT NULL,
                                 `PRODUCT_ID` varchar(20) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

create table wine
(
    id long            not null,
    flavour  varchar(255)   null,
    name     varchar(255)   null,
    origin   varchar(255)   null,
    price    decimal(19, 2) null,
    quantity int            not null,
    type     varchar(255)   null,
    year     int            not null,
    `IMAGE` longblob,
    `CREATE_DATE` datetime NOT NULL,
    constraint UK_3jx72qqpwje587ypaf742i5s0
        unique (name)
);
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (0,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (1,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (2,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (3,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (4,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (5,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (6,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (7,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (8,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (9,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (10,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')
INSERT INTO mistrzowieVaBank.wine (id, flavour, name, origin, price, quantity, type, year, IMAGE, CREATE_DATE) VALUES (11,"Słodkie", "Château Rieussec Premiere Cru Classe Sauternes", "Francja", 560, 10,"Białe", 2014, NULL, '2022-10-10')

/*INSERT INTO mistrzowieVaBank.wine (wine_id, name, flavour, type, year, origin, price, quantity) VALUES (1, "Château Rieussec Premiere Cru Classe Sauternes", "Słodkie", "Białe", 2014, "Francja", 560, 10)
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
*/