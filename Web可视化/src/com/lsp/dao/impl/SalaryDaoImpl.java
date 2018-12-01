package com.lsp.dao.impl;

import com.lsp.dao.SalaryDao;
import com.lsp.util.DBUtil;

import java.util.List;

public class SalaryDaoImpl implements SalaryDao {

    private DBUtil dbUtil = new DBUtil();

    @Override
    public List<String> getTeacherSalary(String tableName) {
        return dbUtil.getTableData(tableName);
    }
}
