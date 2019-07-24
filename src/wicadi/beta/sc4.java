/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wicadi.beta;

import java.util.StringTokenizer;

/**
 *
 * @author Kalana Hettiarachchi
 */
public class sc4 {

    wicadirec wr = new wicadirec();

    public double con(String s, double z) {

        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'x') {
                if (i > 0 && sb.charAt(i - 1) >= '0' && sb.charAt(i - 1) <= '9') {
                    sb.insert(i, '*'); //identifying consecutive numbers and variables without operators as multiplications and putting * sign between them.
                }
                if (i < sb.length() - 1 && sb.charAt(i + 1) >= '0' && sb.charAt(i + 1) <= '9') {
                    sb.insert(i + 1, '*');
                }
            }
        }

        s = sb.toString();
        s = s.replace("x", " x ");

        s = s.replace("ars", " ars ");
        s = s.replace("arc", " arc ");
        s = s.replace("art", " art ");
        s = s.replace("sin", " sin ");
        s = s.replace("cos", " cos ");
        s = s.replace("tan", " tan ");

        //new
        s = s.replace("√", " √ ");

        s = s.replace("ln", " ln ");
        s = s.replace("abs", " abs ");
        s = s.replace("ep", " ep ");
        s = s.replace("log", " log ");
        s = s.replace("sig", " sig ");
        s = s.replace("rem", " rem ");
        s = s.replace("+", " + ");
        s = s.replace("-", " - ");
        s = s.replace("*", " * ");
        s = s.replace("/", " / ");
        s = s.replace("^", " ^ ");
        s = s.replace("(", " ( ");
        s = s.replace(")", " ) ");

        return wr.rec(s, z);

    }

    public double con(String g) {
        return con(g, 0);
    }

    public static void main(String aw[]) {
        sc4 m = new sc4();
        System.out.println("Ans " + m.con("1/0", 2));
    }
}
