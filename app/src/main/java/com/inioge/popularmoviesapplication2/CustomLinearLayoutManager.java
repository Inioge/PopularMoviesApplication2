package com.inioge.popularmoviesapplication2;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by ADMIN on 22/06/2017.
 */
public class CustomLinearLayoutManager extends LinearLayoutManager {

    public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
}