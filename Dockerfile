FROM eclipse-temurin:17-jdk-alpine
LABEL manitainer=Rajasekar
#WORKDIR /app
#COPY ./build/libs/springboot-rest.jar /app
#EXPOSE 8080
#CMD ["java", "-jar", "springboot-rest.jar"]
EXPOSE 8080
ADD /service/build/libs/service.jar springboot-rest.jar
ENTRYPOINT ["java","-jar","/springboot-rest.jar"]