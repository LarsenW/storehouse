insert into role(userType) values('ROLE_ADMIN');
insert into role(userType) values('ROLE_USER');
insert into user(email,name,password,active) values('admin@gmail.com','admin','b59c67bf196a4758191e42f76670ceba',false);
insert into user_role(user_id,role_id) values('1','1');