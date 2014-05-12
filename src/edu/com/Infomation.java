/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.com;

import java.util.Random;

/**
 *
 * @author nguyen van cuong
 */
public class Infomation {

    public static final int BATDAU = 1;
    public static final int THIETLAP = 2;
    public static final int NHANTHUA = 3;
    public static final int SERVER = 1;
    public static final int CLIENT = -1;
    public static final int DEFINITE = 0;
    public static final int DAN1 = 0;
    public static final int DAN2 = 100;
    public static final int DAN3 = 100;
    public static final int DAN4 = 100;
    public static final int DAN5 = 100;
    public static final int DAN6 = 100;
    public static final int DAN7 = 100;
    public static final int DAN8 = 100;
    public static final int LOAI1 = 1;
    public static final int LOAI2 = 2;
    public static final int LOAI3 = 3;
    public static final int LOAI4 = 4;
    public static final int LOAI5 = 5;
    public static final int LOAI6 = 6;
    public static final int LOAI7 = 7;
    public static final int LOAI8 = 8;

    public static int getRandom(int y) {
        return Math.abs(new Random().nextInt()) % y;
    }
}
