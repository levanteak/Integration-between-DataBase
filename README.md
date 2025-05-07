# DB Integration Service

Spring Boot-сервис для интеграции данных между двумя PostgreSQL-базами данных: `integration_from` и `integration_to`.

## Стек технологий
- Java 17
- Spring Boot 3.2+
- Spring Data JPA
- PostgreSQL
- HikariCP
- Lombok

## Описание

Сервис подключается к двум базам данных и копирует данные из таблицы `source_table` в таблицу `target_table` по REST-запросу.

## Конфигурация

Указать параметры подключения в `application.yml`:

```yaml
from:
  datasource:
    jdbc-url: jdbc:postgresql://localhost:5433/integration_from
    username: postgres
    password: postgres

to:
  datasource:
    jdbc-url: jdbc:postgresql://localhost:5433/integration_to
    username: postgres
    password: postgres
