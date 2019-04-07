package com.example.barberia;

public class slot {

    private String id;
    private String startTime;

    public slot(String id, String startTime, String endTime) {
        this.id = id;
        this.startTime = startTime;

    }

    public String getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }


}
