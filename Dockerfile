FROM openjdk:8
EXPOSE 8080
ADD /target /root
ENTRYPOINT ["java","-jar", "/allshoesbackbuscador.jar"]