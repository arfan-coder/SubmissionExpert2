package com.example.submissionexpert2.movie;

import androidx.lifecycle.ViewModel;

import com.example.submissionexpert2.gas.MovieModel;

import java.util.ArrayList;

public class MovieView extends ViewModel {
    private ArrayList<MovieModel> movieModels = new ArrayList<>();

    public void addMovieModel(String name, String description, Integer photo){
        this.movieModels.add(new MovieModel(name, description, photo));
    }

    public ArrayList<MovieModel> getMovieModels(){
        return movieModels;
    }
}
