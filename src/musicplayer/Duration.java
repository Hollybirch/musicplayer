package musicplayer;

import java.text.DecimalFormat;

public class Duration implements Comparable<Duration> {

    //default java class, timeformat is labelled variable making 
    //a new decimal format object
    private static DecimalFormat timeformat = new DecimalFormat("00");
    // declaring integer variables
    private int hours;
    private int minutes;
    private int seconds;

    public Duration() {
        // default constructor giving variables the value of zero
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public Duration(int hours, int minutes, int seconds) {
        //constructor initialising variables
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        reformat();
    }

    public Duration(String duration) {
        //String that splits on :
        String array[] = duration.split(":");
        //passes the string into integers and positions 
        //this in the array
        hours = Integer.parseInt(array[0]);
        minutes = Integer.parseInt(array[1]);
        seconds = Integer.parseInt(array[2]);
        reformat();
    }

    //Creating a method to get the hours using the decimal format
    public int getHours() {

        return hours;
    }

    //Creating a method to get the minutes using the decimal format
    public int getMinutes() {

        return minutes;
    }

    //Creating a method to get the seconds using the decimal format
    public int getSeconds() {

        return seconds;

    }

    @Override
    public String toString() {
        //Creating a string using the hours, minutes and seconds 
        //Have updated previous code to format duration at the end-point without converting to string

        return timeformat.format(hours) + ":" + timeformat.format(minutes) + ":" + timeformat.format(seconds);
    }

    //Creating a method to add durations
    public void add(Duration d2) {

        //Optimised add method. With the reformat method implemented, any 
        //exceptions thrown are dealt with. This saves having to implement 
        //multiple loops to keep format correct.    
        this.hours += d2.hours;
        this.minutes += d2.minutes;
        this.seconds += d2.seconds;
        reformat();
    }

    //Compares the hours, miutes and seconds of each track in order to 
    //work out which track is the longest in the AlbumInfoProgram
    //Have now optimised this. Instead of comparing the hours, minutes 
    //and seconds independently I am now using the toSeconds method to 
    //convert total duration to seconds and just compare the integers.
    @Override
    public int compareTo(Duration d2) {
        return Integer.compare(this.toSeconds(), d2.toSeconds());
    }

    //This method to be used in reformat method
    //Makes things easier by converting entire duration to seconds
    //before reformatting it appropriately
    public int toSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    //Added reformat method to optimise constructors in this class
    //Allows any format of duration to be entered
    //This method will then reformat duration correctly
    private void reformat() {
        int totalSeconds = toSeconds();
        hours = totalSeconds / 3600;
        minutes = (totalSeconds % 3600) / 60;
        seconds = totalSeconds % 60;
    }

}
