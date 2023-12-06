#### 1.Overview

- First step of running YARN application involves requesting the RM (resources) to create an Application Master(AM) process. A client submits a job and the RM finds a Node Manager that can launch a container to host the AM process. 
- The AM process represents the client job/application . It can either run the job itself and return or request for additional resources from the RM.
- Later, The RM has Node managers on other machines launch containers on behalf of the  AM process to run the distributed computation. Nodes chosen for new container allocations allow the computation to execute as close as possible to the input data also known as _data locality_. Ideally, the container is allocated on a node hosting a replica of the data block. The next preference is a node in the same rack as the input data block, and lastly any available node in the cluster.

![[Pasted image 20231127171757.png]]


