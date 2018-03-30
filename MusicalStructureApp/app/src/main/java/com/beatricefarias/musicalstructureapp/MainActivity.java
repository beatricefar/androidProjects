package com.beatricefarias.musicalstructureapp;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Playlist");
        setContentView(R.layout.activity_main);


        // create an array list of the songs and artists
        ArrayList<Song> listOfSongs = new ArrayList<Song>();
        listOfSongs.add(new Song("Pink Floyd", "Song name 1", "Album Name 1", R.drawable.album_1));
        listOfSongs.add(new Song("Pink Floyd", "Song name 2", "Album Name 2", R.drawable.album_2));
        listOfSongs.add(new Song("Pink Floyd", "Song name 1", "Album Name 1", R.drawable.album_1));
        listOfSongs.add(new Song("Pink Floyd", "Song name 2", "Album Name 2", R.drawable.album_2));

        SongAdapter adapter = new SongAdapter(this, listOfSongs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Song currentSong = listOfSongs.get(position);
            }
        });

    }
}
