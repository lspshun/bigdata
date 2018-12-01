package com.lsp.service;

import java.util.List;
import java.util.Map;

public interface TableService {

    public Map<String,String> getTableInfo(String tableName);

    public Map<String,List<String>> getTableDataArray(String tableName);

    public List<Map<String,String>> getTableDataJson(String tableName);

}
