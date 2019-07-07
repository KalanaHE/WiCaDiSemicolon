/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wicadi;

/**
 *
 * @author Kalana Hettiarachchi
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class grafer extends JPanel {

    private double x,  y,  c;
    private int a,  b,  a1,  b1;
    public static String s;
    static public int k = 50;
    static public double ofx = 0;
    static public double ofy = 0;
    static public boolean p = false;
    sc4 o;
    Random r;

    public grafer() {
        r = new Random();
        o = new sc4();

    }

    @Override
    public void paint(Graphics g) {

        int w = this.getWidth();
        int l = this.getHeight();
        a = -(w / 2);
        a1 = -(w / 2);
        y = 0;
        c = 0;
        b1 = 0;
        x = (((double) a) / k) + ofx;
        y = (o.con(s, x)) - ofy;
        b = -(int) (y * k);


        super.paintComponent(g);
        this.setBackground(Color.white);
        g.setColor(Color.lightGray);
        g.translate(w / 2, l / 2);
        g.drawLine(w / 2, 0, -(w / 2), 0);
        g.drawLine(0, l / 2, 0, -(l / 2));
        for (int i = -(w / 2) / k; i <= (w / 2) / k; i++) {
            g.drawLine(-4, k * i, 4, k * i);
            g.drawLine(i * k, 4, i * k, -4);
        }
        if (p) {
            for (int i = -(w / 2) / k; i <= (w / 2) / k; i++) {
                g.drawLine(-w / 2, k * i, w / 2, k * i);
                g.drawLine(i * k, l / 2, i * k, -l / 2);
            }

        }
        g.setColor(Color.BLUE);
        g.fillOval(-3, -3, 6, 6);
        g.drawString(" x= " + ofx + " y= " + ofy, -w / 2 + 50, -l / 2 + 50);
        g.setColor(Color.RED);

        while (a1 <= w / 2 && a1 >= (-w / 2)) {

            x = (((double) a1) / k) + ofx;
            y = o.con(s, x) - ofy;
            if (!(y > -Integer.MAX_VALUE && y < Integer.MAX_VALUE)) {
                a1++;
                a = a1;
                x = ((double) a) / k + ofx;
                y = (o.con(s, x)) - ofy;
                b = -(int) (y * k);
                continue;
            }

            c = y * k;
            b1 = -(int) c;

            g.drawLine(a, b, a1, b1);
            a = a1;
            b = b1;
            a1++;
        }

        this.getParent().repaint();
    }
}
