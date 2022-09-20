# Mall Setup
## Environment Setup
1. macOS Monterey Version 12.5
2. follow instruction from [mall setup](https://www.macrozheng.com/)
3. Install [Homebrew](https://brew.sh/)
    ```
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```
4. Install Cask docker
  * Install [Cask docker](https://formulae.brew.sh/cask/docker)
    ```
    brew install --cask docker
    ```
  * Start Docker Desktop - Launch Docker Desktop app from Launchpad, which will enable the docker command for Terminal. Make sure you keep the Docker Desktop running all the time.
## Docker commands
1. List all docker containers
    ```
    docker ps -a
    ```
2. Execute command in container
    ```
    docker exec -it <CONTAINER_NAME> <command>
    ```
3. Copy file from host to container
    ```
    docker cp SRC_PATH CONTAINER_NAME:DEST_PATH
    ```
3. Check container logs:
    ```
    docker logs <CONTAINER_ID>
    ```
4. Create docker container:
    ```
    docker run -p <HOST_PORT>:<CONTAINER_PORT> --name <CONTAINER_NAME> -v <HOST_PATH>:<CONTAINER_PATH> -d <IMAGE_NAME>
    ```
5. Remove a container with container id:
    ```
    docker rm <CONTAINER_ID>
    ```
## Server Environment Setup
### Docker data directory
Create a directory, ex. ```/Users/xiazhao/docker```, which is going to hold mapped docker files to host machine.
### MySQL 5.7
* Pull container image:
    ```
    docker pull mysql:5.7
    ```
* Create mysql container, make sure your local 3306 port isn't get occupied, such as your local mysql:
    ```
    sudo docker run -p 3306:3306 --name mysql \
    -v ~/docker/mysql/log:/var/log/mysql \
    -v ~/docker/mysql/data:/var/lib/mysql \
    -e MYSQL_ROOT_PASSWORD=root  \
    -d mysql:5.7
    ```
* Launch bash for mysql container:
    ```
    docker exec -it mysql /bin/bash
    ```
* Within mysql container, run the following command to launch mysql client:
    ```
    mysql -uroot -proot --default-character-set=utf8
    ```
* create ```mall``` database:
    ```
    create database mall character set utf8;
    ```
* Download [```document/sql/mall.sql```](https://github.com/macrozheng/mall/blob/master/document/sql/mall.sql) to local as ```mall.sql```.
* Copy ```mall.sql``` to mysql container, and make sure the file successful copied into mysql container:
    ```
    docker cp mall.sql mysql:/
    ```
* Execute ```mall.sql``` to create tables, and fill in test data:
    ```
    use mall;
    source /mall.sql;
    ```
* Create a new mysql account with permission:
    ```
    grant all privileges on *.* to 'reader' @'%' identified by '123456';
    ```
* Launch MySQL Workbench and make sure you are able to connect the database with reader account.
### Redis
* Pull redis 7 container image:
    ```
    docker pull redis:7
    ```
* Create Redis container:
    ```
    sudo docker run -p 6379:6379 --name redis \
    -v ~/docker/redis/data:/data \
    -d redis:7 redis-server --appendonly yes
    ```
* Launch redis client:
    ```
    docker exec -it redis redis-cli
    ```
* Within redis client, run the following command to make sure redis is properly installed:
    ```
    127.0.0.1:6379> set hello 123
    OK
    127.0.0.1:6379> get hello
    "123"
    ```
### Nginx
* Pull Nginx 1.22 container image:
    ```
    docker pull nginx:1.22
    ```
* Create Nginx container:
    ```
    sudo docker run -p 80:80 --name nginx \
    -v ~/docker/nginx/html:/usr/share/nginx/html \
    -v ~/docker/nginx/logs:/var/log/nginx  \
    -d nginx:1.22
    ```
* Copy file from container to host for update:
    ```
    docker container cp nginx:/etc/nginx ~/docker/nginx/
    ```
* Update file name:
    ```
    mv ~/docker/nginx/nginx ~/docker/nginx/conf
    ```
* Stop and remove nginx container:
    ```
    docker stop nginx
    docker rm nginx
    ```
* Create the nginx container again:
    ```
    sudo docker run -p 80:80 --name nginx \
    -v ~/docker/nginx/html:/usr/share/nginx/html \
    -v ~/docker/nginx/logs:/var/log/nginx  \
    -v ~/docker/nginx/conf:/etc/nginx \
    -d nginx:1.22
    ```
* launch [http://localhost/index.html](http://localhost/index.html) to verify the nginx is successful configrated.
### RabbitMQ
* See details with [RabitMQ section](https://www.macrozheng.com/mall/deploy/mall_deploy_docker.html#rabbitmq%E5%AE%89%E8%A3%85).
* Pull rabbitmq3.9-management container image:
    ```
    docker pull rabbitmq:3.9-management
    ```
* Create RabbitMQ container:
    ```
    sudo docker run -p 5672:5672 -p 15672:15672 --name rabbitmq \
    -d rabbitmq:3.9-management
    ```
* Launch [http://localhost:15672](http://localhost:15672) and login with username ```guest```, password ```guest```.
* Navigate to ```Admin``` tab.
* Select ```Users``` from right pannel. Click ```Add a user``` button to ceate a new account with username ```mall```, password ```mall```, and set the Tag as ```Admin```.
* Select ```Virtual Hosts``` from right pannel. Click ```Add a new virtual host``` button to create a new virtual host with name ```/mall```.
* Select ```Users``` from right pannel again, and click the new created user ```mall```. Change the Virtual Host to ```/mall``` and click Set permission button.
### Elasticsearch
* Pull Elasticsearch 7.17.3 container image:
    ```
    docker pull elasticsearch:7.17.3
    ```
* Create Elasticsearch container:
    ```
    sudo docker run -p 9200:9200 -p 9300:9300 --name elasticsearch \
    -e "discovery.type=single-node" \
    -e "cluster.name=elasticsearch" \
    -e "ES_JAVA_OPTS=-Xms512m -Xmx1024m" \
    -v ~/docker/elasticsearch/plugins:/usr/share/elasticsearch/plugins \
    -v ~/docker/elasticsearch/data:/usr/share/elasticsearch/data \
    -d elasticsearch:7.17.3
    ```
* Download IKAnalyzer (.zip) file from this [link](https://github.com/medcl/elasticsearch-analysis-ik/releases/tag/v7.17.3), and unzip it and rename the folder into ```analysis-ik```, and move the folder into ```~/docker/elasticsearch/plugins``` folder.
* ***Important!!!*** If you see ```.DS_Store``` file inside the ```~/docker/elasticsearch/plugins``` folder, make sure you remove it.
* Restart Elasticsearch:
    ```
    docker restart elasticsearch
    ```
* Launch [http://localhost:9200](http://localhost:9200) to verify Elasticsearch is successful configurated.
### Logstash
* Pull Logstash 7.17.3 container image (make sure the version is the same as elasticsearch):
    ```
    docker pull logstash:7.17.3
    ```
* Download [logstash.conf](https://github.com/macrozheng/mall/blob/master/document/elk/logstash.conf) file and copy it into ```~/docker/logstash/logstash.conf```.
* Create Logstash container:
    ```
    sudo docker run --name logstash -p 4560:4560 -p 4561:4561 -p 4562:4562 -p 4563:4563 \
    --link elasticsearch:es \
    -v ~/docker/logstash/logstash.conf:/usr/share/logstash/pipeline/logstash.conf \
    -d logstash:7.17.3
    ```
* Execute command for Logstash container to install ```json_lines``` plugin:
    ```
    docker exec -it logstash logstash-plugin install logstash-codec-json_lines
    ```
### Kibana
* Pull Kibana 7.17.3 container image (make sure the version is the same as elasticsearch):
    ```
    docker pull kibana:7.17.3
    ```
* Create Kibana container:
    ```
    sudo docker run --name kibana -p 5601:5601 \
    --link elasticsearch:es \
    -e "elasticsearch.hosts=http://es:9200" \
    -d kibana:7.17.3
    ```
* Launch [http://localhost:5601](http://localhost:5601) to verify is successful Kibana configurated.
### MongoDB
* Pull MongoDB 4 container image:
    ```
    docker pull mongo:4
    ```
* Create Kibana container:
    ```
    sudo docker run -p 27017:27017 --name mongo \
    -v ~/docker/mongo/db:/data/db \
    -d mongo:4
    ```
## Launch Server Project
* Clone [```mall``` project](https://github.com/macrozheng/mall) with command:
    ```
    git clone https://github.com/macrozheng/mall.git
    ```
* Open IntelliJ and load the project.
* Open ```pom.xml``` file and click sync button to download the dependencies.
* Run all the 4 application from IntelliJ:
  * ```MallAdminApplication``` - Launch [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)
  * ```MallPortalApplication``` - Launch [http://localhost:8085/swagger-ui/](http://localhost:8085/swagger-ui/)
  * ```MallSearchApplication``` - Launch [http://localhost:8081/swagger-ui/](http://localhost:8081/swagger-ui/)
  * ```MallDemoApplication``` - Launch [http://localhost:8082/swagger-ui/](http://localhost:8082/swagger-ui/)
## Web Setup
* Install python 2.7.18:
    ```
    brew install pyenv
    pyenv install 2.7.18
    pyenv global 2.7.18
    ```
* Download [node 12](https://nodejs.org/dist/v12.14.0/node-v12.14.0.pkg) and install the package.
* Clone [mall-admin-web](https://github.com/macrozheng/mall-admin-web) with command:
    ```
    git clone https://github.com/macrozheng/mall-admin-web.git
    ```
* Within mall-admin-web folder, add image source:
    ```
    npm config set registry https://registry.npmjs.org
    ```
* Add node-sass:
    ```
    SASS_BINARY_SITE=https://npm.taobao.org/mirrors/node-sass/ npm install node-sass
    ```
* Build mall admin web project:
    ```
    npm install
    ```
* Start mall-admin-web:
    ```
    npm run dev
    ```
* Launch the app with [http://localhost:8090](http://localhost:8090)
* Login with username ```admin```, password ```macro123```.
* If you see [```java.lang.ClassNotFoundException```](https://wtools.io/paste-code/bFgs), please add the following dependency to ```mall-security``` ```pom.xml``` file.
    ```
    <dependency>
        <groupId>javax.xml.bind</groupId>
        <artifactId>jaxb-api</artifactId>
        <version>2.3.0</version>
    </dependency>
    ```