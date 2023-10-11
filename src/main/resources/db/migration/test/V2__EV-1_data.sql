INSERT INTO palindrome_db.public.users(id, created_at, updated_at, first_name, login, password, last_visit)
VALUES
    ('5ede3318-65e5-11ee-8c99-0242ac120001', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'Алексей', 'AlexSmirnov', 'yH/YcAcL5V/LSkVqRz0id7lo6E+GhBXuOUagWdVn0sw=', '2023-10-09T21:02:00.000'),
    ('5ede3318-65e5-11ee-8c99-0242ac120002', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'Алина', 'AlinaAntipova', '2RRP/F931p24m43oJonkYYz+oVI7aaV6i3d0IDBJ2fA=', '2023-10-09T20:15:00.000'),
    ('5ede3318-65e5-11ee-8c99-0242ac120003', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'Виктория', 'ViktoriaPronina', 'PccZFOqSjcKYMk8n7GotSGBY0zwLKIv9sSVg3TobUoo=', '2023-10-09T18:18:00.000'),
    ('5ede3318-65e5-11ee-8c99-0242ac120004', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'Денис', 'DenisDubov', 'zwnsKszJaBr0V2FItjL3bPRps2tykEtMar/WNm96JWQ=', '2023-10-09T14:12:00.000'),
    ('5ede3318-65e5-11ee-8c99-0242ac120005', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'Егор', 'EgorMironov', '4I6EtYrkJeRhnbMdIV7eEdQrE8jnYcncecKb77VvP48=', '2023-10-09T15:25:00.000'),
    ('5ede3318-65e5-11ee-8c99-0242ac120006', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'Кристина', 'KristinaSheludko', '8KtD9eYnqYrjGDWbaQmKUvrq8FItrEBtU4m54wcJ6LA=', '2023-10-09T19:39:00.000'),
    ('5ede3318-65e5-11ee-8c99-0242ac120007', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'Максим', 'MaximNagorniy', 'HK5Fi3MdcYlw+gxzw2Sx6S5bsnQDeLED2i1sHoZQ49A=', '2023-10-09T18:45:00.000'),
    ('5ede3318-65e5-11ee-8c99-0242ac120008', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'Никита', 'NikitaAntonov', 'AGiMJvutcq7cUhCgv/VY9aESAqV/DyIRRGwQdc/DQuw=', '2023-10-09T11:57:00.000'),
    ('5ede3318-65e5-11ee-8c99-0242ac120009', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'Олеся', 'OlesyaPrimak', '78KtPtMMxEv1e2Ccri0ASL39mYQXqz6xAG0ul3/1D+Y=', '2023-10-09T12:41:00.000'),
    ('5ede3318-65e5-11ee-8c99-0242ac120010', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'Полина', 'PolinaOsipenko', 'WQe84+qOnIJ8Y2Wb6f4aAuDjcr35CR6YWTrYzgCair4=', '2023-10-09T14:57:00.000');

