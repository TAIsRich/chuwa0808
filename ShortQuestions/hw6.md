#HW6
## DATA BASE
### Exercise
1.	Create oms_company_address table
2.	Insert some random data to oms_company_address table
3.	Write a SQL query to fetch all data from oms_company_address `table
4.	Write a SQL query to fetch top 3 records from oms_company_address table
5.	Update oms_company_address table to set all phoneto 666-6666-8888
6.	Delete one entry from oms_company_address table
7.	(Optional) You can also try to create other tables that listed above
```
CREATE DATABASE test;

USE test;

CREATE TABLE oms_company_address(id bigint primary key,
				address_name varchar(200),
                                send_status int(1),
                                receive_status int(1),
                                name varchar(64),
                                phone varchar(64),
                                province varchar(64),
                                city varchar(64),
                                region varchar(64),
                                detail_address varchar(200));

insert into oms_company_address
values (00134, '101 ny street', 1, 1, 'AA', '0213451111', 'bj', 'bj', 'bj', 'good');

insert into oms_company_address
values (00139, '34 pa street', 1, 0, 'BB', '0119875644', 'sh', 'sh', 'sh', 'good');

insert into oms_company_address
values (00287, '77 sf street', 0, 1, 'UU', '1111111111', 'sb', 'sb', 'sb', 'bad');

insert into oms_company_address
values (00666, '78 atl street', 1, 1, 'GO', '9876543589', 'yes', 'ues', 'aj', 'good');

select * from oms_company_address;

select * from oms_company_address
limit 3;

set SQL_SAFE_UPDATES = 0;
update oms_company_address set phone = '666-6666-8888';
set SQL_SAFE_UPDATES = 1;

set SQL_SAFE_UPDATES = 0;
delete from oms_company_address where province = 'sb';
set SQL_SAFE_UPDATES = 1;

select * from oms_company_address;
```

### MongoDB - Non-SQL Database
### Exercise
1.	Create testDB
2.	Create oms_company_address collection (method: createCollection() )
3.	Insert few random entries to oms_company_address collection (method: insert() )
4.	Read one entry from oms_company_address collection (method: find() )
5.	Read all entries from oms_company_address collection (method: find() )
6.	Update one entry from oms_company_addresscollection (method: update() or save() )
7.	Remove one entry from oms_company_addresscollection (method: remove() )
8.	(Optional) You can also try to create other tables that listed above
```
use testDB

db.createCollection(“oms_company_address”);

db.oms_company_address.insertMany([{
	“address_name” : “aa”,
	“send_status” : 1,
	“receive status” : 1,
	“name” : “dde”,
	“phone”: “123455673452”,
	“province”: “bj”,
	“city”: “bj”,
	“region”: “sc”,
	“detail_address”: “dadfadva12”
}, {
	“address_name” : “cr”,
	“send_status” : 1,
	“receive status” : 0,
	“name” : “adf”,
	“phone”: “136459373025”,
	“province”: “sh”,
	“city”: “sh”,
	“region”: “ae”,
	“detail_address”: “ohmygod12”
}, {
	“address_name” : “ct”,
	“send_status” : 0,
	“receive status” : 0,
	“name” : “sef”,
	“phone”: “9872358764”,
	“province”: “sc”,
	“city”: “sc”,
	“region”: “iu”,
	“detail_address”: “afdfdf98”
}, {
	“address_name” : “op”,
	“send_status” : 0,
	“receive status” : 1,
	“name” : “aff”,
	“phone”: “6668889999”,
	“province”: “nb”,
	“city”: “nb”,
	“region”: “haha”,
	“detail_address”: “adfadfau38”
}])

db.oms_company_address.find({“city”: “nb”}).pretty();

db.oms_company_address.find().update({name: “sef”}, {$set: {phone: “6666666666”}})

db.oms_company_address.remove({“city”: ”nb”}, true)
```

## Postman
take below examples,
- 5 GET APIs with different response type
- 5 Post API with json request body, please also paste the response here
- 3 PUT API with json request body, please also paste the response here
- 2 DELETE API
- Each example with 404, 401,500 and any http status codes you know

### GET
- `200 OK`: `GET https://ghibliapi.herokuapp.com/species`
- `404 Not Found`: `GET https://ghibliapi.herokuapp.com/species/300`
- `200 OK`: `GET https://reqres.in/api/users?page=4`
- `404 Not Found`: `GET https://reqres.in/api/users/50`
- `401 Unauthored`: `GET https://api.getpostman.com/scim/v2/Users`

