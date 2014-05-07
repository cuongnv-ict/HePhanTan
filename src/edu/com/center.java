/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.com;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nguyen van cuong
 */
public class center extends javax.swing.JFrame {

    /**
     * Creates new form center
     */
    private boolean flags_khoitao;
    private boolean flags_thamgia;
    private ServerSocket server = null;
    private Socket client = null;
    private Thread ts;
    private BanDoGame bando;
    protected XuLy xuly;

    public center() {
        initComponents();
        this.setResizable(false);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 400, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 300);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        xuly = null;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (xuly == null) {
                    System.exit(0);
                } else {
                    xuly.sendClose();
                }
            }
        });
        bando = new BanDoGame();
        TuyChon.add(TaoTran);
        TuyChon.add(ThamGia);
        bando.setSize(560, 270);
        bando.setLocation(20, 20);
        trungtam.add(bando);
        /*
         * Khoi phuc kha nang tao socket co chuc nang nhu server
         */
        setKhoiTao(true);
        /*
         * Tat kha nang tham gia ket noi
         */
        setKetNoi(false);
        flags_khoitao = true;
        flags_thamgia = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TuyChon = new javax.swing.ButtonGroup();
        trungtam = new javax.swing.JPanel();
        tuychon = new javax.swing.JPanel();
        TaoTran = new javax.swing.JRadioButton();
        ThamGia = new javax.swing.JRadioButton();
        Port_TaoTran = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        KhoiTao = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        IP_TaoTran = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        IP_ThamGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Port_ThamGia = new javax.swing.JTextField();
        KetNoi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        text = new javax.swing.JTextField();
        gui = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        batdau = new javax.swing.JButton();
        thua = new javax.swing.JButton();
        thietlap = new javax.swing.JButton();
        thoat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tuychon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tùy Chọn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        TaoTran.setSelected(true);
        TaoTran.setText("Tạo trận");
        TaoTran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoTranActionPerformed(evt);
            }
        });

        ThamGia.setText("Tham gia");
        ThamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThamGiaActionPerformed(evt);
            }
        });

        jLabel1.setText("Port :");

        KhoiTao.setText("Khởi tạo");
        KhoiTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KhoiTaoActionPerformed(evt);
            }
        });

        jLabel2.setText("IP :");

        IP_TaoTran.setEditable(false);

        jLabel3.setText("IP :");

        jLabel4.setText("Port :");

        KetNoi.setText("Kết nối");
        KetNoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KetNoiActionPerformed(evt);
            }
        });

        area.setEditable(false);
        area.setColumns(20);
        area.setLineWrap(true);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        gui.setText("Gửi");
        gui.setEnabled(false);
        gui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tuychonLayout = new javax.swing.GroupLayout(tuychon);
        tuychon.setLayout(tuychonLayout);
        tuychonLayout.setHorizontalGroup(
            tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tuychonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addGroup(tuychonLayout.createSequentialGroup()
                        .addComponent(text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gui))
                    .addGroup(tuychonLayout.createSequentialGroup()
                        .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tuychonLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tuychonLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(IP_ThamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(tuychonLayout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(IP_TaoTran))
                                        .addGroup(tuychonLayout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Port_ThamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(KetNoi, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(tuychonLayout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Port_TaoTran, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(KhoiTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(TaoTran)
                            .addComponent(ThamGia))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tuychonLayout.setVerticalGroup(
            tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tuychonLayout.createSequentialGroup()
                .addComponent(TaoTran)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IP_TaoTran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KhoiTao, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Port_TaoTran)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThamGia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IP_ThamGia)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KetNoi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Port_ThamGia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(tuychonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gui)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chơi Game", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        batdau.setText("Bắt đầu");
        batdau.setEnabled(false);
        batdau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batdauActionPerformed(evt);
            }
        });

        thua.setText("Nhận thua");
        thua.setEnabled(false);

        thietlap.setText("Thiết lập");
        thietlap.setEnabled(false);
        thietlap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thietlapActionPerformed(evt);
            }
        });

        thoat.setText("Thoát");
        thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/com/image/dan.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/com/image/dan.png"))); // NOI18N
        jLabel6.setToolTipText("");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/com/image/dan.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/com/image/dan.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/com/image/dan.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/com/image/dan.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/com/image/dan.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/com/image/dan.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/com/image/dan.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Loại đạn sẽ bắn :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Số tiền :");

        jTextField1.setEditable(false);
        jTextField1.setText("100");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(batdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thietlap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(thietlap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(thua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thoat))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout trungtamLayout = new javax.swing.GroupLayout(trungtam);
        trungtam.setLayout(trungtamLayout);
        trungtamLayout.setHorizontalGroup(
            trungtamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trungtamLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tuychon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trungtamLayout.setVerticalGroup(
            trungtamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tuychon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trungtamLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(trungtam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(trungtam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setKhoiTao(boolean flags) {
        Port_TaoTran.setEnabled(flags);
        IP_TaoTran.setEnabled(flags);
        KhoiTao.setEnabled(flags);
        IP_TaoTran.setText("");
    }

    private void setKetNoi(boolean flags) {
        Port_ThamGia.setEnabled(flags);
        IP_ThamGia.setEnabled(flags);
        KetNoi.setEnabled(flags);
    }

    private void KetNoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KetNoiActionPerformed
        // TODO add your handling code here:
        if (flags_thamgia) {
            try {
                client = ServerClient.connectServer(IP_ThamGia.getText(), Integer.parseInt(Port_ThamGia.getText()));
                if (client != null) {
                    bando.setIsClient(Infomation.CLIENT);
                    bando.setFlags(false);
                    flags_thamgia = false;
                    IP_ThamGia.setEditable(false);
                    TaoTran.setEnabled(false);
                    Port_ThamGia.setEditable(false);
                    KetNoi.setText("Hủy kết nối");
                }
                xuly = new XuLy(client, null, area, bando, ts);
                (ts = new Thread() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(rootPane, "Đã kết nối thành công", null, JOptionPane.INFORMATION_MESSAGE);
                        gui.setEnabled(true);
                        thietlap.setEnabled(true);
                        batdau.setEnabled(true);
                        bando.setLive();
                        bando.setXuly(xuly);
                        bando.setDefaultPoint();
                        new Thread() {
                            @Override
                            public void run() {
                                while (true) {
                                    if (!xuly.listen()) {
                                        break;
                                    }
                                }
                            }
                        }.start();
                    }
                }).start();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Hãy kiển tra lại cổng khởi tạo của bạn", "Lỗi cổng kết nối", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                client.close();
                client = null;
                ts.stop();
            } catch (IOException ex) {
                Logger.getLogger(center.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                flags_thamgia = true;
                IP_ThamGia.setEditable(true);
                Port_ThamGia.setEditable(true);
                TaoTran.setEnabled(true);
                KetNoi.setText("Kết nối");
                xuly = null;
            }
        }
    }//GEN-LAST:event_KetNoiActionPerformed

    private void KhoiTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhoiTaoActionPerformed
        // TODO add your handling code here:
        if (flags_khoitao) {
            try {
                server = ServerClient.createServerSocket(Integer.parseInt(Port_TaoTran.getText()));
                if (server != null) {
                    KhoiTao.setText("Hủy kết nối");
                    Port_TaoTran.setEditable(false);
                    flags_khoitao = false;
                    ThamGia.setEnabled(false);
                    bando.setFlags(true);
                    IP_TaoTran.setText(InetAddress.getLocalHost().getHostAddress());
                    (ts = new Thread() {
                        @Override
                        public void run() {
                            try {
                                client = server.accept();
                                JOptionPane.showMessageDialog(rootPane, "Có kết nối đến máy bạn ", null, JOptionPane.INFORMATION_MESSAGE);
                                gui.setEnabled(true);
                                thietlap.setEnabled(true);
                                batdau.setEnabled(true);
                                xuly = new XuLy(client, server, area, bando, ts);
                                bando.setIsClient(Infomation.SERVER);
                                bando.setXuly(xuly);
                                bando.setLive();
                                bando.setDefaultPoint();
                                new Thread() {
                                    @Override
                                    public void run() {
                                        while (true) {
                                            if (!xuly.listen()) {
                                                break;
                                            }
                                        }
                                    }
                                }.start();
                            } catch (IOException ex) {
                                Logger.getLogger(center.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }).start();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Hãy kiển tra lại cổng khởi tạo của bạn", "Lỗi cổng kết nối", JOptionPane.ERROR_MESSAGE);
            } catch (UnknownHostException ex) {
                JOptionPane.showMessageDialog(rootPane, "Không thể xác định địa chỉ IP của máy", "Lỗi cổng kết nối", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                if (client != null) {
                    client.close();
                    client = null;
                }
                server.close();
                server = null;

            } catch (IOException ex) {
                Logger.getLogger(center.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ts.stop();
                flags_khoitao = true;
                Port_TaoTran.setEditable(true);
                KhoiTao.setText("Khởi tạo");
                ThamGia.setEnabled(true);
                IP_TaoTran.setText("");
                xuly = null;
            }
        }

    }//GEN-LAST:event_KhoiTaoActionPerformed

    private void ThamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThamGiaActionPerformed
        // TODO add your handling code here:
        /*
         * Tat kha nang tao socket co chuc nang nhu server
         */
        setKhoiTao(false);
        /*
         * Khoi phuc kha nang tham gia ket noi
         */
        setKetNoi(true);
    }//GEN-LAST:event_ThamGiaActionPerformed

    private void TaoTranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoTranActionPerformed
        // TODO add your handling code here:
        /*
         * Khoi phuc kha nang tao socket co chuc nang nhu server
         */
        setKhoiTao(true);
        /*
         * Tat kha nang tham gia ket noi
         */
        setKetNoi(false);

    }//GEN-LAST:event_TaoTranActionPerformed

    private void guiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiActionPerformed
        // TODO add your handling code here:
        if (client == null) {
            return;
        }
        //dua vao ham su ly
        if (text.getText().equals("")) {
            return;
        }
        area.append("Ban: " + text.getText() + "\n");
        xuly.sendMessage(text.getText());
        text.setText("");
    }//GEN-LAST:event_guiActionPerformed

    private void thietlapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thietlapActionPerformed
        // TODO add your handling code here:
        if (client == null) {
            return;
        }
        bando.setDefaultPoint();
        bando.setStatus(Infomation.THIETLAP);
    }//GEN-LAST:event_thietlapActionPerformed

    private void batdauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batdauActionPerformed
        // TODO add your handling code here:
        if (client == null) {
            return;
        }
        if (bando.testLocal()) {
            xuly.sendKhoiTao(bando.getBegin(), bando.getArrImage());
            bando.setStatus(Infomation.BATDAU);
            bando.setBeginHost(true);
            if (bando.isBeginClient()) {
                area.append("Bạn đã sẵng sàng, trận đấu bắt đầu.\n");
                if (bando.isFlags()) {
                    area.append("Bạn bắn trước.\n");
                } else {
                    area.append("Đối thủ bắn trước.\n");
                }
            } else {
                area.append("Bạn đã sẵng sàng, vui lòng chờ đối thủ.\n");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể thiết lập 2 tàu trùng nhau", null, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_batdauActionPerformed

    private void thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoatActionPerformed
        // TODO add your handling code here:
        if (xuly == null) {
            System.exit(0);
        } else {
            xuly.sendClose();
        }
    }//GEN-LAST:event_thoatActionPerformed

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
            java.util.logging.Logger.getLogger(center.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(center.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(center.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(center.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new center().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IP_TaoTran;
    private javax.swing.JTextField IP_ThamGia;
    private javax.swing.JButton KetNoi;
    private javax.swing.JButton KhoiTao;
    private javax.swing.JTextField Port_TaoTran;
    private javax.swing.JTextField Port_ThamGia;
    private javax.swing.JRadioButton TaoTran;
    private javax.swing.JRadioButton ThamGia;
    private javax.swing.ButtonGroup TuyChon;
    private javax.swing.JTextArea area;
    private javax.swing.JButton batdau;
    private javax.swing.JButton gui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField text;
    private javax.swing.JButton thietlap;
    private javax.swing.JButton thoat;
    private javax.swing.JButton thua;
    private javax.swing.JPanel trungtam;
    private javax.swing.JPanel tuychon;
    // End of variables declaration//GEN-END:variables
}
