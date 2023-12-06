#### 1.File System
- is a mechanism of storing,organizing and retrieving data on a storage medium.
- The fundamental unit of a fie system is a file . The structure and rules used to manage files and their names comprises a file system.

#### 2. Type of file systems

- Disk File Systems
- Tape File System
- Network File Systems
- Special purpose File Systems

#### 3. Distributed file systems
- It is a file system that is distributed on multiple file servers or multiple locations.It allows program to access or store isolated files as the do with the local ones, allowing programmers to access files from multiples hosts.
- Some DFS: Luster, GFS,..

#### 4. Disk block

- It is the smallest unit  writable by a disk or file system. Everything a FS does is composed of operations executed on disk blocks. However, FS don't write individual disk blocks. They read/write a couple of blocks together-> efficiency .

-  This abstraction over the physical disk blocks is called the filesystem block. A file system block is always the same size as or larger (in integer multiples) than the disk block size.
#### 5. File metadata
- The name of a file is metadata because it is information not in the stream of bytes making up the file.
- Other pieces of metadata about a file like: the owner, security access controls, size, creation time.,...
- generally the file system stores file metadata in an i-node or index-node

##### i-Node
- It is a data structure in the file system -> it stores metadata information , information about data's location on the storage media.
- An i-node refers to the contents of the file by tracking a list of blocks on the disk that belong to this file.