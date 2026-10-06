# DimDim – CP5 DevOps Tools & Cloud Computing

> Projeto pronto para IntelliJ, adaptado ao Azure SQL criado no CP5. Leia `ABRIR-NO-INTELLIJ.txt` antes da primeira execução.

Aplicação Java Spring Boot + Thymeleaf conectada ao Azure SQL Database. O projeto implementa CRUD completo de **Usuario** e **Transacao**, com relacionamento 1:N.

## Integrantes
- Vitor Madrigrano — RM 564191
- Thiago Sposito — RM 561694

## Azure criado para o CP
- Resource Group: `rg-dimdim-cp5` (Central US)
- Azure SQL Server: `sql-dimdim-cp5-561694.database.windows.net` (Canada Central)
- Database: `DimDimDB`
- Usuário SQL: configurado por variável de ambiente; senha nunca deve ser versionada.

## Banco
Execute `scripts/ddl.sql` apenas em um banco vazio. O banco atual já possui as tabelas `Usuario` e `Transacao` criadas.

Estrutura:
- Usuario: `id`, `nome`, `email`
- Transacao: `id`, `descricao`, `valor`, `tipo`, `data_transacao`, `usuario_id`
- `Transacao.usuario_id` referencia `Usuario.id`.

## Executar localmente
Defina a senha do SQL na variável de ambiente `SPRING_DATASOURCE_PASSWORD`. A URL JDBC e o usuário têm defaults em `application.properties`; também podem ser sobrescritos por `SPRING_DATASOURCE_URL` e `SPRING_DATASOURCE_USERNAME`.

No IntelliJ, adicione `SPRING_DATASOURCE_PASSWORD` em Run > Edit Configurations > Environment variables e execute `DimdimApplication`.

## Endpoints Web
- `/` início
- `/dashboard` dashboard
- `/usuarios` CRUD de usuários
- `/transacoes` CRUD de transações

## API REST
- GET/POST `/api/usuarios`
- GET/PUT/DELETE `/api/usuarios/{id}`
- GET/POST `/api/transacoes`
- GET/PUT/DELETE `/api/transacoes/{id}`

Exemplos/resumo em `api/operacoes.json`.

## Deploy
Os scripts exigidos estão em `scripts/`:
- `config.sh`: nomes dos recursos
- `infra.sh`: criação automatizada da infraestrutura via Azure CLI
- `deploy.sh`: build Maven + `az webapp deploy`
- `cleanup.sh`: remoção dos recursos
- `ddl.sql`: DDL das tabelas

As credenciais são fornecidas por variáveis/App Settings e não ficam no repositório.
