package com.example.projekat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TreningDetailFragment extends Fragment {

    private long vrstaId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trening_detail, container, false);
    }


    public void setVrstaId(long vrstaId) {
        this.vrstaId = vrstaId;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();

        if (view != null){
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Trening trening = Trening.vezbe[(int) vrstaId];
            title.setText(trening.getVrsta());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(trening.getOpisVezbi());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            vrstaId = savedInstanceState.getLong("vrstaId");
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        savedInstanceState.putLong("vrstaId", vrstaId);
    }
}