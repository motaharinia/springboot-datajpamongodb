## Spring Boot Data with JPA-Hibernate ORM and MongoDB Database

### Spring Data JPA:
Spring Data JPA, part of the larger Spring Data family, makes it easy to easily implement JPA based repositories. This module deals with enhanced support for JPA based data access layers. It makes it easier to build Spring-powered applications that use data access technologies.

### JPA (Java Persistence API):
JPA is not a tool or framework; rather, it defines a set of concepts that can be implemented by any tool or framework. While JPA's object-relational mapping (ORM) model was originally based on Hibernate, it has since evolved. Likewise, while JPA was originally intended for use with relational/SQL databases, some JPA implementations have been extended for use with NoSQL datastores. A popular framework that supports JPA with NoSQL is EclipseLink,

### Hibernate ORM:
Hibernate ORM is an object-relational mapping tool for the Java programming language. It provides a framework for mapping an object-oriented domain model to a relational database

### MongoDB Database:
MongoDB is a cross-platform document-oriented database program. Classified as a NoSQL database program, MongoDB uses JSON-like documents with optional schemas. MongoDB is developed by MongoDB Inc. and licensed under the Server Side Public License.
- Rich JSON Documents:
    - The most natural and productive way to work with data.
    - Supports arrays and nested objects as values.
    - Allows for flexible and dynamic schemas.
- Powerful query language:
    - Rich and expressive query language that allows you to filter and sort by any field, no matter how nested it may be within a document.
    - Support for aggregations and other modern use-cases such as geo-based search, graph search, and text search.
    - Queries are themselves JSON, and thus easily composable. No more concatenating strings to dynamically generate SQL queries.
- All the power of a relational database, and more...
    - Distributed multi-document ACID transactions with snapshot isolation.
    - Support for joins in queries.
    - Two types of relationships instead of one: reference and embedded.

### NoSQL database terms:
- Database:     
It is a container for collections and can be thought as similar to an RDBMS database, which is a container for Tables.
- Collection:   
It is equivalent to Tables in RDBMS, but unlike a collection it has a dynamic schema. A collection exists within a database.
- Document:     
It is a single record in a MongoDB collection. It can be thought of as a row in RDBMS.
- Field:    
A document has zero or more fields. It's like an RDBMS column having a key-value pair.

further references:     
- https://spring.io/projects/spring-data-jpa
- https://bezkoder.com/spring-boot-mongodb-crud/
- https://bezkoder.com/spring-boot-mongodb-pagination/
- https://stackabuse.com/spring-data-mongodb-tutorial/
- https://www.mongodb.com/
- https://www.mongodb.com/try/download/compass
- https://docs.mongodb.com/manual/tutorial/enable-authentication/
- https://stackoverflow.com/questions/23515295/spring-boot-and-how-to-configure-connection-details-to-mongodb
- https://www.tutorialspoint.com/mongodb/mongodb_create_database.htm



### Project Descriptions :
please see application.properties files in resources folder and select a active profile "dev" or "com" to run project. you can check test methods too.  

By default mongodb has no enabled access control.
- Download and install mongodb from "https://www.mongodb.com/try/download/community"
- Go to Control Panel > System & Security > System > Advanced System Settings > Environment Variables > navigate to the Path variable hit Edit and add "C:\Program Files\MongoDB\Server\4.4\bin" to the end of Path
- open cmd and run:
    - mongo --port 27017
- Create the user administrator:
    - use admin
    - db.createUser(
        {
          user: "motaharinia",
          pwd: passwordPrompt(), // or cleartext password
          roles: [ { role: "userAdminAnyDatabase", db: "admin" }, "readWriteAnyDatabase" ]
        }
      )
    - enter password: 123456
    - db.adminCommand( { shutdown: 1 } )
    - restart mogodb service in windows
- check your databases list:
    - mongo --port 27017  --authenticationDatabase "admin" -u "motaharinia" -p
    - show dbs
- create database (To display database, you need to insert at least one document into it):
    - use testdb
    - db.user.insert({"username":"eng.motahari@gmail.com"})
    - show dbs

### IntellliJ IDEA Configurations :
- IntelijIDEA: Help -> Edit Custom Vm Options -> add these two line:
    - -Dfile.encoding=UTF-8
    - -Dconsole.encoding=UTF-8
- IntelijIDEA: File -> Settings -> Editor -> File Encodings-> Project Encoding: form "System default" to UTF-8. May be it affected somehow.
- IntelijIDEA: File -> Settings -> Editor -> General -> Code Completion -> check "show the documentation popup in 500 ms"
- IntelijIDEA: File -> Settings -> Editor -> General -> Auto Import -> check "Optimize imports on the fly (for current project)"
- IntelijIDEA: File -> Settings -> Editor -> Color Scheme -> Color Scheme Font -> Scheme: Default -> uncheck "Show only monospaced fonts" and set font to "Tahoma"
- IntelijIDEA: Run -> Edit Configuration -> Spring Boot -> XXXApplication -> Environment -> VM Options: -Dspring.profiles.active=dev

<hr/>
<a href="mailto:eng.motahari@gmail.com?"><img src="https://img.shields.io/badge/gmail-%23DD0031.svg?&style=for-the-badge&logo=gmail&logoColor=white"/></a>

