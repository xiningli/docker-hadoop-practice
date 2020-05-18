package hadoop.practice.hdfsclient;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSClient {

    public void put() throws IOException {
        // 获取hdfs的抽象封装对象
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), configuration);
        // 用这个对象操作文件系统
        fileSystem.copyFromLocalFile(new Path("runproject.md"), new Path("/input3"));
        // 关闭文件对象
        fileSystem.close();
    }

    public void get() throws IOException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), configuration);
        fileSystem.copyToLocalFile(new Path("/input2"), new Path("tmpFile"));
        fileSystem.close();
    }

    public void delete() throws IOException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), configuration);
        boolean deleted = fileSystem.delete(new Path("/runproject.md"), true);
        fileSystem.close();
        System.out.println(deleted);
    }
    public static void main(String[] args) throws IOException {
        HDFSClient hdfsClient = new HDFSClient();
        hdfsClient.delete();
    }
}