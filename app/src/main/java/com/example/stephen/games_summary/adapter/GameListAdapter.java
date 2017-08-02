package com.example.stephen.games_summary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stephen.games_summary.R;
import com.example.stephen.games_summary.model.Request;
import com.example.stephen.games_summary.model.Result;
import com.squareup.picasso.Picasso;

/**
 * Created by Stephen on 01/08/2017.
 */

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameListViewHolder> {

    private final Context context;
    private final Request request;


    public GameListAdapter(Context context, Request request) {
        this.context = context;
        this.request = request;
    }

    @Override
    public GameListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_game, parent, false);
        return new GameListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameListViewHolder holder, int position) {

        Result result = request.getResults().get(position);


        Picasso.with(this.context).cancelRequest(holder.game_poster);

        //Some results don't have images unfortunately, so this handles that exception
        if (result.getImage() != null) {

            //In the event the URL is malformed, the placeholder is used instead
            try {
                Picasso.with(context)
                        .load(result.getImage().getMediumUrl())
                        .fit()
                        .into(holder.game_poster);
            } catch (Exception e) {
                holder.game_poster.setImageResource(R.drawable.missing_visual);
            }
        } else {
            holder.game_poster.setImageResource(R.drawable.missing_visual);
        }


        holder.game_title.setText(result.getName());
        holder.game_blurb.setText(result.getDeck());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, result.getName() + " with ID " + result.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return request.getResults().size();
    }

    public class GameListViewHolder extends RecyclerView.ViewHolder {

        View view;
        TextView game_title;
        TextView game_blurb;
        ImageView game_poster;

        public GameListViewHolder(View view) {
            super(view);

            this.view = view;
            game_title = view.findViewById(R.id.tv_game_title);
            game_blurb = view.findViewById(R.id.tv_game_blurb);
            game_poster = view.findViewById(R.id.img_game_poster);
        }
    }
}
