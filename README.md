
## Tecnologias utilizadas

☕️Java 1.8 <br>
🍂Maven <br>
🌿 [SpringBoot 2+](https://start.spring.io/) <br>
🛢️ H2 Data Base <br>
📋 Swagger <br>
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
## Funcionalidades

1 - [Rotas da API](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/desafio3/desafio03/controllers/PessoasController.java) (/api)

- Listar Pessoas */pessoas/listar/*

- Adicionar Pessoa */pessoas/adicionar*

```
{
	"first_name": "Josué",
	"last_name": "Mota",
	"career":"Procurando Algo"
}
```

- Atualizar Pessoa */pessoas/**{id}**/atualizar*

- Deletar Pessoa */pessoas/**{id}**/deletar*

2 - Segurança

-  Foi configurado uma [Autentificação básica](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/desafio3/desafio03/config/SegurancaConfig.java) para as rotas. No entanto que na rota */listar/pessoas*  tal autentificação não é necessária.

```
Username: admin
Password: admin
```

3 - Tratamento de Exceções

- Foi construído uma [classe](https://github.com/Josuebmota/ApiSpringBoot/tree/master/src/main/java/com/desafio3/desafio03/exceptions) para tratar os erros, em conjunto de algumas [propriedades](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/resources/ValidationMessages.properties)

4 - Consumindo uma api externa

- [Api](http://5e61af346f5c7900149bc5b3.mockapi.io/desafio03/employer) que  incrementa o banco ao inicializar a aplicação.

	**obs**: Caso essa api externa, não esteja funcionando mais. Remova essa parte do [código](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/example/apispringboot/ApiSpringBootApplication.java).

5 - Implementação do Swagger

- Ao rodar a aplicação acesse: http://localhost:9090/swagger-ui.html#

6 - Testes Unitários e Integração

7 - Docker

-  Para rodar o [DockerFile](https://github.com/Josuebmota/ApiSpringBoot/blob/master/Dockerfile), é importante executar o seguintes comandos:

```
./mvnw package
docker build -t <nameimage> .
```

- O primeiro vai gerar o arquivo .jar e o seguindo vai criar a imagem da aplicação.
- A imagem pode ser baixada no [DockerHub](https://hub.docker.com/r/danmorthus/apispringboot)
- Após criar ou baixar rode o seguinte comando:

```
docker run <nameimage>
```
