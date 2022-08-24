-- 1. create database
CREATE DATABASE test_oms CHARACTER SET utf8mb4;
USE test_oms;


-- 2. create 'oms_company_address' table
CREATE TABLE IF NOT EXISTS `oms_company_address` (
`id` BIGINT(20) AUTO_INCREMENT comment 'id',
`address_name` VARCHAR(200) comment '地址名称',
`send_status` INT(1) comment '默认发货地址：0->否；1->是',
`receive_status` INT(1) comment '是否默认收货地址：0->否；1->是',
`name` VARCHAR(64) comment '收发货人姓名',
`phone` VARCHAR(64) comment '收货人电话',
`province` VARCHAR(64) comment '省/直辖市',
`city` VARCHAR(64) comment '市',
`region` VARCHAR(64) comment '区',
`detail_address` VARCHAR(200) comment '详细地址',
PRIMARY KEY(`id`) USING BTREE
) ENGINE = InnoDB 
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;
 
SHOW COLUMNS FROM oms_company_address;


-- 3. insert some random data to 'oms_company_address' table
--    sql dummy data generator
INSERT INTO oms_company_address
VALUES (null, '62117 Berge Stravenue Apt. 275\nLydamouth, MA 32445-1216', 0, 0, 'Summer', '+75(0)0190092215',
        'Pennsylvania', 'Lake Daren', NULL, NULL);
INSERT INTO oms_company_address
VALUES (null, '28195 Becker River\nEast Keiratown, AL 78374', 0, 1, 'Mireille', '(807)054-0180x5068', 'Kansas',
        'Schmittchester', NULL, NULL);
INSERT INTO `oms_company_address`
VALUES (null, '92127 Arlie Square Suite 639\nPort Stephan, SD 28855-0544', 1, 1, 'Kattie', '+56(8)3627152212',
        'NewMexico', 'Hudsonville', NULL, NULL);

INSERT INTO oms_company_address 
(id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES 
(null, '77964 Aufderhar Grove Apt. 208\nPowlowskihaven, CO 91725', 1, 0, 'Kelsie', '1-937-328-0265x0387',
        'Colorado', 'Donnellyberg', NULL, NULL),
(null, '695 Alexandra Parks Suite 056\nErnserview, VT 20935', 0, 0, 'Allie', '1-069-482-3378x9318', 'Nevada',
        'Hudsonburgh', NULL, NULL),
(null, '019 Steuber Place\nPort Matilde, MN 37054-6646', 1, 1, 'Kennedy', '654-780-6240', 'Pennsylvania',
        'Alyssonshire', NULL, NULL),
(null, '921 Destany Spur\nJacobiton, ID 01212-4106', 1, 0, 'Sandra', '1-289-075-8308x263', 'Louisiana',
        'Ondrickaborough', NULL, NULL),
(null, '497 Boyer Cliff\nWest Luciousberg, MA 72817-0474', 1, 0, 'Darron', '972.755.2705', 'Colorado',
        'Anabelchester', NULL, NULL),
(null, '08928 Kulas Station\nWest Rhianna, KY 39016-1617', 0, 1, 'Oran', '606.556.4348x59603', 'California',
        'Mercedesbury', NULL, NULL),
(null, '2285 Isabel Trail Suite 342\nEast Donald, VA 58943', 0, 1, 'Jackson', '1-539-519-7702x377',
        'Tennessee', 'North Katheryn', NULL, NULL);


 -- 4. write a SQL query to fetch all data from 'oms_company_address' table
 SELECT * 
 FROM oms_company_address;
 
 
 -- 5. write a SQL query to fetch top 3 records from 'oms_company_address' table
 SELECT * 
 FROM oms_company_address 
 LIMIT 3;
 
 
 -- 6. update 'oms_company_address' table to set all phone numbers to 666-6666-8888
 UPDATE oms_company_address
 SET phone = '666-6666-8888'
 WHERE id > 0;
 
 
 -- 7. delete one entry from 'oms_company_address' table
 DELETE 
 FROM oms_company_address
 WHERE id = 4;
 
 