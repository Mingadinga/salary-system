package com.hexagonal.salarysystem.domain;

import java.math.RoundingMode;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BigDecimalTest {

    @Test
    void testAddition() {
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(5);
        BigDecimal sum = addNumbers(num1, num2);
        assertEquals(BigDecimal.valueOf(15), sum, "덧셈 결과가 올바르지 않습니다.");
    }

    @Test
    void testAdditionWithDecimals() {
        BigDecimal num1 = BigDecimal.valueOf(10.5);
        BigDecimal num2 = BigDecimal.valueOf(5.3);
        BigDecimal sum = addNumbers(num1, num2);
        assertEquals(BigDecimal.valueOf(15.8), sum, "덧셈 결과가 올바르지 않습니다.");
    }

    @Test
    void testSubtraction() {
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(5);
        BigDecimal difference = subtractNumbers(num1, num2);
        assertEquals(BigDecimal.valueOf(5), difference, "뺄셈 결과가 올바르지 않습니다.");
    }

    @Test
    void testSubtractionWithDecimals() {
        BigDecimal num1 = BigDecimal.valueOf(10.5);
        BigDecimal num2 = BigDecimal.valueOf(5.3);
        BigDecimal difference = subtractNumbers(num1, num2);
        assertEquals(BigDecimal.valueOf(5.2), difference, "뺄셈 결과가 올바르지 않습니다.");
    }

    @Test
    void testMultiplication() {
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(5);
        BigDecimal product = multiplyNumbers(num1, num2);
        assertEquals(BigDecimal.valueOf(50), product, "곱셈 결과가 올바르지 않습니다.");
    }

    @Test
    void testMultiplicationWithDecimals() {
        BigDecimal num1 = BigDecimal.valueOf(10.5);
        BigDecimal num2 = BigDecimal.valueOf(5.3);
        BigDecimal product = multiplyNumbers(num1, num2);
        assertEquals(BigDecimal.valueOf(55.65), product, "곱셈 결과가 올바르지 않습니다.");
    }

    @Test
    void testDivision() {
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(5);
        BigDecimal quotient = divideNumbersByInt(num1, num2);
        assertEquals(BigDecimal.valueOf(2), quotient, "나눗셈 결과가 올바르지 않습니다.");
    }

    @Test
    void testDivisionWithDecimals() {
        BigDecimal num1 = BigDecimal.valueOf(10.5);
        BigDecimal num2 = BigDecimal.valueOf(5.3);
        BigDecimal quotient = divideNumbers(num1, num2);
        assertEquals(BigDecimal.valueOf(1.98), quotient, "나눗셈 결과가 올바르지 않습니다.");
    }

    private BigDecimal addNumbers(BigDecimal num1, BigDecimal num2) {
        return num1.add(num2);
    }

    private BigDecimal subtractNumbers(BigDecimal num1, BigDecimal num2) {
        return num1.subtract(num2);
    }

    private BigDecimal multiplyNumbers(BigDecimal num1, BigDecimal num2) {
        return num1.multiply(num2);
    }

    private BigDecimal divideNumbers(BigDecimal num1, BigDecimal num2) {
        // 나눗셈의 경우 정확한 결과를 얻기 위해 나누는 숫자의 스케일을 지정해주는 것이 좋습니다.
        // RoundingMode는 필요에 따라 선택할 수 있습니다.
        // scale : 소수점 아래의 자릿수까지 반환
        // runningmode : 반올림 방법 지정
        return num1.divide(num2, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal divideNumbersByInt(BigDecimal num1, BigDecimal num2) {
        // 나눗셈의 경우 정확한 결과를 얻기 위해 나누는 숫자의 스케일을 지정해주는 것이 좋습니다.
        // RoundingMode는 필요에 따라 선택할 수 있습니다.
        // scale : 소수점 아래의 자릿수까지 반환
        // runningmode : 반올림 방법 지정
        return num1.divide(num2, 0);
    }

    @Test
    void testDivisionWithDifferentRoundingModes() {
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(3);

        // HALF_UP 모드로 나누기
        BigDecimal resultHalfUp = divideNumbers(num1, num2, RoundingMode.HALF_UP);
        assertEquals(BigDecimal.valueOf(3.33), resultHalfUp, "HALF_UP 모드의 나눗셈이 올바르지 않습니다.");

        // DOWN 모드로 나누기
        BigDecimal resultDown = divideNumbers(num1, num2, RoundingMode.DOWN);
        assertEquals(BigDecimal.valueOf(3.33), resultDown, "DOWN 모드의 나눗셈이 올바르지 않습니다.");

        // CEILING 모드로 나누기
        BigDecimal resultCeiling = divideNumbers(num1, num2, RoundingMode.CEILING);
        assertEquals(BigDecimal.valueOf(3.34), resultCeiling, "CEILING 모드의 나눗셈이 올바르지 않습니다.");

        // FLOOR 모드로 나누기
        BigDecimal resultFloor = divideNumbers(num1, num2, RoundingMode.FLOOR);
        assertEquals(BigDecimal.valueOf(3.33), resultFloor, "FLOOR 모드의 나눗셈이 올바르지 않습니다.");
    }

    private BigDecimal divideNumbers(BigDecimal num1, BigDecimal num2, RoundingMode roundingMode) {
        // 나눗셈의 경우 정확한 결과를 얻기 위해 나누는 숫자의 스케일을 지정해주는 것이 좋습니다.
        return num1.divide(num2, 2, roundingMode);
    }
}