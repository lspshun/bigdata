package day05.java;

public class FinallyTest {

    private String name;

    public static void main(String[] args) {
        // TODO finally使用注意事项
        System.out.println(method());
        System.out.println(test().name);
    }

    public static int method(){
        // 返回基本数据类型及字符串时，在finally中的修改不会被记录，除非出现return语句
        String s = "1";
        int result = 1;
        try{
            return result;
        }catch (Exception e){
            result = 2;
            return result;
        }finally {
            s = "3";
            result = 3;
        }
    }

    public static FinallyTest test(){
        // 返回引用类型时，修改会被记录
        FinallyTest f = new FinallyTest();
        f.name = "123";
        try {
            return f;
        }catch (Exception e){
            f.name = "456";
            return f;
        }finally {
            f.name = "789";
        }
    }

}
