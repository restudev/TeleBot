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
public class FormUser extends javax.swing.JFrame  {
    
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
    public FormUser() throws SQLException  {
        initComponents();
        
        // Inisialisasi objek Chatbot
        chatbot = new MyTelegramBot();
        
        bacaData();
        
        bacaUser();
        
        bacaPesan();
        
        // mouse click tabel barang
        tabelUser.addMouseListener(new MouseAdapter() {
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
        txtUsername_user = new javax.swing.JTextField();
        txtChat_user = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelUser = new javax.swing.JTable();
        btnDaftar_user = new javax.swing.JButton();
        btnClear_user = new javax.swing.JButton();
        btnHapus_user = new javax.swing.JButton();
        btnEdit_user = new javax.swing.JButton();
        btnRefresh_user = new javax.swing.JButton();
        btnKeluar_user = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BupatiBot - Nila");
        setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 1, 16)); // NOI18N
        jLabel1.setText("Kelola User");

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 1, 16)); // NOI18N
        jLabel2.setText("Data User");

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel4.setText("Username");

        txtUsername_user.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        txtChat_user.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel5.setText("Chat ID");

        tabelUser.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        tabelUser.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelUser);

        btnDaftar_user.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnDaftar_user.setText("Daftar");
        btnDaftar_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftar_userActionPerformed(evt);
            }
        });

        btnClear_user.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnClear_user.setText("Bersihkan");
        btnClear_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear_userActionPerformed(evt);
            }
        });

        btnHapus_user.setBackground(new java.awt.Color(204, 0, 0));
        btnHapus_user.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        btnHapus_user.setText("Hapus");
        btnHapus_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapus_userActionPerformed(evt);
            }
        });

        btnEdit_user.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnEdit_user.setText("Edit");
        btnEdit_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit_userActionPerformed(evt);
            }
        });

        btnRefresh_user.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnRefresh_user.setText("Refresh");
        btnRefresh_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh_userActionPerformed(evt);
            }
        });

        btnKeluar_user.setBackground(new java.awt.Color(204, 0, 0));
        btnKeluar_user.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        btnKeluar_user.setText("Keluar");
        btnKeluar_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluar_userActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Form User BupatiBot");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh_user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeluar_user))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(btnDaftar_user)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear_user)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus_user, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit_user, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername_user)
                                    .addComponent(txtChat_user)))
                            .addComponent(jSeparator1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername_user, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtChat_user, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDaftar_user)
                    .addComponent(btnClear_user)
                    .addComponent(btnHapus_user)
                    .addComponent(btnEdit_user))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh_user)
                    .addComponent(btnKeluar_user))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDaftar_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftar_userActionPerformed
        // TODO add your handling code here:
        String tChat = txtChat_user.getText();
        String tUsername = txtUsername_user.getText();
        if(!tChat.isEmpty() && !tUsername.isEmpty()) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String sql = "INSERT INTO user (chat_id, username) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, tChat);
                statement.setString(2, tUsername);
                statement.executeUpdate();
                statement.close();

                // Refresh tabel data
                bacaData();
                
                // Refresh combobox data list
//                cmbMember.removeAllItems();
                bacaUser();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }
    }//GEN-LAST:event_btnDaftar_userActionPerformed

    private void btnEdit_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit_userActionPerformed
        // TODO add your handling code here:
        String tChat = txtChat_user.getText();
        String tUsername = txtUsername_user.getText();
        if(!tChat.isEmpty() && !tUsername.isEmpty()) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String sql = "UPDATE user SET username=? WHERE chat_id=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, tUsername);
                statement.setString(2, tChat);
                statement.executeUpdate();
                statement.close();

                // Refresh tabel data
                bacaData();
                
                // Refresh combobox data list
//                cmbMember.removeAllItems();
                bacaUser();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }
    }//GEN-LAST:event_btnEdit_userActionPerformed

    private void btnHapus_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapus_userActionPerformed
        // TODO add your handling code here:
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql="delete from user where chat_id='" + txtChat_user.getText() + "'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
            
            // Refresh tabel data
            bacaData();
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnHapus_userActionPerformed

    private void btnClear_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear_userActionPerformed
        // TODO add your handling code here:
        txtChat_user.setText("");
        txtUsername_user.setText("");
    }//GEN-LAST:event_btnClear_userActionPerformed

    private void btnRefresh_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh_userActionPerformed
        // TODO add your handling code here:
        bacaData();
        bacaUser();
        bacaPesan();
    }//GEN-LAST:event_btnRefresh_userActionPerformed

    private void btnKeluar_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluar_userActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKeluar_userActionPerformed
    
        // method set field form jika salah satu field tabel ditekan
    private void setField()
    {
        int row=tabelUser.getSelectedRow();
        txtChat_user.setText((String)tabelUser.getValueAt(row,0));
        txtUsername_user.setText((String)tabelUser.getValueAt(row,1));
    }

    // method baca data dari Mysql dimasukkan ke table pada form
    private void bacaData() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsBrg = stm.executeQuery("select * from user");
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
            tabelUser.setModel(new DefaultTableModel(dataTable,header));
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void bacaUser() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            stm=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=stm.executeQuery("select * from user");
            rs.beforeFirst();
//            while(rs.next()) {
//                cmbMember.addItem(rs.getString(2).trim());
//            }
//                rs.close();
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

//        // Display messages in the text area
//        SwingUtilities.invokeLater(() -> {
//            for (String message : messages) {
//                txtPesanMasukKeluar.append(message + "\n");
//            }
//        });
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
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnClear_user;
    private javax.swing.JButton btnDaftar_user;
    private javax.swing.JButton btnEdit_user;
    private javax.swing.JButton btnHapus_user;
    private javax.swing.JButton btnKeluar_user;
    private javax.swing.JButton btnRefresh_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelUser;
    private javax.swing.JTextField txtChat_user;
    private javax.swing.JTextField txtUsername_user;
    // End of variables declaration//GEN-END:variables
}
