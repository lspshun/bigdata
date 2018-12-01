package com.lsp.service.impl;


import com.lsp.dao.TableDao;
import com.lsp.dao.impl.TableDaoImpl;
import com.lsp.service.TableService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TableServiceImpl implements TableService {

    private TableDao tableDao = new TableDaoImpl();

    @Override
    public Map<String, String> getTableInfo(String tableName) {
        List<String> list = tableDao.getTableInfo(tableName);
        Map<String, String> map = new LinkedHashMap<>();
        for (String column : list){
            map.put(column.split(",")[0],column.split(",")[1]);
        }
        return map;
    }

    /**
     * 将表结构中的字段名称作为返回结果Map中的key
     * 将数据存放在对应的key下(List)
     * @param tableName
     * @return
     */
    @Override
    public Map<String, List<String>> getTableDataArray(String tableName) {
        List<String> columns = tableDao.getTableInfo(tableName);
        List<String> data = tableDao.getTableData(tableName);
        Map<String, List<String>> map = new LinkedHashMap<>();
        for(int i = 0;i < columns.size();i ++){
            // 取出每一列的列名
            String column = columns.get(i).split(",")[0];
            List<String> listData = new ArrayList<>();
            // 取出每一行中对应列的数据 -> 存放在List集合中
            for (String line :data){
                listData.add(line.split(",")[i]);
            }
            // 将对应的数据存放在Map结构中
            map.put(column,listData);
        }
        return map;
    }

    @Override
    public List<Map<String, String>> getTableDataJson(String tableName) {
        List<String> columns = tableDao.getTableInfo(tableName);
        List<String> data = tableDao.getTableData(tableName);
        List<Map<String,String>> list = new ArrayList<>();
        // 遍历每一行数据
        for (String line : data){
            Map<String,String> temp = new LinkedHashMap<>();
            // 取出每列的列名和相应的数据，将每一行构建成json格式
            for (int i = 0;i < columns.size();i ++){
                temp.put(columns.get(i).split(",")[0],line.split(",")[i]);
            }
            list.add(temp);
        }
        return list;
    }
}
