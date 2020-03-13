
## Tecnologias utilizadas

Nessa solução deve utilizada as seguintes tecnologias:
- Java 1.8
- Maven
- SpringBoot 2+
- Git
- H2 Data Base
- Mockito
- jUnit
- Swagger2
## Desafio
> Objetivo
- O RH da empresa solicitou a equipe de Sistemas uma aplicação para gerenciar informações dos colaboradores da empresa.
Seu objetivo é desenvolver uma API Rest para que a equipe de front-end realize as consultas nos endpoints e retorne as informações solicitadas pelo RH.
Crie a API seguindo as orientações abaixo:
> Regras
- Projeto de conter duas branchs *develop* e *feature/crud-seunome* tudo deve ser desenvolvido na branch *feature/crud-seunome* depois realizado um merge para *develop*.
- O prazo de enviar o código é de **48hs** a partir do compartilhamento do repositório
- Enviar para repositório após concluir
- Caso não conclua no prazo, informar em qual fase e item você conseguiu chegar.
> Informações: 
- Banco de dados: **H2**
- Console H2: /h2-console
- Usuario de acesso ao banco de dados: **user**
- Password de acesso ao banco de dados: **password**
- Ao iniciar o projeto a aplicação automaticamente cria Banco de Dados e realiza um insert conforme instrucao SQL
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
## Tarefas
> Fase 01 - Estruturar API
1. No projeto deve conter um pacote **model** 
2. No pacote model deve conter uma Classe *Pessoas* com o seguintes atributos:
```
    private Long id;
    private String first_name;
    private String last_name;
    private String career;
```
3. No projeto deve conter uma pacote com o nome **controller**
4. No pacote controller deve conter uma classe com o nome *PessoasController*
```
public class PessoasController {
    ...
}
```
5. A porta padrão do projeto deve ser ser 9090
6. O context-path da aplicação de ser */api*
7. Os retornos devem usar Spring ResponseEntity para manipular a resposta HTTP
```
import org.springframework.http.ResponseEntity;
```
> Fase 02 - Rotas da API
8. Criar Pessoas */pessoas/adicionar*
* 8.1\. Cadastrar pessoa
* 8.2\. Codigo de retorno esperado *Codigo HTTP 201 Created* ou *Codigo HTTP 200 Ok*
* 8.3\. A api deve retornar o objeto criado
9. Atualizar Pessoa */pessoas/atualizar*
* 9.1\. Atualizar os dados da pessoa cadastradas
* 9.2\. Codigo de retorno *Codigo HTTP 204 No Content*
* 9.3\. A api deve retornar o objeto criado com os dados atualizado
10. Deletar Pessoa */pessoas/**{id}**/deletar*
* 10.1\. Deletar pessoa referente ao {id} informado
* 10.2\. Codigo de retorno *Codigo HTTP 204 No Content*
11. Listar Pessoas */pessoas/listar/*
* 11.1\. Visualizar todas as informações de todas as pessoas.
* 11.2\. Codigo de retorno *Codigo HTTP 200 Ok*
12. O retorno da API deve ser no formato de JSON
> Fase 03 - Validação dos Dados de entrada
13. Todas as rotas deve ser validada para não aceitar valores *null* ou *vazio*, o retorno dos erros de validação deve ser Json informando qual campo apresentou erro.
> Fase 04 - Testes
14. Crie uma classe de teste com o nome *CrudTests*. Usar o framwork *jUnit*
* 14.1\. Crie um metodos de teste para pelo menos uma operação do **CRUD**
15. Criar classe de Teste com o nome *CrudMockTests* e use o framework Mockito para java para testar o metodo */pessoas/cadastrar*
> Fase 05 - Segurança
16. Configure uma Autenticação básica para suas rotas
17. Ignorar a Autenticação básica na rota */listar/pessoas*
> Fase 06 - Tratamento de Exceções
18. Crie um pacote exceptions
* 18.1\. Criar uma classe de exception para tratar erros de pessoas não localizadas *EmployerNotFoundException*.
19. Crie um pacote handle
* 19.1\. Crie uma Exception Handling para tratar o erro da exceção *EmployerNotFoundException*.
> Fase 06 - Deploy
20. Criar um Dockerfile e salve resource do seu projeto
21. Gerar imagem docker baseada no Dockerfile e enviar para o https://hub.docker.com/
> Fase 07 - Bonus
22. Consumir uma api e atualizar o banco de dados na inicializaçāo do projeto
* 22.1\. API - http://5e61af346f5c7900149bc5b3.mockapi.io/desafio03/employer
* 22.2\. Criar documentação da API usando Swagger 2


