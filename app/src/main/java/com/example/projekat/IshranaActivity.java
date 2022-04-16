package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class IshranaActivity extends AppCompatActivity {

    Button dorucak, rucak, vecera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ishrana);

        dorucak = (Button) findViewById(R.id.btndorucak);
        rucak = (Button) findViewById(R.id.btnrucak);
        vecera = (Button) findViewById(R.id.btnvecera);


        dorucak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IshranaActivity.this, DorucakActivity.class);
                startActivity(intent);
            }
        });

        rucak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IshranaActivity.this, RucakActivity.class);
                startActivity(intent);
            }
        });

        vecera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IshranaActivity.this, VeceraActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(IshranaActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.logout:
                Intent i = new Intent(IshranaActivity.this, MainActivity.class);
                startActivity(i);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
