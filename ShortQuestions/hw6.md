# Database
## MySQL
1. Create oms_company_address table
```

+---------------------+
| Tables_in_company   |
+---------------------+
| oms_company_address |
+---------------------+

mysql> CREATE TABLE IF NOT EXISTS `oms_company_address`(
    -> `id` BIGINT UNSIGNED AUTO_INCREMENT,
    -> `address_name` VARCHAR(200) ,
    -> `send_status` INT(1),
    -> `receive_status` INT(1),
    -> `name` VARCHAR(64),
    -> `phone` VARCHAR(64),
    -> `province` VARCHAR(64),
    -> `city` VARCHAR(64),
    -> `region` VARCHAR(64),
    -> `detail_address` VARCHAR(200),
    -> PRIMARY KEY(`id`)
    -> )ENGINE=InnoDB DEFAULT CHARSET=utf8;

    mysql> show columns from oms_company_address;
+----------------+-----------------+------+-----+---------+----------------+
| Field          | Type            | Null | Key | Default | Extra          |
+----------------+-----------------+------+-----+---------+----------------+
| id             | bigint unsigned | NO   | PRI | NULL    | auto_increment |
| address_name   | varchar(200)    | YES  |     | NULL    |                |
| send_status    | int             | YES  |     | NULL    |                |
| receive_status | int             | YES  |     | NULL    |                |
| name           | varchar(64)     | YES  |     | NULL    |                |
| phone          | varchar(64)     | YES  |     | NULL    |                |
| province       | varchar(64)     | YES  |     | NULL    |                |
| city           | varchar(64)     | YES  |     | NULL    |                |
| region         | varchar(64)     | YES  |     | NULL    |                |
| detail_address | varchar(200)    | YES  |     | NULL    |                |
+----------------+-----------------+------+-----+---------+----------------+


```


2. Insert some random data to oms_company_address table
```
INSERT INTO oms_company_address
    -> (id,address_name,send_status,receive_status,name,phone,province,city,region,detail_address)
    -> VALUES
    -> ("1","7788 redwood","0","0","Lee","999","CA","SF","West","Test1"),
    -> ("2","53456 yellowstond","1","1","Tim","888","NC","TR","mid-west","Test2"),
    -> ("3","5235 underwood","0","1","Te","777","CA","LA","West","Test3"),
    -> ("4","4525 timeout","1","0","Yu","666","CA","SB","West","Test4"),
    -> ("5","424 nowhere","0","0","Er","555","PA","FA","East","Test5");






+----+-------------------+-------------+----------------+------+-------+----------+------+----------+----------------+
| id | address_name      | send_status | receive_status | name | phone | province | city | region   | detail_address |
+----+-------------------+-------------+----------------+------+-------+----------+------+----------+----------------+
|  1 | 7788 redwood      |           0 |              0 | Lee  | 999   | CA       | SF   | West     | Test1          |
|  2 | 53456 yellowstond |           1 |              1 | Tim  | 888   | NC       | TR   | mid-west | Test2          |
|  3 | 5235 underwood    |           0 |              1 | Te   | 777   | CA       | LA   | West     | Test3          |
|  4 | 4525 timeout      |           1 |              0 | Yu   | 666   | CA       | SB   | West     | Test4          |
|  5 | 424 nowhere       |           0 |              0 | Er   | 555   | PA       | FA   | East     | Test5          |
+----+-------------------+-------------+----------------+------+-------+----------+------+----------+----------------+
```




3. Write a SQL query to fetch all data from oms_company_address `table
```
SELECT * FROM company.oms_company_address;



