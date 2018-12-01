package com.dylan.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "test", catalog = "")
public class UserEntity {
    private int id;
    private String name;
    private String passwd;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "passwd")
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(passwd, that.passwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passwd);
    }
}
