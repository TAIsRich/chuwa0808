- Database with mySQL
  - Customer 
    - with customer information of (id-random assigned, firstname, lastname, email)
  - PurchaseRecord
    - create purchase record for each customer
    - each record has it's own record id
    - each record contains (id, purchase amount, and date)
- Customer Controller
  - add customer
  - delete customer
  - update customer info
  - get points
- PurchaseRecord Controller
  - add purchase record for each customer
- Unit tests
  - test for getAllPoint and getPerMonthPoint

- APIs for testing:
  - post customer
    - http://localhost:8080/api/v1/customers
    - {
      "firstName": "Test100",
      "lastName": "TestTest100",
      "email": "test100@gmail.com"
      }
  - delete customer
    - http://localhost:8080/api/v1/customers/100
  - get customer
    - http://localhost:8080/api/v1/customers/8
  - post purchase record for customer_id = 3
    - http://localhost:8080/api/v1/customers/3/purchaseRecords
    - {
      "purchaseAmount": "140",
      "date": "2022-03-27"
      }
  - get purchase record for customer_id = 3
    - http://localhost:8080/api/v1/customers/3/purchaseRecords
  - delete purchase record 5 for customer_id = 2
    - http://localhost:8080/api/v1/customers/2/purchaseRecords/5
  - get total earned point for customer 2
    - http://localhost:8080/api/v1/customers/2/total
  - get March earned point for customer 2
    - http://localhost:8080/api/v1/customers/2/monthPoint/3