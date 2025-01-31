INSERT INTO phone (id, number, client_id) VALUES
    (gen_random_uuid(),'+7(999)123-45-67', (SELECT id from client where name = 'Calvin Rogahn')),
    (gen_random_uuid(),'+1(750)-532-92-75', (SELECT id from client where name = 'Shannon Waelchi')),
    (gen_random_uuid(),'+7(909)-550-26-07', (SELECT id from client where name = 'Mrs. Alonzo Thiel MD')),
    (gen_random_uuid(),'+6(821)-286-01-18', (SELECT id from client where name = 'Sonia Pacocha DVM')),
    (gen_random_uuid(),'+5(621)-717-12-80', (SELECT id from client where name = 'Janet Strosin')),
    (gen_random_uuid(),'+2(003)-997-07-72', (SELECT id from client where name = 'Mr. Emanuel Schumm')),
    (gen_random_uuid(),'+2(857)-232-15-50', (SELECT id from client where name = 'Angelo Feil')),
    (gen_random_uuid(),'+7(772)-512-60-78', (SELECT id from client where name = 'Doug Zieme')),
    (gen_random_uuid(),'+6(279)-642-76-57', (SELECT id from client where name = 'Nicolas Kerluke')),
    (gen_random_uuid(),'+5(697)-399-74-14', (SELECT id from client where name = 'Mrs. Roxanne Glover PhD'));