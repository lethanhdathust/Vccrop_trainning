- Spark, the platform for data processing for big data, and has taken over the traditional MapReduce framework. Spark outperforms MapReduce .
- Like Hadoop, Spark splits up large tasks across different nodes.However, It tends to perform faster than Hadoop and it uses random access memory(RAM) to cache and process data instead of a file system.
- Benefits of Spark framework:
	- A unified engine that supports SQL queries , streaming data, ML, graph processing.
	- Can be 100x faster than Hadoop for smaller workloads via in-memory processing,disk data storage,..
- Spark is primarily written in Scala, its default language.

![[Pasted image 20231204164045.png]]
#### The Spark ecosystem

- Consists of five primary modules:

	**5. Spark Core:** Underlying execution engine that schedules and    dispatches(lên lịch và phân công ) tasks and coordinates input and output(I/O) operations.
1. **Spark SQL:** Gathers information about structured data to enable users to optimize structured data processing.
2. **Spark Streaming and Structured Streaming:** Both add stream processing capabilities. Spark Streaming takes data from different streaming sources and divides it into micro-batches for a continuous stream. Structured Streaming, built on Spark SQL, reduces latency and simplifies programming.
3. **Machine Learning Library (MLlib):** A set of machine learning algorithms for scalability plus tools for feature selection and building ML pipelines. The primary API for MLlib is DataFrames, which provides uniformity across different programming languages like Java, Scala and [Python](https://www.ibm.com/cloud/blog/python-vs-r).
4. **GraphX:** User-friendly computation engine that enables interactive building, modification and analysis of scalable, graph-structured data.


![[Pasted image 20231204173818.png]]

#### The different between Hadoop and Spark

*1. Performance:* Spark is faster because it uses random access memory (RAM) instead of reading and writing intermediate data to disks. 

*2. Cost:* Hadoop runs at a lower cost since it relies on any disk storage type for data processing. Spark runs at a higher cost because it relies on in-memory computations for real-time data processing, which requires it to use high quantities of RAM to spin up nodes.
*3. Processing:* Though both platform process data in a distributed environment, Hadoop is ideal for batch processing and linear data processing . Spark is ideal for real-time processing and processing live unstructured data streams.
*4. Scalability:* when data volume rapidly grows, Hadoop quickly scales to accommodate (đáp ứng ) the demand via Hadoop Distributed File system
(HDFS). In turn, Spark relies on the fault tolerant HDFS for large volumes of data


![[Pasted image 20231204175900.png]]

#### Spark use cases

- Dealing with chains of parallel operations by using iterative algorthms
- Achieving quick results with in-memory computations
- Analyzing stream data analysis in real time
- Graph-parallel processing to model data
- all ML applications



### References: 
https://www.simplilearn.com/spark-vs-hadoop-article
https://www.ibm.com/blog/hadoop-vs-spark/
https://aws.amazon.com/vi/compare/the-difference-between-hadoop-vs-spark/#:~:text=C%E1%BA%A3%20Hadoop%20v%C3%A0%20Spark%20%C4%91%E1%BB%81u%20cho%20ph%C3%A9p%20b%E1%BA%A1n%20x%E1%BB%AD%20l%C3%BD,h%E1%BA%A1n%20ch%E1%BA%BF%20ch%C3%ADnh%20c%E1%BB%A7a%20Hadoop.