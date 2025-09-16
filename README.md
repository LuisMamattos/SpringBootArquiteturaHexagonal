# Sistema CRUD de Clientes e Produtos

Este projeto é um **sistema de gerenciamento de clientes e produtos**, desenvolvido com **Spring Boot** no backend e **HTML/JavaScript** no frontend. Ele segue princípios de **arquitetura limpa (Clean/Hexagonal)**, separando claramente lógica de negócio, persistência e interface.

---

## Estrutura do Projeto

- **Backend (Spring Boot)**

  - Camada de domínio (`model`) define as entidades principais.
  - Serviços (`service`) implementam a lógica de negócio.
  - Adapters (`adapter`) conectam o domínio à persistência (`MongoRepository`) e à interface web.
  - Ports (`port`) definem contratos de entrada e saída para manter a modularidade.

- **Frontend (HTML/JavaScript)**
  - Interface simples e responsiva para cadastro, listagem, edição e exclusão de clientes e produtos.
  - Comunicação com a API através de `fetch` (GET, POST, PUT, DELETE).
  - Funcionalidade de preenchimento automático para edição de registros.

---

## Funcionalidades

- CRUD completo de **clientes** e **produtos**
- Interface web intuitiva, sem frameworks externos
- Edição inline com preenchimento automático
- Confirmação antes de exclusão de registros
- Estrutura modular e escalável, pronta para integração com banco de dados real ou frameworks de frontend mais avançados

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- HTML, CSS e JavaScript puro
- MongoDB (opcional, via Spring Data)

---

## Endpoints da API

### Clientes

- `GET /clientes` – Lista todos os clientes
- `GET /clientes/{id}` – Busca um cliente pelo ID
- `POST /clientes` – Cria um novo cliente
- `PUT /clientes/{id}` – Atualiza um cliente existente
- `DELETE /clientes/{id}` – Remove um cliente

### Produtos

- `GET /produtos` – Lista todos os produtos
- `GET /produtos/{id}` – Busca um produto pelo ID
- `POST /produtos` – Cria um novo produto
- `PUT /produtos/{id}` – Atualiza um produto existente
- `DELETE /produtos/{id}` – Remove um produto
