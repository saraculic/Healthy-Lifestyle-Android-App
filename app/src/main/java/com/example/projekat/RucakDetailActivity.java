package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RucakDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rucak_detail);

        String rucakIme = (String) getIntent().getExtras().get("ime");
        String rucakOpis = (String) getIntent().getExtras().get("opis");
        int rucakSlika = (Integer) getIntent().getExtras().get("slika");

        TextView ime = (TextView) findViewById(R.id.rucak_naziv_jela);
        ime.setText(rucakIme);

        TextView opis = (TextView) findViewById(R.id.rucak_opis);
        opis.setText(rucakOpis);

        ImageView imageView = (ImageView) findViewById(R.id.rucak_slika);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, rucakSlika));
        imageView.setContentDescription(rucakIme);
    }
}