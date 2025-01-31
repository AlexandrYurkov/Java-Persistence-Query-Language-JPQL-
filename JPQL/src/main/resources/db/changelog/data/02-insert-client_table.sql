INSERT INTO client (id, name, address_id) VALUES
    (gen_random_uuid(),'Calvin Rogahn', (SELECT id from address WHERE address.address= 'Turcotte Terrace 86')),
    (gen_random_uuid(),'Shannon Waelchi', (SELECT id from address WHERE address.address= 'Carter Parkways 32')),
    (gen_random_uuid(),'Mrs. Alonzo Thiel MD', (SELECT id from address WHERE address.address= 'Balistreri Manors  49')),
    (gen_random_uuid(),'Sonia Pacocha DVM', (SELECT id from address WHERE address.address= 'Hahn Junctions 25')),
    (gen_random_uuid(),'Janet Strosin', (SELECT id from address WHERE address.address= 'Aglae Streets 46')),
    (gen_random_uuid(),'Mr. Emanuel Schumm', (SELECT id from address WHERE address.address= 'Reynolds Cape 89')),
    (gen_random_uuid(),'Angelo Feil', (SELECT id from address WHERE address.address= 'Metz Forest 78')),
    (gen_random_uuid(),'Doug Zieme', (SELECT id from address WHERE address.address= 'Roma Oval 18')),
    (gen_random_uuid(),'Nicolas Kerluke', (SELECT id from address WHERE address.address= 'Kemmer Way 64')),
    (gen_random_uuid(),'Mrs. Roxanne Glover PhD', (SELECT id from address WHERE address.address= 'Rosalinda Orchard 56'));