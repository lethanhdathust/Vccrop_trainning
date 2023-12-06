- Hadoop High availability is a feature to provide fault tolerance and eliminate the single point of failure that the NN represent in HDFS>. 
- Prior HA, NN was a single point of failure in Hadoop clusters-> if the NN failed the entire Hadoop cluster could become unavailable until the NN was brought back online
- With HA, the architecture includes multiple redundant NN ad the active NN is responsible for handling client requests and metadata operations. The standby NN continuously maintains a copy of the metadata and stay in sync with the active NN

- *Active NN :* 
	-  The active NN is the primary NN that manages client requests and metadata operations.
- *Standby NN:*: 
	-  The standby NN is an additional NN that continuously  replicates and maintains a copy of the metadata from the active NN
	- The standby NN communicate with the NN constantly ,keep the data synchronized

- 