package musicplayer;

import java.io.File;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

//New album list:
//removed the <tab> after Lovira:Experiments
//removed "music" from the end of Pianochocolate:lilac music
//removed "the" from Kraftwerk: The Man machine
//changed neils heavy concept album to heavy concept for neil pye :neils heavy concept album
public class MusicPlayer extends javax.swing.JFrame {

    AlbumCollection albumCollection = new AlbumCollection();
    Playlist playlist = new Playlist(albumCollection);
    MP3Player mp3 = new MP3Player();
    DefaultListModel<String> listModel = new DefaultListModel<>();
    DefaultListModel<String> listModel2 = new DefaultListModel<>();
    String loadedAlbum = null;
    public static int count;

    public MusicPlayer() {
        initComponents();
        listModel = new DefaultListModel<>();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        LoadAlbumCollectionButton = new javax.swing.JButton();
        LoadPlaylistButton = new javax.swing.JButton();
        MakePlaylistButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        LoopButton = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        PlayButton = new javax.swing.JButton();
        PauseButton = new javax.swing.JButton();
        StopButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SongNameDisplay = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSongDisplay = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        AlbumInfoBox = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListTxtFileDisplay = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listHeader = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 64)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("  Music Album and Playlist Playing System");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 218, 218)));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setDoubleBuffered(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jTextField1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 226, 226)));

        LoadAlbumCollectionButton.setBackground(new java.awt.Color(255, 255, 255));
        LoadAlbumCollectionButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LoadAlbumCollectionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/mp3images/u59.png"))); // NOI18N
        LoadAlbumCollectionButton.setText("  Load Albums  ");
        LoadAlbumCollectionButton.setActionCommand("Load Album Collection");
        LoadAlbumCollectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadAlbumCollectionButtonActionPerformed(evt);
            }
        });

        LoadPlaylistButton.setBackground(new java.awt.Color(255, 255, 255));
        LoadPlaylistButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LoadPlaylistButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/mp3images/u62.png"))); // NOI18N
        LoadPlaylistButton.setText("  Load Playlists");
        LoadPlaylistButton.setActionCommand("Load Playlists");
        LoadPlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadPlaylistButtonActionPerformed(evt);
            }
        });

        MakePlaylistButton.setBackground(new java.awt.Color(255, 255, 255));
        MakePlaylistButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        MakePlaylistButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/mp3images/u60.png"))); // NOI18N
        MakePlaylistButton.setText("  Make Playlist");
        MakePlaylistButton.setActionCommand("Make New Playlist");
        MakePlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakePlaylistButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MakePlaylistButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoadPlaylistButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoadAlbumCollectionButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(LoadAlbumCollectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(LoadPlaylistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(MakePlaylistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LoopButton.setBackground(new java.awt.Color(255, 255, 255));
        LoopButton.setForeground(new java.awt.Color(255, 255, 255));
        LoopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/mp3images/u26.png"))); // NOI18N
        LoopButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoopButtonActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/mp3images/u25.png"))); // NOI18N
        jButton9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        PlayButton.setBackground(new java.awt.Color(255, 255, 255));
        PlayButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PlayButton.setForeground(new java.awt.Color(255, 255, 255));
        PlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/mp3images/u27.png"))); // NOI18N
        PlayButton.setToolTipText("");
        PlayButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButtonActionPerformed(evt);
            }
        });

        PauseButton.setBackground(new java.awt.Color(255, 255, 255));
        PauseButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PauseButton.setForeground(new java.awt.Color(255, 255, 255));
        PauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/mp3images/u65.png"))); // NOI18N
        PauseButton.setToolTipText("");
        PauseButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PauseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PauseButtonMouseReleased(evt);
            }
        });

        StopButton.setBackground(new java.awt.Color(255, 255, 255));
        StopButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StopButton.setForeground(new java.awt.Color(255, 255, 255));
        StopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/mp3images/u64.png"))); // NOI18N
        StopButton.setToolTipText("");
        StopButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });

        SongNameDisplay.setEditable(false);
        SongNameDisplay.setColumns(1);
        SongNameDisplay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        SongNameDisplay.setRows(1);
        SongNameDisplay.setBorder(null);
        jScrollPane1.setViewportView(SongNameDisplay);

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(StopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(PlayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(PauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(LoopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LoopButton, PauseButton, PlayButton, StopButton, jButton9});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LoopButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PlayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(PauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(StopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LoopButton, PauseButton, PlayButton, StopButton, jButton9});

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jListSongDisplay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jListSongDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListSongDisplayMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jListSongDisplayMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jListSongDisplay);

        AlbumInfoBox.setColumns(20);
        AlbumInfoBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        AlbumInfoBox.setRows(5);
        jScrollPane4.setViewportView(AlbumInfoBox);

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jScrollPane6.setBorder(null);

        jListTxtFileDisplay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jListTxtFileDisplay.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jListTxtFileDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListTxtFileDisplayMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jListTxtFileDisplayMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jListTxtFileDisplay);

        listHeader.setColumns(20);
        listHeader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        listHeader.setRows(1);
        jScrollPane3.setViewportView(listHeader);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane3))
                        .addGap(9, 9, 9)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6)))
                        .addGap(9, 9, 9)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadAlbumCollectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadAlbumCollectionButtonActionPerformed
        JFileChooser openFC = new JFileChooser("C:/MusicPlayer/text files/AlbumCollections");
        int returnVal = openFC.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File txtfile = openFC.getSelectedFile();
            String filename = txtfile + "";
            loadedAlbum = openFC + "";
            albumCollection.getAlbumCollection(filename);
            albumCollection.getSelectedAlbumTracks(filename);
        }
    }//GEN-LAST:event_LoadAlbumCollectionButtonActionPerformed

    private void PlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayButtonActionPerformed
        albumCollection.mp3.resume();
        playlist.mp3.resume();
    }//GEN-LAST:event_PlayButtonActionPerformed

    private void StopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButtonActionPerformed
        albumCollection.mp3.stop();
        playlist.mp3.stop();
    }//GEN-LAST:event_StopButtonActionPerformed

    private void PauseButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PauseButtonMouseReleased
        albumCollection.mp3.pause();
        playlist.mp3.pause();
    }//GEN-LAST:event_PauseButtonMouseReleased

    private void LoopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoopButtonActionPerformed
        switch (count) {
            case 0:
                count = 1;
                LoopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/mp3images/u67.png")));
                break;

            case 1:
                count = 0;
                LoopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/mp3images/u26.png")));
                break;
        }
    }//GEN-LAST:event_LoopButtonActionPerformed

    private void LoadPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadPlaylistButtonActionPerformed
        albumCollection.isAlbumCollectionEmpty();
        JFileChooser openFC = new JFileChooser("C:/MusicPlayer/text files/Playlists/");
        int returnVal = openFC.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File txtfile = openFC.getSelectedFile();
            String filename = txtfile + "";
            String[] filenamesplit = filename.split("Playlists");
            String displayedFilename = filenamesplit[1].replace("\\", "") + "";
            loadedAlbum = openFC + "";
            try {
                playlist.getPlaylist(filename, displayedFilename);
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_LoadPlaylistButtonActionPerformed

    private void jListTxtFileDisplayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTxtFileDisplayMousePressed
        String filename = loadedAlbum;
        albumCollection.getSelectedAlbumTracks(filename);
        albumCollection.getSelectedAlbumDuration();
    }//GEN-LAST:event_jListTxtFileDisplayMousePressed

    private void jListTxtFileDisplayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTxtFileDisplayMouseReleased
        albumCollection.getPicture();
    }//GEN-LAST:event_jListTxtFileDisplayMouseReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        JOptionPane.showMessageDialog(null, "This button has not been implemented");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void MakePlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MakePlaylistButtonActionPerformed
        MakePlaylist makeplaylist = new MakePlaylist();
        makeplaylist.setVisible(true);
    }//GEN-LAST:event_MakePlaylistButtonActionPerformed

    private void jListSongDisplayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSongDisplayMouseReleased
        albumCollection.getPicture();
    }//GEN-LAST:event_jListSongDisplayMouseReleased

    private void jListSongDisplayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSongDisplayMousePressed
        if (listHeader.getText().equals("Albums Loaded")) {
            try {
                albumCollection.mp3.stop();
                playlist.mp3.stop();
                albumCollection.playSelectedSong();
            } catch (Exception e) {
            }
        } else {
            try {
                albumCollection.mp3.stop();
                playlist.mp3.stop();
                playlist.displayPlaylistTrackArtistandAlbum();
                playlist.playSelectedPlaylistSong();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jListSongDisplayMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MusicPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea AlbumInfoBox;
    private javax.swing.JButton LoadAlbumCollectionButton;
    private javax.swing.JButton LoadPlaylistButton;
    private javax.swing.JButton LoopButton;
    private javax.swing.JButton MakePlaylistButton;
    private javax.swing.JButton PauseButton;
    private javax.swing.JButton PlayButton;
    public static javax.swing.JTextArea SongNameDisplay;
    private javax.swing.JButton StopButton;
    private javax.swing.JButton jButton9;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JList<String> jListSongDisplay;
    public static javax.swing.JList<String> jListTxtFileDisplay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextArea listHeader;
    // End of variables declaration//GEN-END:variables
}