INSERT INTO palindrome_db.public.palindromes(id, created_at, updated_at, palindrome, user_id)
VALUES
    ('b0420df0-65e6-11ee-8c99-0242ac120001', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'а лес у села', '5ede3318-65e5-11ee-8c99-0242ac120001'),
    ('b0420df0-65e6-11ee-8c99-0242ac120002', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'ага', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120003', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'аки лев велика', '5ede3318-65e5-11ee-8c99-0242ac120004'),
    ('b0420df0-65e6-11ee-8c99-0242ac120004', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'алла', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120005', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'анна', '5ede3318-65e5-11ee-8c99-0242ac120002'),
    ('b0420df0-65e6-11ee-8c99-0242ac120006', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'ара', '5ede3318-65e5-11ee-8c99-0242ac120002'),
    ('b0420df0-65e6-11ee-8c99-0242ac120007', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'баб', '5ede3318-65e5-11ee-8c99-0242ac120008'),
    ('b0420df0-65e6-11ee-8c99-0242ac120008', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'бел хлеб', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120009', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'боб', '5ede3318-65e5-11ee-8c99-0242ac120007'),
    ('b0420df0-65e6-11ee-8c99-0242ac120010', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'дед', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120011', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'дивен мне вид', '5ede3318-65e5-11ee-8c99-0242ac120009'),
    ('b0420df0-65e6-11ee-8c99-0242ac120012', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'еле-еле', '5ede3318-65e5-11ee-8c99-0242ac120001'),
    ('b0420df0-65e6-11ee-8c99-0242ac120013', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'заказ', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120014', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'залаз', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120015', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'иди', '5ede3318-65e5-11ee-8c99-0242ac120010'),
    ('b0420df0-65e6-11ee-8c99-0242ac120016', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'иереи', '5ede3318-65e5-11ee-8c99-0242ac120002'),
    ('b0420df0-65e6-11ee-8c99-0242ac120017', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'или', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120018', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'ими', '5ede3318-65e5-11ee-8c99-0242ac120007'),
    ('b0420df0-65e6-11ee-8c99-0242ac120019', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'искать такси', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120020', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'ищи', '5ede3318-65e5-11ee-8c99-0242ac120004'),
    ('b0420df0-65e6-11ee-8c99-0242ac120021', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'кабак', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120022', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'казак', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120023', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'как', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120024', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'кек', '5ede3318-65e5-11ee-8c99-0242ac120007'),
    ('b0420df0-65e6-11ee-8c99-0242ac120025', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'кик', '5ede3318-65e5-11ee-8c99-0242ac120001'),
    ('b0420df0-65e6-11ee-8c99-0242ac120026', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'комок', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120027', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'коток', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120028', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'коту тащат уток', '5ede3318-65e5-11ee-8c99-0242ac120002'),
    ('b0420df0-65e6-11ee-8c99-0242ac120029', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'лазал', '5ede3318-65e5-11ee-8c99-0242ac120008'),
    ('b0420df0-65e6-11ee-8c99-0242ac120030', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'лакал', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120031', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'лапал', '5ede3318-65e5-11ee-8c99-0242ac120007'),
    ('b0420df0-65e6-11ee-8c99-0242ac120032', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'латал', '5ede3318-65e5-11ee-8c99-0242ac120004'),
    ('b0420df0-65e6-11ee-8c99-0242ac120033', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'левел', '5ede3318-65e5-11ee-8c99-0242ac120009'),
    ('b0420df0-65e6-11ee-8c99-0242ac120034', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'летел', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120035', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'лил', '5ede3318-65e5-11ee-8c99-0242ac120007'),
    ('b0420df0-65e6-11ee-8c99-0242ac120036', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'лишил', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120037', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'мадам', '5ede3318-65e5-11ee-8c99-0242ac120001'),
    ('b0420df0-65e6-11ee-8c99-0242ac120038', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'мам', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120039', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'мамам', '5ede3318-65e5-11ee-8c99-0242ac120004'),
    ('b0420df0-65e6-11ee-8c99-0242ac120040', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'манекенам', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120041', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'мем', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120042', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'нин', '5ede3318-65e5-11ee-8c99-0242ac120003'),
    ('b0420df0-65e6-11ee-8c99-0242ac120043', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'ого', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120044', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'око', '5ede3318-65e5-11ee-8c99-0242ac120004'),
    ('b0420df0-65e6-11ee-8c99-0242ac120045', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'пап', '5ede3318-65e5-11ee-8c99-0242ac120010'),
    ('b0420df0-65e6-11ee-8c99-0242ac120046', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'поп', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120047', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'потоп', '5ede3318-65e5-11ee-8c99-0242ac120002'),
    ('b0420df0-65e6-11ee-8c99-0242ac120048', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'радар', '5ede3318-65e5-11ee-8c99-0242ac120007'),
    ('b0420df0-65e6-11ee-8c99-0242ac120049', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'ребер', '5ede3318-65e5-11ee-8c99-0242ac120009'),
    ('b0420df0-65e6-11ee-8c99-0242ac120050', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'репер', '5ede3318-65e5-11ee-8c99-0242ac120004'),
    ('b0420df0-65e6-11ee-8c99-0242ac120051', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'ротор', '5ede3318-65e5-11ee-8c99-0242ac120008'),
    ('b0420df0-65e6-11ee-8c99-0242ac120052', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'сос', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120053', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'тащат', '5ede3318-65e5-11ee-8c99-0242ac120005'),
    ('b0420df0-65e6-11ee-8c99-0242ac120054', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'тет-а-тет', '5ede3318-65e5-11ee-8c99-0242ac120010'),
    ('b0420df0-65e6-11ee-8c99-0242ac120055', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'течет', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120056', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'топот', '5ede3318-65e5-11ee-8c99-0242ac120002'),
    ('b0420df0-65e6-11ee-8c99-0242ac120057', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'тот', '5ede3318-65e5-11ee-8c99-0242ac120002'),
    ('b0420df0-65e6-11ee-8c99-0242ac120058', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'тут', '5ede3318-65e5-11ee-8c99-0242ac120009'),
    ('b0420df0-65e6-11ee-8c99-0242ac120059', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'тут как тут', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120060', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'угу', '5ede3318-65e5-11ee-8c99-0242ac120004'),
    ('b0420df0-65e6-11ee-8c99-0242ac120061', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'учу', '5ede3318-65e5-11ee-8c99-0242ac120006'),
    ('b0420df0-65e6-11ee-8c99-0242ac120062', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'цыц', '5ede3318-65e5-11ee-8c99-0242ac120010'),
    ('b0420df0-65e6-11ee-8c99-0242ac120063', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'шабаш', '5ede3318-65e5-11ee-8c99-0242ac120009'),
    ('b0420df0-65e6-11ee-8c99-0242ac120064', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'шалаш', '5ede3318-65e5-11ee-8c99-0242ac120004'),
    ('b0420df0-65e6-11ee-8c99-0242ac120065', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', 'шиш', '5ede3318-65e5-11ee-8c99-0242ac120006');

INSERT INTO palindrome_db.public.statistics(id, created_at, updated_at, user_id, palindromes_number, total_points)
VALUES
    ('ca437a7e-65e9-11ee-8c99-0242ac120001', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', '5ede3318-65e5-11ee-8c99-0242ac120001', 4, 27),
    ('ca437a7e-65e5-11ee-8c99-0242ac120002', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', '5ede3318-65e5-11ee-8c99-0242ac120002', 7, 40),
    ('ca437a7e-65e5-11ee-8c99-0242ac120003', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', '5ede3318-65e5-11ee-8c99-0242ac120003', 1, 3),
    ('ca437a7e-65e5-11ee-8c99-0242ac120004', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', '5ede3318-65e5-11ee-8c99-0242ac120004', 8, 43),
    ('ca437a7e-65e5-11ee-8c99-0242ac120005', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', '5ede3318-65e5-11ee-8c99-0242ac120005', 15, 77),
    ('ca437a7e-65e5-11ee-8c99-0242ac120006', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', '5ede3318-65e5-11ee-8c99-0242ac120006', 12, 55),
    ('ca437a7e-65e5-11ee-8c99-0242ac120007', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', '5ede3318-65e5-11ee-8c99-0242ac120007', 6, 22),
    ('ca437a7e-65e5-11ee-8c99-0242ac120008', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', '5ede3318-65e5-11ee-8c99-0242ac120008', 3, 13),
    ('ca437a7e-65e5-11ee-8c99-0242ac120009', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', '5ede3318-65e5-11ee-8c99-0242ac120009', 5, 31),
    ('ca437a7e-65e5-11ee-8c99-0242ac120010', '2023-10-09T10:00:00.000', '2023-10-09T10:00:00.000', '5ede3318-65e5-11ee-8c99-0242ac120010', 4, 18);