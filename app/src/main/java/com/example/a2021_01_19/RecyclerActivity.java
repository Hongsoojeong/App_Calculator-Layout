package com.example.a2021_01_19;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import Adapter.ItemAdapter;
import Data.ItemData;

public class RecyclerActivity extends AppCompatActivity {
    private ItemAdapter adapter;
    private RecyclerView recyclerView;
    private TextView buttonRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recycler_recycler);
        buttonRecycler=findViewById(R.id.button_recyclear);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);
        getData();
        buttonRecycler.setOnClickListener(view->{
        adapter.addItem(new ItemData("new name","new name", "new desc"));
       adapter.notifyDataSetChanged();
    });
    }
    private void getData(){
        for (int i=0; i<=9; i++) adapter.addItem(new ItemData("image","이름"+i,"소개"+i));
        adapter.notifyDataSetChanged();
    }
}