/**************************/
+----+-------------------+-------------+----------------+------+-------+----------+------+----------+----------------+
| id | address_name      | send_status | receive_status | name | phone | province | city | region   | detail_address |
+----+-------------------+-------------+----------------+------+-------+----------+------+----------+----------------+
|  1 | 7788 redwood      |           0 |              0 | Lee  | 999   | CA       | SF   | West     | Test1          |
|  2 | 53456 yellowstond |           1 |              1 | Tim  | 888   | NC       | TR   | mid-west | Test2          |
|  3 | 5235 underwood    |           0 |              1 | Te   | 777   | CA       | LA   | West     | Test3          |
|  4 | 4525 timeout      |           1 |              0 | Yu   | 666   | CA       | SB   | West     | Test4          |
|  5 | 424 nowhere       |           0 |              0 | Er   | 555   | PA       | FA   | East     | Test5          |
+----+-------------------+-------------+----------------+------+-------+----------+------+----------+----------------+
```
4. Write a SQL query to fetch top 3 records from oms_company_address table
```
SELECT * FROM company.oms_company_address LIMIT 3;




+----+-------------------+-------------+----------------+------+-------+----------+------+----------+----------------+
| id | address_name      | send_status | receive_status | name | phone | province | city | region   | detail_address |
+----+-------------------+-------------+----------------+------+-------+----------+------+----------+----------------+
|  1 | 7788 redwood      |           0 |              0 | Lee  | 999   | CA       | SF   | West     | Test1          |
|  2 | 53456 yellowstond |           1 |              1 | Tim  | 888   | NC       | TR   | mid-west | Test2          |
|  3 | 5235 underwood    |           0 |              1 | Te   | 777   | CA       | LA   | West     | Test3          |
+----+-------------------+-------------+----------------+------+-------+----------+------+----------+----------------+
```
5. Update oms_company_address table to set all phoneto 666-6666-8888
```
UPDATE company.oms_company_address SET phone = "666-6666-8888";



+----+-------------------+-------------+----------------+------+---------------+----------+------+----------+----------------+
| id | address_name      | send_status | receive_status | name | phone         | province | city | region   | detail_address |
+----+-------------------+-------------+----------------+------+---------------+----------+------+----------+----------------+
|  1 | 7788 redwood      |           0 |              0 | Lee  | 666-6666-8888 | CA       | SF   | West     | Test1          |
|  2 | 53456 yellowstond |           1 |              1 | Tim  | 666-6666-8888 | NC       | TR   | mid-west | Test2          |
|  3 | 5235 underwood    |           0 |              1 | Te   | 666-6666-8888 | CA       | LA   | West     | Test3          |
|  4 | 4525 timeout      |           1 |              0 | Yu   | 666-6666-8888 | CA       | SB   | West     | Test4          |
|  5 | 424 nowhere       |           0 |              0 | Er   | 666-6666-8888 | PA       | FA   | East     | Test5          |
+----+-------------------+-------------+----------------+------+---------------+----------+------+----------+----------------+
									
```
6. Delete one entry from oms_company_address table
```
DELETE FROM company.oms_company_address WHERE id = 5;




+----+-------------------+-------------+----------------+------+---------------+----------+------+----------+----------------+
| id | address_name      | send_status | receive_status | name | phone         | province | city | region   | detail_address |
+----+-------------------+-------------+----------------+------+---------------+----------+------+----------+----------------+
|  1 | 7788 redwood      |           0 |              0 | Lee  | 666-6666-8888 | CA       | SF   | West     | Test1          |
|  2 | 53456 yellowstond |           1 |              1 | Tim  | 666-6666-8888 | NC       | TR   | mid-west | Test2          |
|  3 | 5235 underwood    |           0 |              1 | Te   | 666-6666-8888 | CA       | LA   | West     | Test3          |
|  4 | 4525 timeout      |           1 |              0 | Yu   | 666-6666-8888 | CA       | SB   | West     | Test4          |
+----+-------------------+-------------+----------------+------+---------------+----------+------+----------+----------------+
```
## MongDB

1. Create testDB
```
use test
```
2. Create oms_company_address collection (method: createCollection() )
```
db.createCollection("oms_company_address")
```
3. Insert few random entries to oms_company_address collection (method: insert() )
```
db.oms_company_address.insertOne({ 
    id: "1", 
    address_name: "7788 redwood", 
    send_statur: "0", 
    receive_status: "0", 
    name: "Lee", 
    phone: "999", 
    province: "CA", 
    city: "SF", 
    region: "West", 
    detail_address: "Test1" })
