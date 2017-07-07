package com.test.greendao.DbUtil;//package com.test.greendao.DbUtil;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.test.greendao.db.DaoMaster;
import com.test.greendao.db.User1Dao;

import org.greenrobot.greendao.database.StandardDatabase;

/**
 * Created by Growth on 2016/3/3.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        DaoMaster.createAllTables(new StandardDatabase(db), false);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("kunge.hu","onUpgrade !!!!");

        try {
            MigrationHelper migratorHelper = new MigrationHelper();
            //判断版本， 设置需要修改得表  我这边设置一个 FileInfo
            if (true) {
                migratorHelper.onUpgrade(db, User1Dao.class);
            }
        } catch (ClassCastException e) {
        }
    }
}