
create database oms;
use oms;
create table oms_company_address(id	bigint, address_name varchar(200), send_status int(1), receive_status int(1), name varchar(64), phone varchar(64), province varchar(64), city varchar(64), region varchar(64), detail_address varchar(200), primary key(id));

insert into oms_company_address(id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) 
values(1, "Louico", 1, 1, "Lucy", "(202)364-8765", "CA", "San Jose", "San Jose", "1342 Line St, San Jose, CA, 95129");
insert into oms_company_address(id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) 
values(2, "Apple", 1, 1, "Nancy", "(205)895-5765", "CA", "San Jose", "San Jose", "1324 Line St, San Jose, CA, 95129");
insert into oms_company_address(id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) 
values(3, "MS", 1, 1, "Ben", "(209)435-1365", "CA", "San Jose", "San Jose", "1323 Line St, San Jose, CA, 95129");
insert into oms_company_address(id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) 
values(4, "Spo", 1, 1, "Paul", "(516)985-3465", "NY", "New York", "new york", "1342 Line St, New York, NY, 20034");
insert into oms_company_address(id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) 
values(5, "Amz", 1, 1, "Jason", "(202)345-5665", "CA", "San Jose", "San Jose", "1323 Line St, San Jose, CA, 95129");

select * from oms_company_address;
select  *  from oms_company_address limit 3;
update oms_company_address set phone = '666-666-8888' where id <> 0;
delete from oms_company_address where id = 1;





