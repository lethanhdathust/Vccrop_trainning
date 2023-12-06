**1.Definition**

- Map reduces is a programming pattern that enables massive scalability in a Hadoop cluster
- MapReduce is a framework used in parallel computing 
- Map Reduce is a processing technique and a program model for distributed computing.
- Distributed computing is a system with multiple components located on different machines that communicate actions in one view to the end user. Each component has it own job, but the components communicate with each other to run as one system to the end user.
- Consist of two tasks, Map and Reduce 
- Can be coded in many languages : Java, Python,...
#### Characteristics

MapReduce programming model has the following characteristics:

- **Distributed**: The MapReduce is a distributed framework consisting of clusters of commodity hardware which run **map** or **reduce** tasks.

- **Parallel**: The map and reduce tasks always work in parallel.
   
- **Fault tolerant**: If any task fails, it is rescheduled on a different node.
   
- **Scalable**: It can scale arbitrarily. As the problem becomes bigger, more machines can be added to solve the problem in a reasonable amount of time; the framework can scale horizontally rather than vertically.
#### 2. Map and Reduce

- Map takes an input file 
- Map: Processes data into key value pairs
- Further data sorting and organizing 
- Reducer: Aggregates and computes a set of result and produces a final output
- Map Reduce keeps track of it task by creating a unique key => ensure all processes are solving the problem

![[Pasted image 20231120164414.png]]


- we have the map step, which takes a set of data and convert it into another set of data,individual elements are broken down into key/value pair.

- The key is the name, value is the content

- The input data is saved in the Hadoop file system (HDFS).
1. Look at the Ex, assume we have an input file contains name of people , i would like to count the unique name occurrences.
2. First, The data is split into four files, each of them in key value pair and worked on separately. Ex, Teju and Briana , we have two key value pair. 
3. Then we have the reducer, the reducer process the data that comes from the map. After processing, it produces a new set of products , which will be stored in HDFS. 
4. The Reducer starts with shuffing(Trộn) , Shuffing sorts the key and a list of values in a list=> Key Teju and the corresponding list of values from the previous step.
5. The name Teju occurred 3 times in the "Map" step => we have Teju [ 1, 1, 1 ] 
6. The Reducer layer than aggregates the values and save them in an output file.


#### 3. Advantage of MapReduce

- Parallel computing
- A node is an independent computer used for processing and storing big volumes of data.
- Two type of node, name node and data node.
- MapReduce allows for splitting and running independent tasks parallel
- Can process data that come in tabular and non-tabular forms
- Supports multiple languages 
- Providing platforms for analysis, data warehousing,...


#### 4. Use case

![[Pasted image 20231120173757.png]]
