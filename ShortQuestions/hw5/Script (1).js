use testDB
db.createCollection("oms_company_address")
db.oms_company_address.insertMany([
{
    id : 1,
    address_name : "Louico",
    send_status : 1, 
    receive_status : 1,
    name : "Lucy",
    phone : "(202)364-8765",
    province :  "CA",
    city : "San Jose" ,
    region : "San Jose",
    detail_address : "1342 Line St, San Jose, CA, 95129"
},
{
    id : 2,
    address_name : "Apple",
    send_status : 1, 
    receive_status : 1,
    name : "Nancy",
    phone : "(202)364-8765",
    province :  "CA",
    city : "San Jose" ,
    region : "San Jose",
    detail_address : "1342 Line St, San Jose, CA, 95129"
},
{
    id : 3,
    address_name : "Louico",
    send_status : 1, 
    receive_status : 1,
    name : "Ben",
    phone : "(202)364-8765",
    province :  "CA",
    city : "San Jose" ,
    region : "San Jose",
    detail_address : "1342 Line St, San Jose, CA, 95129"
},
{
    id : 4,
    address_name : "Louico",
    send_status : 1, 
    receive_status : 1,
    name : "Paul",
    phone : "(202)364-8765",
    province :  "CA",
    city : "San Jose" ,
    region : "San Jose",
    detail_address : "1342 Line St, San Jose, CA, 95129"
},
{
    id : 5,
    address_name : "Louico",
    send_status : 1, 
    receive_status : 1,
    name : "Jason",
    phone : "(202)364-8765",
    province :  "CA",
    city : "San Jose" ,
    region : "San Jose",
    detail_address : "1342 Line St, San Jose, CA, 95129"
}
])

db.oms_company_address.findOne({id : 1})
db.oms_company_address.find()
db.oms_company_address.update({'id':1}, {$set:{'name':'Mike'}})
db.oms_company_address.remove({'name':'Ben'})
