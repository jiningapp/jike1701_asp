package com.example.newXiaoMi.model;

/*LitePal是一款开源的Android数据库框架，采用对象关系映射（ORM）模式，将常用的数据库功能进行封装，
可以不用写一行SQL语句就可以完成创建表、增删改查的操作。我们的编程语言使用的是面向对象语言，
数据库用的是关系型数据库，将面向对象语言和关系型数据库建立的一种映射关系成为对象关系映射。
*/

import android.util.Log;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

public class Dbservice {
    private static final Dbservice ourInstance = new Dbservice();

    public static Dbservice getInstance() {
        return ourInstance;
    }

    private Dbservice() {
        //若初始无信息，则自动初始化创建内容
        if(DataSupport.count(UserInfo.class)==0){
            Log.i("计科1701_asp","创建数据库");//控制台打印信息
            LitePal.getDatabase();//创建数据库

            NoteBook noteBook = new NoteBook();//初始创建便签薄
            noteBook.setBookname("便签");
            noteBook.save();//保存便签薄

            //自动新建三条提示便签
            Note note1 = new Note();
            note1.setBookname("便签");
            note1.setContent("点击主页侧拉菜单，可创建更多便签薄与计划本");
            note1.save();
            //提示便签2
            Note note2 = new Note();
            note2.setBookname("便签");
            note2.setContent("长按以删除单条note");
            note2.save();
            //提示便签3
            Note note3 = new Note();
            note3.setBookname("便签");
            note3.setContent("长按个人信息以修改其内容");
            note3.save();
            //初始创建待办事项本
            TodoBook todoBook = new TodoBook();//初始创建待办事项本
            todoBook.setBookname("日常");
            todoBook.save();//保存到数据库中
            //初始创建用户页面信息
            UserInfo userInfo = new UserInfo();
            userInfo.setSaying("干啥啥不行，干饭第一名！");
            userInfo.setName("计科1701_asp");
            userInfo.setProfile("0");//设置初始头像
            userInfo.save();//保存信息
        }
        else {//否则获取数据库内容
            LitePal.getDatabase();
        }
    }}
