package musicplayer;

import java.io.IOException;
import javax.swing.JOptionPane;

public class MakePlaylist extends javax.swing.JFrame {

    AlbumCollection albumCollection = new AlbumCollection();
    Playlist playlist = new Playlist(albumCollection);

    public MakePlaylist() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        NewPlaylistTracks = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        AddTrackToPlaylist = new javax.swing.JButton();
        AddAlbumToPlaylist = new javax.swing.JButton();
        RemoveSelectedFromPlaylist = new javax.swing.JButton();
        CreatePlaylistButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(460, 1177));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.setText("<Type Your Playlist Title Here>");

        jScrollPane2.setViewportView(NewPlaylistTracks);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setText("            \n                 New Playlist");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 150));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        AddTrackToPlaylist.setBackground(new java.awt.Color(255, 255, 255));
        AddTrackToPlaylist.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        AddTrackToPlaylist.setText("Add Track");
        AddTrackToPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTrackToPlaylistActionPerformed(evt);
            }
        });

        AddAlbumToPlaylist.setBackground(new java.awt.Color(255, 255, 255));
        AddAlbumToPlaylist.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        AddAlbumToPlaylist.setText("Add Album");
        AddAlbumToPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAlbumToPlaylistActionPerformed(evt);
            }
        });

        RemoveSelectedFromPlaylist.setBackground(new java.awt.Color(255, 255, 255));
        RemoveSelectedFromPlaylist.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        RemoveSelectedFromPlaylist.setText("Remove");
        RemoveSelectedFromPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveSelectedFromPlaylistActionPerformed(evt);
            }
        });

        CreatePlaylistButton.setBackground(new java.awt.Color(255, 255, 255));
        CreatePlaylistButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CreatePlaylistButton.setText("Create Playlist");
        CreatePlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePlaylistButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AddTrackToPlaylist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddAlbumToPlaylist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoveSelectedFromPlaylist))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CreatePlaylistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddAlbumToPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(AddTrackToPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RemoveSelectedFromPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreatePlaylistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddTrackToPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTrackToPlaylistActionPerformed
        playlist.addTrackToPlaylist();
    }//GEN-LAST:event_AddTrackToPlaylistActionPerformed

    private void AddAlbumToPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAlbumToPlaylistActionPerformed
        playlist.addAlbumToPlaylist();
    }//GEN-LAST:event_AddAlbumToPlaylistActionPerformed

    private void CreatePlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePlaylistButtonActionPerformed
        try {
            playlist.savePlaylist();
        } catch (IOException ex) {
        }
        this.dispose();
        JOptionPane.showMessageDialog(null, "Playlist saved!");
    }//GEN-LAST:event_CreatePlaylistButtonActionPerformed

    private void RemoveSelectedFromPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveSelectedFromPlaylistActionPerformed
        playlist.removeTrackFromPlaylist();
    }//GEN-LAST:event_RemoveSelectedFromPlaylistActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakePlaylist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAlbumToPlaylist;
    private javax.swing.JButton AddTrackToPlaylist;
    private javax.swing.JButton CreatePlaylistButton;
    public static javax.swing.JList<String> NewPlaylistTracks;
    private javax.swing.JButton RemoveSelectedFromPlaylist;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
