# carro
Spring Rest, Swagger, JPA, MySQL

### POST
```
curl -X POST \
  http://localhost:8080/carro/criar \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: b5c7ca43-d59e-4203-9c14-eb9cec7d6b65' \
  -H 'cache-control: no-cache' \
  -d '{
    "modelo": "Teste",
    "cor": "Branco",
    "localidade": {
        "rua": "Teste",
        "bairro": "Teste",
        "cidade": "Teste",
        "estado": "Teste",
        "longitude": 12345,
        "latitude": -12345
    },
    "ativo": 1
}'
``` 

------

### MYSQL
```
create schema rest;

use rest;

create table carro(idcarro int(11) not null auto_increment, primary key(idcarro));

create table localidade(id int(11) not null, primary key(id));
```
