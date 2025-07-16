# desafioJr3

# 🛠️ Sistema de Controle de Clientes e Ordens de Serviço

Este projeto é uma API REST desenvolvida em Java com Spring Boot para o gerenciamento de **clientes** e suas **ordens de serviço**, comum em oficinas, prestadoras de serviços ou assistências técnicas.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Bean Validation (Jakarta)
- MySQL (via Docker)
- Lombok
- Docker (para o banco)
- Maven

---

## 📦 Funcionalidades

- ✅ Cadastro de clientes
- ✅ Criação de ordens de serviço
- ✅ Listagem de ordens por cliente
- ✅ Filtro de ordens por status
- ✅ Validação de dados com Bean Validation
- ✅ Relacionamento entre entidades (`@ManyToOne` / `@OneToMany`)
- ✅ Tratamento de exceções global
- ✅ Conexão com banco de dados MySQL rodando em container Docker

---

## 🔗 Endpoints principais

### 👤 Cliente

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/clients` | Cadastrar novo cliente |
| `GET` | `/clients/{id}/orders` | Listar ordens de serviço de um cliente |

### 📋 Ordem de Serviço

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/orders` | Criar nova ordem de serviço |
| `GET` | `/orders/{id}/status` | Ver status de uma ordem |
| `GET` | `/orders?status=STATUS` | Listar ordens por status |

---

## 🧪 Exemplo de criação de cliente

```json
POST /clients

{
  "name": "João da Silva",
  "email": "joao@email.com",
  "phone": "(84)91234-5678"
}
🧾 Exemplo de criação de ordem
json
Copy
Edit
POST /orders

{
  "clientId": 1,
  "description": "Troca de motor",
  "price": 550.0,
  "status": "ABERTA"
}
🗂️ Como executar o projeto localmente
Clone este repositório:
git clone https://github.com/seu-usuario/desafio-os.git
cd desafio-os


Crie o container MySQL com Docker:
docker run --name desafio-mysql -e MYSQL_ROOT_PASSWORD=Enos!2486 -e MYSQL_DATABASE=desafioOS -p 3308:3306 -d mysql:8.0

Execute o projeto no IntelliJ ou via terminal:
./mvnw spring-boot:run

A aplicação estará disponível em:
📍 http://localhost:8080

⚠️ Observações
O banco está configurado no arquivo application.yml para acessar o MySQL na porta 3308.

O projeto utiliza ddl-auto: update, portanto as tabelas serão geradas automaticamente.

📌 Futuras melhorias (to-do)
Atualização de status da OS (PUT /orders/{id}/status)

Documentação Swagger

Testes com JUnit e MockMvc

Paginação de listagens

👨‍💻 Autor
Desenvolvido por Enos Rocha

