#### Setup Docker

1. Pull ubuntu:22.04 images

```
docker pull ubuntu:22.04
```

#### Build master node image
- Run the container 
```
docker run -it --name -p 9870:9870 -p 8088:8088 namenode ubuntu:22.04
```

#### Add hdoop user

- Create hdoop user

```

sudo adduser hdoop

```

- grant sudo permission  

```

sudo usermod -aG sudo hadoop

```

- Switch user

```

su - hdoop
```
#### Create SSH key in master node
- install the Open SSH server

```
sudo apt install openssh-server openssh-client -y
```

- Generate the SSH key with passpharase = "" 

```
ssh-keygen -t rsa -P '' -f ~/.ssh/id_rsa
```

- Copy id_ras.pub to authorized_keys to make it become the authorized key for master node
```
cat $HOME/.ssh/id_rsa.pub >> $HOME/.ssh/authorized_keys
```

#### Install java 
```
sudo apt install default-jdk default-jre -y
```
#### Install hadoop

- Copy hadoop file from host

```
docker cp hadoop-2.10.2.tar.gz namenode:/home/hdoop
```

- Extract the file

```
tar -xvf hadoop-2.7.3.tar.gz
```

```
sudo mv hadoop-2.7.3 /home/hdoop/hadoop
```


#### Adding Hadoop path and Java path to bash file 

- open .bashrc file
```
sudo nano ~/.bashrc

```

- Adding this

```
export HADOOP_HOME=/home/hdoop/hadoop
export PATH=$PATH:$HADOOP_HOME/bin
export PATH=$PATH:$HADOOP_HOME/sbin
export HADOOP_MAPRED_HOME=${HADOOP_HOME}
export HADOOP_COMMON_HOME=${HADOOP_HOME}
export HADOOP_HDFS_HOME=${HADOOP_HOME}
export YARN_HOME=${HADOOP_HOME}

```

- Export Java path in file `$HADOOP_HOME/etc/hadoop/hadoop_env.sh`
```
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

```
### Configure ip address in master and data node

#### Check ip address in master and data-node1 and data-node2

```
ifconfig
```

- Config host name and ip address
```
172.17.0.2      master
172.17.0.3      data-node1
172.17.0.4      data-node2


```

#### Configure masters folder in name node

```
hdoop@b7d7cd939b0d:~/hadoop/etc/hadoop$ cat masters
master

```

#### Configure slaves folder in name node
```
data-node1
data-node2

```

#### Configure core-site.xml file in name node


```

<configuration>
<property>
  <name>hadoop.tmp.dir</name>
  <value>/home/hdoop/tmpdata</value>
</property>

    <property>
        <name>fs.defaultFS</name>
        <value>hdfs://master:9000</value>
    </property>
</configuration>

```


#### Configure hdfs-site.xml in name node

```
<configuration>

<property>
  <name>dfs.data.dir</name>
  <value>/home/hdoop/dfsdata/namenode</value>
</property>

 <property>
  <name>dfs.data.dir</name>
  <value>/home/hdoop/dfsdata/datanode</value>
</property>

<property>
  <name>dfs.namenode.http-address</name>
  <value>master:9870</value>
</property>

<property>
  <name>dfs.replication</name>
  <value>1</value>
</property>

 <property>
          <name>dfs.permissions.enabled</name>
          <value>true</value>
</property>

</configuration>

```

#### Configure yarn-site.xml file

```
<configuration>

<!-- Site specific YARN configuration properties -->
    <property>
         <name>yarn.nodemanager.aux-services</name>
         <value>mapreduce_shuffle</value>
     </property>
     <property>
         <name>yarn.nodemanager.auxservices.mapreduce.shuffle.class</name>
         <value>org.apache.hadoop.mapred.ShuffleHandler</value>
     </property>
</configuration>

```

- Configure map-site.xml file

```

<configuration>
    <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
    </property>
</configuration>

```

#### Testing data node

```
hadoop-daemons.sh start namenode
```

#### Commit container to create image

```
docker commit namenode namenode:v1
```


#### Create data-node1 and data-node2 from namenode:v1 image

```
docker run -it --name data-node1 namenode:v1

```

```
docker run -it --name data-node2 namenode:v1

```
#### Copy authorized keys to data-node1 and data-node2

