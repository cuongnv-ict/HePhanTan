/*//GEN-FIRST:event_formMouseClicked
 * To change this template, choose Tools | Templates//GEN-LAST:event_formMouseClicked
 * and open the template in the editor.
 */
package edu.com;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author nguyen van cuong
 */
public class BanDoGame extends javax.swing.JPanel {

    /**
     * Creates new form BanDoGame
     */
    public static final int BATDAU = 1;
    public static final int THIETLAP = 2;
    public static final int NHANTHUA = 3;
    /*
     * Khởi tạo file ảnh
     */
    private ImageIcon tau1[];
    private ImageIcon tau2[];
    private ImageIcon tau3[];
    private ImageIcon tau4[];
    private ImageIcon tau5[];
    private ImageIcon no1[];
    private ImageIcon no2[];
    private ImageIcon no3[];
    private ImageIcon no4[];
    private ImageIcon no5[];
    private ImageIcon anhnen;
    /*
     * Khởi tạo vị trí tàu và hướng tàu
     */
    private Point begin[];
    private int arrImage[];//Giá trị 0 là đứng,1 là nằm ngang
    /*
     * Sử dụng để căn lề tàu trên bản đồ
     */
    private Point XY1[];
    private Point XY2[];
    private Point XY3[];
    private Point XY4[];
    private Point XY5[];
    /*
     * Chiều dài mỗi tàu
     */
    private int length[];
    private boolean isClient;//Kien tra xem chuong trinh o mo hinh nao;
    private int status;//Kiem tra xem chuong trinh o trang thai nao;
    private int serial;
    private int[] local;//Can le toa do di chuyen
    /*
     * Luu toa do doi thu
     */
    private Point rival[];
    private int arrRival[];

