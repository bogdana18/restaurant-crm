# Виберіть базовий образ
FROM openjdk:17-jdk-alpine

# Встановіть робочу директорію в контейнері
WORKDIR /app

# Копіюйте файл збірки у робочу директорію
COPY target/restaurant-crm-0.0.1-SNAPSHOT.jar app.jar

# Вкажіть команду для запуску додатку
ENTRYPOINT ["java", "-jar", "app.jar"]
