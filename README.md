# test-vk-Api
Данный проект выполнен как тестовое задание на позицию java-developer.
Проект позволяет считать из базы данных id пользователей vk, обратиться к open API Вконтакте и обновить данные в DB.
Deploy: https://test-vk-api-production.up.railway.app/
Swagger: https://test-vk-api-production.up.railway.app/swagger-ui/index.html

У данного проекта есть вторая часть: https://github.com/AndreevDan93/file-creator-for-vk-api
Проект совершает запрос к нашему API который обновляет и передает нам данные о пользователях vk, 
после чего формирует их в файл xlsx.

### Технологии

1. Java 17
2. Spring Boot, WVC, Data
3. Unirest, jackson
4. Swagger, Lombok
5. Gradle
6. Liquibase
7. Spring Security, JWT

### Разработка

Прежде чем Вы сможете собрать этот проект, Вы должны установить и настроить следующие зависимости на своем компьютере:

1. JDK 17
2. Gradle 7.4
3. Node.js 16.13.1

### Сборка проекта

```bash
make build
```

## Тестирование проекта

Для запуска теста приложения, запустите:

```bash
make test
```

## Запустите приложение с локальной базой данных

```bash
make start
