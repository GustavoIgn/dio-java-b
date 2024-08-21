# API de To-Do List - Projeto Individual

Desenvolvi uma API de To-Do List utilizando Java 17 com Spring Boot 3, integrando tecnologias modernas para oferecer uma solução robusta e eficiente.

## Principais Tecnologias

Java 17: Aproveitei a versão LTS mais recente para garantir o uso das últimas inovações da linguagem, promovendo um desenvolvimento eficiente e atualizado.

Spring Boot 3: Utilizei a mais recente versão do Spring Boot para maximizar a produtividade com sua poderosa autoconfiguração e integração simplificada.

Spring Data JPA: Implementado para facilitar a camada de acesso aos dados e a integração com bancos de dados SQL de forma simplificada e eficaz.

OpenAPI (Swagger): Criei uma documentação de API clara e compreensível, utilizando OpenAPI para garantir que a API seja bem documentada e fácil de usar.

Railway: Utilizei Railway para deploy e monitoramento na nuvem, aproveitando suas funcionalidades para bancos de dados como serviço e pipelines de CI/CD.

```mermaid
classDiagram
    class Todo {
        -Long id
        -String title
        -Boolean completed
    }

    class TodoList {
        -Long id
        -List<TodoItem> items
    }

    class User {
        -Long id
        -String username
        -String password
        -List<TodoList> todoLists
    }

    Todo --> TodoList : belongs to
    TodoList --> User : owned by
