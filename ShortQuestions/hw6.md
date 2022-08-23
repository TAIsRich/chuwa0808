# API-GET
## API-GET1
GET: {{base_url}}/v1/identity/oauth2/userinfo?schema=paypalv1.1

RequestBody: N/A 

Response status: 200 OK

Response:

{
   "user_id": "https://www.paypal.com/webapps/auth/identity/user/Zq4Vzum-M3h_3MxHddpPWqpnXSKgmSol9crJTUx7gec",
   "sub": "https://www.paypal.com/webapps/auth/identity/user/Zq4Vzum-M3h_3MxHddpPWqpnXSKgmSol9crJTUx7gec"
}


## API - GET2
GET: {{base_url}}/v2/checkout/orders/:order_id

Status: 200 OK

Response:

{
   "id": "2XH91392XR9368306",
   "intent": "CAPTURE",
   "status": "CREATED",
   "purchase_units": [
       {
           "reference_id": "default",
           "amount": {
               "currency_code": "USD",
               "value": "100.00",
               "breakdown": {
                   "item_total": {
                       "currency_code": "USD",
                       "value": "100.00"
                   }
               }
           },
           "payee": {
               "email_address": "john_merchant@example.com",
               "merchant_id": "C7CYMKZDG8D6E"
           },
           "items": [
               {
                   "name": "T-Shirt",
                   "unit_amount": {
                       "currency_code": "USD",
                       "value": "100.00"
                   },
                   "quantity": "1",
                   "description": "Green XL"
               }
           ]
       }
   ],
   "create_time": "2022-08-20T07:37:52Z",
   "links": [
       {
           "href": "https://api.sandbox.paypal.com/v2/checkout/orders/2XH91392XR9368306",
           "rel": "self",
           "method": "GET"
       },
       {
           "href": "https://www.sandbox.paypal.com/checkoutnow?token=2XH91392XR9368306",
           "rel": "approve",
           "method": "GET"
       },
       {
           "href": "https://api.sandbox.paypal.com/v2/checkout/orders/2XH91392XR9368306",
           "rel": "update",
           "method": "PATCH"
       },
       {
           "href": "https://api.sandbox.paypal.com/v2/checkout/orders/2XH91392XR9368306/capture",
           "rel": "capture",
           "method": "POST"
       }
   ]
}

## API - GET3
GET: http://taco-randomizer.herokuapp.com/random/

Status: 500 Internal Server Error

Response Body:

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<title>500 Internal Server Error</title>
<h1>Internal Server Error</h1>
<p>The server encountered an internal error and was unable to complete your request. Either the server is overloaded or
   there is an error in the application.</p>


## API - GET4
GET: {{base_url}}/v1/catalogs/products?page_size=10&page=1&total_required=true

Status: 200 OK

Response body:

