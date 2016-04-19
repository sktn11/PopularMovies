package com.example.android.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsActivityFragment extends Fragment {

    public DetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        if(intent != null && intent.hasExtra(getString(R.string.EXTRA_MOVIE_ITEM))) {
            MovieItem movieItem = intent.getParcelableExtra(getString(R.string.EXTRA_MOVIE_ITEM));
            ((TextView) rootView.findViewById(R.id.movie_original_title))
                    .setText(movieItem.getOriginalTitle());
            ((TextView) rootView.findViewById(R.id.movie_release_date))
                    .setText(movieItem.getReleaseDate());
            String voteAverage = "TMDB: " + String.valueOf(movieItem.getVoteAverage()) + " / 10";
            ((TextView) rootView.findViewById(R.id.movie_vote_average))
                    .setText(voteAverage);
            ((TextView) rootView.findViewById(R.id.movie_overview))
                    .setText(movieItem.getOverview());

            ImageView posterView = ((ImageView) rootView.findViewById(R.id.movie_poster));
            String posterPath = movieItem.getPosterPath();
            Picasso.with(getActivity()).load(getString(R.string.tmdb_image_url) + posterPath).into(posterView);
        }

        return rootView;
    }
}
