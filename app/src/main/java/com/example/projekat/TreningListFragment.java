package com.example.projekat;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TreningListFragment extends ListFragment {

    static interface Listener {
        void itemClicked(long id);
    }

    private Listener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id); //obavestavamo osluskivac da je pritisnuta stavka u listi
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] vrsta = {"Gornji deo tela", "Donji deo tela", "HIIT trening", "Stomak", "Core"};

        ArrayAdapter<String>  adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1, vrsta
        );
        setListAdapter(adapter);

        //pozivanje metoda iz nadklase daje nam podrazumevani raspored za ListFragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}