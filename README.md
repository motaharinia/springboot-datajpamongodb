## Spring Boot Data with MongoDB Database

### Spring Data:
Spring Data’s mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store.
It makes it easy to use data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services. This is an umbrella project which contains many subprojects that are specific to a given database. The projects are developed by working together with many of the companies and developers that are behind these exciting technologies.

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

### MongoDB 4.0 transactions with Spring Data:
With MongoDB 4.0, ACID transactions have arrived in the Document store, enforcing all-or-nothing execution and maintaining data integrity. In Version 4.2, Multi-Document transactions supports transaction on replica sets, sharded clusters .
- When the transaction has committed all data operations on the transaction will commit automatically.
- If any operation fails, the transaction will fail.
- When the transaction has failed all data operations on the transaction will roll back automatically.
- Until transaction committed no write operation data will be exposed to the outside world.

### Application.Properties:
As long as you use Mongo 2.x, you can specify a host/port as above.
If you use the Mongo 3.0 Java driver, spring.data.mongodb.host and spring.data.mongodb.port are not supported. In such cases, spring.data.mongodb.uri should be used to provide all of the configuration.

further references:     
- https://spring.io/projects/spring-data
- https://bezkoder.com/spring-boot-mongodb-crud/
- https://bezkoder.com/spring-boot-mongodb-pagination/
- https://stackabuse.com/spring-data-mongodb-adminUser/
- https://www.mongodb.com/
- https://www.mongodb.com/try/download/compass
- https://docs.mongodb.com/manual/adminUser/enable-authentication/
- https://stackoverflow.com/questions/23515295/spring-boot-and-how-to-configure-connection-details-to-mongodb
- https://www.tutorialspoint.com/mongodb/mongodb_create_database.htm
- https://docs.spring.io/spring-data/data-mongo/docs/current/reference/html/#mapping-usage-annotations
- https://onecompiler.com/posts/3uxxu2z5h/how-to-use-mongodb-transactions-in-spring-boot


### Project Descriptions :
please see application.properties files in resources folder and select a active profile "dev" or "com" to run project. you can check test methods too.  

By default, mongodb has no enabled access control.
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
- IntelijIDEA: Run -> Edit Configuration -> Spring Boot -> XXXApplication -> Configuration -> Environment -> VM Options: -Dspring.profiles.active=dev
- IntelijIDEA: Run -> Edit Configuration -> Spring Boot -> XXXApplication -> Code Coverage -> Fix the package in include box

<hr/>
<a href="mailto:eng.motahari@gmail.com?"><img src="https://img.shields.io/badge/gmail-%23DD0031.svg?&style=for-the-badge&logo=gmail&logoColor=white"/></a>

