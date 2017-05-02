
ReadAll
curl  http://localhost:8080/jsf-ejb-jpa-rest/rest/persons

Read one
curl http://localhost:8080/jsf-ejb-jpa-rest/rest/persons/302

Delete
    curl  -X DELETE http://localhost:8080/jsf-ejb-jpa-rest/rest/persons/302

Add
curl -H "Content-Type: application/json" -X POST -d'{"firstName":"Bengt","lastName":"Svensson"}'  http://localhost:8080/jsf-ejb-jpa-rest/rest/persons

Add many
curl -X  POST -d'{"personList":[{"firstName":"Pelle1 ","lastName":"Persson1"},{"firstName":"Pelle2 ","lastName":"Persson2"},{"firstName":"Pelle3 ","lastName":"Persson3"}]}'  http://localhost:8080/jsf-ejb-jpa-rest/rest/persons

Update
curl -H "Content-Type: application/json" -X PUT -d'{"firstName":"Bengt2","lastName":"Svensson2"}'  http://localhost:8080/jsf-ejb-jpa-rest/rest/persons/302
