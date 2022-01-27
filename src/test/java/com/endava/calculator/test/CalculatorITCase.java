package com.endava.calculator.test;

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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

@ExtendWith(TestReporterExtension.class)
public class CalculatorITCase {

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
    public void shouldAddNumberGivenOperand0(int a, int b, long expected) {
        // WHEN
        long result = expertCalculator.add(a, b);

        // THEN
        assertThat(result, is(expected));
    }

    public static List<Arguments> numberProvider0() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2, 2L));
        argumentsList.add(Arguments.of(2, 0, 2L));
        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNumberGivenTwoNegativeNumbers() {
        // WHEN
        long result = expertCalculator.add(-2, -4);

        // THEN
        assertThat(result, is(-6L));
    }

    @Tags({@Tag("smoke"), @Tag("api")})
    @Test
    public void shouldAddNumberGivenTwoLongNumbers() {
        // WHEN
        long result = expertCalculator.add(Integer.MAX_VALUE, 1);

        // THEN
        assertThat(result,is(Integer.MAX_VALUE + 1L));
        assertThat(result, greaterThan(0L));
        assertThat(result, notNullValue());
    }

    @ParameterizedTest
    @CsvSource( {"1,2,3,6", "2,4,5,11"} )
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddNumberGivenManyNumbers(int a, int b, int c, long expected) {
        // WHEN
        long result = expertCalculator.add(a,b,c);

        // THEN
        assertThat(result, is(expected));
    }

    @Test
    public void shouldAddNumberGivenNoNumbers() {
        // WHEN
        long result = expertCalculator.add();

        // THEN
        assertThat(result, is(0L));
    }

    @Test
    public void shouldAddNumberGivenOneNumber() {
        // WHEN
        long result = expertCalculator.add(2);

        // THEN
        assertThat(result,is(2L));
    }

    /*=================================== Multiply ===================================*/

    @Test
    public void shouldMultiplyNumberGivenOperand0() {
        // WHEN
        long result = expertCalculator.multiply(2,0);

        // THEN
        assertThat(result,is(0L));
    }

    @ParameterizedTest
    @MethodSource("numberProvider1")
    public void shouldMultiplyNumberGivenOperand1(int a, int b, long expected) {
        // WHEN
        long result = expertCalculator.multiply(a, b);

        // THEN
        assertThat(result,is(expected));
    }

    public static List<Arguments> numberProvider1() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(1, 2, 2L));
        argumentsList.add(Arguments.of(2, 1, 2L));
        return argumentsList;
    }

    @Test
    public void shouldMultiplyNumberGivenTwoNegativeNumbers() {
        // WHEN
        long result = expertCalculator.multiply(-2, -4);

        // THEN
        assertThat(result,is(8L));
    }

    @Test
    public void shouldMultiplyNumberGivenOneNegativeNumberAndOnePositiveNumber() {
        // WHEN
        long result = expertCalculator.multiply(2, -4);

        // THEN
        assertThat(result,is(-8L));
    }

    @Test
    public void shouldMultiplyNumberGivenTwoLongNumbers() {
        // WHEN
        long result = expertCalculator.multiply(Integer.MAX_VALUE, 2);

        // THEN
        assertThat(result,is(4294967294L));
    }

    @Test
    public void shouldMultiplyNumberGivenManyNumbers() {
        // WHEN
        long result = expertCalculator.multiply(2,3,4);

        // THEN
        assertThat(result,is(24L));
    }

    @Test
    public void shouldMultiplyNumberGivenNoNumbers() {
        // WHEN
        long result = expertCalculator.multiply();

        // THEN
        assertThat(result,is(1L));
    }

    @Test
    public void shouldMultiplyNumberGivenOneNumber() {
        // WHEN
        long result = expertCalculator.multiply(2);

        // THEN
        assertThat(result,is(2L));
    }

    /*=================================== Power ===================================*/

    @ParameterizedTest
    @MethodSource("numberProviderPower0")
    public void shouldApplyPowerGivenOperand0(double a, double b, double expected) {
        // WHEN
        double result = expertCalculator.pow(a, b);

        // THEN
        assertThat(result,is(expected));
    }

    public static List<Arguments> numberProviderPower0() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2, 0));
        argumentsList.add(Arguments.of(2, 0, 1));
        return argumentsList;
    }

    @ParameterizedTest
    @MethodSource("numberProviderPower1")
    public void shouldApplyPowerGivenOperand1(double a, double b, double expected) {
        // WHEN
        double result = expertCalculator.pow(a, b);

        // THEN
        assertThat(result,is(expected));
    }

    public static List<Arguments> numberProviderPower1() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(1, 2, 1));
        argumentsList.add(Arguments.of(2, 1, 2));
        return argumentsList;
    }

    @Test
    public void shouldApplyPowerGivenTwoNegativeNumbers() {
        // WHEN
        double result = expertCalculator.pow(-2, -4);

        // THEN
        assertThat(result,is(0.0625));
    }

    @Test
    public void shouldApplyPowerGivenBaseNegativeNumber() {
        // WHEN
        double result = expertCalculator.pow(-2, 4);

        // THEN
        assertThat(result,is(16.0));
    }

    @Test
    public void shouldApplyPowerGivenExpNegativeNumber() {
        // WHEN
        double result = expertCalculator.pow(2, -2);

        // THEN
        assertThat(result,is(0.25));
    }

    @Test
    public void shouldApplyPowerGivenTwoLongNumbers() {
        // WHEN
        double result = expertCalculator.pow(Integer.MAX_VALUE, 2);

        // THEN
        assertThat(result,is(4.6116860141324206E18));
    }

    /*=================================== Fact ===================================*/

    @Test
    public void shouldApplyFactGivenOperand0() {
        // WHEN
        long result = expertCalculator.factRec(0);

        // THEN
        assertThat(result,is(1L));
    }

    @Test
    public void shouldApplyFactGivenOperand1( ) {
        // WHEN
        long result = expertCalculator.factRec(1);

        // THEN
        assertThat(result,is(1L));
    }

    @Test
    public void shouldApplyFactGivenLongNumber() {
        // WHEN
        long result = expertCalculator.factRec(20);

        // THEN
        assertThat(result,is(2432902008176640000L));
    }
}
