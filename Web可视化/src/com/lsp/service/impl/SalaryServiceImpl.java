package com.lsp.service.impl;

import com.lsp.bean.Teacher;
import com.lsp.dao.SalaryDao;
import com.lsp.dao.impl.SalaryDaoImpl;
import com.lsp.service.SalaryService;

import java.util.ArrayList;
import java.util.List;

public class SalaryServiceImpl implements SalaryService {

    private SalaryDao salaryDao = new SalaryDaoImpl();

    @Override
    public List<Teacher> getTeacherSalary(String tableName) {
        List<String> list = salaryDao.getTeacherSalary(tableName);
        List<Teacher> teacherList = new ArrayList<>();
        for (String data : list){
            String name = data.split(",")[1];
            double salary = Double.parseDouble(data.split(",")[2]);
            Teacher teacher = new Teacher(name,salary);
            teacherList.add(teacher);
        }
        return teacherList;
    }
}
