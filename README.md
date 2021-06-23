
   <h1 align ="center">Google Search Exercise</h1>  
   
<h4 align="center">QA Automation Framework</h4>  

  
 
  
## Key Features  
  
This repository contains the test framework allowing BDD testing for the "Google basic search by keyword" exercise.
It uses:
- [Cucumber framework](https://cucumber.io/) : for features definition using Behavior-Driven Development approach and Gherkin syntax
- [Geb framework](https://gebish.org/) : for UI tests steps implementation using the page object design pattern

## How To Use

### Prerequisites:

Te be able to run the tests using this framework you will need :  
* Java JDK 1.8 installed 
* Maven installed
* A browser that will be used to run UI tests installed (Chrome, IE, Firefox)
* (optional) git installed
* All binaries are added to the PATH environment variable (JDK, maven, browser)

### Get started:

##### Step1: download the framework

the first step is download the framework on the machine that will be used to run the tests.
This could be done 

- option1: downloading the project zip file then unzip it in your favorite location

- option2: clone the project from the git repository if you have the repository url
```bash
# Clone this repository
$ git clone [the git repository url]
```
##### Step2: run the tests
```bash
# Go into the repository
$ cd Exercise
# Run the tests
$ maven clean
$ maven integration-test
```

## Run the tests using arguments
To run test you have to add some parameters to the maven command :
* -Dcucumber.options=--tags : this param is optional, it takes one or more tags from the list below to specify the test scope. If not precised, all the existing tests will be executed :
   - @GoogleSearch
   - @SanityChecks
   
* -Dgeb.env : this param is optional, it takes only one tag from the list below to choose the browser (webdriver). By default, if not precised, chrome will be used  :
   - chrome (default)
   - firefox
   - IE
* -DnbThread : this param is optional, they specify the number of thread while executing tests, it takes 4 by default.

## CI configuration

The CI build could be configured to run the tests for each pull request or any other wished event:
- step1 : detect the event is triggered by a pull request for example
- step2 : run the tests
- step3 : check the status code of the test execution

Here is an example of jenkins pipeline illustrating the different steps:

```groovy
stage('Trigger regression tests') {
// for pull requests only
    //step1 : detect the event is triggered by a pull request
	if (env.CHANGE_ID != null) {
        //step2 : run the tests
		def statusCode = sh script: 'cd /working_directory && maven clean && maven integration-test', returnStatus:true
			//step3 : check the status code of the test execution 
            if (statusCode == 1){
					println "Some tests failed in the regression"
					currentBuild.result = 'UNSTABLE'
			}
	} else {
			echo "Trigger regression test skiped"
			Utils.markStageSkippedForConditional(STAGE_NAME)
	}
}
```

## CD integration
A similar stage (described in CI configuration section) could be added to the product CD pipeline to run the tests after each delivery/deployment. 
- step1 : get the last version of the test framework by cloning the master branch of the test framework (or by pulling the test framework docker image if is available)
- step2 : run the appropriate test scope (all tests, @SanityChecks only, @GoogleSearch only) according to the deployment phase. for example run all tests for deployments in QA test environment and run only sanity checks in the other environments
- step3 : check the status code of the test execution

Here is an example of the step to be added in the product CD pipeline:
```groovy
def statusCode = sh script: 'git clone [the git repository url] && cd /Exercise && maven clean && maven integration-test "-Dcucumber.options=--tags @SanityChecks"', returnStatus:true
```

## Support  
Contact :   
<saad.allali1@gmail.fr>  
  
