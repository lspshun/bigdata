package day07.java;

public class ProcessTest {

    public static void main(String[] args) throws Exception {
        // TODO Process调用
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("mkdir test1");
    }
}
