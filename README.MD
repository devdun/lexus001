# Automation Framework with Selenium and TestNG

This repository contains a structured automation framework for testing a "Book a Test Drive" form using Selenium WebDriver and TestNG. The framework is designed using the Page Object Model (POM) approach for better maintainability and readability of the code.

## Table of Contents

- [Introduction](#introduction)
- [Setup](#setup)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Running Tests](#Running Tests)
- [Project Structure](#project-structure)
- [Contributing](#contributing)


## Introduction

This automation framework is designed to test the functionality of the test drive booking form on the Lexus Singapore website. It utilizes Selenium WebDriver for browser automation, TestNG for test case management, and Maven for project management and dependency handling.

## Setup

### Prerequisites

Before running the tests, ensure you have the following installed:

- Java Development Kit (JDK)
- Maven
- ChromeDriver (for Chrome browser automation)
- Git (optional, if you want to clone the repository)

### Installation

1. Clone the repository or download the source code.
   ```bash
   git clone https://github.com/devdun/lexus001.git
   ```

2. Navigate to the project directory.
   ```bash
   cd automation-framework
   ```

3. Update the `pom.xml` file to include the correct Selenium, TestNG, and Surefire plugin versions, if necessary.

4. Download the ChromeDriver executable and place it in a location accessible from the system PATH or update the `TestDriveFormTest.java` file with the correct path to ChromeDriver.

5. Build the project using Maven.
   ```bash
   mvn clean install
   ```

## Running Tests

To run the tests, execute the following Maven command:
```bash
mvn test
```

This command will trigger the Surefire plugin, which will execute the TestNG tests defined in the `testng.xml` file.

## Project Structure

The project structure is organized as follows:

```
automation-framework/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           ├── example/
│   │           │   ├── pages/                # Page Object Model classes
│   │           │   │   └── TestDriveFormPage.java
│   │           │   └── utils/                # Utility classes (if any)
│   │           └── pages/                    # Test classes
│   │               └── TestDriveFormTest.java
│   │
│   └── test/
│       └── resources/
│           └── testng.xml                    # TestNG XML configuration file
│
├── pom.xml                                   # Maven project configuration file
└── README.md                                 # Project README file
```
- **src/main/java:** Contains the main Java source code.
- **src/test/java:** Contains the test classes.
- **pom.xml:** Maven project configuration file defining project dependencies and build settings.
- **testng.xml:** TestNG XML configuration file defining test suite and test classes.

## Contributing

Contributions are welcome! If you have any suggestions, bug fixes, or feature implementations, feel free to open an issue or submit a pull request.


---

Feel free to customize the README file according to your project's specific details and requirements.