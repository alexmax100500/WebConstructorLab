-- auto-generated definition
create table t_figure
(
    id   serial      not null
        constraint t_figure_pkey
            primary key,
    path text        not null,
    type figure_type not null,
    quarter integer not null
);

alter table t_figure
    owner to postgres;

