This repository consists of a sample testing framework with Cucumber.
The framework is based on:
    
    - Java JDK -> version: 8
    - Selenium -> version: 3.141.59
    - Cucumber-java and Cucumber-junit -> version: 4.20

Dependencies are handled with Maven through the 'pom.xml' on root.


NOTES:
    
    - ChromeDriver 103 has some instability issues with this framework configuration, Selenium version or overall driver compatability issues. 
    - Forced testing to run on the more stable ChromeDriver 102 version to have tests pass much more consistently.
    - Last scenario in the feature will tend to fail from host detecting webdriver and rerouting to different source page. I've left it as is for demonstration purposes.
    - Framework tested with ChromeDriver, ChromeDriver headless and FirefoxDriver.
    - Includes a mixture of implicitWaits/explicitWaits that has reduced StaleElementReferenceException occurences to none. See config.properties file for times.