{
   "products": [
       {
           "id": "1647236710",
           "name": "T-Shirt",
           "description": "Blue M",
           "create_time": "2022-03-14T05:45:06Z",
           "links": [
               {
                   "href": "https://api.sandbox.paypal.com/v1/catalogs/products/1647236710",
                   "rel": "self",
                   "method": "GET"
               }
           ]
       },
       {
           "id": "1647236727",
           "name": "T-Shirt",
           "create_time": "2022-03-14T05:45:23Z",
           "links": [
               {
                   "href": "https://api.sandbox.paypal.com/v1/catalogs/products/1647236727",
                   "rel": "self",
                   "method": "GET"
               }
           ]
       },
       {
           "id": "1647285840",
           "name": "T-Shirt",
           "description": "Blue M",
           "create_time": "2022-03-14T19:24:00Z",
           "links": [
               {
                   "href": "https://api.sandbox.paypal.com/v1/catalogs/products/1647285840",
                   "rel": "self",
                   "method": "GET"
               }
           ]
       },
       {
           "id": "1647285859",
           "name": "T-Shirt",
           "create_time": "2022-03-14T19:24:18Z",
           "links": [
               {
                   "href": "https://api.sandbox.paypal.com/v1/catalogs/products/1647285859",
                   "rel": "self",
                   "method": "GET"
               }
           ]
       },
       {
           "id": "1647288288",
           "name": "T-Shirt",
           "description": "Blue M",
           "create_time": "2022-03-14T20:04:47Z",
           "links": [
               {
                   "href": "https://api.sandbox.paypal.com/v1/catalogs/products/1647288288",
                   "rel": "self",
                   "method": "GET"
               }
           ]
       },
       {
           "id": "1647288308",
           "name": "T-Shirt",
           "create_time": "2022-03-14T20:05:08Z",
           "links": [
               {
                   "href": "https://api.sandbox.paypal.com/v1/catalogs/products/1647288308",
                   "rel": "self",
                   "method": "GET"
               }
           ]
       },
       {
           "id": "1647289108",
           "name": "T-Shirt",
           "description": "Blue M",
           "create_time": "2022-03-14T20:18:28Z",
           "links": [
               {
                   "href": "https://api.sandbox.paypal.com/v1/catalogs/products/1647289108",
                   "rel": "self",
                   "method": "GET"
               }
           ]
       },
       {
           "id": "1647289127",
           "name": "T-Shirt",
           "create_time": "2022-03-14T20:18:47Z",
           "links": [
               {
                   "href": "https://api.sandbox.paypal.com/v1/catalogs/products/1647289127",
                   "rel": "self",
                   "method": "GET"
               }
           ]
       },
       {
           "id": "1647289319",
           "name": "T-Shirt",
           "description": "Blue M",
           "create_time": "2022-03-14T20:21:59Z",
           "links": [
               {
                   "href": "https://api.sandbox.paypal.com/v1/catalogs/products/1647289319",
                   "rel": "self",
                   "method": "GET"
               }
           ]
       },
       {
           "id": "1647289338",
           "name": "T-Shirt",
           "create_time": "2022-03-14T20:22:18Z",
           "links": [
               {
                   "href": "https://api.sandbox.paypal.com/v1/catalogs/products/1647289338",
                   "rel": "self",
                   "method": "GET"
               }
           ]
       }
   ],
   "total_items": 6071,
   "total_pages": 608,
   "links": [
       {
           "href": "https://api.sandbox.paypal.com/v1/catalogs/products?page_size=10&page=1",
           "rel": "self",
           "method": "GET"
       },
       {
           "href": "https://api.sandbox.paypal.com/v1/catalogs/products?page_size=10&page=2",
           "rel": "next",
           "method": "GET"
       },
       {
           "href": "https://api.sandbox.paypal.com/v1/catalogs/products?page_size=10&page=608",
           "rel": "last",
           "method": "GET"
       }
   ]
}

## API - GET5
GET {{base_url}}/v1/billing/subscriptions/:subscription_id

Status: 404 Not Found

# API- POST
## API - POST1
API: POST {{base_url}}/v1/oauth2/token

Status: 200 OK

Response:

