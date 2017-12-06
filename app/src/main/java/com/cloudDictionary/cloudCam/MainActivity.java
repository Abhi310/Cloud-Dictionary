package com.cloudDictionary.cloudCam;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int REQUEST_CAM = 1;
    private static final int REQUEST_LOC = 2;
    private static final int REQUEST_STO = 3;
    private static final int REQUEST_SENS = 4;
    private static final int REQUEST_MULTI = 5;

    //private static final String LOC = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String Cam = Manifest.permission.CAMERA;
    private static final String Loc = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String Sto = Manifest.permission.READ_EXTERNAL_STORAGE;
    private static final String Sens = Manifest.permission.READ_PHONE_STATE;

    List<String> multiplePermissions = new ArrayList<>();

    String Granted = "False";

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        /**
         * shouldShowRequestPermissionRationale() returns true if the app has requested this permission previously and the user
         * denied the request
         * false in DONT ASK AGAIN
         * */
        System.out.println("Before"+Granted);
        //checkForPermission();
        checkMultiplePermissions();
        //multiplePermission();

        //checkForPermission();
        System.out.println("After"+Granted);
        /**
         * requestPermissions() shows a standard dialog box to the user
         * */
    }



    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onRestart() {
        super.onRestart();
        //checkForPermission();
        checkMultiplePermissions();
    }

    private void checkForPermission() {
        int permissionChecking = ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA);
        if (permissionChecking == PackageManager.PERMISSION_GRANTED)
        {
            Intent in =new Intent(getApplicationContext(),main.class);
            startActivity(in);
            Log.d(TAG, "Granted");
        } else
            {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CAMERA)) {
                //Log.d(TAG, "Contacts Permission Required!!");
                //createSnackbar("Contacts Permission Required!!", "Try Again");
            }
            ActivityCompat.
                    requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAM);

        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case REQUEST_CAM:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Intent in =new Intent(getApplicationContext(),main.class);
                    startActivity(in);
                    Log.d(TAG, "onRequestPermissionsResult: Granted");
                } else
                    {
                    boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale
                            (MainActivity.this, Manifest.permission.CAMERA);

                    if (showRationale) {
                        Intent in =new Intent(getApplicationContext(),main.class);
                        startActivity(in);
                        Log.d(TAG, "onRequestPermissionsResult: IF");
                      //  createSettingsSnackbar("Contacts Permission Required!!");
                    } else {
                        finish();
                        Log.d(TAG, "onRequestPermissionsResult: ELSE");
                        //createSnackbar("Contacts Permission Required!!", "Try Again");
                    }

                }
                break;

            case REQUEST_LOC:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Intent in =new Intent(getApplicationContext(),main.class);
                    startActivity(in);
                    Log.d(TAG, "onRequestPermissionsResult: Granted");
                } else
                {
                    boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale
                            (MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

                    if (showRationale) {
                        Intent in =new Intent(getApplicationContext(),main.class);
                        startActivity(in);
                        Log.d(TAG, "onRequestPermissionsResult: IF");
                        //  createSettingsSnackbar("Contacts Permission Required!!");
                    } else {
                        finish();
                        Log.d(TAG, "onRequestPermissionsResult: ELSE");
                        //createSnackbar("Contacts Permission Required!!", "Try Again");
                    }

                }
                break;

            case REQUEST_STO:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Intent in =new Intent(getApplicationContext(),main.class);
                    startActivity(in);
                    Log.d(TAG, "onRequestPermissionsResult: Granted");
                } else
                {
                    boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale
                            (MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);

                    if (showRationale) {
                        Intent in =new Intent(getApplicationContext(),main.class);
                        startActivity(in);
                        Log.d(TAG, "onRequestPermissionsResult: IF");
                        //  createSettingsSnackbar("Contacts Permission Required!!");
                    } else {
                        finish();
                        Log.d(TAG, "onRequestPermissionsResult: ELSE");
                        //createSnackbar("Contacts Permission Required!!", "Try Again");
                    }

                }
                break;

            case REQUEST_SENS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Intent in =new Intent(getApplicationContext(),main.class);
                    startActivity(in);
                    Log.d(TAG, "onRequestPermissionsResult: Granted");
                } else
                {
                    boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale
                            (MainActivity.this, Manifest.permission.READ_PHONE_STATE);

                    if (showRationale) {
                        Intent in =new Intent(getApplicationContext(),main.class);
                        startActivity(in);
                        Log.d(TAG, "onRequestPermissionsResult: IF");
                        //  createSettingsSnackbar("Contacts Permission Required!!");
                    } else {
                        finish();
                        Log.d(TAG, "onRequestPermissionsResult: ELSE");
                        //createSnackbar("Contacts Permission Required!!", "Try Again");
                    }

                }
                break;

            case REQUEST_MULTI:
                Map<String, Integer> permissionMap = new HashMap<>();
                permissionMap.put(Loc, PackageManager.PERMISSION_GRANTED);
                permissionMap.put(Cam, PackageManager.PERMISSION_GRANTED);
                permissionMap.put(Sto, PackageManager.PERMISSION_GRANTED);
                permissionMap.put(Sens, PackageManager.PERMISSION_GRANTED);

                if (grantResults.length > 0)
                {
                    for (int i = 0; i < permissions.length; i++) {
                        Log.d(TAG, "onRequestPermissionsResult: PERMISSION: " + permissions[i] + " GRANT:" + grantResults[i]);
                        permissionMap.put(permissions[i], grantResults[i]);
                    }

                    if ((permissionMap.get(Loc) == PackageManager.PERMISSION_GRANTED) && (permissionMap.get(Cam) == PackageManager.PERMISSION_GRANTED) && (permissionMap.get(Sto) == PackageManager.PERMISSION_GRANTED) && (permissionMap.get(Sens) == PackageManager.PERMISSION_GRANTED))
                    {
                        Granted = "True";
                        Intent in =new Intent(getApplicationContext(),main.class);
                        startActivity(in);
                        Log.d(TAG, "Granted");
                    }
                    else{
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Loc)  && ActivityCompat.shouldShowRequestPermissionRationale(this, Cam) && ActivityCompat.shouldShowRequestPermissionRationale(this, Sto) && ActivityCompat.shouldShowRequestPermissionRationale(this, Sens))
                        {

                            //finish();
                            Intent in =new Intent(getApplicationContext(),main.class);
                            startActivity(in);
                            //createSnackbar
                            //createMultiplePermSnackbar("Permissions Required!!", "Try Again");
                        }
                        else {
                            //Intent in =new Intent(getApplicationContext(),main.class);
                            //startActivity(in);
                            finish();
                            //goto settings
                            //createSettingsSnackbar("Permissions Required!!");
                        }
                    }
                }


                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }




    private void checkMultiplePermissions(){

        int permissioncam = ContextCompat.checkSelfPermission(this, Cam);
        int permissionloc = ContextCompat.checkSelfPermission(this, Loc);
        int permissionsto = ContextCompat.checkSelfPermission(this, Sto);
        int permissionsens = ContextCompat.checkSelfPermission(this, Sens);
        if (permissioncam != PackageManager.PERMISSION_GRANTED)
            multiplePermissions.add(Cam);
        if (permissionloc != PackageManager.PERMISSION_GRANTED)
            multiplePermissions.add(Loc);
        if (permissionsto != PackageManager.PERMISSION_GRANTED)
            multiplePermissions.add(Sto);
        if (permissionsens != PackageManager.PERMISSION_GRANTED)
            multiplePermissions.add(Sens);

        if (multiplePermissions.size()>0)
        {
            if(multiplePermissions.size() == 1 )
            {
                if (permissioncam != PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAM);

                if (permissionloc != PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.
                            requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOC);

                if (permissionsto != PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.
                            requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_STO);

                if (permissionsens != PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.
                            requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_SENS);

            }
            else
            {
                ActivityCompat.requestPermissions(this, multiplePermissions.toArray(new String[multiplePermissions.size()]), REQUEST_MULTI);
            }
        }
        else{
            Intent in =new Intent(getApplicationContext(),main.class);
            startActivity(in);
        }
    }
}
