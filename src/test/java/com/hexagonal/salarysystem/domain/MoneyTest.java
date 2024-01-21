package com.hexagonal.salarysystem.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void testMinusTwoPositiveValues() {
        Money money1 = new Money(20);
        Money money2 = new Money(8);
        Money result = money1.minus(money2);
        assertEquals(new Money(12), result, "두 Money 객체 간 뺄셈이 올바르지 않습니다.");
    }

    @Test
    void testMinusNegativeResult() {
        Money money1 = new Money(8);
        Money money2 = new Money(20);
        Money negativeResult = money1.minus(money2);
        assertEquals(new Money(-12), negativeResult, "음수 결과의 뺄셈이 올바르지 않습니다.");
    }

    @Test
    void testMultiplyNormalCase() {
        Money money = new Money(10);
        Money result = money.multiply(0.5);
        assertEquals(new Money(5), result, "곱셈이 올바르지 않습니다.");
    }

    @Test
    void testMultiplyZeroRate() {
        Money money = new Money(10);
        Money zeroRateResult = money.multiply(0);
        assertEquals(new Money(0), zeroRateResult, "0에 가까운 rate의 곱셈이 올바르지 않습니다.");
    }

    @Test
    void testMultiplyOneRate() {
        Money money = new Money(10);
        Money oneRateResult = money.multiply(1);
        assertEquals(new Money(10), oneRateResult, "1에 가까운 rate의 곱셈이 올바르지 않습니다.");
    }

    @Test
    void testMultiplyRateAboveOne() {
        Money money = new Money(10);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> money.multiply(1.1));
        assertEquals("rate는 0~1 사이의 실수여야 합니다. 현재 rate : 1.100000", exception.getMessage(), "1 초과의 rate 테스트가 예외를 발생시키지 않았습니다.");
    }

}