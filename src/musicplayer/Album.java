package musicplayer;

import java.util.ArrayList;

public class Album implements Comparable<Album> {
    //declaring variable and type

    private String artistName;
    private String albumTitle;
    private ArrayList<Track> albumSongs;

    //compareTo method to order albums by artist name if these 
    //are the same it orders by album name
    @Override
    public int compareTo(Album a) {

        if (artistName.equals(a.artistName)) {
            return albumTitle.compareTo(a.getAlbumTitle());
        } else {
            return artistName.compareTo(a.getArtistName());
        }
    }

    //constructor with variables and empty array list
    public Album(String title, String artistName) {

        this.albumTitle = title;
        this.artistName = artistName;
        this.albumSongs = new ArrayList<Track>();

    }

    //Moved this from AlbumInfoProgram to Album class
    public static Album makeNewAlbum(String line) {
        String[] albumInfo = line.split(" : ");
        //this.artistName = albumInfo[0];
        //this.albumTitle = albumInfo[1];
        //this.albumSongs = new ArrayList<>();
        Album album = new Album(albumInfo[1], albumInfo[0]);
        return album;
    }

    //method to add tracks to the array list
    public void addTrackToAlbum(Track track) {

        this.albumSongs.add(track);
    }

    //loops through tracks to check if the songname is the same
    public Track findTrack(String songname) {

        for (Track track : albumSongs) {
            if (track.getSong().equals(songname)) {
                return track;
            }
        }
        return null;

    }

    public ArrayList<Track> getAlbumsongs() {
        return albumSongs;

    }

    //creating method to get the album title
    public String getAlbumTitle() {

        return this.albumTitle;
    }

    //creating method to get the artist name
    public String getArtistName() {

        return this.artistName;
    }

    //Returns the album title and artist string and track number
    //Loops through tracks adding them to the album
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(getHeader());
        for (Track track : albumSongs) {
            sb.append("\n" + track);
        }

        return sb.toString();

    }

    //implemented from lecture
    public String getHeader() {
        return artistName + " : " + albumTitle;

    }

}
