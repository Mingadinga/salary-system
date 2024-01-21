package com.hexagonal.salarysystem.domain;

public class WorkDuration {
    private int hours;
    private int minutes;

    public WorkDuration(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("올바르지 않은 시간 또는 분입니다.");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public WorkDuration(int hours) {
        this(hours, 0);
    }

    public int toHour() {
        return this.hours;
    }
}
