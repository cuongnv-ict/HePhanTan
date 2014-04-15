/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.com;

import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author nguyen van cuong
 */
public class XuLy {

    Socket client;
    JTextArea area;
    private DataInputStream in;
    private DataOutputStream out;
    private Packet data;
    private BanDoGame bando;

    public XuLy(Socket client, JTextArea area, BanDoGame bando) {
        try {
            this.client = client;
            this.area = area;
            this.bando = bando;
            data = new Packet();
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    public void sendMessage(String msg) {
        try {
            out.writeBytes(data.setMsg(msg)+"\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Không thể gửi dữ liệu", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sendKhoiTao() {
    }

    public void sendClose() {
    }

    public void sendDienBan(Point point) {
    }

    public boolean listen() {
        try {
           String msg = in.readLine();
            switch (data.getItype(msg)) {
                case Packet.KHOITAO:
                    this.recvKhoiTao();
                    break;
                case Packet.TINNHAN:
                    this.recvTinNhan(msg);
                    break;
                case Packet.TOADO:
                    this.recvToaDo();
                    break;
                case Packet.DONGKETNOI:
                    this.recvDongLienKet();
                    break;
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    public void recvKhoiTao() {
    }

    public void recvTinNhan(String msg) {
        area.append("Đối thủ: " + data.getMsg(msg) + "\n");
    }

    public void recvToaDo() {
    }

    public void recvDongLienKet() {
    }
}
