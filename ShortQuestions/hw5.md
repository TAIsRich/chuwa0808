### take below examples,
```
5 GET APIs with different response type
5 Post API with json request body, please also paste the response here 
3 PUT API with json request body, please also paste the response here 
2 DELETE API
Each example with 404, 401,500 and any http status codes you know
```
### Get:
```
200 OK: GET https://ghibliapi.herokuapp.com/locations
404 Not Found: GET https://ghibliapi.herokuapp.com/locations/6
200 OK: GET https://ghibliapi.herokuapp.com/locations/?name=Irontown
200 OK: GET https://ghibliapi.herokuapp.com/locations/?climate=Mild&&terrain=Marsh
404 Not Found: GET https://ghibliapi.herokuapp.com/location
```
### Post:
```
201 Created: POST https://reqres.in/api/users
```
<img width="1001" alt="1" src="https://user-images.githubusercontent.com/87605453/186130383-677a7950-5aa9-44bb-90de-c302d959011e.png">

```
200 OK: POST https://reqres.in/api/register
```
<img width="719" alt="2" src="https://user-images.githubusercontent.com/87605453/186130438-298db96f-03e0-48ac-ac2f-27f9b902fba4.png">

```
400 Bad Request: POST https://reqres.in/api/register
```
<img width="716" alt="3" src="https://user-images.githubusercontent.com/87605453/186130462-0c456e24-d6ae-4629-ab69-8d8cd3bfdf2b.png">

```
200 OK: POST https://reqres.in/api/login
```
<img width="717" alt="4" src="https://user-images.githubusercontent.com/87605453/186130494-23f58892-809e-4789-99b9-d521ce587dc9.png">

```
400 Bad Request: POST https://reqres.in/api/login
```
<img width="720" alt="5" src="https://user-images.githubusercontent.com/87605453/186130529-4ad7fe4c-858e-4881-9a7e-59f899cb3720.png">

### Put:
```
404 Not Found: PUT https://reqres.in/api/users
```
<img width="710" alt="6" src="https://user-images.githubusercontent.com/87605453/186130566-db57a577-b8d8-4260-b591-f200afac9c08.png">

```
200 OK: PUT https://reqres.in/api/users/2
```
<img width="715" alt="7" src="https://user-images.githubusercontent.com/87605453/186130615-e22491f9-b437-415c-afd3-79c6ed1d4e04.png">

```
200 OK: PUT https://reqres.in/api/users/3
```
<img width="720" alt="8" src="https://user-images.githubusercontent.com/87605453/186130646-94980329-7bbb-4617-b175-68ff380fee73.png">

### Delete:
```
204 Not Content: DELETE https://reqres.in/api/users
```
```
400 Bad Request: DELETE https://reqres.in/api/users/2
```

### API Examples
```
1. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范
```
```
Youtube: 
Get Videos Get Rating: GET {{baseUrl}}/videos/getRating?id=<parameters>&onBehalfOfContentOwner=<>
Get Language: GET {{baseUrl}}/i18nLanguages?hl=<post>&part=<>
Add Videos Rate: POST {{baseUrl}}/videos/rate?id=<parameters>&rating=<post>
Delete Channel Sections: DELETE {{baseUrl}}/channelSections?id=<parameters>&onBehalfOfContentOwner=<>
Delete Comments: DELETE {{baseUrl}}/comments?id=<parameters>
```
```
Twitter: 
Users By Username: GET https://api.twitter.com/2/users/by/username/:username
Liked Tweets: GET https://api.twitter.com/2/users/:id/liked_tweets
Follow a User ID: POST https://api.twitter.com/2/users/:id/following
Mute a user ID: POST https://api.twitter.com/2/users/:id/muting
Like a Tweet: POST https://api.twitter.com/2/users/:id/likes
Unmute a user ID: DELETE https://api.twitter.com/2/users/:source_user_id/muting/:target_user_id
Unlike a TWeet: DELETE https://api.twitter.com/2/users/:id/likes/:tweet_id
```
```
2. Design a collection of APIS for a Blog Website, please specify GET POST PUT DELETE
```
```
Get Users By Username: GET https://myblog.com/users/by/username/:username
Get a post By Date: GET https://myblog.com/posts/date?id=<parameters>
Create a Post: POST https://myblog.com/posts/id/postlist
Update a Post: PUT https://myblog.com/posts/id/update
Delete a Post: DELETE https://myblog.com/posts/id/delete
```
