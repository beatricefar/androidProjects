package com.beatricefarias.musicalstructureapp;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit test which creates a song object and as if object getter methods
 * return same values as when object was created.
 */
public class SongObjectUnitTest {

    @Test
    public void songMethodsShouldReturnCorrectValues() throws Throwable {
        String artist = "Pink Floyd";
        String song = "Eclipse";
        String album = "Dark Side of the Moon";
        int albumCoverId = R.drawable.album_dark_side;

        Song mySong = new Song(artist, song, album, albumCoverId);

        assertEquals(artist, mySong.getArtistName());
        assertEquals(song, mySong.getSong());
        assertEquals(album, mySong.getAlbum());
        assertEquals(albumCoverId, mySong.getImageId());

    }
}
