/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.com;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author nguyen van cuong
 */
public class BanDoGame extends javax.swing.JPanel {

    /**
     * Creates new form BanDoGame
     */
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
    private ImageIcon trung;
    private ImageIcon truot;
    /*
     * Khởi tạo vị trí tàu và hướng tàu
     */
    private Point begin[];
    private int arrImage[];//Giá trị 0 là đứng,1 là nằm ngang
    /*
     * 
     */
    private boolean beginHost;
    private boolean beginClient;
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
    private int isClient;//Kien tra xem chuong trinh o mo hinh nao;
    private int status;//Kiem tra xem chuong trinh o trang thai nao;
    private int serial;
    private int[] local;//Can le toa do di chuyen
    /*
     * Luu toa do doi thu
     */
    private Point rival[];
    private int arrRival[];
    /*
     * Luu thong tin tau 2 ben
     */
    private boolean host[];
    private boolean client[];
    private ArrayList<Point> trungPoint;
    private ArrayList<Point> truotPoint;
    private XuLy xuly;
    private center ce;
    private boolean flags;

    public boolean isFlags() {
        return flags;
    }

    public void setFlags(boolean flags) {
        this.flags = flags;
    }

    public BanDoGame(center ce) {
        initComponents();
        this.ce = ce;
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
        host = new boolean[5];
        client = new boolean[5];
        trungPoint = new ArrayList<Point>();
        truotPoint = new ArrayList<Point>();
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
        truot = new ImageIcon(this.getClass().getResource("image/truot.png"));
        trung = new ImageIcon(this.getClass().getResource("image/trung.png"));
        status = Infomation.THIETLAP;
        isClient = Infomation.DEFINITE;
        serial = -1;
        rival = null;
        arrRival = null;
        vuno.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vuno = new javax.swing.JLabel();

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

        vuno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/com/image/no.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(vuno)
                .addGap(212, 212, 212))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(vuno)
                .addContainerGap(238, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setDefaultPoint() {
        if (isClient == Infomation.DEFINITE) {
            return;
        } else if (isClient == Infomation.CLIENT) {
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
    /*
     * Thiet lap thong tin tau, su song chet cua moi tau.
     */

    public void setLive() {
        for (int i = 0; i < 5; i++) {
            host[i] = true;
            client[i] = false;
        }
        trungPoint.removeAll(trungPoint);
        truotPoint.removeAll(truotPoint);
    }
    /*
     * Xac dinh xem vi tri click la len tau nao
     */

    public boolean getNumber(Point point, int number, int arrI[], Point arrP[]) {
        if (isClient == Infomation.DEFINITE) {
            return false;
        }
        if (isClient == Infomation.SERVER) {
            if (arrI[number] == 0) {
                if ((((point.x - 10) / 25) == ((arrP[number].x - 10) / 25))
                        && (((point.y - 10) / 25) >= ((arrP[number].y - 10) / 25))
                        && (((point.y - 10) / 25) < ((arrP[number].y - 10) / 25) + length[number])) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if ((((point.y - 10) / 25) == ((arrP[number].y - 10) / 25))
                        && (((point.x - 10) / 25) >= ((arrP[number].x - 10) / 25))
                        && (((point.x - 10) / 25) < ((arrP[number].x - 10) / 25) + length[number])) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (arrI[number] == 0) {
                if ((((point.x - 300) / 25) == ((arrP[number].x - 300) / 25))
                        && (((point.y - 10) / 25) >= ((arrP[number].y - 10) / 25))
                        && (((point.y - 10) / 25) < ((arrP[number].y - 10) / 25) + length[number])) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if ((((point.y - 10) / 25) == ((arrP[number].y - 10) / 25))
                        && (((point.x - 300) / 25) >= ((arrP[number].x - 300) / 25))
                        && (((point.x - 300) / 25) < ((arrP[number].x - 300) / 25) + length[number])) {
                    return true;
                } else {
                    return false;
                }
            }
        }

    }

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        switch (status) {
            case Infomation.THIETLAP:
                clickThietLap(evt);
                break;
            case Infomation.BATDAU:
                clickBatDau(evt);
                break;
            case Infomation.NHANTHUA:
                break;
        }
    }//GEN-LAST:event_formMouseClicked
    private void clickThietLap(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2 && serial != -1) {
            this.changeImage();
        }
    }

    private void clickBatDau(java.awt.event.MouseEvent evt) {
        if (beginClient && beginHost) {
            if (isClient == Infomation.SERVER) {
                if (evt.getX() > 300 && evt.getX() < 550 && evt.getY() > 10 && evt.getY() < 260 && flags) {
                    Point pointClick = new Point();
                    pointClick.x = ((evt.getX() - 300) / 25) * 25 + 300;
                    pointClick.y = ((evt.getY() - 10) / 25) * 25 + 10;
                    if (ce.getLoaiDan() == Infomation.LOAI3) {
                        pointClick = setLoaiDan3();
                    }
                    if (clickedPoint(pointClick)) {
                        return;
                    }
                    if (ce.getSoluotcam() > 0) {
                        ce.setSoluotcam(ce.getSoluotcam() - 1);
                    }
                    for (int i = 0; i < 5; i++) {
                        if (getNumber(pointClick, i, arrRival, rival)) {
                            trungPoint.add(pointClick);
                            xulyLoaiDan(pointClick, true, true, i);
                            xuly.sendDienBan(pointClick, ce.getLoaiDan(), flags);
                            ce.addMoney(10);
                            ce.setShoot();
                            flags = false;
                            int count = 0;
                            for (int j = trungPoint.size() - 1; j >= 0; j--) {
                                if (getNumber(trungPoint.get(j), i, arrRival, rival)) {
                                    count++;
                                }
                            }
                            if (count == length[i]) {
                                for (int j = trungPoint.size() - 1; j >= 0; j--) {
                                    if (getNumber(trungPoint.get(j), i, arrRival, rival)) {
                                        trungPoint.remove(j);
                                    }
                                    client[i] = true;
                                }
                            }
                            if (client[0] && client[1] && client[2] && client[3] && client[4]) {
                                ce.setArea("Bạn đã chiến thắng.");
                                setVictory();
                                flags = true;
                            }
                            repaint();
                            break;
                        }
                        if (i == 4) {
                            truotPoint.add(pointClick);
                            xulyLoaiDan(pointClick, true, false, -1);
                            xuly.sendDienBan(pointClick, ce.getLoaiDan(), flags);
                            ce.addMoney(10);
                            ce.setShoot();
                            flags = false;
                            repaint();
                        }
                    }
                }
            } else if (isClient == Infomation.CLIENT) {
                if (evt.getX() > 10 && evt.getX() < 260 && evt.getY() > 10 && evt.getY() < 260 && flags) {
                    Point pointClick = new Point();
                    pointClick.x = ((evt.getX() - 10) / 25) * 25 + 10;
                    pointClick.y = ((evt.getY() - 10) / 25) * 25 + 10;
                    if (ce.getLoaiDan() == Infomation.LOAI3) {
                        pointClick = setLoaiDan3();
                    }
                    if (clickedPoint(pointClick)) {
                        return;
                    }
                    if (ce.getSoluotcam() > 0) {
                        ce.setSoluotcam(ce.getSoluotcam() - 1);
                    }
                    for (int i = 0; i < 5; i++) {
                        if (getNumber(pointClick, i, arrRival, rival)) {
                            trungPoint.add(pointClick);
                            xulyLoaiDan(pointClick, true, true, i);
                            xuly.sendDienBan(pointClick, ce.getLoaiDan(), flags);
                            ce.addMoney(10);
                            ce.setShoot();
                            flags = false;
                            int count = 0;
                            for (int j = trungPoint.size() - 1; j >= 0; j--) {
                                if (getNumber(trungPoint.get(j), i, arrRival, rival)) {
                                    count++;
                                }
                            }
                            if (count == length[i]) {
                                for (int j = trungPoint.size() - 1; j >= 0; j--) {
                                    if (getNumber(trungPoint.get(j), i, arrRival, rival)) {
                                        trungPoint.remove(j);
                                    }
                                    client[i] = true;
                                }
                            }
                            if (client[0] && client[1] && client[2] && client[3] && client[4]) {
                                ce.setArea("Bạn đã chiến thắng.");
                                setVictory();
                                flags = true;
                            }
                            repaint();
                            break;
                        }
                        if (i == 4) {
                            truotPoint.add(pointClick);
                            xulyLoaiDan(pointClick, true, false, -1);
                            xuly.sendDienBan(pointClick, ce.getLoaiDan(), flags);
                            ce.addMoney(10);
                            ce.setShoot();
                            flags = false;
                            repaint();
                        }
                    }
                }
            }
        }
    }

    public Point setLoaiDan3() {
        ArrayList<Point> arr = new ArrayList<Point>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < length[i]; j++) {
                if (arrRival[i] == 0) {
                    arr.add(new Point(rival[i].x, rival[i].y + j * 25 * arrRival[i]));
                } else {
                    arr.add(new Point(rival[i].x + j * 25 * arrRival[i], rival[i].y));
                }
            }
        }
        arr.removeAll(trungPoint);
        int x = Infomation.getRandom(arr.size());
        return arr.get(x);
    }

