package com.inioge.popularmoviesapplication2.callbacks;

import com.inioge.popularmoviesapplication2.movie_model.Review;

/**
 * Created by ADMIN on 22/06/2017.
 */
public interface ReviewCallBack {
    void updateAdapter(Review[] reviews);
}