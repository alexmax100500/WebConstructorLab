-- auto-generated definition
create table t_figure
(
  id   serial      not null
    constraint t_figure_pkey
      primary key,
  path text        not null,
  type figure_type not null,
  quarter integer not null,
  rx real not null,
  ry real not null
);

create type figure_type as enum ('triangle', 'square', 'circle', 'emptiness');

alter table t_figure
    owner to postgres;

