# Database
1. mysql
- Create oms_company_address table
  - create table oms_company_address(id int, num int, address varchar(255), phone varchar(255));
- Insert some random data to oms_company_address table
  - insert into oms_company_address(id, num, address, phone) values(1, 3002, tom dr, 12333211);
- Write a SQL query to fetch all data from oms_company_address `table
  - select * from oms_company_address;
- Write a SQL query to fetch top 3 records from oms_company_address table
  - select * from oms_company_address limit 3;
- Update oms_company_address table to set all phone to 666-6666-8888
  - update oms_company_address set phone = 666-6666-8888;
- Delete one entry from oms_company_address table
  - delete from oms_company_address where id = 1;
- (Optional) You can also try to create other tables that listed abov
2. mongodb
- Create testDB
  - use testDB
- Create oms_company_address collection (method: createCollection() )
  - db.createCollection("oms_company_address")
- Insert few random entries to oms_company_address collection (method: insert() )
  - db.oms_company_address.insert({num: 20003, address:"tom dr", phone:"123-321-1233" })
- Read one entry from oms_company_address collection (method: find() )
  - db.oms_company_address.findOne({"_id":fas12ed1df13});
- Read all entries from oms_company_address collection (method: find() )
  - db.oms_company_address.find();
- Update one entry from oms_company_addresscollection (method: update() or save() )
  - db.oms_company_address.update({"_id":asdfwer14rdf},{$set:{'num':123}});
- Remove one entry from oms_company_addresscollection (method: remove() )
  - db.oms_company_address.remove({"_id":fsawe2341e23})
(Optional) You can also try to create other tables that listed above

# Postman
1. 5 GET APIs with different response type
   1. API: GET https://ghibliapi.herokuapp.com/locations
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
    2. API: GET https://ghibliapi.herokuapp.com/films
    ```
    {
        "id": "2baf70d1-42bb-4437-b551-e5fed5a87abe",
        "title": "Castle in the Sky",
        "original_title": "天空の城ラピュタ",
        "original_title_romanised": "Tenkū no shiro Rapyuta",
        "image": "https://image.tmdb.org/t/p/w600_and_h900_bestv2/npOnzAbLh6VOIu3naU5QaEcTepo.jpg",
        "movie_banner": "https://image.tmdb.org/t/p/w533_and_h300_bestv2/3cyjYtLWCBE1uvWINHFsFnE8LUK.jpg",
        "description": "The orphan Sheeta inherited a mysterious crystal that links her to the mythical sky-kingdom of Laputa. With the help of resourceful Pazu and a rollicking band of sky pirates, she makes her way to the ruins of the once-great civilization. Sheeta and Pazu must outwit the evil Muska, who plans to use Laputa's science to make himself ruler of the world.",
        "director": "Hayao Miyazaki",
        "producer": "Isao Takahata",
        "release_date": "1986",
        "running_time": "124",
        "rt_score": "95",
        "people": [
            "https://ghibliapi.herokuapp.com/people/598f7048-74ff-41e0-92ef-87dc1ad980a9",
            "https://ghibliapi.herokuapp.com/people/fe93adf2-2f3a-4ec4-9f68-5422f1b87c01",
            "https://ghibliapi.herokuapp.com/people/3bc0b41e-3569-4d20-ae73-2da329bf0786",
            "https://ghibliapi.herokuapp.com/people/40c005ce-3725-4f15-8409-3e1b1b14b583",
            "https://ghibliapi.herokuapp.com/people/5c83c12a-62d5-4e92-8672-33ac76ae1fa0",
            "https://ghibliapi.herokuapp.com/people/e08880d0-6938-44f3-b179-81947e7873fc",
            "https://ghibliapi.herokuapp.com/people/2a1dad70-802a-459d-8cc2-4ebd8821248b"
        ],
        "species": [
            "https://ghibliapi.herokuapp.com/species/af3910a6-429f-4c74-9ad5-dfe1c4aa04f2"
        ],
        "locations": [
            "https://ghibliapi.herokuapp.com/locations/"
        ],
        "vehicles": [
            "https://ghibliapi.herokuapp.com/vehicles/4e09b023-f650-4747-9ab9-eacf14540cfb"
        ],
        "url": "https://ghibliapi.herokuapp.com/films/2baf70d1-42bb-4437-b551-e5fed5a87abe"
    },
    ```
    3. GET: https://ghibliapi.herokuapp.com/people
    ```
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
    ```
    4. GET: https://ghibliapi.herokuapp.com/species
    ```
    {
        "id": "6bc92fdd-b0f4-4286-ad71-1f99fb4a0d1e",
        "name": "Deer",
        "classification": "Elk",
        "eye_colors": "Black, Red",
        "hair_colors": "Brown, Light Orange",
        "url": "https://ghibliapi.herokuapp.com/species/6bc92fdd-b0f4-4286-ad71-1f99fb4a0d1e",
        "people": [
            "https://ghibliapi.herokuapp.com/people/030555b3-4c92-4fce-93fb-e70c3ae3df8b",
            "https://ghibliapi.herokuapp.com/people/ca568e87-4ce2-4afa-a6c5-51f4ae80a60b"
        ],
        "films": [
            "https://ghibliapi.herokuapp.com/films/0440483e-ca0e-4120-8c50-4c8cd9b965d6"
        ]
    }
    ```
    5. GET: https://ghibliapi.herokuapp.com/vehicles
    ```
    {
        "id": "4e09b023-f650-4747-9ab9-eacf14540cfb",
        "name": "Air Destroyer Goliath",
        "description": "A military airship utilized by the government to access Laputa",
        "vehicle_class": "Airship",
        "length": "1,000",
        "pilot": "https://ghibliapi.herokuapp.com/people/40c005ce-3725-4f15-8409-3e1b1b14b583",
        "films": [
            "https://ghibliapi.herokuapp.com/films/2baf70d1-42bb-4437-b551-e5fed5a87abe"
        ],
        "url": "https://ghibliapi.herokuapp.com/vehicles/4e09b023-f650-4747-9ab9-eacf14540cfb"
    }
    ```
2. 5 Post API with json request body, please also paste the response here 
    1. POST: https://httpbin.org/post with data:{"name":"yilinzhou", "type":"post", "count":1}
    result:
    ```
    {
    "args": {},
    "data": "{\n    \"name\":\"yilinzhou\",\n    \"type\":\"post\",\n    \"count\":1\n}",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Content-Length": "60",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "6503f529-0726-4317-a84f-11237545c39e",
        "User-Agent": "PostmanRuntime/7.28.4",
        "X-Amzn-Trace-Id": "Root=1-63033440-30488dfb133838d83aa781fd"
    },
    "json": {
        "count": 1,
        "name": "yilinzhou",
        "type": "post"
    },
    "origin": "70.252.19.45",
    "url": "https://httpbin.org/post"
    }

    ```
    2. POST: https://jsonplaceholder.typicode.com/posts with data{"name":"liam","num":2}
    result:
    ```
    {
    "name": "liam",
    "num": 2,
    "id": 101
    }
    ```
    3. POST: https://httpbin.org/post with data {"name":"liam", "num":3}
    result:
    ```
    {
    "args": {},
    "data": "{\n    \"name\":\"liam\",\n    \"num\":3\n}",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Content-Length": "34",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "fa0f5490-0c7b-4535-8114-90676c2af27b",
        "User-Agent": "PostmanRuntime/7.28.4",
        "X-Amzn-Trace-Id": "Root=1-63033578-0690f36b4c5582eb57c018d2"
    },
    "json": {
        "name": "liam",
        "num": 3
    },
    "origin": "70.252.19.45",
    "url": "https://httpbin.org/post"
}
    ```
    4. POST: https://httpbin.org/post with data {"orderName":"NBA ticket","price":1111,"date":"6-7"}
    ```
    {
    "args": {},
    "data": "{\n    \"orderName\":\"NBA ticket\",\n    \"price\":1111,\n    \"date\":\"6-7\"\n}",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Content-Length": "68",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "0b8d0d31-ee50-4c8b-86d4-0cd4c11451a9",
        "User-Agent": "PostmanRuntime/7.28.4",
        "X-Amzn-Trace-Id": "Root=1-630335e1-4312d49779b3bd3a5c6d52c7"
    },
    "json": {
        "date": "6-7",
        "orderName": "NBA ticket",
        "price": 1111
    },
    "origin": "70.252.19.45",
    "url": "https://httpbin.org/post"
}
    ```
    5. POST: https://httpbin.org/post with data {"orderName":"NBA ticket","price":1111,"date":"6-7", "num":5}
    ```
    {
    "args": {},
    "data": "{\n    \"orderName\":\"NBA ticket\",\n    \"price\":1111,\n    \"date\":\"6-7\",\n    \"num\":5\n}",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Content-Length": "81",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "70a5f763-3d5d-496e-a069-88ee3c8f273d",
        "User-Agent": "PostmanRuntime/7.28.4",
        "X-Amzn-Trace-Id": "Root=1-6303363a-0d17cd830273081908b794c5"
    },
    "json": {
        "date": "6-7",
        "num": 5,
        "orderName": "NBA ticket",
        "price": 1111
    },
    "origin": "70.252.19.45",
    "url": "https://httpbin.org/post"
}
    ```


3. 3 PUT API with json request body, please also paste the response here 
    1. PUT: https://httpbin.org/put with data {"type":"testPut", "time":1}
    ```
{
    "args": {},
    "data": "{\n    \"type\":\"testPut\",\n    \"time\":1\n}",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Content-Length": "38",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "f47c2b25-3d79-4fc5-b9d5-020fddd9e23a",
        "User-Agent": "PostmanRuntime/7.28.4",
        "X-Amzn-Trace-Id": "Root=1-63033691-10d3f6bf3a3502ce5efd68a1"
    },
    "json": {
        "time": 1,
        "type": "testPut"
    },
    "origin": "70.252.19.45",
    "url": "https://httpbin.org/put"
}
    ```
    2. PUT: https://httpbin.org/put?id=2 with data {"typeName":"testForPut","num":2}
    ```
    {
    "args": {},
    "data": "{\n\n}",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Content-Length": "4",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "537b2ff1-aa49-481f-95a3-f939d20943b0",
        "User-Agent": "PostmanRuntime/7.28.4",
        "X-Amzn-Trace-Id": "Root=1-630336e0-5f834070289c0fd05ccadf7b"
    },
    "json": {},
    "origin": "70.252.19.45",
    "url": "https://httpbin.org/put"
}
    ```
    3. PUT: https://httpbin.org/put?name=car&type=benz with data {"braze":"new","num":3}
    ```
    {
    "args": {
        "name": "car",
        "type": "benz"
    },
    "data": "{\n    \"braze\":\"new\",\n    \"num\":3\n}",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Content-Length": "34",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "8c66e058-8287-4a06-8af2-ab557f313a62",
        "User-Agent": "PostmanRuntime/7.28.4",
        "X-Amzn-Trace-Id": "Root=1-63033772-702333593b747c7f5e3edfb4"
    },
    "json": {
        "braze": "new",
        "num": 3
    },
    "origin": "70.252.19.45",
    "url": "https://httpbin.org/put?name=car&type=benz"
}
    ```

4. 2 DELETE API
    1. DELETE https://httpbin.org/delete?id=1
    ```
    {
    "args": {
        "id": "1"
    },
    "data": "",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Host": "httpbin.org",
        "Postman-Token": "20db6eff-a230-4fa4-8aab-c642812682c7",
        "User-Agent": "PostmanRuntime/7.28.4",
        "X-Amzn-Trace-Id": "Root=1-630337b6-70b5cd8e29d92ce421037f4a"
    },
    "json": null,
    "origin": "70.252.19.45",
    "url": "https://httpbin.org/delete?id=1"
}
    ```
    2. DELETE: https://httpbin.org/delete?id=2
    ```
    {
    "args": {
        "id": "2"
    },
    "data": "",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Host": "httpbin.org",
        "Postman-Token": "a36e6caa-a45e-4e04-9387-73a8ebcf52b6",
        "User-Agent": "PostmanRuntime/7.28.4",
        "X-Amzn-Trace-Id": "Root=1-630337dc-755e320853d9138f514a6659"
    },
    "json": null,
    "origin": "70.252.19.45",
    "url": "https://httpbin.org/delete?id=2"
}
    ```
5. Each example with 404, 401,500 and any http status codes you know

# API
1. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范
    - Twitter API:
    - Create a Tweet: POST https://api.twitter.com/2/tweets body data:{"text":""}
    - delete a Tweet: DELETE https://api.twitter.com/2/tweets/:id
    - List Tweets lookup: GET https://api.twitter.com/2/lists/:id/tweets
    - Create a list: POST https://api.twitter.com/2/lists body data:{"name": "name-for-new-list","description": "description-of-list", "private": false}
    - Update a list: PUT https://api.twitter.com/2/lists/:id bodydata: {"name": "update-name","description": "update-description", "private": false}
    - Like a Tweet: POST https://api.twitter.com/2/users/:id/likes bodydata: {"tweet_id": "tweet-id-you-want-to-like"}
    - Liked Tweets: GET https://api.twitter.com/2/users/:id/liked_tweets?user.fields=&expansions=&tweet.fields=&max_results=&pagination_token=

    - PAYPAL API:
    - create order: POST https://api-m.sandbox.paypal.com/v2/checkout/orders 
    - show order details: GET https://api-m.sandbox.paypal.com/v2/checkout/orders/:order_id
    - update order: PATCH {{base_url}}/v2/checkout/orders/:order_id
    - show refund detail: GET {{base_url}}/v2/payments/refunds/:refund_id
    - GET {{base_url}}/v2/payments/captures/:capture_id

2. Design acollection of APIS for a Blog Website,please specify GET POST PUT DELETE
    - GET user's basic information:{{base_url}}?user_id=/user/basic_info
    - POST user's basic information:{{base_url}}?user_id=/user/basic_info 
    - PUT user's basic information:{{base_url}}?user_id=/user/basic_info 
    - DELETE user's basic information:{{base_url}}?user_id=/user/basic_info

    - GET user's follow list: {{base_url}}?user_id/friends/follow_list
    - POST follow a user: {{base_url}}?user_id/friends/friend_id
    - DELETE unfollow a user: {{base_url}}?user_id/friends/friend_id
    - GET user's follower list: {{base_url}}?user_id/friends/followers
    - GET chat histry of a friend: {{base_url}}?user_id/friends/friend_id/chat_history
    - POST send message to a friend: {{base_url}}?user_id/friends/friend_id/message
    - GET friend's basic info: {{base_url}}?user_id/friends/friend_id/basic_info
    
    - GET user's blog list: {{base_url}}?user_id/blogs/blog_list
    - GET user's one specific blog: {{base_url}}?user_id/blogs/blog_id
    - POST send a blog: {{base_url}}?user_id/blogs/
    - PUT change a blog: {{base_url}}?user_id/blogs/blog_id
    - GET hot blogs: {{base_url}}/blogs/hot_blogs