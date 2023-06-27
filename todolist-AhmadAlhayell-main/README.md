# TODO App
A simple TODO application that uses SQLite to store and manage TODO items.

## Description
This application allows users to create, update, read, and delete TODO items. It utilizes the SQLite database for storing the tasks. The application is written in Java and uses JUnit and Mockito for unit testing.

## Installation
To run the application locally on your machine, follow these steps:

1. Make sure you have the Java Development Kit (JDK) installed on your computer.
2. Download or clone the source code for the TODO application from the GitHub repository.
3. Navigate to the downloaded source code directory.
4. Compile the code using the command javac Main.java.
5. Run the application using the command java `Main`.

## Features
- Create a new TODO task with a description.
- View an individual TODO task based on ID.
- View all TODO tasks in the list.
- Update an existing TODO task.
- Delete a TODO task based on ID.
   
## Dependencies
The following dependencies are used in the project:

1. `JDBC`: For connecting to and communicating with the database.
2. `SQLite JDBC Driver`: For handling the SQLite database.
You can add these dependencies to your build tool (e.g., Maven, Gradle) or download the JAR files manually and include them in the project.
## Testing
The application comes with unit tests to ensure its functionality is working correctly. To run the tests, follow these steps:

1. Make sure you have the JUnit and Mockito libraries installed.
2. Navigate to the source code directory for the TODO application.
3. Run the tests using the command java -cp <classpath> ` org.junit.runner.JUnitCore DatabaseTest`, where <classpath> is the path to the JUnit and Mockito libraries along with the test source code.
Contributing
Contributions are welcome! If you would like to contribute to the project, follow these steps:

