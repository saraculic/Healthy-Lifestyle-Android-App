package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BMIFirstActivity extends AppCompatActivity {

    Button btnBMI, btnCALL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        btnBMI = (Button) findViewById(R.id.btnBMI);
        btnCALL = (Button) findViewById(R.id.btnpozovi);

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BMIFirstActivity.this, BMIActivity.class);
                startActivity(intent);
            }
        });

        btnCALL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0641234567"));
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
                Intent intent = new Intent(BMIFirstActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.logout:
                Intent i = new Intent(BMIFirstActivity.this, MainActivity.class);
                startActivity(i);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}