```
4. Read one entry from oms_company_address collection (method: find() )
```
db.oms_company_address.find({id: "1"})
```
5. Read all entries from oms_company_address collection (method: find() )
```
db.oms_company_address.find()
```
6. Update one entry from oms_company_addresscollection (method: update() or save() )
```
db.oms_company_address.updateOne({ "phone": "999"}, {$set:{"phone":"666-888"}} )
```
7. Remove one entry from oms_company_addresscollection (method: remove() )
```
db.oms_company_address.deleteOne({"id" : "1"})
```





# Postman

### 5 GET APIs with different response type

- GET https://ghibliapi.herokuapp.com/films?id=12cfb892-aac0-4c5b-94af-521852e46d6a

RequestBody: N/A, since it is GET

Response status: 200 OK

Response:
```
[
    {
        "id": "12cfb892-aac0-4c5b-94af-521852e46d6a",
        "title": "Grave of the Fireflies",
        "original_title": "鳶晶月及贏",
        "original_title_romanised": "Hotaru no haka",
        "image": "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qG3RYlIVpTYclR9TYIsy8p7m7AT.jpg",
        "movie_banner": "https://image.tmdb.org/t/p/original/vkZSd0Lp8iCVBGpFH9L7LzLusjS.jpg",
        "description": "In the latter part of World War II, a boy and his sister, orphaned when their mother is killed in the firebombing of Tokyo, are left to survive on their own in what remains of civilian life in Japan. The plot follows this boy and his sister as they do their best to survive in the Japanese countryside, battling hunger, prejudice, and pride in their own quiet, personal battle.",
        "director": "Isao Takahata",
        "producer": "Toru Hara",
        "release_date": "1988",
        "running_time": "89",
        "rt_score": "97",
        "people": [
            "https://ghibliapi.herokuapp.com/people/"
        ],
        "species": [
            "https://ghibliapi.herokuapp.com/species/af3910a6-429f-4c74-9ad5-dfe1c4aa04f2"
        ],
        "locations": [
            "https://ghibliapi.herokuapp.com/locations/"
        ],
        "vehicles": [
            "https://ghibliapi.herokuapp.com/vehicles/"
        ],
        "url": "https://ghibliapi.herokuapp.com/films/12cfb892-aac0-4c5b-94af-521852e46d6a"
    }
]
```
- GET https://ghibliapi.herokuapp.com/films/200
Response status: 404 Not Found
Response:
```
{}
```

- GET https://ghibliapi.herokuapp.com/people/?name=Haku
Response status: 200 OK

Response:
```
[
    {
        "id": "267649ac-fb1b-11eb-9a03-0242ac130003",
        "name": "Haku",
        "gender": "Male",
        "age": "12",
        "eye_color": "Green",
        "hair_color": "Green",
        "films": [
            "https://ghibliapi.herokuapp.com/films/dc2e6bd1-8156-4886-adff-b39e6043af0c"
        ],
        "species": "https://ghibliapi.herokuapp.com/species/e2cfaa78-fb19-11eb-9a03-0242ac130003",
        "url": "https://ghibliapi.herokuapp.com/people/267649ac-fb1b-11eb-9a03-0242ac130003"
    }
]
```

- GET https://ghibliapi.herokuapp.com/people/?eye_color=Grey&hair_color=Bald, but beard is Brown
Response status: 200 OK

Response:

```
[
    {
        "id": "8bccdc78-545b-49f4-a4c8-756163a38c91",
        "name": "Gonza",
        "gender": "Male",
        "age": "Adult",
        "eye_color": "Grey",
        "hair_color": "Bald, but beard is Brown",
        "films": [
            "https://ghibliapi.herokuapp.com/films/0440483e-ca0e-4120-8c50-4c8cd9b965d6"
        ],
        "species": "https://ghibliapi.herokuapp.com/species/af3910a6-429f-4c74-9ad5-dfe1c4aa04f2",
        "url": "https://ghibliapi.herokuapp.com/people/8bccdc78-545b-49f4-a4c8-756163a38c91"
    }
]
```

- GET https://ghibliapi.herokuapp.com/locations/11014596-71b0-4b3e-b8c0-1c4b15f28b9a
Response status: 200 OK

Response:
```
{
    "id": "11014596-71b0-4b3e-b8c0-1c4b15f28b9a",
    "name": "Irontown",
    "climate": "Continental",
    "terrain": "Mountain",
    "surface_water": "40",
    "residents": [
        "https://ghibliapi.herokuapp.com/people/ba924631-068e-4436-b6de-f3283fa848f0",
        "https://ghibliapi.herokuapp.com/people/030555b3-4c92-4fce-93fb-e70c3ae3df8b"
    ],
    "films": [
        "https://ghibliapi.herokuapp.com/films/0440483e-ca0e-4120-8c50-4c8cd9b965d6"
    ],
    "url": "https://ghibliapi.herokuapp.com/locations/11014596-71b0-4b3e-b8c0-1c4b15f28b9a"
}
```

### 5 Post API with json request body, please also paste the response here

- POST https://ghibliapi.herokuapp.com/locations
RequestBody:
```
{
    "id": "12345",
    "name": "TEST1",
    "age": "10"
}
```

Response status: 201 Created
Response:
```
{
    "id": 12345,
    "name": "TEST1",
    "age": 10
}
```

- POST https://ghibliapi.herokuapp.com/locations
RequestBody:
```
{
    "name": "TEST2",
    "age": "111",
    "surface_water": "20"
}
```
Response status: 201 Created
Response:
```
{
    "name": "TEST2",
    "age": 111,
    "surface_water": 20,
    "id": "ffffde60-4af5-4823-bbdc-fa3c5d260623"
}
```


- POST https://ghibliapi.herokuapp.com/vehicles
RequestBody:
```
{
    "name": "X6",
    "vehicle_class": "BMW"
}
```
Response status: 201 Created
Response:
```
{
    "name": "X6",
    "vehicle_class": "BMW",
    "id": "0532ad9e-ef9f-43e1-9005-f31598dbc496"
}
```


- POST https://ghibliapi.herokuapp.com/films
RequestBody:
```
{
    "name": "none",
    "title": "blank"
}
```
Response status: 201 Created
Response:
```
{
    "name": "none",
    "title": "blank",
    "id": "ff56d123-3292-42ed-8a0f-9df6a2296ef1"
}
```


- POST https://ghibliapi.herokuapp.com/v2/checkout/orders
RequestBody:
```
{
    "name": "vettt"
 
}
```
Response status: 404 Not Found
Response:
```
{}
```

### 3 PUT API with json request body, please also paste the response here
- PUT https://ghibliapi.herokuapp.com/locations/11014596-71b0-4b3e-b8c0-1c4b15f28b9a
RequestBody:
```
{
    "name": "Test1",
    "climate": "Continental",
    "terrain": "Mountain",
    "surface_water": "20",
    "residents": [
        "https://ghibliapi.herokuapp.com/people/ba924631-068e-4436-b6de-f3283fa848f0",
        "https://ghibliapi.herokuapp.com/people/030555b3-4c92-4fce-93fb-e70c3ae3df8b"
    ],
    "films": [
        "https://ghibliapi.herokuapp.com/films/0440483e-ca0e-4120-8c50-4c8cd9b965d6"
    ],
    "url": "https://ghibliapi.herokuapp.com/locations/11014596-71b0-4b3e-b8c0-1c4b15f28b9a"
}
```
Response status: 200 OK
Response:
```
{
    "name": "Test1",
    "climate": "Continental",
    "terrain": "Mountain",
    "surface_water": 20,
    "residents": [
        "https://ghibliapi.herokuapp.com/people/ba924631-068e-4436-b6de-f3283fa848f0",
        "https://ghibliapi.herokuapp.com/people/030555b3-4c92-4fce-93fb-e70c3ae3df8b"
    ],
    "films": [
        "https://ghibliapi.herokuapp.com/films/0440483e-ca0e-4120-8c50-4c8cd9b965d6"
    ],
    "url": "https://ghibliapi.herokuapp.com/locations/11014596-71b0-4b3e-b8c0-1c4b15f28b9a",
    "id": "11014596-71b0-4b3e-b8c0-1c4b15f28b9a"
}
```


- PUT https://ghibliapi.herokuapp.com/locations/64a996aa-481e-4627-9624-ab23f59a05a9
RequestBody:
```
{
    "terrain": "Test2"
   
}
```
Response status: 200 OK
Response:
```
{
    "terrain": "Test2",
    "id": "64a996aa-481e-4627-9624-ab23f59a05a9"
}
```


- PUT https://ghibliapi.herokuapp.com/locations/6565
RequestBody:
```
{
    "name": "Test3"
   
}

