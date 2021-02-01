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