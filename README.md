
### Prerequisites

This project is built using Java and Maven. Please install these tools before running.

- [Java](https://www.oracle.com/uk/java/technologies/javase-downloads.html)
- [Maven](http://maven.apache.org/download.cgi)

### Installation

1. Clone the repo
```sh
git clone https://github.com/mrace94/munro-api.git
```
2. Compile and run JUnit tests 
```sh
mvn clean install
```
3. Run com.xdesign.munro.api.MunroApiApplication from your IDE of choice (IntelliJ/Eclipse)

### How to use

1. Once the application is running, go to http://localhost:8080/munro/search

- The base /munro/search path will return all munros in the database
- Adding ?sort={fieldname} will sort on the specified field. See below for field names
- Optionally, you can add ASC or DESC after {fieldName}, like /search/{fieldName},ASC
- You can specify a minimum or maximum height by using the minHeight and maxHeight URI params respectively
- You can specify a category to search on, by using the category URI parameter. Available
values are MUNRO, TOP or EITHER. Defaults to EITHER
- You can specify the number of items to be returned using the size URI parameter.

### Available fields

- runningNo
- height
- name
- categroy
- gridRef

###

Given more time, I would have expanded the number of tests. As it stands,
only the very basic scenarios are covered. In time, I'd have aimed to test coverage.
I'd also look to flesh out the cucumber integration tests. I have laid our the basic
scenarios but the CucumberStepDefinition code is only stubbed.

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.