package com.test;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TooManyListenersException;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickAdd(View view){
        CheckPermission.checkPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE,CheckPermission.WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        doNext(requestCode,grantResults);
    }

    private void doNext(int requestCode, int[] grantResults) {
        Log.e("kunge.hu","requestCode"+requestCode);
        Toast.makeText(MainActivity.this, "requestCode:"+requestCode, Toast.LENGTH_SHORT).show();
    }
}
