package com.example.submissionexpert2.TvShow;

import androidx.lifecycle.ViewModel;

import com.example.submissionexpert2.gas.MovieModel;

import java.util.ArrayList;

public class TvShowModel extends ViewModel {
    private ArrayList<MovieModel> models = new ArrayList<>();

    public void addTvShowModel(String name, String description, Integer photo){
        this.models.add(new MovieModel(name, description, photo));
    }

    public ArrayList<MovieModel> getTvShow() {
        return models;
    }
}
