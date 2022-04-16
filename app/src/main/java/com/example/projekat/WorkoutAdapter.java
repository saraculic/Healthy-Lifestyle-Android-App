package com.example.projekat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder> {

    private ArrayList<WorkoutModel> workoutModelArrayList;
    private Context context;

    public WorkoutAdapter(ArrayList<WorkoutModel> workoutModelArrayList, Context context) {
        this.workoutModelArrayList = workoutModelArrayList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView name;
        private TextView link;

        public ViewHolder(View v) {
            super(v);
            cardView = v.findViewById(R.id.card_view_workout);
            name = v.findViewById(R.id.name_workout);
            link = v.findViewById(R.id.link);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

            holder.name.setText(workoutModelArrayList.get(position).getName());
            holder.link.setText(workoutModelArrayList.get(position).getVideo());

            holder.link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(workoutModelArrayList.get(position).getVideo()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return workoutModelArrayList.size();
    }

}


