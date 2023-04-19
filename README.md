# Microservice coding - File Processing 

created the below microservice components 

                 1. Service-Registry
                 2. API-Gateway
                 3. File-Processing 
Service-Registry : 
Service Registry & Discovery is one of the key tenets of a microservice-based architecture.Eureka is the Netflix Service Discovery Server and Client.

Spring Cloud Gateway :

Spring Cloud Gateway provides a library to build an API Gateway. This is the preferred gateway implementation provided by Spring Cloud.The API gateway takes all the API calls, from the clients and routes them to appropriate microservice(s) with request routing, composition, and protocol translation.

File Processing Service: 

Large file processing implemented the below approaches.
   1.CompletableFuture -A CompltableFuture is used for asynchronous programming. Asynchronous programming means writing non-blocking code
   2. OpenCSV - OpenCSV provides most of the basic features for CSV parsing
   
TestCase Execution Result:

EndPoint : http://localhost:9191/api/files/fileProcess2  - Implement the CompletableFuture

![image](https://user-images.githubusercontent.com/7304421/232937715-68d36674-f6bb-4a98-8fcb-8d7317749da6.png)

EndPoint : http://localhost:9191/api/files/fileProcess - Implement the OpenCSV

![image](https://user-images.githubusercontent.com/7304421/232937837-bbdaaeb5-f6e0-4a08-b57a-101f91ef8a26.png)

EndPoint : http://localhost:9191/api/files/fileProcess  -  greater than 6GB file process returns the failure message

![image](https://user-images.githubusercontent.com/7304421/232938078-3b1ed09a-7df6-4acf-a8c5-66c4ec9085cc.png)

Eureka:

![image](https://user-images.githubusercontent.com/7304421/232938227-97513b02-517e-4207-bf83-dc46a2143031.png)

Zipkin: Logs tracing 

![image](https://user-images.githubusercontent.com/7304421/232939059-5a8a7325-2b7f-4659-a7f2-e968c73a42aa.png)

OpenAPI -Swagger:

![image](https://user-images.githubusercontent.com/7304421/232939278-6b4cdc6f-42e1-440e-9865-4a453d3e0f22.png)

Actuator :

![image](https://user-images.githubusercontent.com/7304421/232939371-bf8dcd2a-ee5d-4127-ad59-73842bfb8208.png)








   
 



                 
