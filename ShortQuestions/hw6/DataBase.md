# MySQL Practice


### Create oms_company_address table
```
CREATE TABLE `hw6`.`oms_company_address` (
  `id` BIGINT NOT NULL,
  `address_name` VARCHAR(200) NULL,
  `send_status` INT(1) NULL,
  `receive_status` INT(1) NULL,
  `name` VARCHAR(64) NULL,
  `phone` VARCHAR(64) NULL,
  `province` VARCHAR(64) NULL,
  `city` VARCHAR(64) NULL,
  `region` VARCHAR(64) NULL,
  `detail_address` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));
```

### Insert some random data to oms_company_address table
```
INSERT INTO oms_company_address VALUES (0000101, '123', 1, 1, 'Tina', 1234567, 'WA', 'Seattle', 'UW', 'qqwwee')

INSERT INTO oms_company_address VALUES (0000102, '456', 0, 0, 'Rog', 3456778, 'CA', 'Santa Clara', 'Hunter', '56dfgr');

INSERT INTO oms_company_address VALUES (0000103, '789', 0, 1, 'Pho', 456789, 'WA', 'Bothell', '612', '4e5r6t');

INSERT INTO oms_company_address VALUES (0000104, '025', 1, 0, 'Kev', 765432, 'WA', 'Bothell', '612', '4e5r6t');
```

### Write a SQL query to fetch all data from oms_company_address table
```
SELECT * FROM oms_company_address;
```

### Write a SQL query to fetch top 3 records from oms_company_address table
```
SELECT * FROM oms_company_address limit 3;
```

### Update oms_company_address table to set all phone to 666-6666-8888
```
UPDATE oms_company_address SET phone = '666-6666-8888';
```

### Delete one entry from oms_company_address table
```
delete from oms_company_address where name = 'kev';
```


# MongoDB Practice
 

### Create test DB
```
use test
```

### Create oms_company_address collection (method: createCollection() )
```
db.createCollection("oms_company_address");
```

### Insert few random entries to oms_company_address collection (method: insert() )
```
db.oms_company_address.insert({"id": 00001, "address_name" : "ABC", "send_status": 1, "receive_status": 1, "name" : "Tina", "phone" : 123456, "province" : "WA", "city" : "Seattle", "region" : "uw", "detail_address" : "123efdfg 4rfdv"});


db.oms_company_address.insert({"id": 00002, "address_name" : "DEF", "send_status": 0, "receive_status": 0, "name" : "Rog", "phone" : 234567, "province" : "WA", "city" : "Bothell", "region" : "bt", "detail_address" : "4rf 67hhng"});


db.oms_company_address.insert({"id": 00003, "address_name" : "GHI", "send_status": 0, "receive_status": 1, "name" : "Pho", "phone" : 3456789, "province" : "CA", "city" : "San Jose", "region" : "sjsu", "detail_address" : "56dfg 78gb"});
```

### Read one entry from oms_company_address collection (method: find() )
```
db.oms_company_address.find({
    name: "Tina"
  });
```

### Read all entries from oms_company_address collection (method: find() )
```
db.oms_company_address.find();
```

### Update one entry from oms_company_addresscollection (method: update() or save() )
```
db.oms_company_address.update({name : "Rog"}, {$set: {phone: 232323}});
```

### Remove one entry from oms_company_addresscollection (method: remove() )
```
db.oms_company_address.remove({name: "Pho"});
```
