package musicplayer;

public class Track implements Comparable<Track> {
    //Declaring variable and type

    private String songName;
    private Duration duration;

    public Track(String songName, Duration duration) {
        //Constructor initialising variables
        this.songName = songName;
        this.duration = duration;
    }
    //Moved this from AlbumInfoProgram to Track class

    public Track(String line) {
        String[] split = line.split(" - ");
        songName = split[1];
        duration = new Duration(split[0]);

    }

    public Duration getDuration() {
        return duration;
    }

    //Creating method that will be able to get the songname
    public String getSong() {

        return this.songName;
    }

    @Override
//Returns both the songname and the duration
    public String toString() {

        return songName + " " + duration;
    }

    @Override
    public int compareTo(Track d2) {
        return this.duration.compareTo(d2.duration);
    }

}
