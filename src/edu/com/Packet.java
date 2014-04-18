/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.com;

import java.awt.Point;

/**
 *
 * @author nguyen van cuong
 */
public class Packet {

    public static final int TINNHAN = 1;// Ma dùng dể gửi tin nhắn
    public static final int KHOITAO = 2;// Mã dùng đẻ gửi tọa độ các tàu
    public static final int TOADO = 3; //Mã tạo độ bắn
    public static final int DONGKETNOI = 4;//Mã đóng kết nối
    private int iType;//Loai goi tin
    private String msg;//Noi dung tin nhan
    /*
     * Quá trình phân dữ liệu được phân cách bởi dấu : dùng để tách các đối tượng
     * Sử dụng dấu - để tách thuộc tính trong 1 đối tượng
     */
    /*
     * Mã hóa thông điệp tin nhắn
     */

    public int getItype(String msg) {
        String arr[] = msg.split(":", 2);
        return Integer.parseInt(arr[0]);
    }

    public String setMsg(String msg) {
        this.msg = String.valueOf(TINNHAN) + ":" + msg;
        return this.msg;
    }

    public String getMsg(String msg) {
        String arr[] = msg.split(":", 2);
        return arr[1];
    }
    /*
     * Mã hóa thông điệp tọa độ bắn
     */

    public String setMsg(Point point) {
        this.msg = String.valueOf(TOADO) + ":" + String.valueOf(point.x) + "-" + String.valueOf(point.y);
        return this.msg;
    }

    public Point getPoint(String msg) {
        String arr[] = msg.split(":", 2);
        arr = arr[1].split("-");
        return new Point(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
    }
    /*
     * Mã hóa thông điệp tọa độ các tàu khi khởi tạo
     */

    public String setMsg(Point begin[], int[] arrImage) {
        this.msg = String.valueOf(KHOITAO);
        for (int i = 0; i < 5; i++) {
            this.msg += ":" + String.valueOf(begin[i].x) + "-" + String.valueOf(begin[i].y) + "-" + arrImage[i];
        }
        return this.msg;
    }

    public void getAllPoint(Point begin[], int arrImage[], String msg) {
        String arr[] = msg.split(":", 2);
        String temp[];
        arr = arr[1].split(":");
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i].split("-");
            begin[i] = new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            arrImage[i] = Integer.parseInt(temp[2]);
        }
    }
    /*
     * Mã hóa thông điệp đóng kết nối
     */

    public String setClose() {
        this.msg = String.valueOf(DONGKETNOI);
        return this.msg;
    }
}
