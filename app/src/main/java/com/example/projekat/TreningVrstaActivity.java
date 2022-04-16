package com.example.projekat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TreningVrstaActivity extends AppCompatActivity implements TreningListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trening_vrste);

        Button izvodjenje_vezbi = (Button) findViewById(R.id.izvodjenja_vezbi);
        izvodjenje_vezbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TreningVrstaActivity.this, WorkoutsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void itemClicked(long id) {

        //Ovo ce postojati jedino ako se aplikacija izvrsava na uredjaju sa velikim ekranom.
        View fragmentContainer = findViewById(R.id.fragment_container);
        if(fragmentContainer != null){

            //Dodavanje fragmenta u FrameLayout
            TreningDetailFragment details = new TreningDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setVrstaId(id);
            ft.replace(R.id.fragment_container, details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //postizanje da se stari i novi fragment postepeno zamene
            ft.addToBackStack(null);
            ft.commit();
        } else {
            //ako raspored okvira ne postoji znaci da se aplikacija izvrsava na uredjaju sa manjim ekranom
            Intent intent = new Intent(this, TreningDetailActivity.class);
            intent.putExtra(TreningDetailActivity.VRSTA_ID, (int) id);
            startActivity(intent);
        }
    }

}