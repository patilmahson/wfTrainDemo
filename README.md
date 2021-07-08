# wfTrainDemo
training project

# Summary
Producer side to a project to demonstrate competence with Apache Kafka and Spring Boot

# Setup
Install and run mongodb on port 27017 before starting the application
Install Kafka and run a server instance on port 9092

# Endpoints
Post endpoint to /customers  
Takes a json body of type customer and saves the customer to the mongodb

>{"cID":16,"firstName":"roald", "lastName":"ghoul", "age":27}

# Swagger Spec
A swagger spec can be found under src/main/resources.  
Paste this spec into editor.swagger.io to try out the methods