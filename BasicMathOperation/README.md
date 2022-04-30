# Basic Math Operation using Spring Boot


## Prerequisite
    -> Setup MongDB, currently Code supports connecting string in local DB without username and password
    -> Update the Docker File before build Docker image file
            --> defaultDocumentDBName=operations 
            --> documentDBClusterIp=localhost:27017 
            --> dbConnectionString=mongodb://%s/?ssl=false&retryWrites=false
    -> Default port expose to 8080
 

## API Details:
     http://localhost:8080/swagger-ui/index.html#/

## Docker Build Command:
    cd MathOperation
    docker build -t mathoperation:1.0.0 .

## Docker Run Command
    docker run --name mathoperation  --env documentDBClusterIp=host.docker.internal:27017 --env dbConnectionString="mongodb://%s/?ssl=false&retryWrites=false" -p 8080:8080  mathoperation:1.0.0
