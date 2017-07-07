package com.test.greendao;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.test.greendao.db.User1;
import com.test.greendao.db.User1Dao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MainActivity extends Activity {
    private User1Dao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDao = AppController.getInstance().getDaoSession().getUser1Dao();
    }

    public void clickAdd(View view) {
        User1 user = new User1();
        user.setEmail("66547109@qq.com");
        user.setFirst_name("hu");
        user.setLast_name("kunge_update_test");
        user.setUser_id(11);
        user.setAddress("江苏省新安镇轻工路西十三巷五十号");
        user.setHeadicon("www.baidu.com");
//        user.setId(12l);

//        userDao.insert(user);
        userDao.insertInTx(user);
//        userDao.insertOrReplace(user);
    }

    public void clickDelete(View view) {
//        User user = new User();
//        user.setEmail("66547109@qq.com");
//        user.setFirst_name("hu");
//        user.setLast_name("kunge");
//        user.setUser_id(11);
//        user.setId(10l);
//
//        userDao.delete(user);
//        userDao.deleteInTx(user);

        userDao.deleteAll();
    }

    public void clickUpdate(View view) {
//        userDao.insertOrReplaceInTx(user);
    }

    public void clickQuery(View view) {
//        Log.e("kunge.hu",System.currentTimeMillis() + "--------------start click");
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 200; i++) {
//            executorService.submit(run);
//        }
//        executorService.shutdown();
//        Log.e("kunge.hu",System.currentTimeMillis() + "--------------end click");


        search();
    }


    private void search(){
        //生成按id倒排序的列表
//        List<User> userList = userDao.queryBuilder().orderDesc(UserDao.Properties.First_name).list();
//        for (User u : userList) {
//            System.out.println("id:" + u.getId() + " last_name:" + u.getLast_name());
//        }


        Log.e("kunge.hu",System.currentTimeMillis() + "--------------start111");
        userDao.getSession().runInTx(new Runnable() {
            @Override
            public void run() {
                Log.e("kunge.hu",System.currentTimeMillis() + "--------------start");
                //根据查询条件,返回数据列表
                QueryBuilder qb = userDao.queryBuilder();
                qb.where(User1Dao.Properties.First_name.eq("hu"),
                        qb.or(User1Dao.Properties.Id.gt(23),
                                qb.and(User1Dao.Properties.Last_name.eq("kunge"), User1Dao.Properties.Id.ge(23))));
                List<User1> userList = qb.list();
                for (User1 u : userList) {
                    Log.e("kunge.hu","id:" + u.getId() + " last_name:" + u.getLast_name());
                }
                Log.e("kunge.hu",System.currentTimeMillis() + "--------------end");
            }
        });
        Log.e("kunge.hu",System.currentTimeMillis() + "--------------end1111");
    }

//    private Runnable run = new Runnable() {
//        @Override
//        public void run() {
//            search();
//        }
//    };
}
