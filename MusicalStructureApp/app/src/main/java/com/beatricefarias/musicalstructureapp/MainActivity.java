package com.beatricefarias.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.main_activity_title);
        setContentView(R.layout.activity_main);

        final ArrayList<Song> listOfSongs = new ListOfSongs(this).getListOfSongs();
        SongAdapter adapter = new SongAdapter(this, listOfSongs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Song currentSong = listOfSongs.get(position);
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("song", currentSong);
                startActivity(intent);
            }
        });
    }
}
