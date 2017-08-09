package com.example.stephen.games_summary.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stephen.games_summary.fragment.GameFragment;
import com.example.stephen.games_summary.R;
import com.example.stephen.games_summary.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Stephen on 01/08/2017.
 */

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameListViewHolder> {

    private final Activity activity;
    private final List<Result> results;
    private final List<Integer> bookmarks;

    //private List<Integer> ids = new ArrayList<>();

    public GameListAdapter(Activity activity, List<Result> results, List<Integer> bookmarks) {
        this.activity = activity;
        this.results = results;
        this.bookmarks = bookmarks;
    }

    @Override
    public GameListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(activity).inflate(R.layout.item_game, parent, false);
        return new GameListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameListViewHolder holder, int position) {

        if (results != null && results.size() > 0) {
            Result result = results.get(position);

            Picasso.with(this.activity).cancelRequest(holder.game_poster);

            //Some results don't have images unfortunately, so this handles that exception
            if (result.getImage() != null) {

                //In the event the URL is malformed, the placeholder is used instead
                try {
                    Picasso.with(activity)
                            .load(result.getImage().getSmallUrl())
                            .centerCrop()
                            .fit()
                            .into(holder.game_poster);
                } catch (Exception e) {
                    holder.game_poster.setImageResource(R.drawable.missing_visual);
                }
            } else {
                holder.game_poster.setImageResource(R.drawable.missing_visual);
            }

            if (bookmarks != null && bookmarks.contains(result.getId())) {
                holder.game_bookmark.setVisibility(View.VISIBLE);
            } else {
                holder.game_bookmark.setVisibility(View.INVISIBLE);
            }

            holder.game_title.setText(result.getName());
            holder.game_blurb.setText(result.getDeck());
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class GameListViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        View view;
        TextView game_title;
        TextView game_blurb;
        ImageView game_poster;
        ImageView game_bookmark;

        public GameListViewHolder(View view) {
            super(view);

            this.view = view;
            game_title = view.findViewById(R.id.tv_game_title);
            game_blurb = view.findViewById(R.id.tv_game_blurb);
            game_poster = view.findViewById(R.id.img_game_poster);
            game_bookmark = view.findViewById(R.id.img_bookmark);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),
                    results.get(getAdapterPosition()).getName(),
                    Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putInt("id", results
                    .get(getAdapterPosition())
                    .getId());

            Fragment gameFragment = new GameFragment();
            gameFragment.setArguments(bundle);

            activity.getFragmentManager().beginTransaction()
                    .replace(R.id.main_container, gameFragment)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }
    }
}
