# POS-API

Back-end CRUD RESTful API service written for a POS style system. Created to store customer, order and inventory data.

Written in Java, using the Spring and hibernate ORM frameworks. Connects to a PostgreSQL relational database specified via the AppConfig file. 

Spring is used for dependency injection and additional features, whilst Hibernate was used for its ORM and query strengths. Hibernate also implements c3po to manage connection pool.

Build and run locally using Maven and Tomcat.

Build: "mvn clean install"

Run: "mvn tomcat7:run"

