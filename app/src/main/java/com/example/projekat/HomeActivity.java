package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button bmi = findViewById(R.id.btnbmi);
        Button ishrana = findViewById(R.id.btnishrana);
        Button trening = findViewById(R.id.btntrening);
        Button koraci = findViewById(R.id.btnkoraci);
        Button hidratacija = findViewById(R.id.btnhidratacija);
        Button mapa = findViewById(R.id.mapa);

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BMIFirstActivity.class);
                startActivity(intent);
            }
        });

        ishrana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, IshranaActivity.class);
                startActivity(intent);
            }
        });

        trening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, TreningVrstaActivity.class);
                startActivity(intent);
            }
        });

        koraci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, KoraciActivity.class);
                startActivity(intent);
            }
        });

        hidratacija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ObavestenjeActivity.class);
                startActivity(intent);
            }
        });
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,  LokacijaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                DialogFragment dialogFragment = new DialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"My  Fragment");
        }
        return super.onOptionsItemSelected(item);
    }

}