    public void xulyLoaiDan(Point point, boolean isHost, boolean isHit, int number) {
        switch (ce.getLoaiDan()) {
            case Infomation.LOAI2:
                System.out.println("hoa loi");
                if (isHost) {
                    if (isHit) {
                        for (int j = trungPoint.size() - 1; j >= 0; j--) {
                            if (getNumber(trungPoint.get(j), number, arrRival, rival)) {
                                trungPoint.remove(j);
                            }
                            client[number] = true;
                        }
                    }
                } else {
                    if (isHit) {
                        for (int j = trungPoint.size() - 1; j >= 0; j--) {
                            if (getNumber(trungPoint.get(j), number, arrImage, begin)) {
                                trungPoint.remove(j);
                            }
                            host[number] = false;
                        }
                    }
                }
                break;
            case Infomation.LOAI4:
                if (isHost && isHit) {
                    int x = Infomation.getRandom(150);
                    ce.addMoney(x + 50);
                }
                break;
        }
    }

    public void setDiemBan(Point point) {
        flags = true;
        for (int i = 0; i < 5; i++) {
            if (getNumber(point, i, arrImage, begin)) {
                trungPoint.add(point);
                xulyLoaiDan(point, false, true, i);
                int count = 0;
                for (int j = trungPoint.size() - 1; j >= 0; j--) {
                    if (getNumber(trungPoint.get(j), i, arrImage, begin)) {
                        count++;
                    }
                }
                if (count == length[i]) {
                    for (int j = trungPoint.size() - 1; j >= 0; j--) {
                        if (getNumber(trungPoint.get(j), i, arrImage, begin)) {
                            trungPoint.remove(j);
                        }
                        host[i] = false;
                    }
                }
                if (!host[0] && !host[1] && !host[2] && !host[3] && !host[4]) {
                    ce.setArea("Bạn đã thua.");
                    setVictory();
                    flags = false;
                }
                repaint();
                break;
            }
            if (i == 4) {
                truotPoint.add(point);
                xulyLoaiDan(point, false, false, -1);
                repaint();
            }
        }
    }

