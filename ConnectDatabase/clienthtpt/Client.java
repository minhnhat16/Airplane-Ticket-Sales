/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clienthtpt;

import com.serviceExchange.ExchangeData;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Apple Bee
 */
public class Client extends javax.swing.JFrame implements ActionListener {

    private Timer timerDatGhe;
    private Timer timerRefresh;
    private String gheDangDat;

    public JButton[] buttons;
    DataOutputStream dos = null;
    DataInputStream dis = null;
    ExchangeData seatStatus;
    Socket client;
    //String ipServer = "192.168.68.135";
    public String ipServer;

    /**
     * Creates new form Client
     */
    public Client(String ip) {
        ipServer = ip;
        initComponents();
        try {
            client = new Socket(ipServer, 6543);

            // gửi câu lệnh
            dos = new DataOutputStream(client.getOutputStream());
            dis = new DataInputStream(client.getInputStream());
            seatStatus = new ExchangeData();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        gheDangDat = "";

        timerDatGhe = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea_ThongBao.setText(jTextArea_ThongBao.getText() + "\n\n" + "Ghế " + gheDangDat + " đã bị hủy đặt");
                buttons[Integer.parseInt(gheDangDat)].setBackground(Color.green);
                String ok = "SET TRANSACTION ISOLATION LEVEL SERIALIZABLE BEGIN TRAN update TICKET set BLOCK = 0 where ID = " + gheDangDat + " COMMIT";
                try {
                    dos.writeUTF(ok);
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }

                timerDatGhe.stop();
            }
        });
        timerRefresh = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshButtons();
            }
        });

        timerRefresh.start();
        buttons = new JButton[100];
        getDatabase();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_ThongBao = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel_Buttons = new javax.swing.JPanel();
        jButton_Mua = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Vé máy bay");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea_ThongBao.setColumns(20);
        jTextArea_ThongBao.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextArea_ThongBao.setRows(5);
        jScrollPane1.setViewportView(jTextArea_ThongBao);

        jLabel1.setFont(new java.awt.Font("Raleway Black", 1, 14)); // NOI18N
        jLabel1.setText("Notification");

        jPanel_Buttons.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Buttons.setLayout(new java.awt.GridLayout(7, 9, 5, 5));

        jButton_Mua.setBackground(new java.awt.Color(255, 204, 204));
        jButton_Mua.setFont(new java.awt.Font("Raleway Medium", 0, 24)); // NOI18N
        jButton_Mua.setText("Buy");
        jButton_Mua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MuaActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Ticket");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel_Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jButton_Mua, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1)))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Mua, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // reset mỗi 0,5 giây
    public void refreshButtons() {
        try {
            dos.writeUTF("select * from TICKET");
            String sms = dis.readUTF();
            String[] words = seatStatus.seatStatus(sms);

            int x = 0;
            for (int i = words.length - 1; i > 0; i = i - 3) {
                x = Integer.parseInt(words[i - 2]);
                buttons[x].removeActionListener(this);
                if (Integer.parseInt(words[i - 1]) == 1) { // đã được mua                   
                    buttons[x].setBackground(Color.red);
                    buttons[x].removeActionListener(this);

                } else if (Integer.parseInt(words[i]) == 1) { // đã được đặt
                    buttons[x].setBackground(Color.yellow);
                    buttons[x].addActionListener(this);

                } else {// chưa mua, chưa đặt
                    buttons[x].setBackground(Color.green);
                    buttons[x].addActionListener(this);
                }
            }
        } catch (Exception e) {
            try {
                dos.close();
                dis.close();
                client.close();

            } catch (IOException ex) {
                System.out.println("ngat ket noi server");
            }

        }
    }

    // khởi tạo button
    public void getDatabase() {
        try {
            dos.writeUTF("select * from TICKET");
            // đọc dữ liệu từ server
            String sms = dis.readUTF();

            String[] words = seatStatus.seatStatus(sms);

            int x = 0;
            for (int i = words.length - 1; i > 0; i = i - 3) {
                x = Integer.parseInt(words[i - 2]);
                // khởi tạo button
                buttons[x] = new JButton();
                buttons[x].setText(x + "");
                if (Integer.parseInt(words[i - 1]) == 1) { // đã được mua                   
                    buttons[x].setBackground(Color.red);
                    buttons[x].removeActionListener(this);

                } else if (Integer.parseInt(words[i]) == 1) { // đã được đặt
                    buttons[x].setBackground(Color.yellow);
                    buttons[x].addActionListener(this);

                } else {// chưa mua, chưa đặt
                    buttons[x].setBackground(Color.green);
                    buttons[x].addActionListener(this);

                }
                // add button
                jPanel_Buttons.add(buttons[x]);

            }
        } catch (Exception e) {
            try {
                dos.close();
                dis.close();
                client.close();

            } catch (IOException ex) {
                System.out.println("ngat ket noi server");
            }

        }

    }

    private void jButton_MuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MuaActionPerformed
        // TODO add your handling code here:
        if (!timerDatGhe.isRunning()) {
            jTextArea_ThongBao.setText(jTextArea_ThongBao.getText() + "\n\n" + "Bạn chưa đặt ghế!");
            return;
        }
        timerDatGhe.stop();
        jTextArea_ThongBao.setText(jTextArea_ThongBao.getText() + "\n\n" + "Ghế " + gheDangDat + " đã được mua");

        try {
            dos.writeUTF("SET TRANSACTION ISOLATION LEVEL SERIALIZABLE BEGIN TRAN update TICKET set SOLD = 1 where ID = " + gheDangDat + " COMMIT");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i = Integer.parseInt(gheDangDat);
        buttons[i].setBackground(Color.red);
        buttons[i].removeActionListener(this);
    }//GEN-LAST:event_jButton_MuaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        try {
            // TODO add your handling code here:

            dos.writeUTF("SET TRANSACTION ISOLATION LEVEL SERIALIZABLE BEGIN TRAN update TICKET set BLOCK = 0 where SOLD = 0 COMMIT");

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println(btn.getText());
        try {
            dos.writeUTF("select * from TICKET where ID = " + btn.getText());
            String sms = dis.readUTF();
            String[] words = seatStatus.seatStatus(sms);

            if (Integer.parseInt(words[2]) == 1) {
                jTextArea_ThongBao.setText(jTextArea_ThongBao.getText() + "\n\n" + "Ghế " + btn.getText() + " đã được người khác đặt!");
                return;
            }

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (timerDatGhe.isRunning()) {
            timerDatGhe.stop();
            //jTextArea_ThongBao.setText(jTextArea_ThongBao.getText() + "\n\n" + "Ghế " + gheDangDat + " đã bị hủy đặt");
            buttons[Integer.parseInt(gheDangDat)].setBackground(Color.green);

            try {
                dos.writeUTF("SET TRANSACTION ISOLATION LEVEL SERIALIZABLE BEGIN TRAN update TICKET set BLOCK = 0 where ID = " + gheDangDat + " COMMIT");
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        gheDangDat = btn.getText();

        jTextArea_ThongBao.setText(jTextArea_ThongBao.getText() + "\n\n" + "Đang chọn mua ghế " + gheDangDat);
        buttons[Integer.parseInt(gheDangDat)].setBackground(Color.yellow);
        try {
            dos.writeUTF("SET TRANSACTION ISOLATION LEVEL SERIALIZABLE BEGIN TRAN update TICKET set BLOCK = 1 where ID = " + gheDangDat + " COMMIT");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        timerDatGhe.start();
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) throws UnknownHostException, IOException {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Client().setVisible(true);
//            }
//        });     
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Mua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Buttons;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea_ThongBao;
    // End of variables declaration//GEN-END:variables
}
