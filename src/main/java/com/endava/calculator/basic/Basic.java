package com.endava.calculator.basic;

public class Basic implements BasicOperations {

    protected int decimals;

    public Basic() {
        this.decimals = 10;
    }

    public Basic(int decimals) {
        this.decimals = decimals;
    }

    @Override
    public long add(int... no) {
        long sum = 0;
        for (int n : no) {
            sum += n;
        }
        return sum;
    }

    @Override
    public long add(long... no) {
        long sum = 0;
        for (long n : no) {
            sum += n;
        }
        return sum;
    }

    @Override
    public double add(double... no) {
        double sum = 0;
        for (double n : no) {
            sum += n;
        }
        return formatNumber(sum);
    }

    @Override
    public int substract(int... no) {
        int dif = no[0];
        for (int i = 1; i < no.length; i++) {
            dif -= no[i];
        }
        return dif;
    }

    @Override
    public long substract(long... no) {
        long dif = no[0];
        for (int i = 1; i < no.length; i++) {
            dif -= no[i];
        }
        return dif;
    }

    @Override
    public double substract(double... no) {
        double dif = no[0];
        for (int i = 1; i < no.length; i++) {
            dif -= no[i];
        }
        return formatNumber(dif);
    }

    @Override
    public long multiply(int... no) {
        long product = 1;
        for (int i = 0; i < no.length; i++) {
            product *= no[i];
        }
        return product;
    }

    @Override
    public long multiply(long... no) {
        long product = 1L;
        for (int i = 0; i < no.length; i++) {
            product *= no[i];
        }
        return product;
    }

    @Override
    public double multiply(double... no) {
        double product = 1.0;
        for (int i = 0; i < no.length; i++) {
            product *= no[i];
        }
        return formatNumber(product);
    }

    @Override
    public double divide(int... no) {
        double ratio = no[0];
        for (int i = 1; i < no.length; i++) {
            ratio /= no[i];
        }
        return formatNumber(ratio);
    }

    @Override
    public double divide(long... no) {
        double ratio = no[0];
        for (int i = 1; i < no.length; i++) {
            ratio /= no[i];
        }
        return formatNumber(ratio);
    }

    @Override
    public double divide(double... no) {
        double ratio = no[0];
        for (int i = 1; i < no.length; i++) {
            ratio /= no[i];
        }
        return formatNumber(ratio);
    }

    protected double formatNumber(double n) {
        String s = String.format("%." + decimals + "f", n);
        return Double.parseDouble(s);
    }
}