    public void setVictory() {
        ce.setThua(false);
        ce.setThietlap(true);
        beginClient = false;
        beginHost = false;
        status = Infomation.NHANTHUA;
        ce.resetMoney();
    }
    /*
     * Kiem tra xem diem do da duoc click hay chua
     */

    public boolean clickedPoint(Point point) {
        for (int i = 0; i < trungPoint.size(); i++) {
            if (trungPoint.get(i).x == point.x && trungPoint.get(i).y == point.y) {
                return true;
            }
        }
        for (int i = 0; i < truotPoint.size(); i++) {
            if (truotPoint.get(i).x == point.x && truotPoint.get(i).y == point.y) {
                return true;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (client[i] == true) {
                if (getNumber(point, i, arrRival, rival)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void changeImage() {
        arrImage[serial] = Math.abs(1 - arrImage[serial]);
        if (arrImage[serial] == 0) {
            if ((begin[serial].y + local[serial]) > 260) {
                begin[serial].y = 260 - local[serial];
            }
            repaint();
        } else {
            if (isClient == Infomation.CLIENT) {
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

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        if (status == Infomation.THIETLAP && serial != -1) {
            if (isClient == Infomation.SERVER) {
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
            } else if (isClient == Infomation.CLIENT) {
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
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        if (status == Infomation.THIETLAP) {
            Point point = new Point(evt.getX(), evt.getY());
            for (int i = 0; i < 5; i++) {
                if (getNumber(point, i, arrImage, begin)) {
                    serial = i;
                    break;
                }
                serial = -1;
            }
        }
    }//GEN-LAST:event_formMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel vuno;
    // End of variables declaration//GEN-END:variables
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
        for (int i = 0; i < truotPoint.size(); i++) {
            g.drawImage(truot.getImage(), truotPoint.get(i).x, truotPoint.get(i).y, 25, 25, null);
        }
        if (isClient == Infomation.DEFINITE) {
            return;
        }
        if (host[0]) {
            g.drawImage(tau1[arrImage[0]].getImage(), begin[0].x + XY1[arrImage[0]].x, begin[0].y + XY1[arrImage[0]].y, tau1[arrImage[0]].getImage().getWidth(this), tau1[arrImage[0]].getImage().getHeight(this), null);
        } else {
            g.drawImage(no1[arrImage[0]].getImage(), begin[0].x + XY1[arrImage[0]].x, begin[0].y + XY1[arrImage[0]].y, no1[arrImage[0]].getImage().getWidth(this), no1[arrImage[0]].getImage().getHeight(this), null);
        }
        if (host[1]) {
            g.drawImage(tau2[arrImage[1]].getImage(), begin[1].x + XY2[arrImage[1]].x, begin[1].y + XY2[arrImage[1]].y, tau2[arrImage[1]].getImage().getWidth(this), tau2[arrImage[1]].getImage().getHeight(this), null);
        } else {
            g.drawImage(no2[arrImage[1]].getImage(), begin[1].x + XY2[arrImage[1]].x, begin[1].y + XY2[arrImage[1]].y, no2[arrImage[1]].getImage().getWidth(this), no2[arrImage[1]].getImage().getHeight(this), null);
        }
        if (host[2]) {
            g.drawImage(tau3[arrImage[2]].getImage(), begin[2].x + XY3[arrImage[2]].x, begin[2].y + XY3[arrImage[2]].y, tau3[arrImage[2]].getImage().getWidth(this), tau3[arrImage[2]].getImage().getHeight(this), null);
        } else {
            g.drawImage(no3[arrImage[2]].getImage(), begin[2].x + XY3[arrImage[2]].x, begin[2].y + XY3[arrImage[2]].y, no3[arrImage[2]].getImage().getWidth(this), no3[arrImage[2]].getImage().getHeight(this), null);
        }
        if (host[3]) {
            g.drawImage(tau4[arrImage[3]].getImage(), begin[3].x + XY4[arrImage[3]].x, begin[3].y + XY4[arrImage[3]].y, tau4[arrImage[3]].getImage().getWidth(this), tau4[arrImage[3]].getImage().getHeight(this), null);
        } else {
            g.drawImage(no4[arrImage[3]].getImage(), begin[3].x + XY4[arrImage[3]].x, begin[3].y + XY4[arrImage[3]].y, no4[arrImage[3]].getImage().getWidth(this), no4[arrImage[3]].getImage().getHeight(this), null);
        }
        if (host[4]) {
            g.drawImage(tau5[arrImage[4]].getImage(), begin[4].x + XY5[arrImage[4]].x, begin[4].y + XY5[arrImage[4]].y, tau5[arrImage[4]].getImage().getWidth(this), tau5[arrImage[4]].getImage().getHeight(this), null);
        } else {
            g.drawImage(no5[arrImage[4]].getImage(), begin[4].x + XY5[arrImage[4]].x, begin[4].y + XY5[arrImage[4]].y, no5[arrImage[4]].getImage().getWidth(this), no5[arrImage[4]].getImage().getHeight(this), null);
        }
        if (rival == null || arrRival == null) {
            return;
        }
        if (client[0]) {
            g.drawImage(no1[arrRival[0]].getImage(), rival[0].x + XY1[arrRival[0]].x, rival[0].y + XY1[arrRival[0]].y, no1[arrRival[0]].getImage().getWidth(this), no1[arrRival[0]].getImage().getHeight(this), null);
        }
        if (client[1]) {
            g.drawImage(no2[arrRival[1]].getImage(), rival[1].x + XY2[arrRival[1]].x, rival[1].y + XY2[arrRival[1]].y, no2[arrRival[1]].getImage().getWidth(this), no2[arrRival[1]].getImage().getHeight(this), null);
        }
        if (client[2]) {
            g.drawImage(no3[arrRival[2]].getImage(), rival[2].x + XY3[arrRival[2]].x, rival[2].y + XY3[arrRival[2]].y, no3[arrRival[2]].getImage().getWidth(this), no3[arrRival[2]].getImage().getHeight(this), null);
        }
        if (client[3]) {
            g.drawImage(no4[arrRival[3]].getImage(), rival[3].x + XY4[arrRival[3]].x, rival[3].y + XY4[arrRival[3]].y, no4[arrRival[3]].getImage().getWidth(this), no4[arrRival[3]].getImage().getHeight(this), null);
        }
        if (client[4]) {
            g.drawImage(no5[arrRival[4]].getImage(), rival[4].x + XY5[arrRival[4]].x, rival[4].y + XY5[arrRival[4]].y, no5[arrRival[4]].getImage().getWidth(this), no5[arrRival[4]].getImage().getHeight(this), null);
        }
        if (status == Infomation.NHANTHUA) {
            if (!client[0]) {
                g.drawImage(tau1[arrRival[0]].getImage(), rival[0].x + XY1[arrRival[0]].x, rival[0].y + XY1[arrRival[0]].y, tau1[arrRival[0]].getImage().getWidth(this), tau1[arrRival[0]].getImage().getHeight(this), null);
            }
            if (!client[1]) {
                g.drawImage(tau2[arrRival[1]].getImage(), rival[1].x + XY2[arrRival[1]].x, rival[1].y + XY2[arrRival[1]].y, tau2[arrRival[1]].getImage().getWidth(this), tau2[arrRival[1]].getImage().getHeight(this), null);
            }
            if (!client[2]) {
                g.drawImage(tau3[arrRival[2]].getImage(), rival[2].x + XY3[arrRival[2]].x, rival[2].y + XY3[arrRival[2]].y, tau3[arrRival[2]].getImage().getWidth(this), tau3[arrRival[2]].getImage().getHeight(this), null);
            }
            if (!client[3]) {
                g.drawImage(tau4[arrRival[3]].getImage(), rival[3].x + XY4[arrRival[3]].x, rival[3].y + XY4[arrRival[3]].y, tau4[arrRival[3]].getImage().getWidth(this), tau4[arrRival[3]].getImage().getHeight(this), null);
            }
            if (!client[4]) {
                g.drawImage(tau5[arrRival[4]].getImage(), rival[4].x + XY5[arrRival[4]].x, rival[4].y + XY5[arrRival[4]].y, tau5[arrRival[4]].getImage().getWidth(this), tau5[arrRival[4]].getImage().getHeight(this), null);
            }
        }
        for (int i = 0; i < trungPoint.size(); i++) {
            g.drawImage(trung.getImage(), trungPoint.get(i).x, trungPoint.get(i).y, 25, 25, null);
            if(i == trungPoint.size() - 1){
                vuno.setLocation(trungPoint.get(i).x, trungPoint.get(i).y);
                vuno.setSize(24, 24);
                vuno.setVisible(true);
            }
        }
    }

    public void setIsClient(int is) {
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

    public void setBeginHost(boolean beginHost) {
        this.beginHost = beginHost;
    }

    public void setBeginClient(boolean beginClient) {
        this.beginClient = beginClient;
    }

    public boolean isBeginHost() {
        return beginHost;
    }

    public boolean isBeginClient() {
        return beginClient;
    }

    public void setXuly(XuLy xuly) {
        this.xuly = xuly;
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
    /*
     * Kiem tra xem 2 tau co giao nhau hay khong
     */

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
    /*
     * Sinh ra vi tri toa do cua 1 tau
     */

    private ArrayList<Integer> setArr(int number) {
        ArrayList<Integer> e = new ArrayList<Integer>();
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
        return e;
    }
}
