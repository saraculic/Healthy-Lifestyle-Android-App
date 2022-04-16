package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class ObavestenjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obavestenje);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MessageService.class);
        intent.putExtra(MessageService.EXTRA_MESSAGE, getResources().getString(R.string.poruka));
        startService(intent);
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
                Intent intent = new Intent(ObavestenjeActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.logout:
                Intent i = new Intent(ObavestenjeActivity.this, MainActivity.class);
                startActivity(i);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}