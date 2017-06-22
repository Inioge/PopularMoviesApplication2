package com.inioge.popularmoviesapplication2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inioge.popularmoviesapplication2.callbacks.TrailerAdapterCallBack;
import com.inioge.popularmoviesapplication2.movie_model.Trailer;

import java.util.ArrayList;

/**
 * Created by ADMIN on 22/06/2017.
 */
public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.ViewHolder> {

    private final ArrayList<Trailer> trailers;
    private final TrailerAdapterCallBack adapterCallBack;

    public TrailerAdapter(ArrayList<Trailer> trailers, TrailerAdapterCallBack callback) {
        this.trailers = trailers;
        this.adapterCallBack = callback;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trailer_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Trailer trailer = trailers.get(position);
        holder.trailer = trailer;
        holder.trailerName.setText(trailer.getName());
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        Trailer trailer;
        final TextView trailerName;

        ViewHolder(View itemView) {
            super(itemView);
            trailerName = (TextView) itemView.findViewById(R.id.trailer_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapterCallBack.onItemClickListener(trailer.getKey());
                }
            });
        }

    }
}
