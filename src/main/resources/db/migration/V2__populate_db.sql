INSERT INTO client (name)
VALUES ('Dima'),
       ('Den'),
       ('Sem'),
       ('Max'),
       ('Alex'),
       ('Nik'),
       ('Riz'),
       ('Set'),
       ('Ostin'),
       ('Luck');

INSERT INTO planet (name)
VALUES ('Mercury'),
       ('Earth'),
       ('Mars'),
       ('Venus'),
       ('Jupiter');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES ('2023-03-01 10:00:00', 1, 1, 2),
       ('2023-03-01 11:00:00', 2, 1, 3),
       ('2023-03-01 12:00:00', 3, 2, 4),
       ('2023-03-01 13:00:00', 4, 3, 4),
       ('2023-03-01 14:00:00', 4, 3, 5),
       ('2023-03-01 15:00:00', 4, 1, 4),
       ('2023-03-01 16:00:00', 4, 2, 3),
       ('2023-03-01 17:00:00', 4, 2, 4),
       ('2023-03-01 18:00:00', 4, 5, 1),
       ('2023-03-01 19:00:00', 4, 4, 2);
