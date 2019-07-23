/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wicadi.beta;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Kalana Hettiarachchi
 */
public class testIntergration {
    
    
    public static void main(String[] args) {
        double n1 = 0, n2 = 0, l = 0, y = 0;
        double h = 0, j = 0;
        double d = 0;
        String ss = "x^2-2"; //The formula need to intergrate
        int xp = 5;
        
        
        
        try {
            n1 = Double.parseDouble(JOptionPane.showInputDialog("Enter Starting limit"));
            n2 = Double.parseDouble(JOptionPane.showInputDialog("Enter Ending limit"));

        } catch (Exception exception) {
            return;
        }

        y = 1000 * (n2 - n1);
        h = (double) (n2 - n1) / y;
        j = n1;

        while (l < y) {
            l++;
            j = j + h;
            d = d + (con(ss, j) * h);
        }

        System.out.println("" + round(d, xp) + " ");
       
    }
    
     static double round(double d, int k) {

        if (Double.isInfinite(d)) {
            return d;
        }

        double h1 = d % 1;
        double h2 = (Math.round(h1 * Math.pow(10, k))) / Math.pow(10, k);
        double h3 = d - h1;
        double d1 = h3 + h2;

        return d1;

    }
     
            public static double con(String s, double z) {

        s = s.toLowerCase();
        StringBuffer sb=new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)=='x'){
                if(i>0 && sb.charAt(i-1)>='0'&& sb.charAt(i-1)<='9'){
                    sb.insert(i, '*'); //identifying consecutive numbers and variables without operators as multiplications and putting * sign between them.
                }
                if(i<sb.length()-1 && sb.charAt(i+1)>='0' && sb.charAt(i+1)<='9'){
                    sb.insert(i+1, '*'); 
                }
            }
        }
        
        s=sb.toString();
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

        return rec(s, z);

    }
    
        public static double rec(String s, double z) {

        StringTokenizer tok = new StringTokenizer(s);
        String[] a = new String[tok.countTokens()];

        for (int i = 0; i < a.length; i++) {
            a[i] = tok.nextToken();
            if (a[i].equalsIgnoreCase("x")) {
                a[i] = "" + z;
            }

        }

        for (int i = 0; i < a.length; i++) {

            if (a[i].equalsIgnoreCase(")")) {
                String temp = "";
                int j = i - 1;
                while (!a[j].equalsIgnoreCase("(")) {
                    temp = " " + a[j] + temp;
                    a[j] = "U";
                    j--;
                }
                a[j] = "U";
                a[i] = "" + rec(temp, z);
            }

        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].equalsIgnoreCase("√") || a[i].equalsIgnoreCase("sin") || a[i].equalsIgnoreCase("cos") || a[i].equalsIgnoreCase("tan") || a[i].equalsIgnoreCase("ln") || a[i].equalsIgnoreCase("ars") || a[i].equalsIgnoreCase("arc") || a[i].equalsIgnoreCase("art") || a[i].equalsIgnoreCase("ep") || a[i].equalsIgnoreCase("abs") || a[i].equalsIgnoreCase("log") || a[i].equalsIgnoreCase("sig")) {
                String temp = "";

                int k = i + 1;
                while (k < a.length && !a[k].equalsIgnoreCase("+") && !a[k].equalsIgnoreCase("-") && !a[k].equalsIgnoreCase("*") && !a[k].equalsIgnoreCase("/")) {

                    temp = temp + " " + a[k];
                    a[k] = "U";
                    k++;

                }

                k = k - 1;
                if (a[i].equalsIgnoreCase("sig")) {

                    a[k] = "" + Math.signum(rec(temp, z));
                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("abs")) {

                    a[k] = "" + Math.abs(rec(temp, z));
                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("ep")) {

                    a[k] = "" + Math.exp(rec(temp, z));
                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("√")) {

                    a[k] = "" + Math.sqrt(rec(temp, z));
                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("sin")) {

                    a[k] = "" + Math.sin(rec(temp, z));
                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("cos")) {

                    a[k] = "" + Math.cos(rec(temp, z));

                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("tan")) {

                    a[k] = "" + Math.tan(rec(temp, z));
                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("ln")) {

                    a[k] = "" + Math.log(rec(temp, z));
                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("log")) {

                    a[k] = "" + Math.log10(rec(temp, z));
                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("ars")) {

                    a[k] = "" + Math.asin(rec(temp, z));
                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("arc")) {

                    a[k] = "" + Math.acos(rec(temp, z));
                    a[i] = "U";
                }
                if (a[i].equalsIgnoreCase("art")) {

                    a[k] = "" + Math.atan(rec(temp, z));
                    a[i] = "U";
                }


            }
        }
        for (int i = 0; i < a.length; i++) {

            if (a[i].equalsIgnoreCase("^")) {
                double n1, n2;
                n1 = Double.parseDouble(a[i - 1]);
                int temp = 0;
                for (int k = i + 1; k < a.length; k++) {
                    if (a[k].equalsIgnoreCase("+") || a[k].equalsIgnoreCase("-") || a[k].equalsIgnoreCase("*") || a[k].equalsIgnoreCase("/")) {
                        temp = k - 1;
                        break;
                    }
                    temp = k;

                }
                n2 = Double.parseDouble(a[temp]);
                a[temp] = "" + Math.pow(n1, n2);
                a[i] = a[i - 1] = "U";

            }
        }

        for (int i = 0; i < a.length; i++) {

            if (a[i].equalsIgnoreCase("rem")) {
                double n1, n2;
                n1 = Double.parseDouble(a[i - 1]);
                int temp = 0;
                for (int k = i + 1; k < a.length; k++) {
                    if (a[k].equalsIgnoreCase("+") || a[k].equalsIgnoreCase("-") || a[k].equalsIgnoreCase("*") || a[k].equalsIgnoreCase("/")) {
                        temp = k - 1;
                        break;
                    }
                    temp = k;

                }
                n2 = Double.parseDouble(a[temp]);
                a[temp] = "" + n1 % n2;
                a[i] = a[i - 1] = "U";

            }
        }

        for (int i = 0; i < a.length; i++) {

            if (a[i].equalsIgnoreCase("*") || a[i].equalsIgnoreCase("/")) {
                double n1, n2;
                n1 = Double.parseDouble(a[i - 1]);
                int temp = 0;
                for (int k = i + 1; k < a.length; k++) {
                    if (a[k].equalsIgnoreCase("+") || a[k].equalsIgnoreCase("-") || a[k].equalsIgnoreCase("*") || a[k].equalsIgnoreCase("/")) {

                        temp = k - 1;
                        break;
                    }
                    temp = k;

                }
                n2 = Double.parseDouble(a[temp]);
                if (a[i].equalsIgnoreCase("*")) {
                    a[temp] = "" + (n1 * n2);

                }
                if (a[i].equalsIgnoreCase("/")) {

                    a[temp] = "" + (n1 / n2);

                }
                a[i] = a[i - 1] = "U";

            }
        }

        for (int i = 0; i < a.length; i++) {

            if (a[i].equalsIgnoreCase("+") || a[i].equalsIgnoreCase("-")) {
                double n1, n2;
                if (i == 0) {
                    n1 = 0;
                } else {
                    n1 = Double.parseDouble(a[i - 1]);
                }


                int temp = 0;
                for (int k = i + 1; k < a.length; k++) {
                    if (a[k].equalsIgnoreCase("+") || a[k].equalsIgnoreCase("-") || a[k].equalsIgnoreCase("*") || a[k].equalsIgnoreCase("/")) {
                        temp = k - 1;
                        break;
                    }
                    temp = k;
                }
                n2 = Double.parseDouble(a[temp]);

                if (a[i].equalsIgnoreCase("+")) {

                    a[temp] = "" + (n1 + n2);

                }
                if (a[i].equalsIgnoreCase("-")) {

                    a[temp] = "" + (n1 - n2);

                }

                if (i != 0) {
                    a[i] = a[i - 1] = "U";
                } else {
                    a[i] = "U";
                }

            }
        }
        double ans = Double.parseDouble(a[a.length - 1]);
        return ans;


    }
    
}
