package com.endava.calculator.test;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

public class TestCalculator {

    public static void main(String[] args) {

        BasicOperations bc = new Basic(3);
        System.out.println("\n=============== Suma ===============");
        System.out.println("Suma int = " + bc.add(1, 2, 3));
        System.out.println("Suma long = " + bc.add(1L, 2L, 3L));
        System.out.println("Suma double = " + bc.add(2.0, 3.9, 4.1));

        System.out.println("\n============== Diferenta ==============");
        System.out.println("Diferenta int = " + bc.substract(10, 3, 4));
        System.out.println("Diferenta long = " + bc.substract(10L, 3L, 4L));
        System.out.println("Diferenta double = " + bc.substract(10.0, 3.0, 4.0));

        System.out.println("\n============== Inmultire ==============");
        System.out.println("Inmultire int = " + bc.multiply(2, 3));
        System.out.println("Inmultire long = " + bc.multiply(2L, 3L));
        System.out.println("Inmultire double = " + bc.multiply(3.5, 2.3));

        System.out.println("\n============= Impartire =============");
        System.out.println("Impartire int = " + bc.divide(10, 3));
        System.out.println("Impartire long = " + bc.divide(10L, 3L));
        System.out.println("Impartire double = " + bc.divide(10.0, 3.0));

        System.out.println("\n============= Expert =============");
        ExpertOperations ec = new Expert(3);
        System.out.println("Ridicarea la putere: " + ec.pow(2, 5));
        System.out.println("Radical de ordin 2 din 2 = " + ec.root(4));
        System.out.println("Radical de ordin 2 din 5 = " + ec.root(5));
        System.out.println("Radical de ordin 5 din 27 = " + ec.nthRoot(27, 5));
        double a = ec.pow(ec.nthRoot(27, 5), 5);
        System.out.println("Verificare radical de ordin n = " + a);
        System.out.println("3! = " + ec.fact(3));

        System.out.println("\n============= String =============");
        System.out.println(ec.calculate("2+2"));
        System.out.println(ec.calculate("22+33"));
        System.out.println(ec.calculate("22.1+33.9"));
        System.out.println(ec.calculate("22.1 + 33.9"));
        System.out.println(ec.calculate("22.1 + 33.9 + 4.0 + 6.0"));
        System.out.println(ec.calculate("2*4"));
        System.out.println(ec.calculate("2*3%2"));
        System.out.println(ec.calculate("-5+1"));
        System.out.println(ec.calculate("-5*5"));
        System.out.println(ec.calculate("-3-5*3"));
        System.out.println(ec.calculate("2 * -3"));
        System.out.println(ec.calculate("2 + (-3 -5)*(-7 - 5)"));
        //System.out.println(ec.calculate("2 - (-3 -5)"));
        //System.out.println(ec.calculate("((3+2)/5*5)-(8/2)"));
        //System.out.println(ec.calculate("(3+2)/5*5-(8/2)"));
    }
}