```
ssh-copy-id -i $HOME/.ssh/id_rsa.pub hdoop@data-node1
ssh-copy-id -i $HOME/.ssh/id_rsa.pub hdoop@data-node2
```

#### Remove the dfsdata folder where save the name node and data node in namenode , data-node1 and data-node2

 ![](Pasted%20image%2020240104223851.png)


```
rm -rf dfsdata

```

#### Format namenode

```
hadoop namenode -format
```

#### Start hdfs and yarn in name-node

- Start ssh service

```
sudo service ssh start
```


- Start the Name Node and Data Node:

```agsl
 start-dfs.sh
```
- Once the name node, data nodes, and secondary name node are up and running, start the YARN resource and nodem anagers by typing:

```agsl
start-yarn.sh
```


#### Using jps command to check if all start


```agsl
jps
```


##### In name node

![](Pasted%20image%2020240104230239.png)

### In data node 1 

![](Pasted%20image%2020240104230313.png)
![](Pasted%20image%2020240104230332.png)

##### In data node 2

![](Pasted%20image%2020240104230351.png)
### Project Word-Count with one node
![img_6.png](img_6.png)
#### The interface of Name Node

http://localhost:9870/dfshealth.html#tab-datanode

![](Pasted%20image%2020240104231224.png)


#### The interface of ResourceManager

![](Pasted%20image%2020240105105854.png)

- First we built the jar file 
```agsl
mvn clean package
```


![img_4.png](img_4.png)

- We push the input.txt file to the HDFS
  - hdfs dfs: invoke the Hadoop file system shell command
  - -copyFromLocal input.txt / : Thhis command copy the file to the root directory ('/') of the HDFS.
```agsl
hdfs dfs -copyFromLocal input.txt /
```

- Check if we push file success 
```agsl
hdfs dfs -ls /
```
![img_5.png](img_5.png)



- execute the jar file with the input and output
  - org.example.WordCount: the directory to the WordCount main file 
```agsl
hadoop jar target/word-count-1.0-SNAPSHOT.jar org.example.WordCount hdfs://localhost:9000/input.txt hdfs://localhost:9000/output.txt

```

```
hadoop jar target/word-count-1.0-SNAPSHOT.jar org.example.WordCount hdfs://master:9000/input.txt hdfs://master:9000/output.txt 
```

![](Pasted%20image%2020240105105725.png)

- Using this to check the output
```agsl
hdfs dfs -cat /output.txt/part-r-00000

```

![](Pasted%20image%2020240105105736.png)



#### Setup Spark for Word count project

##### Download Spark 

```
wget https://dlcdn.apache.org/spark/spark-3.5.0/spark-3.5.0-bin-hadoop3.tgz

```

- Extract Spark folder 
```
wget https://dlcdn.apache.org/spark/spark-3.5.0/spark-3.5.0-bin-hadoop3.tgz

```

- Untar the download file
```bash
tar -xzf spark-3.5.0-bin-hadoop3.tgz
mv spark-3.5.0-bin-hadoop3 spark
```

- Add Spark environment variables


```bash
# Add below lines at the end of the .bashrc file.
export SPARK_HOME=/home/sparkuser/spark
export PATH=$PATH:$SPARK_HOME/bin
```

- Source the bashrc file

```
source ~/.bashrc
```

##### Test if Spark work 

```
spark-submit --class org.apache.spark.examples.SparkPi spark/examples/jars/spark-examples_2.1

```

- Result
![](Pasted%20image%2020240105111240.png)


#### Word-count project with spark on yarn

##### Run spark on yarn

```
spark-shell --master=yarn
```


- Create spark folder in hadoop
```
hdfs dfs -mkdir /spark
```


- Put the test.txt file to spark folder

```
 hdfs dfs -put /home/codegyani/sparkdata.txt /spark
```


- Create a RDD in Spaek


```
val data2=sc.textFile("hdfs://master:9000/spark/input.txt");

```
- Check the RDD 
![](Pasted%20image%2020240105171303.png)

- Map and Reducer the data

```
 val splitdata = data.flatMap(line => line.split(" "));
```

```
val mapdata = splitdata.map(word => (word,1));
```

```
 val reducedata = mapdata.reduceByKey(_+_);
```

```
reducedata.collect;
```

 Result
 
![](Pasted%20image%2020240105171925.png)



