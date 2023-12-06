#### 1. what is HBASE
- it it a column-oriented non-relational database management system that run on top of Hadoop Distributed File System.
- Provide a fault-tolerant way of storing sparse datasets

![[Pasted image 20231124115102.png]]

- Work well with real-time data and random rad and write access to Big Data

#### 2.Feature


![[Pasted image 20231124115715.png]]

- Ex: An HBASE column represents an attribute of an object 
![[Pasted image 20231124115755.png]]
- suppose the table save the data about heart monitor., each row may be a log record.
-  Many attributes can be grouped together into column families such that  elements of a column family are all stored together.
Ex: ![[Pasted image 20231124145327.png]]


- New columns can be added to column families at anytime
- HBASE schema is very flexible
- As HDFS has a Name Node and secondary nodes,HBASE is built on similar concepts. HBASE has master nodes to manage the cluster and region servers to perform the work.

#### Different between HBASE and HDFS
![[Pasted image 20231124145855.png]]


#### HBASE architecture

![[Pasted image 20231124150120.png]]


#### HBASE concepts

![[Pasted image 20231124150333.png]]

- HMaster is the master server. It monitors the region server instances, assigns region to region servers, and distributes service to different region servers, it manages ant changes that are made to the schema and metadata operations. 

- The region servers receive read and write requests from the client and assign request to a specific region where the column family resides = > They responsible for serving and managing regions that are present in a distributed cluster.
	- Rather than go through HMaster all the time, the region servers can communicate directly with the client to facilitate requests

- The region is the basic and smallest unit of the HBase cluster that consist of column families.
	- It contains multiple stores, one for each column family 
	- Has two components : Hfile and Memstore 
- ZooKepper: a centralized service for maintaining configuration information to maintain healthy links between nodes.
	- It provides synchronization across distributed applications and is used to track server failure and network partitions by trigger an error message