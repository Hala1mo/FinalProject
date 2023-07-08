package com.example.finalproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityy);
        RecyclerView recycler = findViewById(R.id.Test_recycler);
        int[] ids = new int[6];
        ids[0]=R.drawable.img;
        ids[1]=R.drawable.img_1;
        ids[2]=R.drawable.img_2;
        ids[3]=R.drawable.img_3;
        ids[4]=R.drawable.img_4;
        ids[5]=R.drawable.img_5;
        String [] cap=new String[6];
        cap[0]="Abundant Flavours ";
        cap[1]="Rooms & Suites ";
        cap[2]="Dining";
        cap[3]="Spa";
        cap[4]="Activities &  Entertainment";
        cap[5]="Events & Clubs";
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter( cap,ids);
        recycler.setAdapter(adapter);

    }
}