package com.south.prefee.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.south.prefee.bean.UserProfileBean;

import com.south.prefee.db.UserProfileBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userProfileBeanDaoConfig;

    private final UserProfileBeanDao userProfileBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userProfileBeanDaoConfig = daoConfigMap.get(UserProfileBeanDao.class).clone();
        userProfileBeanDaoConfig.initIdentityScope(type);

        userProfileBeanDao = new UserProfileBeanDao(userProfileBeanDaoConfig, this);

        registerDao(UserProfileBean.class, userProfileBeanDao);
    }
    
    public void clear() {
        userProfileBeanDaoConfig.clearIdentityScope();
    }

    public UserProfileBeanDao getUserProfileBeanDao() {
        return userProfileBeanDao;
    }

}
