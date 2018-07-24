package com.south.prefee.utils.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.south.prefee.db.DaoMaster;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/3/16
 * @Describe
 */

public class DBDaoHelper extends DaoMaster.OpenHelper {
    private String name;
    private Context context;

    public DBDaoHelper(Context context, String name) {
        super(context, name);
        this.context = context;
        this.name = name;

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
/*
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

                    @Override
                    public void onCreateAllTables(Database db, boolean ifNotExists) {
                        DaoMaster.createAllTables(db, ifNotExists);
                    }

                    @Override
                    public void onDropAllTables(Database db, boolean ifExists) {
                        DaoMaster.dropAllTables(db, ifExists);
                    }
                };
*/



    }

}