```
Response status: 404 Not Found
Response:
```
{}
```

### 2 DELETE API
- DELETE https://ghibliapi.herokuapp.com/locations/64a996aa-481e-4627-9624-ab23f59a05a9
Response status: 200 OK

- DELETE https://ghibliapi.herokuapp.com/locations
Response status: 404 Not Found

### Each example with 404, 401,500 and any http status codes you know
- 100 Continue
- 101 Switching Protocols
- 102 Processing


- 200 每 OK
- 201 每 Created
- 202 每 Accepted
- 203 每 Non-Authoritative Information
- 204 每 No Content
- 205 每 Reset Content
- 206 每 Partial Content
- 207 每 Multi-Status
- 208 每 Already Reported
- 226 每 IM Used

- 300 每 Multiple Choices
- 301 每 Moved Permanently
- 302 每 Found
- 303 每 Check Other
- 304 每 Not Modified
- 305 每 Use Proxy
- 306 每 Switch Proxy
- 307 每 Temporary Redirect
- 308 每 Permanent Redirect

- 400 每 Bad Request
- 401 每 Unauthorised
- 402 每 Payment Required
- 403 每 Forbidden
- 404 每 Not Found
- 405 每 Method Not Allowed
- 406 每 Not Acceptable
- 407 每 Proxy Authentication Required
- 408 每 Request Timeout
- 409 每 Conflict

- 500 每 Internal Server Error
- 501 每 Not Implemented
- 502 每 Bad Gateway
- 503 每 Service Unavailable
- 504 每 Gateway Timeout



## API
### Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc
- Twitter: 
  - Single Tweet: GET https://api.twitter.com/2/tweets/:id
  - Multiple Tweets: GET https://api.twitter.com/2/tweets?ids=
  - Follow a user ID: POST https://api.twitter.com/2/users/:id/following
  - Unblock a user ID: DELETE https://api.twitter.com/2/users/:source_user_id/blocking/:target_user_id
- Youtube: 
  - Get Media Resource Name: GET https://www.googleapis.com/youtube/v1/media/:resourceName
  - Add Video Rate: POST https://www.googleapis.com/youtube/v1/videos/rate?id=<*parameters*>&rating<*post*> 
  - Delete Comments: DELETE https://www.googleapis.com/youtube/v1/comments?id=<*parameters*>
### Design a collection of APIS for a Blog Website, please specify GET POST PUT DELETE
- https://www.Blog.com
- GET https://www.Blog.com/users-management/1/users/:id
- POST https://www.Blog.com/users-management/2/users
- PUT https://www.Blog.com/users-management/users/:id/test
 - DELETE https://www.Blog.com/users-management/users/:id