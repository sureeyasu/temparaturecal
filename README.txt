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