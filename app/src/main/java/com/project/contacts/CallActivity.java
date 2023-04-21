package com.project.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

public class CallActivity extends AppCompatActivity {

    static int PERMISSION_CODE=100;
    Button Callbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);


        if(ContextCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(CallActivity.this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
        }

        Callbtn=findViewById(R.id.callbtn);
        Callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent CallIntent = new Intent(Intent.ACTION_CALL);
        CallIntent.setData(Uri.parse("tell:"+"9912755232"));
                if (ContextCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallActivity.this, new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);
                    startActivity(CallIntent);
                }
                else
                {
                    startActivity(CallIntent);
                }
                startActivity(CallIntent);
            }
        });

    }
}