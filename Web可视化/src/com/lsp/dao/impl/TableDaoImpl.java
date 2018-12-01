package com.lsp.dao.impl;

import com.lsp.dao.TableDao;
import com.lsp.util.DBUtil;

import java.util.List;

public class TableDaoImpl implements TableDao {

    private DBUtil dbUtil = new DBUtil();

    @Override
    public List<String> getTableInfo(String tableName) {
        return dbUtil.getTableInfo(tableName);
    }

    @Override
    public List<String> getTableData(String tableName) {
        return dbUtil.getTableData(tableName);
    }
}
