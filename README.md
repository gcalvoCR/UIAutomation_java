# UIAutomation-java
This repo is a base for UI automation using java, it is set to use zalenium and docker to run.


## Pre-requisites
- Install docker. [Read more here](https://docs.docker.com/)
- Have maven installed.
- Have java 8 installed.
- Have an IDE of your preference installed (I love IntelliJ).



# Steps
## 1. The solution
- Clone the repo, [here it is](https://github.com/gcalvoCR/UIAutomation-java).
- Open the solution on IntelliJ or any IDE of your preference.
- Right click on the project and rebuild the solution.


## 2. Start the grid

### In case of Zalenium (Docker)

- Open up a new CMD.
- Navigate to the root of your project (where you cloned it)
- Double check that you have a file named docker-compose.yaml.
- Type docker-compose up on the Terminal.
- Make sure the grid is up and running, go to the browser and navigate to 
`http://localhost:4444/grid/admin/live`
   *You should see a page that says Zalenium Live Preview.*


### In case of Selenium-grid standalone

- Open up a new CMD.
- Navigate to the root of your project (where you clone it)
- CD in selenium-server
- type:
```
java -jar selenium-server-standalone-3.12.0.jar -role hub -timeout 30 -browserTimeout 60
```
*This starts the Hub.*
- type: 
```$xslt
 java -Dwebdriver.chrome.driver=PATH_TO_CHROMEDRIVER -jar selenium-server-standalone-3.12.0.jar -role node -hub http://YOUR_IP_ADDRESS:4444/grid/register/ -port 5566 -browser browserName=chrome,version=latest,maxInstances=10
```
*This adds the node (In this case Chrome).*

- Type docker-compose up on the Terminal.
- Make sure the grid is up and running, go to the browser and navigate to ` http://localhost:4444/grid/admin/live `
    *You should see a page that says Zalenium Live Preview.*

## 3. Run the tests

### Running from the IDE

- We are all set, all what we need is to go to the project, look up for an Xml you want to run (found under test/resources/XMLFiles), right click on it "Run".

### Running from the terminal 

- If you want to run the tests from the terminal it is a simple as:
- Navigate to the root of your project (where you cloned it)
- type:
```
mvn clean test -DsuiteXmlFile=BaseSuite.xml
```
- The console should clean the project and test.


***

## Disclaimer

- This repo is just a base for your tests, the implementation of Jenkins needs some work but here you can find a simple pipeline defined in a jenkinsfile to allow CI/CD.
- In order to run the project it is completely necessary to put a grid up, either stand-alone or docker. 
- This repo doesn't take in count any management tool, in order to make it really useful, you should integrate it to a reporter tool.
- If you are running it locally, make sure you have the latest version of the BrowserDrivers (and your browsers up to date).

Have any questions? Feel free to reach out to me!


### by Gabriel Calvo Vargas

