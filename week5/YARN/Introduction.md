#### 1.Overview

- YARN can be thought (xem nhu) of same as an operating system for a cluster. A cluster is a set of loosely(lỏng lẻo) or tightly connected computers that work together to be viewed as  single system. 
- The cluster represents the collection of resources, such as compute, memory, disk-space disk-space, network bandwidth that YARN must arbitrate among jobs that run on the cluster.
- Similar to how an OS presides(quan li = manage) over the machine's resources and distributes them among  competing process,
- YARN allocates cluster resources among competing jobs.
- The following picture shows where YARN sits in the Hadoop stack:

![[Pasted image 20231127152102.png]]

#### 1. What is YARN
- stands for YET Another Resources Negotiator.It has two major responsibilities: 
	1. Management of cluster resources such as compute,network, memory
	2. Scheduling and monitoring of jobs
- YARN achieves these goals through two long-running demons
![[Pasted image 20231127152640.png]]


- The two components work in a master-slave relationship, where the Resource Manager(RM) is the master and the Node Managers the slave. A single Resource Manager runs in the cluster with one Node Manager per machine. Together, these two components make up the data-computation framework.

#### 2. Resource Manager

- Consists of two parts:
	- **Applications manager**:  is responsible for accepting job submissions and starting a container for an entity called the *ApplicationMaster*  .It also restarts the ApplicationMaster container if the container fails
	- **Scheduler**: The scheduler is responsible for allocating resources such as disk, CPU , and network running applications, subject to restrictions imposed by queues and capacity(tuân theo các hạn chế do .. và dung lượng). The scheduler does not monitor nor initiate restart on application or hardware failures. 
##### Note : 
	- In the context of YARN, container is an abstract notion that represent resources such as disk, memory CPU, network, and others. A container grants right to an application to use a specific amount of resources on a specific host.
- In Linux a container is a cgroup. Map and reduce tasks run inside a container. A single machine in the cluster can have multiple containers. 
----- 
- The Resource Manager acts as a single point of failure. If the machine hosting the RM goes down, no jobs can get get scheduled .
- To reduce the shortcoming high availability for YARN  was introduced in Hadoop 2.4. A pair or Resource managers runs in Active/Standby configuration to achieve high availability. 
-  If the active Resource Manager dies, then the standby one becomes the active and the cluster continues to function correctly. The transition from standby to active mode can be done manually by an administrator or automatically. For automatic transition, Zookeeper is required for election

![[Pasted image 20231127161248.png]]

#### 3. Node manager 
- It is an agent that runs on every machine in the cluster. It is responsible for launching containers on that machines and managing the use of resources by the containers