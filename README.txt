Overview of Framework
--------------------------------

The framework choosen is Hybrid framework as it using Page Object Model also Data Driven framework concepts for better modularity, maintance & development. 

Structure of Framework is:
----------------------------------

SRC
   --Driver - This package/folder contains java files/classes to set-up, this has code to open a browser & nevigate to the webiste under test
   
   --PageObject - This package/folder contains java files/classes for different pages of website, It has different methods for user action on the 		           pertciluar pages with like HomePage
   
   --Testcases -  This package/folder contains java files/classes which contains the test methods & building blocks of methods, methods from page                 object are used here to form test cases 

   --Utility  - This package/folder contains java files/classes which are used as helper function like reading excel file, reading properrty values 		etc.

   --Resources - This folder contains, different drivers used for initializing the driver & property files. 

   --Reports   - This folder is used for keeping extra reporting files 

      --- Screenshot - This folder contains screenshot of the test execution

  --Testdata   - This folder contains the datasheet which contains different data that will be used for execution of test cases

  --Test-outputs - This folder got generated on running the project & it contains the TestNG reports for the execution

  --Doc  - This folder contains the java doc creating out of the project 

  --testng.xml - This is main testng file which gets executed. 



Libararies Used: 
---------------------------------
1. apache-log4j-1.2.17 --- For Logging 
2. guice-3.0.jar --- For customized TestNG HTML Report
3. jxl-2.6.12.jar --- For Reading Excel file.
4. selenium-java-3.0.1 -- Main Selenium WebDriver 
5. velocity-dep-1.4.jar -- For customized TestNG HTML Report
6. reportng-1.1.4.jar  --  For customized TestNG HTML Report


How to Run
-----------------------------------------
It is very simple to run as mentioned below.
1. Download the project
2. Add the recuired libraries. 
3. Chhose the group of Test Cases needs to be run, Test cases are as grouped. (Look at testng.xml)
   a) Smoke
   b) Flight
   c) Home
   d) Rgression. 
4. Under Package com.visa.testcases the files ending with "TCRun" actually contains the TestNG tests which calls methods from files ending with TC and which further uses methods of Page Objects