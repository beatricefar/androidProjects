package com.beatricefarias.musicalstructureapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable{
    private String artistName;
    private String song;
    private String album;
    private int imageId;

    public Song(String artistName, String song, String album, int imageId) {
        this.artistName = artistName;
        this.song = song;
        this.album = album;
        this.imageId = imageId;
    }

    /**
     * Method which gets artist's name.
     * @return String of an artist name.
     */

    public String getArtistName() {
        return artistName;
    }

    /**
     * Method which gets song.
     * @return String of a song.
     */

    public String getSong() {
        return song;
    }

    /**
     * Method which gets album's title.
     * @return String of an album.
     */

    public String getAlbum() {
        return album;
    }

    /**
     * Method which gets album cover's image Id.
     * @return int ID of an album cover image.
     */

    public int getImageId() {
        return imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.artistName);
        dest.writeString(this.song);
        dest.writeString(this.album);
        dest.writeInt(this.imageId);
    }

    protected Song(Parcel in) {
        this.artistName = in.readString();
        this.song = in.readString();
        this.album = in.readString();
        this.imageId = in.readInt();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}
