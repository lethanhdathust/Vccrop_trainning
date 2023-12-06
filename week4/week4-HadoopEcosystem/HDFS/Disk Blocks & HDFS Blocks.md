### Overview
- Disk block is the smallest unit of data that can be read from or written to a disk.
- Disk blocks are 512 bytes in size. The filesystem sitting on top of the physical disk works with an abstraction called the filesystem block.
- HDFS is not a physical filesystem, but rather a virtual abstraction over distributed disk-based file systems.

#### HDFS block

- A file in HDFS is logically divided up into HDFS blocks. Each HDFS block is physically made of filesystem blocks of the underlying filesystem, which is an integral multiple of the disk block size.
- The benefit of block abstraction for a distributed file system like HDFS is that a file can be larger than any single disk in the cluster.Ex: HDFS has a default block size of 128 MB. However, if we store a 10 MB file,it will take up only 10 MB of disk space , not 128 MB. The HDFS block of 128 MB doesn't translate to a unit of storage.Instead, it is an abstraction to store the metadata in Namenode. It is the smallest unit the Namenode can references in its memory. 
- The underlying physical file system isn't divided into HDFS block-sized chunks.
- Ex: If we have three files of 10 KB each, then the space consumed on disk would be 3 x 10 KB = 30 KB whereas the Namenode would hold 3 HDFS blocks, one per file in memory

![[Pasted image 20231201153255.png]]

- The HDFS blocks of  single file may spread across different machines in the cluster. In an extreme case, a single file can take all available disk space on the cluster with all HDFS blocks in the cluster, belonging to one file. Note that data blocks in the cluster belonging to one file.
-  Note that data blocks are chunks of data and that do not store metadata information like permissions, last access time, or author. That is handled by the Namenode. Each HDFS block is stored as a file on a data node and replicated across the cluster equal to the number specified by the property `dfs.replication`.
![[Pasted image 20231201170902.png]]


#### Large block size

- HDFS has an unusually large default block size.

1. *Relieve memory pressure on Namenode:* The Namenode must remember all HDFS blocks for a file and retain this information in memory. Each file, directory, and block is represented as an object in the Namenode 's memory. It's easy to see how limiting the number of blocks per file can help relieve pressure on the NN 's memory . For a lower block size , like 1 KB, a 10 KB file will yield(tao ra) 10 HDFS blocks that Namenode needs to store in memory.But the same file would comprise (tạo thành) a single HDFS block if the block size was set to 10 KB.
	
	Another optimization to reduce memory footprint: combining several smaller files into a single file,similar to how a tar file is produced. Sequence and Hadoop Archive (HAR) files can bundle( gộp). Consider 3 files of size 10 KB each. If the HDFS block size is 128 MB then the Namenode will store 1 block per file.The three files can combined into a HAR file which take up a single HDFS block in memory


*2. Reduce seek time:* 
 Another reason to have a large HDFS block size is to dwarf the time it takes to seek to the start of the block in comparison to the time it takes to transfer the data. If the disk seek time is minuscule in comparison to the transfer rate, then we can ignore the seek time and state that _the data is read at the disk transfer rate_. We can do a back of the hand calculation; say it takes 10ms to seek to the start of the block and the data transfer rate is 100MB/s. The block size needs to be roughly 100MB in size to make the disk seek time 1% of the transfer time. This is why the default filesystem block size in HDFS is 128MB, while many installations use higher block sizes. Remember, HDFS doesn’t support multiple concurrent file writers and usually a single process writes a file to HDFS. This often results in data written sequentially to disk. The filesystem blocks appear contiguously on the physical disk. This becomes an advantage for rotational disks because the disk head can avoid re-positioning when reading or writing sequential data. Other optimization at the hardware level, such as read and write ahead buffers used by disk controller also help. Thus, the net effect is minimizing the number of seeks when reading a HDFS block, which is helpful to jobs that read or write lots of data to HDFS.
    
3. **Improve network throughput:** When running MapReduce, it is possible for data to be moved around from one node to another across the network. The HDFS blocks (which are just files as we’ll learn later) are transferred via one persistent TCP connection per block. For large block sizes, the TCP connection can achieve higher throughput compared to smaller block sizes. When working on a larger sized HDFS block, the likelihood of a client performing operations on the same chunk of data is high. Thus it can maintain a persistent TCP connection with the Datanode and reduce network overhead.
    
    Another, less significant benefit: if a file consists of fewer number of HDFS blocks because of larger HDFS block size, the reader’s number of network requests made to the Namenode to retrieve a file is also fewer than if the block size were larger. The Namdenode holds the mapping of blocks belonging to a file and needs to transmit the location of each block to the reader. Fewer blocks imply fewer network requests, less network traffic and subsequently fewer persistent TCP connections.
    
4. **Improve MapReduce performance:** If the split-size and HDFS block size are equal to the number of mappers spawned in a MapReduce job, to process an input file is equal to the number of HDFS blocks in that file. If the block size is too small, it results in too many mappers with little to work with and additional overhead management. On the flip side, the block size shouldn’t be too large, resulting in too few map tasks and increased job execution time.