# REST API Postman


### 5 GET APIs with different response type
```
200 OK : GET https://ghibliapi.herokuapp.com/locations
404 Not Found : GET https://ghibliapi.herokuapp.com/locations/1
405 Method Not Allowed : GET http://localhost:8080/api/v1/posts
204 No Content : 
500 server error :
```

### 5 Post API with json request body, please also paste the response here

- POST https://reqres.in/api/users
```
// request body
{
    "Name" : "XYZ",
    "Job" : "Student"
}

// response - 201 Created
{
    "Name": "XYZ",
    "Job": "Student",
    "id": "384",
    "createdAt": "2022-08-23T05:32:41.056Z"
}
```

- POST https://reqres.in/api/users
```
// request body
{
    "Name" : "CCC",
    "Job" : "Student",
    "Gender" : "Male"
}

// response - 201 Created
{
    "Name": "CCC",
    "Job": "Student",
    "Gender": "Male",
    "id": "910",
    "createdAt": "2022-08-23T05:36:27.747Z"
}
```

- POST https://reqres.in/api/login
```
// request body
{
    "Name" : "CCC",
    "password" : "123"
}

// response - 400 Bad Request
{
    "error": "Missing email or username"
}
```

- POST https://reqres.in/api/register
```
// request body
{
    "email": "eve.holt@reqres.in",
     "password": "pistol"
}

// response - 200 OK
{
    "id": 4,
    "token": "QpwL5tke4Pnpja7X4"
}
```

- POST https://reqres.in/api/login
```
// request body
{
    "password" : "12345"
}

// response - 400 Bad Request
{
    "error": "Missing email or username"
}
```

### 3 PUT API with json request body, please also paste the response here

- PUT https://reqres.in/api/users/
```
// request body
{
    "name" : "qwe",
    "job" : "12"
}

// response - 200 OK
{
    "name": "qwe",
    "job": "12",
    "updatedAt": "2022-08-23T05:52:04.254Z"
}
```

- PUT https://reqres.in/api/users/578
```
// request body
null

// response - 400 Bad Request
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
```

- PUT https://reqres.in/api/users/578
```
// request body
{
    "name" : "qqq",
    "job" : "teacher"
}

// response - 200 OK
{
    "name": "qqq",
    "job": "teacher",
    "updatedAt": "2022-08-23T05:55:14.229Z"
}
```

### 2 DELETE API

- DELETE https://reqres.in/api/users/578
```
// response - 204 No Content
null
```

- DELETE https://leetcode.com/problemset/all/?search=208&page=1
```
// response - 405Method Not Allowed
<!DOCTYPE html>
<html lang="en">

<head>
	<meta name="viewport" content="width=device-width" />
	<meta charSet="utf-8" />
	<script>
		!function(){try {var d=document.documentElement.classList;d.remove('light','dark');var e=localStorage.getItem('lc-dark-side');if("system"===e||(!e&&true)){var t="(prefers-color-scheme: dark)",m=window.matchMedia(t);m.media!==t||m.matches?d.add('dark'):d.add('light')}else if(e) d.add(e)}catch(e){}}()
	</script>
	<title>405: Method Not Allowed</title>
	<meta name="next-head-count" content="4" />
	<link rel="preload" href="/_next/static/css/1e948112a7a14c10.css" as="style" />
	<link rel="stylesheet" href="/_next/static/css/1e948112a7a14c10.css" data-n-g="" /><noscript
		data-n-css=""></noscript>
	<script defer="" nomodule="" src="/_next/static/chunks/polyfills-5cd94c89d3acac5f.js"></script>
	<script src="/_next/static/chunks/webpack-6b9225f2056b6e4d.js" defer=""></script>
	<script src="/_next/static/chunks/framework-560765ab0625ba27.js" defer=""></script>
	<script src="/_next/static/chunks/main-2752c6213a177432.js" defer=""></script>
	<script src="/_next/static/chunks/pages/_app-9c9301424837f15a.js" defer=""></script>
	<script src="/_next/static/chunks/pages/_error-d5e199e0b01a6787.js" defer=""></script>
	<script src="/_next/static/Ldb_Fcc-UKa_pLAqMwyAp/_buildManifest.js" defer=""></script>
	<script src="/_next/static/Ldb_Fcc-UKa_pLAqMwyAp/_ssgManifest.js" defer=""></script>
	<script src="/_next/static/Ldb_Fcc-UKa_pLAqMwyAp/_middlewareManifest.js" defer=""></script>
</head>

<body>
	<div id="__next" data-reactroot="">
		<div
			style="color:#000;background:#fff;font-family:-apple-system, BlinkMacSystemFont, Roboto, &quot;Segoe UI&quot;, &quot;Fira Sans&quot;, Avenir, &quot;Helvetica Neue&quot;, &quot;Lucida Grande&quot;, sans-serif;height:100vh;text-align:center;display:flex;flex-direction:column;align-items:center;justify-content:center">
			<div>
				<style>
					body {
						margin: 0
					}
				</style>
				<h1
					style="display:inline-block;border-right:1px solid rgba(0, 0, 0,.3);margin:0;margin-right:20px;padding:10px 23px 10px 0;font-size:24px;font-weight:500;vertical-align:top">
					405</h1>
				<div style="display:inline-block;text-align:left;line-height:49px;height:49px;vertical-align:middle">
					<h2 style="font-size:14px;font-weight:normal;line-height:inherit;margin:0;padding:0">Method Not
						Allowed
						<!-- -->.</h2>
				</div>
			</div>
		</div>
	</div>
	<script id="__NEXT_DATA__" type="application/json">
		{"props":{"pageProps":{"statusCode":405}},"page":"/_error","query":{},"buildId":"Ldb_Fcc-UKa_pLAqMwyAp","isFallback":false,"gip":true,"scriptLoader":[]}
	</script>
</body>

</html>
```

### Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
- Paypal
```
User info - GET  {{base_url}}/v1/identity/oauth2/userinfo?schema=paypalv1.1\
Create order - POST {{base_url}}/v2/checkout/orders
Show order detail - GET {{base_url}}/v2/checkout/orders/:order_id
update order - PATCH {{base_url}}/v2/checkout/orders/:order_id
Authorize payment for order - POST {{base_url}}/v2/checkout/orders/:order_id/authorize
Capture payment for order - POST {{base_url}}/v2/checkout/orders/:order_id/capture
Show refund details - GET {{base_url}}/v2/payments/refunds/:refund_id
Refund captured payment POST {{base_url}}/v2/payments/captures/:capture_id/refund
```

- YouTuBe
```
Caption list - GET https://www.googleapis.com/youtube/v3/captions
Caption insert - POST https://www.googleapis.com/upload/youtube/v3/captions
Caption update - PUT https://www.googleapis.com/upload/youtube/v3/captions
Caption download - GET https://www.googleapis.com/youtube/v3/captions/id
Caption delete - DELETE https://www.googleapis.com/youtube/v3/captions
Subscription list - GET https://www.googleapis.com/youtube/v3/subscriptions
Subscription insert - POST https://www.googleapis.com/youtube/v3/subscriptions
Subscription delete - DELETE https://www.googleapis.com/youtube/v3/subscriptions
```

### Design a collection of APIS for a Blog Website, please specify GET POST PUT DELETE 
```
read a post - GET http://www.bblloogg.com/user/v2/blogs/blogID/post
create a post - POST http://www.bblloogg.com/user/v2/blogs/blogID/post
update a post - PUT http://www.bblloogg.com/user/v2/blogs/blogID/post
delete a post - DELETE http://www.bblloogg.com/user/v2/blogs/blogID/post
```