{
   "scope": "https://uri.paypal.com/services/invoicing https://uri.paypal.com/services/vault/payment-tokens/read https://uri.paypal.com/services/disputes/read-buyer https://uri.paypal.com/services/payments/realtimepayment https://uri.paypal.com/services/disputes/update-seller https://uri.paypal.com/services/payments/payment/authcapture openid https://uri.paypal.com/services/disputes/read-seller Braintree:Vault https://uri.paypal.com/services/payments/refund https://api.paypal.com/v1/vault/credit-card https://api.paypal.com/v1/payments/.* https://uri.paypal.com/services/reporting/search/read https://uri.paypal.com/payments/payouts https://uri.paypal.com/services/vault/payment-tokens/readwrite https://api.paypal.com/v1/vault/credit-card/.* https://uri.paypal.com/services/shipping/trackers/readwrite https://uri.paypal.com/services/subscriptions https://uri.paypal.com/services/applications/webhooks",
   "access_token": "A21AAKQKwhaoEpOcTTqklGu3tSO5l7ggiGtjdZlWR-vstldQTwBV4msqinwOxJV2779v4sV3jYQR0uIhTGUI1Dp5-V3UUiQFQ",
   "token_type": "Bearer",
   "app_id": "APP-80W284485P519543T",
   "expires_in": 32400,
   "supported_authn_schemes": [
       "email_password",
       "remember_me"
   ],
   "nonce": "2022-08-20T07:33:43Z6VWER5Jl2-hg84OmNiFozvvxyl3ibXa4mSa9KM1rjjg",
   "client_metadata": {
       "name": "PostmanDefaultApp",
       "display_name": "PostmanDefaultApp",
       "logo_uri": "",
       "scopes": [
           "https://uri.paypal.com/services/payments/futurepayments",
           "https://uri.paypal.com/services/invoicing",
           "https://uri.paypal.com/services/vault/payment-tokens/read",
           "https://uri.paypal.com/services/payments/basic",
           "https://uri.paypal.com/services/disputes/read-buyer",
           "https://uri.paypal.com/services/payments/realtimepayment",
           "https://uri.paypal.com/services/payments/payment/authcapture",
           "https://uri.paypal.com/services/disputes/update-seller",
           "openid",
           "https://uri.paypal.com/services/disputes/read-seller",
           "https://uri.paypal.com/services/payments/refund",
           "https://uri.paypal.com/web/experience/incontextxo",
           "https://api.paypal.com/v1/vault/credit-card",
           "Braintree:Vault",
           "https://api.paypal.com/v1/payments/.*",
           "https://uri.paypal.com/services/reporting/search/read",
           "https://uri.paypal.com/payments/payouts",
           "https://uri.paypal.com/services/vault/payment-tokens/readwrite",
           "https://api.paypal.com/v1/vault/credit-card/.*",
           "https://uri.paypal.com/services/shipping/trackers/readwrite",
           "https://uri.paypal.com/services/subscriptions",
           "https://uri.paypal.com/services/applications/webhooks"
       ],
       "ui_type": "NEW"
   }
}

## API - POST2
Post: {{base_url}}/v2/checkout/orders

Request Body:

{
   "intent": "CAPTURE",
   "purchase_units": [
       {
           "items": [
               {
                   "name": "T-Shirt",
                   "description": "Green XL",
                   "quantity": "1",
                   "unit_amount": {
                       "currency_code": "USD",
                       "value": "100.00"
                   }
               }
           ],
           "amount": {
               "currency_code": "USD",
               "value": "100.00",
               "breakdown": {
                   "item_total": {
                       "currency_code": "USD",
                       "value": "100.00"
                   }
               }
           }
       }
   ],
   "application_context": {
       "return_url": "https://example.com/return",
       "cancel_url": "https://example.com/cancel"
   }
}

Status : 201 Created

Response:

{
   "id": "2XH91392XR9368306",
   "intent": "CAPTURE",
   "status": "CREATED",
   "purchase_units": [
       {
           "reference_id": "default",
           "amount": {
               "currency_code": "USD",
               "value": "100.00",
               "breakdown": {
                   "item_total": {
                       "currency_code": "USD",
                       "value": "100.00"
                   }
               }
           },
           "payee": {
               "email_address": "john_merchant@example.com",
               "merchant_id": "C7CYMKZDG8D6E"
           },
           "items": [
               {
                   "name": "T-Shirt",
                   "unit_amount": {
                       "currency_code": "USD",
                       "value": "100.00"
                   },
                   "quantity": "1",
                   "description": "Green XL"
               }
           ]
       }
   ],
   "create_time": "2022-08-20T07:37:52Z",
   "links": [
       {
           "href": "https://api.sandbox.paypal.com/v2/checkout/orders/2XH91392XR9368306",
           "rel": "self",
           "method": "GET"
       },
       {
           "href": "https://www.sandbox.paypal.com/checkoutnow?token=2XH91392XR9368306",
           "rel": "approve",
           "method": "GET"
       },
       {
           "href": "https://api.sandbox.paypal.com/v2/checkout/orders/2XH91392XR9368306",
           "rel": "update",
           "method": "PATCH"
       },
       {
           "href": "https://api.sandbox.paypal.com/v2/checkout/orders/2XH91392XR9368306/capture",
           "rel": "capture",
           "method": "POST"
       }
   ]
}

