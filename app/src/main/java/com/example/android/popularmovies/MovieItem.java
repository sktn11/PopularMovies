package com.example.android.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sarthak on 17/4/16.
 */
public class MovieItem implements Parcelable {

    private String OriginalTitle;
    private String PosterPath;
    private String BackdropPath;
    private String Overview;
    private Double VoteAverage;
    private String ReleaseDate;

    public MovieItem(String title, String posterPath, String backdropPath, String overview,
                     Double voteAverage, String releaseDate) {
        this.OriginalTitle = title;
        this.PosterPath = posterPath;
        this.BackdropPath = backdropPath;
        this.Overview = overview;
        this.VoteAverage = voteAverage;
        this.ReleaseDate = releaseDate;
    }

    public MovieItem(Parcel parcel) {
        this.OriginalTitle = parcel.readString();
        this.PosterPath = parcel.readString();
        this.BackdropPath = parcel.readString();
        this.Overview = parcel.readString();
        this.VoteAverage = parcel.readDouble();
        this.ReleaseDate = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.OriginalTitle);
        dest.writeString(this.PosterPath);
        dest.writeString(this.BackdropPath);
        dest.writeString(this.Overview);
        dest.writeDouble(this.VoteAverage);
        dest.writeString(this.ReleaseDate);
    }

    public static final Parcelable.Creator<MovieItem> CREATOR = new Parcelable.Creator<MovieItem>() {
        @Override
        public MovieItem createFromParcel(Parcel parcel) {
            return new MovieItem(parcel);
        }

        @Override
        public MovieItem[] newArray(int i) {
            return new MovieItem[i];
        }
    };

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public String getPosterPath() {
        return PosterPath;
    }

    public String getBackdropPath() {
        return BackdropPath;
    }

    public String getOverview() {
        return Overview;
    }

    public Double getVoteAverage() {
        return VoteAverage;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }
}
