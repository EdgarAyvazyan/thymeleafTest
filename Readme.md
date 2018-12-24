# Configuration

## Run Postgres database 
```
docker run -d -p 5432:5432 -e POSTGRES_DB=thymeleaf-test -e POSTGRES_USER=thymeleaf-test -e POSTGRES_PASSWORD=thymeleaf-test --name thymeleaf-test postgres
```