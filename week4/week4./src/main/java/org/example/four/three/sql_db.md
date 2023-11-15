**0.Overview**

- Relational Databases (RDBMS)
Relation Database Management Systems (RDBMS) are one of the earliest datastores. RDBMS are optimized for OLTP workloads requiring fast reading and updating a large number of rows. That’s why RDBMSs are row-oriented databases.

- The data is organized in tables. Tables are normalized for reduced data redundancy and better data integrity.

- Tables may have primary and foreign keys:

- Primary Key is a minimal set of attributes (columns) that uniquely identifies a record (row) in a table.

- Foreign Key establishes relationships between tables. It is a set of attributes in a table that refers to the primary key of another table.

**When to Use SQL Database**

- SQL databases are suitable for storing structured data. Data is stored in a table. Each record (row) has the same number of attributes (columns) of the same type.

There are two kinds of applications:

* Online Transaction Processing (OLTP): Capture, store, and process data from transactions in real-time.

* Online Analytical Processing (OLAP): analyze aggregated historical data from OLTP applications.

* OLTP applications need datastores that support low latency reads and writes of individual records. OLAP applications need datastores that support high throughput reads on a large number of (read-only) records.

----
### **SQL DATABASE**

**1. Oracle**


- Oracle is a relational database management system created and run by the Oracle Corporation. Among all the types of SQL databases, Oracle stands out. Currently, it supports multiple data models like document, graph, relational, and key-value within a single database. In its latest releases, it refocused on cloud computing. Oracle database engine licensing is fully proprietary, with both free and paid options available.

**Pros of Oracle**


- Innovations for daily workflow. Starting with the Oracle 12c release, when the software entered the hybrid cloud era, new cloud computing technologies appeared regularly. With every new release, Oracle tries to keep up with the innovation pace while focusing on information security, including active data guard, partitioning, improved backup, and recovery.

- Strong tech support and documentation. Oracle ensures decent customer support and provides comprehensive tech documentation across multiple resources. So, you’ll likely find solutions to any issues that appear. You may also expect some community support.

- Large capacity. Oracle’s multi-model solution allows for accommodating and processing a vast amount of data. Thanks to the recently released multi-tenancy feature, the database architecture now simplifies packing many databases and manages them smoothly. In combination with in-memory data processing capabilities, it creates a strong engine for synchronous data processing.

**Cons of Oracle**

**High cost.** Though the Oracle database has free editions, they are very limited in terms of functionality. Standard Edition, which doesn’t include all available features, costs $17,500 per unit. The Enterprise Edition is over $47,000 per unit.

**Resource-consuming technology.** The Oracle database needs powerful infrastructure. Not only does installation require a lot of disk space, but you’ll also have to consider constant hardware updates if you deploy it on-premises.

**Hard learning curve.** Oracle database is not a system to start using right away. It’s better to have certified Oracle DB engineers to run it. Oracle’s documentation, while covering many issues, can sometimes be overwhelming and even confusing. So, to install and run an Oracle database, you’ll have to consider hiring dedicated experts.

**Use cases**

**Large-scale enterprise applications**. 

Given all those perks and pitfalls, you can consider Oracle RDBMS as a reasonable solution for online OLTP, data warehousing, and even mixed (OLTP and DW) database applications. If you have a billion records to hold and manage – and a sufficient budget to support it – Oracle hybrid cloud software is a good option.

**Financial institutions.**

Oracle is widely used in the financial sector, where data integrity and security are paramount. Banks, insurance companies, and investment firms often rely on Oracle to manage sensitive financial data and transactions.

**Government and public sector.** 

Oracle is often chosen for its robust features and security in government and public sector applications, including national security, healthcare, and transportation systems.

**2. MSSQL**

As a completely commercial tool, Microsoft SQL Server is one of the most popular relational DBMSs, in addition to MySQL, PostgreSQL, and Oracle. It copes well with effective storing, changing, and managing relational data. To interact with SQL Server databases, DB engineers usually utilize the Transact-SQL (T-SQL) language, which is an extension of the SQL standard.

