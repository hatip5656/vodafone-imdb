
##  Build image of vodafone-IMDB & run with Docker ##
```bash
mvn clean install
```
```bash
docker build -t poc/imdb-service .
```
```bash
docker run  poc/imdb-service
```
##  Build without docker ##
```bash
mvn clean install
```
```bash
java -jar target/imdb-0.0.1-SNAPSHOT.jar
```

 
# Project UI's #

 Swagger UI *[__http://localhost:9090/imdb/swagger-ui.html#/__](http://localhost:9090/imdb/swagger-ui.html#/)* <br>
 Database Console UI *[__http://localhost:9090/imdb/db-console/__](http://localhost:9090/imdb/db-console/)* <br>
