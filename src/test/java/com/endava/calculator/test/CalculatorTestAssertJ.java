package com.endava.calculator.test;

import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculatorTestAssertJ {

    private ExpertOperations expertCalculator = new Expert();

    @Test
    public void shouldAddNumberGivenOneNumber() {
        // WHEN
        long result = expertCalculator.add(160L);

        // THEN
        assertThat(result).isBetween(100L,200L)
                .isGreaterThan(150L)
                .isEqualTo(160)
                .isNotNegative()
                .isNull();
    }
}
