package com.test;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by kunge on 2016/4/20.
 */
public class CheckPermission {
    public static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 20;

    /**
     * @param permission  Manifest.permission.WRITE_EXTERNAL_STORAGE
     * @param requestCode
     */
    public static void checkPermission(Activity activity, String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(App.getInstance(), permission)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    requestCode);
        }
    }
}
