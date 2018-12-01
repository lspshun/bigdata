package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HiveUtil {

    // 声明成员变量
    private Connection conn = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    // 加载驱动
    static {
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造方法，打开一个连接
     */
    public HiveUtil(){
        try {
            conn = DriverManager.getConnection("jdbc:hive2://192.168.116.200:10010/","bigdata","");
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库列表
     * @return 数据库名称集合
     */
    public List<String> getDatabases(){
        List databases = new ArrayList();
        try {
            preparedStatement = conn.prepareStatement("show databases");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                databases.add(resultSet.getString(1));
            }
            return databases;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 切换数据库
     * @param databse 目标数据库名称
     */
    public void changeDatabase(String databse){
        try {
            statement.execute("use " + databse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得某一数据库下数据表的列表
     * @param database 数据库名称
     * @return 数据表名称集合
     */
    public List<String> getTables(String database){
        List databases = new ArrayList();
        try {
            changeDatabase(database);
            resultSet = statement.executeQuery("show tables");
            while (resultSet.next()){
                databases.add(resultSet.getString(1));
            }
            return databases;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 执行查询语句，返回结果
     * @param sql 需要执行的sql语句
     * @param paras 执行查询所需要的参数
     * @return 结果集
     */
    public ResultSet executeQuery(String sql,Object[] paras){
        try {
            preparedStatement = conn.prepareStatement(sql);
            getPreparedStatement(paras);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获得表结构信息
     * @param database 数据库名称
     * @param table 数据表名称
     * @return 数据表结构集合
     */
    public List<String> getDesc(String database, String table){
        try {
            List<String> list = new ArrayList<>();
            preparedStatement = conn.prepareStatement("desc " + database + "." + table);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(resultSet.getString(1) + "," + resultSet.getString(2));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将传入的参数进行赋值，构建一个完整的PreparedStatement
     * @param paras 传入的参数
     */
    private void getPreparedStatement(Object[] paras){
        if (paras != null){
            for (int i = 0;i < paras.length;i ++){
                try {
                    preparedStatement.setObject(i + 1,paras[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 执行一个不需要返回结果的命令
     * @param sql 需要执行的sql
     * @param paras 执行sql需要的参数
     */
    public void execute(String sql, Object[] paras){
        try {
            preparedStatement = conn.prepareStatement(sql);
            getPreparedStatement(paras);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过自定义SQL返回结果
     * @param sql 执行语句 - 包含数据库名称
     * @return SQL执行结果集
     */
    public List<String> getDataBySQL(String sql){
        // temp_userId_时间戳
        // 时间戳 -> Long -> 1970-01-01 00:00:00 毫秒数 -> Unix元年 -> 1967 -> 1969
        try {
            String tableName = "temp_1_" + new Date().getTime();
            preparedStatement = conn.prepareStatement("create table temp." + tableName + " as " + sql);
            preparedStatement.execute();
            // 如果使用同一个ResultSet对象必须保证不出现穿插调用
            int size = getDesc("temp",tableName).size();
            preparedStatement = conn.prepareStatement("select * from temp." + tableName);
            resultSet = preparedStatement.executeQuery();
            return getData(resultSet,size);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从数据表中查询指定列的数据
     * @param sql 执行语句 - 包含数据库名称
     * @param columnsIndex 待查询的列的索引
     * @return SQL执行结果集
     */
    public List<String> getDataBySQLWithColumns(String sql,int[] columnsIndex){
        try {
            String tableName = "temp_1_" + new Date().getTime();
            preparedStatement = conn.prepareStatement("create table temp." + tableName + " as " + sql);
            preparedStatement.execute();
            // 如果使用同一个ResultSet对象必须保证不出现穿插调用
            int size = getDesc("temp",tableName).size();
            preparedStatement = conn.prepareStatement("select * from temp." + tableName);
            resultSet = preparedStatement.executeQuery();
            return getDataByColumns(resultSet,columnsIndex);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 数据封装工具
     * @param resultSet 结果集
     * @param size 数据列数量
     * @return 封装的List数据集
     */
    private List<String> getData(ResultSet resultSet,int size){
        List<String> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                String line = "";
                for(int i = 0;i < size;i ++){
                    line += resultSet.getString(i + 1) + ",";
                }
                line = line.substring(0,line.length() - 1);
                list.add(line);
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 数据封装工具
     * @param resultSet 结果集
     * @param columnIndex 数据列索引
     * @return 封装的List数据集
     */
    private List<String> getDataByColumns(ResultSet resultSet,int[] columnIndex){
        List<String> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                String line = "";
                for(int i = 0;i < columnIndex.length;i ++){
                    line += resultSet.getString(columnIndex[i]) + ",";
                }
                line = line.substring(0,line.length() - 1);
                list.add(line);
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放资源
     */
    public void close() {
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
