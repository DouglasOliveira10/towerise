# Towerise

| Data | Autor | Comentários | Versão |
| --- | --- | --- | --- |
| 01/08/2023 | Douglas Oliveira  | Versão de lançamento | 1.0.0-RELEASE |

---

## Objetivo

O objetivo do sistema é ser um exemplo de API utilizando spring-boot na versão 3.1.3, o projeto contem depencias como lombok, swagger e banco de dados em memoria H2, além das dependencias conhecidas do spring como devtools, spring-data e spring-web. O projeto pode ser baixo e ultilizado como back-end para profissionais front-end ou simplismente uma base de estudos ultilizando o postman. Sugestões são bem vindas!

---

## Inicializando o Sistema

### Via IDE

No caminho _br.com.towerise_ encontrar-se a classe [ToweriseApplication.java](./src/main/java/br/com/towerise/ToweriseApplication.java), execute-a como uma aplicação Java via IDE.

### Via Maven

Construa a aplicação com __mvn clean install__, logo após, é possível executar a aplicação via linha de comando:
```java -jar towerise-1.0.0-RELEASE.jar```

---

### Swagger

http://localhost:8080/swagger-ui.html
http://localhost:8080/v2/api-docs

### Tecnologias

* Java 17
* Maven
* Spring boot 3.1.3
