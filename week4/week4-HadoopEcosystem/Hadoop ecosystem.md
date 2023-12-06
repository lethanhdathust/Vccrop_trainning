**1.Introduction**

- Hadoop is a reliable, distributed and scalable platform for storing and analyzing vast amounts of data.
- The advantages of Hadoop is its ability to run on cheap commodity hardware, while its competitors may need expensive hardware to do the same job.
- Hadoop is designed to detect and handle failures at the application layer.

#### Overview
- Core components of Hadoop : Hadoop common, HDFS , MapReduce ,  and YARN.
- Hadoop common refer to the common utilities and libraries that support the Hadoop module and libraries that support Hadoop modules.
- HDFS stores the data collected from the ingestion and distributes the data multiple nodes.
- MapReduce is used for making Big Data manageable by processing them into clusters.
- YARN is the resource manager across clusters

**2. Hadoop ecosystem**


- when the data is received from multiple resources, Flume and Sqoop are responsible for ingesting data and transfer them to the storage component HDFS and HBASE. 
- Than the data is distributed to a Map framework like Pig and Hive to process and analysis data, and the processing is done by parallel computing.
- After all is done, tool like Hue is used to access refined data.

![[Pasted image 20231121104931.png]]


#### **1. Ingest data**

- When ever you work with data, you get data from different sources 

![[Pasted image 20231121105659.png]]

**2. Store data**

![[Pasted image 20231121112926.png]]



**3. Analyze data**

![[Pasted image 20231121113021.png]]![[Pasted image 20231121113037.png]]



**4. Access data** 

![[Pasted image 20231121113124.png]]