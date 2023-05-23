# Projeto de CRUD de produtos com Springboot

Este projeto tem como objetivo criar um CRUD (Create, Read, Update e Delete) de produtos utilizando o framework Springboot e as dependências spring-boot-starter-web, spring-boot-starter-data-jpa, spring-boot-devtools, lombok e h2.

## Configuração do Banco de Dados
Foi utilizado o banco de dados H2, que é um banco de dados em memória. Para acessar o console do banco de dados, utilize o caminho /h2-console na URL do projeto. As credenciais para acesso ao banco de dados são:

**Username: admin**

**Password: admin**

O arquivo *application.yaml* contém a configuração do banco de dados, que pode ser atualizado conforme sua necessidade.

```yaml
spring:
  datasource:
    driverClassName: org.h2.Driver
    url: jdbc:h2:mem:produtos
    username: admin
    password: admin
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        format_sql: true
        show_sql: true 
```

## DTO e Conversão
Para a comunicação entre a camada de controle e a camada de persistência, foi utilizado o padrão DTO (Data Transfer Object). Além disso, foi criada uma pasta Convert, que contém as classes de conversão entre DTO e entidade.

## Funcionalidades
As funcionalidades do projeto são:

Busca de um produto por id
Busca de todos os produtos
Adição de um novo produto
Edição de um produto existente
Exclusão de um produto existente


## Execução do Projeto
Para executar o projeto, é necessário ter o Java e o Maven instalados na máquina. Em seguida, execute o seguinte comando na raiz do projeto:

```arduino
mvn spring-boot:run
```
Acesse o seguinte caminho no seu navegador para visualizar a documentação da API:


```bash
http://localhost:8080/swagger-ui.html
```

## Considerações Finais
Espero que este README possa ajudar a entender melhor o projeto! Qualquer dúvida ou sugestão, não hesite em entrar em contato.
