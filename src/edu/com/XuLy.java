/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.com;

import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
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

    private Socket client;
    private ServerSocket server;
    private JTextArea area;
    private DataInputStream in;
    private DataOutputStream out;
    private Packet data;
    private BanDoGame bando;
    private Thread ts;

    public XuLy(Socket client,ServerSocket server, JTextArea area, BanDoGame bando,Thread ts) {
        try {
            this.client = client;
            this.server = server;
            this.area = area;
            this.bando = bando;
            this.ts = ts;
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

    public void sendKhoiTao(Point []begin,int []arr) {
        try {
            out.writeBytes(data.setMsg(begin,arr)+"\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Không thể gửi dữ liệu", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sendClose() {
        try {
            out.writeBytes(data.setClose());
            client.close();
            if(server!=null){
                server.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            System.exit(0);
        }
    }

    public void sendDienBan(Point point) {
    }

    public boolean listen() {
        try {
           String msg = in.readLine();
            switch (data.getItype(msg)) {
                case Packet.KHOITAO:
                    this.recvKhoiTao(msg);
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

    public void recvKhoiTao(String msg) {
        Point begin[] = new Point[5];
        int arr[] = new int[5];
        data.getAllPoint(begin, arr, msg);
        bando.setArrRival(arr);
        bando.setRival(begin);
        bando.repaint();
    }

    public void recvTinNhan(String msg) {
        area.append("Đối thủ: " + data.getMsg(msg) + "\n");
    }

    public void recvToaDo() {
    }

    public void recvDongLienKet() {
        try {
            area.append("Đối thủ đã thoát\n");
            client.close();        
        } catch (IOException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(server!=null){
                ts.start();
            }
        }
    }
}
