# CRUD System for Clients and Products

This project is a **clients and products management system**, developed with **Spring Boot** on the backend and **HTML/JavaScript** on the frontend. It follows **clean/hexagonal architecture** principles, clearly separating business logic, persistence, and interface.

---

## Project Structure

- **Backend (Spring Boot)**

  - Domain layer (`model`) defines the main entities.
  - Services (`service`) implement business logic.
  - Adapters (`adapter`) connect the domain to persistence (`MongoRepository`) and the web interface.
  - Ports (`port`) define input and output contracts to maintain modularity.

- **Frontend (HTML/JavaScript)**
  - Simple and responsive interface for creating, listing, editing, and deleting clients and products.
  - API communication through `fetch` (GET, POST, PUT, DELETE).
  - Auto-fill functionality for record editing.

---

## Features

- Full CRUD for **clients** and **products**
- Intuitive web interface without external frameworks
- Inline editing with auto-fill
- Confirmation before record deletion
- Modular and scalable structure, ready for integration with a real database or advanced frontend frameworks

---

## Technologies Used

- Java 17
- Spring Boot
- Pure HTML, CSS, and JavaScript
- MongoDB (optional, via Spring Data)

---

## API Endpoints

### Clients

- `GET /clientes` – List all clients
- `GET /clientes/{id}` – Retrieve a client by ID
- `POST /clientes` – Create a new client
- `PUT /clientes/{id}` – Update an existing client
- `DELETE /clientes/{id}` – Delete a client

### Products

- `GET /produtos` – List all products
- `GET /produtos/{id}` – Retrieve a product by ID
- `POST /produtos` – Create a new product
- `PUT /produtos/{id}` – Update an existing product
- `DELETE /produtos/{id}` – Delete a product
