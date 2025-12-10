package rlp.footrix.protrix.box.helper;

public class Math {

    public static double round(double number, int decimals) {
        double factor = java.lang.Math.pow(10, decimals);
        return java.lang.Math.round(number * factor) / factor;
    }
}
