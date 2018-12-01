package com.dylan.demo.dao;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository   //仓库类
public interface LoginRepository extends JpaRepository<User,Integer> {
}
