package com.hexagonal.salarysystem.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WorkDurationTest {
    @Test
    void testToHour() {
        int testHours = 8;
        int testMinutes = 30;

        WorkDuration workDuration = new WorkDuration(testHours, testMinutes);

        int result = workDuration.toHour();
        assertEquals(testHours, result, "toHour 메서드의 반환값이 올바르지 않습니다.");
    }

    @Test
    void testToHourWithZeroMinutes() {
        int testHours = 5;

        WorkDuration workDuration = new WorkDuration(testHours);

        int result = workDuration.toHour();
        assertEquals(testHours, result, "toHour 메서드의 반환값이 올바르지 않습니다.");
    }

    @Test
    void testToHourWithNegativeValuesFails() {
        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new WorkDuration(-2, 30)
        );

        assertEquals("올바르지 않은 시간 또는 분입니다.", exception.getMessage(), "예외 메시지가 일치하지 않습니다.");
    }
}