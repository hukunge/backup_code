package com.test.annotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTest(View view) {

        try {
            MyTest1.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
