package com.endava.calculator.test;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import com.endava.extensions.TestReporterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(TestReporterExtension.class)
public class CalculatorTest {

    private ExpertOperations expertCalculator;

    @BeforeAll
    public static void setUpAllTests() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachTests() {
        expertCalculator = new Expert();
        System.out.println("\nBefore Each");
    }

    @AfterEach
    public void tearDownEachTests() {
        System.out.println("After Each\n");
    }

    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider0")
    public void shouldAddNumberGivenOperand0(int a, int b) {
        // WHEN
        long result = expertCalculator.add(a, b);

        // THEN
        System.out.println(result);
    }

    public static List<Arguments> numberProvider0() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2));
        argumentsList.add(Arguments.of(2, 0));
        return argumentsList;
    }

    public static List<Arguments> numberProvider1() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(1, 2));
        argumentsList.add(Arguments.of(2, 1));
        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNumberGivenTwoNegativeNumbers() {
        // WHEN
        long result = expertCalculator.add(-2, -4);

        // THEN
        System.out.println(result);
    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldAddNumberGivenTwoLongNumbers() {
        // WHEN
        long result = expertCalculator.add(Integer.MAX_VALUE, 1);

        // THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @CsvSource( {"1,2,3", "2,4,5"} )
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddNumberGivenManyNumbers(int a, int b, int c) {
        // WHEN
        long result = expertCalculator.add(a,b,c);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNumberGivenNoNumbers() {
        // WHEN
        long result = expertCalculator.add();

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNumberGivenOneNumber() {
        // WHEN
        long result = expertCalculator.add(2);

        // THEN
        System.out.println(result);
    }

    /*=================================== Multiply ===================================*/

    @ParameterizedTest
    @MethodSource("numberProvider0")
    public void shouldMultiplyNumberGivenOperand0(int a, int b) {
        // WHEN
        long result = expertCalculator.multiply(a, b);

        // THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @MethodSource("numberProvider1")
    public void shouldMultiplyNumberGivenOperand1(int a, int b) {
        // WHEN
        long result = expertCalculator.multiply(a, b);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNumberGivenTwoNegativeNumbers() {
        // WHEN
        long result = expertCalculator.multiply(-2, -4);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNumberGivenOneNegativeNumberAndOnePositiveNumber() {
        // WHEN
        long result = expertCalculator.multiply(2, -4);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNumberGivenTwoLongNumbers() {
        // WHEN
        long result = expertCalculator.multiply(Integer.MAX_VALUE, 2);

        // THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @CsvSource( {"1,2,3", "2,4,5"} )
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldMultiplyNumberGivenManyNumbers(int a, int b, int c) {
        // WHEN
        long result = expertCalculator.multiply(a,b,c);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNumberGivenNoNumbers() {
        // WHEN
        long result = expertCalculator.multiply();

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNumberGivenOneNumber() {
        // WHEN
        long result = expertCalculator.multiply(2);

        // THEN
        System.out.println(result);
    }

    /*=================================== Power ===================================*/

    @ParameterizedTest
    @MethodSource("numberProvider0")
    public void shouldApplyPowerGivenOperand0(double a, double b) {
        // WHEN
        double result = expertCalculator.pow(a, b);

        // THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @MethodSource("numberProvider1")
    public void shouldApplyPowerGivenOperand1(double a, double b) {
        // WHEN
        double result = expertCalculator.pow(a, b);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldApplyPowerGivenTwoNegativeNumbers() {
        // WHEN
        double result = expertCalculator.pow(-2, -4);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldApplyPowerGivenBaseNegativeNumber() {
        // WHEN
        double result = expertCalculator.pow(-2, 4);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldApplyPowerGivenExpNegativeNumber() {
        // WHEN
        double result = expertCalculator.pow(2, -2);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldApplyPowerGivenTwoLongNumbers() {
        // WHEN
        double result = expertCalculator.pow(Integer.MAX_VALUE, 2);

        // THEN
        System.out.println(result);
    }

    /*=================================== Fact ===================================*/

    @Test
    public void shouldApplyFactGivenOperand0() {
        // WHEN
        long result = expertCalculator.factRec(0);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldApplyFactGivenOperand1( ) {
        // WHEN
        long result = expertCalculator.factRec(1);

        // THEN
        System.out.println(result);
    }

    @Test
    public void shouldApplyFactGivenLongNumber() {
        // WHEN
        long result = expertCalculator.factRec(20);

        // THEN
        System.out.println(result);
    }
}
