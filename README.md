This repository consists of a sample testing framework with Cucumber.
The framework is based on:
    
    - Java SDK -> version: 8
    - Selenium -> version: 3.141.59
    - Cucumber-java and Cucumber-junit -> version: 4.20

Dependencies are handled with Maven through the 'pom.xml' on root.


NOTES:
    
    - ChromeDriver\Chrome 103 has difficulties with this version of Selenium
    - Forced ChromeDriver\Chrome 102 with WebDriverManager plugin to minimize errors