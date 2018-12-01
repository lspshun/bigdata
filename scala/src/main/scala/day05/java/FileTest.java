package day05.java;

import java.io.File;
import java.io.FileInputStream;

public class FileTest {

    public static void main(String[] args) {
        // TODO Java字节流读取文件
        try {
            FileInputStream inputStream = new FileInputStream(new File("E://data.txt"));
            // 定义数组，类似缓冲区
            byte[] b = new byte[10];
            // 将读取到的内容存放到数组中，方法本身的返回值本次读取存放到数组中数据的长度，-1时代表达到末尾
            while (inputStream.read(b) != -1){
                for (byte content:b){
                    System.out.println((char) content);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
