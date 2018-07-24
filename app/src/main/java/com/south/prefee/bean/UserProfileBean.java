package com.south.prefee.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserProfileBean {
    @Id(autoincrement = true)
    public long id;
    public String userId;
    public String name;
    @Generated(hash = 1458297456)
    public UserProfileBean(long id, String userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }
    @Generated(hash = 2022987115)
    public UserProfileBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
