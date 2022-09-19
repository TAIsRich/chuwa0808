entity: table1 : user (id, name, transaction(one to many))
        table2 : transaction (id, user(many to one), amount, date)

dto: name toal cur

conrtoller: 1.path: api/v1/reward       post  dto(name)  responseresult
            2.path: api/v1/reward/{id}     post  dto  responseresult

service:  A customer receives 2 points for every dollar spent over $100 in each transac?on, plus 1 point for every 
dollar spent over $50 in each transac?on 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).098

dao: jpa