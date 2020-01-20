package com.example.submissionexpert2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.submissionexpert2.TvShow.TvShowFragment;
import com.example.submissionexpert2.movie.MovieFragment;

public class SectionsAdapter extends FragmentPagerAdapter {

    private static final int[] TAB_TITLES = new int[]{R.string.tab1, R.string.tab2};
    private Context context;
    private MovieFragment movieFragment;
    private TvShowFragment tvShowFragment;


    public SectionsAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        movieFragment = new MovieFragment();
        tvShowFragment = new TvShowFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MovieFragment();
            case 1:
                return new TvShowFragment();
            default:
                return null;

        }
    }

    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
