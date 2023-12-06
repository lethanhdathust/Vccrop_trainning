- Spark offers APIs and data abstractions that significantly enhance the developer experience. The original Spark paper describe the low-level abstraction called RDD. 
- Others like DataFrames and Datasets were added. Spark enables distributed data processing through functional transformations of data collections (RDD) . The Spark API significantly reduces the size of programs compared to other frameworks like MapReduce. The three data abstractions available in Spark are:
	- Resilient Distributed Datasets
	- DataFrames
	- Datasets


![[Pasted image 20231206095551.png]]

- Data Frames and Datasets fall under the higher-level structured APIs while RDDs are referred low-level unstructured, APIs. Generally, the guidance from the Spark community is to almost always work with higher-level APIs


**Transformation**: A Spark operation that reads a DataFrame, manipulates some of the columns, and returns another DataFrame (eventually). Examples of transformation include [filter](https://spark.apache.org/docs/latest/api/python/reference/api/pyspark.sql.DataFrame.filter.html#pyspark.sql.DataFrame.filter) and [select](https://spark.apache.org/docs/latest/api/python/reference/api/pyspark.sql.DataFrame.select.html#pyspark.sql.DataFrame.select). Figure 2 presents a transformation that creates a DataFrame with a new column group using the age column of the input DataFrame.

![[Pasted image 20231206101835.png]]

**Action**: A spark operation that either returns a result or writes to the disc. Examples of action include [count](https://spark.apache.org/docs/latest/api/python/reference/api/pyspark.sql.functions.count.html#pyspark.sql.functions.count) and [collect](https://spark.apache.org/docs/latest/api/python/reference/api/pyspark.sql.DataFrame.collect.html#pyspark.sql.DataFrame.collect). Figure 3 presents an action that returns the total number of rows in a DataFrame.


![[Pasted image 20231206101846.png]]