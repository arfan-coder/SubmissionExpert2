package com.example.submissionexpert2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submissionexpert2.R;
import com.example.submissionexpert2.gas.MovieModel;

import java.util.ArrayList;

public class WatchAdapter extends RecyclerView.Adapter<WatchAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MovieModel> models;

    private OnItemClickListener movieonItemClickListener;

    public WatchAdapter(Context context, ArrayList<MovieModel> models) {
        this.context = context;
        this.models = models;
    }

    public void updateList(ArrayList<MovieModel> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            final MovieModel model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.name.setText(model.getName());

            if (model.getDescription().length() > 50) {
                genericViewHolder.description.setText(model.getDescription().substring(0, 49) + "....");
            } else {
                genericViewHolder.description.setText(model.getDescription());
            }

            genericViewHolder.photo.setImageResource(model.getPhoto());
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public interface OnItemClickListener {
        void OnItemClick(View view, int position, MovieModel movieModel);
    }

    public void setOnItemClickListener(final OnItemClickListener movieonItemClickListener) {
        this.movieonItemClickListener = movieonItemClickListener;
    }

    private MovieModel getItem(int position) {
        return models.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, description;
        private ImageView photo;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.listName);
            description = itemView.findViewById(R.id.listDesc);
            photo = itemView.findViewById(R.id.listImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieonItemClickListener.OnItemClick(itemView, getAdapterPosition(), models.get(getAdapterPosition()));
                }
            });
        }
    }
}
