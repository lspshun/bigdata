package com.dylan.test.service;

import com.dylan.test.bean.Account;
import com.dylan.test.dao.IAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountDAO accountDAO;

    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }

    @Override
    public int updata(Account account) {
        return accountDAO.update(account);
    }


    @Override
    public int delete(int id) {
        return accountDAO.delete(id);
    }


    @Override
    public Account findAccountByID(int id) {
        return accountDAO.findAccountById(id);
    }

    @Override
    public List<Account> findAccountLIst() {
        return accountDAO.findAccountList();
    }
}
