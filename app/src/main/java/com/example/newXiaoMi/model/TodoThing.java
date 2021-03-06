package com.example.newXiaoMi.model;

import org.litepal.crud.DataSupport;

import java.util.Date;
//计划事项的实体及其实现方法
public class TodoThing extends DataSupport {
    private int id;
    private String bookName;//所归属的计划本名字
    private String content;//计划事项内容
    private Date timeStart;
    private double timeSpent;
    private  Date day;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
