	
- Hive is a data warehouse software within Hadoop that is designed for reading, writing and managing tabular-type datasets and data analysis : 
	- It is scalable, fast , easy to use
	- Hive Query language is inspired by SQL
	- It supports data cleaning and filtering depending on user's requirements.
- A data warehouse stores historical data from many different sources => u can analyze and extract insights from it.

#### 2. Hive and traditional RDBMS compared

![[Pasted image 20231124095820.png]]

#### 3.Hive architecture

![[Pasted image 20231124100349.png]]

- Hive provides different drivers for communication depending on the type of the application.
- Ex: Java bases applications, it uses JDBC drivers, others types of applications use ODBC drivers. 
![[Pasted image 20231124101409.png]]
- Hive services: client interactions are done through this.

![[Pasted image 20231124102120.png]]

- Hive services in charge of performing queries
- Hive server is used to run queries and allows multiple clients to submit requests.
- The driver receives query statements through the command line and send the query to the compiler after initiating a session.
-  Optimizer performs transformations on the execution plan and splits the tasks speed up and improve efficiency.
- The executor executes tasks after the optimizer.
- The meta store in charge of keeping this information in a central place