## API - POST3
Post: ​​{{base_url}}/v2/invoicing/generate-next-invoice-number

Status: 200 OK

Response:

{
   "invoice_number": "1660978906"
}


## API - POST4
Post:{{base_url}}/v1/billing/subscriptions

Request Body:

{
   "plan_id": "{{billing_plan_id}}",
   "start_time": "2022-11-01T00:00:00Z",
   "shipping_amount": {
       "currency_code": "USD",
       "value": "10.00"
   },
   "subscriber": {
       "name": {
           "given_name": "FooBuyer",
           "surname": "Jones"
       },
       "email_address": "foobuyer@example.com",
       "shipping_address": {
           "name": {
               "full_name": "John Doe"
           },
           "address": {
               "address_line_1": "2211 N First Street",
               "address_line_2": "Building 17",
               "admin_area_2": "San Jose",
               "admin_area_1": "CA",
               "postal_code": "95131",
               "country_code": "US"
           }
       }
   },
   "application_context": {
       "brand_name": "Example Inc",
       "locale": "en-US",
       "shipping_preference": "SET_PROVIDED_ADDRESS",
       "user_action": "SUBSCRIBE_NOW",
       "payment_method": {
           "payer_selected": "PAYPAL",
           "payee_preferred": "IMMEDIATE_PAYMENT_REQUIRED"
       },
       "return_url": "https://example.com/return",
       "cancel_url": "https://example.com/cancel"
   }
}


Status: 400 Bad Request

Response Body:

{
   "name": "INVALID_REQUEST",
   "message": "Request is not well-formed, syntactically incorrect, or violates schema.",
   "debug_id": "25a762d5f2f0c",
   "details": [
       {
           "field": "/plan_id",
           "value": "",
           "location": "body",
           "issue": "INVALID_PARAMETER_SYNTAX",
           "description": "The value of a field does not conform to the expected format."
       }
   ],
   "links": [
       {
           "href": "https://developer.paypal.com/docs/api/v1/billing/subscriptions#INVALID_REQUEST",
           "rel": "information_link",
           "method": "GET"
       }
   ]
}


## API - POST5
Post: {{base_url}}/v1/shipping/trackers-batch

Request Body:

{
   "trackers": [
       {
           "transaction_id": "{{capture_id}}",
           "status": "SHIPPED",
           "tracking_number": "{{tracking_number}}",
           "carrier": "FEDEX",
           "tracking_number_type": "CARRIER_PROVIDED",
           "shipment_date": "{{todays_date}}",
           "carrier_name_other": "FEDEX Ground",
           "notify_buyer": true,
           "quantity": 1,
           "tracking_number_validated": true
       }
   ]
}

Status: 200 OK

Response:

{
   "tracker_identifiers": [],
   "errors": [
       {
           "name": "RESOURCE_NOT_FOUND",
           "message": "The specified resource does not exist",
           "details": [
               {
                   "field": "/trackers/1/transaction_id",
                   "value": "",
                   "location": "body",
                   "issue": "INVALID_TRANSACTION_ID",
                   "description": "The PayPal transaction id is invalid"
               }
           ],
           "links": []
       }
   ],
   "links": [
       {
           "href": "https://api-m.sandbox.paypal.com/v1/shipping/trackers-batch",
           "rel": "self",
           "method": "POST",
           "encType": "application/json"
       }
   ]
}


# API- PUT
## PUT1
{{base_url}}/v2/invoicing/invoices/:invoice_id?send_to_recipient=true&send_to_invoicer=true

Request body:

