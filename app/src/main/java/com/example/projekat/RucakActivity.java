package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class RucakActivity extends AppCompatActivity {

    private ArrayList<Obrok> listaRucak;
    private IshranaDatabaseHelper db;
    private SlikaAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rucak);

        listaRucak = new ArrayList<>();
        db = new IshranaDatabaseHelper(RucakActivity.this);

        listaRucak = db.readRucak();

        SlikaAdapter adapter = new SlikaAdapter(listaRucak, RucakActivity.this);
        RecyclerView recyclerView = findViewById(R.id.rucak_recycle);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setListener(new SlikaAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(RucakActivity.this, RucakDetailActivity.class);
                intent.putExtra("ime", listaRucak.get(position).getName());
                intent.putExtra("opis", listaRucak.get(position).getDescription());
                intent.putExtra("slika", listaRucak.get(position).getImage_resource_id());
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