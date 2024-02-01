package com.example.recyclerviewuse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<String>ulkelerList;
    private RvAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        ulkelerList =new ArrayList<>();
        ulkelerList.add("ÜLKELER");
        ulkelerList.add("Türkiye");
        ulkelerList.add("Almanya");
        ulkelerList.add("İspanya");
        ulkelerList.add("Romanya");
        ulkelerList.add("Rusya");
        ulkelerList.add("İngiltere");
        ulkelerList.add("ABD");

        adapter = new RvAdapter(MainActivity.this,ulkelerList);

        rv.setAdapter(adapter);

    }
}