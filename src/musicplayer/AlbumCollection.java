package musicplayer;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AlbumCollection {

    //Declaring variables and Types
    DefaultListModel<String> listModel = new DefaultListModel<>();
    DefaultListModel<String> listModel2 = new DefaultListModel<>();
    public ArrayList<Album> albums;
    private ArrayList<Track> listmodel2tracks = new ArrayList<>();
    private Album currentlySelectedAlbum;
    MP3Player mp3 = new MP3Player();

    Playlist playlist = new Playlist(this);

    //Constructor initialising empty array list
    public AlbumCollection() {

        this.albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        //Creating addAlbums method to add albums to array
        this.albums.add(album);
    }

    public static boolean isStringTrackInformation(String line) {

        if (line.charAt(1) == ':' && line.charAt(4) == ':') {
            return true;
        }
        return false;
    }

    public Album findAlbum(String artistname, String albumname) {
        //Method using a loop to find album checking both the artist name 
        //and the albumname are equal
        for (Album album : albums) {
            if (album.getArtistName().equals(artistname)
                    && album.getAlbumTitle().equals(albumname)) {
                return album;

            }
        }
        return null;
    }

    public void sortAlbums() {
        //Method to sort albums
        Collections.sort(albums);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Album album : albums) {
            sb.append(album + "\n");
        }
        return sb.toString().trim();
    }

    public Duration getSelectedAlbumDuration() {

        String selectedAlbum = MusicPlayer.AlbumInfoBox.getText();
        Duration selectedAlbumDuration = new Duration();

        System.out.println("selected Album = " + selectedAlbum);

        for (Album album : albums) {
            System.out.println(album.getHeader());
            if (album.getHeader().equals(selectedAlbum)) {
                for (Track track : album.getAlbumsongs()) {
                    selectedAlbumDuration.add(track.getDuration());
                }

                String durationString = selectedAlbumDuration + "";
                MusicPlayer.AlbumInfoBox.append("\nAlbum Duration: " + durationString);
                System.out.println(selectedAlbumDuration);
            }

        }
        return null;
    }

    public void getAlbumCollection(String filename) {
        //getAlbumCollection method used on click of "Load Albums"    

        //Checking the listHeader textbox and setting it to "Albums Loaded"
        try {
            if (MusicPlayer.listHeader.getText().equals("Playlists Loaded")) {
                MusicPlayer.listHeader.setText("Albums Loaded");
            } else if (MusicPlayer.listHeader != null) {
                MusicPlayer.listHeader.setText("Albums Loaded");
            } else {
            }
        } catch (Exception e) {
        }

        try {
            //Reading in the file
            File albumFile = new File(filename);
            BufferedReader in = new BufferedReader(new FileReader(albumFile));
            String currentLine;
            Album currentAlbum = null;

            //Loop through the file adding albums to the albumCollection array.
            //Uses the isStringTrackInformation() method to determine if the
            //current line is a track. If it is a track, this is added to the
            //current album
            while ((currentLine = in.readLine()) != null) {

                if (currentAlbum == null) {
                    currentAlbum = Album.makeNewAlbum(currentLine);

                } else if (AlbumCollection.isStringTrackInformation(currentLine)) {
                    Track currentTrack = new Track(currentLine);
                    currentAlbum.addTrackToAlbum(currentTrack);

                } else {
                    //Added this code to check the albumCollection first to ensure
                    //that we are not getting duplicate albums added to the array
                    Album matchedAlbum = this.findAlbum(currentAlbum.getArtistName(), currentAlbum.getAlbumTitle());
                    if (matchedAlbum == null) {
                        //Also populating a listModel with album titles which 
                        //is to be displayed on jListTxtFileDisplay
                        listModel.addElement(currentAlbum.getArtistName() + " : " + currentAlbum.getAlbumTitle());
                        this.addAlbum(currentAlbum);
                    }
                    currentAlbum = Album.makeNewAlbum(currentLine);
                }

            }

            //This code added to ensure last album gets added to list (as 
            //last line is always track information).
            Album matchedAlbum = this.findAlbum(currentAlbum.getArtistName(), currentAlbum.getAlbumTitle());
            if (matchedAlbum == null) {
                listModel.addElement(currentAlbum.getArtistName() + " : " + currentAlbum.getAlbumTitle());
                this.addAlbum(currentAlbum);
            }

            //Displaying the populated listModel on the jListTxtFileDisplay
            MusicPlayer.jListTxtFileDisplay.setModel(listModel);

            in.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void getSelectedAlbumTracks(String filename) {
        //Method to get tracks of selected album in jListTxtFileDisplay
        String selectedJList = MusicPlayer.jListTxtFileDisplay.getSelectedValue() + "";
        selectedJList = selectedJList.replaceAll("\\[", "").replaceAll("\\]", "");
        int i = 0;
        //Setting the AlbumInfoBox to the selected jList value
        try {
            listModel2.clear();
            listmodel2tracks = new ArrayList<>();
            MusicPlayer.AlbumInfoBox.setText(selectedJList);
            System.out.println("set Text Area 1 to " + selectedJList);
        } catch (Exception e) {
        }
        //Loop through album collection searching for selected jList value.
        //When found, loop through album songs and add tracks as elements to
        //listModel2. track objects also added to "listmodel2tracks" array to 
        //aid with onclick mp3 playing.
        for (Album album : albums) {
            String selectedAlbum = selectedJList;
            if (album.getHeader().equals(selectedAlbum)) {
                //Setting album to the currently selected album
                currentlySelectedAlbum = album;
                for (Track track : album.getAlbumsongs()) {
                    i = i + 1;
                    String albumString2 = "Track " + i + ": " + track;
                    listModel2.addElement(albumString2);
                    listmodel2tracks.add(track);
                }

            }
            //Displaying populated listModel2
            MusicPlayer.jListSongDisplay.setModel(listModel2);
        }
    }

    public static String getSelectedAlbumText() {

        //Method to return selected album text with no spaces and all in 
        //lower case.
        //Text taken from AlbumInfoBox
        String selectedAlbumText = MusicPlayer.AlbumInfoBox.getText();
        String[] pictureArray = selectedAlbumText.split("[\\r\\n]");
        String[] pictureArray2 = pictureArray[0].split(" : ");
        pictureArray2[1] = pictureArray2[1].replace(" ", "");
        pictureArray2[1] = pictureArray2[1].replace("?", "");
        pictureArray2[1] = pictureArray2[1].replace("'", "");
        pictureArray2[1] = pictureArray2[1].toLowerCase();
        String selectedAlbum = pictureArray2[1];
        //Testing
        System.out.println("TEST HERE " + selectedAlbum);
        return selectedAlbum;
    }

    public static boolean isStringImageFile(String line) {

        //Method to check if a line contains .jpg (indicating that it 
        //is an image file. Can add other image formats here in future if 
        //necessary
        if (line.contains(".jpg")) {
            return true;
        }
        return false;
    }

    public static void getPicture() {

        //Method to get the image of the selected album and display it
        //Generating two array lists -
        //fullList will be populated with full file names
        //splitList will contain only album names. 
        //ThegetSelectedAlbumText()
        ArrayList<String> fullList = new ArrayList<String>();
        ArrayList<String> splitList = new ArrayList<String>();

        try {
            //Resetting the labels
            MusicPlayer.jLabel1.setIcon(null);
            MusicPlayer.jLabel2.setIcon(null);
            //Reading in the file
            File pictureFile = new File("C:/MusicPlayer/text files/AlbumImageList.txt");
            BufferedReader in
                    = new BufferedReader(new FileReader(pictureFile));
            String currentLine;

            while ((currentLine = in.readLine()) != null) {

                //If the current line is an image file
                if (AlbumCollection.isStringImageFile(currentLine)) {
                    //Add it to the fullList array
                    fullList.add(currentLine);
                    //Also reformat the current line to the same format 
                    //as the getSelectedAlbumText() method.
                    String[] picSplit = currentLine.split("_");
                    picSplit[1] = picSplit[1].replace(".jpg", "");
                    picSplit[1] = picSplit[1].toLowerCase();
                    //Add reformatted line to the splitList array
                    splitList.add(picSplit[1]);
                    //Checking format is correct
                    System.out.println("splitList format: " + picSplit[1]);
                }

            }

            //After the lists are populated
            //Assign the getSelectedAlbumText() method to selectedAlbum
            String selectedAlbum = getSelectedAlbumText();
            //Check the splitList and the selectedAlbum
            System.out.println("List:\n\n" + splitList);
            System.out.println("Selected Album:\n\n" + selectedAlbum);
            //Return the index of the selected album in the splitList
            int listPos = splitList.indexOf(selectedAlbum);
            System.out.println("Selected Album position:" + listPos);
            //Use this index to select the correct file name from the
            //fullList. Assign it to returnedAlbum.
            String returnedAlbum = fullList.get(listPos);
            System.out.println("Selected Album filename:" + returnedAlbum);

            //Had problems with image scaling so created an ImageIcon with filepath, converted in to an image, rescaled to size of jLabel,
            //then made another ImageIcon from the rescaled image.
            //Put this new ImageIcon into the jLabel.
            BufferedImage img = ImageIO.read(new File("C:/MusicPlayer/album images/" + returnedAlbum));
            ImageIcon imgPath = new ImageIcon(img);
            Image img1 = imgPath.getImage();
            Image img2 = img1.getScaledInstance(MusicPlayer.jLabel1.getWidth(), MusicPlayer.jLabel1.getHeight(), Image.SCALE_SMOOTH);
            Image img3 = img1.getScaledInstance(MusicPlayer.jLabel2.getWidth(), MusicPlayer.jLabel2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledImage = new ImageIcon(img2);
            ImageIcon scaledImage2 = new ImageIcon(img3);
            MusicPlayer.jLabel1.setIcon(scaledImage);//new javax.swing.ImageIcon(javax.swing.JLabel.class.getResource("/albuminfoprogram/newpackage/"+returnedAlbum))); // NOI18N
            MusicPlayer.jLabel2.setIcon(scaledImage2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playSelectedSong() {

        //Method to play selected song if it is clicked in the jListSongDisplay.
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

            //Need to build the filepath of the selected track in the format:
            //mp3 files/<folderArtist>_<folderAlbum>/<fileArtist>_-_<fileTrackNumber>_-_<fileSong>.mp3
            //FILETRACKNUMBER: Number determined by using index of selected 
            //value in jList
            int listModelIndex = MusicPlayer.jListSongDisplay.getSelectedIndex();
            int fileTrackNumber = listModelIndex + 1;

            //FILESONG: using index of selected value in jList to retrieve
            //song name from the listmodel2tracks array. 
            Track selectedTrack = listmodel2tracks.get(listModelIndex);
            String fileSong = selectedTrack.getSong();

            //FILEARTIST: currentlySelectedAlbum defined in getAlbumTracks 
            //method. This is used to obtain artist name. Formatted 
            //appropriately
            String fileArtist = currentlySelectedAlbum.getArtistName();
            fileArtist = fileArtist.replaceAll("&", "__");
            fileArtist = fileArtist.replaceAll("'", "");

            //Defining the file name:
            String fileName = fileArtist + " - " + String.format("%02d", fileTrackNumber) + " - " + fileSong + ".mp3";
            fileName = fileName.replace(" ", "_");

            //FOLDERARTIST: using currentlySelectedAlbum to obtain artist name.
            //Format is different to FILEARTIST.
            String folderArtist = currentlySelectedAlbum.getArtistName();
            folderArtist = folderArtist.replaceAll("&", "");
            folderArtist = folderArtist.replaceAll("'", "");
            folderArtist = folderArtist.replaceAll(" ", "");

            //FOLDERALBUM: using currentlySelectedAlbum to obtain album title.
            //Formatted to remove special characters.
            String folderAlbum = currentlySelectedAlbum.getAlbumTitle().replaceAll("[^A-Za-z]", "");
            folderAlbum = folderAlbum.replaceAll("&", "");
            folderAlbum = folderAlbum.replaceAll("'", "");

            //Defining the folder name:
            String folderName = folderArtist + "_" + folderAlbum;

            //Defining the final path:
            String path = "C:/MusicPlayer/mp3 files/" + folderName + "/" + fileName;

            //Testing
            System.out.println("====ALBUM MODEL====");
            System.out.println(listmodel2tracks);
            System.out.println("======================");

            System.out.println("====ALBUM SONG TESTING====");
            System.out.println("FILEARTIST: " + fileArtist);
            System.out.println("FILESONG: " + fileSong);
            System.out.println("FOLDERARTIST: " + folderArtist);
            System.out.println("FOLDERALBUM: " + folderAlbum);
            System.out.println("TRACKNUMBER: " + fileTrackNumber);
            System.out.println("==========================");
            System.out.println("====ALBUM SONG FILE PATH====");
            System.out.println(path);
            System.out.println("============================");
            //Playing the path
            mp3.play(path);
            //Set display to show which song is playing
            MusicPlayer.SongNameDisplay.setText("Now Playing: " + selectedTrack.getSong());
        }
    }

    public void isAlbumCollectionEmpty() {
        //Popup if album collection has not been loaded. Used with load playlist
        //button
        if (albums.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please ensure your album collection is loaded first!");
        }
    }

}
