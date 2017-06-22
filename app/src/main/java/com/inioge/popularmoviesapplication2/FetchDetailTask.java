package com.inioge.popularmoviesapplication2;

import android.net.Uri;
import android.os.AsyncTask;

import com.inioge.popularmoviesapplication2.callbacks.MovieDetailsCallBack;
import com.inioge.popularmoviesapplication2.movie_model.Movies;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ADMIN on 22/06/2017.
 */
public class FetchDetailTask extends AsyncTask<Movies,Void,Movies> {

    private final MovieDetailsCallBack detailMovieCallback;

    public FetchDetailTask(MovieDetailsCallBack detailMovieCallback) {
        this.detailMovieCallback = detailMovieCallback;
    }

    @Override
    protected Movies doInBackground(Movies... movies) {
        if (movies.length == 0) {
            return null;
        }

        final String BASE_URL = "https://api.themoviedb.org/3/movie/";
        final String API_KEY = "api_key";

        Uri uri = Uri.parse(BASE_URL).buildUpon()
                .appendEncodedPath(String.valueOf(movies[0].getMovieId()))
                .appendQueryParameter(API_KEY, BuildConfig.API_KEY)
                .build();

        String jsonString = NetworkRequest.getJsonString(uri);

        try {
            return getMovieFromJson(jsonString, movies[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }


    private Movies getMovieFromJson(String jsonString, Movies movie) throws JSONException {
        final String MOVIE_RUNTIME = "runtime";
        if (jsonString == null || "".equals(jsonString)) {
            return null;
        }

        JSONObject jsonObjectMovie = new JSONObject(jsonString);
        movie.setMovieRuntime(jsonObjectMovie.getString(MOVIE_RUNTIME));
        return movie;
    }

    @Override
    protected void onPostExecute(Movies movie) {
        if (movie != null) {
            detailMovieCallback.updateMovie(movie);
        }
    }
}