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
    primary key (id),
    constraint caso_abogado
        foreign key (idAbogado) references abogado (id),
    constraint caso_cliente
        foreign key (idCliente) references cliente (id) on delete cascade,
    constraint caso_juzgado
        foreign key (idJuzgado) references juzgado (id)
);

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
    constraint juez_jusgado
        foreign key (idJusgado) references juzgado (id)
);

create table servicio
(
    id     int         not null auto_increment,
    nombreServicio varchar(50) not null,
    valorServicio  int         not null,
    primary key (id)
);

create table serviciocaso
(
    id int not null auto_increment,
    idcaso         int not null,
    idservicio     int not null,
    primary key (id),
    constraint serviciocaso_caso
        foreign key (idcaso) references caso (id),
    constraint serviciocaso_servicio
        foreign key (idservicio) references servicio (id)
);

create table factura
(
    id             int  not null auto_increment,
    idservicioCaso int  not null,
    fechaFactura   date not null,
    primary key (id),
    constraint factura_ibfk_1
        foreign key (idservicioCaso) references serviciocaso (id)
);

