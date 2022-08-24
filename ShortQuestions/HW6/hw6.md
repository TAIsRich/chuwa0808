## hw6

###1. Database Exercise: CRUD in MySQL and MongoDB.
#### https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/database/DB_README.md

**MySQL:**

[MySQL CODE](./MySQL_exercise.sql)

[All Data_Table](./all_data.csv)

[Top 3 Records_Table](./top3_records.csv)

[1 Entry deletion_Table](./delete_one_entry.csv)

[All phone numbers Change_Table](./change_all_phone_numbers.csv)

**MongoDB:**

1. Create test database:
```
use test
```

2. Create oms_company_address collection (method: createCollection()):
```
db.createCollection("oms_company_address")
```

3. Insert a few random entries to oms_company_address collection (method: insert()):

**note:** id must be defined by String but not Long
```
db.oms_company_address.insertOne({
    id: "1",
    address_name: "62117 Berge Stravenue Apt. 275\\nLydamouth, MA 32445-1216",
    send_status: 0,
    receive_status: 0,
    name: "Summer",
    phone: "111-111-1111",
    province: "Pennsylvania",
    city: "Lake Daren",
    region: "test",
    detail_address: "test"
})

db.oms_company_address.insertMany([{
    id: "2",
    address_name: "92127 Arlie Square Suite 639\\nPort Stephan, SD 28855-0544",
    send_status: 1,
    receive_status: 1,
    name: "Kattie",
    phone: "111-111-1111",
    province: "NewMexico",
    city: "Hudsonville",
    region: "test",
    detail_address: "test"
    },
    {
    id: "3",
    address_name: "28195 Becker River\\nEast Keiratown, AL 78374",
    send_status: 0,
    eceive_status: 1,
    name: "Mireille",
    phone: "111-111-1111",
    province: "Kansas",
    city: "Schmittchester",
    region: "test",
    detail_address: "test"
}])
```

4. Read one entry from oms_company_address collection (method: find()):
```
db.oms_company_address.findOne({id: "1"})
db.oms_company_address.findOne({"id": "1"})
db.oms_company_address.findMany({id: "1"})
db.oms_company_address.findMany({"id": "1"})
```

5. Read all entries from oms_company_address collection (method: find()):
```
db.oms_company_address.find()
```

6. Update one entry from oms_company_address collection (method: update() or save()):
```
db.oms_company_address.updateOne({"phone": "111-111-111"}, {$set: {"phone": "666-666-888"}})
db.oms_company_address.updateMany({"phone": "111-111-111"}, {$set: {"phone": "666-666-888"}})
```

7. Remove one entry from oms_company_addresscollection (method: remove() )
```
db.oms_company_address.deleteOne({"id" : "1"})
db.oms_company_address.deleteOne({name : "Summer"})
db.oms_company_address.deleteOne({"name" : "Summer"})
db.oms_company_address.deleteMany({name : "Summer"})
db.oms_company_address.deleteMany({"name" : "Summer"})
```