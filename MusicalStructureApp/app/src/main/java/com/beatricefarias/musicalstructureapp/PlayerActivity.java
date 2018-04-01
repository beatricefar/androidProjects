package com.beatricefarias.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        setTitle(R.string.player_activity_title);

        setPlayingSong();
    }

    /**
     * Method which sets a currently playing song
     * which should be set to a song which user last clicked on the list in previous activity.
     */

    public void setPlayingSong(){
        Intent currentSong = getIntent();
        Song playingSong = (Song) currentSong.getParcelableExtra("song");

        TextView artistTextView = (TextView) findViewById(R.id.artist);
        artistTextView.setText(playingSong.getArtistName());

        TextView songTextView = (TextView) findViewById(R.id.song);
        songTextView.setText(playingSong.getSong());

        ImageView albumCover = (ImageView) findViewById(R.id.album_cover);
        albumCover.setImageResource(playingSong.getImageId());
    }
}
