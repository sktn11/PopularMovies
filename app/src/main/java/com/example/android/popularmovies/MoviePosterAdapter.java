package com.example.android.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sarthak on 17/4/16.
 */
public class MoviePosterAdapter extends ArrayAdapter<MovieItem> {

    private final String LOG_TAG = MoviePosterAdapter.class.getSimpleName();

    public MoviePosterAdapter(Context context, List<MovieItem> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieItem movieItem = getItem(position);
        Context context = getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.grid_item_movie_poster, parent, false);
        ImageView moviePosterView = (ImageView) rootView.findViewById(R.id.grid_item_movie_poster);
        ImageView movieBackdropView = (ImageView) rootView.findViewById(R.id.grid_item_movie_poster);
        String PosterURL = context.getString(R.string.tmdb_image_url)
                .concat(movieItem.getPosterPath());
        Picasso.with(context).load(PosterURL).into(moviePosterView);
        return rootView;
    }
}