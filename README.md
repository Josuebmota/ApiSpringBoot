
## Tecnologias utilizadas

- Java 1.8
- Maven
- [SpringBoot 2+](https://start.spring.io/)
- H2 Data Base

## Ferramentas Utilizadas

- [Vs Code](https://code.visualstudio.com/docs/languages/java)
- [Postman](https://www.postman.com/)

## Informações
- Banco de dados: [**H2**](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/resources/application.properties)
- Console H2: /h2-console
- Usuario de acesso ao banco de dados: **user**
- Password de acesso ao banco de dados: **password**
- Ao iniciar o projeto a aplicação automaticamente cria Banco de Dados e realiza um insert conforme instrucao [SQL](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/resources/data.sql).
```sql
DROP TABLE IF EXISTS Pessoas;

CREATE TABLE Pessoas (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

INSERT INTO Pessoas (first_name, last_name, career) VALUES
('Aliko', 'Dangote', 'Billionaire Industrialist'),
('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');
```
## Funcionalidades

> 1 - [Rotas da API](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/desafio3/desafio03/controllers/PessoasController.java) (/api)

1. Listar Pessoas */pessoas/listar/*

![](https://user-images.githubusercontent.com/34459397/76682336-1488b180-65da-11ea-99ad-de38afdb48a2.png)

2. Adicionar Pessoa */pessoas/adicionar*

![](https://user-images.githubusercontent.com/34459397/76682339-1d798300-65da-11ea-8e00-a1106d9b1a60.png)

3. Deletar Pessoa */pessoas/**{id}**/deletar*

![](https://user-images.githubusercontent.com/34459397/77826297-4d05b080-70ed-11ea-9482-209e2b6d589f.png)

4. Atualizar Pessoa */pessoas/**{id}**/atualizar*

![](https://user-images.githubusercontent.com/34459397/77826486-87bc1880-70ee-11ea-8c98-09a289ed0461.png)

> 2 - Segurança

5. Foi configurado uma [Autentificação básica](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/desafio3/desafio03/config/SegurancaConfig.java) para as rotas

![](https://user-images.githubusercontent.com/34459397/76682372-721cfe00-65da-11ea-917a-975e743127e2.png)

6. Sendo que na rota */listar/pessoas* a Autenticação básica é ignorada 

> 3 - [Tratamento de Exceções](https://github.com/Josuebmota/ApiSpringBoot/tree/master/src/main/java/com/desafio3/desafio03/exceptions)

7. Foi construido uma classe para tratar os erros em conjunto de algumas [propriedades](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/resources/ValidationMessages.properties)

## Atividades Futuras

> 1 - Deploy
1. Criar um Dockerfile e salvar resource do projeto
2. Gerar imagem docker baseada no Dockerfile e enviar para o https://hub.docker.com/
> 2 - Consumir uma api externa
3. Esta [API](http://5e61af346f5c7900149bc5b3.mockapi.io/desafio03/employer) deve atualizar o banco na inicialização do projeto
> 3 - Swagger
4. Criar documentação da API usando Swagger2.
