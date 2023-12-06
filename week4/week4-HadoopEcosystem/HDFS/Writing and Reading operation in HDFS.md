

#### Write path

- A client initiates the write process. A client could be an application using the Java API or a person working with the HDFS command line.
- The flow of this interaction between client and HDFS like this: 
	- A client buffers data on the local disk initially. It waits for one HDFS-block worth of data to accumulate (tich tru ) before contacting the Namenode.
	- The NN, once contacted by the client, verifies if the file exists and that the client has the required permissions to create that file. If these check pass, the NN makes a corresponding change in its namespace. It then returns the client a list of Datanodes to write to. These Datanodes host the blocks(and their replicas ) that make up the files