package com.example.end_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    GetAuth_CAM getAuth_cam = new GetAuth_CAM();
    GetAuth_MIC getAuth_mic = new GetAuth_MIC();
    GetAuth_PHONE getAuth_phone = new GetAuth_PHONE();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getAuth_phone.Request_Phone_Permission(this);
        getAuth_mic.Request_MIC_Permission(this);

        // Check whether your app is running on a device that has a front-facing camera.
        if (getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA_FRONT)) {
            // Continue with the part of your app's workflow that requires a
            // front-facing camera. 카메라 있는 경우
            getAuth_cam.Request_Camera_Permission(this); // 카메라 권한 요청
        } else {
            // Gracefully degrade your app experience. 카메라 없는 경우
        }
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

}