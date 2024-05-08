FROM openjdk:17
LABEL manitainer=Rajasekar
WORKDIR /app
COPY ./build/libs/springboot-rest.jar /app
EXPOSE 8080
CMD ["java", "-jar", "springboot-rest.jar"]
