front end

git clone URL

npm install

go into dataservices.ts change url to localhost:8080/api/ <--- dont forget trailing slash

start postgres and make a database invoicify


backend

git clone URL

go into src/main/resources/application.properties and make user = postgres

go into C:\Program Files\PostgreSQL\11\data\pg_hba.conf and make all md5 to trust

comment out .anyRequest().authenticated() from seruirtyconfig.java