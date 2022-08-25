## REST API Postman

take below examples,

- 5 GET APIs with different response type
- 5 Post API with json request body, please also paste the response here
- 3 PUT API with json request body, please also paste the response here
- 2 DELETE API
- Each example with 404, 401,500 and any http status codes you know

### GET

- `200 OK`: `GET https://reqres.in/api/users/2`
- `200 OK`: `GET https://reqres.in/api/unknown`
- `200 OK`: `GET https://reqres.in/api/users?page=2`
- `404 Not Found`: `GET https://reqres.in/api/users/23`
- `400 Bad Request`

### POST

- `201 Created`: `POST https://reqres.in/api/users`

```json
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

```json
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

```json
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

```json
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

- `400 Bad Request`: `POST https://reqres.in/api/login`

```json
// request body
{
    "email": "peter@klaven"
}

// response
{
    "error": "Missing password"
}

```

### PUT

- `200 OK` : `PUT https://reqres.in/api/users/2`

```json
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

- `400 Bad Request`: `PUT https://reqres.in/api/users/2`

```json
// request body
{
  "name": "morpheus",
  "job": "zion resident"
  "email": "a@a.a"
}

// response
{
  <!DOCTYPE html>
  <html lang="en">
  <head>
  <meta charset="utf-8">
  <title>Error</title>
  </head>
  <body>
  <pre>Bad Request</pre>
  </body>
  </html>
}

```


- `404 Not Found`: `PUT https://api.getpostman.com/scim/v2/Users`

```json
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

## DELETE

- `204 No Content`: `DELETE https://reqres.in/api/users/2`

```json
// response
null
```

- `204 No Content`: `DELETE https://reqres.in/api/users`

```json
// response
null
```

## API Examples

### 1. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范

- **Youtube**: 

    - Get Activities: GET https://youtube.googleapis.com/youtube/v3/activities?key=[YOUR_API_KEY] HTTP/1.1
    Authorization: Bearer [YOUR_ACCESS_TOKEN]
    Accept: application/json
  
    - Get Channels: GET https://youtube.googleapis.com/youtube/v3/channels?key=[YOUR_API_KEY] HTTP/1.1
    Authorization: Bearer [YOUR_ACCESS_TOKEN]
    Accept: application/json

    - Get Comments: GET https://youtube.googleapis.com/youtube/v3/comments?part=<>&id=<>&maxResults=<>&pageToken=<>&parentId=<>&textFormat=<>&key=[YOUR_API_KEY] HTTP/1.1
    Authorization: Bearer [YOUR_ACCESS_TOKEN]
    Accept: application/json

    - Add Comments: POST https://youtube.googleapis.com/youtube/v3/comments?part=<>&key=[YOUR_API_KEY] HTTP/1.1
    Authorization: Bearer [YOUR_ACCESS_TOKEN]
    Accept: application/json
    Content-Type: application/json

    - Update Comments: PUT https://youtube.googleapis.com/youtube/v3/comments?part=<>&key=[YOUR_API_KEY] HTTP/1.1
    Authorization: Bearer [YOUR_ACCESS_TOKEN]
    Accept: application/json
    Content-Type: application/json
    
    - Delete Comments: DELETE https://youtube.googleapis.com/youtube/v3/comments?id=<>&key=[YOUR_API_KEY] HTTP/1.1
    Authorization: Bearer [YOUR_ACCESS_TOKEN]
    Accept: application/json

- **PayPal**: 
    - User Info: `GET {{base_url}}/v1/identity/oauth2/userinfo?schema=paypalv1.1`
    - Create order: `POST {{base_url}}/v2/checkout/orders`
    - Show order details: `GET {{base_url}}/v2/checkout/orders/:order_id`
    - List transactions: `GET {{base_url}}/v1/reporting/transactions?fields=transaction_info,payer_info,shipping_info,auction_info,cart_info,incentive_info,store_info&start_date=2022-02-20T23:59:59.999Z&end_date=2022-03-20T00:00:00.000Z`
    - Fully update invoice: `PUT {{base_url}}/v2/invoicing/invoices/:invoice_id?send_to_recipient=true&send_to_invoicer=true`
    - Show tracking information: `GET {{base_url}}/v1/shipping/trackers/:tracking_id`

### 2. Design a collection of APIS for a Blog Website, please specify GET POST PUT DELETE

- **getting posts from a blog**: `GET https://{BASE_URL}/api/v1/posts?part=<>&id=<>&maxResults=<>&pageToken=<>&parentId=<>&textFormat=<>`
- **Adding a post**: `POST https://{BASE_URL}//api/v1/posts?part=<>`
- **Deleting a post**: `DELETE https://{BASE_URL}//api/v1/posts/postId`
- **Updating a post**: `PUT https://{BASE_URL}//api/v1/posts?part=<>`