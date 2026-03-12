# API de Gestão de Fluxo de Caixa

API REST desenvolvida com **Spring Boot** para gerenciamento de transações financeiras.

O sistema permite registrar **entradas e saídas**, consultar transações e calcular o saldo total.

## 🚀 Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

## 📌 Funcionalidades

* Cadastro de transações (entrada ou saída)
* Listagem de todas as transações
* Busca de transação por ID
* Exclusão de transações
* Filtros por:

  * Tipo
  * Categoria
  * Data
* Cálculo de saldo total

## 📊 Endpoint de saldo

`GET /transactions/balance`

Exemplo de resposta:

```json
{
  "totalEntries": 5000.00,
  "totalExits": 2000.00,
  "balance": 3000.00
}
```

## 📂 Estrutura da API

```
controller -> recebe requisições HTTP
service -> lógica de negócio
repository -> acesso ao banco de dados
model -> entidades do sistema
dto -> objetos de transferência de dados
```

## ▶ Como rodar o projeto

1. Clonar o repositório

```
git clone https://github.com/seu-usuario/api-fluxo-caixa.git
```

2. Configurar o banco de dados no `application.properties`

3. Rodar o projeto

```
mvn spring-boot:run
```

## 📬 Testando a API

Exemplo usando Postman:

```
GET http://localhost:8080/transactions
```

---

## 👨‍💻 Autor

Otávio Henrique
