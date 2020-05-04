package com.bridgelabz.greetingappapi.dto;

public class GreetingDto {
    private long incrementAndGet;
    private String format;

    public GreetingDto(long incrementAndGet, String format) {
        this.incrementAndGet = incrementAndGet;
        this.format = format;
    }

    public long getIncrementAndGet() {
        return incrementAndGet;
    }

    public String getFormat() {
        return format;
    }
}
