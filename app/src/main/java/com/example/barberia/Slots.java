package com.example.barberia;

public class Slots {
    private String slot_id;
    private String start_time;
    private String end_time;
    private String booking_id;

    public Slots(String slot_id, String start_time, String end_time, String booking_id) {
        this.slot_id = slot_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.booking_id = booking_id;
    }

    public String getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(String slot_id) {
        this.slot_id = slot_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }
}
