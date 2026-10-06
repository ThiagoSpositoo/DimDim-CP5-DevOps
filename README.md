# DimDim App — CP5 DevOps

Projeto desenvolvido para o **Checkpoint 5**, com o objetivo de implementar uma aplicação web integrada a banco de dados em nuvem e realizar sua publicação utilizando serviços do Microsoft Azure.

## Integrantes

| Nome | RM |
| Vitor Madrigrano | RM 564191 |
| Thiago Sposito | RM 561694 |

## Sobre o projeto

O **DimDim App** é uma aplicação web para gerenciamento de usuários e movimentações financeiras.

A aplicação permite:

- Cadastrar usuários;
- Editar e excluir usuários;
- Registrar transações;
- Classificar transações como entrada ou saída;
- Relacionar transações aos usuários;
- Consultar o histórico de movimentações;
- Visualizar um dashboard com saldo, entradas, saídas e últimas transações.

## Tecnologias utilizadas

- Java 25
- Spring Boot
- Spring Data JPA
- Maven
- HTML
- CSS
- Azure SQL Database
- Azure App Service
- Microsoft Azure

## Banco de dados

O projeto utiliza um **Azure SQL Database** para persistência dos dados.

As informações de conexão sensíveis, como a senha do banco, são configuradas através de variáveis de ambiente e não são armazenadas diretamente no código-fonte.

## Deploy

A aplicação foi compilada e publicada no **Azure App Service**, utilizando:

- Java 25
- Linux
- Java SE (Embedded Web Server)
- Azure App Service
- Azure SQL Database

O projeto foi testado tanto em ambiente local quanto no ambiente publicado no Azure.

## Vídeo de apresentação

O vídeo demonstra o funcionamento do projeto, a infraestrutura utilizada e a aplicação publicada no Azure.

**[▶ Assistir ao vídeo de apresentação no YouTube](https://youtu.be/lcajc1MeWwQ)**

## Funcionalidades demonstradas

- Aplicação Spring Boot em execução;
- Conexão com Azure SQL Database;
- Cadastro e gerenciamento de usuários;
- Cadastro e gerenciamento de transações;
- Dashboard financeiro;
- Persistência dos dados no banco;
- Deploy da aplicação no Azure App Service;
- Acesso à aplicação através do ambiente em nuvem.


Checkpoint 5 — DevOps / Cloud Computing
