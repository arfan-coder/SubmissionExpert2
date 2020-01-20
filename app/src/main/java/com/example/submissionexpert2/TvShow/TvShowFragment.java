package com.example.submissionexpert2.TvShow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.submissionexpert2.ListMovie;
import com.example.submissionexpert2.R;
import com.example.submissionexpert2.adapter.WatchAdapter;
import com.example.submissionexpert2.detail.DetailMovie;
import com.example.submissionexpert2.gas.MovieModel;

public class TvShowFragment extends Fragment {
    private TvShowModel model;
    private WatchAdapter tvadapter;

    public static TvShowFragment newInstance() {
        return new TvShowFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle SavedInstanceState) {
        return inflater.inflate(R.layout.activity_tv_show, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.TvRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        model = ViewModelProviders.of(this).get(TvShowModel.class);

        model.addTvShowModel(getResources().getString(R.string.tv_title_arrow), getResources().getString(R.string.tv_desc_arrow), R.drawable.arrow);
        model.addTvShowModel(getResources().getString(R.string.tv_title_doom_patrol), getResources().getString(R.string.tv_desc_doom_patrol), R.drawable.dommpatrol);
        model.addTvShowModel(getResources().getString(R.string.tv_title_dragon_ball), getResources().getString(R.string.tv_desc_dragon_ball), R.drawable.dragonball);
        model.addTvShowModel(getResources().getString(R.string.tv_title_fairytail), getResources().getString(R.string.tv_desc_fairytail), R.drawable.fairytale);
        model.addTvShowModel(getResources().getString(R.string.tv_title_family_guy), getResources().getString(R.string.tv_desc_family_guy), R.drawable.familyguy);
        model.addTvShowModel(getResources().getString(R.string.tv_title_flash), getResources().getString(R.string.tv_desc_flash), R.drawable.flash);
        model.addTvShowModel(getResources().getString(R.string.tv_title_god), getResources().getString(R.string.tv_desc_god), R.drawable.gameofthrones);
        model.addTvShowModel(getResources().getString(R.string.tv_title_gotham), getResources().getString(R.string.tv_desc_gotham), R.drawable.gotham);
        model.addTvShowModel(getResources().getString(R.string.tv_title_grey_anatomy), getResources().getString(R.string.tv_desc_grey_anatomy), R.drawable.gray);
        model.addTvShowModel(getResources().getString(R.string.tv_title_hanna), getResources().getString(R.string.tv_desc_hanna), R.drawable.hanna);

        tvadapter = new WatchAdapter(view.getContext(), model.getTvShow());
        recyclerView.setAdapter(tvadapter);
        recyclerView.setHasFixedSize(true);

        tvadapter.setOnItemClickListener(new WatchAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, MovieModel movieModel) {
                Intent detail = new Intent(view.getContext(), DetailMovie.class);
                detail.putExtra(ListMovie.SELECTED_MOVIE, movieModel);
                startActivity(detail);
            }
        });
    }
}
