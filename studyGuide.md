# What is name node? 

HDFS集群有两类节点以管理节点-工作节点模式运行，即一个namenode（管理节点）和多个datanode（工作节点）。namenode管理文件系统的命名空间。他维护着文件系统树及整棵树内所有的文件和目录。这些信息以两个文件形式永久保存在本地磁盘上：命名空间镜像文件和编辑日志文件。namenode也记录着每个文件中各个块所在的数据节点信息，但他并不永久保存快的位置信息，因为这些信息会在系统启动时根据数据节点信息重建。


# Word count on HDFS

``` bash
hdfs dfs -mkdir -p /input/
```

``` bash
hdfs dfs -copyFromLocal -f /opt/hadoop-3.2.1/README.txt /input/
```

To check if the README.txt is there

``` bash
hdfs dfs -cat /input/README.txt
```

We will compile the job locally and push to the hadoop cluster

```bash
cd example_programs/word_count
./gradlew clean build
docker cp ./build/libs/hadoop-practice.jar 99577e2bbc03:/tmp
```


Now go inside of the docker
``` bash
hadoop jar hadoop-practice.jar hadoop.practice.wordcount.WordCount hdfs:/input/README.txt hdfs:/output

hdfs dfs -cat /output/*
```