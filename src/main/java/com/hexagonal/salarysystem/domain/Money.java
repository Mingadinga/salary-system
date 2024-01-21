package com.hexagonal.salarysystem.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 돈을 표현하는 자료구조 클래스
 */
public final class Money {

    private BigDecimal value;

    public Money(final long value) {
        this.value = BigDecimal.valueOf(value);
    }

    public Money(final double value) {
        this.value = BigDecimal.valueOf(value);
    }

    private Money(final BigDecimal value) {
        this.value = value;
    }

    public Money minus(Money money) {
        return new Money(this.value.subtract(money.value));
    }

    public Money multiply(double rate) {
        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException(String.format("rate는 0~1 사이의 실수여야 합니다. 현재 rate : %f", rate));
        }
        return new Money(this.value.multiply(BigDecimal.valueOf(rate)));
    }

    public Money multiply(int number) {
        return new Money(this.value.multiply(BigDecimal.valueOf(number)));
    }

    public Money add(Money money2) {
        return new Money(this.value.add(money2.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return value.stripTrailingZeros().equals(money.value.stripTrailingZeros());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public BigDecimal getValue() {
        return value;
    }


}
