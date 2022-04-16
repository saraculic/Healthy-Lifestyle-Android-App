package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DorucakDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dorucak_detail);

        String dorucakIme = (String) getIntent().getExtras().get("ime");
        String dorucakOpis = (String) getIntent().getExtras().get("opis");
        int dorucakSlika = (Integer) getIntent().getExtras().get("slika");

        TextView textView = (TextView) findViewById(R.id.dorucak_naziv_jela);
        textView.setText(dorucakIme);

        TextView opis = (TextView) findViewById(R.id.dorucak_opis);
        opis.setText(dorucakOpis);

        ImageView imageView = (ImageView) findViewById(R.id.dorucak_slika);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, dorucakSlika));
        imageView.setContentDescription(dorucakIme);


    }
}