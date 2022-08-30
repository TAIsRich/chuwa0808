#### Database

#### MySQL

1. Create oms_company_address table

   CREATE TABLE oms_company_address(id bigint primary key,address_name varchar(200),name varchar(64),phone varchar(64));

2. Insert some random data to oms_company_address table

   insert into oms_company_address values (00001, '600 epic st', 'Tom', '1111111111');

3. Write a SQL query to fetch all data from oms_company_address `table

   select * from oms_company_address;

4. Write a SQL query to fetch top 3 records from oms_company_address table

   select * from oms_company_address limit 3;

5. Update oms_company_address table to set all phoneto 666-6666-8888

   update oms_company_address set phone = 666-6666-8888;

6. Delete one entry from oms_company_address table

   delete from oms_company_address where id = 00001;

```
-- create database shopping
-- use shopping;
-- create table oms_company_address(id bigint primary key,address_name varchar(200),name varchar(64),phone varchar(64));
-- insert into oms_company_address values (00001, '600 epic st', 'Tom', '1111111111');
-- insert into oms_company_address values (00002, '500 epic st', 'Jam', '1111111111');
-- insert into oms_company_address values (00003, '400 epic st', 'John', '1111111111');
-- insert into oms_company_address values (00004, '300 epic st', 'Frank', '1111111111');

-- select * from oms_company_address limit 3;
-- update oms_company_address set phone = 123;
delete from oms_company_address where id = 00001;
```

#### MongoDB

1. Create testDB
   - use testDB
2. Create oms_company_address collection (method: createCollection())
   - db.createCollection("oms_company_address")
3. Insert few random entries to oms_company_address collection (method: insert())
   - db.oms_company_address.insert({address:"a ave", name: 'Luis', phone:"2222222222" })
4. Read one entry from oms_company_address collection (method: find())
   - db.oms_company_address.findOne({"id":00001});
5. Read all entries from oms_company_address collection (method: find())
   - db.oms_company_address.find({"name":"Tom"}).pretty;
6. Update one entry from oms_company_addresscollection (method: update() or save())
   - db.oms_company_address.update({"name":"Luis"},{$set:{phone:"3333333333"}});
7. Remove one entry from oms_company_addresscollection (method: remove())
   - db.oms_company_address.remove({"name":"Luis"})

### REST API

- 5 GET APIs with different response type
- 5 Post API with json request body, please also paste the response here
- 3 PUT API with json request body, please also paste the response here
- 2 DELETE API
- Each example with 404, 401,500 and any http status codes you know

#### GET

- `200 OK`: `GET https://reqres.in/api/users/2`
- `200 OK`: `GET https://reqres.in/api/users?page=2`
- `404 Not Found`: `GET https://reqres.in/api/users/23`
- `400 Bad Request`

#### POST

- `201 Created`: `POST https://reqres.in/api/users`

  ```
  // request body
  {
      "name": "morpheus",
      "job": "leader"
  }
  
  // response
  {
    "name": "morpheus",
    "job": "leader",
    "id": "431",
    "createdAt": "2022-08-21T23:24:00.893Z"
  }
  ```

- `200 OK`: `POST https://reqres.in/api/register`

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
      "email": "sydney@fife"
  }
  
  // response
  {
      "error": "Missing password"
  }
  ```

- `200 OK`: `POST https://reqres.in/api/login`

  ```
  // request body
  {
    "email": "eve.holt@reqres.in",
    "password": "cityslicka"
  }
  
  // response
  {
      "token": "QpwL5tke4Pnpja7X4"
  }
  ```

#### PUT

- `200 OK` : `PUT https://reqres.in/api/users/2`

  ```
  // request body
  {
      "name": "morpheus",
      "job": "zion resident"
  }
  
  // response
  {
      "name": "morpheus",
      "job": "zion resident",
      "updatedAt": "2022-08-21T23:27:44.324Z"
  }
  ```

- `404 Not Found`: `PUT https://api.getpostman.com/scim/v2/Users`

  ```
  // request body
  null
  
  // response
  {
      "error": {
          "name": "NotFound",
          "message": "We can't seem to find what you are looking for."
      },
      "status": "error"
  }
  ```

#### DELETE

- `204 No Content`: `DELETE https://reqres.in/api/users/2`

  ```
  // response
  null
  ```

- `204 No Content`: `DELETE https://reqres.in/api/users`

  ```
  // response
  null
  ```

### API

#### Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范

- Youtube:
  - Get Activities: `GET {{baseUrl}}/activities?channelId=<post>&home=<>&maxResults=<>&mine=<>&pageToken=<>&part=<>&publishedAfter=<>&publishedBefore=<>®ionCode=<post>`
  - Get Channels: `GET {{baseUrl}}/channels?categoryId=<post>&forUsername=<>&hl=<post>&id=<parameters>&managedByMe=<>&maxResults=<>&mine=<>&mySubscribers=<>&onBehalfOfContentOwner=<>&pageToken=<>&part=<>`
  - Get Search: `GET {{baseUrl}}/search?channelId=<post>&channelType=<>&eventType=<>&forContentOwner=<>&forDeveloper=<>&forMine=<>&location=<>&locationRadius=<>&maxResults=<>&onBehalfOfContentOwner=<>&order=<>&pageToken=<>&part=<>&publishedAfter=<>&publishedBefore=<>&q=<>®ionCode=<post>&relatedToVideoId=<>&relevanceLanguage=<>&safeSearch=<>&topicId=<>&type=<post>&videoCaption=<>&videoCategoryId=<>&videoDefinition=<>&videoDimension=<>&videoDuration=<>&videoEmbeddable=<>&videoLicense=<>&videoSyndicated=<>&videoType=<>`
  - Add Videos Rate: `POST {{baseUrl}}/videos/rate?id=<parameters>&rating=<post>`
  - Delete Playlists: `DELETE {{baseUrl}}/playlists?id=<parameters>&onBehalfOfContentOwner=<>`
  - Delete Videos: `DELETE {{baseUrl}}/videos?id=<parameters>&onBehalfOfContentOwner=<>`
- PayPal:
  - User Info: `GET {{base_url}}/v1/identity/oauth2/userinfo?schema=paypalv1.1`
  - Create order: `POST {{base_url}}/v2/checkout/orders`
  - Show order details: `GET {{base_url}}/v2/checkout/orders/:order_id`
  - List transactions: `GET {{base_url}}/v1/reporting/transactions?fields=transaction_info,payer_info,shipping_info,auction_info,cart_info,incentive_info,store_info&start_date=2022-02-20T23:59:59.999Z&end_date=2022-03-20T00:00:00.000Z`
  - Fully update invoice: `PUT {{base_url}}/v2/invoicing/invoices/:invoice_id?send_to_recipient=true&send_to_invoicer=true`
  - Show tracking information: `GET {{base_url}}/v1/shipping/trackers/:tracking_id`

#### Design a collection of APIS for a Blog Website, please specify GET POST PUT DELETE

- **Retrieving posts from a blog**: `GET https://www.googleapis.com/blogger/v3/blogs/blogId/posts`
- **Retrieving a specific post**: `GET https://www.googleapis.com/blogger/v3/blogs/blogId/posts/postId`
- **Adding a post**: `POST https://www.googleapis.com/blogger/v3/blogs/blogId/posts/`
- **Deleting a post**: `DELETE https://www.googleapis.com/blogger/v3/blogs/blogId/posts/postId`
- **Updating a post**: `PUT https://www.googleapis.com/blogger/v3/blogs/blogId/posts/postId`
