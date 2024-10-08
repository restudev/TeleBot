/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nila.bupati_bot;

//import com.mycompany.chatbot.Chatbot;
//import com.mycompany.chatbot.FormKataKunci;
//import com.mycompany.chatbot.FormLogin;
//import com.mycompany.chatbot.FormPesan;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 *
 * @author Restu
 */
public class FormTelegramBot extends javax.swing.JFrame  {
    
    // Database Credentials
    public String DB_URL = "jdbc:mysql://localhost:3306/db_bupati";
    public String DB_USERNAME = "root";
    public String DB_PASSWORD = "";
    ResultSet rsBrg;
    Statement stm;
    private Object[][] dataTable = null;
    private String[] header = {"ChatID", "Username"};
    private MyTelegramBot chatbot;

    /**
     * Creates new form FormTelegramBot
     * @throws java.sql.SQLException
     */
    public FormTelegramBot() throws SQLException  {
        initComponents();
        
        // Inisialisasi objek Chatbot
        chatbot = new MyTelegramBot();
        
        bacaData();
        
        bacaMember();
        
        bacaPesan();
        
        // mouse click tabel barang
        tabelMember.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setField();
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtChat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMember = new javax.swing.JTable();
        btnDaftar = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtBroadcast = new javax.swing.JTextArea();
        btnBroadcast = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtPesanMasukKeluar = new javax.swing.JTextArea();
        btnBroadcastTo = new javax.swing.JButton();
        cmbMember = new javax.swing.JComboBox<>();
        btnKeluar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Member BupatiBot");
        setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 1, 16)); // NOI18N
        jLabel1.setText("Kelola Member");

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 1, 16)); // NOI18N
        jLabel2.setText("Data Member");

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel4.setText("Username");

        txtUsername.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        txtChat.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel5.setText("Chat ID");

        tabelMember.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N
        tabelMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Username", "Chat ID"
            }
        ));
        jScrollPane1.setViewportView(tabelMember);

        btnDaftar.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnDaftar.setText("Daftar");
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(204, 0, 0));
        btnHapus.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 1, 16)); // NOI18N
        jLabel7.setText("Broadcast Pesan");

        txtBroadcast.setColumns(20);
        txtBroadcast.setRows(5);
        txtBroadcast.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jScrollPane2.setViewportView(txtBroadcast);

        btnBroadcast.setBackground(new java.awt.Color(204, 204, 204));
        btnBroadcast.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnBroadcast.setText("Broadcast All");
        btnBroadcast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadcastActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 1, 16)); // NOI18N
        jLabel8.setText("Pesan Keluar dan Masuk");

        txtPesanMasukKeluar.setEditable(false);
        txtPesanMasukKeluar.setColumns(20);
        txtPesanMasukKeluar.setRows(5);
        txtPesanMasukKeluar.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jScrollPane3.setViewportView(txtPesanMasukKeluar);

        btnBroadcastTo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnBroadcastTo.setText("Broadcast To");
        btnBroadcastTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadcastToActionPerformed(evt);
            }
        });

        cmbMember.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        cmbMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMemberActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(204, 0, 0));
        btnKeluar.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Form Member BupatiBot");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnDaftar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnClear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnHapus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEdit)
                                        .addGap(49, 49, 49)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(186, 186, 186)
                                        .addComponent(btnRefresh))
                                    .addComponent(jLabel2)))
                            .addComponent(jScrollPane3)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBroadcastTo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBroadcast))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtChat)
                                    .addComponent(txtUsername))
                                .addGap(72, 72, 72)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(0, 363, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDaftar)
                    .addComponent(btnClear)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit)
                    .addComponent(btnRefresh))
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBroadcast)
                    .addComponent(btnBroadcastTo)
                    .addComponent(cmbMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKeluar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
        // TODO add your handling code here:
        String tChat = txtChat.getText();
        String tUsername = txtUsername.getText();
        if(!tChat.isEmpty() && !tUsername.isEmpty()) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String sql = "INSERT INTO member (chat_id, username) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, tChat);
                statement.setString(2, tUsername);
                statement.executeUpdate();
                statement.close();

                // Refresh tabel data
                bacaData();
                
                // Refresh combobox data list
                cmbMember.removeAllItems();
                bacaMember();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }
    }//GEN-LAST:event_btnDaftarActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String tChat = txtChat.getText();
        String tUsername = txtUsername.getText();
        if(!tChat.isEmpty() && !tUsername.isEmpty()) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String sql = "UPDATE member SET username=? WHERE chat_id=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, tUsername);
                statement.setString(2, tChat);
                statement.executeUpdate();
                statement.close();

                // Refresh tabel data
                bacaData();
                
                // Refresh combobox data list
                cmbMember.removeAllItems();
                bacaMember();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBroadcastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadcastActionPerformed
        // TODO add your handling code here:
        String broadcastMessage = txtBroadcast.getText();
        
        chatbot.sendBroadcastAll(broadcastMessage);
    }//GEN-LAST:event_btnBroadcastActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql="delete from member where chat_id='" + txtChat.getText() + "'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
            
            // Refresh tabel data
            bacaData();
            
            // Refresh combobox data list
            cmbMember.removeAllItems();
            bacaMember();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtChat.setText("");
        txtUsername.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        bacaData();
        cmbMember.removeAllItems();
        bacaMember();
        bacaPesan();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBroadcastToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadcastToActionPerformed
        // TODO add your handling code here:
        String tMember=cmbMember.getSelectedItem().toString();
        String broadcastMessage = txtBroadcast.getText();
        
        chatbot.sendBroadcastTo(tMember, broadcastMessage);
    }//GEN-LAST:event_btnBroadcastToActionPerformed

    private void cmbMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMemberActionPerformed
        // TODO add your handling code here:1441574211
    }//GEN-LAST:event_cmbMemberActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed
    
        // method set field form jika salah satu field tabel ditekan
    private void setField()
    {
        int row=tabelMember.getSelectedRow();
        txtChat.setText((String)tabelMember.getValueAt(row,0));
        txtUsername.setText((String)tabelMember.getValueAt(row,1));
    }

    // method baca data dari Mysql dimasukkan ke table pada form
    private void bacaData() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsBrg = stm.executeQuery("select * from member");
            ResultSetMetaData meta = rsBrg.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while(rsBrg.next()) {
                baris = rsBrg.getRow();
            }
            dataTable = new Object[baris][col];
            int x = 0;
            rsBrg.beforeFirst();
            while(rsBrg.next()) {
                dataTable[x][0] = rsBrg.getString("chat_id");
                dataTable[x][1] = rsBrg.getString("username");
                x++;
            }
            tabelMember.setModel(new DefaultTableModel(dataTable,header));
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void bacaMember() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            stm=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=stm.executeQuery("select * from member");
            rs.beforeFirst();
            while(rs.next()) {
                cmbMember.addItem(rs.getString(2).trim());
            }
                rs.close();
        } catch(SQLException e) {
            System.out.println("Error : "+e);
        }
    }
    
    public void bacaPesan() {
        List<String> messages = new ArrayList<>(); // Store messages in a list

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = statement.executeQuery("SELECT * FROM pesan")) {

            rs.beforeFirst();
            while (rs.next()) {
                String message = "(" + rs.getString(2).trim() + ")" + rs.getString(3).trim() + ": " + rs.getString(4).trim();
                messages.add(message); // Add each message to the list
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        // Display messages in the text area
        SwingUtilities.invokeLater(() -> {
            for (String message : messages) {
                txtPesanMasukKeluar.append(message + "\n");
            }
        });
    }
  
    public static void Call() {
        new FormLogin().setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTelegramBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTelegramBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTelegramBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTelegramBot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            // Create an instance of the TelegramBotsApi to register your bot
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            // Register your bot by providing an instance of your bot class
            botsApi.registerBot((LongPollingBot) new MyTelegramBot());

            System.out.println("Bot started successfully!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //                    new FormTelegramBot().setVisible(true);
                Call();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBroadcast;
    private javax.swing.JButton btnBroadcastTo;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDaftar;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cmbMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelMember;
    private javax.swing.JTextArea txtBroadcast;
    private javax.swing.JTextField txtChat;
    private javax.swing.JTextArea txtPesanMasukKeluar;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