**Pros of MSSQL**
Variety of versions. Microsoft SQL Server provides a wide choice of different options with diverse functionalities. For instance, the Express edition with a free database offers entry-level tooling, the perfect match for learning and building desktop or small server data-driven applications. The Developers option allows for building and testing applications, including some enterprise functionalities, but without a production server license. For bigger projects, there are also Web, Standard, and Enterprise editions, with a varying extent of administrative capabilities and service levels.

**End-to-end business data solution.** With a focus on mostly commercial solutions, MSSQL provides a lot of business value-added features. The optional selection of components allows building ETL solutions, forming a knowledge base, and implementing data clearance. Also, it provides tools for overall data administration, online analytical processing, and data mining, additionally offering solutions for report and visualization generation.

**Rich documentation and community assistance.** With Microsoft SQL Server aimed at comprehensive database maintenance, the full online documentation also reflects this concept. The correspondingly structured guidelines, numerous whitepapers, and demos give a full picture of the MSSQL data system. Also, Microsoft Premier provides access to dedicated Microsoft community support, which is an advantage when a DB engineer needs assistance.

**Cloud database support.** A part of the consistent Microsoft ecosystem, MSSQL can be integrated with Microsoft Cloud, Azure SQL Database, or SQL Server on Azure Virtual Machines. The solutions allow shifting database administration to the cloud if your business software database becomes really overwhelming and hard to administer.

**Cons of MSSQL**
**High cost.** Being mostly used at the enterprise scale, MSSQL Server remains one of the most expensive solutions. Speaking of numbers, the Enterprise edition currently costs over $15, 123 per core, sold as 2 core packs.

**Unclear and floating license conditions.** Another issue is the ever-changing licensing process. The pricing strategy itself is hard to understand, and the elements included in a particular edition are floating, tending to shift from one to another.

**Complicated tuning process.** For those beginners who have to operate heavy data sets, working with query optimization and performance tuning may be problematic. As the process is not so obvious, it can create substantial bottlenecks early on.

**Use cases**

MSSQL Server is a reasonable option for companies with other Microsoft product subscriptions. As Microsoft builds a robust ecosystem with seamless integration of services, MSSQL emerges as a powerful database solution. With its cloud accessibility and advanced data retrieval tools, MSSQL proves to be a valuable asset for businesses, ensuring a sustainable and efficient system that aligns with evolving needs.

**MySQL**
MySQL is one of the most popular relational database systems. Originally an open-source solution, MySQL is now owned by Oracle Corporation. Today, MySQL is a pillar of LAMP application software. That means it’s a part of Linux, Apache, MySQL, and Perl/PHP/Python stack. Having C and C++ under the hood, MySQL works well with such system platforms as Windows, Linux, MacOS, IRIX, and others.

**Pros of MySQL**
**Free installation.** 

The community edition of MySQL is free to download. With a basic set of tools for individual use, MySQL community edition is a good option, to begin with. Of course, there are other, prepaid versions for Enterprise or Cluster purposes with richer functionality. Nevertheless, if your company is too small to pay for one of them, the free-to-download model is the most suitable for a fresh start.

**Simple syntax and mild complexity.** 

MySQL’s structure and style are very plain. Developers even consider MySQL a database with a human-like language. MySQL is often used in tandem with the PHP programming language. Because they share a gentle learning curve, it’s much easier to form a team to manage your database. Also, MySQL is easy to use. For instance, most of the tasks can be executed right in the command line, reducing development steps.

**Cloud compatibility.** 

Business-oriented by nature and originally developed for the web, MySQL is supported by the most popular cloud providers. It’s available on leading platforms like Amazon, Microsoft, and others. This makes MySQL even more attractive and gives businesses room for growth.


**Cons of MySQL**

