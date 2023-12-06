

The fundamental abstraction in Spark is the RDD, short for Resilient Distributed Dataset. It is a read-only (immutable) collection of objects or records, partitioned across the cluster that can be operated on in parallel. A partition can be reconstructed if the hosting node experiences failure. RDDs are a lower-level API; the other two Spark data abstractions namely DataFrames and Datasets compile to an RDD. The constituent records or objects within an RDD are Java, Python, or Scala objects. Anything can be stored in any format in these objects.

RDDs are a low-level API and the Spark authors discourage working directly with them unless the intent is to exercise fine grain control. Using RDDs, you have to trade-off the optimizations and pre-built functionality that comes with structured APIs such as DataFrames and Datasets. For instance, data is compressed and stored in an optimized binary format in case of structured APIs. That must be manually achieved when working with RDDs.

RDD stands for Resilient Distributed Datasets. Let’s examine each property in turn:

**Resilient:** means an RDD is fault-tolerant and able to recompute missing or damaged partitions due to node failures. This self-healing is made possible using an RDD lineage graph that we’ll cover later. An RDD _remembers_ how it reached its current state and can trace back the steps to recompute any lost partitions.

**Distributed:** means data making up an RDD is spread across a cluster of machines.

**Datasets:** refer to representations of the data records we work with. External Data can be loaded using a variety of sources such as JSON file, CSV file, text file or database via JDBC.

Spark RDDs can be cached and manually partitioned. Caching is useful as it allows repeated use of RDDs. Manual partitioning helps correctly balance partitions. Next, we’ll jump into code and see a few examples of creating RDDs.