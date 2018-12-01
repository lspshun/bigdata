package com.lsp.dao;

import java.util.List;

public interface TableDao {

    public List<String> getTableInfo(String tableName);

    public List<String> getTableData(String tableName);

}
