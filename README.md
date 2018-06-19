# socotra POC app

## Getting Started

Yarn is used for dependency management to provide greater stability and prevent unwanted drift
in version numbers for JavaScript dependencies.

If you don't have Yarn on your computer yet, you'll want to install it globally using this command:
```
npm install -g yarn
```

### Important!
For all **yarn** tasks, you need to be in the "client-app" directory.

```
cd client-app/
```

## Build the App
Run this command to do a full gradle clean and then build which will install the JavaScript dependencies.
In the future, you can skip this command unless you've added additional dependencies.

```
./gradlew clean build
```

## Run the App
There are 2 ways to run the app. The preferred way to run the app locally is running this command to start up the
Webpack Dev Server. After running the yarn start command, you'll see a message in the terminal saying
"Webpack Dev Server is Fired Up!" Shortly after this, the React app will be automatically opened in a new tab of
your default browser.

```
yarn start
```

A Gradle task can be used for to start the Webpack dev server. The Gradle task will use the Gradle installed version of
Yarn, will run from the project root, but the task is best ran without the Gradle daemon.

```
./gradlew yarnStart --no-daemon
```

The other way is to run the Spring Boot server. When you build the app, the compiled client-app files are copied
into a folder named "static" in the main src folder in Spring Boot. You can then start the app locally as you would
with any Spring Boot app. Either through the IDE functions or 

```
./gradlew bootRun
```
#### Important:
You need to run the app using the Spring Boot server in order to make all API calls. The Spring controllers make all the API calls to the service for the app.


## Running the tests

The Jest library is used for testing.  It will calculate code coverage and display these metrics in the 
console whenever the tests run.  Coverage results will also be available in the "client-app/dev/.jest"
directory.  When the project runs on the pipeline, all of the tests will run, and test results and 
coverage information will be available in SonarQube.

To run the tests one time, use this command:

```
yarn test
```

A Gradle task exists to run tests from the root directory using the version of Yarn installed by Gradle.

```
./gradlew yarnTest
```

Jest also provides a very useful "watch mode."  Using this command will run the tests once and then 
continue watching for changes.  The tests will run again whenever a file is saved.  You can tell Jest
which tests to run by entering options in the console while watch mode is running.  More information on
this will be displayed in the console. Watchman is required for watch mode. Watchman can 
be installed with Homebrew with `brew install watchman`.

```
yarn test:watch
```

A Gradle task can be used for to run tests in watch mode. The Gradle task will use the Gradle installed version of Yarn,
but the interactive console will be disabled and the task is best ran without the Gradle daemon.

```
./gradlew yarnTestWatch  --no-daemon
```

## Linting

Linting rules are extended from the [airbnb](https://www.npmjs.com/package/eslint-config-airbnb) linting rules.

The linter will run along with the WebPack build using eslint-loader.

If using IntelliJ, be sure to enable in Settings under ESLint.

You can also run the linter on it's own using this command.  The linter will fix easy issues on it's own, 
such as missing semi-colons, and provide a list of any other issues that need to be addressed.

```
yarn lint
```


## DB Connection
H2 Database can be accessed at local (when application is running) at
http://localhost:8079/mob_socotra_poc/h2/


## Application
Application can be reached here: 
http://localhost:8079/mob_socotra_poc/#/foo
