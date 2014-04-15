/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author nguyen van cuong
 */
public class ServerClient {
    public static ServerSocket createServerSocket(int port){
        try {
            ServerSocket server = new ServerSocket(port,1);
            return server;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khởi tạo: "+ex.toString(), "Lỗi khởi tạo",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public static Socket connectServer(String ip,int port){
        try {
            Socket client = new Socket(ip, port);
            return client;
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Hãy xác định lại địa chỉ IP cần kết nối", "Lỗi kết nối",JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Hãy xác định lại cổng muốn kết nối", "Lỗi kết nối",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
