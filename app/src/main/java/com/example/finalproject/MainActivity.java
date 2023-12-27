package com.example.finalproject;

import static android.system.Os.connect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.appsearch.PutDocumentsRequest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.Manifest;


import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;


import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL_PHONE = 1;
    private ImageButton callButton;
    private ImageButton gallery;
    private ImageButton about;
    private ImageButton Dining;
    private ImageButton room;
    private ImageButton book;
    private ImageButton map;

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
        map=findViewById(R.id.idImgBtn4);

       /* callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });*/

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map();
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
                dining();
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
    public void makeactivity(){
        Intent intent = new Intent (this,Activity.class);
        startActivity(intent);
    }
    public void map(){
        Intent intent = new Intent (this,map.class);
        startActivity(intent);
    }
    public void dining(){
        Intent intent = new Intent (this,Dining.class);
        startActivity(intent);
    }
    public void make(){
        Intent intent = new Intent (this,Loginn.class);
        startActivity(intent);
    }
    public void makeactivityyy(){
        Intent intent = new Intent (this,room.class);
        startActivity(intent);
    }
    public void makeactivityy(){
        Intent intent = new Intent (this,Aboutus.class);
        startActivity(intent);
    }


   /* @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            }
        }
    }*/


}