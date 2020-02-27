# UIAutomation-java
This repo is a base for UI automation using java, it is set to use zalenium and docker to run.


# Prerequisited
- Install docker. 
- Have maven and IntelliJ up and running.



# Steps
## 1. The solution
- Clone the repo, [here it is](https://github.com/gcalvoCR/UIAutomation-java).
- Open the solution on IntelliJ or any IDE of your preference.
- Right click on the project and rebuild the solution.


## 2. Start docker

- Open up a new CMD.
- Navigate to the root of your project (where you clone it)
- Double check that you have a file named docker-compose.yaml.
- Type docker-compose up on the Terminal.
- Make sure the server starts, Go to the browser and navigate to ` http://localhost:4444/grid/admin/live `
    ** You should see a page that says Zalenium Live Preview **


## 3. Run the tests

- We are all set, all what we need is to go to the project, look up for an Xml you want to run (found under test/resources/XMLFiles), right click on it "Run".

***

## Disclamer

- This repo is just a base for your tests, I will keep adding features to the framework until it could be running in Jenkins of Circle CI to allow CI/CD.
- The tests could be run from the Terminal, Instructions coming soon.
- This repo doesn't take in count any management tool, in order to make it really useful, you should integrate it to a reporter tool.

Have any questions? Feel free to reach out to me!


### by Gabriel Calvo Vargas

