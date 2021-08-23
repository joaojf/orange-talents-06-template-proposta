FROM openjdk:11
ARG JAR_FILE=target/*jar

# Jogando para a docker
COPY ${JAR_FILE} proposta.jar

# E o que a máquina virtual executa no cmd
ENTRYPOINT ["java", "-jar", "/proposta.jar"]
