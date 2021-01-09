# cucumber_java_basic_framework
A Basic Cucumber Java Framework

# Setup Instructions

## Java Setup

This project needs Java version 1.8

## Webdriver Setup

Install the last versions of:
[Google Chrome](https://www.google.com/chrome/)
and [Mozilla Firefox](https://www.mozilla.org/en-US/firefox/).

You will need the last versions of the webdrivers for those browesers: [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/) for Chrome
and [geckodriver](https://github.com/mozilla/geckodriver/releases) for Firefox.

The ChromeDriver and gheckodriver must be added on the System PATH [system path](https://en.wikipedia.org/wiki/PATH_(variable)).

## Project Setup

1. Clone this repository
2. Open the file `src/config.properties` and change the paths for the Chrome and Firefox executables for the paths in your computer

### To run the tests via command line

3. Access the project folder by the terminal and run the following command:
   `mvn test`

### To run the tests via IDE (Intellij)

3. Import the project
4. Open the class `src/test/java/steps/CucumberRunnerTest.java`
5. Click with the right button and select the option `run 'CucumberRunnerTest'` or press`ctrl+shift+f10`

## Report

The execution test report can be accessed on `target/cucumber-reports`

## About the Author

This project is made by **Aline de Farias Lisboa** or "lisboalien" in social media.

* Twitter: [@Lisboalien](https://twitter.com/Lisboalien)
* LinkedIn: [Aline Lisboa](https://www.linkedin.com/in/alinelisboa/)