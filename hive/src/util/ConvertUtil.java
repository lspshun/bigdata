package util;

public class ConvertUtil {

    /**
     * 统计分析函数计算
     * @param database 数据库名称
     * @param table 数据表名称
     * @param columns 结果列
     * @param column 计算列 - 也可以为数组
     * @param type 计算功能
     * @return 翻译后的SQL
     */
    public String SAC(String database,String table,String[] columns,String column,String type){
        String cls = "";
        for (String c : columns){
            cls += c + ",";
        }
        String sql = "select " + cls + type +"(" + column + ")" + " from " + database + "." + table + " group by " + cls.substring(0,cls.length() - 1);
        System.out.println(sql);
        return sql;
    }

    /**
     * 获得指定数据表的前n条数据
     * @param database 数据库名称
     * @param table 数据表名称
     * @param n 数据量
     * @param columns 待查询的列
     * @return 翻译后的SQL
     */
    public String getTableDataByN(String database, String table, String[] columns, int n){
        String cls = "";
        for (String c : columns){
            cls += c + ",";
        }
        cls = cls.substring(0,cls.length() - 1);
        String sql = "select " + cls + " from " + database + "." + table + " limit " + n;
        return sql;
    }

    /**
     * 获得指定数据表的前百分之n的数据
     * @param database 数据库名称
     * @param table 数据表名称
     * @param columns 待查询的列
     * @param n 百分比
     * @return 翻译后的SQL
     */
    public String getDataByNPercent(String database, String table, String[] columns, int n){
        String cls = "";
        for (String c : columns){
            cls += c + ",";
        }
        cls = cls.substring(0,cls.length() - 1);
        String sql = "select " + cls + " from " + database + "." + table + " tablesample(" + n + " percent)";
        return sql;
    }

    /**
     * 随机抽样
     * @param database 数据库名称
     * @param table 数据表名称
     * @param columns 待查询的列
     * @param n 数据量
     * @return 翻译后的SQL
     */
    public String getRandomDataN(String database, String table, String[] columns, int n){
        String cls = "";
        for (String c : columns){
            cls += c + ",";
        }
        cls = cls.substring(0,cls.length() - 1);
        String sql = "select " + cls + ",RAND() r from " + database + "." + table + " order by r limit " + n;
        return sql;
    }

    /**
     * 条件查询
     * @param database 数据库名称
     * @param table 数据表名称
     * @param columns 条件列名
     * @param conditions 条件
     * @param values 条件值
     * @return 翻译后的SQL
     */
    public String getDataByCondition(String database, String table, String[] columns, String[] conditions, String[] values){
        String c = "";
        for (int i = 0;i < columns.length;i ++){
            c += " and " + columns[i] + " " + conditions[i] + " " + values[i];
        }
        String sql = "select * from " + database + "." + table + " where 1 = 1" + c;
        return sql;
    }
}
