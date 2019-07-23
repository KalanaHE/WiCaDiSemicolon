/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wicadi.beta;

/**
 *
 * @author Kalana Hettiarachchi
 */
public class roundnumber {

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

}
