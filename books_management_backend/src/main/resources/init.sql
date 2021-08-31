create database booksDb;
use booksDb;
create table books(
                      name varchar(30) primary key not null ,
                      author varchar(30) not null ,
                      ISBN varchar(30) not null
)
engine = InnoDB
default character set  = utf8;

insert into books value ('你踩过天鹅尸体吗','[日]宫藤官九郎','9787572602184');
insert into books value ('太阳与铁','[日]三岛由纪夫','9787559651754');
insert into books value ('喂——出来','[日]星新一','9787544786829');
insert into books value ('没有个性的人','[奥]罗伯特·穆齐尔','9787532787685');