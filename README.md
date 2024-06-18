# Workshop Spring Boot JPA
![Static Badge](https://img.shields.io/badge/license-MIT-green?link=https%3A%2F%2Fgithub.com%2FRafa-Hoff%2Fworkshop-springboot3-jpa%2Fblob%2Fmain%2FLICENSE)

# Objectives
- Create a Spring Boot Java project
- Implement domain model
- Structure logical layers: resource, service, repository
- Configure test database (H2 database)
- Increment database
- CRUD: Create, Retrieve, Update, Delete
- Exceptions treatment

# About the project
My third academic project in [Professor Nelio Alves'](https://github.com/acenelio) Java course.

This is a back-end application implemented by layers, using PostgreSQL as database, where the classes are Product,
Category, Order, OrderItem, Payment and User.
The resource layer is the REST controllers, they will be the application interface with the 
back-end and will receive requests to respond based on the system behavior. 
There is also the service layer that will interact with the objects in database.

# Technologies Used
- IDE IntelliJ
- Sping Boot
- Maven
- H2
- Postman
- PostgreSQL
- Heroku (soon)

## Project UML Diagram

![Domain Model](https://github.com/Rafa-Hoff/assests/blob/main/Domain%20model.png)

![Domain Instance](https://github.com/Rafa-Hoff/assests/blob/main/Domain%20Instance.png)

# How to test the program (IntelliJ):

### Download and Install:
- IDE of your preference(IntelliJ, Eclipse, etc...)
- [Java 17](https://www.azul.com/downloads/#downloads-table-zulu)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Postman](https://www.postman.com/downloads/)

### Clone the project
- Open the Git bash inside a folder of your preference.
- Writes and run the comand:
```
git@github.com:Rafa-Hoff/workshop-springboot3-jpa.git
```
- The project folder must be in your computer now.

### Configuring project
- If your IDE do not update the project with the maven dependencies automatically, make this steps:
  - Click with the right mouse button on "pom.xml" file.
  - Search for maven.
  - Click in the option "project reload".
  - Wait the dependencies download.
- Open the "applicaiton.properties" at: src > main > resources > application.properties.
- You will see this:
```
spring.profiles.active=dev

spring.jpa.open-in-view=true
```
- Change the "spring.profiles.active=dev" for "spring.profiles.active=test"

### Testing with H2 Database:
- Run the CourseApplication at: src > java > com.educandoweb.course > CourseApplication
- Open a browser and paste ```localhost:8080/h2-console``` in the URL
- Click the "connect" option
- You can see the data in the database and the entities associations

### Testing requisitions with Postman
- Run the CourseApplication at: src > main > java > com.educandoweb.course > CourseApplication
- Open the Postman and initiates a request
#### Obs.: When you see {id}, change it to 1, 2, etc...
- To test the User methods, you can try:
  - FindAll: (GET) ```http://localhost:8080/users```
  - FindById: (GET) ```http://localhost:8080/users/{id}```
  - Steps to Update:
    - (PUT) ```http://localhost:8080/users/{id}```
    - In the Postman, select "Body" then "raw" and lastly JSON, now you can copy and paste this:
    ```
    {
      "name": "Bob Brown",
      "email": "bob@gmail.com",
      "phone": "977557755"
    }
    ```
    - You can check in H2 Database if the user update was successful.
  
  - Steps to Insert:
    - (POST) ```http://localhost:8080/users```
    - In the Postman, select "Body" then "raw" and lastly JSON, now you can copy and paste this:
    ```
    {
      "name": "Rafael",
      "email": "rafael@email.com",
      "phone": "123456789",
      "password": "123456"
    }
    ```
    - You can check in H2 Database if the new user insertion was successful.
  
  - Delete: (DELETE) ```http://localhost:8080/users/{id}```
- To test the Category methods:
  - FindAll: (GET) ```http://localhost:8080/categories```
  - FindById: (GET) ```http://localhost:8080/categories/{id}```
- To teste the Product methods:
  - FindAll: (GET) ```http://localhost:8080/products```
  - FindById: (GET) ```http://localhost:8080/products/{id}```
- To teste the Order methods:
  - FindAll: (GET) ```http://localhost:8080/orders```
  - FindById: (GET) ```http://localhost:8080/orders/{id}```

### Testing with PostgreSQL:
- Start the pgAdmin and login.
- click on Servers > PostgreSQL > right mouse button on Database > Create > Database.
- Name the database with "springboot_course", set the user and save.
- In your IDE, open: src > main > resources > application-dev.properties.
- You need to change this part with:
```
# PostgreSQL:
spring.datasource.url=jdbc:postgresql://localhost:{Your Port}/springboot_course
spring.datasource.username={Your Username}
spring.datasource.password={Your Password}
```
- Now open "application.properties" at: src > main > resources > application.properties and change:
```
spring.profiles.active=test
            to
spring.profiles.active=dev
```
- Run "CourseApplication" at: src > main > java > com.educandoweb.course > CourseApplication.
- Check in pgAdmin if the tables are created. To check go: springboot_course > Schemas > public > tables.

This is it! Thank you!

# Author
Rafael Hoffmann do Amaral

LinkedIn: https://www.linkedin.com/in/rafael-amaral-0b9a06166/
