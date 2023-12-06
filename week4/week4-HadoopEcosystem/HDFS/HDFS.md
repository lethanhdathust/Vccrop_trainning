#### 1. What is HDFS
- It is the storage system used by Hadoop applications.This open source framework works by rapidly transferring data between nodes.
- It is often used by companies who need to handle and store big data.

#### 2. The goals of HDFS
- *Large files:* The system should store large files comprising of several hundred gigabytes or petabytes.
- *Streaming data access:* 
	- HDFS is optimized and built for a  write-once and read-many times pattern.
	- Having the time to read entire dataset is more important than the latency in reading the first record.
	- This assumption enables high throughput data access and also simplifies data coherency issues.

- ![[Pasted image 20231127141155.png]]
 *- Commodity hardware:* 
	 - Hadoop is designed to run in clusters of cheap commodity hardware. 
	 - The chance of hardware failure in such situations is high but the system is expected to continue working correctly. => HDFS is highly fault-tolerant and designed to be deployed on low-cost hardware.
#### 3.Working of HDFS

- A file system, distributed or local, must know the location of disk blocks making up a file. Then be it can retrieve blocks for a clients.
- Additionally, the file system should return any metadata related to the file to the client.
=> Two software made up HDFS : Namenode and Datanode

![[Pasted image 20231127104918.png]]

- The *NN keeps track of all the data stored on HDFS*. It maintains the file system namespace and controls the clients's access to files.=> it keep the metadata
  
  - (Essentially, Namespace means a container. In this context it means the file name grouping or hierarchy structure.)
- NN and DN function like a book glossary, used to navigate desired information.The glossary (or the table contents) is the metadata about the topics covered in a book. The NN holds metadata about the location of the actual data.

- The clients talk to the Namenode to read or write a file. The Namenode responds with the location if the right Datanode to send or receive data. The client then contacts the Datanodes specified by the Namenode for writing or reading data blocks. 
- Note that the data doesn't flow through Namenode. The clients and the Datanodes communicate directly to avoid making the Namenode a bottleneck. 

![[Pasted image 20231127135444.png]]


- The relationship between a Namenode and Datanodes is that of master and slaves. The Namenode acts as the master, Datanodes as slaves.

#### 4. Disadvantages
- **Low latency data access:**
	- HDFS isn't designed for low-latency access to data in the tens of milliseconds range. HDFS optimized for providing high throughput of data, possibly at the expense of latency(thông lượng dữ liệu cao, có thể phải trả giá bằng độ trễ)
	- HDFS is designed to batch processing  rather than interactive use-cases
	- "interactive use-cases" refers to scenarios where users require real-time or near real-time access to data and expect quick response times. Interactive use-cases typically involve tasks such as running ad-hoc queries, performing iterative analysis, or supporting interactive applications where users expect immediate responses.

	- The statement suggests that HDFS (Hadoop Distributed File System) is primarily designed to support batch processing scenarios rather than interactive use-cases. Batch processing involves processing large volumes of data in a scheduled or periodic manner, where response time is not a critical factor. Examples of batch processing include offline data processing, data analytics, and ETL (Extract, Transform, Load) processes.
- Numerous small files: Namenode holds filesystem metadata in memory. This limits the number of files in a system by the amount of memory available on the Namenode