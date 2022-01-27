package com.endava.calculator.test;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.endava.matches.InLastFiveMinutes.inLastFiveMinutes;
import static org.hamcrest.MatcherAssert.assertThat;

public class DateTest {

    @Test
    public void testDates() {

        LocalDateTime actual = LocalDateTime.now();

        assertThat(actual, inLastFiveMinutes());
    }
}
