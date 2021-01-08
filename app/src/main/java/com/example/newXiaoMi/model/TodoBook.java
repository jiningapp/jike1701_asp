package com.example.newXiaoMi.model;

import org.litepal.crud.DataSupport;
//计划本的实体及其对应实现方法
public class TodoBook extends DataSupport {
    private int id;
    private String bookname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
