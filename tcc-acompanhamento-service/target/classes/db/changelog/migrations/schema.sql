--liquibase formatted sql

--changeset nvoxland:1
create sequence banca_sequence;

--changeset nvoxland:2
alter sequence banca_sequence
  owner to postgres;

--changeset nvoxland:3
create sequence comentariobanca_sequence;

--changeset nvoxland:4
alter sequence comentariobanca_sequence
  owner to postgres;

--changeset nvoxland:5
create sequence defesa_sequence;

--changeset nvoxland:6
alter sequence defesa_sequence
  owner to postgres;

--changeset nvoxland:7
create sequence documento_sequence;

--changeset nvoxland:8
alter sequence documento_sequence
  owner to postgres;

--changeset nvoxland:9
create sequence entregatcc_sequence;

--changeset nvoxland:10
alter sequence entregatcc_sequence
  owner to postgres;

--changeset nvoxland:11
create sequence materialapoio_sequence;

--changeset nvoxland:12
alter sequence materialapoio_sequence
  owner to postgres;

--changeset nvoxland:13
create sequence tcc_sequence;

--changeset nvoxland:14
alter sequence tcc_sequence
  owner to postgres;

--changeset nvoxland:15
create table banca
(
  id             bigint  not null
    constraint banca_pkey
    primary key,
  coordenador_id integer not null,
  defesa_id      bigint
);

--changeset nvoxland:16
alter table banca
  owner to postgres;

--changeset nvoxland:17
create table banca_professores
(
  banca_id    bigint not null
    constraint fksxfb4nkcahw30kprbioo4enxv
    references banca,
  professores bigint not null
);

--changeset nvoxland:18
alter table banca_professores
  owner to postgres;

--changeset nvoxland:19
create table defesa
(
  id          bigint       not null
    constraint defesa_pkey
    primary key,
  tccid       bigint       not null,
  ambiente_id bigint       not null,
  comunicado  varchar(255) not null,
  data_hora   timestamp    not null,
  banca_id    bigint
    constraint fkl8ufb16neijpom3ilg2nf3g2r
    references banca
);

--changeset nvoxland:20
alter table defesa
  owner to postgres;

--changeset nvoxland:21
alter table banca
  add constraint fk5qu9vrxoan650yrq68dihyco8
foreign key (defesa_id) references defesa;

--changeset nvoxland:22
create table entregatcc
(
  id             bigint       not null
    constraint entregatcc_pkey
    primary key,
  tccid          bigint       not null,
  comunicado     varchar(255) not null,
  coordenador_id bigint       not null,
  data_hora_max  timestamp    not null,
  tipo_entrega   integer      not null
);

--changeset nvoxland:23
alter table entregatcc
  owner to postgres;

--changeset nvoxland:24
create table documento
(
  id            bigint       not null
    constraint documento_pkey
    primary key,
  caminho       varchar(255) not null,
  descricao     varchar(255) not null,
  titulo        varchar(255) not null,
  entregatcc_id bigint
    constraint fkjla8bxu8jsi98ssl0jwjq1ht6
    references entregatcc
);

--changeset nvoxland:25
alter table documento
  owner to postgres;

--changeset nvoxland:26
create table comentario_banca
(
  id           bigint       not null
    constraint comentario_banca_pkey
    primary key,
  comentario   varchar(255) not null,
  professor_id integer      not null,
  documento_id bigint
    constraint fk2qi81kjxyy68fsdb7xs68brav
    references documento
);

--changeset nvoxland:27
alter table comentario_banca
  owner to postgres;

--changeset nvoxland:28
create table entregatcc_documentos
(
  entregatcc_id bigint not null
    constraint fkg7xb2j3u1g9f0ukx5apbfdppr
    references entregatcc,
  documentos_id bigint not null
    constraint uk_9xabl33c0uvsxdhr2man66d31
    unique
    constraint fk8iwdy698xf85r8d4nustaamlk
    references documento
);

--changeset nvoxland:29
alter table entregatcc_documentos
  owner to postgres;

--changeset nvoxland:30
create table material_apoio
(
  id           bigint       not null
    constraint material_apoio_pkey
    primary key,
  arquivo      varchar(255) not null,
  comentario   varchar(255) not null,
  descricao    varchar(255) not null,
  link_externo varchar(255) not null
);

--changeset nvoxland:31
alter table material_apoio
  owner to postgres;

--changeset nvoxland:32
create table tcc
(
  id            bigint       not null
    constraint tcc_pkey
    primary key,
  aluno_id      bigint       not null,
  curso_id      bigint       not null,
  orientador_id bigint       not null,
  semestre      varchar(255) not null,
  statustcc     integer,
  tema          bigint       not null,
  tipo          integer,
  titulo        varchar(255) not null
);

--changeset nvoxland:33
alter table tcc
  owner to postgres;

