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
```
200 OK: POST https://reqres.in/api/register
```
```
400 Bad Request: POST https://reqres.in/api/register
```
```
200 OK: POST https://reqres.in/api/login
```
```
400 Bad Request: POST https://reqres.in/api/login
```
### Put:
```
404 Not Found: PUT https://reqres.in/api/users
```
```
200 OK: PUT https://reqres.in/api/users/2
```
```
200 OK: PUT https://reqres.in/api/users/3
```
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
