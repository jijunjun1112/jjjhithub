1���½���ͱ�����
create database day14 character set utf8 collate utf8_general_ci;

use day14;

create table users(
	id int primary key,
	name varchar(40),
	password varchar(40),
	email varchar(60),
	birthday date
);

insert into users(id,name,password,email,birthday) values(1,'zs','123456','zs@sina.com','1980-12-04');
insert into users(id,name,password,email,birthday) values(2,'lisi','123456','lisi@sina.com','1981-12-04');
insert into users(id,name,password,email,birthday) values(3,'wangwu','123456','wangwu@sina.com','1979-12-04');


1.��������
2�����������ݿ������
3���õ����������ݿⷢ��sql���� statement
4�������ݿⷢsql�����õ�����������resultset
5����resultset��ȡ����
6���ر����ӡ��ͷ���Դ
