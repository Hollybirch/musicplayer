package musicplayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MP3Player {

    private String filename;
    private Player player;

    FileInputStream fis;
    BufferedInputStream bis;

    public long pausePoint;
    public long trackTotalLength;
    public String location;

    //Default Constructor
    public MP3Player() {
    }

    //Constructor takes a given file name 
    public MP3Player(String filename) {
        this.filename = filename;
    }

    public void stop() {
        if (player != null) {
            player.close();
            pausePoint = 0;
            trackTotalLength = 0;
            MusicPlayer.SongNameDisplay.setText("");
        }
    }

    public void pause() {
        if (player != null) {
            try {
                pausePoint = fis.available();
                player.close();
            } catch (IOException e) {
            }
        }
    }

    public void play(String filename) {
        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
            trackTotalLength = fis.available();
            location = filename + "";
        } catch (FileNotFoundException | JavaLayerException e) {
            System.out.println("Problem in playing: " + filename);
            System.out.println(e);
        } catch (IOException ex) {
        }

        //Create a thread to play music in background
        new Thread() {
            @Override
            public void run() {
                try {
                    player.play();
                    if (player.isComplete() && MusicPlayer.count == 1) {
                        play(location);
                    }
                    if (player.isComplete()) {
                        MusicPlayer.SongNameDisplay.setText("");
                    }
                } catch (JavaLayerException e) {
                    System.out.println(e);
                }
            }
        }.start();
    }

    public void resume() {
        try {
            fis = new FileInputStream(location);
            fis.skip(trackTotalLength - pausePoint); //moved this above bis (track was playing a snippet of the beginning of song, then continuing from pause point)
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (FileNotFoundException | JavaLayerException e) {
            System.out.println("Problem in resuming song");
            System.out.println(e);
        } catch (IOException ex) {
        }

        //Create a thread to play music in background
        new Thread() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    System.out.println(e);
                }
            }
        }.start();
    }
}
