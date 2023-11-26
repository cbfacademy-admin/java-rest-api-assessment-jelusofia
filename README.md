# **Stock Profit and Loss Java API using Springboot**
---
## **Overview**
A profit and loss statement is a financial report that provides a summary of revenues, expenses and profit or losses.

For the context of stocks in this project, it simply shows the profit or loss from buying and selling stocks.
You can use this API to:
1. Calculate the Profit or Loss
2. Save a stock transaction
3. View the details of a stock transaction using id
4. See all stock transactions
5. Delete a stock transaction
6. Update the details of a stock transaction

You can go to [Usage](#usage) for more details on how to use each of these functionalities.

---
## Table of Contents
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Setup](#setup)
- [Endpoints](#endpoints)
- [Usage](#usage)
- [Tests](#tests)
- [Contributing](#contributing)

---

## Getting Started

- [Prerequisites](#prerequisites)

- [Setup](#setup)

### Prerequisites

Before you begin, make sure you have the following installed:

1. [JDK 17](https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-17) (or higher)

2. [Git](https://git-scm.com/downloads)

3. [Visual Studio Code](https://code.visualstudio.com/Download)
   1. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
   2. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

Also make sure you have accounts for the following:

1. [GitHub](https://github.com/signup)

### Setup

#### 1. Clone the Repository

```sh
git clone [REPO_URL]
cd [REPO_NAME]
```

Replace [REPO_URL] with the link to your GitHub repository and [REPO_NAME] with the repository's name.

#### 2. Install Dependencies

Open a terminal at the root of the repo directory and run the following command to install the dependencies:

```sh
./mvnw clean dependency:resolve
```

If you are on a Windows machine, that will be:
```cmd
mvnw clean dependency:resolve
```

You should see console output similar to the following:

```sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ api-assessment ---
[INFO] Deleting /Users/user/Dev/cbfacademy/java-api-assessment/target
...
[truncated output]
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.060 s
[INFO] Finished at: 2023-10-03T16:18:25+01:00
[INFO] ------------------------------------------------------------------------
```

#### 3. Running the Application

To start the API in VS Code, press `F5` or tap the 'Play' icon for the `api-assessment` app in the Spring Boot Dashboard.

Alternatively, to start the API from the terminal, run the following command:

```sh
./mvnw spring-boot:run
```

Or on Windows:

```cmd
mvnw spring-boot:run
```

You should see console output similar to the following (press `Ctrl + C` to exit):

```sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ api-assessment ---
[INFO] Deleting /Users/gary/Dev/cbfacademy/java-api-assessment/target
[INFO] 
[INFO] >>> spring-boot:3.1.4:run (default-cli) > test-compile @ api-assessment >>>
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ api-assessment ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
...
[truncated output]
...
2023-10-03T17:17:34.413+01:00  INFO 35536 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2023-10-03T17:17:34.751+01:00  INFO 35536 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-10-03T17:17:34.756+01:00  INFO 35536 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-10-03T17:17:34.756+01:00  INFO 35536 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.13]
2023-10-03T17:17:34.777+01:00  INFO 35536 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-10-03T17:17:34.778+01:00  INFO 35536 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 364 ms
2023-10-03T17:17:34.898+01:00  INFO 35536 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2023-10-03T17:17:34.907+01:00  INFO 35536 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-10-03T17:17:34.911+01:00  INFO 35536 --- [  restartedMain] com.cbfacademy.apiassessment.App         : Started App in 0.643 seconds (process running for 0.786)
```

Open your browser and navigate to `http://localhost:8080`.

---
## **Endpoints**
* [POST /api/v3/pnlcalculator](#1-add-a-new-transaction)
* [GET /api/v3/pnlcalculator/calculateProfit](#2-calculate-profit)
* [GET /api/v3/pnlcalculator](#3-get-all-transactions)
* [GET /api/v3/pnlcalculator/{id}](#4-get-transaction-by-id)
* [DELETE /api/v3/pnlcalculator/{id}](#5-delete-transaction-by-id)
* [PUT /api/v3/pnlcalculator/{id}](#6-update-transaction-by-id)
* [GET /api/v3/pnlcalculator/getByProfit](#7-get-sorted-transactions-by-profit)

---
## **Usage**
This is the main controller class for handling stock transactions:
[StockTransactionControllerV3](src/main/java/com/cbfacademy/apiassessment/api/StockTransactionControllerV3.java)

To use the API, follow these steps:
1. Once the application is running you can use swagger-ui, by navigating to http://localhost:8080/swagger-ui/index.html, to access the documentation for this API
2. Using postman
    * Input the URL `http://localhost:8080` followed by the endpoint for the functionality you wnat to use

### 1. Add a New Transaction
**Endpoint: POST /api/v3/pnlcalculator**

**Request:**
```
{
    "id": "generated-uuid",
    "name": "ExampleStock",
    "quantity": 10,
    "buyingPrice": 150.0,
    "sellingPrice": 200.0,
    "commission": 5.0,
    "profit": 0.0
}
```
**Example Response:**
```
Status: 200 OK
```

### 2. Calculate Profit
**Endpoint: GET /api/v3/pnlcalculator/calculateProfit**

**Request:**
```
Parameters:

name (String): Name of the stock
quantity (Integer): Quantity of stocks
buyingPrice (Double): Buying price per stock
sellingPrice (Double): Selling price per stock
commission (Double): Commission per transaction
```
**Example Response:**
```
Status: 200 OK
Response Body: 250.0
```

### 3. Get All Transactions
**Endpoint: GET /api/v3/pnlcalculator**

**Example Response:**
```
Status: 200 OK
Response Body: 
[
    {
        "id": "generated-uuid-1",
        "name": "ExampleStock1",
        "quantity": 10,
        "buyingPrice": 150.0,
        "sellingPrice": 200.0,
        "commission": 5.0,
        "profit": 250.0
    },
    {
        "id": "generated-uuid-2",
        "name": "ExampleStock2",
        "quantity": 15,
        "buyingPrice": 120.0,
        "sellingPrice": 180.0,
        "commission": 4.0,
        "profit": 200.0
    },
    ...
]

```

### 4.  Get Transaction by ID
**Endpoint: GET /api/v3/pnlcalculator/{id}**

**Example Response:**
```
Status: 200 OK
Response Body: 
{
    "id": "generated-uuid",
    "name": "ExampleStock",
    "quantity": 10,
    "buyingPrice": 150.0,
    "sellingPrice": 200.0,
    "commission": 5.0,
    "profit": 250.0
}

```

### 5.  Delete Transaction by ID
**Endpoint: DELETE /api/v3/pnlcalculator/{id}**

**Example Response:**
```
Status: 200 OK
```

### 6.  Update Transaction by ID
**Endpoint: PUT /api/v3/pnlcalculator/{id}**

**Request:**
```
{
    "id": "generated-uuid",
    "name": "UpdatedExampleStock",
    "quantity": 12,
    "buyingPrice": 160.0,
    "sellingPrice": 220.0,
    "commission": 6.0,
    "profit": 320.0
}
```

**Example Response:**
```
Status: 200 OK
```

### 7.  Get Sorted Transactions by Profit
**Endpoint: GET /api/v3/pnlcalculator/getByProfit**

**Example Response:**
```
Status: 200 OK
Response Body: 
[
    {
        "id": "generated-uuid-2",
        "name": "ExampleStock2",
        "quantity": 15,
        "buyingPrice": 120.0,
        "sellingPrice": 180.0,
        "commission": 4.0,
        "profit": 200.0
    },
    {
        "id": "generated-uuid-1",
        "name": "ExampleStock1",
        "quantity": 10,
        "buyingPrice": 150.0,
        "sellingPrice": 200.0,
        "commission": 5.0,
        "profit": 250.0
    },
    ...
]
```

---
## **Tests**
### **Running Tests**
1. Open a terminal in the project directory
2. Execute the following command
Then run the following command in your terminal.
```
./mvnw clean test 
```
If you are on Windows, run this command instead:
```
mvnw.cmd clean test
```
### **Test Information**
There are three test files [AppTests.java](src\test\java\com\cbfacademy\apiassessment\AppTests.java), [StockTransactionTest.java](src\test\java\com\cbfacademy\apiassessment\StockTransactionTest.java) and [JsonHandlerTest.java](src\test\java\com\cbfacademy\apiassessment\JsonFileHandlerTest.java)

---
## **Contributing**
Contributions are welcome! Here's how you can get involved:
1. Fork the repository to your GitHub account.
2. Clone the forked repository to your local machine, if you haven't already.
3. Create a new branch for your feature or bug fix.
``` 
git checkout -b feature-name
```
4. Make your changes and commit them with a descriptive commit message.
``` 
git commit -m "Add feature-name"
```
5. Push your changes to your fork on GitHub.
``` 
git push origin feature-name
```
6. Open a pull request on the original repository. Include the folowing in your request:
* Provide a clear title and description for your changes.
* Reference any related issues or discussions.