{
   "id": "{{invoice_id}}",
   "status": "DRAFT",
   "detail":
       "invoice_number": "{{$timestamp}}",
       "reference": "deal-refernce-update",
       "invoice_date": "2018-11-12",
       "currency_code": "USD",
       "note": "Thank you for your business.",
       "term": "No refunds after 30 days.",
       "memo": "This is a long contract",
       "payment_term": {
           "term_type": "NET_10",
           "due_date": "2018-11-22"
       }
   },
   "invoicer": {
       "name": {
           "given_name": "David",
           "surname": "Larusso"
       },
       "address": {
           "address_line_1": "1234 First Street",
           "address_line_2": "337673 Hillside Court",
           "admin_area_2": "Anytown",
           "admin_area_1": "CA",
           "postal_code": "98765",
           "country_code": "US"
       },
       "phones": [
           {
               "country_code": "001",
               "national_number": "4085551234",
               "phone_type": "MOBILE"
           }
       ],
       "website": "www.test.com",
       "tax_id": "ABcNkWSfb5ICTt73nD3QON1fnnpgNKBy-Jb5SeuGj185MNNw6g",
       "logo_url": "https://example.com/logo.PNG",
       "additional_notes": "2-4"
   },
   "primary_recipients": [
       {
           "billing_info": {
               "name": {
                   "given_name": "Stephanie",
                   "surname": "Meyers"
               },
               "address": {
                   "address_line_1": "1234 Main Street",
                   "admin_area_2": "Anytown",
                   "admin_area_1": "CA",
                   "postal_code": "98765",
                   "country_code": "US"
               },
               "email_address": "foobuyer@gmail.com",
               "phones": [
                   {
                       "country_code": "001",
                       "national_number": "4884551234",
                       "phone_type": "HOME"
                   }
               ],
               "additional_info_value": "add-info"
           },
           "shipping_info": {
               "name": {
                   "given_name": "Stephanie",
                   "surname": "Meyers"
               },
               "address": {
                   "address_line_1": "1234 Main Street",
                   "admin_area_2": "Anytown",
                   "admin_area_1": "CA",
                   "postal_code": "98765",
                   "country_code": "US"
               }
           }
       }
   ],
   "items": [
       {
           "name": "Yoga Mat",
           "description": "Elastic mat to practice yoga.",
           "quantity": "1",
           "unit_amount": {
               "currency_code": "USD",
               "value": "50.00"
           },
           "tax": {
               "name": "Sales Tax",
               "percent": "7.25",
               "amount": {
                   "currency_code": "USD",
                   "value": "3.27"
               }
           },
           "discount": {
               "percent": "5",
               "amount": {
                   "currency_code": "USD",
                   "value": "2.5"
               }
           },
           "unit_of_measure": "QUANTITY"
       },
       {
           "name": "Yoga t-shirt",
           "quantity": "1",
           "unit_amount": {
               "currency_code": "USD",
               "value": "10.00"
           },
           "tax": {
               "name": "Sales Tax",
               "percent": "7.25",
               "amount": {
                   "currency_code": "USD",
                   "value": "0.34"
               }
           },
           "discount": {
               "amount": {
                   "currency_code": "USD",
                   "value": "5.00"
               }
           },
           "unit_of_measure": "QUANTITY"
       }
   ],
   "configuration": {
       "partial_payment": {
           "allow_partial_payment": true,
           "minimum_amount_due": {
               "currency_code": "USD",
               "value": "20.00"
           }
       },
       "allow_tip": true,
       "tax_calculated_after_discount": true,
       "tax_inclusive": false
   },
   "amount": {
       "currency_code": "USD",
       "value": "74.21",
       "breakdown": {
           "item_total": {
               "currency_code": "USD",
               "value": "60.00"
           },
           "custom": {
               "label": "Packing Charges",
               "amount": {
                   "currency_code": "USD",
                   "value": "10.00"
               }
           },
           "shipping": {
               "amount": {
                   "currency_code": "USD",
                   "value": "10.00"
               },
               "tax": {
                   "name": "Sales Tax",
                   "percent": "7.25",
                   "amount": {
                       "currency_code": "USD",
                       "value": "0.73"
                   }
               }
           },
           "discount": {
               "item_discount": {
                   "currency_code": "USD",
                   "value": "-7.50"
               },
               "invoice_discount": {
                   "percent": "5",
                   "amount": {
                       "currency_code": "USD",
                       "value": "-2.63"
                   }
               }
           },
           "tax_total": {
               "currency_code": "USD",
               "value": "4.34"
           }
       }
   }
}

