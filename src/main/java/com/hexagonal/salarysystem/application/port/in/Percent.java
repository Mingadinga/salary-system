package com.hexagonal.salarysystem.application.port.in;

import java.math.BigDecimal;

public class Percent {
    private BigDecimal value;

    public Percent(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("퍼센트 값은 0 이상 100 이하이어야 합니다.");
        }
        this.value = BigDecimal.valueOf(percent);
    }

    public double toRatio() {
        return value.divide(BigDecimal.valueOf(100)).doubleValue();
    }

}
