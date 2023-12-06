
#### Architecture

- Spark is a distributed parallel data-processing framework and many similar to traditional MapReduce, framework. Spark has the same master-slave architecture as MapReduce, where one process, the master, coordinates and distributes work among slave processes.
	- Driver
	- Executor
- Some basic terms:
	*- Resource Manager:* In Spark, a resource manager is responsible for allocating resources to Spark applications running on a cluster.Spark has a pluggable architecture that allows different cluster managers to be used as resource managers such as: Apace mesos, Hadoop YARN, Kubernetes,...
	*- Application Master*: Application Master is a program that is responsible for managing a specific Spark application running on a cluster. The mission of Application Mater is Allocating resources, coordinating tasks, faults tolerance , reporting the status of spark application to the Driver program
	*- Container:*  Each container represents a virtual machine, or a process, that runs on a node in the cluster and is assigned with a certain amount of resources to execute the tasks or the executor.Container are created by the resource manager like YARN , Mesos,..
	*- Executor:* In Spark, an executor is a process that runs on a worker node in a cluster and is responsible for executing tasks. It is launched by the Application Master and are responsible for processing the data and performing the computations
### Driver: 

- *The driver is the master process that manages the execution of a Spark job.* it is responsible for maintaining the overall state of the spark application, responding to a user's program or input and analyzing , distributing and scheduling work among executor processes.
- The driver process is the heart of the Spark application and maintains all application related information during an application's lifetime


### Executor

- Executors are the slave processed that execute the code assigned to them by the driver process. They report  the state of the computation on that executor back to the driver.

![[Pasted image 20231205111250.png]]


### Cluster manager 

- A MapReduce or Spark job runs on a cluster of machines. MapReduce 's Application Master or Spark's Driver process do not have the authority or the ability to allocate cluster resources for job execution. 
- Another piece of software manages the physical resources of the cluster and arbitrates
- The Spark driver negotiates ( dàm phán) resources with the cluster manager to launch executor processes .

- YARN is one such example of a cluster manager software. Spark is compatible with the following cluster managers : 

- Hadoop YARN
- Apache Mesos
- Built-in standalone cluster manager
- Kubernetes
- Local mode


![[Pasted image 20231205160412.png]]

- The standalone cluster (cụm độc lập) has only Spark specific components. It has no dependencies on Hadoop components and Spark driver acts as the cluster manager.
- In local mode, the entire Spark application runs on a single machine. Parallelism is achieved through multi-threading -> used for learning and testing Spark.
- Other cluster managers also arbitrate resources( phan bo) and coordinate jobs(dieu phoi) jobs across machines though their implementations and design choices may different.

#### Execution nodes

Spark can execute in two mode:

**- Cluster mode:** In cluster mode, the user submits a spark application (Java .jar file, Python, or R script) to the cluster manager. The manager in turn spawns the driver and the executor processes(sinh ra trình điều khiển và trình thực thi) on worker nodes to execute job. In this setting, both the driver and the executors live inside the cluster
![[Pasted image 20231205161642.png]]


**- Client mode:** The client mode is similar to the cluster mode , except that the driver process lives on the client machine that is used to submit the Spark job outside the cluster
	-  The machine hosting the driver process is not co-located on the cluster running the executor processes
	- The client machine is responsible for maintaining the driver process, while the cluster is responsible for maintaining the executor processes

- **# Local Mode:

In local mode, Spark runs on a single machine, using all the cores of the machine. It is the simplest mode of deployment and is mostly used for testing and debugging.

![](https://miro.medium.com/v2/resize:fit:626/1*geGYn7n2XUqpnjZt0A8sLg.png)

Here you don’t need to much worry about complex cluster setups or configurations. This is a good choice for users who are just starting with Spark, or for those who need to test small-scale data processing workflows.**