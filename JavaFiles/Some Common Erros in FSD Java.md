# Some Common Erros in FSD Java

## 1) entityManagerFactory Error in H2:
  - Cant execute sql statement in .sql file.
  - Failed to initialize dependency 'dataSourceScriptDatabaseInitializer' of LoadTimeWeaverAware bean 'entityManagerFactory': Error creating bean with name 'dataSourceScriptDatabaseInitializer' defined in class path resource
  - Failed to execute SQL script statement
  - ## Soln: 
    - I) In ``application.properties`` add the following:
        - a)  spring.jpa.defer-datasource-initialization=true
        - b)  spring.jpa.hibernate.ddl-auto= update
    - II) In ```pom.xml`` add :
    ```
            <dependency>
        		    <groupId>com.h2database</groupId>
        		    <artifactId>h2</artifactId>
        		    <scope>runtime</scope>
        		</dependency>
        		<dependency>
        		    <groupId>org.hibernate</groupId>
        		    <artifactId>hibernate-core</artifactId>
        		    <version>6.2.2.Final</version>
        		</dependency>
    ```
    - III) No need to CREATE Table in .sql file....just have *insert commands* in .sql file
