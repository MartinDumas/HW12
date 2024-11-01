INSERT INTO client(id, name) VALUES
                             (1,'Alice'),
                             (2, 'Bob'),
                             (3,'John'),
                             (4,'Charlie'),
                             (5,'Danny'),
                             (6,'Megan'),
                             (7,'Nicholas'),
                             (8,'Martin'),
                             (9,'Emma'),
                             (10,'Justin');

INSERT INTO planet(id, name) VALUES
                                 ('MER', 'Mercury'),
                                 ('VEN', 'Venus'),
                                 ('EARTH', 'Earth'),
                                 ('MARS', 'Mars'),
                                 ('SAT', 'Saturn');

INSERT INTO ticket(client_id, from_planet_id, to_planet_id) VALUES
                                                                (1, 'VEN', 'EARTH'),
                                                                (2, 'MARS', 'VEN'),
                                                                (3, 'EARTH', 'MER'),
                                                                (4, 'SAT', 'MARS'),
                                                                (5, 'MER', 'SAT');
