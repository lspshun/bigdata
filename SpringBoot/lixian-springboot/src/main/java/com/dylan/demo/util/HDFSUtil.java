package com.dylan.demo.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component("hdfsUtil")
public class HDFSUtil {

    @Resource
    private PropertiesUtil propertiesUtil;
    // 初始化配置对象
    private static Configuration conf = new Configuration();
    // 声明操作文件系统的类
    private FileSystem fs;

    /**
     * 初始化工具类，指定需要操作的集群
     *
     */
    public void init() {
        propertiesUtil.setFileName("cluster.properties");
        // 伪装用户 - 防止HDFS文件系统出现权限问题
        System.setProperty("HADOOP_USER_NAME",propertiesUtil.readPropertyByKey(Property.HADOOP_USER.toString()));
        // 声明需要访问的集群地址
        String URI = propertiesUtil.readPropertyByKey(Property.HDFS_URI.toString());
        try {
            // 将URI信息记录到配置项中
            FileSystem.setDefaultUri(conf, URI);
            // 使用读取到的配置实例化fs
            fs = FileSystem.get(conf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回当前用户的家目录
     *
     * @return
     */
    public String getHomeDir() {
        // 当前用户的家目录
        return fs.getHomeDirectory().toString();
    }

    /**
     * 创建文件夹
     *
     * @param path       完整路径，不需要添加斜杠
     * @param useHomeDir 是否在用户家目录中创建
     */
    public void mkdirs(String path, boolean useHomeDir) {
        // 同时创建多级目录
        try {
            if (useHomeDir) {
                fs.mkdirs(new Path(path));
            } else {
                fs.mkdirs(new Path("/" + path));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     *
     * @param delSrc    是否删除源文件
     * @param overwrite 是否覆盖目标文件
     * @param srcs      源文件路径，可以指定多个路径
     * @param dest      目标路径
     */
    public Boolean upLoad(boolean delSrc, boolean overwrite, String[] srcs, String dest) {
        try {
            // 从本地上传文件，两个参数，源路径(本地磁盘)，目标路径(HDFS)，默认不删除源文件，默认覆盖
            // fs.copyFromLocalFile(new Path("E://test.txt"), new Path("/"));
            // 三个参数，是否删除源文件，源路径，目标路径
            // fs.copyFromLocalFile(false, src, dst);
            // 四个参数，是否删除源文件，是否覆盖目标文件，源路径，目标路径，声明不覆盖时抛出异常(不会发生覆盖)
            // fs.copyFromLocalFile(false, false, new Path("E://test.txt"), new Path("/"));
            // 上传单个文件时，直接上传
            if (srcs.length == 1) {
                fs.copyFromLocalFile(delSrc, overwrite, new Path(srcs[0]), new Path(dest));
            } else {
                // 上传多个文件时，生成所需的Path数组
                Path[] paths = new Path[srcs.length];
                for (int i = 0; i < srcs.length; i++) {
                    paths[i] = new Path(srcs[i]);
                }
                fs.copyFromLocalFile(delSrc, overwrite, paths, new Path(dest));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 文件下载
     *
     * @param delSrc 是否删除源文件
     * @param src    源文件路径
     * @param dest   目标路径
     */
    public void downLoad(boolean delSrc, String src, String dest) {
        try {
            // 从HDFS下载文件，两个参数，源路径(HDFS)，目标路径(本地磁盘)，默认不删除源文件
            // fs.copyToLocalFile(new Path("/boss.txt"), new Path("D://"));
            // 三个参数，是否删除源文件，源路径，目标路径，默认覆盖目标文件
            // fs.copyToLocalFile(false, src, dst);
            // 四个参数，是否删除源文件，源路径，目标路径，是否使用原生的系统文件系统
            fs.copyToLocalFile(delSrc, new Path(src), new Path(dest), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断每个用户的目录是否存在
     * @param path
     * @return
     */
    public boolean isExists(String path) {
        boolean result = false;
        try {
            result = fs.exists(new Path(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除某一路径
     *
     * @param path      需要删除的路径
     * @param recursive 指定为true删除目录中全部文件，false时可以删除空目录和单个文件
     * @return
     */
    public boolean delete(String path, boolean recursive) {
        boolean result = false;
        if (recursive) {
            try {
                // 是否递归删除
                result = fs.delete(new Path(path), true);
            } catch (Exception e) {
                e.printStackTrace();
                result = false;
            }
            return result;
        } else {
            try {
                // 是否递归删除
                result = fs.delete(new Path(path), false);
            } catch (Exception e) {
                e.printStackTrace();
                result = false;
            }
            return result;
        }
    }

    /**
     * 获得某一路径下的文件信息
     *
     * @param path 待查看路径
     * @return 文件信息列表-包含文件类型，文件大小，所有者，所在组，文件名称
     */
    public List<String> getFileInfo(String path) {
        List<String> infos = new ArrayList<>();
        try {
            // 通过FileSystem获得某一路径下的文件状态列表
            FileStatus[] fileStatus = fs.listStatus(new Path(path));
            for (FileStatus temp : fileStatus) {
                String info = "";
                // 判断文件类型
                if (temp.isDirectory()) {
                    info += "目录\t" + "0" + "\t";
                } else {
                    info += "文件\t" + sizeFormat(temp.getLen()) + "\t";
                }
                // 拼接文件信息
                info += temp.getOwner() + "\t" + temp.getGroup() + "\t" + temp.getPath().getName();
                infos.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return infos;
    }

    /**
     * 文件大小单位换算
     *
     * @param length 默认获得的文件大小单位为Byte-字节
     * @return 使用1024进行换算
     */
    private String sizeFormat(long length) {
        long result = length;
        // 不足1024则单位为Byte
        if (result / 1024 == 0) {
            return result + "B";
        } else {
            result /= 1024;
            // 不足1024*1024则单位为KB，否则为MB
            if (result / 1024 == 0) {
                return result + "KB";
            } else {
                return result / 1024 + "MB";
            }
        }
    }

    /**
     * 从指定文件中读取数据
     *
     * @param path HDFS路径
     * @return 字符串按行拼接得到的文件内容
     */
    public String read(String path) {
        StringBuffer result = new StringBuffer();
        try {
            // 使用open方法获得一个输入流
            FSDataInputStream fsDataInputStream = fs.open(new Path(path));
            // 使用缓冲流读取文件内容
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsDataInputStream, "UTF-8"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line + "\n");
            }
            bufferedReader.close();
            fsDataInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
