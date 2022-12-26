show user;

drop table web_users;

select * from web_users;

commit;

insert into web_users 
values(1,'mc','1111','นฮรถ','Admin');

insert into web_users(seq,id,password,name,role)values((select nvl(max(seq),0)+1 from web_users),1,1,1,1);