This is a simple automation framework desined to automated android mobile application.

Frameworks Architecture:
  1. Build Tools - Mavan
  2. Unit testing framework - testNg
  3. Programming Langaguge - Java
  4. Automation tool - Appium
  5. Design Pattern - Page Object Model
  
This framework is build using maven and testng. So the execution starts from pom.xml file. Our testcases are called using testng.xml
file. testng.xml file gets called by pom.xml, Here we uses Page Object Model so we have Our locator strategies sperate from our     testcode. 
Framework folder structure: All our main code is written inside src/test/java folder. This folder has following packages-
1. healthifyme.automationassignment.base:  This package contains our driver factory class which creates our appium driver object.
2. healthifyme.automationassignment.config: This package contains our testConfig.json file which has our testdata and Code to read parse and read json file.
3. healthifyme.automationassignment.pages: This package has an interface corresponding to each app page used in our automation. And this interface contains locator strategies for all the elements for that page
4. healthifyme.automationassignment.pages.actions: This package has an Actions class corresponding to each app page used in our automation. And these actions class have all the automated code for the actions performed on those pages.
5. healthifyme.automationassignment.testscripts: This package has testscripts corresponding to our testcase. Here in each testscripts we call corresonding actions method for aur testcase.

6.Results for the execution are located inside target folder
  
Prerequites:
  1. Java sdk 1.8 is installed and JAVA_HOME path is set
  2. Android sdk is installed and ANDROID_HOME path is set
  3. apache-maven isn installed and MAVEN_HOME path is set
  3. Appium server is installed and running on localhost and port 4723. 
  
Execution Steps:
  1. clone this director on your system.
  2. Any android device is connected to system.
  3. cd to the our cloned directory and cd to where pom.xml file is located.
  4. execute mvn test command
