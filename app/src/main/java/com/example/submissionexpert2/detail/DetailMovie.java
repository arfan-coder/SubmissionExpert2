package com.example.submissionexpert2.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submissionexpert2.ListMovie;
import com.example.submissionexpert2.R;
import com.example.submissionexpert2.gas.MovieModel;

public class DetailMovie extends AppCompatActivity {
    TextView name, description;
    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        name = findViewById(R.id.detailname);
        description = findViewById(R.id.detaildescription);
        photo = findViewById(R.id.detailImage);

        MovieModel movieModel = getIntent().getParcelableExtra(ListMovie.SELECTED_MOVIE);
        name.setText(movieModel.getName());
        description.setText(movieModel.getDescription());
        photo.setImageResource(movieModel.getPhoto());
        setTitle(movieModel.getName());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onSupportNavigetUp() {
        finish();
        return true;
    }
}
