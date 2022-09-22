# Customer API

Use /customer resource to create, update, retrieve, authenticate, and authorize customers.

## Reward Points

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in in each transaction, plus 1 point for every dollar spent over 50 dollars in each transaction.
Given a record of every transaction during a three month period, calculate the reward points earned for each
customer per month and total.

### Get total rewarded point for a certain customer by its name or email

GET /api/v1/customers/{customerNameOrEmail}/totalpoints


### Get total rewarded point in a given month for a certain customer by its name or email

GET /api/v1/customers/{customerNameOrEmail}/points/{month}