**Scalability challenges.** MySQL was not built with scalability in mind, which is inherent in its code. Theoretically, you can scale MySQL, but it will need more engineering effort than any of the NoSQL databases. So, if you expect one day your database will increase substantially, keep this limitation in mind or choose another DBMS option.

**Partial open-source support.** Although MySQL has an open-source part, it’s mostly under Oracle’s license. This limits the MySQL community in terms of improving the DBMS. Why do you care? Because when you have completely open-source support, you expect many problem-specific implementations and community assistance. This is not the case when the software belongs to corporate owners, and you have to pay for support.

**Limited compliance with SQL standards.** Structured Query Language has specific standards. MySQL doesn’t completely follow them, i.e., MySQL provides no support for some standard SQL features. On the other hand, MySQL has some extensions and distinct features that don’t match the Structured Query Language standards. It’s not a big deal for small web applications. The issues may appear when you have to shift to other databases, which will likely happen when your business starts growing.

**Use cases**

Small web-based solutions. MySQL database system is the best option when you’re designing a small, web-based solution with a small volume of data. For example, when building a local eCommerce store, MySQL may come in handy.


--------------
### **Non-SQL DATABASE**

### **MongoDB**

A free, open-source, non-relational DBMS, MongoDB also includes a commercial version. Although MongoDB wasn’t initially intended for structured data processing, it can be employed for applications that use both structured and unstructured data. In MongoDB, databases are connected to applications via database drivers. They are widely available within the database management system. Multiple data types are processed simultaneously and use the internal cache for this purpose.

**Pros of MongoDB**

**Simple data access, storage, input, and retrieval.** One of the benefits of MongoDB derived from its NoSQL nature is the fast and easy data operation. That is to say, data can be entered, stored, and withdrawn from the database quickly and without any additional confirmation. As with any other non-relational database, it places emphasis on RAM usage, so the records can be manipulated really fast and without any consequences to data integrity.

**Easy compatibility with other data models.** MongoDB is easily combined with different database management systems, both SQL and NoSQL types. Besides that, it has pluggable storage engine APIs. To make a long story short, this option allows third parties to build their own data storage engines for MongoDB. From a commercial point of view, it creates extra value for business software.

**Horizontally scalable solution.** Scalability – where data is spread out across a distributed network of manageable servers – is a facet of MongoDB’s fundamental nature. It becomes even more important for enterprises operating big data applications. Additionally, the database can allocate data across a cluster of machines. How can that help you? The data is distributed faster and equally, free of bulkiness. As it leads to faster data processing, the application performance is accelerated too.

**Cons of MongoDB**
**Extensive memory consumption.** The denormalization process, when previously normalized data in a database is grouped to increase performance, usually results in high memory consumption. Also, this DBMS keeps in memory all key names for each value pair. Beyond that, because there is no support for joins, Mongo databases have data oversupply, resulting in big memory waste and lower application performance.

**Data insecurity.** With a focus on fast data operation, MongoDB, like any other NoSQL DBMS, lacks data security. As user authentication isn’t a default Mongo option, and higher protection is available with a commercial edition only, you can’t consider it totally secure. Additionally, there are constant MongoDB update releases, with no guarantee that all amendments or data changes will work as they did before. Keep in mind that all manipulations should be formed around these updates, being covered with additional tests.

**Complicated process to interpret into other query languages.** As MongoDB wasn’t initially developed to deal with relational data models, the performance may slow down in these cases. Besides, the translation of SQL to MongoDB queries takes additional action to use the engine, which may delay the development and deployment.

**Use cases**
MongoDB works best in real-time data integration and database scalability. 
For instance, it’s the right option for product catalogs due to its capacity 
to stock a multiplicity of objects with various attribute collections. 
Also, consider here analytic platforms, as MongoDB’s speed provides dynamic performance that can help track the user’s behavior in real time.

### **Redis**

