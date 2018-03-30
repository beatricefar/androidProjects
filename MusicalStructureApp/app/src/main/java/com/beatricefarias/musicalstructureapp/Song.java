package com.beatricefarias.musicalstructureapp;

/**
 * Created by beatrice.farias on 29/03/2018.
 */

public class Song {
    private String artistName;
    private String song;
    private String album;
    private int imageId;

    public Song(String artistName, String song, String album, int imageId){
            this.artistName = artistName;
            this.song = song;
            this.album = album;
            this.imageId = imageId;
        }

    public String getArtistName() {
        return artistName;
    }

    public String getSong() {
        return song;
    }

    public String getAlbum() {
        return album;
    }

    public int getImageId() {
        return imageId;
    }
}
