- A responsibility of YARN is scheduling user jobs. Scheduling is important because the cluster has finite resource to allocate to users' jobs based on some policy.
- Without scheduling, a rogue job cab hog the entire cluster and starve other jobs of resources. There 's no sliver bullet when it come to scheduling, as no one policy satisfies all possible usecases .

**- The three schedulers in YARN are:**

- *FIFO Scheduler :* The jobs are placed in  queue and executed in the order of their submission. Though simple, the FIFO scheduler isn't suitable for a shared cluster.A large job could deny smaller jobs from running. 
	![[Pasted image 20231201104547.png]]

**Advantage:**

- It is simple to understand and doesn’t need any configuration.
- Jobs are executed in the order of their submission.

**Disadvantage:**

- It is not suitable for shared clusters. If the large application comes before the shorter one, then the large application will use all the resources in the cluster, and the shorter application has to wait for its turn. This leads to starvation.
	
 - **Clusters in _shared_ access mode** – or just shared clusters – are the _recommended_ compute options for most workloads. Shared clusters allow any number of users to attach and concurrently execute workloads on the same compute resource, allowing for significant cost savings, simplified cluster management, and holistic data governance including fine-grained access control. This is achieved by Unity Catalog's user workload isolation which runs any SQL, Python and Scala user code in full isolation with no access to lower-level resources.
- **Clusters in _single-user_ access mode** are recommended for workloads requiring privileged machine access or using RDD APIs, distributed ML, GPUs, Databricks Container Service or R.
 
 *- Capacity Scheduler :*  
 - Define queues with each queue being allocated a fraction of the cluster resources. A queue can be divided further into sub-queues in a hierarchicaly. 
 - Capacity scheduler is designed to support an organizational cluster to be shared amongst different departments and groups within each department.
 - with each queue the jobs are executed in a FIFO manner.It's possible for a queue to eat into another queue's capacity if the other queue isn't utilizing its resources.  This is known as **queue elasticity**. The borrowed capacity from a queue is only returned when containers for a job from the other queue complete. Containers aren’t abruptly killed when the lending queue requires its capacity back. However, the maximum cluster capacity that a single queue can consume can be bounded by configuration. This prevents a single queue from overtaking the entire cluster resources. A job can be destined for a queue using the property `mapreduce.job.queuename`. If skipped, the job is sent to the **default** queue.
  ![[Pasted image 20231201111754.png]]

*- Fair Scheduler:* allocate resources fairly among all the running applications.  
-  Consider two queues **A** and **B**. A job added to queue **A** is allowed to use the entire cluster. Next, another job gets added to queue **A**. The cluster resources at this point are divided evenly between the two jobs of queue **A**. If a new job gets added to queue **B**, the fair scheduler will reassign 25% of the cluster resources to each job of queue **A** and 50% of the resources to the sole job in queue **B**. This scenario is shown in the following two tables. Essentially, the resources are fairly divided among queues and then recursively among jobs of a queue.
- Before Job in Queue B is added 
![[Pasted image 20231201112457.png]]


![[Pasted image 20231201112506.png]]
- This is a pictorial representation of cluster utilization vs time under the Fair Scheduler:


![[Pasted image 20231201112559.png]]



- The fair scheduler is more complicated than described. Queues can also be assigned weights and each queue can have nested child queues. In our example, if the two queues **A** and **B** are allocated weights 3 and 8 respectively, then the allocation is fair if the cluster resources are split in the ratio of 3:8 between the queues **A** and **B** respectively. Queues can have individual scheduling policies. The default is fair but can be changed to FIFO or DRF (Dominant Resource Fairness).

- Fair scheduling also allows for specific rules to be specified when placing jobs in queues. The rules are tried one by one until a match occurs or the job is placed in a catch-all default queue. Unlike capacity scheduler, the fair scheduler allows for preemption by setting the property `yarn.scheduler.fair.preemption` to true. If a job lands in an empty queue on a busy cluster, the scheduler can kill containers for queues currently consuming more than their fair share, in order for the new job to execute. Preemption happens at the expense of lowered cluster efficiency as the killed containers are re-executed.