### POST

- `201 Created`: `POST https://reqres.in/api/users`
```
// request body
{
    "name": "spectre",
    "job": "SDE"
}

// response
{
    "name": "spectre",
    "job": "SDE",
    "id": "280",
    "createdAt": "2022-08-22T15:22:59.651Z"
}
```
- `200 OK`: `POST https://reqres.in/api/login`
```
// request body
{
  "email": "eve.holt@reqres.in",
  "password": "pistol"
}

// response
{
    "id": 4,
    "token": "QpwL5tke4Pnpja7X4"
}
```
- `400 Bad Request`: `POST https://reqres.in/api/register`
```
// request body
{
  "email": "niub@gmail.com",
  "password": "goodjob"
}

// response
{
    "error": "Note: Only defined users succeed registration"
}
```

### PUT
- `200 OK` : `PUT https://reqres.in/api/users/1`
```
// request body
{
    "name": "bill",
    "job": "CEO"
}

//. Response
{
    "name": "bill",
    "job": "CEO",
    "updatedAt": "2022-08-22T15:35:34.516Z"
}
```
- `404 Not Found`: `PUT https://api.getpostman.com/scim/v2/Users`
```// request body
{
    "name": "sb",
    "job": "no job"
}

// response
{
    "error": {
        "name": "NotFound",
        "message": "We can't seem to find what you are looking for."
    },
    "status": "error"
}
```

### DELETE
- `204 No Content`: `DELETE https://reqres.in/api/users/1`
```// reponse
1
```

## API
### 1. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范

- **Notion API**:[Reference]( https://www.postman.com/notionhq/workspace/notion-s-api-workspace/collection/15568543-d990f9b7-98d3-47d3-9131-4866ab9c6df2?action=share&creator=22935406)
```
List all users: GET https://api.notion.com/v1/users
Create a databse: POST https://api.notion.com/v1/databases/
Update a databse: PATCH https://api.notion.com/v1/databases/:id
Create a Page with Content: POST https://api.notion.com/v1/pages/
Delete a Page: DELETE https://api.notion.com/v1/blocks/:id
Search: POST https://api.notion.com/v1/search
Add comment to a page: POST https://api.notion.com/v1/comments
```



- **Youtube API**[Reference](https://www.postman.com/api-evangelist/workspace/youtube/collection/35240-0bdca8cb-a591-4d01-90eb-dc36f5720cac?action=share&creator=22935406)
```
Get Media Resource Name: GET {{baseUrl}}/v1/media/:resourceName
Get Captions: GET {{baseUrl}}/captions/:id?onBehalfOf=<>&onBehalfOfContentOwner=<>&tfmt=<>&tlang=<>
Delete Captions: DELETE {{baseUrl}}/captions?id=<parameters>&onBehalfOf=<>&onBehalfOfContentOwner=<>
Add comments Set Moderation Status: POST {{baseUrl}}/comments/setModerationStatus?banAuthor=<>&id=<parameters>&moderationStatus=<post>
Delete Live Chat Messages: DELETE {{baseUrl}}/liveChat/messages?id=<parameters>
Get Videos Get Rating: GET {{baseUrl}}/videos/getRating?id=<parameters>&onBehalfOfContentOwner=<>
Get Languages: GET {{baseUrl}}/i18nLanguages?hl=<post>&part=<>
```

### 2. Design a collection of APIS for a Blog Website, please specify GET POST PUT DELETE
```
Receive a blog: GET https://www.googleapis.com/blogger/v3/blogs/blogId

Retrieving a blog by its URL: GET https://www.googleapis.com/blogger/v3/blogs/byurl?url=blog-url

Retrieve a user’s blogs: GET https://www.googleapis.com/blogger/v3/users/userId/blogs

Search for a post: GET  https://www.googleapis.com/blogger/v3/blogs/blogId/posts/search?q=query terms

Adding a post: POST  https://www.googleapis.com/blogger/v3/blogs/blogId/posts/

Deleting a post: DELETE  https://www.googleapis.com/blogger/v3/blogs/blogId/posts/postId

Updating a post: PUT https://www.googleapis.com/blogger/v3/blogs/blogId/posts/postId

Retrieving comments for a post: GET https://www.googleapis.com/blogger/v3/blogs/blogId/posts/postId/comments
```
