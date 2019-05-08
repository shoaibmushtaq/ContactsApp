package com.example.muhammadshoaib.contactsapp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    Intent intent;
    public static final int PERMISSION_REQUEST_CODE=1240;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //checking if the permissions are already granted
        if (ContextCompat.checkSelfPermission(SplashActivity.this,
                Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED ) {
            Toast.makeText(SplashActivity.this, "You have already granted this permission!",
                    Toast.LENGTH_SHORT).show();


                        intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();



            //if permissions are not granted before then invoke reuquestStoragePermission method
        } else {
            requestStoragePermission();
        }
    }

    //this method is used if the user have already deny the permission and gives user the custom dialog
    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,
                Manifest.permission.READ_CONTACTS))
        {

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("permission is  required to fetch contacts ")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(SplashActivity.this,
                                    new String[] {Manifest.permission.READ_CONTACTS}, PERMISSION_REQUEST_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    })
                    .create().show();

            //
        } else {
            ActivityCompat.requestPermissions(SplashActivity.this,
                    new String[] {Manifest.permission.READ_CONTACTS}, PERMISSION_REQUEST_CODE);
        }
    }



    //this method is used to get allow request from user and check
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE)  {
            if ((grantResults.length > 0) &&(grantResults[0]) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();



                            intent=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            finish();
                    }






            } else {
                Toast.makeText(SplashActivity.this, "Permission DENIED", Toast.LENGTH_SHORT).show();
                finish();
            }




        }
    }




