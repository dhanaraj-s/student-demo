# student-demo

This project is a sample Spring Boot app (Web MVC) for a single page application which maintains the data in MongoDB and allows the user to manipulate data by providing options like add/delete/edit student details.

The basic plan for this project is to familiarize with the below technologies,
1.	HTML5
2.	CSS
3.	Bootstrap
4.	AngularJs
5.	Grunt
6.	Spring Boot
7.	Restfull services
8.	JPA
9.	Maven
10.	MongoDB

We can run this project, just the way we run a simple spring boot application. But here I have explicitly generated a war file so that i can deploy it over my tomcat server and check.

The MongoDB properties are given inside #application.properties

##mongoDB-properties##
spring.data.mongodb.database=mongoDB_student
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017

If you are new to MongoDB, just go to the mongod.exe inside the MonogoDB installed pckage file and run it, which will start the mongoDB. We can query our data and schema details in the opened console. 

Static assets are available in “src/main/resources/static”. Here I am using a minified version of the js which I minified using npm grunt.

Once the application is deployed access the application through "localhost:8080/student-app/"
