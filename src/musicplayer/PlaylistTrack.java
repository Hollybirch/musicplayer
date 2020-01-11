package musicplayer;

//Playlisttrack is a subclass that extends the superclass
public class PlaylistTrack extends Track {

    public Album album;

    //Constructor referencing the superclass and album
    public PlaylistTrack(String songName, Duration duration,
            Album album) {

        super(songName, duration);
        this.album = album;
    }

    @Override
    public String toString() {
        return this.getSong() + ":" + album.getHeader() + ":";
    }
}
