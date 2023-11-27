# TrafficVision - Backend

Este é o backend do TrafficVision, desenvolvido com Spring 3, Java 17, Spring Security 6 e PostgreSQL. A documentação da API está disponível aqui.

## Sobre o Projeto

O backend do TrafficVision é responsável por gerenciar a lógica de negócios, autenticação, e comunicação com o banco de dados PostgreSQL. Foi desenvolvido para suportar as funcionalidades de autenticação de usuários, cadastro e gerenciamento de dados relacionados às ruas.

## Tecnologias Utilizadas

  - Spring Boot 3
  - Java 17
  - Spring Security 6
  - PostgreSQL

## Executar em modo de Desenvolvimento

Certifique-se de ter o Java 17 instalado em sua máquina. O projeto utiliza o Maven para gerenciamento de dependências.

  - Configure as variáveis de ambiente

```bash
DB_URL
DB_USERNAME
DB_PASSWORD
JWT_SECRET 
WEB_URL # url do frontend
```

  - Para iniciar o backend, utilize o seguinte comando:
```bash
mvn spring-boot:run
```
 
 A api estará rodando em `http://localhost:8080/`

 ## Documentação da API

A documentação detalhada da API pode ser encontrada [aqui](https://traffic-vision-74e8dddd00ed.herokuapp.com/swagger-ui/index.html).
