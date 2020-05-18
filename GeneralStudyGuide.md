# What is name node? 

HDFS集群有两类节点以管理节点-工作节点模式运行，即一个namenode（管理节点）和多个datanode（工作节点）。namenode管理文件系统的命名空间。他维护着文件系统树及整棵树内所有的文件和目录。这些信息以两个文件形式永久保存在本地磁盘上：命名空间镜像文件和编辑日志文件。namenode也记录着每个文件中各个块所在的数据节点信息，但他并不永久保存快的位置信息，因为这些信息会在系统启动时根据数据节点信息重建。

# named volume in docker
A named volume is similar to an anonymous volume. Docker manages where on disk the volume is created, but you give it a volume name. To create a named volume:

