# jiajiao

## how to run
1. run **db_jiajiao.sql** to create dabase.
2. update file in "jiajiao/src/main/webapp/WEB-INF/proxool.xml", replace ```<driver-url>``` and ```<driver-properties>``` with your own database setting.
3. build this project using command: ```mvn clean package```
4. run jetty: ```mvn jetty:run```
5. open the broser and input the url:```http://localhost:8081/index.do```