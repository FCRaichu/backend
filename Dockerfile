FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# 이미지 컴프레션 ( cwebp / libwebp-tools )
RUN apk add --no-cache libwebp-tools

COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]