package com.example.finalproject;

import static android.system.Os.connect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.Manifest;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL_PHONE = 1;
    private ImageButton callButton;
    private ImageButton gallery;
    private ImageButton about;
    private ImageButton Dining;
    private ImageButton room;
    private ImageButton book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callButton = findViewById(R.id.idImgBtn7);
        gallery=findViewById(R.id.idImgBtn3);
        about=findViewById(R.id.idImgBtn);
        Dining=findViewById(R.id.idImgBtn6);
        room=findViewById(R.id.idImgBtn5);
        book=findViewById(R.id.idImgBtn2);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeactivity();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeactivityy();
            }
        });
        Dining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeactivityyy();
            }
        });

        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makeactivityyy();
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              make();
            }
        });
    }


    private void makePhoneCall() {
        String phoneNumber = "123456789"; // Replace with your desired phone number
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
        }
    }
    public void makeactivity(){
        Intent intent = new Intent (this,Activity.class);
        startActivity(intent);
    }
    public void make(){
        Intent intent = new Intent (this,Book.class);
        startActivity(intent);
    }
    public void makeactivityyy(){
        Intent intent = new Intent (this,Dining.class);
        startActivity(intent);
    }
    public void makeactivityy(){
        Intent intent = new Intent (this,Aboutus.class);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            }
        }
    }




}