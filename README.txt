1)Install Neo4j
2)Neo4j password : suresh
3)Install lombok
4)Launch the SampleTemparatureApplication


POST:http://localhost:8080/api/location
{
"country": "India",
"temparature": "30",
"name": "Venkatapuram",
"lon": "78.245",
"region": "Andhra Pradesh",
"lat": "17.251"
}

PUT:http://localhost:8080/api/location
{
"country": "India",
"temparature": "20",
"name": "Venkatapuram",
"lon": "78.245",
"region": "Andhra Pradesh",
"lat": "17.251"
}

GET:http://localhost:8080/api/location?longitude=78.245&latitude=17.251

DELETE:http://localhost:8080/api/location?longitude=78.245&latitude=17.251

GET:http://localhost:8080/v2/api-docs(Swagger)
http://localhost:8080/swagger-ui.html#

https://stackoverflow.com/questions/24319662/from-inside-of-a-docker-container-how-do-i-connect-to-the-localhost-of-the-mach

Use --network="host" in your docker run command, then 127.0.0.1 in your docker container will point to your docker host.

docker run \
    --name testneo4j \
    -p7474:7474 -p7687:7687 \
    -d \
    -v $HOME/neo4j/data:/data \
    -v $HOME/neo4j/logs:/logs \
    -v $HOME/neo4j/import:/var/lib/neo4j/import \
    -v $HOME/neo4j/plugins:/plugins \
    --env NEO4J_AUTH=neo4j/test \
    neo4j:latest
    
 https://community.neo4j.com/t/solved-cant-open-a-session-with-neo4j-ogm/11229   
    
docker pull neo4j
mvn clean install
#will create image with name 'b5dd5ab090ff' and version latest
docker build -f Dockerfile -t temparaturecal .

docker run -d --name testneo4j -p7474:7474 -p7687:7687 --env NEO4J_AUTH=neo4j/suresh  neo4j:latest

docker run -d --name testneo4j -p7474:7474 -p7687:7687 --env NEO4J_dbms_connector_https_advertised__address="localhost:7473" --env NEO4J_dbms_connector_http_advertised__address="localhost:7474" --env NEO4J_dbms_connector_bolt_advertised__address="localhost:7687" --env NEO4J_AUTH=neo4j/suresh  neo4j:latest

docker run --name temparaturecal -p8080:8080 temparaturecal:latest

docker run --name temparaturecal --network="host.docker.internal" -p8080:8080 temparaturecal:latest

https://towardsdatascience.com/weather-data-and-forecasts-from-open-weather-api-1636691d5ba

https://github.com/docker/for-win/issues/667

WARNING: The requested image's platform (linux/amd64) does not match the detected host platform (windows/amd64) and no specific platform was requested

docker: Error response from daemon: failed to create endpoint temparaturecal on network nat: Windows does not support host IP addresses in NAT settings.
