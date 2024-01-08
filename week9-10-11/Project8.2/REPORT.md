#### 0. Configure Spark 

##### Edit the .bashrc file
```
# Setup SPARK Environment variables
export SPARK_HOME=/home/hdoop/spark
export PATH=$PATH:$SPARK_HOME/bin
export PATH=$SPARK_HOME/sbin:$PATH
export CLASSPATH=$SPARK_HOME/jars/*:$CLASSPATH
export LD_LIBRARY_PATH=$HADOOP_HOME/lib/native:$LD_LIBRARY_PATH
#Controll Spark
alias Start_SPARK='$SPARK_HOME/sbin/start-all.sh;$SPARK_HOME/sbin/start-history-server.sh'
alias Stop_SPARK='$SPARK_HOME/sbin/stop-all.sh;$SPARK_HOME/sbin/stop-history-server.sh'
# Setup PYSPARK Environment variables
export PYTHONPATH=$SPARK_HOME/python/:$SPARK_HOME/python/lib/py4j-0.10.9.7-src.zip:$SPARK_HOME/python/lib/pyspark.zip:$PYTHONPATH


export HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop
#export PYSPARK_DRIVER_PYTHON=jupyter
#export PYSPARK_DRIVER_PYTHON_OPTS='notebook--ip 0.0.0.0'

```

```
Source ~/.bashrc
```

##### Edit the spark-env.sh file in master 
```
#PYSPARK Environment variables
SPARK_CONF_DIR=/home/hdoop/spark/conf
SPARK_LOG_DIR=/home/hdoop/spark/logs

#IP for Local node
SPARK_LOCAL_IP=master #or 192.168.1.72
HADOOP_CONF_DIR=/home/hdoop/hadoop/etc/hadoop
YARN_CONF_DIR=/home/hdoop/hadoop/etc/hadoop
SPARK_EXECUTOR_CORES=1
SPARK_EXECUTOR_MEMORY=512m
SPARK_DRIVER_MEMORY=512m

SPARK_MASTER_HOST=master #or 192.168.1.72
SPARK_MASTER_PORT=6066
SPARK_MASTER_WEBUI_PORT=6064

SPARK_WORKER_PORT=7077
SPARK_WORKER_WEBUI_PORT=7074

```

##### Edit the spark-env.sh file in data-node1 and data-node2 
```
#PYSPARK Environment variables
SPARK_CONF_DIR=/home/hdoop/spark/conf
SPARK_LOG_DIR=/home/hdoop/spark/logs

#IP for Local node
SPARK_LOCAL_IP=data-node1 #or 192.168.1.72
HADOOP_CONF_DIR=/home/hdoop/hadoop/etc/hadoop
YARN_CONF_DIR=/home/hdoop/hadoop/etc/hadoop
SPARK_EXECUTOR_CORES=1
SPARK_EXECUTOR_MEMORY=512m
SPARK_DRIVER_MEMORY=512m

SPARK_MASTER_HOST=master #or 192.168.1.72
SPARK_MASTER_PORT=6066
SPARK_MASTER_WEBUI_PORT=6064

SPARK_WORKER_PORT=7077
SPARK_WORKER_WEBUI_PORT=7074



```

```
#PYSPARK Environment variables
SPARK_CONF_DIR=/home/hdoop/spark/conf
SPARK_LOG_DIR=/home/hdoop/spark/logs

#IP for Local node
SPARK_LOCAL_IP=data-node2 #or 192.168.1.72
HADOOP_CONF_DIR=/home/hdoop/hadoop/etc/hadoop
YARN_CONF_DIR=/home/hdoop/hadoop/etc/hadoop
SPARK_EXECUTOR_CORES=1
SPARK_EXECUTOR_MEMORY=512m
SPARK_DRIVER_MEMORY=512m

SPARK_MASTER_HOST=master #or 192.168.1.72
SPARK_MASTER_PORT=6066
SPARK_MASTER_WEBUI_PORT=6064

SPARK_WORKER_PORT=7077
SPARK_WORKER_WEBUI_PORT=7074



```


