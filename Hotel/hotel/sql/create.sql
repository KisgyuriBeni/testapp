create table rooms(
    id int primary key auto_increment,
    szoba_szam varchar(32),
    szoba_merete int,
    agyak_szama int, 
    terasz TINYINT(1), 
    haziallat TINYINT(1)
);

create table renters(
    id int primary key auto_increment,
    nev varchar(32),
    szuletesi_datum DATE
);

create table rentings(
    id int primary key auto_increment,
    szoba_id int,
    foglalo_id int,
    foglalas_eleje DATE,
    foglalas_vege DATE,
    foreign key (szoba_id) references rooms(id),
    foreign key (foglalo_id) references renters(id)
);