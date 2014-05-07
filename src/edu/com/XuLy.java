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
    private center ce;

    public XuLy(Socket client, ServerSocket server, JTextArea area, BanDoGame bando, Thread ts,center ce) {
        try {
            this.client = client;
            this.server = server;
            this.area = area;
            this.bando = bando;
            this.ts = ts;
            this.ce = ce;
            data = new Packet();
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    public void sendMessage(String msg) {
        try {
            out.writeBytes(data.setMsg(msg) + "\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Không thể gửi dữ liệu", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sendKhoiTao(Point[] begin, int[] arr) {
        try {
            out.writeBytes(data.setMsg(begin, arr) + "\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Không thể gửi dữ liệu", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sendClose() {
        try {
            out.writeBytes(data.setClose());
            client.close();
            if (server != null) {
                server.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.exit(0);
        }
    }

    public void sendDienBan(Point point) {
        try {
            out.writeBytes(data.setMsg(point) + "\n");
        } catch (IOException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    this.recvToaDo(msg);
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
        bando.setBeginClient(true);
        if (bando.isBeginHost()) {
            ce.setThua(true);
            area.append("Đối thủ đã sẵng sàng, trận đấu bắt đầu.\n");
            if (bando.isFlags()) {
                area.append("Bạn bắn trước.\n");
            } else {
                area.append("Đối thủ bắn trước.\n");
            }
        } else {
            area.append("Đối thủ đã sẵng sàng, họ đang chờ bạn đó.\n");
        }

        bando.repaint();
    }

    public void recvTinNhan(String msg) {
        area.append("Đối thủ: " + data.getMsg(msg) + "\n");
    }

    public void recvToaDo(String msg) {
        Point point = data.getPoint(msg);
        bando.setDiemBan(point);
    }

    public void recvDongLienKet() {
        try {
            area.append("Đối thủ đã thoát\n");
            ce.setBatdau(false);
            ce.setGui(false);
            ce.setThietlap(false);
            ce.setThua(false);
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (server != null) {
                ts.start();
            }
        }
    }
}
