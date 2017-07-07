package com.test.butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.tv_hello)
    TextView tvHello;

    @OnClick(R.id.bt_test)
    private void clickTest() {
        tvHello.setText("我是click后的textview");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ViewInjectUtils.inject(this);
        tvHello.setText("我是click前的textview");
    }
}
