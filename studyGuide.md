Hadoop by default uses the local drive. Map reduce. HDFS didn't even get used, it uses local drive. 

```
<configuration>
    <property><name>hadoop.proxyuser.hue.hosts</name><value>*</value></property>
    <property><name>fs.defaultFS</name><value>hdfs://namenode:9000</value></property>
    <property><name>hadoop.http.staticuser.user</name><value>root</value></property>
    <property><name>io.compression.codecs</name><value>org.apache.hadoop.io.compress.SnappyCodec</value></property>
    <property><name>hadoop.proxyuser.hue.groups</name><value>*</value></property>
</configuration>
```



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