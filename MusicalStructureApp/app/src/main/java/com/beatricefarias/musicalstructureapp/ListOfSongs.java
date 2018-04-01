package com.beatricefarias.musicalstructureapp;

import android.content.Context;

import java.util.ArrayList;

public class ListOfSongs extends ArrayList<Song> {

    private ArrayList<Song> listOfSongs;
    private Context context;

    /**
     * Constructor to create an array list and context.
     * @param context
     */

    public ListOfSongs(Context context) {
        listOfSongs = new ArrayList<Song>();
        this.context = context;
    }

    /**
     * Method which creates adds songs into listOfSongs array list.
     * @param listOfSongs
     * @return array list of songs
     */

    private ArrayList<Song> createArrayList(ArrayList<Song> listOfSongs) {
        listOfSongs.add(new Song(context.getString(R.string.artist_1), context.getString(R.string.song_1),
                context.getString(R.string.album_1), R.drawable.album_are_you_experienced));
        listOfSongs.add(new Song(context.getString(R.string.artist_2), context.getString(R.string.song_2),
                context.getString(R.string.album_2), R.drawable.album_awesome_wave));
        listOfSongs.add(new Song(context.getString(R.string.artist_3), context.getString(R.string.song_3),
                context.getString(R.string.album_3), R.drawable.album_californication));
        listOfSongs.add(new Song(context.getString(R.string.artist_4), context.getString(R.string.song_4),
                context.getString(R.string.album_4), R.drawable.album_dark_side));
        listOfSongs.add(new Song(context.getString(R.string.artist_5), context.getString(R.string.song_5),
                context.getString(R.string.album_5), R.drawable.album_dark_side));
        listOfSongs.add(new Song(context.getString(R.string.artist_6), context.getString(R.string.song_6),
                context.getString(R.string.album_6), R.drawable.album_awesome_wave));

        return listOfSongs;
    }

    /**
     * Method which returns an ArrayList of Song objects.
     * @return
     */

    public ArrayList<Song> getListOfSongs() {
        return createArrayList(listOfSongs);
    }
}
