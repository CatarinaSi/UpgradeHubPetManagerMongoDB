FROM openjdk:latest
ADD target/pet-manager-1.0-SNAPSHOT.jar pet-manager.jar
#EXPOSE 8088
ENTRYPOINT ["java","-jar","pet-manager.jar"]