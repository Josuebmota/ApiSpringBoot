
## Tecnologias utilizadas
☕️Java 1.8
🍂Maven
🌿 [SpringBoot 2+](https://start.spring.io/) 
🛢️ H2 Data Base 
📋 Swagger
🔎Junit

## Ferramentas Utilizadas
- [Vs Code](https://code.visualstudio.com/docs/languages/java)
- [Insomnia](https://insomnia.rest/download/)

## Informações
- Banco de dados: [**H2**](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/resources/application.properties)
- Console H2: /h2-console
- Usuario de acesso ao banco de dados: **user**
- Password de acesso ao banco de dados: **password**
- Ao iniciar o projeto a aplicação automaticamente cria Banco e a tabela pessoas

```sql
DROP TABLE IF EXISTS Pessoas;

CREATE TABLE Pessoas (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);
```
## Execução
Após efetuar o download e certificar que seu pc possui o java instalado, acesse o arquivo [principal](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/example/apispringboot/ApiSpringBootApplication.java) e execute.

## Funcionalidades

#### Rotas da API

- Listar Pessoas: */api/pessoas/listar/*

- Adicionar Pessoa: */pessoas/adicionar*
```
{
    "first_name": "Josué", 
    "last_name": "Mota",
    "career":"Procurando Algo"
}
```

- Atualizar Pessoa: */pessoas/**{id}**/atualizar*

- Deletar Pessoa: */pessoas/**{id}**/deletar*

#### Segurança

Foi configurado uma [Autentificação básica](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/desafio3/desafio03/config/SegurancaConfig.java) para as rotas. No entanto, na rota de listagem de usuários, tal autentificação não é necessária.
```
Username: admin
Password: admin
```

#### Tratamento de Exceções
Foi construído uma [classe](https://github.com/Josuebmota/ApiSpringBoot/tree/master/src/main/java/com/desafio3/desafio03/exceptions) para tratar os erros, em conjunto de algumas [propriedades](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/resources/ValidationMessages.properties).

#### Consumindo uma api externa
[Api](http://5e61af346f5c7900149bc5b3.mockapi.io/desafio03/employer) que  incrementa o banco ao inicializar a aplicação.
*obs*: Caso essa api externa, não esteja funcionando mais. Remova essa parte do [código](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/example/apispringboot/ApiSpringBootApplication.java).

#### Implementação do Swagger
Ao rodar a aplicação acesse: http://localhost:9090/swagger-ui.html#

#### Testes Unitários e Integração
Testes voltados para as ações de criação, listagem, atualização e delete dos dados cadastrados.
*obs* : para realizar os testes é necessario que a aplicação esteja rodando

####  Docker

Para rodar o DockerFile, é importante executar o seguintes comandos:
```
./mvnw package
docker build -t <nameimage> .
docker run <nameimage>
```
O primeiro comando, ira gerar o arquivo *.jar* , o segundo criará a imagem da aplicação e o terceiro executará o container.

*obs*: Caso queira efetuar o download da imagem, acesse o [DockerHub](https://hub.docker.com/r/danmorthus/apispringboot).
