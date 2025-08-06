# API de Produtos com Spring Boot

API RESTful para gerenciamento de produtos desenvolvida com Spring Boot.

## Tecnologias
- Java 21
- Spring Boot 3.5.4
- Spring Data JPA
- H2 Database
- RESTful API

## Funcionalidades
- Cadastro de produtos
- Listagem de produtos
- Busca por ID
- Atualização
- Exclusão
  
# Como executar

## Pré-requisitos:
- Java 21 [(https://www.oracle.com/br/java/technologies/downloads/#java21)]
- IDE IntelliJ [(https://www.jetbrains.com/pt-br/idea/download/?section=windows)]
- Postman para testar endpoints [(https://www.postman.com/downloads)]

## Passo a Passo

Crie uma pasta com o nome "api-products-spring"

Abra o cmd e digite os seguintes comandos

```
cd caminho-da-pasta\api-products-spring
git clone https://github.com/CdBr4zil/api-products-spring.git
```

Abra a pasta no IntelliJ e execute o "ProductsApiApplication"

Ao executar, a URL do H2 Database será imprimida no console, abrindo o H2 Database insira as credenciais:
```
JDBC URL: jdbc:h2:mem:product
User Name: admin
Password: admin
```

## Endpoints

Para utilizar os endpoints, abra o Postman, coloque os metodos requisitados na tabela abaixo, e na URL coloque http://localhost:8080/endpoint-da-tabela

| Método | Endpoint           | Descrição               |
|--------|--------------------|-------------------------|
| POST   | /products          | Cria novo produto       |
| GET    | /products          | Lista todos os produtos |
| GET    | /products/:id      | Busca produto por ID    |
| PUT    | /products/:id      | Atualiza produto        |
| DELETE | /products/:id      | Exclui produto          |

Exemplo:

POST - http://localhost:8080/products
```
{
  "name":"Smartphone", 
  "description":"Android 128GB", 
  "price":1599.90
}
```

## Estrutura do projeto
```
src/
├── main/
│   ├── java/
│   │   └── com/exemplo/apiproducts/
│   │       ├── controller/   # Controladores REST
│   │       │  └── ProductController.java
│   │       ├── model/        # Entidades JPA
│   │       │  └── Product.java
│   │       ├── repository/   # Repositórios de dados
│   │       │  └── ProductRepository.java
│   │       └── ProductsApiApplication.java # Classe principal
│   └── resources/
│       ├── application.yml           # Configurações
│       └── data.sql                  # Dados iniciais
```
