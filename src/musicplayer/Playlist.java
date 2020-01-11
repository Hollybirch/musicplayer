package musicplayer;

import static musicplayer.MusicPlayer.jListSongDisplay;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class Playlist {

    DefaultListModel<String> listModel2 = new DefaultListModel<>();
    DefaultListModel<String> playlistModel = new DefaultListModel<>();
    DefaultListModel<String> playlistInfoModel = new DefaultListModel<>();
    private ArrayList<Track> listmodel2tracks = new ArrayList<>();
    private ArrayList<String> playlistmodel2tracks = new ArrayList<>();
    private Album currentlySelectedAlbum;
    MP3Player mp3 = new MP3Player();
    private AlbumCollection albumCollection;
    public ArrayList<PlaylistTrack> playlistTracks;

//A constructor that initialises variables and empty array list
    public Playlist(AlbumCollection albumCollection) {

        this.playlistTracks = new ArrayList<PlaylistTrack>();
        this.albumCollection = albumCollection;
    }

//Creating a method to add tracks to the playlist
    public void addPlaylistTrack(PlaylistTrack playlisttracks) {

        this.playlistTracks.add(playlisttracks);
    }

    //Splits each line of the file on brackets and : and puts songname, 
    //artistname and albumname into an array. 
    public void addTrackToPlaylist(String line) {

        String[] playlistTracks = line.split(" \\(");
        String[] playlistInfo = playlistTracks[1].split(" : ");
        String[] playlistAlbum = playlistInfo[1].split("\\)");

        String songName = playlistTracks[0];
        String artistname = playlistInfo[0];
        String albumname = playlistAlbum[0];

        //Calls find album method checking artist and album match
        Album albumContainingSong = this.albumCollection.
                findAlbum(artistname, albumname);

        if (albumContainingSong != null) {

            Track foundTrack = albumContainingSong.
                    findTrack(songName);

            if (foundTrack != null) {
                PlaylistTrack newPlaylistTrack
                        = new PlaylistTrack(foundTrack.getSong(),
                                foundTrack.getDuration(),
                                albumContainingSong);
                this.addPlaylistTrack(newPlaylistTrack);
            }

        }
    }

    public void getPlaylist(String filename, String displayedFilename) throws FileNotFoundException, IOException {
        //Reading in the file
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String currentLine;
        //Declaring Playlist variable
        Playlist currentPlaylist = new Playlist(this.albumCollection);
        try {
            //Clearing listModels that are to be populated
            listModel2.clear();
            listmodel2tracks.clear();

            int i = 0;
            //All lines are playlist tracks so:
            while ((currentLine = br.readLine()) != null) {
                currentPlaylist.addTrackToPlaylist(currentLine);
            }
            for (PlaylistTrack track : currentPlaylist.playlistTracks) {
                //Adding playlist tracks to the listModel displayed 
                //in jListSongDisplay 
                i = i + 1;
                listModel2.addElement("Track " + i + ": " + track.getSong() + " " + track.getDuration());
            }

            jListSongDisplay.setModel(listModel2);
        } catch (Exception e) {
        }

        //Setting UI display to have relevent playlist information
        MusicPlayer.listHeader.setText("Playlist Loaded");
        MusicPlayer.AlbumInfoBox.setText("Playlist: " + displayedFilename + "\n" + currentPlaylist.getPlaylistDuration());
        playlistInfoModel.clear();
        playlistInfoModel.addElement("Playlist: " + displayedFilename);
        playlistInfoModel.addElement("Playlist Duration: " + currentPlaylist.getPlaylistDuration());
        MusicPlayer.jListTxtFileDisplay.setModel(playlistInfoModel);
        MusicPlayer.AlbumInfoBox.setText("Playlist: " + displayedFilename + "\n" + currentPlaylist.getPlaylistDuration());
    }

    public String displayPlaylistTrackArtistandAlbum() {
        //Method used when playlist is loaded.
        //Displays the artist and album of the selected playlist track.
        String selectedSongx = jListSongDisplay.getSelectedValue();
        String[] split1 = selectedSongx.split(": ");
        String[] split2 = split1[1].split(" 00:");
        String selectedSong = split2[0] + "";

        for (Album album : albumCollection.albums) {
            for (Track track : album.getAlbumsongs()) {
                if (track.getSong().equals(selectedSong)) {
                    MusicPlayer.AlbumInfoBox.setText(album.getHeader());
                }
            }
        }
        return null;
    }

    public void addTrackToPlaylist() {

        //Method for the "add" button in the MakePlaylist window.
        //The code below takes the required elements from the UI and puts them 
        //together into the given playlist format.
        String selectedAlbumTrack = MusicPlayer.jListSongDisplay.getSelectedValue();
        String[] selectedTrackSplit = selectedAlbumTrack.split(": ");
        String stringTrackSplit = selectedTrackSplit[1] + "";
        String[] selectedTrackSplit2 = stringTrackSplit.split("00:");

        String selectedArtistAndAlbum = MusicPlayer.AlbumInfoBox.getText();
        String[] selectedArtistAndAlbumSplit = selectedArtistAndAlbum.split("[\\r\\n]");

        String finalElement = selectedTrackSplit2[0] + "(" + selectedArtistAndAlbumSplit[0] + ")";

        //Every time this method is called (every click of the button) the 
        //finalElement is added to the playlistModel.
        playlistModel.addElement(finalElement);

        MakePlaylist.NewPlaylistTracks.setModel(playlistModel);
    }

    public void removeTrackFromPlaylist() {

        //Method for the "remove" button in the MakePlaylist window.
        //Takes selected track's index and removes this index number from the
        //model.
        DefaultListModel model = (DefaultListModel) MakePlaylist.NewPlaylistTracks.getModel();
        int selectedTrackIndex = MakePlaylist.NewPlaylistTracks.getSelectedIndex();
        if (selectedTrackIndex != -1) {
            model.remove(selectedTrackIndex);
        }
    }

    public void addAlbumToPlaylist() {

        //Method for the "add album" button in the MakePlaylist window.
        //Takes advantage of the fact that the jListSongDisplay model is 
        //populated when an album is clicked.
        //Creating a model called selectedAlbum and populating it with the
        //selected album's songs.
        DefaultListModel<String> selectedAlbum = (DefaultListModel<String>) MusicPlayer.jListSongDisplay.getModel();
        String selectedArtistAndAlbum = MusicPlayer.jListTxtFileDisplay.getSelectedValue();

        //Looping through the selectedAlbum model, reformatting the values to
        //the playlist format and adding the reformatted values as elements to
        //the playlistModel
        for (int i = 0; i < selectedAlbum.getSize(); i++) {

            String trackName = selectedAlbum.getElementAt(i);
            String[] trackNameSplit = trackName.split(": ");
            String trackName2 = trackNameSplit[1];
            String[] trackNameSplit2 = trackName2.split(" 00");
            String trackNameFinal = trackNameSplit2[0] + " (" + selectedArtistAndAlbum + ")";
            playlistModel.addElement(trackNameFinal);
            System.out.println("ADDALBUMTOPLAYLIST TEST: " + trackNameFinal);
        }
        MakePlaylist.NewPlaylistTracks.setModel(playlistModel);
    }

    public void savePlaylist() throws IOException {

        //Method to save the playlist that has been created to 
        //"text files/Playlists/"
        //There is a prompt to type filename into jTextField1
        String filename = MakePlaylist.jTextField1.getText();
        //This is used as the new playlist filename
        File newPlaylist = new File("C:/MusicPlayer/text files/Playlists/" + filename + ".txt");
        ListModel model = playlistModel;

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newPlaylist)));

        //Printing the playlistModel to the text file as String
        try {
            int len = model.getSize();
            for (int i = 0; i < len; i++) {
                pw.println(model.getElementAt(i).toString());
            }
        } finally {
            pw.close();
        }
    }

    public void playSelectedPlaylistSong() {

        //playSelectedTrack does not work on a playlist as the songs can be
        //added in a random order and the screen display is different.
        //This method created to play selected playlist song if it is 
        //clicked in the jListSongDisplay.
        //Implemented function to prevent song from playing if user is making
        //a playlist.
        //If Makeplaylist window open then do not play tracks
        boolean windowShowing = false;

        try {
            if (MakePlaylist.NewPlaylistTracks.isShowing()) {
                windowShowing = true;
            }

            if (windowShowing == true) {
                System.out.println("Make Playlist window exists");
            }

        } catch (Exception e) {
        }

        //If Makeplaylist window is closed then proceed.
        if (windowShowing == false) {

            //Need to build the filepath of the selected playlist track in the format:
            //mp3 files/<folderArtist>_<folderAlbum>/<fileArtist>_-_<fileTrackNumber>_-_<fileSong>.mp3
            //FILESONG:
            String[] playlistFileSong = MusicPlayer.jListSongDisplay.getSelectedValue().split(": ");
            String[] playlistFileSong2 = playlistFileSong[1].split(" 00:");
            String fileSong = playlistFileSong2[0];
            //FILEARTIST
            String[] playlistFileAlbumAndArtist = MusicPlayer.AlbumInfoBox.getText().split(" : ");
            String fileArtist = playlistFileAlbumAndArtist[0].replaceAll("&", "__");
            fileArtist = fileArtist.replaceAll("'", "");
            //FOLDERALBUM:
            String folderAlbum = playlistFileAlbumAndArtist[1];
            folderAlbum = folderAlbum.replaceAll(" ", "");
            //FOLDERARTIST:
            String folderArtist = playlistFileAlbumAndArtist[0].replaceAll("&", "");
            folderArtist = folderArtist.replaceAll(" ", "");
            folderArtist = folderArtist.replaceAll("'", "");
            //FILETRACKNUMBER:
            playlistmodel2tracks.clear();
            for (Album album : albumCollection.albums) {
                if (album.getHeader().equals(playlistFileAlbumAndArtist[0] + " : " + playlistFileAlbumAndArtist[1])) {
                    currentlySelectedAlbum = album;
                    for (Track track : album.getAlbumsongs()) {
                        playlistmodel2tracks.add(track.getSong());

                    }
                }
            }
            int playlistFileTrackNumber = playlistmodel2tracks.indexOf(playlistFileSong2[0]) + 1;

            //Defining folder name:
            String folderName = folderArtist + "_" + folderAlbum;

            //Defining file name:
            String fileName = fileArtist + " - " + String.format("%02d", playlistFileTrackNumber) + " - " + fileSong + ".mp3";
            fileName = fileName.replace(" ", "_");

            //Defining the final path:
            String path = "C:/MusicPlayer/mp3 files/" + folderName + "/" + fileName;

            //Testing
            System.out.println("====PLAYLIST MODEL====");
            System.out.println(playlistmodel2tracks);
            System.out.println("======================");

            System.out.println("====PLAYLIST SONG TESTING====");
            System.out.println("FILEARTIST: " + fileArtist);
            System.out.println("FILESONG: " + fileSong);
            System.out.println("FOLDERARTIST: " + folderArtist);
            System.out.println("FOLDERALBUM: " + folderAlbum);
            System.out.println("TRACKNUMBER: " + playlistFileTrackNumber);
            System.out.println("==========================");
            System.out.println("====PLAYLIST SONG FILE PATH====");
            System.out.println(path);
            System.out.println("============================");

            //Playing the path
            mp3.play(path);

            //Displaying the song that is being played
            MusicPlayer.SongNameDisplay.setText("Now Playing: " + fileSong);

        }
    }

    public Duration getPlaylistDuration() {
        //Method to get the duration of the playlist

        //Making a new playlist duration duration 
        Duration playlistDuration = new Duration();
        //Looping through the playlist tracks
        for (Track track : this.playlistTracks) {
            //Adding the tracks on the playlists durations 
            //to create duration of the playlist
            System.out.println(track.getDuration());
            playlistDuration.add(track.getDuration());
        }
        //Returing the playlists duration
        return playlistDuration;
    }

    public String toString() {

        String PlaylistTrackString = "";
        for (int i = 0; i < this.playlistTracks.size(); i++) {
            PlaylistTrackString += this.playlistTracks.get(i) + "\n";
        }
        return PlaylistTrackString;
    }
}
