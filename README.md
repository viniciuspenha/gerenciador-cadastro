# gerenciador-cadastro

Esta API tem como objetivo gerenciar o cadastro de automoveis.

# Config
### DB
Para inicializar o banco de dados MySql:
```
docker-compose up dbmysql
```

### Build
Buildar o projeto usando o maven:
```
mvn clean install
```

### Run
Após isso execute o comando abaixo para inicializar a aplicaçao na porta 8080:
```
mvn spring-boot:run
```

#Endpoints
- Para criar um novo automovel:
```
Post: localhost:8080/automovel
Body: {
      	"modeloId" : 1,
      	"valor" : 150000.00
      }
```

- Para listar todos os automoveis:
```
Get: localhost:8080/automovel
```

- Para buscar um automovel por id:
```
Get: localhost:8080/automovel/{id}
```