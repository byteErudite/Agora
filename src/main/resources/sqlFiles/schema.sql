

create table public.author(
author_id uuid not null,
name varchar(50),
pen_name varchar(50) null,
is_deleted bool null,
added_date timestamp null,
last_modified timestamp null,
added_by varchar(50) null,
last_modified_by varchar(50),
constraint pk_author_authorid primary key (author_id)
);

create table public.book_details(
book_detail_id uuid not null,
title varchar(100) not null,
author_id uuid not null,
category varchar(100) not null,
genre varchar(100) not null,
publication_name varchar(100) not null,
edition varchar(20),
average_rating numeric(2) not null default 0,
is_deleted bool null,
added_date timestamp null,
last_modified timestamp null,
added_by varchar(50) null,
last_modified_by varchar(50),
constraint bk_book_book_detail_id primary key (book_detail_id),
constraint fk_book_author_author_id foreign key (author_id) references author(author_id)
);

create table public.book(
book_id uuid not null,
is_available bool null default true,
is_Reserved bool null default false,
isbn varchar(100) not null,
book_detail_id uuid  not null,
is_deleted bool null,
added_date timestamp null,
last_modified timestamp null,
added_by varchar(50) null,
last_modified_by varchar(50),
constraint bk_book_book_id primary key (book_id),
constraint fk_book_book_details_book_detail_id foreign key (book_detail_id) references book_details(book_detail_id)
);



create table public.user(
user_id uuid not null,
username varchar(50) not null,
password varchar(50) not null,
email varchar(50) null,
is_active bool not null,
is_deleted bool null,
added_date timestamp null,
last_modified timestamp null,
added_by varchar(50) null,
last_modified_by varchar(50),
constraint pk_user_id primary key (user_id)
);
create unique index ix_username on public.user(username);

create table public.user_detail(
user_detail_id uuid not null,
name varchar(50) not null,
date_of_birth date not null,
student_id varchar(20) not null,
is_deleted bool null,
fathers_name varchar(50) null,
mothers_name varchar(50) null,
bloodGroup varchar(2) null,
added_date timestamp null,
last_modified timestamp null,
added_by varchar(50) null,
last_modified_by varchar(50),
constraint pk_user_detail_id primary key (user_detail_id),
constraint fk_user_detail_address_permanent_address_id foreign key (permanent_address_id ) references address(address_id ),
constraint fk_user_detail_address_current_address_id foreign key (current_address_id ) references address(address_id )
);




create table public.address(
address_id uuid not null,
address_type varchar(20) null,
locality varchar(50) not null,
area date not null,
landmark varchar(50) null,
city varchar(50) null,
state varchar(50) null,
country varchar(50) null,
pincode numeric(2),
user_detail_id uuid null,
is_deleted bool null,
added_date timestamp null,
last_modified timestamp null,
added_by varchar(50) null,
last_modified_by varchar(50),
constraint pk_address_id primary key (address_id)
constraint fk_address_user_detail_user_detail_id foreign key (user_detail_id) references public.user_detail(user_detail_id)
);

create table public.role(
role_id uuid not null,
role varchar(50) not null,
is_deleted bool null,
added_date timestamp null,
last_modified timestamp null,
added_by varchar(50) null,
last_modified_by varchar(50),
constraint pk_role_id primary key (role_id)
);

create table public.user_role(
user_role_id uuid not null,
role_id uuid not null,
user_id uuid not null,
is_deleted bool null,
added_date timestamp null,
last_modified timestamp null,
added_by varchar(50) null,
last_modified_by varchar(50),
constraint pk_user_role_id primary key (user_role_id),
constraint fk_user_role_user_user_id foreign key (user_id ) references public.user(user_id ),
constraint fk_user_role_role_role_id foreign key (role_id ) references public.role(role_id )
);
create unique index ix_user_id_role_id on user_role(user_id , role_id);



---------------------------------------------------------------------------------------------------


