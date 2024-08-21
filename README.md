# Projeto de Manipulação de Objetos `Person`

Este projeto Java fornece funcionalidades para gerenciar objetos da classe `Person` usando serialização para armazenamento em um arquivo `.ser`. As principais operações incluem salvar um novo objeto `Person`, remover um objeto por e-mail, listar todos os objetos e remover todos os objetos armazenados.

## Funcionalidades

1. **Salvar um Novo Objeto**
   - Adiciona um novo objeto `Person` ao arquivo `.ser`.
   - **Método Utilizado:** `savePerson(Person person)`

2. **Remover Objeto por E-mail**
   - Remove um objeto `Person` com base no endereço de e-mail fornecido.
   - **Método Utilizado:** `removeByEmail(String email)`

3. **Listar Todos os Objetos**
   - Exibe todos os objetos `Person` armazenados no arquivo `.ser`.
   - **Método Utilizado:** `showPersons()`

4. **Remover Todos os Objetos**
   - Remove todos os objetos `Person` do arquivo `.ser`.
   - **Método Utilizado:** `removeAll()`

## Estrutura do Projeto

### 1. Etrutura do projeto

```java
-src
  -applications
  -controllers
  -dao
  -model
    --entities
    --exceptions
    --util
