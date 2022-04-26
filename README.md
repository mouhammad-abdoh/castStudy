just remember to start a docker container for the postgresql using 

(docker run --name pg -e POSTGRES_PASSWORD="password" -p 5432:5432 -v postgresql:/var/lib/postgresql/data postgres)
