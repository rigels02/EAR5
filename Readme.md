# Enterprise Application example EAR5

Maven Enterprise Application project created with Maven Archetype Plugin 
from collection of EAR, EJB and Web App archetypes. Wildfly10 server is used
as runtime environment for EA ear5-ear. 

- create Maven POM (Multi-module) project EAR5 by maven archetype:
~~~
mvn -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root 
-DarchetypeVersion=1.1 -DarchetypeRepository=http://repo.maven.apache.org/maven2 
-DgroupId=org.rb -DartifactId=ear5 -Dversion=1.0-SNAPSHOT -Dpackage=org.rb -Dbasedir=ear5_dir -Darchetype.interactive=false
~~~
- create modules for EAR5 POM by using **Maven archetypes plugin (see below)**: 
    1. ear5-ear
    2. ear5-ejb
    3. ear5-ejb-itf
    4. ear5-web
    5. ear5-web-remote

## Module  ear5-ear archetype

~~~
archetypeGroupId= org.codehaus.mojo.archetypes
archetypeArtifactId = ear-javaee7
archetypeVersion= 1.0
~~~


## Module ear5-ejb-itf

Create module as simple java jar project.
Add dependency:
~~~
<dependency>
    <groupId>javax</groupId>
    <artifactId>javaee-api</artifactId>
    <version>6.0</version>
    <scope>provided</scope>
</dependency>
~~~
This is jar lib module containing remote EJB interfaces.

## Module ear5-ejb archetype
~~~
archetypeGroupId=org.codehaus.mojo.archetypes 
archetypeArtifactId=ejb-javaee7
archetypeVersion=1.1
~~~
Add dependency:
~~~
<dependency>
    <groupId>org.rb</groupId>
    <artifactId>ear5-ejb-itf</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
~~~
This module implements EJB remote interfaces.

## Module ear5-web archetype
~~~
archetypeGroupId=org.codehaus.mojo.archetypes 
archetypeArtifactId=webapp-javaee7 
archetypeVersion=1.1
~~~
Add dependency:
~~~
<dependency>
    <groupId>org.rb</groupId>
    <artifactId>ear5-ejb</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>provided</scope>
</dependency>
~~~
Because this module use local ejb interface to access EJB service.


## Module ear5-web-remote archetype
The same Maven archetype used as for ear5-web.
This Maven project is outside of ear5-ear project and will be used for
EJB service remote access by using remote interface.
~~~
archetypeGroupId=org.codehaus.mojo.archetypes 
archetypeArtifactId=webapp-javaee7 
archetypeVersion=1.1
~~~

Add dependency:
~~~
<dependency>
    <groupId>org.rb</groupId>
    <artifactId>ear5-ejb-itf</artifactId>
    <version>1.0-SNAPSHOT</version>
    <type>jar</type>
</dependency>
~~~
Because it will use remote EJB access interface.

## Now add modules to EA maven project ear5-ear

We are going to add modules ear5-ejb and ear5-web 
by adding dependencies:
~~~
<dependency>
    <groupId>org.rb</groupId>
    <artifactId>ear5-ejb</artifactId>
    <version>1.0-SNAPSHOT</version>
    <type>ejb</type>
</dependency>
<dependency>
    <groupId>org.rb</groupId>
    <artifactId>ear5-web</artifactId>
    <version>1.0-SNAPSHOT</version>
    <type>war</type>
</dependency>
~~~

## Build EAR5 Maven project
Inside ear5 directory (where pom.xml resided) run:
~~~
mvn clean install
~~~

## Run EA application ear5-ear

Deploy and run EA ear5-ear on Wildfly server.
Using web browser call 
ear5-web (http://localhost:8080/ear5-web/)
and ear5-web-remote (http://localhost:8080/ear5-web-remote-1.0-SNAPSHOT/) to call EJB services localy or
remotely.