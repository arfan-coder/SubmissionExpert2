package com.example.submissionexpert2.movie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.submissionexpert2.ListMovie;
import com.example.submissionexpert2.gas.MovieModel;
import com.example.submissionexpert2.R;
import com.example.submissionexpert2.adapter.WatchAdapter;
import com.example.submissionexpert2.detail.DetailMovie;

public class MovieFragment extends Fragment {
    private MovieView movieModel;
    private WatchAdapter watchAdapter;

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_movie_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.movieRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        movieModel = ViewModelProviders.of(this).get(MovieView.class);

        movieModel.addMovieModel(getResources().getString(R.string.title_aquaman), getResources().getString(R.string.desc_aquaman), R.drawable.aquaman);
        movieModel.addMovieModel(getResources().getString(R.string.title_avenger), getResources().getString(R.string.desc_avenger), R.drawable.avenger);
        movieModel.addMovieModel(getResources().getString(R.string.title_birdbox), getResources().getString(R.string.desc_birdbox), R.drawable.birdbbox);
        movieModel.addMovieModel(getResources().getString(R.string.title_creed), getResources().getString(R.string.desc_creed), R.drawable.creed);
        movieModel.addMovieModel(getResources().getString(R.string.title_deadpool2), getResources().getString(R.string.desc_deadpool), R.drawable.deadpool2);
        movieModel.addMovieModel(getResources().getString(R.string.title_httyd2), getResources().getString(R.string.desc_httyd), R.drawable.dragon);
        movieModel.addMovieModel(getResources().getString(R.string.title_robin), getResources().getString(R.string.desc_robin), R.drawable.robin);
        movieModel.addMovieModel(getResources().getString(R.string.title_spiderman), getResources().getString(R.string.desc_spiderman), R.drawable.spiderman);
        movieModel.addMovieModel(getResources().getString(R.string.title_star), getResources().getString(R.string.desc_star), R.drawable.star);
        movieModel.addMovieModel(getResources().getString(R.string.title_venom2), getResources().getString(R.string.desc_venom), R.drawable.venom);

        watchAdapter = new WatchAdapter(view.getContext(), movieModel.getMovieModels());
        recyclerView.setAdapter(watchAdapter);
        recyclerView.setHasFixedSize(true);

        watchAdapter.setOnItemClickListener(new WatchAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, MovieModel movieModel) {
                Intent detail = new Intent(view.getContext(), DetailMovie.class);
                detail.putExtra(ListMovie.SELECTED_MOVIE,movieModel);
                startActivity(detail);
            }
        });
    }
}
