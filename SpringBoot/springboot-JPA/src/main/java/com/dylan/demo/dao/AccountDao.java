package com.dylan.demo.dao;

import com.dylan.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public interface AccountDao  extends JpaRepository<Account,Integer> {
}
