# 🧩 Sistema de Reserva De Restaurante

Este projeto é um sistema web completo com back-end em **Java (Spring)** e front-end em **Angular**, utilizando boas práticas de versionamento, documentação e integração contínua.

---

## 🚀 Tecnologias Utilizadas

### 🔙 Back-end

- ⚙️ **Java** — Linguagem principal
- 🌱 **Spring Framework** — Aplicação web (Spring Boot, Spring Security, etc.)
- 🐘 **PostgreSQL** — Banco de dados relacional
- 🔐 **JWT** — Autenticação baseada em token
- 📚 **Swagger** — Documentação da API
- 🧪 **Maven** — Gerenciamento de dependências
- ☁️ **Railway (opcional)** — Deploy na nuvem

### 🧾 Versionamento

- 🗂️ **Git & GitHub** — Controle de versão e colaboração

### 🗂️ Organização e Documentação

- 📌 **Trello** — Gestão de tarefas e prazos
- 📖 **Swagger** — Documentação interativa da API REST

# 🗂️ Estruturação de Pastas

📁 Módulos Principais
- 📦 controller/
Lida com as requisições HTTP (GET, POST, PUT, DELETE). Expõe os endpoints REST da aplicação.

- 🧱 model/
Contém as entidades do sistema, que representam tabelas no banco de dados.

- 🗃️ repository/
Interfaces que fazem a comunicação com o banco de dados. Usam JpaRepository para simplificar operações CRUD.

- 🧠 service/
Implementa a lógica de negócio. Os controllers chamam os serviços, que utilizam os repositórios.

- ⚙️ resources/application.properties
Arquivo de configurações do Spring Boot, como porta do servidor, conexão com o banco de dados, etc.

- 🖼️ resources/static/
Armazena arquivos estáticos como imagens, CSS e JS (caso a aplicação sirva front-end direto).

- 📝 resources/templates/
Templates HTML para motores como Thymeleaf, caso aplicável.

- 🧪 test/
Contém os testes automatizados da aplicação, organizados da mesma forma que o código principal.

- 📄 pom.xml
Arquivo de build e dependências do Maven.

- 📘 README.md
Documentação do projeto — você está lendo ele agora

## 🚀 Diagrama de Classes

```mermaid
classDiagram
    class Usuario {
        Long id
        String nome
        String email
        String senha
        String telefone
        Enum tipo
    }

    class Restaurante {
        Long id
        String nome
        String endereco
        String telefone
        String descricao
    }

    class Mesa {
        Long id
        int numero
        int capacidade
        boolean disponivel
        Long restauranteId
    }

    class Reserva {
        Long id
        LocalDateTime dataHora
        int quantidadePessoas
        Enum status
        Long usuarioId
        Long mesaId
    }

    Usuario "1" --> "0..*" Reserva
    Restaurante "1" --> "0..*" Mesa
    Mesa "1" --> "0..*" Reserva


```
## 🚀 Diagrama de relacionamento
```mermaid
erDiagram
    USUARIO {
        BIGINT id PK
        VARCHAR nome
        VARCHAR email
        VARCHAR senha
        VARCHAR telefone
        ENUM tipo
    }

    RESTAURANTE {
        BIGINT id PK
        VARCHAR nome
        VARCHAR endereco
        VARCHAR telefone
        VARCHAR descricao
    }

    MESA {
        BIGINT id PK
        INT numero
        INT capacidade
        BOOLEAN disponivel
        BIGINT restaurante_id FK
    }

    RESERVA {
        BIGINT id PK
        DATETIME data_hora
        INT quantidade_pessoas
        ENUM status
        BIGINT usuario_id FK
        BIGINT mesa_id FK
    }

    USUARIO ||--o{ RESERVA : faz
    MESA ||--o{ RESERVA : possui
    RESTAURANTE ||--o{ MESA : contém
```

## 🚀 Diagrama de Interação

```mermaid
sequenceDiagram
    participant Usuário
    participant Frontend (Angular)
    participant Backend (Spring)
    participant Banco (PostgreSQL)

    %% Ação do usuário
    Usuário->>Frontend (Angular): Preenche formulário de reserva
    Frontend->>Backend (Spring): POST /reserva (dados da reserva + JWT)
    Backend->>Banco (PostgreSQL): Verifica disponibilidade da mesa
    Banco-->>Backend: Mesa disponível
    Backend->>Banco: INSERT reserva
    Banco-->>Backend: Confirma inserção
    Backend-->>Frontend: 201 Created + detalhes da reserva
    Frontend-->>Usuário: Exibe mensagem de sucesso
```



---




