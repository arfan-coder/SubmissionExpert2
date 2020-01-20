package com.example.submissionexpert2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submissionexpert2.adapter.WatchAdapter;
import com.example.submissionexpert2.detail.DetailMovie;
import com.example.submissionexpert2.gas.MovieModel;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private WatchAdapter adapter;
    private ArrayList<MovieModel> movieModels = new ArrayList<>();
    public static final String SELECTED_MOVIE = "selected movie";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
        setAdapter();
    }

    private void findViews() {
        recyclerView = findViewById(R.id.movieRecycler);
    }

    private void setAdapter() {
        movieModels.add(new MovieModel(getResources().getString(R.string.title_aquaman), getResources().getString(R.string.desc_aquaman), R.drawable.aquaman));
        movieModels.add(new MovieModel(getResources().getString(R.string.title_avenger), getResources().getString(R.string.desc_avenger), R.drawable.avenger));
        movieModels.add(new MovieModel(getResources().getString(R.string.title_birdbox), getResources().getString(R.string.desc_birdbox), R.drawable.birdbbox));
        movieModels.add(new MovieModel(getResources().getString(R.string.title_creed), getResources().getString(R.string.desc_creed), R.drawable.creed));
        movieModels.add(new MovieModel(getResources().getString(R.string.title_deadpool2), getResources().getString(R.string.desc_deadpool), R.drawable.deadpool2));
        movieModels.add(new MovieModel(getResources().getString(R.string.title_httyd2), getResources().getString(R.string.desc_httyd), R.drawable.dragon));
        movieModels.add(new MovieModel(getResources().getString(R.string.title_robin), getResources().getString(R.string.desc_robin), R.drawable.robin));
        movieModels.add(new MovieModel(getResources().getString(R.string.title_spiderman), getResources().getString(R.string.desc_spiderman), R.drawable.spiderman));
        movieModels.add(new MovieModel(getResources().getString(R.string.title_star), getResources().getString(R.string.desc_star), R.drawable.star));
        movieModels.add(new MovieModel(getResources().getString(R.string.title_venom2), getResources().getString(R.string.desc_venom), R.drawable.venom));

        adapter = new WatchAdapter(ListMovie.this, movieModels);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setOnItemClickListener(new WatchAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, MovieModel movieModel) {
                Intent detailintent = new Intent(ListMovie.this, DetailMovie.class);
                detailintent.putExtra(ListMovie.SELECTED_MOVIE, movieModel);
                startActivity(detailintent);
            }
        });
    }
}
