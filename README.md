<h1 align = "center">
<strong>☕️ApiSpringBoot </strong>
</h1>

<p align="center">
   <a href="https://www.linkedin.com/in/josu%C3%A9-batista-694bba135/">
      <img alt="Josué Batista" src="https://img.shields.io/badge/-JosuéBatista-ff8c00?style=flat&logo=Linkedin&logoColor=white" />
   </a>
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/Josuebmota/ApiSpringBoot?color=ff8c00">
  <a href="https://github.com/Josuebmota/ApiSpringBoot/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/Josuebmota/ApiSpringBoot?color=ff8c00">
  </a> 
  <a href="https://github.com/Josuebmota/ApiSpringBoot/blob/master/LICENSE"><img alt="License" src="https://img.shields.io/badge/license-MIT-ff8c00">
  </a>
  <a href="https://github.com/Josuebmota/ApiSpringBoot/stargazers"><img alt="Stargazers" src="https://img.shields.io/github/stars/Josuebmota/ApiSpringBoot?color=ff8c00&logo=github">
  </a>
</p>

##  📌 Tecnologias utilizadas
🍂Maven - Tecnologia de automação de compilação utilizada em primariamente em projetos Java.<br>
🌿 SpringBoot 2 - Facilita o processo de configurações e publicações. <br>
🛢️ H2 Data Base - Sistema de gerenciamento de banco de dados relacional. <br>
🐳 Docker - Criação de ambientes isolados via container <br>
📋 Swagger - Documenta os serviços de Web RestFul <br>
🔎Junit - Utilizado para criação de testes automatizados<br>

## 🛠️ Ferramentas Utilizadas
- [Vs Code](https://code.visualstudio.com/docs/languages/java)
- [Insomnia](https://insomnia.rest/download/)

## 📕 Informações
- Banco de dados: **H2**
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

## 🚀 Execução

Após efetuar o download e certificar que seu pc possui o java instalado, siga os passos:

```
# Clone o repositório
git clone https://github.com/Josuebmota/ApiSpringBoot.git

# Vá para o diretório do arquivo
cd ApiSpringBoot
```
Siga ate o arquivo [principal](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/example/apispringboot/ApiSpringBootApplication.java) e execute no seu vscode ou eclipse

Afim de facilitar os testes das rotas, efetue o download do arquivo abaixo:

>[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=ApiSpringBoot&uri=https%3A%2F%2Fraw.githubusercontent.com%2FJosuebmota%2FApiSpringBoot%2Fmaster%2FInsomnia.json)

## 🍄 Funcionalidades

- ♻️ ***Rotas da API***
	 - Listar Pessoas: */api/pessoas/listar/*
	- Adicionar Pessoa: */pessoas/adicionar*

	      {
	          "first_name": "Josué", 
	          "last_name": "Mota",
	          "career":"Procurando Algo"
	      }

	- Atualizar Pessoa: */pessoas/**{id}**/atualizar*

	- Deletar Pessoa: */pessoas/**{id}**/deletar*

- 🔐 ***Segurança*** <br>
Foi configurado uma [Autentificação básica](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/desafio3/desafio03/config/SegurancaConfig.java) para as rotas. No entanto, na rota de listagem de usuários, tal autentificação não é necessária.

	   Username: admin
	   Password: admin

- ⛔ ***Tratamento de Exceções*** <br>
Foi construído uma [classe](https://github.com/Josuebmota/ApiSpringBoot/tree/master/src/main/java/com/desafio3/desafio03/exceptions) para tratar os erros, em conjunto de algumas [propriedades](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/resources/ValidationMessages.properties).

- 🥣 ***Consumindo uma api externa*** <br>
[Api](http://5e61af346f5c7900149bc5b3.mockapi.io/desafio03/employer) que  incrementa o banco ao inicializar a aplicação. <br>**obs**: Caso essa api externa, não esteja funcionando mais. Remova essa parte do [código](https://github.com/Josuebmota/ApiSpringBoot/blob/master/src/main/java/com/example/apispringboot/ApiSpringBootApplication.java).

- 🔎 ***Testes Unitários e Integração***<br>
Testes voltados para as ações de criação, listagem, atualização e delete dos dados cadastrados. <br>  **obs** : para realizar os testes é necessario que a aplicação esteja rodando

- 🍏 ***Swagger*** <br>
Afim de trazer entedimento de cada rota desta api, basta ao rodar à aplicação, acessar está url: <br>
> http://localhost:9090/swagger-ui.html#

-  🐋 ***Docker*** <br>
Para rodar o DockerFile, é importante executar o seguintes comandos:

	    ./mvnw package
	    docker build -t <nameimage> .
	    docker run <nameimage>
      O primeiro comando, ira gerar o arquivo *.jar* , o segundo criará a imagem da aplicação e o terceiro executará o container.<br> **obs**: Caso queira efetuar o download da imagem, acesse o [DockerHub](https://hub.docker.com/r/danmorthus/apispringboot).

## 🐛 Problemas

Sinta-se a vontade de registrar um novo problema, com um respectivo título e descrição no repositório do [ApiSpringBoot](https://github.com/Josuebmota/ApiSpringBoot/issues). Se encontrar a solução, avaliarei seu Pull Request.

## 👨‍💻 [](<[https://github.com/Josuebmota/ApiSpringBoot](https://github.com/Josuebmota/ApiSpringBoot)#autor>)Autor

Criado por [**Josué Batista Mota** ](https://github.com/Josuebmota), <br>esse projeto está sobre [MIT license](./LICENSE) 📃.

Coloque uma ⭐️ caso esse proejto tenha lhe ajudado