Status: 405 Method Not Allowed

Response:


{
   "name": "METHOD_NOT_SUPPORTED",
   "message": "The server does not implement the requested HTTP method.",
   "debug_id": "2df5b5d95ca1e",
   "details": [],
   "links": []
}

## PUT2
{{base_url}}/v1/shipping/trackers/:tracking_id

Request Body:

{
   "transaction_id": "{{capture_id}}",
   "tracking_number": "{{tracking_number}}",
   "status": "SHIPPED",
   "carrier": "OTHER",
   "carrier_name_other": "{{$randomCompanyName}}"
}

Status: 405 Method Not Allowed

Response:

{
   "name": "METHOD_NOT_SUPPORTED",
   "message": "The server does not implement the requested HTTP method.",
   "debug_id": "845fb95fd8160",
   "details": [],
   "links": []
}

## PUT3
{{baseUrl}}/api/channels/email/:email

Request Body:

{
   "channel": {
       "address": "{{email_address}}",
       "commercial_opted_out": "{{today_date_time}}",
       "type": "email"
   }
}


Status 401 Unauthorized

Response:

{"ok":false,"error":"Unauthorized","error_code":40101}


# API - DELETE
## DELETE1
{{base_url}}/v2/invoicing/invoices/:invoice_id

Status: 405 Method Not Allowed

Response:

{
   "name": "METHOD_NOT_SUPPORTED",
   "message": "The server does not implement the requested HTTP method.",
   "debug_id": "17a4d6a85f8b4",
   "details": [],
   "links": []
}


## DELETE2
{{base_url}}/v2/invoicing/invoices/:invoice_id/payments/:transaction_id

Status: 404 Not Found

Response:

{
   "name": "RESOURCE_NOT_FOUND",
   "message": "The specified resource does not exist.",
   "debug_id": "25398056ad19d",
   "details": [],
   "links": [
       {
           "href": "https://developer.paypal.com/docs/api/invoicing/#errors",
           "method": "GET"
       }
   ]
}

# Blog Website
1. EndPoint: https://www.blogwebtest.com/v1
2. Blog
- POST: https://www.blogwebtest.com/v1/blog
- GET:
-   https://www.blogwebtest.com/v1/blog/:id
-    https://www.blogwebtest.com/v1/blog/:username
- PUT: https://www.blogwebtest.com/v1/blog
- DELETE: https://www.blogwebtest.com/v1/blog
3. Comment
-   POST: https://www.blogwebtest.com/v1/comment/:id
-   DELETE: https://www.blogwebtest.com/v1/comment
4. Search
- GET:
-   https://www.blogwebtest.com/v1/blog/:id
-   https://www.blogwebtest.com/v1/blog/:username
-   https://www.blogwebtest.com/v1/blog

# MySQL DB Practice

USE test;


INSERT INTO oms_company_address (id, address_name, send_status,receive_status, name, phone, province, city, region, detail_address ) 


VALUES ( 00000001, '1392 road', 0, 0, 'Amy', 1352837492, 'Santa Clara', 'SC', 'CA', 'detail1');


INSERT INTO oms_company_address (id, address_name, send_status,receive_status, name, phone, province, city, region, detail_address ) 


VALUES ( 00000002, '0002 road', 0, 0, 'Bob', 2222222222, 'Santa Clara', 'SC', 'CA', 'detail2'),
( 00000003, '0003 road', 1, 1, 'Cathy', 3333333333, 'Santa Cruz', 'SC', 'CA', 'detail3'),
( 00000004, '0004 road', 0, 1, 'Daisy', 4444444444, 'Santa Clara', 'SC', 'CA', 'detail4');

SELECT * FROM oms_company_address;


SELECT * FROM oms_company_address LIMIT 3;


UPDATE oms_company_address


SET phone = '666-6666-8888';


SELECT * FROM oms_company_address;


DELETE FROM oms_company_address

WHERE name = 'Bob';


SELECT * FROM oms_company_address;







