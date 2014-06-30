# Wine Cellar Application #

The Wine Cellar application is documented [here](http://coenraets.org).

This application provides an example of building a complete RESTful API in Java using JAX-RS and Jersey, consuming these services using jQuery.

**NOTE** - Port 18080 is assumed for JBoss.

Set Up:

1. Install MySQL (instructions are for Ubuntu)

```
$ sudo apt-get install mysql-server
```

2. Create the "cellar" schema

```
$ mysql -u root -p
```

```
create schema cellar
```

```
create user 'cellar'@'localhost' identified by 'cellar';
```

```
grant all privileges on cellar.* to 'cellar'@'localhost';
```

```
quit
```

2. Execute cellar.sql to create and populate the "wine" table:

```
$ mysql -u cellar -pcellar cellar < cellar.sql
```

3. Build the project

```
$ mvn clean install
```

4. Copy (or link) `target/cellar.war` to `$JBOSS_HOME/standalone/deployments`

Access the application via browser at [http://localhost:18080/cellar/](http://localhost:18080/cellar/) or via command line:

```
$ curl -i -H "Accept: application/json" -X GET http://localhost:18080/cellar/rest/wines
```

```
$ curl -i -H "Accept: application/json" -X GET http://localhost:18080/cellar/rest/wines/2
```
