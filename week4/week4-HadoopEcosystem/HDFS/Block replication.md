- [Block replication](#introduction)
- [Selection of nodes for replication](#)
#### Block Replication <a name="introduction"></a>
- *Fault tolerance :* as the property that enables a system to continue operating properly in the event of the failure of some of its components. Said another way, fault tolerant computing is a form of full hardware redundancy (sao luu phan cung day du). 
- Two systems operate in pareall ,
   copy identical applications and executing instructions in lock step.When a hardware failure occurs in the primary system, the secondary system running an identical application simultaneously takes over with no loss of service and zero downtime.
- Hai (hoặc nhiều hơn) hệ thống hoạt động song song, sao chép các ứng dụng giống nhau và thực hiện các lệnh theo bước khóa. Khi một sự cố phần cứng xảy ra trên hệ thống chính, hệ thống phụ chạy một ứng dụng giống nhau đồng thời tiếp quản mà không có mất dịch vụ và không gián đoạn (zero downtime).

- The secret behind HDFS's ability to withstand corrupted(Chịu hư hỏng) or lost data is the replication of data blocks.If a file comprise of 4 HDFS blocks and the replication factor is 3, than each data block would have 3 copies of it self.These copies spread out in the cluster oon physically separate machines, total of 12 blocks
- Replication ensures that if one data block becomes corrupted or hardware failure occurs, than the read request can still be fullfilled by another avaiable clone of the block. 
	- This setup allows for self-healing. A lost block due to corruption or machine failure can be replicated to other live machines by making a copy of the healthy clone. The replication is controlled by the property *dfs.replication* . Some applications use a higher replication factor for the data blocks of a popular file to better distribute the read load across the cluster. 

####  Selection of nodes for replication 

- When it comes to placement of placement of replicated data blocks in a cluster, there are  many possibilities . On one end of the spectrum, all three data blocks can be placed on one node.Or all three can be placed in separate data-centers. 
- In the former case,the write bandwidth is minimized because the replicas are written to the same node. No redundancy because if the single node goes down, all replicas are lost.
- In the latter case, redundancy is maximized at the cost of band width.
(  
Khi đề cập đến việc đặt các khối dữ liệu sao chép trong một cụm, có một loạt các khả năng. Ở một đầu của phổ, tất cả ba khối dữ liệu có thể được đặt trên một nút. Hoặc tất cả ba có thể được đặt trong các trung tâm dữ liệu khác nhau. Trong trường hợp trước, băng thông ghi được tối thiểu hóa vì các bản sao được ghi vào cùng một nút. Không có tính dự phòng được thực hiện vì nếu nút duy nhất gặp sự cố, tất cả các bản sao đều bị mất. Trong trường hợp sau, tính dự phòng được tối đa hóa nhưng đồng thời đi kèm với chi phí băng thông.)


- Hadoop places the first replica on the same node as the client. If the client is running outside the cluster, a node is chosen at random
- The second replica is places on a randomly chosen rack different than the first replica.
- The third replica is placed on a randomly chosen node on the same rack as the second replica
- Any further replicas are placed on randomly selected nodes without too many replicas in the same rack

- Ex: image shows how a block gets replicated on a two rack cluster eight machines :
![[Pasted image 20231204080716.png]]

- In a datacenter a rack refers to the physical steel and electronic framework designed to house servers, networking devices, cables and other computing equipment. The hardware configuration is such that data can travel faster between servers in the same rack than between servers on different racks.