# product-manager-api
#### API basica para gerenciamento de produtos.
Projeto demonstrativo criado com intuito de iniciar uma estruturação adequada para evidenciar bases iniciais de uma API,
cujo modelo basico desenvolvido fornece endpoints de CRUD de produto.

Desenvolvido utilizando Java e Spring-Boot.

#### TECNOLOGIAS
- Java
- Spring
- Gradle
- PostgreSQL
- JPA
- Liquibase
- JUnit
- Mockito
- Swagger

#### REQUISITOS
- JDK Java 17
- PostgreSQL (pode ser facilmente alterado para qualquer banco)

#### INSTALAÇÃO

- Clonar o projeto do github
```
git clone https://github.com/feelipecb10/product-manager-api.git
```
- Criar banco de dados postgreSQL com o nome 'db_productmanager'
- Em 'src/main/resources/application.properties' altera os dados de conexão com o banco criado
- No 'gradle.properties' altere também os dados da conexão com o banco criado, será necessário para o liquibase acessar o banco.

- Na pasta raiz do projeto, rode no terminal:
```
gradlew update -> para rodar os scripts do liquibase, criar tabelas, realizar insert inicial
gradlew bootRun -> para subir API
```
Esses comandos criaram as tabelas necessárias no banco configurado na configuração de banco do liquibase e subirá a API.<br>

### Swagger
Documentação da API, e interface web interativa para testar as APIs

> http://{ServerAddress}:{port}/swagger-ui.html <br>
> http://{ServerAddress}:{port}/v3/api-docs

### Actuator
> http://{ServerAddress}:{port}/actuator <br>
> http://{ServerAddress}:{port}/actuator/health

### TESTES
Para rodar os testes de unidade/integração de exemplo:
> gradlew test

#### Teste
Implementado por: <br> Felipe Cordeiro Bochnia<br>