##### Add slaves file to Master node
```
master    
data-node1
data-node2

```

##### Configure spark-defaults.conf in all ndoes

```
spark.eventLog.enabled 			true
spark.eventLog.dir			hdfs://master-namenode:9000/spark-history
spark.yarn.historyServer.address	master-namenode:19888/
spark.yarn.am.memory			512m
spark.executor.memoryOverhead		1g
spark.history.provider			org.apache.spark.deploy.history.FsHistoryProvider
spark.history.ui.port			18080
spark.history.fs.logDirectory		hdfs://master-namenode:9000/spark-history
spark.driver.cores			1
spark.driver.memory			512m
spark.executor.instances		1
spark.executor.memory			512m
spark.yarn.jars				hdfs://master-namenode:9000/user/spark-2.4.5/jars/*
spark.serializer                	org.apache.spark.serializer.KryoSerializer
spark.network.timeout			800
```


##### Add this to file yarn-site.sh in all nodes

```
<property>
	<name>yarn.nodemanager.pmem-check-enabled</name>
	<value>false</value>
</property>

<property>
	<name>yarn.nodemanager.vmem-check-enabled</name>
	<value>false</value>
</property>
```


##### Start Spark and hadoop

![](images/Pasted%20image%2020240108160525%201.png)
![](images/Pasted%20image%2020240108160538%201.png)
### 1. Create file parquet with 1.000.000 records
#### Running Jupyter

```
jupyter notebook --ip 0.0.0.0
```

#### Create file parquet to hdfs 

- Code 
```
from pyspark.sql import SparkSession
from faker import Faker
import random


spark = SparkSession.builder.appName("CreateParquet").getOrCreate()

num_records = 1000000

fake = Faker()

data = []
for _ in range(num_records):
    name = fake.name()
    dob = fake.date_of_birth(minimum_age=18, maximum_age=90)
    address = fake.random_int(min=1, max=100)  # Địa chỉ từ 1 đến 100 (có thể thay đổi)
    gender = random.choice(["Male", "Female"])
    phone = fake.phone_number()
    data.append((name, dob, address, gender, phone))

columns = ["name", "dob", "address", "gender", "phone"]
df = spark.createDataFrame(data, columns)

df.write.mode("overwrite").parquet("hdfs://master:9000/dat/file.parquet")

spark.stop()

```

- Running code in jyputer
![](images/Pasted%20image%2020240107130749%201.png)
- The data is saved in hdfs

![](images/Pasted%20image%2020240107130716%201.png)

### 3. Using pyspark to read file in notebook


- Reading parquet file with PySPARK
```
from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("ReadParquet").getOrCreate()

parquet_file_path = "hdfs://master:9000/dat/file.parquet"  # Replace with your file path
df = spark.read.parquet(parquet_file_path)

df.show(100)

spark.stop()

```

- Result
![](images/Pasted%20image%2020240107131538%201.png)

### 3.1 Using Spark to run in standlone mode 


- Read only part of the file.parquet because when i run with full data of file , my computer always die
```
from pyspark.sql import SparkSession

# Khởi tạo SparkSession trong chế độ standalone
spark = SparkSession.builder \
    .appName("ReadParquetStandalone") \
    .master("spark://master:6066") \
    .getOrCreate()
# Đọc file Parquet vào DataFrame
file_path = "hdfs://master:9000/dat/file.parquet/part-00000-e3e1acec-9c4b-4911-9d3e-201e9ccda9d6-c000.snappy.parquet" 
df = spark.read.parquet(file_path)

df.show(1000)

spark.stop()

```

![](images/Pasted%20image%2020240108103506%201.png)
- Spark Master
![](images/Pasted%20image%2020240108104240%201.png)

- Application
![](images/Pasted%20image%2020240108104259%201.png)

![](images/Pasted%20image%2020240108113550%201.png)
### 3.2 Using Spark to run in yarn mode 


