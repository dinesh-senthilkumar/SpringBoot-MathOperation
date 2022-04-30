FROM alpine
RUN apk add openjdk8=8.302.08-r2
RUN apk upgrade --update-cache --available
ENV defaultDocumentDBName=operations \
    documentDBClusterIp=localhost:27017 \
    dbConnectionString=mongodb://%s/?ssl=false&retryWrites=false

EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} mathBasicOperation.jar
ENTRYPOINT ["java","-jar","/mathBasicOperation.jar"]