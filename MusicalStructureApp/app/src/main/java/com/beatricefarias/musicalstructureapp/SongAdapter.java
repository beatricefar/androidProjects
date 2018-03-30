package com.beatricefarias.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by beatrice.farias on 29/03/2018.
 */

public class SongAdapter extends ArrayAdapter<Song>{

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView; // initialise recycler view
        if (listItemView == null) { // if there are no views to recycle, inflate a view
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist);
        artistTextView.setText(currentSong.getArtistName());

        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album);
        albumTextView.setText(currentSong.getAlbum());

        TextView songTextView = (TextView) listItemView.findViewById(R.id.song);
        songTextView.setText(currentSong.getSong());

        ImageView albumCover = (ImageView) listItemView.findViewById(R.id.album_cover);
        albumCover.setImageResource(currentSong.getImageId());

        Log.v("artist text view: ", currentSong.getArtistName());

        return listItemView;
    }
}
