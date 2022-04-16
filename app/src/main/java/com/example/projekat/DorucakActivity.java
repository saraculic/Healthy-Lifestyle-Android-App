package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class DorucakActivity extends AppCompatActivity {

    private ArrayList<Obrok> listaDorucak;
    private IshranaDatabaseHelper db;
    private SlikaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dorucak);

        RecyclerView recyclerView = findViewById(R.id.dorucak_recycle);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        listaDorucak = new ArrayList<>();
        db = new IshranaDatabaseHelper(DorucakActivity.this);
        listaDorucak = db.readDorucak();

        SlikaAdapter adapter = new SlikaAdapter(listaDorucak, DorucakActivity.this);
        recyclerView.setAdapter(adapter);

        adapter.setListener(new SlikaAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(DorucakActivity.this, DorucakDetailActivity.class);
                intent.putExtra("ime", listaDorucak.get(position).getName());
                intent.putExtra("opis", listaDorucak.get(position).getDescription());
                intent.putExtra("slika", listaDorucak.get(position).getImage_resource_id());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}