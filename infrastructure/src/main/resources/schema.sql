create table brand
(
    id   bigint not null,
    name varchar(255),
    primary key (id)
);
create table pricing
(
    price       float(24)    not null,
    priority    smallint     not null,
    brand_id    bigint       not null,
    create_date timestamp(6) not null,
    end_date    timestamp(6) not null,
    product_id  bigint       not null,
    tariff_id   bigint       not null,
    id          uuid         not null,
    currency    varchar(255) check (currency in ('EUR')),
    primary key (id)
);
create table product
(
    id         bigint not null,
    additional varchar(255),
    primary key (id)
);
create table tariff
(
    id         bigint not null,
    additional varchar(255),
    primary key (id)
);
alter table if exists pricing
    add constraint brand_id_fk foreign key (brand_id) references brand;
alter table if exists pricing
    add constraint product_id_fk foreign key (product_id) references product;
alter table if exists pricing
    add constraint tariff_id_fk foreign key (tariff_id) references tariff;