package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TreningDetailActivity extends AppCompatActivity {

    public static final String VRSTA_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trening_detail);

        TreningDetailFragment frag = (TreningDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        int vrstaId = (int) getIntent().getExtras().get(VRSTA_ID);
        frag.setVrstaId(vrstaId);
    }
}