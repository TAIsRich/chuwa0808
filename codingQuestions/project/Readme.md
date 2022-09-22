## The project is consisted of Controller, dao, entity, payload, servi
### Controller:
- TransactionController : Create a transaction: POST {{host}}/api/v1/customers/{id}/transactions 
                          Get all the transactions: GET {{host}}/api/v1/customers/{id}/transactions
- CustomerController: Create a customer: POST {{host}}/api/v1/customers/{id}
                      Get total reward points from a customer: GET {{host}}/api/v1/customers/{id}/Reward
                      Get reward points by month: GET {{host}}/api/v1/customers/{id}/Rewards?month={RequestParam}

### emtoty:
- The relationship between Customer and Transaction is one-to-many
- There is a joinColumn in Transaction that is customer_id that program can trace all the transactions from a specific customer

### service:
- The customerImpl implements a method that can calculate the total reward points; the basic logic is to compare each customer transaction with the current date time to determine whether the transaction is in the range of three months or not. Afterward, sum up each transaction's reward points.
- Also, to calculate the total reward points by month that is implemented as same as the above method, except for the method add a feature to determine the parameter month is equal to the transaction month.
### Unit Test
- Merely a unit test method in order to test the getRewardById and getRewardByIdAndMonth.