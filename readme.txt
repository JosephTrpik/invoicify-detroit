Setup

    create a postgres database:
        from bash terminal: psql -U postgres
        type your password in*
        then enter: CREATE DATABASE invoicify;

            *if you forget your password: go into C:\Program Files\PostgreSQL\11\data\pg_hba.conf and replace all md5 with trust

Frontend

    git clone URL

    npm install

    go into dataservices.ts change url to localhost:8080/api/ <--- dont forget trailing slash

    to run program: npm start

Backend

    git clone URL

    go into src/main/resources/application.properties and make user = postgres

    to use postman:
        comment out .anyRequest().authenticated() from seruirtyconfig.java

    to run program: mvn spring-boot:run

Misc
    if you can't boot due to port in use:
        open up a command prompt with admin rights
        type: netstat -ao
        find the port in use and note its PID
        type: tskill "PID"