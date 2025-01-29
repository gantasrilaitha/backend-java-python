# backend-java-python

## Directories and Commands for a Full Stack Java-Angular Project 
  
- Navigate to ``cd demo-1`` to explore *Relations* b/w Student, Passport, Review entities
- Look for ``JavaFiles/angular-practice/crud_angular`` : angular frontend
- ng new <project name> : to create new project
- ng g s <service name> : to create service
- ng g c <component name>: to create components that are not standalone
- ``ng serve`` =>to run angular frontend application

- Look for ``fsd`` under JavaFiles : java springboot backend logic
- ## 2 mini projects in fsd covering CRUD Operations:
- a) Admin , Customer entities: admin contols the customer 
- b) User, Event ,Group entities : Users are part of grops participating in events.
- c) ``angular-practice/crud_angular`` contains respective frontend code for
    - i) with *standalone components* on ``angular-practice/crud_angular`` and
    - ii) *non-standalone components* in ``angular-practice/no_standalone``.
- d) ``JavaFiles/react-practice`` contains *React* frontend code for b)

- Run ``mvn spring-boot:run`` =>to run springboot backend application
- Run ``npm start`` => to run react frontend application 
