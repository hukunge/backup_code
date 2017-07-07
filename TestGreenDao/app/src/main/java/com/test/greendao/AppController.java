package com.test.greendao;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.test.greendao.DbUtil.MySQLiteOpenHelper;
import com.test.greendao.db.DaoMaster;
import com.test.greendao.db.DaoSession;


/**
 * Created by M4500 on 2017/7/5.
 */

public class AppController extends Application {
    public static final boolean ENCRYPTED = true;
    private DaoSession daoSession;

    private static AppController instance = null;

    public static AppController getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;


        //数据库名称：user-db.db和user-db是一样

        //有数据库升级的回调
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(this, "users-db", null,5);
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = daoMaster.newSession();

        //数据库加密
//        DaoMaster daoMaster = new DaoMaster(helper.getEncryptedWritableDb("1234"));
//        daoSession = daoMaster.newSession();

        //数据库不加密
        //无数据库升级回调
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "users-db"); //The users-db here is the name of our database.
//        Database db = helper.getWritableDb();
//        daoSession = new DaoMaster(db).newSession();

        //Stetho
        Stetho.initializeWithDefaults(this);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
