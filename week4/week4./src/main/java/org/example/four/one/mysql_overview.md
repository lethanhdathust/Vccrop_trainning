**1. What is MySQL**
- It is a popular open source database.Many big company use MySQL such as : Twitter, Facebok,Shopify, Uber,Netflix,..
- Mysql is a relational database management system.Database are the essential data repository for all software applications.
- A relational database stores data in separate tables.The db structure is organized into physical files optimized for speed.You set up rules governing the relationships between different data fields,, such as one-one,one-many,unique,required, or optional , and "pointers" between different tables
- Users can define, manipulate,control, and query data using Structured Query Language, 

**2. MySQL benefits**
- MySQL is fast, reliable, scalable , easy to use.It was originally developed to handle large databases quickly and has been used in highly demanding production environments for many years.
+ Reliability: MySQL is one of the most mature and widely used databases
+ Scalability: MySQL scales to meet the demands of the most accessed applications. MySQL’s native replication architecture enables organizations such as Facebook to scale applications to support billions of users.
+ Performance: MySQL HeatWave is faster and less expensive than other database services, as demonstrated by multiple standard industry benchmarks, including TPC-H, TPC-DS, and CH-benCHmark.

+ High availability: MySQL delivers a complete set of native, fully integrated replication technologies for high availability and disaster recovery. For business-critical applications, and to meet service-level agreement commitments, customers can achieve

+ Recovery point objective = 0 (zero data loss)
+ Recovery time objective = seconds (automatic failover)
+ Security: Data security entails protection and compliance with industry and government regulations, including the European Union General Data Protection Regulation, the Payment Card Industry Data Security Standard, the Health Insurance Portability and Accountability Act, and the Defense Information Systems Agency’s Security Technical Implementation Guides. MySQL Enterprise Edition provides advanced security features, including authentication/authorization, transparent data encryption, auditing, data masking, and a database firewall.

+ Flexibility: The MySQL Document Store gives users maximum flexibility in developing traditional SQL and NoSQL schema-free database applications. Developers can mix and match relational data and JSON documents in the same database and application.

**3. Basic Query in MySQL**

3.1) Section 1. Querying data 
    + SELECT – learn how to use the SELECT statement without referencing a table
   

3.2) Section 2. Sorting data
+ ORDER BY – show you how to sort the result set using the ORDER BY clause. The custom sort order with the FIELD function will be also covered.
   
3.3) Section 3. Filtering data

+ WHERE – learn how to use the WHERE clause to filter rows based on specified conditions.

+ SELECT DISTINCT – show you how to use the DISTINCT operator in the SELECT statement to eliminate duplicate rows in a result set.

+ AND – introduce you to the AND operator to combine Boolean expressions to form a complex condition for filtering data.

+ OR– introduce you to the OR operator and show you how to combine the OR operator with the AND operator to filter data.
Section 4. Joining tables

+ Table & Column Aliases – introduce you to table and column aliases.
+ Joins  – give you an overview of joins supported in MySQL including inner join, left join, and right join.

Section 5. Grouping data

Section 6. Subqueries

Section 7. MySQL Stored Procedures

When you use MySQL Workbench or mysql shell to issue the query to MySQL Server, MySQL processes the query and returns the result set.

If you want to save this query on the database server for execution later, one way to do it is to use a stored procedure.


**4.Mysql index**

* Types of indexes in MySQL: 

+ Unique indexes – uses unique indexes to ensure distinct values stored in a column.

+ Prefix indexes – shows you how to use the prefix index to create an index for a character string column.

+ Invisible indexes – covers the index visibility and shows you how to make an index visible or invisible.

+ Descending indexes –  shows you how to use descending indexes to increase query performance.

+ Composite indexes – illustrates the application of composite indexes and shows you when to use them to speed up your queries.

+ Clustered indexes – explains the clustered indexes in InnoDB tables.

+ Index cardinality – explains the index cardinality and shows you how to view it using the show indexes command.

+ A functional index is created based on the result of an expression or function applied to one or more columns in a table.

**. MySQL use cases**

+ Ecommerce: Many of the world’s largest ecommerce applications (for example, Shopify, Uber, and Booking.com) run their transactional systems on MySQL. It’s a popular choice for managing user profiles, credentials, user content, financial data including payments, and fraud detection.

+ Social platforms: Facebook, Twitter, and LinkedIn are among the world’s largest social networks that rely on MySQL.