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
