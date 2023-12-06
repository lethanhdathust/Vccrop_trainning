- it maintains the filesystem tree and all metadata for all files and directories in the tree. 
- The file system metadata information is stored on the local disk of the Namenode by the following entities: 
	- Namespace Image file
	- Edit Log

#### Namespace Image File (FS Image)

- It is a snapshot of the HDFS file system metadata at a certain point of time. 
- It is a checkpoint of the file system's metadata. 
- Every modification to the filesystem is assigned a unique, monotonically increasing transaction ID
- An FS image file represents the file system's state after all modifications up to a specific transaction ID

#### Edit log

- EditLog is a transaction journal( ban ghi giao dich) or log containing records for every change that occurs to the file system's metadata after the most recent FS image.
- Both the FS iamge and the edit log live on the local file system of the Namenode.
- The location of the fsimage and the editlogs at `/usr/local/tmp/dfs/name/current/`. The location is configured as the directory `＄{hadoop.tmp.dir}/dfs/name`. In this case, the variable `hadoop.tmp.dir` is set to `/usr/local/tmp/`.
- ![[Pasted image 20231204134635.png]]

- We can cat the contents of the VERSION file and see the various fields 

![[Pasted image 20231204135534.png]]

#### Working of the Namenode

- A file in the system consists of several blocks.The blocks making up a file don;t live on the same Datanode but instead spread across different Datanodes.
- At the start up time. the NN does not know the location of the file;'s data blocks. 
- It builds a map containing the location of each data block of every file from periodic reports(bao cao dinh ki) sent by Datanodes.
- Each Datanode identifies block replicas it has to the NN, by sending a block report.
- The Name Node dynamically computes the block map from the reports and maintains it in memory.



- When the NN starts up, it picks the FS image and applies the edit log to get the latest state of the file system's metadata. Next, the NN writes the new HDFS state to the FS image and starts normal operation with an empty edit file. 
- The start up time is proportional to the size of the edit log -> It lead to the problem , A huge edit log takes longer to process => increase the start-up time for the Name Node.
- The NN merges the FS image and edit log only when it starts-up -> it can cause the edit log to grow large in size over time  -> Secondary Name node come in

#### Secondary Namenode

- The secondary Namenode periodically (dinh ky) merges the edit log with FS image so the edit log does not grow over a reasonable limit.
- The Secondary Namenode is a helper to the primary Namenode but can't replace it in case of failure . 
- Usually the Secondary Namenode is run on a different machine because it requires similar computer and memory resources as the NN.\
- Secondary NN doesn't run when HDFS is deployed with high availability.


#### Single point of failure

- If a particular component in a distributed system is designated as a single point of failure, a failure of this critical component can bring entire system to failure. 
- The NN is a single point of failure in the Hadoop ecosystem. If it becomes unavailable , all clients interacting with the NN, including MapReducess jobs, will fail.No client will be able to read, write or list files and directories on the system


#### Addressing NN failures 

- It is enforce to make NN resilient (phục hổi ) to failure :
	- Using backups
	- Using Secondary Namenode
	- Using Standby Namenode


1. The first option is to backup metadata files, specially the namespace image file and edit log file that make up the metadata state of the filesystem. HDFS can be configured so that NN writes to multiple file systems and the writes are synchronous and atomic.
     
     Usually, the writes are also made to a drive on the network filesystem (NFS). The Network File System is a distributed file system protocol that can mount remote directories on your server. 
     This allows you to leverage( tận dụng) storage space in a different location and write easily to the same space from multiple servers.

2. The second option is to run a Secondary Namenode. It maintains a copy of the FS image, but, its state usually lags behind the primary. In the case of total failure of the primary -> data loss is almost certain.
    - The resource is to copy over the backed-up metadata files to the secondary and run it as the primary.


#### Data nodes

- It stores the actual data. It stores the data blocks on its local filesystem and sends a block report to the Namenode.
- The data for HDFS files will be stored in the directory specified as the value for the configuration setting `dfs.datanode.data.dir` . The default value of this setting is `${hadoop.tmp.dir}/dfs/data`    

- Datanodes respond to client request by performing read-write operations on file systems.They also carry out actions such as block creation, deletion, replication

![[Pasted image 20231204155330.png]]