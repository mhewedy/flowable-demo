# Flowable-demo

## How to run the admin ui
1. download the flowable.zip matching the release you're using 
   from https://github.com/flowable/flowable-engine/releases, (for spring boot 2.7.x use 6.8.1 and for spring boot 3.x use 7.x release)
2. unzip the file flowable-<verion>.zip, then cd flowable-<version>/wars 

3. run this command:
```bash
java -cp "flowable-ui.war:<jdbc-driver>.jar" org.springframework.boot.loader.WarLauncher \
  --server.port=<port, e.g. 8081> \
  --spring.datasource.url="<jdbc url>" \
  --spring.datasource.username=<username> \
  --spring.datasource.password="<password>" \
  --flowable.database-schema-update=true
``` 
4. Now you can access the flowable ui on: http://localhost:<port>/flowable-ui, use admin/test for login

Note, executing this command will create additional tables