- Read only part of the file.parquet because when i run with full data of file , my computer always die
```
from pyspark.sql import SparkSession


spark = SparkSession.builder \
    .appName("ReadParquetYARN") \
    .master("yarn") \
    .config("spark.yarn.historyServer.address", "http://master:18080") \
    .getOrCreate()


file_path = "hdfs://master:9000/dat/file.parquet/part-00000-e3e1acec-9c4b-4911-9d3e-201e9ccda9d6-c000.snappy.parquet" ay đổi đường dẫn file của bạn


df = spark.read.parquet(file_path)

df.show(1000)

spark.stop()

```

![](images/Pasted%20image%2020240108114753%201.png)

- Spark application run on Yarn 

![](images/Pasted%20image%2020240108114826%201.png)

- Read the Spark history
![](images/Pasted%20image%2020240108114934%201.png)


#### 4. Visualize with Matplotlib
- Run Spark on Yarn

```
spark = SparkSession.builder \
    .appName("ReadParquetYARN") \
    .master("yarn") \
    .config("spark.yarn.historyServer.address", "http://master:18080") \
    .getOrCreate()
```

- Read file 
```
file_path = "hdfs://master:9000/dat/file.parquet/part-00000-e3e1acec-9c4b-4911-9d3e-201e9ccda9d6-c000.snappy.parquet"
df = spark.read.parquet(file_path)
```
- Visualize the data
```
from pyspark.sql.functions import year, current_date
df = df.withColumn("age", year(current_date()) - year("dob"))

# Create age groups (e.g., 10-20, 20-30, ...)
df = df.withColumn("age_group", ((df["age"] / 10) * 10).cast("string"))

# Group by age group and gender, count users
grouped_df = df.groupBy("age_group", "gender").count().orderBy("age_group")

# Convert to Pandas DataFrame for visualization
pandas_df = grouped_df.toPandas()

# Pivot the data for plotting
pivot_df = pandas_df.pivot(index="age_group", columns="gender", values="count")

# Plotting stacked bar chart
plt.figure(figsize=(15, 8))
pivot_df.plot(kind="bar", stacked=True)
plt.xlabel("Age Groups")
plt.ylabel("Number of Users")
plt.title("User Sort by Age Groups and Gender")
plt.xticks(rotation=60)
plt.legend(title="Gender")
plt.tight_layout()
plt.show()

# Stop SparkSession
spark.stop()
```

![](images/Pasted%20image%2020240108142425%201.png)

- Check Yarn
![](images/Pasted%20image%2020240108142454%201.png)

- Check Spark history
![](images/Pasted%20image%2020240108142514%201.png)

#### 5. Run this app in Yarn mode

- Code 
```

package com.example;
import org.apache.spark.sql.*;
import static org.apache.spark.sql.functions.*;

public class App 
{
      public static void main(String[] args) {
        // Create SparkSession
        SparkSession spark = SparkSession.builder()
            .appName("ReadParquetYARN")
            .master("yarn")
            .config("spark.yarn.historyServer.address", "http://master:18080")
            .getOrCreate();

        //  ^p  ^mc file Parquet v  o DataFrame
        String file_path = "hdfs://master:9000/dat/file.parquet/part-00000-e3e1acec-9c4b-4911-9d3e-201e9ccda9d6-c000.snappy.parquet";
        // Update HDFS file path if necessary, ensuring it's accessible in your YARN environment

        Dataset<Row> df = spark.read().parquet(file_path);

        // Hi  ^cn th  ^k n  ^yi dung c   a DataFrame
        df.show(1000);

        // D   ng SparkSession khi b   n  ^q   ho  n th  nh c  ng vi  ^gc
        spark.stop();
    }
}

```

- Build jar file
```
mvn clean package
```
- Run this command
```
spark-submit --deploy-mode cluster --master yarn --class com.example.App target/my-project-1.0-SNAPSHOT.jar 
```

- Logs
![](images/Pasted%20image%2020240108155233%201.png)

- Check YARN 
![](images/Pasted%20image%2020240108155258%201.png)

- Check logs in YARN
![](images/Pasted%20image%2020240108155332%201.png)

- Check Spark history
![](images/Pasted%20image%2020240108155356%201.png)

![](images/Pasted%20image%2020240108155542%201.png)