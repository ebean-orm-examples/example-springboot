# example-springboot
Example app with Ebean in a Spring Boot application

## usage

Clone this repository to your local and boot it.
```console
$ git clone git@github.com:ebean-orm-examples/example-springboot.git

$ mv example-springboot

$ mvn spring-boot:run
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building example-springboot 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
(snip)
2016-07-21 17:40:47.549  INFO 7668 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2016-07-21 17:40:47.553  INFO 7668 --- [           main] org.example.sboot.Application            : Started Application in 2.915 seconds (JVM running for 5.595)
```

Get all contents.
``` console
$ curl localhost:8080/content
[{"id":1,"version":1,"whenCreated":1469089981790,"whenModified":null,"whoCreated":"default","whoModified":null,"name":"name1"}]
```

Add a content.
``` console
$ curl -d '{"name" : "test"}' -H 'Content-Type: application/json' localhost:8080/content
{"id":2,"version":1,"whenCreated":1469090379285,"whenModified":1469090379285,"whoCreated":"test","whoModified":"test","name":"test"}

$ curl localhost:8080/content
[{"id":1,"version":1,"whenCreated":1469090362551,"whenModified":null,"whoCreated":"default","whoModified":null,"name":"name1"},{"id":2,"version":1,"whenCreated":1469090379285,"whenModified":1469090379285,"whoCreated":"test","whoModified":"test","name":"test"}]
```

When you try to add a content named 'rollback', the transaction will be rollbacked.
```console
$ curl -d '{"name" : "rollback"}' -H 'Content-Type: application/json' localhost:8080/content
{"timestamp":1469090470562,"status":500,"error":"Internal Server Error","exception":"java.lang.RuntimeException","message":"boooom!!","path":"/content"}

$ curl localhost:8080/content
[{"id":1,"version":1,"whenCreated":1469090446776,"whenModified":null,"whoCreated":"default","whoModified":null,"name":"name1"},{"id":2,"version":1,"whenCreated":1469090456177,"whenModified":1469090456177,"whoCreated":"test","whoModified":"test","name":"test"}]
```
