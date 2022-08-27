# 2. 
1. @Column(ColumnDefinition = "Varchar(255) default 'John Snow'")
- name类型是String 255, default name 是 John Snow
2. @Column(name = "STUDENT_NAME", length = 50, nullable = false, unique = false):
- name的value是”STUDENT_NAME“， 长度最长有50个char，不可以为空，可以有重复的record with same name

# 3. 
first_name & operating_system

# 4. 
layers:
1. postman: 发送相应的API指令
2. controller：拦截API指令，并决定调用service里面的哪一部分
3. service：
- 储存各种method和指令，把payload(requestBody & responseBody)转化成entity，只有这样才能让DAO跟database interact。
- requestBody先传递给entity 
- entity调用DAO里面相应method,看是要save, update还是retrieve
- 将DAO的return转换成controller需要的数据并返回
4. DAO：接收service的指令，与database交互，看是要save new record, 还是catch some information from database
5. DB: 根据DAO做出的指令，来决定怎么update table，并决定要返回哪些相对应的数据给DAO



# 5. 
postman发送相应的API指令

Controller拦截发送过来的指令，并且决定要调用server里面的哪一部分（是要保存呢，还是要生成一个新的record，还是要更新)
- ex. SignUp is the controller, then @RequestMapping to post

controller调用server里面的具体某一个method, 不同的method去DAO里面不同的数据做interaction

DAO要跟database去interact提取request所需要的数据。比如database里面可能有100个column,但是本次request生成的requestBody里面只需要4个column，那么database就会把相应的4个column的数据建立一个新的responseBody，放到DAO里面，DAO再返回给service。

ex. post:
- postman发送一个post的请求，controller拦截request,通过@RequestMapping, map到postController这一个具体的controller。
- 要create一个post,需要用一个PostDto来做payload
- @RequestBody把要post的内容转化成entity(JSON format)来跟DAO交互，这个是通过生成一个PostDto来完成的
- 因为是post，所以会调用DAO里面save的方法，将entity的数据储存到database,并且会返回储存好的数据
- save()返回的数据放到response里面返回给controller

# 6. 
## data source
1. server.pot = 8080 -- 设置端口
2. spring.datasource.url=jdbc:mysql://localhost:xxxx/project_name?useSSL=false&serverTimezone=UTC
- 设置url，看要跟哪个数据库的哪个table连接
3. spring.datasource.username=
- 数据库用来连接的用户名
4. spring.datasource.password=
- 数据库用来连接的密码
## hibernate properties
5. spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
- 看我用的是哪种数据库的语言，SQL的话，使用MySQL的，还是ORACLE的还是Microsoft的？
## hibernate ddl auto (create, create-drop, validate, update)
6. spring.jpa.hibernate.ddl-auto=update
- ddl是用来对table进行增删查改，而不是对table里面的每一个record
- 上面这条指令的，对于你的entity，我会自动进行相应的操作
