Invoicify

    The purpose of this web application is to provide an invoice management tool for internal use.

Setup

    Clone both the frontend and backend projects from the github repo into your local machine's file system.
    
    https://github.com/peternsilva/invoicify-detroit - backend
    https://github.com/peternsilva/invoicify-detroit-fe - frontend

    create a postgres database:
        from bash terminal: psql -U postgres
        type your password in*
        then enter: CREATE DATABASE invoicify;

            *if you forget your password: go into C:\Program Files\PostgreSQL\11\data\pg_hba.conf and replace all md5 with trust

Frontend

    git clone URL

    npm install

    go into dataservices.ts change url to localhost:8080/api/ <--- dont forget trailing slash


Backend

    git clone URL

    go into src/main/resources/application.properties and make user = postgres

    to use postman:
        comment out .anyRequest().authenticated() from securityconfig.java

    
Run

    Start the frontend - npm start
    Start the frontend - mvn spring-boot:run
    
    Use a web browser and go to http://localhost:4200 to access the application running on your local machine.


Misc
    if you can't boot due to port in use:
        open up a command prompt with admin rights
        type: netstat -ao
        find the port in use and note its PID
        type: tskill "PID"
