package com.endava.calculator.expert;

import com.endava.calculator.basic.BasicOperations;

public interface ExpertOperations extends BasicOperations {

    abstract double pow(int base, int exponent);

    abstract double pow(double base, double exponent);

    abstract double root(int no);

    abstract double nthRoot(int no, int n);

    abstract long fact(int n);

    abstract long factRec(int n);

    abstract double calculate(String s);
}
