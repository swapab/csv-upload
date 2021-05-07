CREATE TABLE book (
   id int not null auto_increment primary key,
   title varchar(255),
   description varchar(255),
   published_at timestamp with time zone not null
);
