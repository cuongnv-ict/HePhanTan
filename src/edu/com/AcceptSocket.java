/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.com;

import java.net.ServerSocket;

/**
 *
 * @author nguyen van cuong
 */
public class AcceptSocket extends Thread{
    ServerSocket server;
    public AcceptSocket(ServerSocket server){
        this.server = server;
    }
}
