package com.example.projekat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SlikaAdapter extends RecyclerView.Adapter<SlikaAdapter.ViewHolder> {

    private ArrayList<Obrok> listaObroka;
    private Context context;

    private Listener listener; // dodajemo osluskivac kao privatnu promenljivu

    public SlikaAdapter(ArrayList<Obrok> listaObroka, Context context) {
        this.listaObroka = listaObroka;
        this.context = context;
    }

    interface Listener {
        void onClick(int position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            this.cardView = v;
        }
    }

    @Override
    public int getItemCount() {
        return listaObroka.size();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    //ovaj metod se poziva kada reciklirajuci prikaz treba da napravi drzac prikaza
    public SlikaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_slika, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Obrok obrok = listaObroka.get(position);

        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_slika);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), obrok.getImage_resource_id());
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription( obrok.getName());

        TextView textView = (TextView) cardView.findViewById(R.id.info_tekst);
        textView.setText(obrok.getName());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onClick(position);
                }
            }
        });
    }

}
