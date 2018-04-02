package com.training.gytis.foodep;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Gytis on 2018-01-18.
 */

public class Note implements Serializable{
    String name;
    String note;
    String date;

    public Note(String name, String note){
        this.name = name;
        this.note = note;
        this.date = createDateString();
    }

    public Note(String name, String note, String date){
        this.name = name;
        this.note = note;
        this.date = date;
    }

    private String createDateString() {
        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        return year + "/" + String.format("%02d", month) + "/" + String.format("%02d", day) + " " + String.format("%02d", hour) + ":" + String.format("%02d", minute);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
