A Dataframe is the most common Structured API. It represents a table with rows and columns. Each column has a defined type maintained in a schema. You can think of the DataFrame as a spreadsheet that is too big to fit on a single machine so it has parts of it spread across a cluster of machines. Even if the spreadsheet can fit onto a single machine, the desired computations take too long so the data has to be chunked and processed on multiple machines in parallel.

A DataFrame is broken into smaller parts called _partitions_. A partition is a collection of rows from the parent DataFrame that reside on a particular physical machine on the cluster. A DataFrame’s partitions represent the data’s physical distribution across the cluster of machines. The number of partitions also dictate the parallelism achieved in a Spark job. With a single partition, only a single executor can process the data, even if several hundred are available. Similarly, if there are many partitions with single executor available ,there would be no parallelism.

When working with DataFrames, partitions are never manually or individually manipulated. Instead, the user specifies higher-level data transformations that the Spark framework then applies to all partitions across the cluster.

## Schema[](app://obsidian.md/index.html#Schema)

A schema defines the column names and types of a DataFrame. A schema can be manually defined or read-in from the source. Spark allows **schema inference**. Spark reads in a few rows and then parses the types in those rows to map them to _Spark types_. We can also examine the inferred schema for a DataFrame object using the `schema` method.

## Spark types[](app://obsidian.md/index.html#Spark-types)

Spark uses an engine called **Catalyst** that maintains type information. The Spark types map to corresponding types in supported languages (Java, Python etc). Spark will convert an expression written in one of the supported languages into an equivalent Catalyst representation for the same type. The Catalyst engine applies several optimizations and is continually improved to make executions faster.