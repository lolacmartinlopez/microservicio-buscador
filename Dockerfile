FROM openjdk:17
EXPOSE 8080
ADD /target /root
ENTRYPOINT ["java","-jar", "/allshoesbackbuscador.jar"]