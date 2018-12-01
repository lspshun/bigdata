package hvieProject;

import util.ConvertUtil;
import util.HiveUtil;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ConvertUtil convertUtil = new ConvertUtil();
        // String sql = convertUtil.SAC("test","orders",new String[]{"typeId"},"retail","sum");
        //String[] columns = new String[]{"id","typeId","retail"};
        //String sql = convertUtil.getRandomDataN("test","orders",columns,50);
        String sql = convertUtil.getDataByCondition("test","orders",new String[]{"retail"},new String[]{">"},new String[]{"50"});
        System.out.println(sql);
        /*int[] columnsIndex = new int[columns.length];
        for (int i = 1;i <= columnsIndex.length;i ++){
            columnsIndex[i - 1] = i;
        }*/
        try {
            HiveUtil hiveUtil = new HiveUtil();
            List<String> data = hiveUtil.getDataBySQL(sql);
            for (String line : data) {
                for (String column : line.split(",")){
                    System.out.print(column + "\t");
                }
                System.out.println();
            }
            // 释放资源
            hiveUtil.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
