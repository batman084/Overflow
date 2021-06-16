package com.overflow.todo.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TodoItem {
    private final int id;
    private final int userId;
    private final String title;
    private final String description;
    private final Date dateTime;

    private static final SimpleDateFormat DateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm");

    public TodoItem(
            int id,
            int userId,
            String title,
            String description,
            String dateTimeStr) {

        this(id, userId, title, description, createDateFromString(dateTimeStr));
    }

    public TodoItem(
            int id,
            int userId,
            String title,
            String description,
            Date dateTime) {

        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }

    public static Date createDate(int year, int month, int date, int hours, int minutes) {
        Calendar calendarInstance = Calendar.getInstance();
        calendarInstance.set(year, month - 1, date, hours, minutes, 0);
        return calendarInstance.getTime();
    }

    public int getId() {
        return this.id;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDateTime() {
        return this.dateTime;
    }

    public String getDateTimeString() {
        return DateTimeFormat.format(this.dateTime);
    }

    public String getDate() {
        return DateFormat.format(this.dateTime);
    }

    public String getTime() {
        return TimeFormat.format(this.dateTime);
    }

    @Override
    public String toString() {
        return
                "id         : " + this.id + "\n" +
                        "user id    : " + this.userId + "\n" +
                        "title      : " + this.title + "\n" +
                        "description: " + this.description + "\n" +
                        "date       : " + getDateTimeString() + "\n";
    }

    private static Date createDateFromString(String dateTimeStr) {
        Date dateTime = null;
        try {
            dateTime = DateTimeFormat.parse(dateTimeStr);
        } catch (Exception e) {
            System.err.println(e);
        }

        return dateTime;
    }
}