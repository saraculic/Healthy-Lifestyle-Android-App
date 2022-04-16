package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity {

    Button btn_bmi_izracunaj;

    TextView trenutna_visina;
    TextView trenutne_godine, trenutno_kg;

    ImageView plus_godine, plus_tezina, minus_godine, minus_tezina;

    SeekBar mseekbar_visina;
    RelativeLayout muski, zenski;

    int tezina = 55;
    int godine = 22;
    int trenutni_progress;

    String mprogress = "170";
    String pol = "0";
    String tezina1 = "55";
    String godine1 = "22";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalc);
        getSupportActionBar().hide();

        btn_bmi_izracunaj = (Button) findViewById(R.id.calculatorbmi);
        trenutne_godine = (TextView) findViewById(R.id.trenutne_godine);
        trenutno_kg = (TextView) findViewById(R.id.trenutno_kg);
        trenutna_visina = (TextView) findViewById(R.id.trenutna_visina);
        plus_godine = (ImageView) findViewById(R.id.plus_godine);
        minus_godine = (ImageView) findViewById(R.id.minus_godine);
        plus_tezina =  (ImageView)findViewById(R.id.plus_tezina);
        minus_tezina = (ImageView) findViewById(R.id.minus_tezina);
        mseekbar_visina = (SeekBar) findViewById(R.id.seekbar);
        muski = (RelativeLayout) findViewById(R.id.muski);
        zenski = (RelativeLayout) findViewById(R.id.zenski);


        muski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muski.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                zenski.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                pol = "Muški";
            }
        });

        zenski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zenski.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                muski.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                pol = "Ženski";
            }
        });


        mseekbar_visina.setMax(300);
        mseekbar_visina.setProgress(170);
        mseekbar_visina.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                trenutni_progress = progress;
                mprogress = String.valueOf(trenutni_progress);
                trenutna_visina.setText(mprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        plus_godine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                godine = godine + 1;
                godine1 = String.valueOf(godine);
                trenutne_godine.setText(godine1);
            }
        });

        minus_godine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                godine = godine - 1;
                godine1 = String.valueOf(godine);
                trenutne_godine.setText(godine1);
            }
        });

        plus_tezina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tezina = tezina + 1;
                tezina1 = String.valueOf(tezina);
                trenutno_kg.setText(tezina1);
            }
        });

        minus_tezina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tezina = tezina - 1;
                tezina1 = String.valueOf(tezina);
                trenutno_kg.setText(tezina1);
            }
        });

        btn_bmi_izracunaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pol.equals("0")){
                    Toast.makeText(getApplicationContext(), "Izaberite pol!", Toast.LENGTH_SHORT).show();
                } else if(mprogress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Izaberite visinu!", Toast.LENGTH_SHORT).show();
                } else if (godine == 0 || godine < 0){
                    Toast.makeText(getApplicationContext(), "Broj godina nije u dobrom formatu!", Toast.LENGTH_SHORT).show();
                } else if (tezina == 0 || tezina < 0){
                    Toast.makeText(getApplicationContext(), "Težina nije u dobrom formatu", Toast.LENGTH_SHORT).show();
                } else {
                    Bundle args = new Bundle();
                    args.putString("visina", mprogress);
                    args.putString("tezina", tezina1);
                    DialogFragmentBMI dialogFragment = new DialogFragmentBMI();
                    dialogFragment.setArguments(args);
                    dialogFragment.show(getSupportFragmentManager(),"BMI fragment");
                }
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
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(BMIActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.logout:
                Intent i = new Intent(BMIActivity.this, MainActivity.class);
                startActivity(i);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}