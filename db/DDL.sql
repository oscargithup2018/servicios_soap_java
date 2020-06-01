# create schema consultorio_juridico collate utf8mb4_general_ci;

create table abogado
(
    id        int          not null auto_increment,
    cedula    int          not null,
    nombres   varchar(100) not null,
    apellidos varchar(100) not null,
    email     varchar(100) not null,
    telefono  varchar(18)  not null,
    direccion varchar(100) not null,
    tarjetap  int          not null,
    primary key (id)
);

create table cliente
(
    id        int          not null auto_increment,
    cedula    int          not null,
    nombres   varchar(100) not null,
    apellidos varchar(100) not null,
    email     varchar(100) not null,
    telefono  varchar(18)  not null,
    direccion varchar(100) not null,
    estrato   int(1)       not null,
    ingresos  int(8)       not null,
    primary key (id)
);

create table juzgado
(
    id         int          not null auto_increment,
    tipo       varchar(50)  not null,
    secretario varchar(100) not null,
    asistente  varchar(100) not null,
    primary key (id)
);

create table caso
(
    id          int          not null auto_increment,
    fechaInicio date         not null,
    descripcion varchar(100) not null,
    idJuzgado   int          not null,
    idCliente   int          not null,
    idAbogado   int          not null,
    key (id),
    constraint caso_ibfk_1
        foreign key (idAbogado) references abogado (id),
    constraint caso_ibfk_3
        foreign key (idCliente) references cliente (id) on delete cascade,
    constraint caso_ibfk_4
        foreign key (idJuzgado) references juzgado (id)
);

create index idAbogado
    on caso (idAbogado);

create index idCliente
    on caso (idCliente, idAbogado);

create index idJuzgado
    on caso (idJuzgado);

create table juez
(
    id        int          not null auto_increment,
    cedula    int          not null,
    nombres   varchar(100) not null,
    apellidos varchar(100) not null,
    email     varchar(100) not null,
    telefono  varchar(18)  not null,
    direccion varchar(100) not null,
    tarjetap  int          not null,
    idJusgado int          not null,
    primary key (id),
    constraint juez_ibfk_1
        foreign key (idJusgado) references juzgado (id)
);

create index idJusgado
    on juez (idJusgado);

create table servicio
(
    idServicio     int         not null auto_increment,
    nombreServicio varchar(50) not null,
    valorServicio  int         not null,
    primary key (idServicio)
);

create table serviciocaso
(
    idcaso         int not null,
    idservicio     int not null,
    idServicioCaso int not null
        primary key,
    constraint serviciocaso_ibfk_1
        foreign key (idcaso) references caso (id),
    constraint serviciocaso_ibfk_2
        foreign key (idservicio) references servicio (idServicio)
);

create table factura
(
    id             int  not null auto_increment,
    idservicioCaso int  not null,
    fechaFactura   date not null,
    primary key (id),
    constraint factura_ibfk_1
        foreign key (idservicioCaso) references serviciocaso (idServicioCaso)
);

create index idservicioCaso
    on factura (idservicioCaso);

create index idcaso
    on serviciocaso (idcaso, idservicio);

create index idservicio
    on serviciocaso (idservicio);