An open-source, NoSQL, in-memory data structure store, Redis can also be used as a cache. Instead of documents, it uses key-value pairs. Its distinct feature is that there are several options for data structuring, such as lists, sets, and hashes.

Allowing for data replication and supporting transactions, Redis executes commands in a queue instead of setting it one at a time.

**Pros of Redis**

**Rapid solution.** Due to its replication and transaction features, Redis processes the data really fast. The absence of dependencies and in-memory data store type makes Redis a worthy competitor even among simple SQL alternatives.

**Massive data processing.** From the data perception and refining perspective, Redis can be considered a colossus. It can easily upload up to 1GB of data for one entry. Add built-in data caching and you get a powerhouse data machine.

**Cons of Redis**

**Dependency on the application memory.** Total reliance and dependency on the application memory is a real drawback. That is to say, your database will crash if its size exceeds the size of available memory.

**No support for query language or joins.** Regarding compatibility with other dataset types, Redis lags behind. Given that at some time your business may need scaling and using other data formats, having rapid entries as a single option leaves this issue open.

**Use cases**

Redis basically has a few different directions to work with. And the first of them is IoT applications. Here, heavy data from IoT devices can be transferred to Redis to process these records before keeping them in any steady data storage. Also, Redis is a perfect option for microservice architectures with scalable cloud hosting. As data here doesn’t have to be long-term persistent, Redis seems a reasonable decision.


### **Cassandra**

Cassandra is a decentralized system developed by Apache. It’s a free Java-based DBMS with multi-replication and multi-deployment features as its strengths. These peculiarities allow for numerous query copying and deploying all of them at the same time. Being rapidly scalable, Cassandra allows for managing large data volumes by replicating them into multiple nodes. It eliminates the problem of database crash – if some of the nodes fail at any time, it’s replaced immediately, and the system keeps working as long as at least one single node is safe.

Cassandra uses its own query language, CQL. In its syntax, it’s very similar to SQL but doesn’t apply joins, replacing them with so-called column families. And the second difference is that not all columns in a table are stored for subqueries. Some of them are used as clustering columns, where adjacent data is put next to each other for fast retrieval. Why does that matter? It provides faster querying from massive datasets, accelerating data processing.

**Pros of Cassandra**

**Data security.** Due to its master node replication feature, Cassandra stays failure tolerant. It means that DB engineers can feel confident about data safety unless master nodes fail all at the same time. As long as it’s extremely unlikely, the database and the application built on it will stay sound and secure.

**Flexibility and on-hand amendments.** Cassandra’s simple syntax has the best of SQL and NoSQL. In addition to scalability, it largely contributes to dataset flexibility. Cassandra collects data on the go, and data retrieval shares the same simplicity, despite dataset size. This allows for enlarging the database to the fullest extent.

**Cons of Cassandra**

**Slow reading.** As Cassandra was initially designed for fast writing, its weakness lies in its incapacity for fast reading. One of the reasons for it is that the system doesn't have bottlenecks for incoming information. So while data can be written to the database quickly, the system may take longer to process and retrieve that data. This can be further explained by the fact that Cassandra spreads the data across multiple nodes in a cluster. When you query the data, it may have to read from various nodes, which can slow down the read performance.

**Need for additional resources.** As Cassandra processes multiple layers of data simultaneously, it demands enough power to do it. This means additional investment in both software and hardware. If this is the first time a company faces such a necessity and is not sure about the resources, then maybe it should consider other database systems.

**Use cases**

Thanks to even data distribution, Cassandra is relevant in applications where large volumes of information are processed. For instance, it’s a great choice for data centers. Also, Cassandra fits well with real-time analytics, as it allows linear scaling and data increase in real time. You may also consider it for applications with constant data streaming, like weather apps. Another option is using it as a DBMS for an eCommerce store, as it allows for storing purchase history and other transactions. Add here the feasibility of tracking such data types as order status and packages, and you’ll get the full solution with eCommerce delivery integration.


