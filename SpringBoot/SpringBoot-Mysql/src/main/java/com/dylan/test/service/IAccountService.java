package com.dylan.test.service;

import com.dylan.test.bean.Account;

import java.util.List;

public interface IAccountService {
    int add(Account account);
    int updata(Account account);
    int delete (int id);
    Account findAccountByID(int id);
    List<Account> findAccountLIst();
}
