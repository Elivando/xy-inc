#Teste projeto backend Zup 

O projeto visa a criação de aplicação backend para gerenciamento de cadastro de Products através do Recurso REST.

####1) Configuração:

- MySQL: 
O banco de dados utlizado no projeto foi o MySql é necessario que o mesmo esteja instalado na maquina para execução dos testes. O MySql é gratuito é pode ser baixado através do link: (http://www.mysql.com/downloads/). É possível utilizar outro banco de dados para testes, porém é necessária a inclusão do driver competente como dependência utilizando o Maven e alterar o driver que esta sendo utilizado no arquivo persistence.xml

- Configurar Tomcat7: 
O servidor web utilizado para os testes foi o tomcat7. Se não estiver configurado fazer download da versão 7 através do link https://tomcat.apache.org/download-70.cgi

- Banco de Dados:
Criar um database com o nome de “zup_xy-inc” ex: CREATE DATABASE 'zup_xy-inc'; Dar permissões de escrita para o usuário criado no database conforme necessário.

- Deploy:
Após executar todos os passos anteriores, Acessar a pasta onde o projeto yx-inc-backend foi baixado ou descompactado. 
Executar o comando de deploy: 
  1. Project -> Clean
  2. Project -> Right click -> Maven -> Update Project
  3. Project -> Right click -> Run As.. -> Maven Build (option 5) -> Add "clean install"

 Acessar: http://localhost:8080/xy-inc-backend/rest/products/ 
 
####2) Testes:
Para desenvolver os testes da aplicação foram usados os frameworks: JUnit, Rest-Assured. 
Basta executar o projeto através do Run -> JUnit Test nas classes "ProductServiceTest" e "ProductRestServiceTest".
O Rest-Assured é usado para testar a integração da aplicação, ele permite desenvolver os testes para camada REST.

- API REST:
 - GET http://localhost:8080/xy-inc-backend/rest/products (Lista todos os produtos cadastrados).
 - GET http://localhost:8080/xy-inc-backend/rest/products/{id} (Busca o produto pelo id).
 - POST http://localhost:8080/xy-inc-backend/rest/products (Adiciona um novo produto - HEADER Content-Type: application/json BODY {"name":"Refrigerator","description":"Test","category":"Electronic","price":500.00}).
 - PUT http://localhost:8080/xy-inc-backend/rest/products (Alterar produto HEADER Content-Type: application/json BODY {"id": 1,"name":"Car","description":"test test","category":"Other", "price":20000.98}).
 - DELETE http://localhost:8080/xy-inc-backend/rest/products/{id} (Remover produto HEADER Content-Type: application/json).

 Será retornado status código 200 para sucesso e em caso erros é retornado o código status e a mensagem do erro.

####3) Projeto:
  Foi utilizado para o desenvolvimento as seguintes tecnologinas:
  - IDE: Eclipse Java EE IDE for Web Developers Neon 4.6. 
  - Servidor de Aplicação: Tomcat7. 
  - Banco de dados: MySQL. 
  - Frameworks de testes: JUnit, Rest-Assured.
  - Outros:  JPA 2.1, etc.
  
O projeto é uma aplicação inicial simples, porem que pode crescer e se transformar em uma aplicação mais completa e robustas. 
Foi desenvolvida a camada REST com os serviços métods GET,POST, PUT e DELETE para faclitar a integração entre outras aplicações (no casso o app mobile ),que por sua vez acessa a camada de persistencia dos dados. 
Os testes unitarios implementados na aplicação, permite cobertura de testes, extensibilidade, manutenibilidade o que gera maior qualidade a aplicação além de um desenvolvimento agil.
 
