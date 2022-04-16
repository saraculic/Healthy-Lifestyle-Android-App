package com.example.projekat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DialogFragmentBMI extends androidx.fragment.app.DialogFragment{

    Button btnNazad;
    TextView rez, rezOpis;
    Intent intent;
    String bmi, visinaStr,tezinaStr;
    float rezBMI, visina, tezina;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.dialog_fragment_bmi, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        Bundle mArgs = getArguments();

        if (view != null){
            intent = getActivity().getIntent();
            rez = (TextView) view.findViewById(R.id.rezultat);
            rezOpis = (TextView) view.findViewById(R.id.rezOpis);
            btnNazad = (Button) view.findViewById(R.id.btnNazad);

            visinaStr = mArgs.getString("visina");
            tezinaStr = mArgs.getString("tezina");

            visina = Float.parseFloat(visinaStr);
            tezina = Float.parseFloat(tezinaStr);
            visina = visina /100;

            rezBMI = tezina /(visina * visina);
            bmi = Float.toString(rezBMI);

            if(rezBMI < 18.5){
                rezOpis.setText("Neuhranjenost!");
            } else if(rezBMI >= 18.5 && rezBMI < 25){
                rezOpis.setText("Normalna telesna težina");
            } else if (rezBMI >= 25 && rezBMI < 30){
                rezOpis.setText("Prekomerna telesna težina");
            } else if(rezBMI >= 30 ) {
                rezOpis.setText("Gojaznost!");
            }

            rez.setText(bmi);

            btnNazad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
