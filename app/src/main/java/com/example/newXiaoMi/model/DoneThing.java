package com.example.newXiaoMi.model;

import org.litepal.crud.DataSupport;

import java.util.Date;
//完成的计划的实体类，并定义了相关方法
public class DoneThing extends DataSupport {
    private int id;
    private String bookName;
    private String content;
    private String timeStart;
    private double timeSpent;
    private  String day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettBookName() {
        return bookName;
    }

    public void settBookName(String tBookName) {
        this.bookName = tBookName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
