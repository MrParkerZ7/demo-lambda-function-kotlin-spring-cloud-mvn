> $ Document: https://mydeveloperplanet.com/2020/11/04/how-to-deploy-a-spring-cloud-function-on-aws-lambda/

> $ mvn spring-boot:run
> 
> $ curl -H "Content-Type: text/plain" localhost:8080/containsCloud -d 'this is a cloud'
> 
> $ curl -H "Content-Type: text/plain" localhost:8080/containsCloud -d 'this is a function'

> $ mvn clean package
> 
> $ mvn clean package -DskipTests
> 
> Runnable on lambda only