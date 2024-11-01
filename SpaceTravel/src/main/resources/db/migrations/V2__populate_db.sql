INSERT INTO client(name) VALUES
                             ('Alice'),
                             ('Bob'),
                             ('John'),
                             ('Charlie'),
                             ('Danny'),
                             ('Megan'),
                             ('Nicholas'),
                             ('Martin'),
                             ('Emma'),
                             ('Justin');

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
