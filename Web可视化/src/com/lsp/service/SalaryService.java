package com.lsp.service;

import com.lsp.bean.Teacher;

import java.util.List;

public interface SalaryService {

    public List<Teacher> getTeacherSalary(String tableName);

}
