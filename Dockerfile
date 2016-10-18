FROM maven:onbuild
CMD mvn spring-boot:run

EXPOSE 8080
#CMD tail -f /dev/null

