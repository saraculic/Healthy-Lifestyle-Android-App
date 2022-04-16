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

public class VeceraDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vecera_detail);

        String veceraIme = (String) getIntent().getExtras().get("ime");
        String veceraOpis = (String) getIntent().getExtras().get("opis");
        int veceraSlika = (Integer) getIntent().getExtras().get("slika");

        TextView ime = (TextView) findViewById(R.id.vecera_naziv_jela);
        ime.setText(veceraIme);

        TextView opis = (TextView) findViewById(R.id.vecera_opis);
        opis.setText(veceraOpis);

        ImageView imageView = (ImageView) findViewById(R.id.vecera_slika);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, veceraSlika));
        imageView.setContentDescription(veceraIme);

    }
}