    public BanDoGame() {
        initComponents();
        tau1 = new ImageIcon[2];
        tau2 = new ImageIcon[2];
        tau3 = new ImageIcon[2];
        tau4 = new ImageIcon[2];
        tau5 = new ImageIcon[2];
        no1 = new ImageIcon[2];
        no2 = new ImageIcon[2];
        no3 = new ImageIcon[2];
        no4 = new ImageIcon[2];
        no5 = new ImageIcon[2];
        XY1 = new Point[2];
        XY2 = new Point[2];
        XY3 = new Point[2];
        XY4 = new Point[2];
        XY5 = new Point[2];
        begin = new Point[5];
        arrImage = new int[5];
        length = new int[5];
        local = new int[5];
        XY1[0] = new Point(-4, 4);
        XY1[1] = new Point(4, -4);
        XY2[0] = new Point(0, -5);
        XY2[1] = new Point(-5, 0);
        XY3[0] = new Point(-3, -2);
        XY3[1] = new Point(-2, -3);
        XY4[0] = new Point(-2, 0);
        XY4[1] = new Point(0, -2);
        XY5[0] = new Point(0, -3);
        XY5[1] = new Point(-3, 0);
        length[0] = 5;
        length[1] = 2;
        length[2] = 3;
        length[3] = 3;
        length[4] = 4;
        local[0] = 125;
        local[1] = 50;
        local[2] = 75;
        local[3] = 75;
        local[4] = 100;
        tau1[0] = new ImageIcon(this.getClass().getResource("image/TauSanBay2.png"));
        tau1[1] = new ImageIcon(this.getClass().getResource("image/TauSanBay3.png"));
        tau2[0] = new ImageIcon(this.getClass().getResource("image/tauChien2.png"));
        tau2[1] = new ImageIcon(this.getClass().getResource("image/tauChien3.png"));
        tau3[0] = new ImageIcon(this.getClass().getResource("image/tauNgam2.png"));
        tau3[1] = new ImageIcon(this.getClass().getResource("image/tauNgam3.png"));
        tau4[0] = new ImageIcon(this.getClass().getResource("image/tauNgu2.png"));
        tau4[1] = new ImageIcon(this.getClass().getResource("image/tauNgu3.png"));
        tau5[0] = new ImageIcon(this.getClass().getResource("image/tauThuyChien1.png"));
        tau5[1] = new ImageIcon(this.getClass().getResource("image/tauThuyChien2.png"));
        no1[0] = new ImageIcon(this.getClass().getResource("image/TauSanBay2-no.png"));
        no1[1] = new ImageIcon(this.getClass().getResource("image/TauSanBay3-no.png"));
        no2[0] = new ImageIcon(this.getClass().getResource("image/tauChien2-no.png"));
        no2[1] = new ImageIcon(this.getClass().getResource("image/tauChien3-no.png"));
        no3[0] = new ImageIcon(this.getClass().getResource("image/tauNgam2-no.png"));
        no3[1] = new ImageIcon(this.getClass().getResource("image/tauNgam3-no.png"));
        no4[0] = new ImageIcon(this.getClass().getResource("image/tauNgu2-no.png"));
        no4[1] = new ImageIcon(this.getClass().getResource("image/tauNgu3-no.png"));
        no5[0] = new ImageIcon(this.getClass().getResource("image/tauThuyChien1-no.png"));
        no5[1] = new ImageIcon(this.getClass().getResource("image/tauThuyChien2-no.png"));
        anhnen = new ImageIcon(this.getClass().getResource("image/song cuon.png"));
        status = THIETLAP;
        isClient = true;
        serial = -1;
        rival = null;
        arrRival = null;
        this.setDefaultPoint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    public void setDefaultPoint() {
        if (isClient) {
            begin[0] = new Point(300, 10);
            begin[1] = new Point(475, 60);
            begin[2] = new Point(400, 85);
            begin[3] = new Point(450, 160);
            begin[4] = new Point(375, 210);
        } else {
            begin[0] = new Point(10, 10);
            begin[1] = new Point(185, 60);
            begin[2] = new Point(110, 85);
            begin[3] = new Point(160, 160);
            begin[4] = new Point(85, 210);
        }
        arrImage[0] = 0;
        arrImage[1] = 1;
        arrImage[2] = 0;
        arrImage[3] = 1;
        arrImage[4] = 1;
        repaint();
    }

    public boolean getNumber(Point point, int number) {
        if (!isClient) {
            if (arrImage[number] == 0) {
                if ((((point.x - 10) / 25) == ((begin[number].x - 10) / 25))
                        && (((point.y - 10) / 25) >= ((begin[number].y - 10) / 25))
                        && (((point.y - 10) / 25) < ((begin[number].y - 10) / 25) + length[number])) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if ((((point.y - 10) / 25) == ((begin[number].y - 10) / 25))
                        && (((point.x - 10) / 25) >= ((begin[number].x - 10) / 25))
                        && (((point.x - 10) / 25) < ((begin[number].x - 10) / 25) + length[number])) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (arrImage[number] == 0) {
                if ((((point.x - 300) / 25) == ((begin[number].x - 300) / 25))
                        && (((point.y - 10) / 25) >= ((begin[number].y - 10) / 25))
                        && (((point.y - 10) / 25) < ((begin[number].y - 10) / 25) + length[number])) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if ((((point.y - 10) / 25) == ((begin[number].y - 10) / 25))
                        && (((point.x - 300) / 25) >= ((begin[number].x - 300) / 25))
                        && (((point.x - 300) / 25) < ((begin[number].x - 300) / 25) + length[number])) {
                    return true;
                } else {
                    return false;
                }
            }
        }

    }

    public void getLocal(int number) {
    }
    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && serial != -1) {
            this.changeImage();
        }

        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2) {
            if (evt.getX() > 10 && evt.getX() < 260 && evt.getY() > 10 && evt.getX() < 260) {
                Point point = new Point();
                point.x = (evt.getY() - 10) / 25;
                point.y = (evt.getX() - 10) / 25;
                System.out.println(point.x + "-" + point.y);
            } else if (evt.getX() > 300 && evt.getX() < 550 && evt.getY() > 10 && evt.getY() < 260) {
                Point point = new Point();
                point.x = (evt.getY() - 10) / 25;
                point.y = (evt.getX() - 300) / 25;
                System.out.println(point.x + "-" + point.y);
            }
        }
        repaint();
    }                                 

    public void changeImage() {
        arrImage[serial] = Math.abs(1 - arrImage[serial]);
        if (arrImage[serial] == 0) {
            if ((begin[serial].y + local[serial]) > 260) {
                begin[serial].y = 260 - local[serial];
            }
            repaint();
        } else {
            if (isClient) {
                if ((begin[serial].x + local[serial]) > 550) {
                    begin[serial].x = 550 - local[serial];
                }
            } else {
                if ((begin[serial].x + local[serial]) > 260) {
                    begin[serial].x = 260 - local[serial];
                }
            }
            repaint();
        }
    }
    private void formMouseDragged(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        if (status == THIETLAP && serial == -1) {
            return;
        }
        if (!isClient) {
            if (evt.getX() > 10 && evt.getX() < 260 && evt.getY() > 10 && evt.getY() < 260) {
                int x, y;
                if (arrImage[serial] == 0) {
                    if (evt.getY() >= 260 - local[serial]) {
                        y = 260 - local[serial];
                    } else {
                        y = evt.getY();
                    }
                    x = evt.getX();
                } else {
                    if (evt.getX() >= 260 - local[serial]) {
                        x = 260 - local[serial];
                    } else {
                        x = evt.getX();
                    }
                    y = evt.getY();
                }
                begin[serial].x = ((x - 10) / 25) * 25 + 10;
                begin[serial].y = ((y - 10) / 25) * 25 + 10;
            }
        } else {
            if (evt.getX() > 300 && evt.getX() < 550 && evt.getY() > 10 && evt.getY() < 260) {
                int x, y;
                if (arrImage[serial] == 0) {
                    if (evt.getY() >= 260 - local[serial]) {
                        y = 260 - local[serial];
                    } else {
                        y = evt.getY();
                    }
                    x = evt.getX();
                } else {
                    if (evt.getX() >= 550 - local[serial]) {
                        x = 550 - local[serial];
                    } else {
                        x = evt.getX();
                    }
                    y = evt.getY();
                }
                begin[serial].x = ((x - 300) / 25) * 25 + 300;
                begin[serial].y = ((y - 10) / 25) * 25 + 10;
            }
        }
        repaint();
    }                                 

    private void formMousePressed(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        Point point = new Point(evt.getX(), evt.getY());
        for (int i = 0; i < 5; i++) {
            if (getNumber(point, i)) {
                serial = i;
                break;
            }
            serial = -1;
        }
    }                                 

    // Variables declaration - do not modify                     
    // End of variables declaration                   
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(anhnen.getImage(), 0, 0, 560, 270, null);
        for (int i = 0; i < 11; i++) {
            g.drawLine(10, 10 + (i * 25), 260, (i * 25) + 10);
            g.drawLine(10 + (i * 25), 10, 10 + (i * 25), 260);
        }
        for (int i = 0; i < 11; i++) {
            g.drawLine(300, 10 + (i * 25), 550, (i * 25) + 10);
            g.drawLine(300 + (i * 25), 10, 300 + (i * 25), 260);
        }
        g.drawImage(tau1[arrImage[0]].getImage(), begin[0].x + XY1[arrImage[0]].x, begin[0].y + XY1[arrImage[0]].y, tau1[arrImage[0]].getImage().getWidth(this), tau1[arrImage[0]].getImage().getHeight(this), null);
        g.drawImage(tau2[arrImage[1]].getImage(), begin[1].x + XY2[arrImage[1]].x, begin[1].y + XY2[arrImage[1]].y, tau2[arrImage[1]].getImage().getWidth(this), tau2[arrImage[1]].getImage().getHeight(this), null);
        g.drawImage(tau3[arrImage[2]].getImage(), begin[2].x + XY3[arrImage[2]].x, begin[2].y + XY3[arrImage[2]].y, tau3[arrImage[2]].getImage().getWidth(this), tau3[arrImage[2]].getImage().getHeight(this), null);
        g.drawImage(tau4[arrImage[3]].getImage(), begin[3].x + XY4[arrImage[3]].x, begin[3].y + XY4[arrImage[3]].y, tau4[arrImage[3]].getImage().getWidth(this), tau4[arrImage[3]].getImage().getHeight(this), null);
        g.drawImage(tau5[arrImage[4]].getImage(), begin[4].x + XY5[arrImage[4]].x, begin[4].y + XY5[arrImage[4]].y, tau5[arrImage[4]].getImage().getWidth(this), tau5[arrImage[4]].getImage().getHeight(this), null);
        if (rival == null || arrRival == null) {
            return;
        }
        g.drawImage(no1[arrRival[0]].getImage(), rival[0].x + XY1[arrRival[0]].x, rival[0].y + XY1[arrRival[0]].y, no1[arrRival[0]].getImage().getWidth(this), no1[arrRival[0]].getImage().getHeight(this), null);
        g.drawImage(no2[arrRival[1]].getImage(), rival[1].x + XY2[arrRival[1]].x, rival[1].y + XY2[arrRival[1]].y, no2[arrRival[1]].getImage().getWidth(this), no2[arrRival[1]].getImage().getHeight(this), null);
        g.drawImage(no3[arrRival[2]].getImage(), rival[2].x + XY3[arrRival[2]].x, rival[2].y + XY3[arrRival[2]].y, no3[arrRival[2]].getImage().getWidth(this), no3[arrRival[2]].getImage().getHeight(this), null);
        g.drawImage(no4[arrRival[3]].getImage(), rival[3].x + XY4[arrRival[3]].x, rival[3].y + XY4[arrRival[3]].y, no4[arrRival[3]].getImage().getWidth(this), no4[arrRival[3]].getImage().getHeight(this), null);
        g.drawImage(no5[arrRival[4]].getImage(), rival[4].x + XY5[arrRival[4]].x, rival[4].y + XY5[arrRival[4]].y, no5[arrRival[4]].getImage().getWidth(this), no5[arrRival[4]].getImage().getHeight(this), null);

    }

    public void setIsClient(boolean is) {
        isClient = is;
    }

    public void setStatus(int s) {
        status = s;
    }

    public Point[] getBegin() {
        return begin;
    }

    public int[] getArrImage() {
        return arrImage;
    }

    public void setRival(Point[] begin) {
        rival = begin;
    }

    public void setArrRival(int[] arr) {
        arrRival = arr;
    }
    /*
     * Su dung xet tuong quan giua cac tau
     */

    public boolean testLocal() {
        Boolean test1 = testSpace(setArr(0), setArr(1)) && testSpace(setArr(0), setArr(2)) && testSpace(setArr(0), setArr(3)) && testSpace(setArr(0), setArr(4));
        Boolean test2 = testSpace(setArr(1), setArr(2)) && testSpace(setArr(1), setArr(3)) && testSpace(setArr(1), setArr(4));
        Boolean test3 = testSpace(setArr(2), setArr(3)) && testSpace(setArr(2), setArr(4));
        Boolean test4 = testSpace(setArr(3), setArr(4));
        return test1 && test2 && test3 && test4;
    }

    private boolean testSpace(ArrayList<Integer> b, ArrayList<Integer> e) {
        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < e.size(); j++) {
                if (b.get(i) == e.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private ArrayList<Integer> setArr(int number) {
        ArrayList<Integer> e = new ArrayList<Integer>();
        if (isClient) {
        } else {
            int row = begin[number].y / 25;
            int column = begin[number].x / 25;
            e.add(row * 10 + column);
            if (arrImage[number] == 0) {
                for (int i = 0; i < length[number]; i++) {
                    e.add((row + i) * 10 + column);
                }
            } else {
                for (int i = 0; i < length[number]; i++) {
                    e.add((row) * 10 + column + i);
                }
            }
        }
        return e;
    }
}
